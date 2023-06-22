package nl.hu.ipass.viktorklijn.setup;

import nl.hu.ipass.viktorklijn.system.models.*;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.io.*;
import java.util.ArrayList;

@WebListener
public class ContextListener implements ServletContextListener {
    private static final String DATA_FILE = "C:\\Users\\vikto\\Desktop\\Projects\\IPASS-magazijn\\src\\main\\resources\\data.obj";

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        loadData();
//        initializeData();
    }

    private void initializeData() {
        Shop s1 = new Shop(1, "ByJensen");
        Manufacturer m1 = new Manufacturer("humdakin", "Denmark", "23975954");
        Category c1 = new Category("Meubels");

        Article a1 = new Article(1, "Stoel", "Mooie stoel", m1, c1, 10.5, 1245678);
        Article a2 = new Article(2, "Bank", "Mooie Bank", m1, c1, 249.95, 466677544);
        Article a3 = new Article(3, "Laptop", "Test", m1, c1, 300.0, 343493859);

        s1.addArticle(a1);
        s1.addArticle(a2);
        s1.addArticle(a3);

        Role r1 = new Role("admin", 1);
        User u1 = new User("Viktor", "test@test.com", "pass", 12, r1, s1);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        saveData();
    }

    private void saveData() {
        try {
            FileOutputStream fos = new FileOutputStream(DATA_FILE);
             ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(new SaveModel(Shop.getShops(), User.getUsers()));
            oos.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void loadData() {
        ArrayList<Shop> shops = new ArrayList<>();
        ArrayList<User> users = new ArrayList<>();
        SaveModel data;

        File file = new File(DATA_FILE);
        if (file.exists()) {
            try (FileInputStream fis = new FileInputStream(DATA_FILE);
                 ObjectInputStream ois = new ObjectInputStream(fis)) {
                data = (SaveModel) ois.readObject();
                System.out.println(data.getShops());
                Shop.setShops(data.getShops());
                User.setUsers(data.getUsers());
                System.out.println("loaded");
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }

    }
}
