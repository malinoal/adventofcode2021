import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class fiveTest {

    @Test
    void part_one() throws FileNotFoundException {
        assertEquals(5, five.part_one("5/example.txt"));
    }

    @Test
    void part_two() {
    }
}