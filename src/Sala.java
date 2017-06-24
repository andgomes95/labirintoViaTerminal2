import java.util.ArrayList;

public class Sala {
	private int[] conjuntoPortas; // Quais portas do vetor portas/ambiente tem
									// nessa sala.
	private int numero; // nome
	private ArrayList<Diamante> diamanteSala = new ArrayList<Diamante>();
	private ArrayList<Porta> portas = new ArrayList<Porta>();
	private ArrayList<Troll> trolls = new ArrayList<Troll>();
	private ArrayList<Gold> goldSala = new ArrayList<>();
	private ArrayList<Machado> machadoSala = new ArrayList<>();
	private ArrayList<Pocao> pocaoSala = new ArrayList<>();
	private ArrayList<Chave> chaveSala = new ArrayList<>();
	private boolean isPersonagem;
	private boolean isAction;
	private int machadoOuro;
	private int machadoBronze;
	private int machadoFerro;

	

	public int getMachadoOuro() {
		return machadoOuro;
	}

	public void setMachadoOuro(int machadoOuro) {
		this.machadoOuro = machadoOuro;
	}

	public int getMachadoBronze() {
		return machadoBronze;
	}

	public void setMachadoBronze(int machadoBronze) {
		this.machadoBronze = machadoBronze;
	}

	public int getMachadoFerro() {
		return machadoFerro;
	}

	public void setMachadoFerro(int machadoFerro) {
		this.machadoFerro = machadoFerro;
	}

	public boolean isAction() {
		return isAction;
	}

	public void setAction(boolean isAction) {
		this.isAction = isAction;
	}

	public ArrayList<Porta> getPortas() {
		return portas;
	}

	public boolean isPersonagem() {
		return isPersonagem;
	}

	public void setPersonagem(boolean isPersonagem) {
		this.isPersonagem = isPersonagem;
	}

	public ArrayList<Troll> getTrolls() {
		return trolls;
	}

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

	public ArrayList<Diamante> getDiamanteSala() {
		return diamanteSala;
	}
	
	public ArrayList<Machado> getMachados(){
		return machadoSala;
	}
	public ArrayList<Gold> getGoldSala(){
		return goldSala;
	}
	public ArrayList<Pocao> getPocaoSala(){
		return pocaoSala;
	}
	public ArrayList<Chave> getChaveSala(){
		return chaveSala;
	}


	void view() {
		System.out.println("Gold na Sala " + goldSala.get(0).getGold());
		System.out.println("Diamante na Sala " + diamanteSala.get(0).getDiamante());
		System.out.println("Pocoes na Sala " + pocaoSala.get(0).getPocaoMagica());
		if(machadoSala.size() != 0){
			nomesAxe();
		}else{
			System.out.println("Nenhum Machado na Sala");
		}
		System.out.println("Chaves na Sala " + getChaveSala().get(0).getChave());
		if(getTrolls().size() != 0){
			nomeTrolls();
		}else{
			System.out.println("Não tem troll na sala");
		}
		System.out.println("Portas na Sala " + getConjuntoPortas().length);

	}
	public Sala(int numero) {
		this.numero = numero;
	}
	public void verificaTiposMachado(){
		setMachadoOuro(50);
		setMachadoBronze(50);
		setMachadoFerro(50);
		for(int i = 0; i< machadoSala.size(); i++){
			if(getMachados().get(i).getMachadoTipo().equals("Ouro")){
				setMachadoOuro(i);
			}else if(getMachados().get(i).getMachadoTipo().equals("Bronze")){
				setMachadoBronze(i);
			}else{
				setMachadoFerro(i);
			}
		}
	}
	public void nomeTrolls(){
		for (int i = 0; i< getTrolls().size(); i++){
			System.out.println("O Troll está na sala: " + getTrolls().get(i).getIdentificacao());
		}
	}
	public void nomesAxe(){
		for (int i = 0; i< machadoSala.size(); i++){
			System.out.println("Machados na Sala " + machadoSala.get(i).getMachadoTipo());
		}
	}
}
