package com.keeperCE.repo;

import com.keeperCE.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository("userRepository")
public interface UserRepository extends JpaRepository<Users, Long> {

	Optional<Users> findByEmail(String email);


}
