package models;

public class Article {
    private Manufacturer manufacturer;
    private Category category;

    public Article(Manufacturer manufacturer, Category category) {
        this.manufacturer = manufacturer;
        this.category = category;


    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public Category getCategory() {
        return category;
    }
}
