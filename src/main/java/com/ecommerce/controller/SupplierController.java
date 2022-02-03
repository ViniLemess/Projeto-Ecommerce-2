package com.ecommerce.controller;

import com.ecommerce.model.Supplier;
import com.ecommerce.service.SupplierService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {

    private SupplierService service;

    public SupplierController(SupplierService supplierService) {
        this.service = supplierService;
    }

    @GetMapping(params = {"filter"})
    public List<Supplier> getSuppliers(@RequestParam("filter") String filter) {

        return service.listByTradingName(filter);
    }
    @GetMapping
    public Supplier getSupplier(@RequestParam("tradingName") String tradingName) {

        return service.searchByTradingName(tradingName);
    }
    @PostMapping
    public void createSupplier(@RequestBody @Valid Supplier supplier) {

        service.registerSupplier(supplier);
    }
}
