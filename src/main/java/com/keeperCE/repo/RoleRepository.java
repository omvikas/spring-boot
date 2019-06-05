package com.keeperCE.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.keeperCE.model.Role;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

	public Role findByRole(String role);
}
