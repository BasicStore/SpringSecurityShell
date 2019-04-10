package com.security.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.security.repository.UsersRepository;


// BEFORE
//@Configuration
//@EnableWebSecurity


@EnableGlobalMethodSecurity(prePostEnabled=true) // allows us to @PreAuthorize checks (authorization)
@EnableWebSecurity
@EnableJpaRepositories(basePackageClasses=UsersRepository.class)
@Configuration
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
	// TODO new db roles version
	@Autowired
	private UserDetailsService userDetailsService;
	
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        http
        .authorizeRequests()
	        .antMatchers("/", "**/login/**").permitAll()  // home
	        .anyRequest().authenticated()
	        
	     .and()
	        .authorizeRequests()
			.antMatchers("**/admin/**").authenticated()  
			.anyRequest().permitAll()	        

	     .and()
	        .authorizeRequests()
			.antMatchers("**/member/**").authenticated()  
			.anyRequest().permitAll()	        
	
			
	        
        .and()
            .formLogin()
            .loginPage("/login")  // directs to a login form page
            .permitAll()          // once past the login, all actions are fine
        .and()
            .logout()                 // implcitily the same with logging out, although there is no logout action 
            .permitAll();
        
        
        
        
//        http
//		.authorizeRequests()
//			.antMatchers("**/admin/**").authenticated()   // authenticate if /admin/ is within the path
//			.anyRequest().permitAll()
//		.and()
//	        .formLogin()
//            .loginPage("/login")  // directs to a login form page
//            .permitAll()          // once past the login, all actions are fine
//        .and()
//        	.logout()                 // implcitly the same with logging out, although there is no logout action 
//            .permitAll();
        
        
    }

    
	
//	@Bean
//    @Override
//    public UserDetailsService userDetailsService() {
//        UserDetails user =
//             User.withDefaultPasswordEncoder()
//                .username("user")
//                .password("password")
//                .roles("USER")
//                .build();
//
//        return new InMemoryUserDetailsManager(user);
//    }
    
    
    
    
    
    @Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		// look at auth.inMemoryAuthentication()
		
		auth.userDetailsService(userDetailsService).passwordEncoder(getPasswordEncoder());
	}


	private PasswordEncoder getPasswordEncoder() {
		return new PasswordEncoder() {
			
			@Override
			public String encode(CharSequence charSequence) {
				return charSequence.toString();
			}
			
			@Override
			public boolean matches(CharSequence charSequence, String s) {
				return true;
			}
		};
	}
    
    
    
}