package nl.hu.ipass.viktorklijn.system.models;

import java.io.Serializable;

public class Article implements Serializable {
    private int articleNumber;
    private String name;
    private String description;
    private Manufacturer manufacturer;
    private Category category;
    private Double price;
    private int barcode;
    private int stock;

    public Article(int anr, String nm, String desc, Manufacturer manu, Category cate ,Double pr, int bc) {
        this.articleNumber = anr;
        this.name = nm;
        this.description = desc;
        this.manufacturer = manu;
        this.category = cate;
        this.price = pr;
        this.barcode = bc;
        this.stock = 0;
    }
    public Article(int anr, String nm, String desc, Manufacturer manu, Category cate ,Double pr, int bc, int stock) {
        this.articleNumber = anr;
        this.name = nm;
        this.description = desc;
        this.manufacturer = manu;
        this.category = cate;
        this.price = pr;
        this.barcode = bc;
        this.stock = stock;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Category getCategory() {
        return category;
    }

    public String getName() {
        return name;
    }

    public int getArticleNumber() {
        return articleNumber;
    }

    public String getDescription() {
        return description;
    }

    public Double getPrice() {
        return price;
    }

    public int getBarcode() {
        return barcode;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
