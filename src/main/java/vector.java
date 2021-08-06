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

    private void grow() {
        if (count() < elements.length)
            return;

        int[] larger = new int[count() * 2]; // TODO: maybe slow the growth at a certain point?
        for (int x = 0; x < count(); x++) {
            larger[x] = elements[x];
        }
        elements = larger;
    }

    public void append(int i) {
        grow();
        elements[elementCount++] = i;
    }

    public int at(int x) throws IndexOutOfBoundsException {
        if (x >= count())
            throw new IndexOutOfBoundsException();

        return elements[x];
    }

    public int pop() throws IndexOutOfBoundsException {
        if (count() == 0)
            throw new IndexOutOfBoundsException();

        return elements[--elementCount];
    }

    public void insert(int index, int value) {
        grow();

        for (int x = count(); x > index; x--)
            elements[x] = elements[x - 1];

        elementCount++;
        elements[index] = value;
    }

    public void remove(int index) {
        if (index >= count()) {
            throw new IndexOutOfBoundsException();
        }
        for (int x = index; x < count(); x++)
            elements[x] = elements[x + 1];

        elementCount--;
    }
}
