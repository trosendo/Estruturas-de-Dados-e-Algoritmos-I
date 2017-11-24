import java.util.Iterator;

public class BinarySearchTree<E extends Comparable<? super E>> implements Iterable<E>, IBST<E> {

    BSTNode<E> root;
    int size;

    public BinarySearchTree(E x) {
        root = new BSTNode<>(x);
        size = 1;
    }

    public BinarySearchTree(BSTNode<E> r) {
        root = r;
        size = 0;
    }

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public BinarySearchTree(E r, BSTNode<E> e, BSTNode<E> d) {
        root = new BSTNode<>(r, e, d);
        size = 3;
    }

    @Override
    public boolean isEmpty() {
        return root == null;
    }

    public E getElement(E x) {
        return getElement(x, root);
    }
    public E getElement(E x, BSTNode<E> node){
        if(node == null)
            return null;

        if(node.element.compareTo(x) == 0)
            return node.element;

        if(node.element.compareTo(x) > 0)
            return getElement(x, node.left);
        else
            return getElement(x, node.right);

    }

    @Override
    public boolean contains(E x) {
        return contains(x, root);
    }

    public boolean contains(E x, BSTNode<E> n){
        if (n == null)
            return false;
        if (n.element.compareTo(x) == 0)
            return true;

        if (x.compareTo(n.element) < 0)    // if(x < root.element)
            return contains(x, n.left);
        else                               // if(x > root.element)
            return contains(x, n.right);

    }

    @Override
    public E findMin() {
        return findMin(root).element;
    }

    public BSTNode<E> findMin(BSTNode<E> n) {
        BSTNode<E> current = n;
        while(current.left != null){
            current = current.left;
        }
        return current;
    }

    @Override
    public E findMax() {
        return findMax(root).element;
    }

    public BSTNode<E> findMax(BSTNode<E> n) {
        BSTNode<E> current = n;
        while(current.right != null){
            current = current.right;
        }
        return current;
    }

    @Override
    public void insert(E x) {
        size++;
        root = insert(x, root);
    }

    public BSTNode<E> insert(E x, BSTNode<E> n) {
        if (n == null)
            return new BSTNode<>(x);

        if (n.element.compareTo(x) == 0)
            return n;

        if (x.compareTo(n.element) < 0){     // if(x < root.element)
            n.left = insert(x, n.left);
            return n;
        } else {                                // if(x > root.element)
            n.right = insert(x, n.right);
            return n;
        }
    }

    @Override
    public void remove(E x) {
        size--;
        root = remove(x, root);
    }

    public BSTNode<E> remove(E x, BSTNode<E> n){
        if(n == null)
            return null;

        if(x.compareTo(n.element) == 0){     // if(x == n.element)
            // n is the node to be removed
            if(n.left == null && n.right == null){
               return null;
            }

            if(n.left == null){
               return n.right;
            }

            if(n.right == null){
               return n.left;
            }

            /*
            if the code gets here then the node n has 2 children.
            find the smallest node by reading the most left
            child of the right subtree.
            */

            BSTNode<E> smallestNode = findMin(n.right);

            n.element = smallestNode.element;
            n.right = smallestNode.right;

            n.right = remove(smallestNode.element, n.right);

            return n;
        } else if(x.compareTo(n.element) < 0){ // if(x < n.element)
            n.left = remove(x, n.left);
            return n;
        } else {
            n.right = remove(x, n.left);
            return n;
        }
    }

    @Override
    public void printInOrder() {
        printInOrder(root);
    }

    public void printInOrder(BSTNode<E> node){ //RETURN STRING WITH PRINTED ELEMENTS!!
        if(node == null)
            return;

        printInOrder(node.left);
        System.out.println("-> " + node.element);
        printInOrder(node.right);
    }

    @Override
    public void printPostOrder() {

    }

    @Override
    public void printPreOrder() {

    }

    @Override
    public Iterator<E> iterator() {
        return new BSTIterator<>(root, size);
    }

    public int getSize(){
        return size;
    }
}
