package com.ecommerce.infra.repository;

import com.ecommerce.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    @Query("SELECT p FROM Product p WHERE p.name LIKE %:name%")
    public List<Product> searchAllProducts(@Param("name") String name);

    @Query("SELECT p FROM Product p WHERE p.name = :name")
    public Product searchProductByName(@Param("name") String name);

    @Query("SELECT count(p) FROM Product p WHERE p.name = :name and (p.id != :id or :id is null)")
    public Long countByNameAndDifferentId(@Param("name") String name, @Param("id") Long id);
}
