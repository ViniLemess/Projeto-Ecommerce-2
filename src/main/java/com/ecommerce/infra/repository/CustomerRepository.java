package com.ecommerce.infra.repository;

import com.ecommerce.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("SELECT c FROM Customer c WHERE c.name LIKE %:name%")
    public List<Customer> searchAllCustomers(@Param("name") String name);

    @Query("SELECT c FROM Customer c WHERE c.name = :name")
    public Customer searchCustomerByName(@Param("name") String name);

    @Query("SELECT count(c) FROM Customer c WHERE c.name = :name and (c.id != :id or :id is null)")
    public Long countByNameAndDifferentId(@Param("name") String name, @Param("id") Long id);
}
