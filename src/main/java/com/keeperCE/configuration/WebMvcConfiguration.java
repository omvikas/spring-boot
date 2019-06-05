package com.keeperCE.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.keeperCE.repo.RoleRepository;
import com.keeperCE.repo.UserRepository;

@Configuration
@EnableJpaRepositories(basePackageClasses= {RoleRepository.class,UserRepository.class})
public class WebMvcConfiguration implements WebMvcConfigurer  {

	  @Bean
	    public BCryptPasswordEncoder passwordEncoder() {
	        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
	        return bCryptPasswordEncoder;
	    }
	
}
