package com.example.buynow.data_models;

public class product {
    private String product_name;
    private String product_status;
    private String product_type;
    private String product_price;
    private String product_description;
    private String product_date;
    private String product_area;

    public product(String product_name, String product_status, String product_type, String product_price, String product_description, String product_date, String product_area) {
        this.product_name = product_name;
        this.product_status = product_status;
        this.product_type = product_type;
        this.product_price = product_price;
        this.product_description = product_description;
        this.product_date = product_date;
        this.product_area = product_area;
    }

    public String getProduct_name() {
        return product_name;
    }

    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }

    public String getProduct_status() {
        return product_status;
    }

    public void setProduct_status(String product_status) {
        this.product_status = product_status;
    }

    public String getProduct_type() {
        return product_type;
    }

    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    public String getProduct_price() {
        return product_price;
    }

    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }

    public String getProduct_description() {
        return product_description;
    }

    public void setProduct_description(String product_description) {
        this.product_description = product_description;
    }

    public String getProduct_date() {
        return product_date;
    }

    public void setProduct_date(String product_date) {
        this.product_date = product_date;
    }

    public String getProduct_area() {
        return product_area;
    }

    public void setProduct_area(String product_area) {
        this.product_area = product_area;
    }
}
