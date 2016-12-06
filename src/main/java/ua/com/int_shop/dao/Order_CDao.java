package ua.com.int_shop.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.int_shop.entity.Order_C;

public interface Order_CDao extends JpaRepository<Order_C, Integer>{
	
//	@Query("select distinct o from order_c o left join fetch  where o.id =:id")
//	Order_C fetchOrderWithCommodity(@Param("id") int id);

    @Query("SELECT CASE WHEN COUNT(o) > 0 THEN true ELSE false END FROM Order_C o WHERE o.name =:name")
    boolean order_CExistsByName(@Param("name") String name);

    @Query("SELECT CASE WHEN COUNT(o) > 0 THEN true ELSE false END FROM Order_C o WHERE o.price =:price")
    boolean order_CExistsByPrice(@Param("price") String price);

    @Query("SELECT CASE WHEN COUNT(o) > 0 THEN true ELSE false END FROM Order_C o WHERE o.paymentMethod =:paymentMethod")
    boolean order_CExistsByPaymentMethod(@Param("paymentMethod") String paymentMethod);
	
}
