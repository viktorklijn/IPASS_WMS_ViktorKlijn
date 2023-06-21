import nl.hu.ipass.viktorklijn.system.models.Role;
import nl.hu.ipass.viktorklijn.system.models.Shop;
import nl.hu.ipass.viktorklijn.system.models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user;
    private Role role;
    private Shop shop;

    @BeforeEach
    public void setUp() {
        role = new Role("Manager", 1);
        shop = new Shop(1, "TestStore");
        user = new User("John", "test@mail.com", "123", 1, role, shop);
    }

    @Test
    public void testUserInitialization() {
        assertEquals("John", user.getUsername());
        assertEquals("test@mail.com", user.getEmail());
        assertEquals("123", user.getPassword());
        assertEquals(1, user.getId());
        assertEquals(role, user.getRole());
    }
}
