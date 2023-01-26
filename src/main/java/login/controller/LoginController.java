package login.controller;

import javax.servlet.http.HttpSession;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.web.WebAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import login.models.LoginUser;


@Controller
public class LoginController {
	@GetMapping("/login")
	public void login(Model model, HttpSession session) {
		String pass = PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("password");
		System.out.println(pass);
		AuthenticationException ex = (AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}
	@GetMapping("/home")
	public String home(@AuthenticationPrincipal LoginUser user) {
		System.out.println(user);
		return "home";
	}
}
