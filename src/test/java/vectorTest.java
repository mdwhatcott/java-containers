import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/*
[x] append (conj)
[x] at     (nth)
[x] pop
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
    void append_grow_at() {
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
    void at_out_of_bounds() {
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

    @Test
    void pop() {
        vector v = new vector();

        v.append(1);
        int popped = v.pop();

        assertEquals(1, popped);
        assertEquals(0, v.count());
    }

    @Test
    void pop_empty() {
        assertThrows(IndexOutOfBoundsException.class, new vector()::pop);
    }
}
