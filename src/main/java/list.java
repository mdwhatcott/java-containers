public class list {
    private class node {
        int value;
        node next;

        node(int value) {
            this.value = value;
        }

        int count() {
            if (next == null) {
                return 1;
            }
            return 1 + next.count();
        }

        public int at(int current, int target) throws IndexOutOfBoundsException {
            if (current == target)
                return value;

            if (next == null)
                throw new IndexOutOfBoundsException();

            return next.at(current + 1, target);
        }
    }

    private node root;

    public int count() {
        return root == null ? 0 : root.count();
    }

    public void prepend(int value) {
        if (root == null)
            root = new node(value);
        else {
            node old = root;
            root = new node(value);
            root.next = old;
        }
    }

    public int at(int x) throws IndexOutOfBoundsException {
        if (root == null)
            throw new IndexOutOfBoundsException();

        return root.at(0, x);
    }
}
