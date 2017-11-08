import java.util.ArrayList;

public class FilaDeEspera_<T> implements FilaDeEspera<T>, Comparable<T> {
    private ArrayList<T> elements;
    private int numberOfElements;
    private int maxCapacity;

    public FilaDeEspera_(){
        maxCapacity = 100;
        elements = new ArrayList<>(maxCapacity);
        numberOfElements = 0;
    }

    public FilaDeEspera_(int capacity){
        elements = new ArrayList<>(capacity);
        numberOfElements = 0;
        maxCapacity = capacity;
    }

    @Override
    public int size() {
        return numberOfElements;
    }

    @Override
    public int maxSize() {
        return maxCapacity;
    }

    @Override
    public int places() {
        return maxCapacity - numberOfElements;
    }

    @Override
    public boolean isFull() {
        if (places() == 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public boolean isEmpty() {
        if (numberOfElements == 0){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public void add(T element) {
        elements.add(element);
        numberOfElements++;
    }

    @Override
    public T front() {
        return (T) elements.get(0);
    }

    @Override
    public T remove() {
        Object removed = this.front();
        for (int i = 0; i < numberOfElements - 1; i++) {
            elements.set(i, elements.get(i + 1));
        }
        numberOfElements--;
        return (T) removed;
    }

    public String toString(){
        return elements.toString();
    }

    @Override
    public int compareTo(T o) {
        ArrayList<T> l = (ArrayList<T>) o;
        if(this.size() > l.size()){
            return 1;
        }else if (this.size() == l.size()){
            return 0;
        }else{
            return -1;
        }
    }
}
