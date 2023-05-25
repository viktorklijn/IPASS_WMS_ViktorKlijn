import models.Article;
import models.Category;
import models.Manufacturer;
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
        Article article = new Article(manufacturer, category);

        assertEquals(manufacturer, article.getManufacturer());
        assertEquals(category, article.getCategory());
    }
}