package ua.com.int_shop.entity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Entity
public class Customer implements UserDetails{

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	

	private String name;
	private String surname;
	private String login;
	private String password;
	private String phoneNumber;
	private String email;
	private String city;
	private String address;
	
	private String pathImage;
	
	@OneToMany(fetch=FetchType.LAZY, mappedBy="customer")
	private List<Order_C> order_C;
	
	@Enumerated
	private Role role;
	
	public Customer() {
		// TODO Auto-generated constructor stub
	}

	public Customer(String name, String surname, String login, String password, String phoneNumber, String email,
			String city, String address) {
		super();
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.city = city;
		this.address = address;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public List<Order_C> getOrder_C() {
		return order_C;
	}

	public void setOrder_C(List<Order_C> order_C) {
		this.order_C = order_C;
	}
	
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	public String getPathImage() {
		return pathImage;
	}

	public void setPathImage(String pathImage) {
		this.pathImage = pathImage;
	}

	@Override
	public String toString() {
		return "Customer " + id + "{" 
				+ "\n login:" + login 
				+ "\n password:" + password 
				+ "\n name:" + name
				+ "\n surname" + surname
				+ "\n phoneNumber:" + phoneNumber 
				+ "\n email:" + email 
				+ "\n city:" + city 
				+ "\n address:" + address
				+ "}";
	}

	public Collection<? extends GrantedAuthority> getAuthorities() {
		List<SimpleGrantedAuthority> authorities = new ArrayList<SimpleGrantedAuthority>();
		authorities.add(new SimpleGrantedAuthority(role.name()));
		return authorities;
	}

	public String getUsername() {
		return String.valueOf(id);
	}

	public boolean isAccountNonExpired() {
		return true;
	}

	public boolean isAccountNonLocked() {
		return true;
	}

	public boolean isCredentialsNonExpired() {
		return true;
	}

	public boolean isEnabled() {
		return true;
	}
	
}
