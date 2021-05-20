package com.shopmilk.config;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.shopmilk.service.UserService;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
 
    @Autowired
    private UserService userService;
 
    @Bean
    public PasswordEncoder passwordEncoder() {
//		return new NormalPasswordEncoder();
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(8);
		return encoder;
    }
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // Sét đặt dịch vụ để tìm kiếm User trong Database.
        // Và sét đặt PasswordEncoder.
        auth.userDetailsService(userService).passwordEncoder(passwordEncoder());
 
    }
 
    @Override
    protected void configure(HttpSecurity http) throws Exception {
 
    	http.csrf().disable().authorizeRequests() // thực hiện xác thực request ngưười dùng gửi lên.
		
		// không thực hiện xác thực đối với các ur/ này.
        .antMatchers("/css/**", "/js/**", "/img/**", "/vendor/**"
        		, "/fonts/**", "/summernote-0.8.18-dist/**").permitAll()
        
        // thực hiện xác thực với các url kiểu ..../admin/....
//        .antMatchers("/admin/**").hasAnyAuthority("ADMIN")
        .antMatchers("/admin/**").authenticated()
        
        .and() // kết hợp với điều kiện.
        
        // khi click vào button logout thì không cần login.
        // khi click vào button này thì dữ liệu user trên session sẽ bị xoá.
        .logout()
        .logoutUrl("/perform_logout")
        .logoutSuccessUrl("/index.html")
        .invalidateHttpSession(true) // xoá hết dữ liệu trên seesion
        .deleteCookies("JSESSIONID") // xoá hết dữ liệu trên cokies.
        .permitAll()
        
        .and() // kết hợp với điều kiện.
        
        .formLogin() // thực hiện xác thực qua form(username và password)
        .loginPage("/login") // trang login do mình thiết kế.
        .loginProcessingUrl("/perform_login") // link action for form post.
        .defaultSuccessUrl("/admin", true) // when user success authenticated then go to this url.
        .failureUrl("/login?login_error=true") // nhập username, password sai thì redirect về trang nào.
        .permitAll();
 
    }
 
    
    //đổi pass thật sang hash code tại đây
    public static void main(String[] args) {
		System.out.println("encript password: ");
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder(8);
		System.out.println(encoder.encode("123456"));//123456 là pass thật
	}
 
}