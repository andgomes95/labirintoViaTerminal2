public class Porta {
	private char nome1;
	private char nome2;
	private int sala1;
	private int sala2;
	private boolean status; // true-aberta/false-fechada
	private boolean feitico = true; // false-trancada por feiti�o/true-n
									// enfeiti�ada

	public Porta() {
	}

	public Porta(char nome1, char nome2, int sala1, int sala2, boolean status) {
		this.nome1 = nome1;
		this.nome2 = nome2;
		this.sala1 = sala1;
		this.sala2 = sala2;
		this.status = status;
	}

	public boolean isFeitico() {
		return feitico;
	}

	public void setFeitico(boolean feitico) {
		this.feitico = feitico;
	}

	public char getNome1() {
		return nome1;
	}

	public void setNome1(char nome1) {
		this.nome1 = nome1;
	}

	public char getNome2() {
		return nome2;
	}

	public void setNome2(char nome2) {
		this.nome2 = nome2;
	}

	public int getSala1() {
		return sala1;
	}

	public void setSala1(int sala1) {
		this.sala1 = sala1;
	}

	public int getSala2() {
		return sala2;
	}

	public void setSala2(int sala2) {
		this.sala2 = sala2;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}
}
