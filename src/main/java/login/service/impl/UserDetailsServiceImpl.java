package login.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import login.models.LoginUser;
import login.service.UserService;


@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	@Autowired
	private UserService service;
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException{
		LoginUser loginUser = service.getLoginUser(username);
		if(loginUser == null) {
			throw new UsernameNotFoundException("User" + username + "was not found in the database");
		}
		return loginUser;
	}
}
