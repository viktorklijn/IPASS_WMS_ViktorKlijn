package nl.hu.ipass.viktorklijn.system.models;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Shop implements Serializable{
    private int id;
    private String name;
    private static ArrayList<Shop> shops = new ArrayList<>();
    private ArrayList<Article> articles;

    public Shop(int id,String name) {
        this.id = id;
        this.name = name;
        articles = new ArrayList<>();
        shops.add(this);
    }

    public static Shop getShop(int shopId) {
        for (Shop shop : shops) {
            if (shop.id == shopId) {
                return shop;
            }
        }
        return null;
    }

    public void setArticles(ArrayList<Article> newArticles) {
        articles = newArticles;
    }

    public static void setShops(ArrayList<Shop> newShops) {
        shops = newShops;
    }

    public static ArrayList<Shop> getShops() {
        return shops;
    }

    public void addArticle(Article article) {
        articles.add(article);
    }

    public ArrayList<Article> getArticles() {
        return articles;
    }

    public Article getArticle(int articleNumber) {
        for (Article article : articles) {
            if (article.getArticleNumber() == articleNumber) {
                return article;
            }
        }
        return null;
    }
}
