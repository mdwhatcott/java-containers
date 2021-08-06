import java.util.stream.IntStream;

public class vector {
    private int elementCount;
    private int[] elements;

    public vector() {
        this(16);
    }

    public vector(int initialSize) {
        elements = new int[initialSize];
    }

    public int count() {
        return elementCount;
    }

    public void append(int i) {
        if (elementCount == elements.length) grow();
        elements[elementCount] = i;
        elementCount++;
    }

    private void grow() {
        int[] larger = new int[elements.length * 2]; // TODO: maybe slow the growth at a certain point?
        IntStream.range(0, elements.length).forEach(x -> larger[x] = elements[x]);
        elements = larger;
    }

    public int at(int x) throws IndexOutOfBoundsException {
        if (x >= elementCount) {
            throw new IndexOutOfBoundsException();
        }
        return elements[x];
    }

    public int pop() throws IndexOutOfBoundsException {
        elementCount--;
        return elements[elementCount];
    }
}
