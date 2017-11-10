public class LinkedListIterator<T> implements java.util.Iterator<T> {
    private SingleNode<T> current;
    public LinkedListIterator(SingleNode<T> c) {
        current = c;
    }
    public boolean hasNext() {
        return current != null;
    }
    public T next() {
        if (!hasNext())
            throw new java.util.NoSuchElementException();
        T nextItem = current.element();
        current = current.getNext();
        return nextItem;
    }
    public void remove() {
        throw new UnsupportedOperationException();
    }
}