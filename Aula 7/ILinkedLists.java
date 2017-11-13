public interface ILinkedLists<T> {
    java.util.Iterator<T> iterator();

    int size();

    boolean isEmpty();

    void removeIndex(int i);

    void remove(T x);

    void add(T x); // adiciona x no fim da lista

    void add(int i, T x);

    T get(int i);

    void set(int i, T y);

    String toString();
}
