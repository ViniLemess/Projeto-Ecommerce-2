package com.ecommerce.controller;

import com.ecommerce.model.OrderModel;
import com.ecommerce.service.DTO.OrderDTO;
import com.ecommerce.service.OrderService;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/order")
public class OrderController {

    private OrderService orderService;

    public OrderController(OrderService orderService) { this.orderService = orderService; }

    @PostMapping
    public void createOrder(@RequestBody @Valid OrderDTO newOrder) {

        orderService.registerOrder(newOrder);
    }
    @GetMapping
    public List<OrderModel> getOrders() {

        return orderService.searchAll();
    }
    @GetMapping(params = {"id"})
    public Optional<OrderModel> getOrderById(@RequestParam("id") Long id) {

        return orderService.searchById(id);
    }
}
