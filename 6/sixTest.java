import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.math.BigInteger;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class sixTest {

    @Test
    void part_one() throws FileNotFoundException {
        assertEquals(26, six.part_one("6/example.txt", 18));
        assertEquals(5934, six.part_one("6/example.txt", 80));
    }

    @Test
    void part_two() throws FileNotFoundException {
        assertEquals(new BigInteger("26984457539") , six.part_two("6/example.txt", 256));
    }

}