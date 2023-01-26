package login.repository;

import org.apache.ibatis.annotations.Mapper;

import login.models.LoginUser;

@Mapper
public interface UserMapper {
	public LoginUser findUser(String username);
}