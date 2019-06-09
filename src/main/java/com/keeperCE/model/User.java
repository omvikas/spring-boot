package com.keeperCE.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Collection;
import java.util.Set;
import java.util.stream.Collectors;

@Data
@Entity
@Table(name="user")
public class User implements UserDetails {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="user_id")
	private Long id;
	
	@Column(name="email")
	@Email(message="*Please provide valid email")
	private String email;
	
	@Column(name="password")
	@Length(min=5,message="Password length should be atleast 5 digits")
	@NotEmpty(message="password is mandatory")
	private String password;
	
	@Column(name="fname")
	@NotEmpty(message="first name cannot be empty")
	private String name;
	
	@Column(name="last_name")
	@NotEmpty(message="last name cannot be empty")
	private String last_name;
	
	@Column(name="active")
	private int active;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return getRoles()
				.stream()
				.map(role -> new SimpleGrantedAuthority("ROLE_" + role.getRole()))
				.collect(Collectors.toList());
	}

	@Override
	public String getUsername() {
		return this.name;
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
}