package com.uts.finalproject.model;

public class ProductCategory {

    Integer ProductId;
    String ProductName;
    Integer ImageUrl;

    public ProductCategory(Integer productId, String productName, Integer imageUrl) {
        ProductId = productId;
        ProductName = productName;
        ImageUrl = imageUrl;
    }

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer productId) {
        ProductId = productId;
    }

    public String getProductName() {
        return ProductName;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public Integer getImageUrl() {
        return ImageUrl;
    }

    public void setImageUrl(Integer imageUrl) {
        ImageUrl = imageUrl;
    }
}
