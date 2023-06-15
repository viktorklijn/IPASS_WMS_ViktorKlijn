package models;

import nl.hu.ipass.viktorklijn.system.models.Manufacturer;

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
