package fr.bicomat.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
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
	
	@Autowired
	@Qualifier("customUserDetailsService")
	UserDetailsService userDetailsService;
	
	@Autowired
	CustomSuccessHandler customSuccessHandler;
    
	@Autowired
	public void configureGlobalSecurity(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
		//auth.userDetailsService(userDetailsService);
	}
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
		 http.authorizeRequests()
		 	.antMatchers("/images/**","/js/**", "/css/**").permitAll()
		  	.antMatchers("/", "/client/**").access("hasRole('CLIENT')")
		  	.antMatchers("/agent/**").access("hasRole('AGENT')")
		  	.antMatchers("/admin/**").access("hasRole('ADMIN')")
		  	.and().formLogin().loginPage("/login").successHandler(customSuccessHandler)
		  	.usernameParameter("ssoId").passwordParameter("password")
		  	.and().csrf()
		  	.and().exceptionHandling().accessDeniedPage("/AccessDenied");
		 
       /* http
            .authorizeRequests()
                .antMatchers("/", "/pages/", "/home","/images/**","/js/**", "/css/**").permitAll()
                .anyRequest().authenticated()
                .and()
            .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
            .logout()
                .permitAll();*/
    }

    /*@Bean
    @Override
    public UserDetailsService userDetailsService() {
        UserDetails user =
             User.withDefaultPasswordEncoder()
                .username("user")
                .password("123")
                .roles("USER")
                .build();

        return new InMemoryUserDetailsManager(user);
    }*/
}