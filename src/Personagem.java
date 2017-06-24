

public class Personagem {
	private String itemMao = "Vazio";
	private int localizacao;
	private String objetoProx;
	
	//public Personagem(){};
	
	public Personagem(int localizacao) {
		this.localizacao = localizacao;
	}


	
	public String getObjetoProx() {
		return objetoProx;
	}

	public void setObjetoProx(String objetoProx) {
		this.objetoProx = objetoProx;
	}

	public int getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(int localizacao) {
		this.localizacao = localizacao;
	}

	public String getItemMao() {
		return itemMao;
	}

	public void setItemMao(String itemMao) {
		this.itemMao = itemMao;
	}
}
