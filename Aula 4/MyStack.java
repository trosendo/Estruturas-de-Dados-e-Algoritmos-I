

public class MyStack<E> implements Stack<E> {

    private E[] values;
    private int topIndex = 0;
    private int maxSize = 0;

    public MyStack(){
        values = (E[]) new Object[20];
        maxSize = 20;
    }

    public MyStack(int n){
        values = (E[]) new Object[n];
        maxSize = n;
    }

    @Override
    public E top() {
        if(topIndex > 0){
            return values[topIndex - 1];
        }else{
            return null;
        }
    }

    @Override
    public E pop() {
        if(topIndex > 0){
            E obj = values[topIndex - 1];
            values[topIndex - 1] = (E) new Object();
            topIndex--;
            return obj;
        }else{
            System.out.println("Pop Unsucessful >> Array is Empty!");
            return null;
        }
    }

    @Override
    public void push(E element) {
        if(topIndex < maxSize){
            values[topIndex] = element;
            topIndex++;
        }else{
            System.out.println("Push Unsucessful >> Array is full!");
        }
    }

    @Override
    public boolean empty() {
        return topIndex == 0;
    }

    @Override
    public int size() {
        return topIndex;
    }
}
