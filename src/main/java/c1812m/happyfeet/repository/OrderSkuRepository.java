package c1812m.happyfeet.repository;

import c1812m.happyfeet.model.OrderSku;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderSkuRepository extends JpaRepository<OrderSku,Integer> {
//
//    @Query(value = "SELECT SUM(os.price*os.quantity) FROM dbo_order_sku os " +
//            "WHERE os.order_id = ("+
//                "SELECT o.order_id " +
//                "FROM dbo_order o " +
//                "WHERE o.username = :username " +
//                "AND o.status = 0)",
//            nativeQuery = true)
//    Long sumPendingOrderValueByUsername(@Param("username") String username);
}
