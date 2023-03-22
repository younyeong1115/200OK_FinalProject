package shop.myshop.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.message.BasicNameValuePair;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import shop.myshop.dto.UserDTO;
import shop.myshop.entity.User;
import shop.myshop.repository.UserRepository;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


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
    
    

}
	

	
	
	
