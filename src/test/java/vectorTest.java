import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

        assertThrows(IndexOutOfBoundsException.class, () -> v.at(0));
        assertThrows(IndexOutOfBoundsException.class, () -> v.at(100));
        assertThrows(IndexOutOfBoundsException.class, () -> v.at(-1));
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

    @Test
    void insert_at() {
        vector v = new vector(4);
        v.append(0);
        v.append(1);
        v.append(3);
        v.append(4);

        v.insert(2, 22);

        assertEquals(0, v.at(0));
        assertEquals(1, v.at(1));
        assertEquals(22, v.at(2));
        assertEquals(3, v.at(3));
        assertEquals(4, v.at(4));
    }

    @Test
    void remove() {
        vector v = new vector();
        v.append(0);
        v.append(1);
        v.append(1);
        v.append(2);

        v.remove(2);

        assertEquals(0, v.at(0));
        assertEquals(1, v.at(1));
        assertEquals(2, v.at(2));
    }

    @Test
    void remove_out_of_bounds() {
        vector v = new vector();

        assertThrows(IndexOutOfBoundsException.class, () -> v.remove(0));
        assertThrows(IndexOutOfBoundsException.class, () -> v.remove(-1));
    }
}
