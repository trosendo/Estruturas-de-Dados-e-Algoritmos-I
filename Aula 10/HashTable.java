public abstract class HashTable<T> {

    Elemento<T>[] arr;
    int nElementos;

    public HashTable() {
        alocarTabela(23);
        nElementos = 0;
    }

    public HashTable(int n) {
        alocarTabela(n);
        nElementos = 0;
    }


    public int ocupados() {
        return nElementos;
    }

    public float fatorCarga() {
        return ((float) nElementos / (float) arr.length);
    }

    protected abstract int procPos(T s);    //retornará a posição em que s será inserido ou se s existe a sua localização na tabela

    public void alocarTabela(int dim) {     //uma nova tabela de dimensão especificada
        arr = new Elemento[dim];
        nElementos = 0;
    }

    public void tornarVazia(){              //esvazia a tabela em uso;
        alocarTabela(arr.length);
    }

    public T procurar(T x) {                //retorna o elemento que esta na tabela , se x não está lá retorna null
        int index = procPos(x);
        if(arr[index].getElemento().equals(x) && arr[index].isAtivo())
            return x;
        else
            return null;
    }

    public void remove(T x) {
        if(!procurar(x).equals(null)) {
            arr[procPos(x)].remove();
            nElementos--;
        }
    }

    public void insere(T x) {
        arr[procPos(x)] = new Elemento<>(x);
        nElementos++;
        if(fatorCarga() >= 0.5)
            rehash();
    }

    public void rehash() {
        int dim = getPrime(arr.length * 2);
        Elemento<T>[] arrTemp1 = new Elemento[dim];
        int c = 0;
        while(c < arr.length){
            if(arr[c].isAtivo())
                arrTemp1[c] = arr[c];
            c++;
        }
        alocarTabela(dim);
        while(c >= 0){
            if(arrTemp1[c].isAtivo())
                insere(arrTemp1[c].getElemento());
        }

    }

    public void print() {
        System.out.println("Index||Object||Active");
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%-5d||%s||%s", i, arr[i], arr[i].isAtivo());
        }
    }

    private int getPrime(int min){
        while(true){
            int c = 0;
            for(int i = 1; i <= min; i++){
                if(c > 2)
                    break;
                if(min % i == 0){
                    c++;
                }
            }
            if(c == 2)
                return min;
            min++;
        }
    }
}
