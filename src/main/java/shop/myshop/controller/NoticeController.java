package shop.myshop.controller;

import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import shop.myshop.dto.Role;
import shop.myshop.dto.UserDTO;
import shop.myshop.entity.Notice;
import shop.myshop.entity.User;
import shop.myshop.service.NoticeService;

@Controller
@RequestMapping("notice")
public class NoticeController {

	@Autowired
	private NoticeService noticeService;

	// 공지 작성폼으로 이동 - 관리자만 작성 가능
	@GetMapping("writeform")
	public String noticeForm(HttpSession session, Model model) throws Exception {
		UserDTO user = (UserDTO) session.getAttribute("user");

		model.addAttribute("user", user);

		return "board/notice-write";
	}

//	 @RequestMapping(value = "/",method = RequestMethod.GET)
	@RequestMapping(value = "/a")
	public ModelAndView insertEditor(HttpServletRequest req, ModelMap model) throws Exception {
		ModelAndView mav = new ModelAndView("board/notice-write");

		return mav;
	}

	// @RequestMapping(value = "/savepost" ,method = RequestMethod.GET)
	@RequestMapping(value = "/savepost1")
	public String savePost(HttpServletRequest req, Notice notice) throws Exception {

		Date today = new Date();
		notice.setNoticeRegdate(today);
		System.out.println(today);
		System.out.println("노티스 객체  " + notice);

		noticeService.saveNotice(notice);

		return "redirect:/notice/noticelist";

	}
	
	@RequestMapping(value = "savepost")
	public String savePost1(HttpServletRequest req, Notice notice) throws Exception {

		return "redirect:../notice/noticelist";

	}
	
	
	
	@RequestMapping(value = "/updatePost")
	public String updatePost(HttpSession session,HttpServletRequest req, Notice notice) throws Exception {

		Date today = new Date();
		notice.setNoticeRegdate(today);
		ModelMapper modelMapper = new ModelMapper();
		UserDTO user =  (UserDTO) session.getAttribute("user");
		User userEntity = modelMapper.map(user, User.class);
		notice.setUserId(userEntity);
		System.out.println("노티스 객체  " + notice);

		noticeService.saveNotice(notice);

		return "redirect:/notice/noticelist";

	}

	// notice list로 이동
	@GetMapping("noticelist")
	public String noticeList(Model model, HttpSession httpSession) throws Exception {

		model.addAttribute("notice", noticeService.getNotice());

		// 비회원 일경우
		if (httpSession.getAttribute("user") == null) {
			return "board/notice-list";

		}

		// 비회원 일 경우 여기 먼저 생성하면 에러남
		UserDTO user = (UserDTO) httpSession.getAttribute("user");
		model.addAttribute("user", user);

		// 관리자일 경우
		if (Role.ADMIN == user.getUserRole()) {
			return "board/admin-notice-list";
		}

		return "board/notice-list";
	}

	@GetMapping("detail/{noticeNo}")
	public String detail(@PathVariable int noticeNo, Model model,HttpSession httpSession) throws Exception {
		
		model.addAttribute("notice", noticeService.findByNoticeNo(noticeNo));
		System.out.println("??"+noticeService.findByNoticeNo(noticeNo));
		// 비회원 일경우
		if (httpSession.getAttribute("user") == null) {
			return "board/notice-detail";

		}

		UserDTO user = (UserDTO) httpSession.getAttribute("user");
		model.addAttribute("user", user);

		// 관리자일 경우
		if (Role.ADMIN == user.getUserRole()) {
			return "board/admin-notice-detail";
		}

		return "board/notice-detail";

	}
	//삭제
	@GetMapping("delete")
	public String noticeDelete(@RequestParam("noticeNo") int noticeNo) throws Exception {
		noticeService.deleteByNoticeNo(noticeNo);

		return "redirect:/notice/noticelist";

	}
	//수정 폼으로 이동
	@GetMapping("updateform")
	public String noticeUpdateForm(@RequestParam("noticeNo") int noticeNo,Model model) throws Exception {
		model.addAttribute("notice",  noticeService.findByNoticeNo(noticeNo));
		return "board/notice-update";
	}
	
	

	/*
	 * //스마트 에디터 이미지 업로드
	 * 
	 * @RequestMapping(value="/singleImageUploader.do") public String
	 * simpleImageUploader( HttpServletRequest req, SmartEditor smartEditor) throws
	 * UnsupportedEncodingException{ String callback = smartEditor.getCallback();
	 * String callback_func = smartEditor.getCallback_func(); String file_result =
	 * ""; String result = ""; MultipartFile multiFile = smartEditor.getFiledata();
	 * try{ if(multiFile != null && multiFile.getSize() > 0 &&
	 * StringUtils.isNotBlank(multiFile.getName())){
	 * if(multiFile.getContentType().toLowerCase().startsWith("image/")){ String
	 * oriName = multiFile.getName(); String uploadPath =
	 * req.getServletContext().getRealPath("/img"); String path = uploadPath +
	 * "/smarteditor/"; File file = new File(path); if(!file.exists()){
	 * file.mkdirs(); } String fileName = UUID.randomUUID().toString();
	 * smartEditor.getFiledata().transferTo(new File(path + fileName)); file_result
	 * += "&bNewLine=true&sFileName=" + oriName + "&sFileURL=/img/smarteditor/" +
	 * fileName; }else{ file_result += "&errstr=error"; } }else{ file_result +=
	 * "&errstr=error"; } } catch (Exception e){ e.printStackTrace(); } result =
	 * "redirect:" + callback + "?callback_func=" +
	 * URLEncoder.encode(callback_func,"UTF-8") + file_result; return result; }
	 */
}
