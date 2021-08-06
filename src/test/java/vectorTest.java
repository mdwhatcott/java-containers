import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
[x] append (conj)
[x] at     (nth)
[ ] pop
[ ] remove-at
[ ] insert-at
*/

class vectorTest {
    @Test
    void empty_upon_instantiation() {
        vector v = new vector();
        assertEquals(0, v.count());
    }

    @Test
    void append_grow_nth() {
        int totalItems = 100;
        vector v = new vector(16);

        for (int x = 1; x <= totalItems; x++) {
            v.append(x);
        }

        assertEquals(totalItems, v.count());
        for (int x = 1; x <= totalItems; x++) {
            assertEquals(x, v.at(x - 1));
        }
    }

    @Test
    void nth_out_of_bounds() {
        vector v = new vector();

        assertThrows(IndexOutOfBoundsException.class, () -> {
            v.at(0);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            v.at(100);
        });

        assertThrows(IndexOutOfBoundsException.class, () -> {
            v.at(-1);
        });
    }
}
