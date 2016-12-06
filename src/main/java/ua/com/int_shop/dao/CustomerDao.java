package ua.com.int_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.int_shop.entity.Customer;

public interface CustomerDao extends JpaRepository<Customer, Integer>{

	Customer findByLogin(String login);

	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.login =:login")
	boolean customerExistsByLogin(@Param("login") String login);

	@Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Customer c WHERE c.email =:email")
	boolean customerExistsByEmail(@Param("email") String email);

}
