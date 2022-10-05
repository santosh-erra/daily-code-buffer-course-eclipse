package com.dialycodebuffer.ProductService.dto;

public class ProductDTO  {
    private long productId;
    private String productName;
    private long price;
    private long quantity;

    public ProductDTO() {
    }

    public void setProductId(long productId) {
        this.productId = productId;
    }

    public long getProductId() {
        return this.productId;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductName() {
        return this.productName;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getPrice() {
        return this.price;
    }

    public void setQuantity(long quantity) {
        this.quantity = quantity;
    }

    public long getQuantity() {
        return this.quantity;
    }
}