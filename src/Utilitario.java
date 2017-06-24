package pratico.trabalho;

public class Utilitario {
	private int chave;
	private int pocaoMagica;
	private int machado;
	
	public Utilitario(){
		this.chave = 0;
		this.pocaoMagica = 0;
		this.machado = 0;
	}
	
	public Utilitario(int chave, int pocaoMagica, int machado) {
		this.chave = chave;
		this.pocaoMagica = pocaoMagica;
		this.machado = machado;
	}
	
	public int getChave() {
		return chave;
	}
	public void setChave(int chave) {
		this.chave = chave;
	}
	public int getPocaoMagica() {
		return pocaoMagica;
	}
	public void setPocaoMagica(int pocaoMagica) {
		this.pocaoMagica = pocaoMagica;
	}
	public int getMachado() {
		return machado;
	}
	public void setMachado(int machado) {
		this.machado = machado;
	}
	public String toString(){
		return String.format("Inventario\nChave %d,Pocao %d,Machado %d",this.chave,this.pocaoMagica,this.machado);
	}
}
