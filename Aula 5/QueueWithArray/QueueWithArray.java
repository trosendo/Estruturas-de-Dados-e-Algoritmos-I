public class QueueWithArray<E> {
    int maxSize = 0;
    E[] array;
    int first = 0;
    int last = 0;

    public QueueWithArray(){
        array = (E[]) new Object[20];
        maxSize = 20;
    }

    public QueueWithArray(int n){
        array = (E[]) new Object[n];
        maxSize = n;
    }

    public void enqueue(E x) throws Exception{
        if(size() == maxSize - 1){
            throw new Exception("Queue is Full!");
        }
        array[last] = x;
        last = inc(last);
    }

    public E dequeue() throws Exception{
        if(empty()){
            throw new Exception("Queue is Empty!");
        }
        E x = array[first];
        array[first] = null;
        first = inc(first);
        return x;
    }

    public int inc(int i){
        return (i + 1) % maxSize;
    }

    public int size(){
        return (maxSize - first + last) % maxSize;
    }

    public boolean empty(){
        return first == last;
    }

    public E front(){
        return array[first];
    }
}
