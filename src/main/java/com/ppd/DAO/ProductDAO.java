package com.ppd.DAO;

import com.ppd.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDAO extends JpaRepository<Product,Integer> {

    @Query(value = "select p from Product p where p.productId in :idList")
    List<Product> getByIdCollection(@Param("idList") List<Integer> idList);

    @Query(value = "select count(p) from Product p where p.productId in :idList")
    long getCountByIdCollection(@Param("idList") List<Integer> idList);

    @Query(value = "select p from Product p where lower(p.productName) like lower(:name)")
    List<Product> getByName(@Param("name") String name);

    List<Product> findByProductNameContainingIgnoreCase(String name);
}
