public class Numero{
	int nchamadas;
	String numero;

	Numero(String numero){
		this.numero = numero;
		nchamadas = 0;
	}

	void addCall(){
		nchamadas++;
	}

	String getNumero(){
		return numero;
	}
}