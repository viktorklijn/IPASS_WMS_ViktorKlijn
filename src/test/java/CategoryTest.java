import models.Article;
import models.Category;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CategoryTest {
    private Category category;

    @BeforeEach
    public void setUp() {
        Category category = new Category("Kitchen");
    }

    @Test
    public void testCategoryInitialization() {
        assertEquals("Kitchen", category.getName());
    }
}