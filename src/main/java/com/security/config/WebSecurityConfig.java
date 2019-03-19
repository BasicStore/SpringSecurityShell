package com.security.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;


@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    
	@Override
    protected void configure(HttpSecurity http) throws Exception {
        
		http.authorizeRequests()
                .antMatchers("/", "/home").permitAll()  // configured for / or home to require no configuration
                .anyRequest().authenticated()           // all other paths no mention in the antMatchers must be authenticated (test this)
                .and()
            .formLogin()
                .loginPage("/login")  // rerouted to login page (the login controller exists within the spring security framework)
                .permitAll()          // the login controller returns this page with either login?error or login?logout in URL if there is a problem
                .and()                // (see thyme conditional)
            .logout()
                .permitAll(); // routes directly to login page (logout)
    }

	
//	We display the username by using Spring Security’s integration with HttpServletRequest#getRemoteUser(). 
//	The "Sign Out" form submits a POST to "/logout". 
//	Upon successfully logging out it will redirect the user to "/login?logout".
	
	
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
             User.withDefaultPasswordEncoder()
                .username("user")
                .password("password")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }
    
}