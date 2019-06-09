package com.keeperCE.service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.keeperCE.model.Role;
import com.keeperCE.model.User;
import com.keeperCE.repo.RoleRepository;
import com.keeperCE.repo.UserRepository;

import lombok.Data;

@Data
@Service("userService")
public class UserService  implements UserDetailsService {

public enum Direction{
	Instance;
	public String getMessage(){
		return "Hello";
	}
}

	private UserRepository userRepository;
	private RoleRepository roleRepository;
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	public UserService(UserRepository userRepository, RoleRepository roleRepository,
			BCryptPasswordEncoder bCryptPasswordEncoder) {
		super();
		this.userRepository = userRepository;
		this.roleRepository = roleRepository;
		this.bCryptPasswordEncoder = bCryptPasswordEncoder;
	}

	  public User findUserByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }

	    public User saveUser(User user) {
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        user.setActive(1);
	        Role userRole = roleRepository.findByRole("ADMIN");
	        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
	        userRepository.save(user);
			Direction instance=Direction.Instance;
			instance.getMessage();
	        return user;
	    }

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		Optional<User> optionalUsers = userRepository.findByName(s);
		if(optionalUsers.isPresent()){
			return optionalUsers.get();
		}
	return null;
	}
}
