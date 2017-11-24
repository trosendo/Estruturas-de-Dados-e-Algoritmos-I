package Stacks;

public class MyStack<E> implements Stack<E> {

    private int maxSize;
    private E[] values;
    private int topIndex;


    public MyStack(int max) {
        maxSize = max;
        values = (E[]) new Object[maxSize];
        topIndex = -1;
    }

    public void push(E j) {
        values[++topIndex] = j;
    }

    public E pop() {
        return values[topIndex--];
    }

    public E top() {
        return values[topIndex];
    }

    public boolean empty() {
        return (topIndex == -1);
    }

    @Override
    public int size() {
        return topIndex;
    }


    public String toString() {
        String output = "";
        for (int i = 0; i < topIndex; i++) {
            output += String.format("%s", values[i]);
            output += ", ";
        }
        return output;
    }

    public E get(int i) {
        return values[i];

    }
}
