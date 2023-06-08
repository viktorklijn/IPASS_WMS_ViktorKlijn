import nl.hu.ipass.viktorklijn.system.models.Manufacturer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ManufacturerTest {
    private Manufacturer manufacturer;

    @BeforeEach
    public void setUp() {
        manufacturer = new Manufacturer("Manufacturer", "Netherlands", "test@mail.com");
    }

    @Test
    public void testManufacturerInitialization() {
        assertEquals("Manufacturer", manufacturer.getName());
        assertEquals("Netherlands", manufacturer.getCountry());
        assertEquals("test@mail.com", manufacturer.getEmail());
    }
}
