package com.model;

public class Product {
    private Integer id;
    private String nameProduct;
    private String price;
    private String discription;
    private String producer;

    public Product() {
    }

    public Product(Integer id, String nameProduct, String price, String discription, String producer) {
        this.id = id;
        this.nameProduct = nameProduct;
        this.price = price;
        this.discription = discription;
        this.producer = producer;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public String getProducer() {
        return producer;
    }

    public void setProducer(String producer) {
        this.producer = producer;
    }
}
