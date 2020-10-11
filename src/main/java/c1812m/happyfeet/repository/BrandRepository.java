package c1812m.happyfeet.repository;

import c1812m.happyfeet.model.Brand;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BrandRepository extends JpaRepository<Brand,Integer> {

    @Query("select count(b.id) from Brand b")
    long getTotalCountBrands();

    @Query("SELECT b FROM Brand b")
    List<Brand> getBrandList();

    @Query("SELECT b FROM Brand b " +
            "WHERE (:brand IS NULL OR UPPER(b.name) LIKE CONCAT('%',UPPER(:brand),'%'))")
    Page<Brand> getBrandListByNameContaining(Pageable pageable, @Param("brand") String brandName);


    Brand findFirstByName(String name);
}
