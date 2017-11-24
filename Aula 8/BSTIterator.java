import Stacks.*;

public class BSTIterator<E> implements java.util.Iterator<E> {
    BSTNode<E> node;
    Stack<BSTNode<E>> stack;

    BSTIterator(BSTNode<E> node, int BSTSize){
        this.node = node;
        stack = new MyStack<>(BSTSize);
        populateStack(stack, this.node);
    }

    private void populateStack(Stack<BSTNode<E>> st, BSTNode<E> n){
        if(n == null)
            return;
        populateStack(st,n.right);
        st.push(n);
        populateStack(st,n.left);
    }

    public boolean hasNext(){
        return !stack.empty();
    }

    public E next() {
        return stack.pop().element;
    }

}
