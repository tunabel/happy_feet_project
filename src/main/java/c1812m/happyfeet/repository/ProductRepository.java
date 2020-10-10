package c1812m.happyfeet.repository;

import c1812m.happyfeet.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


public interface ProductRepository extends JpaRepository<Product,Integer> {

    @Query("select count(p.id) from Product p")
    long getTotalProducts();

//    @Query("SELECT p FROM Product p " +
//            "JOIN ProductSku s " +
//            "WHERE s.id = :skuId")
//    Product findBySkuId(@Param("skuId") int skuId);

    @Query(value = "SELECT p.* FROM dbo_product p " +
            "WHERE p.product_id = (" +
                "SELECT s.product_id " +
                "FROM dbo_product_sku s " +
                "WHERE s.sku_id = :skuId" +
            ")", nativeQuery = true)
    Product findBySkuId(@Param("skuId") int skuId);

    @Query("SELECT p FROM Product p WHERE (:search IS NULL OR UPPER(p.name) LIKE CONCAT('%',UPPER(:search),'%'))")
    Page<Product> findAllWithSearch(Pageable pageable,  @Param("search") String search);

    @Query("SELECT p FROM Product p WHERE UPPER(p.name) = UPPER(:productName) AND p.brandId = :brandId")
    Product findOneByNameAndBrandId(@Param("productName") String productName, @Param("brandId") int brandId);
}
