package ua.com.int_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.int_shop.entity.Category;

public interface CategoryDao extends JpaRepository<Category, Integer>{

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Category c WHERE c.name =:name")
    boolean categoryExistsByName(@Param("name") String name);
	
}
