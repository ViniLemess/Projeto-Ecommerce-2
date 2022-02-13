package com.ecommerce.service;

import com.ecommerce.infra.repository.ProductRepository;
import com.ecommerce.model.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {this.productRepository = productRepository;}

    public void registerCustomer(Product product) {

        validateDuplicatedRegister(product.getProductName(), product.getId());
        this.productRepository.save(product);
    }
    public Product searchByName(String name) {

        if(name == null || name.isBlank()) {

            throw new IllegalArgumentException("Nome inválido!");
        }
        return productRepository.searchProductByName(name);
    }
    public List<Product> listByName(String name) {

        if(name == null || name.isBlank()) {

            throw new IllegalArgumentException("Nome inválido!");
        }
        return productRepository.searchAllProducts(name);
    }
    public Product searchProductById(Long id) {

        return productRepository.findById(id).get();
    }
    private void validateDuplicatedRegister(String name, Long id) {

        var quantity = productRepository.countByNameAndDifferentId(name, id);
        if (quantity != 0) {
            throw new IllegalArgumentException("Registro já cadastrado");
        }
    }
}
