package ua.com.int_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import ua.com.int_shop.entity.Commodity;

public interface CommodityDao extends JpaRepository<Commodity, Integer>{

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Commodity c WHERE c.name =:name")
    boolean commodityExistsByName(@Param("name") String name);

    @Query("SELECT CASE WHEN COUNT(c) > 0 THEN true ELSE false END FROM Commodity c WHERE c.price =:price")
    boolean commodityExistsByPrice(@Param("price") String price);

}
