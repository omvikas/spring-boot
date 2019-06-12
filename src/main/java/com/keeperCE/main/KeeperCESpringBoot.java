package com.keeperCE.main;


import com.keeperCE.model.Role;
import com.keeperCE.model.User;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.keeperCE.*")
@EnableJpaRepositories(basePackages = "com.keeperCE.repo.*")
@EntityScan(  basePackageClasses={User.class, Role.class})
public class KeeperCESpringBoot {

	public static void main(String[] args) {
		SpringApplication.run(KeeperCESpringBoot.class,args);
	}


}
