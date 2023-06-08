package nl.hu.ipass.viktorklijn.system.models;

public class Article {
    private int articleNumber;
    private String name;
    private String description;
    private Manufacturer manufacturer;
    private Category category;
    private Double price;
    private int barcode;

    public Article(int anr, String nm, String desc, Manufacturer manu, Category cate ,Double pr, int bc) {
        this.articleNumber = anr;
        this.name = nm;
        this.description = desc;
        this.manufacturer = manu;
        this.category = cate;
        this.price = pr;
        this.barcode = bc;
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
}
