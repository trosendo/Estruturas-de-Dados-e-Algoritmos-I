public class Tester {
    public static void main(String[] args){
        LinHashTable<Integer> hashTable = new LinHashTable<Integer>() {
            @Override
            protected int procPos(Integer s) {
                int i = 0;
                boolean visited = false;
                int ativos = 0;
                int indexToInsert = 0;
                Elemento<Integer> elemento = new Elemento<>(s);
                int index = s % super.arr.length;

                while(!super.arr[(index + i) % super.arr.length].equals(elemento) && ativos != super.nElementos) {
                    if (super.arr[(index + i) % super.arr.length].isAtivo())
                        ativos++;
                    else if (!visited) {
                        indexToInsert = (index + i) % super.arr.length;
                        visited = true;
                    }
                    i++;
                }
                if(super.arr[(index + i) % super.arr.length].equals(elemento))
                    return (index + i) % super.arr.length;
                else
                    return indexToInsert;
            }
        };

        hashTable.insere(1);
        hashTable.insere(15);
        hashTable.insere(50);
        hashTable.insere(68);
        hashTable.insere(789);
        hashTable.insere(56);
        hashTable.print();
    }
}
