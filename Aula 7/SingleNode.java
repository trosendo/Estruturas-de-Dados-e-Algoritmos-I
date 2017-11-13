public class SingleNode<T> {
    T element;
    SingleNode<T> next;

    //construtor
    public SingleNode(T x){
        element=x;
        next=null;
    }

    //construtor vazio
    public SingleNode(){
        this(null);
    }

    //construtor com elemento e next
    public SingleNode(T x, SingleNode<T> n){
        element= x;
        next=n;
    }

    public T element(){
        return element;
    }

    public SingleNode<T> getNext(){
        return next;
    }

    public void setElement(T x){
        element=x;
    }

    public void setNext(SingleNode<T> n){
        next=n;
    }
}
