import java.util.ArrayList;

public class Player extends Personagem {
	private String nome;
	private Gold dinheiroAtual;
	private Diamante diamanteAtual;
	private ArrayList<Machado> machadoPlayer;
	private Pocao pocaoPlayer;
	private Chave chavePlayer;
	private int qtdItens = 0;
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
	
	public int getQtdItens() {
		return qtdItens;
	}

	public void setQtdItens(int qtdItens) {
		this.qtdItens = qtdItens;
	}

	public Player(int localizacao, String nome,Gold dinheiroAtual, Diamante diamanteAtual, ArrayList<Machado> machadoPlayer, Pocao pocaoPlayer, Chave chavePlayer) {
		super(localizacao);
		this.nome = nome;
		this.dinheiroAtual = dinheiroAtual;
		this.diamanteAtual = diamanteAtual;
		this.machadoPlayer = machadoPlayer;
		this.pocaoPlayer = pocaoPlayer;
		this.chavePlayer = chavePlayer;
	}

	public Player() {
		super(0);
		this.dinheiroAtual = new Gold();
		this.diamanteAtual = new Diamante();
		this.machadoPlayer = new ArrayList<Machado>();
		this.pocaoPlayer = new Pocao();
		this.chavePlayer = new Chave();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Gold getDinheiroAtual() {
		return dinheiroAtual;
	}

	public void setDinheiroAtual(Gold dinheiroAtual) {
		this.dinheiroAtual = dinheiroAtual;
	}
	public Diamante getDiamanteAtual() {
		return diamanteAtual;
	}

	public void setDiamanteAtual(Diamante diamanteAtual) {
		this.diamanteAtual = diamanteAtual;
	}
	
	public ArrayList<Machado> getMachadoPlayer() {
		return machadoPlayer;
	}

	public Pocao getPocaoPlayer(){
		return pocaoPlayer;
	}
	public void setPocaoPlauer(Pocao pocaoPlayer){
		this.pocaoPlayer = pocaoPlayer;
	}
	public Chave getChavePlayer() {
		return chavePlayer;
	}

	public void setChavePlayer(Chave chavePlayer) {
		this.chavePlayer = chavePlayer;
	}
	
	 public boolean mandarMachado(Sala sala, String comando) {
		int identificacaoTroll = Integer.parseInt(comando.substring(comando.indexOf(" ") + 1));
        if (getMachadoPlayer().size() > 0) {
			for (int i = 0; sala.getTrolls().size() > i; i++) {
				if(sala.getTrolls().get(i).getIdentificacao() == identificacaoTroll){
		            if(getMachadoPlayer().get(0).getDurabilidade() == 1){
		            	getMachadoPlayer().remove(0);
		            }else{
		            	getMachadoPlayer().get(0).setDurabilidade(getMachadoPlayer().get(0).getDurabilidade() - 1);
		            }
		            System.out.println("Mandou machado");
		            sala.getTrolls().remove(i);
		            System.out.println("AA" + sala.getTrolls().size());
		            setQtdItens(getQtdItens() - 1);
				}
	            return true;
			}
        }
        return false;
    }


	void sairSala(Sala sala) {
		String destinoSala = getObjetoProx();
		switch (destinoSala) {
		case "A":
			for (int i = 0; i < sala.getPortas().size(); i++) {
				if (sala.getPortas().get(i).getNome1() == 'A'
						&& sala.getPortas().get(i).getSala1() == getLocalizacao()) {
					if (sala.getPortas().get(i).isStatus() == true) {
						sala.setPersonagem(false);
						setLocalizacao(sala.getPortas().get(i).getSala2());

					} else {
						System.out.println("PORTA TRANCADA");
					}

					break;
				} else if (sala.getPortas().get(i).getNome2() == 'A'
						&& sala.getPortas().get(i).getSala2() == getLocalizacao()) {
					if (sala.getPortas().get(i).isStatus() == true) {
						sala.setPersonagem(false);
						setLocalizacao(sala.getPortas().get(i).getSala1());
					} else {
						System.out.println("PORTA TRANCADA");
					}

					break;
				}
			}
			break;
		case "B":
			for (int i = 0; i < sala.getPortas().size(); i++) {

				if (sala.getPortas().get(i).getNome1() == 'B'
						&& sala.getPortas().get(i).getSala1() == getLocalizacao()) {
					if (sala.getPortas().get(i).isStatus() == true) {
						sala.setPersonagem(false);
						setLocalizacao(sala.getPortas().get(i).getSala2());
					} else {
						System.out.println("PORTA TRANCADA");
					}

					break;
				} else if (sala.getPortas().get(i).getNome2() == 'B'
						&& sala.getPortas().get(i).getSala2() == getLocalizacao()) {
					if (sala.getPortas().get(i).isStatus() == true) {
						sala.setPersonagem(false);
						setLocalizacao(sala.getPortas().get(i).getSala1());
					} else {
						System.out.println("PORTA TRANCADA");
					}
					break;
				}
			}
			break;
		case "C":
			for (int i = 0; i < sala.getPortas().size(); i++) {

				if (sala.getPortas().get(i).getNome1() == 'C'
						&& sala.getPortas().get(i).getSala1() == getLocalizacao()) {
					if (sala.getPortas().get(i).isStatus() == true) {
						sala.setPersonagem(false);
						setLocalizacao(sala.getPortas().get(i).getSala2());
					} else {
						System.out.println("PORTA TRANCADA");
					}

					break;
				} else if (sala.getPortas().get(i).getNome2() == 'C'
						&& sala.getPortas().get(i).getSala2() == getLocalizacao()) {
					if (sala.getPortas().get(i).isStatus() == true) {
						sala.setPersonagem(false);
						setLocalizacao(sala.getPortas().get(i).getSala1());
					} else {
						System.out.println("PORTA TRANCADA");
					}

					break;
				}
			}
			break;
		}
	}

	public void pegarItens(Sala sala, String comando) {
		String itemDesejado = comando.substring(comando.indexOf(" ") + 1);
		int qtdAtual = getQtdItens();
		switch (itemDesejado) {
		case "gold":
			if (sala.getTrolls().size() == 0) {
				if (getObjetoProx().equals("Gold")) {
					if (sala.getGoldSala().get(0).getGold() != 0) {
						getDinheiroAtual()
								.setGold(getDinheiroAtual().getGold() + sala.getGoldSala().get(0).getGold());
						sala.getGoldSala().get(0).setGold(0);
						System.out.println("PEGOU GOLD");
					} else {
						System.out.println("Nao ha gold na sala");
					}
				}
			} else {
				System.out.println("AINDA HA TROLL NA SALA");
			}
			break;
		case "diamond":
			if (sala.getTrolls().size() == 0) {
				if (getObjetoProx().equals("Diamante")) {
					if (sala.getDiamanteSala().get(0).getDiamante() != 0) {
						System.out.println("S: " + sala.getDiamanteSala().get(0).getDiamante());
						System.out.println("P: " + getDiamanteAtual().getDiamante());
						getDiamanteAtual().setDiamante(
								getDiamanteAtual().getDiamante() + sala.getDiamanteSala().get(0).getDiamante());
						sala.getDiamanteSala().get(0).setDiamante(0);
						System.out.println("PEGOU DIAMANTE");
					} else {
						System.out.println("Nao ha diamante na sala");
					}
				}
			} else {
				System.out.println("AINDA H� TROLL NA SALA");
			}
			break;
		}

		if (getQtdItens() < 10) {
			switch (itemDesejado) {
			case "axe":
				if (getMachadoPlayer().size() < 4) {
					if (getObjetoProx().equals("Machado") && sala.getMachados().size() > 0) {
						sala.verificaTiposMachado();
						if(sala.getMachadoOuro() != 50){
							getMachadoPlayer().add(new Temouro());
							sala.getMachados().remove(sala.getMachadoOuro());
						}else if(sala.getMachadoBronze() != 50){
							getMachadoPlayer().add(new Tembronze());
							sala.getMachados().remove(sala.getMachadoBronze());
						}else{
							getMachadoPlayer().add(new Temferro());
							sala.getMachados().remove(sala.getMachadoFerro());
						}
						setQtdItens(qtdAtual + 1);
						System.out.println("PEGOU MACHADO");
					} else {
						System.out.println("nao possui machado na sala.");
					}
				} else {
					System.out.println("Inventario de machado cheio.");
				}
				break;
			case "potion":
				if (getPocaoPlayer().getPocaoMagica() < 3) {
					if (getObjetoProx().equals("Pocao") && sala.getPocaoSala().get(0).getPocaoMagica() > 0) {
						int pocaoSala = sala.getPocaoSala().get(0).getPocaoMagica();
						getPocaoPlayer().setPocaoMagica(getPocaoPlayer().getPocaoMagica() + 1);
						sala.getPocaoSala().get(0).setPocaoMagica(pocaoSala - 1);
						setQtdItens(qtdAtual + 1);
						System.out.println("PEGOU POCAO");
					} else {
						System.out.println("nao possui pocao na sala.");
					}
				} else {
					System.out.println("Inventario de pocao cheio.");
				}
				break;
			case "key":
				if (getChavePlayer().getChave() < 3) {
					if (getObjetoProx().equals("Chave") && sala.getChaveSala().get(0).getChave() > 0) {
						int chaveSala = sala.getChaveSala().get(0).getChave();
						getChavePlayer().setChave(getChavePlayer().getChave() + 1);
						sala.getChaveSala().get(0).setChave(chaveSala - 1);
						setQtdItens(qtdAtual + 1);
						System.out.println("PEGOU CHAVE");
					} else {
						System.out.println("nao possui chave na sala.");
					}
				} else {
					System.out.println("Inventario de chave cheio");
				}
				break;
			}
		} else {
			System.out.println("Inventario Cheio");
		}
	}

	public void soltarItens(Sala sala, String comando) {
		String destinoMovimento = comando.substring(comando.indexOf(" ") + 1);
		int qtdAtual = getQtdItens();
		switch (destinoMovimento) {
		case "gold":
			if (sala.getTrolls().size() == 0) {
				if (getDinheiroAtual().getGold() != 0) {
					sala.getGoldSala().get(0).setGold(getDinheiroAtual().getGold());
					getDinheiroAtual().setGold(0);
					System.out.println("Dropou gold");
				} else {
					System.out.println("Nao ha gold na bag");
				}
			} else {
				System.out.println("AINDA H� TROLL NA SALA");
			}
			break;
		case "diamond":
			if (sala.getTrolls().size() == 0) {
				if (getDiamanteAtual().getDiamante() != 0) {
					sala.getDiamanteSala().get(0).setDiamante(getDiamanteAtual().getDiamante());
					getDiamanteAtual().setDiamante(0);
					System.out.println("Dropou diamante");
				} else {
					System.out.println("Nao ha diamante na bag");
				}
			} else {
				System.out.println("AINDA H� TROLL NA SALA");
			}
			break;
		}
		if (getQtdItens() >= 0) {
			switch (destinoMovimento) {
			case "axe":
				if (getObjetoProx().equals("Machado")) {
					verificaBaga();
					if(getMachadoFerro() != 50){
						int disp = getMachadoPlayer().get(getMachadoFerro()).getDurabilidade();
						sala.getMachados().add(new Temferro(disp));
						getMachadoPlayer().remove(getMachadoFerro());
					}else if(getMachadoBronze() != 50){
						int disp = getMachadoPlayer().get(getMachadoBronze()).getDurabilidade();
						sala.getMachados().add(new Tembronze(disp));
						getMachadoPlayer().remove(getMachadoBronze());
					}else{
						int disp = getMachadoPlayer().get(getMachadoOuro()).getDurabilidade();
						sala.getMachados().add(new Temouro(disp));
						getMachadoPlayer().remove(getMachadoOuro());
					}
					//getMachadoPlayer().add(new Temferro());
					//getMachadoPlayer().remove(sala.getMachadoFerro());
					setQtdItens(qtdAtual - 1);
				}
				break;
			case "potion":
				if (getObjetoProx().equals("Pocao")) {
					getPocaoPlayer().setPocaoMagica(getPocaoPlayer().getPocaoMagica() - 1);
					sala.getPocaoSala().get(0).setPocaoMagica(sala.getPocaoSala().get(0).getPocaoMagica() + 1);
					setQtdItens(qtdAtual - 1);
				}
				break;
			case "key":
				if (getObjetoProx().equals("Chave")) {
					getChavePlayer().setChave(getChavePlayer().getChave() - 1);
					sala.getChaveSala().get(0).setChave(sala.getChaveSala().get(0).getChave() + 1);
					setQtdItens(qtdAtual - 1);
				}
				break;
			}
		} else {
			System.out.println("Inventario Cheio");
		}
	}

	public void sobAtaque(Sala sala) {
		if (getPocaoPlayer().getPocaoMagica() != 0) {
			System.out.println("LEVOU O ATAQUE MAS TINHA POCAO");
			getPocaoPlayer().setPocaoMagica(getPocaoPlayer().getPocaoMagica() - 1);
			System.out.println("Ainda restam de pocoes: " + getPocaoPlayer().getPocaoMagica());
		} else {
			getDiamanteAtual().setDiamante(0);
			getDinheiroAtual().setGold(0);
			System.out.println("Perdeu todo gold e diamante");
		}
	}

	public void unlockDoor(Sala sala) {
		String destinounlock = getObjetoProx();
		if (getChavePlayer().getChave() != 0) {
			switch (destinounlock) {
			case "A":
				for (int i = 0; i < sala.getPortas().size(); i++) {
					if (sala.getPortas().get(i).getNome1() == 'A'
							&& sala.getPortas().get(i).getSala1() == getLocalizacao()) {
						System.out.println("status salas: " + sala.getPortas().get(i).isStatus());
						if (sala.getPortas().get(i).isStatus() == false) {
							sala.getPortas().get(i).setStatus(true);
							getChavePlayer().setChave(getChavePlayer().getChave() - 1);
							System.out.println("A: " + sala.getPortas().get(i).isStatus());
							System.out.println("Porta destrancada.");
						} else {
							System.out.println("BB: " + sala.getPortas().get(i).isStatus());

							System.out.println("Voce nao possui chave.");
						}

						break;
					} else if (sala.getPortas().get(i).getNome2() == 'A'
							&& sala.getPortas().get(i).getSala2() == getLocalizacao()) {
						System.out.println("status salas: " + sala.getPortas().get(i).isStatus());
						if (sala.getPortas().get(i).isStatus() == false) {
							sala.getPortas().get(i).setStatus(true);
							getChavePlayer().setChave(getChavePlayer().getChave() - 1);
							System.out.println("Porta destrancada.");
						} else {
							System.out.println("Voce nao possui chave.");
						}

						break;
					}
				}
				break;

			case "B":
				for (int i = 0; i < sala.getPortas().size(); i++) {
					if (sala.getPortas().get(i).getNome1() == 'B'
							&& sala.getPortas().get(i).getSala1() == getLocalizacao()) {
						if (sala.getPortas().get(i).isStatus() == false) {
							sala.getPortas().get(i).setStatus(true);
							getChavePlayer().setChave(getChavePlayer().getChave() - 1);
							System.out.println("Porta destrancada.");
						} else {
							System.out.println("Voce nao possui chave.");
						}

						break;
					} else if (sala.getPortas().get(i).getNome2() == 'B'
							&& sala.getPortas().get(i).getSala2() == getLocalizacao()) {
						if (sala.getPortas().get(i).isStatus() == false) {
							sala.getPortas().get(i).setStatus(true);
							getChavePlayer().setChave(getChavePlayer().getChave() - 1);
							System.out.println("Porta destrancada.");
						} else {
							System.out.println("Voce nao possui chave.");
						}
						break;
					}
				}
				break;

			case "C":
				for (int i = 0; i < sala.getPortas().size(); i++) {
					if (sala.getPortas().get(i).getNome1() == 'C'
							&& sala.getPortas().get(i).getSala1() == getLocalizacao()) {
						if (sala.getPortas().get(i).isStatus() == false) {
							sala.getPortas().get(i).setStatus(true);
							getChavePlayer().setChave(getChavePlayer().getChave() - 1);
							System.out.println("Porta destrancada.");
						} else {
							System.out.println("Voce nao possui chave.");
						}

						break;
					} else if (sala.getPortas().get(i).getNome2() == 'C'
							&& sala.getPortas().get(i).getSala2() == getLocalizacao()) {
						if (sala.getPortas().get(i).isStatus() == false) {
							sala.getPortas().get(i).setStatus(true);
							getChavePlayer().setChave(getChavePlayer().getChave() - 1);
							System.out.println("Porta destrancada.");
						} else {
							System.out.println("Voce nao possui chave.");
						}

						break;
					}
				}
				break;

			}

		}
	}
	public void printMochila(){
        System.out.println(getNome()+" possui os seguintes itens na sua mochila:");
        System.out.println("Ouro: "+getDinheiroAtual().getGold()
                            +" Diamante: "+getDiamanteAtual().getDiamante()
                            +" Machado: "+getMachadoPlayer().size()
                            +" Chave: "+getChavePlayer().getChave()
                            +" Poção: "+getPocaoPlayer().getPocaoMagica());
    }
	
	public void verificaBaga(){
		setMachadoOuro(50);
		setMachadoBronze(50);
		setMachadoFerro(50);
		for(int i = 0; i< getMachadoPlayer().size(); i++){
			if(getMachadoPlayer().get(i).getMachadoTipo().equals("Ouro")){
				setMachadoOuro(i);
			}else if(getMachadoPlayer().get(i).getMachadoTipo().equals("Bronze")){
				setMachadoBronze(i);
			}else{
				setMachadoFerro(i);
			}
		}
	}
}
