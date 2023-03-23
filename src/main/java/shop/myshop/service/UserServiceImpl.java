package shop.myshop.service;

import java.util.List;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import shop.myshop.dto.UserDTO;
import shop.myshop.entity.User;
import shop.myshop.repository.UserRepository;



@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserRepository userDao;
	
	@Autowired
	private ModelMapper modelMapper;

	@Override
	public User join(User user) {
		return userDao.save(user);
	}
	
	

	@Override
    public Boolean isUser(String id, String pwd) throws Exception {
        List<User> list = userDao.findByUserIdAndUserPwd(id, pwd);
        return list.stream().anyMatch((user) -> user.getUserId().equals(id) && user.getUserPwd().equals(pwd));
    }

    @Override
    public UserDTO findByUserId(String id) throws Exception {
        User user = userDao.findByUserId(id);
        if (user == null) {
            throw new NotFoundException();
        }
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public List<UserDTO> findAll() throws Exception{
        List<User> userList = userDao.findAll();
        return userList.stream()
                .map(user -> modelMapper.map(user, UserDTO.class))
                .collect(Collectors.toList());
    }


    

	@Override
	public String getUserId(String userName, String userEmail) throws Exception {
		return  userDao.findByUserNameAndUserEmail(userName,userEmail);
		
		
		
	}
    
    

}
	

	
	
	
