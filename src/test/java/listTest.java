import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    void pop() {
        list l = new list();
        l.prepend(1);

        int popped = l.pop();

        assertEquals(1, popped);
        assertEquals(0, l.count());
    }

    @Test
    void pop_empty() {
        assertThrows(IndexOutOfBoundsException.class, new list()::pop);
    }

    @Test
    void insert_at() {
        list l = new list();
        l.prepend(4);
        l.prepend(3);
        l.prepend(1);
        l.prepend(0);

        l.insert(2, 22);

        assertEquals(0, l.at(0));
        assertEquals(1, l.at(1));
        assertEquals(22, l.at(2));
        assertEquals(3, l.at(3));
        assertEquals(4, l.at(4));
    }

    @Test
    void insert_at_out_of_bounds() {
        list l = new list();
        assertThrows(IndexOutOfBoundsException.class, () -> l.insert(0, 42));

        l.prepend(0);
        assertThrows(IndexOutOfBoundsException.class, () -> l.insert(10, 42));
        assertThrows(IndexOutOfBoundsException.class, () -> l.insert(-1, 42));
    }

    @Test
    void remove() {
        list l = new list();
        l.prepend(2);
        l.prepend(1);
        l.prepend(1);
        l.prepend(0);

        l.remove(2);

        assertEquals(0, l.at(0));
        assertEquals(1, l.at(1));
        assertEquals(2, l.at(2));
    }

    @Test
    void remove_out_of_bounds() {
        list l = new list();

        assertThrows(IndexOutOfBoundsException.class, () -> l.remove(0));

        l.prepend(0);
        assertThrows(IndexOutOfBoundsException.class, () -> l.remove(10));
        assertThrows(IndexOutOfBoundsException.class, () -> l.remove(-1));
    }
}