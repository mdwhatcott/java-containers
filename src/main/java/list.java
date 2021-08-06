public class list {
    private static class node {
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

        public void insert(int current, int target, int value) throws IndexOutOfBoundsException{
            if ((current + 1) == target) {
                node n = new node(value);
                n.next = next;
                next = n;
            } else if (current < target) {
                next.insert(current+1, target, value);
            } else {
                throw new IndexOutOfBoundsException();
            }
        }

        public void remove(int current, int target) throws IndexOutOfBoundsException {
            if ((current + 1) == target) {
                next = next.next;
            } else if (current < target && next != null)  {
                next.remove(current+1, target);
            } else {
                throw new IndexOutOfBoundsException();
            }
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

    public int pop() throws IndexOutOfBoundsException {
        if (root == null)
            throw new IndexOutOfBoundsException();

        int value = root.value;
        root = root.next;
        return value;
    }

    public void insert(int index, int value) throws IndexOutOfBoundsException {
        if (root == null)
            throw new IndexOutOfBoundsException();

        root.insert(0, index, value);
    }

    public void remove(int index) throws IndexOutOfBoundsException {
        if (root == null)
            throw new IndexOutOfBoundsException();

        root.remove(0, index);
    }
}
