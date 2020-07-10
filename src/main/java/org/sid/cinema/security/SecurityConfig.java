/* package org.sid.cinema.security;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter  {
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.inMemoryAuthentication().withUser("wijdane").password("{noop}1234").roles("ADMIN","USER");
		auth.inMemoryAuthentication().withUser("user1").password("{noop}1234").roles("USER");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// TODO Auto-generated method stub
		super.configure(http);
		http.csrf().disable();
	}
}
	
	
	
	Pour le cas ou les utilisateurs sont connues et fixes d’une manière statique */
	//auth.inMemoryAuthentication().withUser("admin").password("1234").roles("ADMIN","USER");
	//auth.inMemoryAuthentication().withUser("user").password("1234").roles("USER");
