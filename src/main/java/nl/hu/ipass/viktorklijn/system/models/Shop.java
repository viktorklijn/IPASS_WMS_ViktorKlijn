package nl.hu.ipass.viktorklijn.system.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Serializable {
    private String name;
    private static ArrayList<Shop> shops = new ArrayList<>();
    private static ArrayList<Article> articles = new ArrayList<>();

    public Shop(String name) {
        this.name = name;
        shops.add(this);
    }

    public static void setArticles(ArrayList<Article> newArticles) {
        articles = newArticles;
    }

    public static void setShops(ArrayList<Shop> newShops) {
        shops = newShops;
    }

    public static Object getShops() {
        return shops;
    }

    public void addArticle(Article article) {
        articles.add(article);
    }

    public static ArrayList<Article> getArticles() {
        return articles;
    }
}
