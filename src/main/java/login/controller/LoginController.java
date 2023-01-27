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
import org.springframework.web.bind.annotation.RequestParam;

import login.models.LoginUser;


@Controller
public class LoginController {
	@GetMapping("/login")
	public String login(@RequestParam(value = "error", required = false) String error,
    		Model model, HttpSession session) {
    	if (error != null) {
    		AuthenticationException ex = (AuthenticationException) session.getAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
    		if (ex != null) {
    			System.out.println(ex);
    			model.addAttribute("showErrorMsg", true);
    			model.addAttribute("errorMsg", ex.getMessage());
    		}
    	}
		return "login";
	}
	@GetMapping("/home")
	public String home(@AuthenticationPrincipal LoginUser user) {
		System.out.println(user);
		return "home";
	}
}
