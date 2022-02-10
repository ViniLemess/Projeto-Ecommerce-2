package com.ecommerce.controller;

import com.ecommerce.model.Product;
import com.ecommerce.service.ProductService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    private ProductService service;

    public ProductController(ProductService service) { this.service = service; }

    @GetMapping(params = {"filter"})
    public List<Product> getProducts(@RequestParam("filter") String filter) {

        return service.listByName(filter);
    }
    @GetMapping
    public Product getProduct(@RequestParam("name") String name) {

        return service.searchByName(name);
    }
    @PostMapping
    public void createProduct(@RequestBody @Valid Product product) {

        service.registerCustomer(product);
    }
}
