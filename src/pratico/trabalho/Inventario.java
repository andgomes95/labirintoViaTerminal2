package pratico.trabalho;

public class Inventario {
	int qtdItens = 0;
	Utilitario itens;
	
	public Inventario(){
		this.itens = new Utilitario();
	}
	
	public int getQtdItens() {
		return qtdItens;
	}
	public void setQtdItens(int qtdItens) {
		this.qtdItens = qtdItens;
	}
	public Utilitario getItens() {
		return itens;
	}
	public void setItens(Utilitario itens) {
		this.itens = itens;
	}
	public String toString(){
		return this.itens.toString();
	}
}
