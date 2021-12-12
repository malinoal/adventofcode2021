import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.*;

class twelveTest {

    @org.junit.jupiter.api.Test
    void part_one() throws FileNotFoundException {
        assertEquals(10, twelve.part_one("12/example1.txt"));
        assertEquals(19, twelve.part_one("12/example2.txt"));
        assertEquals(226, twelve.part_one("12/example3.txt"));
    }

    @org.junit.jupiter.api.Test
    void part_two() throws FileNotFoundException {
        assertEquals(36, twelve.part_two("12/example1.txt"));
        assertEquals(103, twelve.part_two("12/example2.txt"));
        assertEquals(3509, twelve.part_two("12/example3.txt"));
    }
}