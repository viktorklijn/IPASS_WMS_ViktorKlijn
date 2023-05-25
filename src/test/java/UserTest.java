import models.Role;
import models.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserTest {
    private User user;
    private Role role;

    @BeforeEach
    public void setUp() {
        role = new Role("Manager", 1);
        user = new User("John", "test@mail.com", "123", 1, role);
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
