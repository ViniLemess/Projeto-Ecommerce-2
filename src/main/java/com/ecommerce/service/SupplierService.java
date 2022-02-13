package com.ecommerce.service;

import com.ecommerce.infra.repository.CustomerRepository;
import com.ecommerce.infra.repository.SupplierRepository;
import com.ecommerce.model.Customer;
import com.ecommerce.model.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SupplierService {

    private SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {this.supplierRepository = supplierRepository;}

    public void registerSupplier(Supplier supplier) {

        validateDuplicatedRegister(supplier.getTradingName(), supplier.getId());
        this.supplierRepository.save(supplier);
    }
    public Supplier searchByTradingName(String tradingName) {

        if(tradingName == null || tradingName.isBlank()) {

            throw new IllegalArgumentException("Nome Fantasia inválido!");
        }
        return supplierRepository.searchSupplierByName(tradingName);
    }
    public List<Supplier> listByTradingName(String tradingName) {

        if(tradingName == null || tradingName.isBlank()) {

            throw new IllegalArgumentException("Nome Fantasia inválido!");
        }
        return supplierRepository.searchAllSuppliers(tradingName);
    }
    public Supplier searchSupplierById(Long id) {

        return supplierRepository.findById(id).get();
    }
    private void validateDuplicatedRegister(String tradingName, Long id) {

        var quantity = supplierRepository.countByNameAndDifferentId(tradingName, id);
        if (quantity != 0) {
            throw new IllegalArgumentException("Registro já cadastrado");
        }
    }
}
