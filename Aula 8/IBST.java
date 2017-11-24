public interface IBST<E extends Comparable<? super E>>{     // Interface Binary Search Tree
    public boolean isEmpty();
    public boolean contains(E x);
    public E findMin();         //done
    public E findMax();
    public void insert(E x);    //done
    public void remove(E x);    //done
    public void printInOrder(); //done
    public void printPostOrder();
    public void printPreOrder();
}
