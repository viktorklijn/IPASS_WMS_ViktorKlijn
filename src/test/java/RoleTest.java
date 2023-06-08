import nl.hu.ipass.viktorklijn.system.models.Role;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleTest {
    private Role role;

    @BeforeEach
    public void setUp() {
        role = new Role("Manager", 1);
    }

    @Test
    public void testRoleInitialization() {
        assertEquals("Manager", role.getName());
        assertEquals(1, role.getId());
    }
}
