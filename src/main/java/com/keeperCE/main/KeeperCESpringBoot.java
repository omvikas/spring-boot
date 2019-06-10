package com.keeperCE.main;

import com.keeperCE.model.Role;
import com.keeperCE.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@ComponentScan(basePackages = "com.keeperCE.*")
@EnableJpaRepositories(basePackages = "com.keeperCE.repo.*")
@EntityScan(  basePackageClasses={User.class, Role.class})
public class KeeperCESpringBoot {


	public static void main(String[] args) {
		SpringApplication.run(KeeperCESpringBoot.class,args);
	}


}
