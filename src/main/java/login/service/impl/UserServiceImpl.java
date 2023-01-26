package login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import login.models.LoginUser;
import login.repository.UserMapper;
import login.service.UserService;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	private UserMapper mapper;
	@Override
	public LoginUser getLoginUser(String username) {
		return mapper.findUser(username);
	}
}
