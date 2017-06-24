package pratico.trabalho;

import java.util.ArrayList;
import java.util.Random;
import java.util.concurrent.SynchronousQueue;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class Ambiente {
	private Porta[] portas = new Porta[21];
	private Sala[] salas = new Sala[21];
	ArrayList<Troll> trolls = new ArrayList<>();
	private int qtdOuro;
	private int qtdDiamante;
	
	Ambiente(){
		for (int i = 0; i < 21; i++){
			this.salas[i] = new Sala();
			this.portas[i] = new Porta();
		}
		this.configurarComodos();
		this.distribuirPecas();
	}
	
	public Porta[] getPortas() {
		return portas;
	}
	public void setPortas(Porta[] portas) {
		this.portas = portas;
	}
	public Sala[] getSalas() {
		return salas;
	}
	public void setSalas(Sala[] salas) {
		this.salas = salas;
	}
	public int getQtdOuro() {
		return qtdOuro;
	}
	public void setQtdOuro(int qtdOuro) {
		this.qtdOuro = qtdOuro;
	}
	public int getQtdDiamante() {
		return qtdDiamante;
	}
	public void setQtdDiamante(int qtdDiamante) {
		this.qtdDiamante = qtdDiamante;
	}
	
	public void distribuirPecas(){
		int qtdTotalGold = 0,qtdTotalDiamante = 0;
		int randomDiamante,randomGold;
		int randomPocao,randomChave,randomMachado;
		int randomTroll;
		int randomPorta;
		int identificacaoTroll = 0;
		int numeroPortasSala = 0;
		int[] indicePortasSala = new int[3];
		
		Dinheiro dinheiro = new Dinheiro();
		Utilitario utilitario = new Utilitario();
		Random rand = new Random();
		
		//Configurando salas
		for(int i = 0; i < 20; i++){
			//Configurando as portas de cada sala
			numeroPortasSala = 0;
			for(int k = 0; k < 21; k++){
				if((portas[k].getSala1() == i) ||(portas[k].getSala2() == i)){
					indicePortasSala[numeroPortasSala] = k;
					numeroPortasSala++;
				}
			}
			int[] conjuntoPortas = new int[numeroPortasSala];
			for(int k = 0; k < conjuntoPortas.length; k++){
				conjuntoPortas[k] = indicePortasSala[k];
			}
			this.salas[i].setConjuntoPortas(conjuntoPortas);
			randomDiamante = rand.nextInt(4); //Random para Diamante
			randomGold = rand.nextInt(6); //Random Para gold
			randomPocao = rand.nextInt(2); //Random Para poção
			randomChave = rand.nextInt(2); //Random Para chave
			randomMachado = rand.nextInt(3); //Random Para machado
			randomTroll = rand.nextInt(3); //Random Para Qtd Troll
			
			if(randomChave == 1){ //Se tem chave no ambiente uma porta aleatoria é trancada
				randomPorta = rand.nextInt(21);
				//System.out.println(randomPorta);
				if(portas[randomPorta].isStatus()){ //Tranca apenas se estiver aberta;
					/**função trancar porta**/
					portas[randomPorta].setStatus(false);
				}
			}
			
			//Atribuindo quantias
			dinheiro.setDiamante(randomDiamante);
			dinheiro.setGold(randomGold);
			salas[i].setDinheiroSala(dinheiro); 
			
			utilitario.setChave(randomChave);
			utilitario.setMachado(randomMachado);
			utilitario.setPocaoMagica(randomPocao);
			salas[i].setUtilitariosSala(utilitario);
			
			for(int j = 0; j < randomTroll; j++){
				this.trolls.add(new Troll(i,identificacaoTroll++));
			}
			
			//Calculando o a quantia de dinheiro total no jogo
			qtdTotalGold = qtdTotalGold + randomGold;
			qtdTotalDiamante = qtdTotalDiamante + randomDiamante;
		}
		this.qtdOuro = qtdTotalGold;
		this.qtdDiamante = qtdTotalDiamante;
	}
	
	public void configurarComodos(){
		int j = 0;
		//Porta[] portasTmp = new Porta[21];
		//Matrizes para atribuir valores as portas
		char[][] nomesPortas = {{'A','D'},{'A','A'},{'B','A'},{'B','A'},{'B','B'},{'A','A'},{'B','A'},
								{'A','B'},{'B','A'},{'C','A'},{'B','B'},{'B','B'},{'A','B'},{'A','B'},
								{'B','A'},{'B','B'},{'A','A'},{'A','A'},{'A','C'},{'B','B'},{'C','A'}};
		int[][] salaPortas = {{3,20},{0,5},{10,15},{0,1},{5,6},{10,11},
							  {15,16},{6,11},{1,2},{11,12},{16,17},{2,7},{7,12},
							  {17,18},{13,18},{3,4},{8,9},{13,14},{4,9},{9,14},{14,19}};
		
		//Atribuindo valores nas portas
		for(int i = 0; i < 21; i++){
			j = 0;
			this.portas[i].setNome1(nomesPortas[i][j]);
			this.portas[i].setSala1(salaPortas[i][j]);
			j = 1;
			this.portas[i].setNome2(nomesPortas[i][j]);
			this.portas[i].setSala2(salaPortas[i][j]);
		}
		//this.setPortas(portasTmp);
		return;
	}
	
	public ArrayList<Troll> retornarTrollsSala(int sala){
		ArrayList<Troll> trollsSala = new ArrayList<>();
		for(Troll b: this.trolls){
			if(b.getIdentificacao() == sala){
				trollsSala.add(b);  
			}
		}
		return trollsSala;
		
	}
	
	void moverTroll(){
		int salaAtual = 0;
		int randomPortaDestino;
		int[] portasAtual;
		Random rand = new Random();
		int destino;
		
		for(Troll b: this.trolls){
			salaAtual = b.getLocalizacao();
			portasAtual = this.salas[salaAtual].getConjuntoPortas();
			randomPortaDestino = rand.nextInt(portasAtual.length);
			if(this.portas[portasAtual[randomPortaDestino]].getSala1() != salaAtual){
				destino = this.portas[portasAtual[randomPortaDestino]].getSala1();
			}
			else{
				destino = this.portas[portasAtual[randomPortaDestino]].getSala2();
			}
			if((this.portas[portasAtual[randomPortaDestino]].isFeitico()) && (this.portas[portasAtual[randomPortaDestino]].isStatus())){
				b.setLocalizacao(destino);
			}
			int qtdMachado = this.salas[salaAtual].getUtilitariosSala().getMachado();
			if(qtdMachado > 0){
				if(b.getItemMao().equals("Vazio")){
					b.setItemMao("Machado");
					this.salas[salaAtual].getUtilitariosSala().setMachado(qtdMachado - 1);;
				}
			}
		}
	}
	
	void movePlayer(Player jogador, String comando){
		
		String destinoMovimento = comando.substring(comando.indexOf(" ") + 1);
		switch(destinoMovimento){
		case "A door":
			jogador.setObjetoProx("A");
			break;
		case "B door":
			jogador.setObjetoProx("B");
			break;
		case "C door":
			jogador.setObjetoProx("C");
			break;
		case "gold":
			jogador.setObjetoProx("Gold");
			break;
		case "diamante":
			jogador.setObjetoProx("Diamante");
			break;
		case "machado":
			jogador.setObjetoProx("Machado");
			break;
		case "pocao":
			jogador.setObjetoProx("Pocao");
			break;
		case "chave":
			jogador.setObjetoProx("Chave");
			break;
		default:
			break;
		}
	}
	
	void sairSala(Player jogador){
		int[] portasSala = this.salas[jogador.getLocalizacao()].getConjuntoPortas();
		
		String destinoSala = jogador.getObjetoProx();
		switch(destinoSala){
		case "A":
			for(int i = 0; i < portasSala.length; i++){
				 
				if(this.portas[portasSala[i]].getNome1() == 'A'){
					if(this.portas[portasSala[i]].isStatus()){
						jogador.setLocalizacao(this.portas[portasSala[i]].getSala2());
					}else{
						System.out.println("PORTA TRANCADA");
					}
					for(Troll b: this.trolls){
						if((b.getLocalizacao() == jogador.getLocalizacao()) && (b.getItemMao().equals("Machado"))){
							b.setItemMao("Vazio");
							if(jogador.getItemMao().equals("Pocao")){
								System.out.println("Levou ATAQUE E PERDEU POCAO");
								jogador.setItemMao("Vazio");
								jogador.getInventario().getItens().setPocaoMagica(jogador.getInventario().getItens().getPocaoMagica() - 1);
							}else{
								System.out.println("LEVOU ATAQUE E PERDEU GOLD");
								jogador.getDinheiroAtual().setGold(0);
							}
						}
					}
					break;
				}
				else if (this.portas[portasSala[i]].getNome2() == 'A'){
					if(this.portas[portasSala[i]].isStatus()){
						jogador.setLocalizacao(this.portas[portasSala[i]].getSala1());
					}else{
						System.out.println("PORTA TRANCADA");
					}
					for(Troll b: this.trolls){
						if((b.getLocalizacao() == jogador.getLocalizacao()) && (b.getItemMao().equals("Machado"))){
							b.setItemMao("Vazio");
							if(jogador.getItemMao().equals("Pocao")){
								System.out.println("Levou ATAQUE E PERDEU POCAO");
								jogador.setItemMao("Vazio");
								jogador.getInventario().getItens().setPocaoMagica(jogador.getInventario().getItens().getPocaoMagica() - 1);
							}else{
								System.out.println("LEVOU ATAQUE E PERDEU GOLD");
								jogador.getDinheiroAtual().setGold(0);
							}
						}
					}
					break;
				}
			}
			break;
		case "B":
			for(int i = 0; i < portasSala.length; i++){
				 
				if(this.portas[portasSala[i]].getNome1() == 'B'){
					if(this.portas[portasSala[i]].isStatus()){
						jogador.setLocalizacao(this.portas[portasSala[i]].getSala2());
					}
					for(Troll b: this.trolls){
						if((b.getLocalizacao() == jogador.getLocalizacao()) && (b.getItemMao().equals("Machado"))){
							b.setItemMao("Vazio");
							if(jogador.getItemMao().equals("Pocao")){
								System.out.println("Levou ATAQUE E PERDEU POCAO");
								jogador.setItemMao("Vazio");
								jogador.getInventario().getItens().setPocaoMagica(jogador.getInventario().getItens().getPocaoMagica() - 1);
							}else{
								System.out.println("LEVOU ATAQUE E PERDEU GOLD");
								jogador.getDinheiroAtual().setGold(0);
							}
						}
					}
					break;
				}
				else if (this.portas[portasSala[i]].getNome2() == 'B'){
					System.out.println(" EXIT B2");
					if(this.portas[portasSala[i]].isStatus()){
						jogador.setLocalizacao(this.portas[portasSala[i]].getSala1());
					}else{
						System.out.println("PORTA TRANCADA");
					}
					for(Troll b: this.trolls){
						if((b.getLocalizacao() == jogador.getLocalizacao()) && (b.getItemMao().equals("Machado"))){
							b.setItemMao("Vazio");
							if(jogador.getItemMao().equals("Pocao")){
								System.out.println("Levou ATAQUE E PERDEU POCAO");
								jogador.setItemMao("Vazio");
								jogador.getInventario().getItens().setPocaoMagica(jogador.getInventario().getItens().getPocaoMagica() - 1);
							}else{
								System.out.println("LEVOU ATAQUE E PERDEU GOLD");
								jogador.getDinheiroAtual().setGold(0);
							}
						}
					}
					break;
				}
			}
			break;
		case "C":
			for(int i = 0; i < portasSala.length; i++){
				 
				if(this.portas[portasSala[i]].getNome1() == 'C'){
					System.out.println(" EXIT C1");
					if(this.portas[portasSala[i]].isStatus()){
						jogador.setLocalizacao(this.portas[portasSala[i]].getSala2());
					}else{
						System.out.println("PORTA TRANCADA");
					}
					for(Troll b: this.trolls){
						if((b.getLocalizacao() == jogador.getLocalizacao()) && (b.getItemMao().equals("Machado"))){
							b.setItemMao("Vazio");
							if(jogador.getItemMao().equals("Pocao")){
								System.out.println("Levou ATAQUE E PERDEU POCAO");
								jogador.setItemMao("Vazio");
								jogador.getInventario().getItens().setPocaoMagica(jogador.getInventario().getItens().getPocaoMagica() - 1);
							}else{
								System.out.println("LEVOU ATAQUE E PERDEU GOLD");
								jogador.getDinheiroAtual().setGold(0);
							}
						}
					}
					break;
				}
				else if (this.portas[portasSala[i]].getNome2() == 'C'){
					if(this.portas[portasSala[i]].isStatus()){
						jogador.setLocalizacao(this.portas[portasSala[i]].getSala1());
					}else{
						System.out.println("PORTA TRANCADA");
					}
					for(Troll b: this.trolls){
						if((b.getLocalizacao() == jogador.getLocalizacao()) && (b.getItemMao().equals("Machado"))){
							b.setItemMao("Vazio");
							if(jogador.getItemMao().equals("Pocao")){
								System.out.println("Levou ATAQUE E PERDEU POCAO");
								jogador.setItemMao("Vazio");
								jogador.getInventario().getItens().setPocaoMagica(jogador.getInventario().getItens().getPocaoMagica() - 1);
							}else{
								System.out.println("LEVOU ATAQUE E PERDEU GOLD");
								jogador.getDinheiroAtual().setGold(0);
							}
						}
					}
					break;
				}
			}
			break;
		}
	}
	void enfeiticarPorta(Player jogador){
		int[] portasSala = this.salas[jogador.getLocalizacao()].getConjuntoPortas();
		int qtdPocao = jogador.getInventario().getItens().getPocaoMagica();
		switch(jogador.getObjetoProx()){
		case "A":
			for(int i = 0; i < portasSala.length; i++){
				 
				if((this.portas[portasSala[i]].getNome1() == 'A') || (this.portas[portasSala[i]].getNome2() == 'A')){
					this.portas[portasSala[i]].setFeitico(false);
					if(qtdPocao > 0){
						jogador.getInventario().getItens().setPocaoMagica(qtdPocao - 1);
					}
				}
			}
			break;
		case "B":
			for(int i = 0; i < portasSala.length; i++){
				 
				if((this.portas[portasSala[i]].getNome1() == 'B') || (this.portas[portasSala[i]].getNome2() == 'B')){
					this.portas[portasSala[i]].setFeitico(false);
					if(qtdPocao > 0){
						jogador.getInventario().getItens().setPocaoMagica(qtdPocao - 1);
					}
				}
			}
			break;
		case "C":
			for(int i = 0; i < portasSala.length; i++){
				 
				if((this.portas[portasSala[i]].getNome1() == 'C') || (this.portas[portasSala[i]].getNome2() == 'C')){
					this.portas[portasSala[i]].setFeitico(false);
					if(qtdPocao > 0){
						jogador.getInventario().getItens().setPocaoMagica(qtdPocao - 1);
					}
				}
			}
			break;
		}
	}
	public void pegarItens(Player jogador, String comando){
		String itemDesejado = comando.substring(comando.indexOf(" ") + 1);
		int qtdAtual = jogador.getInventario().getQtdItens();
		int trollSala = 0;
		if(jogador.getInventario().getQtdItens() <= 5){
			switch(itemDesejado){
			case "gold":
				for(Troll b: this.trolls){
					if(b.getLocalizacao() == jogador.getLocalizacao()){
						trollSala = 1;
					}
				}
				if(trollSala != 1){
					if(jogador.getObjetoProx().equals("Gold")){
						int goldAtual = jogador.getDinheiroAtual().getGold();
						jogador.getDinheiroAtual().setGold(goldAtual + this.salas[jogador.getLocalizacao()].getDinheiroSala().getGold());
						this.salas[jogador.getLocalizacao()].getDinheiroSala().setGold(0);
						jogador.getInventario().setQtdItens(qtdAtual + 1);
						System.out.println("PEGOU GOLD");
					}
				}else{
					System.out.println("AINDA HÁ TROLL NA SALA");
				}
				break;
			case "diamante":
				for(Troll b: this.trolls){
					if(b.getLocalizacao() == jogador.getLocalizacao()){
						trollSala = 1;
					}
				}
				if(trollSala != 1){
					if(jogador.getObjetoProx().equals("Diamante")){
						int diamanteAtual = jogador.getDinheiroAtual().getDiamante();
						jogador.getDinheiroAtual().setDiamante(diamanteAtual + this.salas[jogador.getLocalizacao()].getDinheiroSala().getGold());
						this.salas[jogador.getLocalizacao()].getDinheiroSala().setDiamante(0);;
						jogador.getInventario().setQtdItens(qtdAtual + 1);
						System.out.println("PEGOU DIAMANTE");
					}
				}else{
					System.out.println("AINDA HÁ TROLL NA SALA");
				}
				break;
			case "machado":
				if(jogador.getObjetoProx().equals("Machado")){
					int machadoSala = this.salas[jogador.getLocalizacao()].getUtilitariosSala().getMachado();
					jogador.getInventario().getItens().setMachado(jogador.getInventario().getItens().getMachado() +  1);
					this.salas[jogador.getLocalizacao()].getUtilitariosSala().setMachado(machadoSala - 1);
					jogador.getInventario().setQtdItens(qtdAtual + 1);
					System.out.println("PEGOU MACHADO");
				}
				break;
			case "pocao":
				if(jogador.getObjetoProx().equals("Pocao")){
					int pocaoSala = this.salas[jogador.getLocalizacao()].getUtilitariosSala().getPocaoMagica();
					jogador.getInventario().getItens().setPocaoMagica(jogador.getInventario().getItens().getPocaoMagica() +  1);
					this.salas[jogador.getLocalizacao()].getUtilitariosSala().setPocaoMagica(pocaoSala - 1);
					jogador.getInventario().setQtdItens(qtdAtual + 1);
					System.out.println("PEGOU POCAO");
				}
				break;
			case "chave":
				if(jogador.getObjetoProx().equals("Chave")){
					int chaveSala = this.salas[jogador.getLocalizacao()].getUtilitariosSala().getChave();
					jogador.getInventario().getItens().setChave(jogador.getInventario().getItens().getChave() +  1);
					this.salas[jogador.getLocalizacao()].getUtilitariosSala().setChave(chaveSala - 1);
					jogador.getInventario().setQtdItens(qtdAtual + 1);
					System.out.println("PEGOU CHAVE");
				}
				break;
			}
		}else{
			System.out.println("Inventario Cheio");
		}
	}
	public void soltarItens(Player jogador, String comando){
		String destinoMovimento = comando.substring(comando.indexOf(" ") + 1);
		int qtdAtual = jogador.getInventario().getQtdItens();
		if(jogador.getInventario().getQtdItens() >= 0){
			switch(destinoMovimento){
			case "gold":
				if(jogador.getObjetoProx().equals("Gold")){
					int goldAtual = jogador.getDinheiroAtual().getGold();
					jogador.getDinheiroAtual().setGold(0);
					this.salas[jogador.getLocalizacao()].getDinheiroSala().setGold(goldAtual + this.salas[jogador.getLocalizacao()].getDinheiroSala().getGold());
					jogador.getInventario().setQtdItens(qtdAtual + 1);
				}
				break;
			case "diamante":
				if(jogador.getObjetoProx().equals("Diamante")){
					int diamanteAtual = jogador.getDinheiroAtual().getDiamante();
					jogador.getDinheiroAtual().setDiamante(0);
					this.salas[jogador.getLocalizacao()].getDinheiroSala().setDiamante(diamanteAtual + this.salas[jogador.getLocalizacao()].getDinheiroSala().getGold());;
					jogador.getInventario().setQtdItens(qtdAtual + 1);
				}
				break;
			case "machado":
				if(jogador.getObjetoProx().equals("Machado")){
					int machadoSala = this.salas[jogador.getLocalizacao()].getUtilitariosSala().getMachado();
					jogador.getInventario().getItens().setMachado(jogador.getInventario().getItens().getMachado() -  1);
					this.salas[jogador.getLocalizacao()].getUtilitariosSala().setMachado(machadoSala + 1);
					jogador.getInventario().setQtdItens(qtdAtual + 1);
				}
				break;
			case "pocao":
				if(jogador.getObjetoProx().equals("Pocao")){
					int pocaoSala = this.salas[jogador.getLocalizacao()].getUtilitariosSala().getPocaoMagica();
					jogador.getInventario().getItens().setPocaoMagica(jogador.getInventario().getItens().getPocaoMagica() -  1);
					this.salas[jogador.getLocalizacao()].getUtilitariosSala().setPocaoMagica(pocaoSala + 1);
					jogador.getInventario().setQtdItens(qtdAtual + 1);
				}
				break;
			case "chave":
				if(jogador.getObjetoProx().equals("Chave")){
					int chaveSala = this.salas[jogador.getLocalizacao()].getUtilitariosSala().getChave();
					jogador.getInventario().getItens().setChave(jogador.getInventario().getItens().getChave() -  1);
					this.salas[jogador.getLocalizacao()].getUtilitariosSala().setChave(chaveSala + 1);
					jogador.getInventario().setQtdItens(qtdAtual + 1);
				}
				break;
			}
		}else{
			System.out.println("Inventario Cheio");
		}
	}
	public void mandarMachado(Player jogador, String comando){
		int trollSala = 0;
		int identificaoTroll = Integer.parseInt(comando.substring(comando.indexOf(" ") + 1));
		int machadoJogador = jogador.getInventario().getItens().getMachado();
		if(machadoJogador > 0){
			for(Troll b:this.trolls){
				if(b.getLocalizacao() == jogador.getLocalizacao()){
					trollSala = 1;
				}
			}
			if(trollSala == 1){
				for(Troll b:this.trolls){
					if(b.getIdentificacao() == identificaoTroll){
						b.setStatus(false);
						jogador.getInventario().getItens().setMachado(machadoJogador - 1);
						jogador.getInventario().setQtdItens(jogador.getInventario().getQtdItens() - 1);
						System.out.println("MANDOU MACHADO");
					}
				}
			}
		}
	}
	void view(Player jogador){
		int[] portasSala = salas[jogador.getLocalizacao()].getConjuntoPortas();
		for(int i = 0; i < portasSala.length; i++){
			if(portas[portasSala[i]].getSala1() == jogador.getLocalizacao()){
				System.out.println("Porta " + portas[portasSala[i]].getNome1());
			
			}else if(portas[portasSala[i]].getSala2() == jogador.getLocalizacao()){
				System.out.println("Porta " + portas[portasSala[i]].getNome2());
			}
		}
		System.out.println("Gold na Sala "+salas[jogador.getLocalizacao()].getDinheiroSala().getGold());
		System.out.println("Diamante na Sala "+salas[jogador.getLocalizacao()].getDinheiroSala().getDiamante());
		System.out.println("Pocoes na Sala "+salas[jogador.getLocalizacao()].getUtilitariosSala().getPocaoMagica());
		System.out.println("Machados na Sala "+salas[jogador.getLocalizacao()].getUtilitariosSala().getMachado());
		System.out.println("Chaves na Sala "+salas[jogador.getLocalizacao()].getUtilitariosSala().getChave());
		int i = 0;
		for(Troll b:this.trolls){
			if(b.getLocalizacao() == jogador.getLocalizacao()){
				System.err.println("Troll: "+ i + " noome: " + b.getIdentificacao());
			}
			i++;
		}
	}
}