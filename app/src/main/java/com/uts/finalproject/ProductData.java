package com.uts.finalproject;

public class ProductData {

    private String prodName, prodPrice, prodDescription;
    private int  prodImg;


    public ProductData(String prodName, String prodPrice, String prodDescription, int prodImg) {
        this.prodName = prodName;
        this.prodPrice = prodPrice;
        this.prodDescription = prodDescription;
        this.prodImg = prodImg;
    }

    public String getProdName() {

        return prodName;
    }

    public String getProdPrice() {

        return prodPrice;
    }

    public String getProdDescription() {
        return prodDescription;
    }

    public int getProdImg() {
        return prodImg;
    }
}
