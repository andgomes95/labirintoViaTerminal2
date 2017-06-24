package pratico.trabalho;

public class Sala {
	private int[] conjuntoPortas; //Quais portas do vetor portas/ambiente tem nessa sala.
	private int numero; //nome
	private Dinheiro dinheiroSala;
	private Utilitario utilitariosSala;
	
	public int[] getConjuntoPortas() {
		return conjuntoPortas;
	}
	public void setConjuntoPortas(int[] conjuntoPortas) {
		this.conjuntoPortas = conjuntoPortas;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public Dinheiro getDinheiroSala() {
		return dinheiroSala;
	}
	public void setDinheiroSala(Dinheiro dinheiroSala) {
		this.dinheiroSala = dinheiroSala;
	}
	public Utilitario getUtilitariosSala() {
		return utilitariosSala;
	}
	public void setUtilitariosSala(Utilitario utilitariosSala) {
		this.utilitariosSala = utilitariosSala;
	}
}
