package ua.com.int_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.int_shop.entity.Manufacturer;

public interface ManufacturerDao extends JpaRepository<Manufacturer, Integer>{

    @Query("SELECT CASE WHEN COUNT(m) > 0 THEN true ELSE false END FROM Manufacturer m WHERE m.name =:name")
    boolean manufacturerExistsByName(@Param("name") String name);

}
