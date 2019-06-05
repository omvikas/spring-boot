package com.keeperCE.model;

import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import org.hibernate.validator.constraints.Length;
import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@Entity
@Table(name="user")
public class User{
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
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;





}