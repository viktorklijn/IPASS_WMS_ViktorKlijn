import nl.hu.ipass.viktorklijn.system.webservices.DashboardResource;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;
import nl.hu.ipass.viktorklijn.system.models.Article;
import nl.hu.ipass.viktorklijn.system.models.Category;
import nl.hu.ipass.viktorklijn.system.models.Manufacturer;
import nl.hu.ipass.viktorklijn.system.models.Shop;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DashboardResourceTest {
    private DashboardResource dashboardResource;

    @BeforeEach
    public void setUp() {
        dashboardResource = new DashboardResource();
    }

    @Test
    public void testLoadDashboard_ReturnsArticles() {
        ArrayList<Article> articles = new ArrayList<>();
        Manufacturer manufacturer1 = new Manufacturer("Manufacturer 1", "Country 1", "email1@example.com");
        Manufacturer manufacturer2 = new Manufacturer("Manufacturer 2", "Country 2", "email2@example.com");
        Manufacturer manufacturer3 = new Manufacturer("Manufacturer 3", "Country 3", "email3@example.com");
        Category category1 = new Category("Category 1");
        Category category2 = new Category("Category 2");
        Category category3 = new Category("Category 3");
        articles.add(new Article(1, "Article 1", "Description 1", manufacturer1, category1, 10.0, 123456));
        articles.add(new Article(2, "Article 2", "Description 2", manufacturer2, category2, 20.0, 654321));
        articles.add(new Article(3, "Article 3", "Description 3", manufacturer3, category3, 30.0, 987654));
        Shop.setArticles(articles);

        Response response = dashboardResource.loadDashboard();

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        assertNotNull(response.getEntity());

        List<Article> returnedArticles = (List<Article>) response.getEntity();
        assertEquals(articles.size(), returnedArticles.size());
        for (int i = 0; i < articles.size(); i++) {
            Article verwachtArticle = articles.get(i);
            Article returnedArticle = returnedArticles.get(i);
            assertEquals(verwachtArticle.getArticleNumber(), returnedArticle.getArticleNumber());
            assertEquals(verwachtArticle.getName(), returnedArticle.getName());
            assertEquals(verwachtArticle.getDescription(), returnedArticle.getDescription());
            assertEquals(verwachtArticle.getManufacturer().getName(), returnedArticle.getManufacturer().getName());
            assertEquals(verwachtArticle.getCategory().getName(), returnedArticle.getCategory().getName());
            assertEquals(verwachtArticle.getPrice(), returnedArticle.getPrice());
            assertEquals(verwachtArticle.getBarcode(), returnedArticle.getBarcode());
        }
    }
}
