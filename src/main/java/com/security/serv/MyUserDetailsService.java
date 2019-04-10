package com.security.serv;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.security.dm.CustomUserDetails;
import com.security.dm.Users;
import com.security.repository.UsersRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class MyUserDetailsService implements UserDetailsService { // ie implements the spring UserDetailsService
	
	@Autowired
	private UsersRepository userRep;
	
	private Logger logger = LoggerFactory.getLogger(MyUserDetailsService.class);
	
	
	@Override
	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		
		System.out.println("============================================================================");		
		System.out.println("============================================================================");
		System.out.println("============================================================================");
		
		logger.info("============================================================================");
		logger.info("============================================================================");
		logger.info("============================================================================");
		
		Optional<Users> optionalUser = userRep.findByName(name);
		
		optionalUser.orElseThrow(()->new UsernameNotFoundException("Username not found"));
		
//		return optionalUser
//			.map(user-> {
//				return new CustomUserDetails(user);
//			}).get();
		
//		return optionalUser
//				.map(user-> new CustomUserDetails(user)).get();
		
		// note the lamdas above
		return optionalUser
				.map(CustomUserDetails::new).get();
	}

	
	
	

}
