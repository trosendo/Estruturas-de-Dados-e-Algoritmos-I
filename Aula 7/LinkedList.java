import java.util.Iterator;

public class LinkedList<T> implements Iterable<T> {
    private SingleNode<T> header, tail;
    private int size;

    public LinkedList() {
        tail = header = new SingleNode<>();
        size = 0;
    }

    public java.util.Iterator<T> iterator() {
        return new LinkedListIterator<>(header.next);
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public SingleNode<T> header() {
        return header;
    }

    public void add(int i, T x) {
        if (i == size)
            add(x);
        else {
            SingleNode<T> prev = getNode(i - 1);
            ;
            SingleNode<T> newNode = new SingleNode<>(x, prev.getNext());
            prev.setNext(newNode);
            size++;
        }
    }

    public void add(SingleNode<T> prev, T x) {
        SingleNode<T> newNode = new SingleNode<>(x, prev.getNext());
        prev.setNext(newNode);
        tail = newNode;
        size++;
    }

    public void add(T x) {
        add(tail, x);
    }

    public void remove(int index) { //try{ remove.....} catch ( exception e)}
        remove(getNode(index - 1));
    }

    public void remove(SingleNode<T> prev) {
        prev.setNext(prev.getNext().getNext());
        size--;
    }

    public void removeElement(T x){ //remove first occurrence of the node with the element x
        SingleNode<T> r = header();
        for(T v : this){
            if(v.equals(x)){
                remove(r);
            }else{
                r = r.getNext();
            }
        }
        //throw new java.util.NoSuchElementException("No element");
    }

    SingleNode<T> getNode(int i) {
        int index = -1;
        SingleNode<T> s = header();
        while (index++ < i) //same as   while(index < i){<...body...>; index++;}
            s = s.getNext();
        return s;
    }

    SingleNode<T> findPrevious(T x) {
        SingleNode<T> p = header();
        for (T v : this) {
            if (v.equals(x))
                return p;
            else
                p = p.getNext();
        }
        throw new java.util.NoSuchElementException("No element");
    }

    public String toString() {
        String s = "[";
        for (T x : this)
            s += x + ", ";
        return s.substring(0, s.length()-2) + "] OLAAAA";
    }

    public void set(int index, T x) {
        getNode(index).setElement(x);
    }

    public T get(int ind) throws IndexOutOfBoundsException {
        if (ind >= 0 && ind <= size() - 1)
            return getNode(ind).element;
        else
            throw new IndexOutOfBoundsException("getNode index:" + ind + ";size:" + size());
    }

}