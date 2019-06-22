package com.keeperCE.service;

import com.keeperCE.model.CustomUser;
import com.keeperCE.model.Role;
import com.keeperCE.model.Users;
import com.keeperCE.repo.RoleRepository;
import com.keeperCE.repo.UserRepository;
import lombok.Data;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;

@Data
@Service("userService")
public class UserService  implements UserDetailsService {

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

	  public Optional<Users> findUserByEmail(String email) {
	        return userRepository.findByEmail(email);
	    }

	    public Users saveUser(Users user) {
	        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
	        user.setIs_active(1);
	        Role userRole = roleRepository.findByRole("ADMIN");
	        user.setRoles(new HashSet<Role>(Arrays.asList(userRole)));
	        userRepository.save(user);
	        return user;
	    }

	@Override
	public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
		Optional<Users> user=userRepository.findByEmail(s);
		return  user.map(CustomUser::new).orElseThrow(()->new UsernameNotFoundException(s+ "Not found") );
	}
}
