package nl.hu.ipass.viktorklijn.system.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Shop{
    private String name;
    private static ArrayList<Shop> shops = new ArrayList<>();
    private ArrayList<Article> articles;

    public Shop(String name) {
        this.name = name;
        articles = new ArrayList<>();
        shops.add(this);
    }

    public void setArticles(ArrayList<Article> newArticles) {
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

    public ArrayList<Article> getArticles() {
        return articles;
    }
}
