package com.keeperCE.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Set;


@Entity
@Data
@Table(name="users")
public class Users  {
	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int user_id;
	@Column(name="is_active")
	private int is_active;
	@Column(name="devision_id")
	private int devision_id;
	@Column(name="preferred_language_id")
	private int preferred_language_id;
	@Column(name="login")
	private String login;
	@Column(name="password")
	private String password;
	@Column(name="title")
	private String title;
	@Column(name="first_name")
	private String first_name;
	@Column(name="middle_name")
	private String middle_name;
	@Column(name="last_name")
	private String last_name;
	@Column(name="suffix")
	private String suffix;
	@Column(name="email")
	private String email;
	@Column(name="sha1_password")
	private String sha1_password;
	@Column(name="salt")
	private String salt;
	@Column(name="address1")
	private String address1;
	@Column(name="address2")
	private String address2;
	@Column(name="address3")
	private String address3;
	@Column(name="city")
	private String city;
	@Column(name="state")
	private String state;
	@Column(name="country_id")
	private int country_id;
	@Column(name="postal_code")
	private String postal_code;
	@Column(name="phone")
	private String phone;
	@Column(name="cell")
	private String cell;
	@Column(name="fax")
	private String fax;
	@Column(name="company")
	private String company;
	@Column(name="last_login")
	private Date last_login;
	@Column(name="last_logout")
	private Date last_logout;
	@Column(name="created_by")
	private int created_by;
	@Column(name="date_created")
	private Timestamp date_created;
	@Column(name="modified_by")
	private int modified_by;
	@Column(name="date_modified")
	private Timestamp date_modified;
	@Column(name="subscriber_id")
	private Integer subscription_id;
	@Column(name="user_type")
	private String user_type;

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	private Set<Role> roles;
}
