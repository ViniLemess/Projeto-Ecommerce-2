package com.ecommerce.infra.repository;

import com.ecommerce.model.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Long> {

    @Query("SELECT s FROM Supplier s WHERE s.tradingName LIKE %:tradingName%")
    public List<Supplier> searchAllSuppliers(@Param("tradingName") String tradingName);

    @Query("SELECT s FROM Supplier s WHERE s.tradingName = :tradingName")
    public Supplier searchSupplierByName(@Param("tradingName") String tradingName);

    @Query("SELECT count(s) FROM Supplier s WHERE s.tradingName = :tradingName and (s.id != :id or :id is null)")
    public Long countByNameAndDifferentId(@Param("tradingName") String tradingName, @Param("id") Long id);
}
