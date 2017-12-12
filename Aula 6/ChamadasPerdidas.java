public class ChamadasPerdidas{
	QueueArray<Numero> chamadasPerdidas;

	ChamadasPerdidas(){
		chamadasPerdidas = new QueueArray<>(50);
	}

	boolean contains(Numero numero){
		QueueArray<Numero> temp = new QueueArray<>(chamadasPerdidas.size());
		boolean found = false;
		while(!chamadasPerdidas.empty()){
			Numero tempN = chamadasPerdidas.dequeue();
			if(tempN.getNumero.equals(numero)){
				tempN.addCall();
				found = true;
			}
			temp.enqueue(tempN);
		}
		while(!temp.empty()){
			chamadasPerdidas.enqueue(temp.dequeue());
		}
		return found;
	}

	void newCall(String numero){
		chamadasPerdidas.enqueue(new Numero(numero));
	}
}