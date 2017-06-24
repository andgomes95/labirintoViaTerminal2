import java.util.ArrayList;
import java.util.Random;

public class Troll extends Personagem{
	boolean status = true; //true vivo/false morto
	int identificacao;
	private ArrayList<Machado> machadoTroll = new ArrayList<>();
	private boolean temaxe;

	
	public boolean isTemaxe() {
		return temaxe;
	}
	public void setTemaxe(boolean temaxe) {
		this.temaxe = temaxe;
	}
	public Troll() {
		super(0);
		this.machadoTroll = new ArrayList<Machado>();
	}
	public Troll(int localizacao,int identificacao, Boolean temtroll) {
		super(localizacao);
		this.identificacao = identificacao;
		this.temaxe = temtroll;
	}
	public Troll(int localizacao,int identificacao, ArrayList<Machado> machadoTroll) {
		super(localizacao);
		this.identificacao = identificacao;
		this.machadoTroll = machadoTroll;
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
	
	public ArrayList<Machado> getMachadoTroll() {
		return machadoTroll;
	}


	
	public void mover(Sala sala){
		int randomPortaDestino;
		Random rand = new Random();
		int destino;
		randomPortaDestino = rand.nextInt(sala.getPortas().size());
		//System.out.println("RANDOM PORTA DESTINO: " + randomPortaDestino);
		if(sala.getPortas().get(randomPortaDestino).getSala1() != getLocalizacao()){
			destino = sala.getPortas().get(randomPortaDestino).getSala1();
			setLocalizacao(destino);
		}
		else{
			destino = sala.getPortas().get(randomPortaDestino).getSala2();
			setLocalizacao(destino);
		}
	}
	
}
