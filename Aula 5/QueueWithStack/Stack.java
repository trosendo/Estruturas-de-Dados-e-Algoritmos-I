public interface Stack<E> {
    public E top();
    public E pop();
    public void push(E element);
    public boolean empty();
    public int size();
    public E elementAt(int i);
}
