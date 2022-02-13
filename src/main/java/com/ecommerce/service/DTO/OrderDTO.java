package com.ecommerce.service.DTO;

import java.util.List;

public class OrderDTO {

    private Long Customer;
    private Long Supplier;
    private Double shippingPrice;
    private List<ItemDTO> itemDTOList;

    public Long getCustomer() {
        return Customer;
    }

    public void setCustomer(Long customer) {
        Customer = customer;
    }

    public Long getSupplier() {
        return Supplier;
    }

    public void setSupplier(Long supplier) {
        Supplier = supplier;
    }

    public Double getShippingPrice() {
        return shippingPrice;
    }

    public void setShippingPrice(Double shippingPrice) {
        this.shippingPrice = shippingPrice;
    }

    public List<ItemDTO> getItemDTOList() {
        return itemDTOList;
    }

    public void setItemDTOList(List<ItemDTO> itemDTOList) {
        this.itemDTOList = itemDTOList;
    }
}
