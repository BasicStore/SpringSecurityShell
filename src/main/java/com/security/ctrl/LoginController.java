package com.security.ctrl;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class LoginController {

	private Logger logger = LoggerFactory.getLogger(LoginController.class);
	
	
	@GetMapping("/login")
    public String greetingForm(HttpServletRequest request, Model model) {
		
		
		logger.info("TEST CONFIG PROP VALUE HERE ***********************************************");
		System.out.println("TEST CONFIG PROP VALUE HERE ***********************************************");
		
	    return "login";
	}

	
	
	
	//@GetMapping("/hello/all")
	@GetMapping("/home/all")
	public String hello() {
		
		System.out.println("&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		return "user";  // returns view + use spring mvc for view resolver
	}
	
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/admin/all")
	public String adminHello() {
		return "admin";   // returns view + use spring mvc for view resolver
	}
	
	
	
	
	/*
	@RequestMapping("/rest/hello")
@RestController
public class HelloResource {
	
	@GetMapping("/all")
	public String hello() {
		return "user";  // returns view + use spring mvc for view resolver
	}

	
	
	@PreAuthorize("hasAnyRole('ADMIN')")
	@GetMapping("/admin/all")
	public String adminHello() {
		return "admin";   // returns view + use spring mvc for view resolver
	}

	 */
	
	
	
	
}
