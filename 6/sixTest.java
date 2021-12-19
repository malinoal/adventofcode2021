import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class sixTest {

    @Test
    void part_one() throws FileNotFoundException {
        assertEquals(26, six.part_one("6/example.txt", 18));
        assertEquals(5934, six.part_one("6/example.txt", 80));
    }

    @Test
    void lanternFish() throws FileNotFoundException {
        assertEquals(5, six.lanternFish(3, 20));
        assertEquals(7, six.lanternFish(List.of(4), 24));
    }

    @Test
    void part_two() {
    }

}