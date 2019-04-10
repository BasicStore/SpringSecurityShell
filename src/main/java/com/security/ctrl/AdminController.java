package com.security.ctrl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;



@Controller
public class AdminController {

	private Logger logger = LoggerFactory.getLogger(AdminController.class);
		
	
	
//	@PreAuthorize("hasAnyRole('ADMIN')")
//	@GetMapping("/admin/other")
//	public String admin2Hello() {
//		return "admin";   // returns view + use spring mvc for view resolver
//	}
//	
	
	

}
