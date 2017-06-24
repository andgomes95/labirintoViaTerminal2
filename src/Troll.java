package pratico.trabalho;

public class Troll extends Personagem{
	boolean status = true; //true vivo/false morto
	int identificacao;
	
	public Troll() {
		super();
	}

	public Troll(int localizacao,int identificacao) {
		super(localizacao);
		this.identificacao = identificacao;
	}


	public int getIdentificacao() {
		return identificacao;
	}

	public void setIdentificacao(int identificacao) {
		this.identificacao = identificacao;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
