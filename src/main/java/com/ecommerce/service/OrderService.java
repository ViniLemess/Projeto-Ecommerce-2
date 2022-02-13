package com.ecommerce.service;

import com.ecommerce.infra.repository.OrderRepository;
import com.ecommerce.model.Item;
import com.ecommerce.model.OrderModel;
import com.ecommerce.service.DTO.ItemDTO;
import com.ecommerce.service.DTO.OrderDTO;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    private OrderRepository orderRepository;
    private SupplierService supplierService;
    private CustomerService customerService;
    private ProductService productService;

    public OrderService(OrderRepository orderRepository, SupplierService supplierService, CustomerService customerService, ProductService productService) {
        this.orderRepository = orderRepository;
        this.supplierService = supplierService;
        this.customerService = customerService;
        this.productService = productService;
    }

    public void registerOrder(OrderDTO newOrder) {
        var customer = customerService.searchCustomerById(newOrder.getCustomer());
        var supplier = supplierService.searchSupplierById(newOrder.getSupplier());
        var order = new OrderModel(null, customer, supplier, newOrder.getShippingPrice(), null);
        for(ItemDTO itemDTO : newOrder.getItemDTOList()) {

            var product = productService.searchProductById(itemDTO.getProduct());
            var item = new Item(null, product, itemDTO.getQuantity());
            order.addItem(item);
        }
        orderRepository.save(order);
    }
    public Optional<OrderModel> searchById(Long id) {

        if(id == null) {

            throw new IllegalArgumentException("Id inválida!");
        }
        return orderRepository.findById(id);
    }
    public List<OrderModel> searchAll() {

        return orderRepository.findAll();
    }
}
