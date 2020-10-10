package c1812m.happyfeet.repository;

import c1812m.happyfeet.model.Sku;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface SkuRepository extends JpaRepository<Sku, Integer> {

    @Query("SELECT s FROM Sku s")
    List<Sku> getSkuList();

    @Query("SELECT s FROM Sku s WHERE (:search IS NULL OR UPPER(s.name) LIKE CONCAT('%',UPPER(:search),'%'))")
    Page<Sku> getSkuPageWithSearch(Pageable pageRequest, @Param("search") String search);

    @Query(value = "SELECT * FROM dbo_product_sku s " +
            "WHERE s.sku_id = :skuId AND s.sku_id NOT IN " +
            "(" +
            "SELECT cs.sku_id FROM dbo_cart_sku cs " +
            "GROUP BY cs.sku_id " +
            "UNION " +
            "SELECT os.sku_id FROM dbo_order_sku os " +
            "GROUP BY os.sku_id" +
            ")", nativeQuery = true)
    Sku findByIdNotInOrderOrCart(@Param("skuId") int skuId);

    @Query(value = "SELECT * FROM dbo_product_sku s " +
            "WHERE s.sku_id IN " +
            "( " +
            "SELECT os.sku_id FROM dbo_order_sku os " +
            "WHERE os.order_id = :orderId" +
            ")", nativeQuery = true)
    List<Sku> findAllByOrderId(@Param("orderId") int orderId);

    @Query(value = "SELECT p.*, SUM(op.quantity)AS SALES FROM dbo_product_sku p " +
            "JOIN dbo_order_sku op " +
            "ON op.sku_id = p.sku_id " +
            "GROUP BY p.sku_id " +
            "ORDER BY SALES DESC " +
            "LIMIT :limit", nativeQuery = true)
    List<Sku> getBestSellers(@Param("limit") int limit);

}
