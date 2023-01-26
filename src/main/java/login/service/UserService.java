package login.service;

import login.models.LoginUser;

public interface UserService {
	public LoginUser getLoginUser(String username);
}
