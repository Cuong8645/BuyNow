package vn.edu.tdc.chuyendedidong.data_models;

public class Product {
    private int ID_Image;
    private String NameProduct;
    private double Price;

    public Product() {
    }

    public Product(int ID_Image, String nameProduct, double price) {
        this.ID_Image = ID_Image;
        NameProduct = nameProduct;
        Price = price;
    }

    public int getID_Image() {
        return ID_Image;
    }

    public String getNameProduct() {
        return NameProduct;
    }

    public double getPrice() {
        return Price;
    }

    public void setID_Image(int ID_Image) {
        this.ID_Image = ID_Image;
    }

    public void setNameProduct(String nameProduct) {
        NameProduct = nameProduct;
    }

    public void setPrice(double price) {
        Price = price;
    }
}
