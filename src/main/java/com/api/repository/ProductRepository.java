package com.api.repository;

import com.api.entity.Product;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

    List<Product> findByDesp(String ProductDesp);

    @Query("SELECT p.ProductName FROM Product p WHERE p.ProductDesp = :ProductDesp")
    List<String> findNameByProductDesp(@Param("ProductDesp") String ProductDesp);

    @Query("UPDATE Product p SET p.ProductDesp = ?1 WHERE p.ProductId = ?2")
    @Modifying
    @Transactional
    Integer updateProductDesp(String updateProductDesp, Integer ProductId);

}
