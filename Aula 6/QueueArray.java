public class QueueArray<E> implements IQueue<E> {
    E[] queue;
    private int first = 0;
    private int last = 0;
    //private int nElements = 0;
    private int maxSize = 0;

    public QueueArray(){
        maxSize = 20;
        queue = (E[]) new Object[maxSize];
    }

    public QueueArray(int n){
        maxSize = n;
        queue = (E[]) new Object[maxSize];
    }

    @Override
    public void enqueue(E o) throws OverflowQueueException {
        if(size() == maxSize - 1) {
            throw new OverflowQueueException();
        }else{
            queue[last] = o;
            last = inc(last);
        }
    }

    @Override
    public E front() throws EmptyQueueException {
        if(empty()){
            throw new EmptyQueueException();
        }else{
            return queue[first];
        }
    }

    @Override
    public E dequeue() throws EmptyQueueException {
        if(empty()){
            throw new EmptyQueueException();
        }else{
            E out = queue[first];
            queue[first] = (E) new Object();
            first = inc(first);
            return out;
        }
    }

    @Override
    public int size() {
        return (maxSize - first + last) % maxSize;
    }

    @Override
    public boolean empty() {
        return first == last;
    }

    private int inc(int n){
        return (n+1) % maxSize;
    }

    public String toString(){
        String out = (String) queue[0];
        for(int i = 1; i < size(); i++){
            out += ", " + queue[i];
        }
        return out;
    }
}
