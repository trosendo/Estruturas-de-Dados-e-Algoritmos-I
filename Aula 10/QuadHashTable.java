public abstract class QuadHashTable<T> extends HashTable<T> {
    public abstract int ocupados();
    public abstract float fatorCarga();
    protected abstract int procPos(T s);
    public abstract void alocarTabela(int dim);
    public abstract void tornarVazia();
    public abstract T procurar(T x);
    public abstract void remove(T x);
    public abstract void insere (T x);
    public abstract void rehash();
    public abstract void print();
}
