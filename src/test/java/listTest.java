import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
[x] prepend (conj)
[x] at      (nth)
[ ] pop
[ ] insert-at
[ ] remove-at
*/

class listTest {
    @Test
    void empty_upon_instantiation() {
        list l = new list();
        assertEquals(0, l.count());
    }

    @Test
    void prepend_count_at() {
        list l = new list();
        for (int x = 9; x >= 0; x--) {
            l.prepend(x);
        }

        assertEquals(10, l.count());
        for (int x = 0; x < 10; x++) {
            int actual = l.at(x);
            assertEquals(x, actual);
        }
    }

    @Test
    void at_out_of_bounds() {
        list l = new list();
        assertThrows(IndexOutOfBoundsException.class, () -> l.at(0));

        l.prepend(0);
        assertThrows(IndexOutOfBoundsException.class, () -> l.at(1));

        assertThrows(IndexOutOfBoundsException.class, () -> l.at(-1));
    }
}