public abstract class LinHashTable<T> extends HashTable<T> {

    public LinHashTable() {
        super();
    }

    public LinHashTable(int n) {
        super(n);
    }

    public int ocupados(){
        return super.ocupados();
    }
    public float fatorCarga(){
        return super.fatorCarga();
    }

    protected abstract int procPos(T s);

    public void alocarTabela(int dim){
        super.alocarTabela(dim);
    }
    public void tornarVazia(){
        super.tornarVazia();
    }
    public T procurar(T x){
        return super.procurar(x);
    }
    public void remove(T x){
        super.remove(x);
    }
    public void insere (T x){
        super.insere(x);
    }
    public void rehash(){
        super.rehash();
    }
    public void print(){
        super.print();
    }


}