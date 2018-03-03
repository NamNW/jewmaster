package com.jewery.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled=true)
public class JewSecurityConfig extends WebSecurityConfigurerAdapter{

	@Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/js/**","/lib/**", "/images/**");	
    }
	
	@Override
    protected void configure(HttpSecurity http) throws Exception {
		CharacterEncodingFilter filter = new CharacterEncodingFilter();
		filter.setEncoding("UTF-8");
		filter.setForceEncoding(true);
		
		//disable just for test
		http.csrf().disable()
		.headers().frameOptions().sameOrigin().and()
		.authorizeRequests()
			.antMatchers(
					"/login", 
					"/registration/**"
					).permitAll()
			.anyRequest().fullyAuthenticated()
			.and()
			.formLogin()
			.loginPage("/login")
			.loginProcessingUrl("/login/submit")
			.defaultSuccessUrl("/login/success", true)
			.usernameParameter("username")
			.passwordParameter("password")
			.and()
	    	.sessionManagement()
	    	.maximumSessions(20)
	    	.expiredUrl("/login?expired=true");
		
		http.requiresChannel().anyRequest().requiresInsecure();
		http.sessionManagement().sessionFixation().none();
    }
}
