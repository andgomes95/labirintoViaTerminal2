package pratico.trabalho;

public class Dinheiro {
	private int gold;
	private int diamante;
	
	public Dinheiro(){
		this.gold = 0;
		this.diamante = 0;
	}
	
	public Dinheiro(int gold, int diamante) {
		this.gold = gold;
		this.diamante = diamante;
	}
	public int getGold() {
		return gold;
	}
	public void setGold(int gold) {
		this.gold = gold;
	}
	public int getDiamante() {
		return diamante;
	}
	public void setDiamante(int diamante) {
		this.diamante = diamante;
	}
	
}
