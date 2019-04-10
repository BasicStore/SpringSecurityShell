package com.security.ctrl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MemberController {

	private Logger logger = LoggerFactory.getLogger(MemberController.class);
	
	
	
	@PreAuthorize("hasAnyRole('MEMBER', 'ADMIN')")
	@PostMapping("/member")
	public String memberHello() {
		
		System.out.println("++++++++++++++++++++++++++++++++++&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&");
		
		
		return "member";   // returns view + use spring mvc for view resolver
	}
	
	
	
	
}
