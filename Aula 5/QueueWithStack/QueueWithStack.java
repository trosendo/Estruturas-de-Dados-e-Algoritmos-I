public class QueueWithStack<E> {
    int maxSize = 0;
    E[] array;
    int first = 0;
    int last = 0;

    public QueueWithStack(){
        array = new E[20];
        maxSize = 20;
    }

    public QueueWithStack(int n){
        array = new E[n];
        maxSize = n;
    }

    public void enqueue(E x) throws OverFlowException{
        if(size() == nElements - 1){
        	throw OverFlowException;
        }
        array[last] = x;
        fim = inc(last);
    }

    public E dequeue() throws EmptyException{
    	if(empty()){
    		throw EmptyException;
    	}
    	E x = array[first];
    	array[first] = null;
    	inc(first);
    	return x;
    }

    public int inc(int i){
    	return (i + 1) / maxSize;
    }

    public int size(){
    	return (maxSize - first + last) / maxSize;
    }

    public boolean empty(){
    	return first==last;
    }
}
