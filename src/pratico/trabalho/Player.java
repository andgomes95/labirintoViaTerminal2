package pratico.trabalho;

public class Player extends Personagem{
	private String nome;
	private Inventario inventario;
	private Dinheiro dinheiroAtual;

	public Player(int localizacao, String nome, Inventario inventario, Dinheiro dinheiroAtual) {
		super(localizacao);
		this.nome = nome;
		this.inventario = inventario;
		this.dinheiroAtual = dinheiroAtual;
	}

	public Player() {
		super(0);
		this.inventario = new Inventario();
		this.dinheiroAtual = new Dinheiro();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Inventario getInventario() {
		return inventario;
	}

	public void setInventario(Inventario inventario) {
		this.inventario = inventario;
	}

	public Dinheiro getDinheiroAtual() {
		return dinheiroAtual;
	}

	public void setDinheiroAtual(Dinheiro dinheiroAtual) {
		this.dinheiroAtual = dinheiroAtual;
	}
}
