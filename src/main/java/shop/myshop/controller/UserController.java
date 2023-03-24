package shop.myshop.controller;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.JsonNode;

import shop.myshop.annotation.MySecured;
import shop.myshop.dto.Role;
import shop.myshop.dto.UserDTO;
import shop.myshop.entity.User;
import shop.myshop.service.CartService;
import shop.myshop.service.KakaoUserInfo;
import shop.myshop.service.LikesService;
import shop.myshop.service.ProductQuestionService;
import shop.myshop.service.QuestionService;
import shop.myshop.service.RegisterMail;
import shop.myshop.service.ReviewService;
import shop.myshop.service.UserService;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService userService;

	@Autowired
	private CartService cartService;
	
	@Autowired
	private LikesService likesService;
	
	@Autowired
	private ReviewService reviewService;
	
	@Autowired
	private QuestionService questionService;
	
	@Autowired
	private ProductQuestionService productQuestionService;

	@Autowired
	RegisterMail registerMail;

	

	@GetMapping("login")
	public String login(Model model, HttpSession httpSession) throws Exception {
		if (httpSession.getAttribute("user") != null) {
			User user = (User) httpSession.getAttribute("user");
			model.addAttribute("user", user);
			return "redirect:user/my-info";
		}
		return "user/login-form";
	}

	//
	@PostMapping("login")
	public String login(@RequestParam("id") String id, @RequestParam("password") String password,
			HttpSession httpSession) throws Exception {
		System.out.println(id);
		if (!userService.isUser(id, password)) {
			return "redirect:loginfail";
		}

		httpSession.setAttribute("user", userService.findByUserId(id));
		return "redirect:/main.html";
	}



	@PostMapping("user/userEmailConfirm")
	@ResponseBody
	String userEmailConfirm(@RequestParam("userEmail") String email) throws Exception {

		String code = registerMail.sendSimpleMessage(email);
		System.out.println("인증코드 : " + code);
		return code;
	}

	@GetMapping("idFindForm")
	public String findIdForm() {

		return "user/findId.html";
	}

	@PostMapping(value = "findId")
	@ResponseBody
	public String findId(@RequestParam("userName") String userName, @RequestParam("userEmail") String userEmail)
			throws Exception {
		return userService.getUserId(userName, userEmail);

	}

	@GetMapping("joinForm")
	public String join() {

		return "user/signUp.html";
	}

	@PostMapping("join")
	@ResponseBody
	public String join(User user) {

		User newUser = null;
		try {
			newUser = userService.join(user);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return user.getUserName() + "님의 회원가입이 완료되었습니다.";
	}

	@GetMapping("logo")
	public String index(HttpSession httpSession) {
		if (httpSession.getAttribute("user") == null) {
			return "redirect:/index.html";
		}
		return "redirect:/main.html";
	}

	@GetMapping("loginfail")
	public String loginfail(Model model, HttpSession httpSession) throws Exception {
		return "user/login-fail";
	}

	// 같은 역할을 하는 컨트롤러가 2개가 됨 !!로그인 실패시 메시지만 보내는 형식으로 수정 필요
	@PostMapping("loginfail")
	public String loginfail(@RequestParam("id") String id, @RequestParam("password") String password,
			HttpSession httpSession) throws Exception {
		if (!userService.isUser(id, password)) {
			return "redirect:loginfail";
		}

		httpSession.setAttribute("user", userService.findByUserId(id));
		return "redirect:/main.html";
	}

	// USER이상의 회원만 로그아웃가능
	@MySecured(role = Role.USER)
	@GetMapping("logout")
	public String logout(HttpSession httpSession) throws Exception {
		httpSession.invalidate();
		return "redirect:/index.html";
	}

	@GetMapping("my-info")
	public String myInfo(Model model, HttpSession httpSession) throws Exception {
		if (httpSession.getAttribute("user") != null) {

			UserDTO user = (UserDTO) httpSession.getAttribute("user");
			
			model.addAttribute("cartCount", cartService.getCartCount(user.getUserId()));
			model.addAttribute("LikesCount", likesService.getLikesCount(user.getUserId()));
			model.addAttribute("BoardCount", reviewService.getReviewCount(user.getUserId()) + questionService.getQuestionCount(user.getUserId())  +  productQuestionService.getProductQuestionCount(user.getUserId()));//리뷰 + 상품 질문 + 질문
			model.addAttribute("user", user);
		} else {
			model.addAttribute("user", new UserDTO());
		}

		return "user/my-info";
	}

	@RequestMapping(value = "/kakao", produces = "application/json", method = { RequestMethod.GET, RequestMethod.POST })
	public ModelAndView kakaoLogin(@RequestParam("code") String code, RedirectAttributes ra, HttpSession session,
			HttpServletResponse response) throws Exception {
		ModelAndView mv = new ModelAndView();

		JsonNode access_token = userService.getKakaoAccessToken(code);

		JsonNode userInfo = KakaoUserInfo.getKakaoUserInfo(access_token.get("access_token"));

		// Get id
		String member_id = userInfo.get("id").asText();

		String member_name = null;

		String birthday = null;

		String email = null;

		// 유저정보 카카오에서 가져오기 Get properties
		JsonNode properties = userInfo.path("properties");
		JsonNode kakao_account = userInfo.path("kakao_account");
		System.out.println("kakao_account : " + kakao_account);

		System.out.println("아이디로 찾은 user객체 : " + userService.findByUserId(member_id.toString()));

		member_name = properties.path("nickname").asText(); // 이름 정보 가져오는 것
		email = kakao_account.path("email").asText();
		
		// System.out.println("id : " + member_id);

		// 디비에 카카오 아이디와 동일한 아이디가 없다면
		if (userService.findByUserId(member_id.toString()) == null) {
			// 세션에 member_id 저장
			session.setAttribute("user", userService.findByUserId(member_id.toString()));
			System.out.println("아이디로 찾은 user객체 : " + userService.findByUserId(member_id.toString()));

			mv.addObject("userId", member_id);
			mv.addObject("userName", member_name);
			mv.addObject("userEmail", email);
			mv.setViewName("user/kakaosignUp");
			return mv;
		} else {
			// 동일한 아이디 있으면 세션에 저장만
			session.setAttribute("user", userService.findByUserId(member_id.toString()));
		}

		mv.setViewName("redirect:/main.html");
		return mv;
	}

	@GetMapping("kakaoTerms")
	public String kakaoConnect() {

		StringBuffer url = new StringBuffer();
		url.append("https://kauth.kakao.com/oauth/authorize?");
		url.append("client_id=" + "클라이언트 아이디");
		url.append("&redirect_uri=http://localhost/ok/user/kakao");
		url.append("&response_type=code");

		return "redirect:" + url.toString();
	}
	
	@GetMapping("kakaologoutterm")
	public String kakaoLogoutTerm(HttpSession httpSession) {

		StringBuffer url = new StringBuffer();
		url.append("https://kauth.kakao.com/oauth/logout?");
		url.append("client_id=" + "클라이언트 아이디");
		url.append("&logout_redirect_uri=http://localhost/ok/user/kakaologout");

		return "redirect:" + url.toString();
	}

	// 카카오 탈퇴(연결 끊기)
	/*
	 * @GetMapping("kakaoquitterms") public String kakaoQuitTerms(HttpSession
	 * session) { StringBuffer url = new StringBuffer();
	 * url.append("https://kapi.kakao.com/v1/user/unlink?");
	 * url.append("Authorization=" + session.getAttribute("access_tocken"));
	 * url.append("&logout_redirect_uri=http://localhost/ok/user/kakaounlink");
	 * 
	 * //System.out.println("----"+session.getAttribute("access_tocken"));
	 * //url.append("Authorization=" + session.getAttribute("access_tocken"));
	 * 
	 * return "redirect:" + url.toString(); }
	 * 
	 * @GetMapping("kakaounlink") public String kakaoQuit(HttpSession session) {
	 * 
	 * return "redirect:/index.html"; }
	 */

	@GetMapping("kakaologout")
	public String kakaoLogout(HttpSession httpSession) {

		httpSession.invalidate();

		return "redirect:/index.html";
	}

}