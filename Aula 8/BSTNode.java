public class BSTNode<E> {  //Binary Search Tree Node

    E element;
    BSTNode<E> left;
    BSTNode<E> right;

    BSTNode(E e) {
        element = e;
        left = null;
        right = null;
    }

    BSTNode(E e, BSTNode<E> left, BSTNode<E> right) {
        element = e;
        this.left = left;
        this.right = right;
    }

    public String toString() {
        return element.toString();
    }
}
