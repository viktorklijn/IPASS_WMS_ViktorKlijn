import nl.hu.ipass.viktorklijn.system.models.Article;
import nl.hu.ipass.viktorklijn.system.models.Category;
import nl.hu.ipass.viktorklijn.system.models.Manufacturer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ArticleTest {
    private Manufacturer manufacturer;
    private Category category;

    @BeforeEach
    public void setUp() {
        manufacturer = new Manufacturer("Manufacturer", "Netherlands", "test@mail.com");
        category = new Category("Test Category");
    }

    @Test
    public void testArticleInitialization() {
        Manufacturer m1 = new Manufacturer("humdakin", "Denmark", "23975954");
        Category c1 = new Category("Meubels");
        Article article = new Article(3, "Laptop", "Test", m1, c1, 300.0, 343493859);;

        assertEquals(manufacturer, article.getManufacturer());
        assertEquals(category, article.getCategory());
    }
}