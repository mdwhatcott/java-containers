public class vector {
    private int elementCount;
    private int[] elements;

    public vector() {
        this(16);
    }

    public vector(int initialSize) {
        elements = new int[initialSize];
    }

    private void grow() {
        if (elementCount < elements.length)
            return;

        int[] larger = new int[elements.length * 2]; // TODO: maybe slow the growth at a certain point?
        for (int x = 0; x < elements.length; x++) {
            larger[x] = elements[x];
        }
        elements = larger;
    }

    public int count() {
        return elementCount;
    }

    public void append(int i) {
        grow();
        elements[elementCount] = i;
        elementCount++;
    }

    public int at(int x) throws IndexOutOfBoundsException {
        if (x >= elementCount)
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

        for (int x = elementCount; x > index; x--)
            elements[x] = elements[x - 1];

        elementCount++;
        elements[index] = value;
    }

    public void remove(int index) {
        if (index >= elementCount) {
            throw new IndexOutOfBoundsException();
        }
        for (int x = index; x < elementCount; x++)
            elements[x] = elements[x + 1];

        elementCount--;
    }
}
