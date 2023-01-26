package login.models;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.Data;

@Data
public class LoginUser implements UserDetails{
	private static final long serialVersionUID = 1L;
	private int id;
	private String username;
	private String password;
	private String nickname;
	private String authority;
	private Collection<GrantedAuthority> authorities;

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		if (authorities != null) {
			return authorities;
		}
		GrantedAuthority auth = new SimpleGrantedAuthority(authority);
		authorities = new ArrayList<>();
		authorities.add(auth);
		return authorities;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}

	public String getNickName() {
		return nickname;
	}

}
