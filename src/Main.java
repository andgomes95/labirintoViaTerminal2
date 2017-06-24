
import java.io.IOException;
import java.util.Scanner;

import org.json.simple.parser.ParseException;

public class Main {

	public static void moverTroll(Ambiente ambiente) {
		for (Troll b : ambiente.trolls) {
			int posantiga = b.getLocalizacao();
			b.mover(ambiente.getSalas()[b.getLocalizacao()]);
			for (int i = 0; i < ambiente.getSalas()[posantiga].getTrolls().size(); i++) {
				ambiente.getSalas()[posantiga].getTrolls().remove(i);
			}
			ambiente.getSalas()[b.getLocalizacao()].getTrolls().add(b);
			if (b.isTemaxe() == false) {
				if (ambiente.getSalas()[b.getLocalizacao()].getMachados().size() != 0){
					for(int j = 0; j < ambiente.getSalas()[b.getLocalizacao()].getMachados().size(); j++){
						if(ambiente.getSalas()[b.getLocalizacao()].getMachados().get(j).getMachadoTipo() == "Ouro"){
							b.getMachadoTroll().add(new Temouro());
							b.setTemaxe(true);
						}else if(ambiente.getSalas()[b.getLocalizacao()].getMachados().get(j).getMachadoTipo() ==   "Bronze"){
							b.getMachadoTroll().add(new Tembronze());
							b.setTemaxe(true);
						}else{
							b.getMachadoTroll().add(new Temferro());
							b.setTemaxe(true);
						}
						ambiente.getSalas()[b.getLocalizacao()].getMachados().remove(j);
					}
				}
			}
			if ((ambiente.getSalas()[b.getLocalizacao()].isPersonagem() == true) && (b.isTemaxe() == true)) {
				if(b.getMachadoTroll().get(0).getDurabilidade() == 1){
					b.getMachadoTroll().remove(0);
				}else{
					if(b.getMachadoTroll().get(0).getMachadoTipo() == "Ouro"){
						b.getMachadoTroll().get(0).setDurabilidade(b.getMachadoTroll().get(0).getDurabilidade() - 1);
					}else if(b.getMachadoTroll().get(0).getMachadoTipo() == "Bronze"){
						b.getMachadoTroll().get(0).setDurabilidade(b.getMachadoTroll().get(0).getDurabilidade() - 1);
					}
				}
				ambiente.getSalas()[b.getLocalizacao()].setAction(true);
			}
		}
	}

	public static void action(Player jogador, String comando) {

		String destinoMovimento = comando.substring(comando.indexOf(" ") + 1);
		switch (destinoMovimento) {
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
		case "diamond":
			jogador.setObjetoProx("Diamante");
			break;
		case "axe":
			jogador.setObjetoProx("Machado");
			break;
		case "potion":
			jogador.setObjetoProx("Pocao");
			break;
		case "key":
			jogador.setObjetoProx("Chave");
			break;
		default:
			break;
		}
	}

	public static void main(String[] args) throws IOException, ParseException {
		Scanner scan = new Scanner(System.in);
		Ambiente ambiente = new Ambiente();
		Player jogador = new Player();
		String selecaoComando;
		System.out.println("Digite um nome de usuario");
		String nome = scan.nextLine();
		jogador.setNome(nome);
		int i = 0;
		ambiente.getSalas()[0].setPersonagem(true);
		System.out.println("SALA ATUAL: " + jogador.getLocalizacao());
		while (i != 1) {
			System.out.println("Digite o comando:");
			String comando = scan.nextLine();
			selecaoComando = comando;
			System.out.println("/" + selecaoComando + "\n");
			if (comando.indexOf(" ") > 0) {
				selecaoComando = comando.substring(0, comando.indexOf(" "));
			}
			switch (selecaoComando) {
			case "view":
				ambiente.getSalas()[jogador.getLocalizacao()].view();
			case "moveTo":
				action(jogador, comando);
				break;
			case "exit":
				jogador.sairSala(ambiente.getSalas()[jogador.getLocalizacao()]);
				ambiente.getSalas()[jogador.getLocalizacao()].setPersonagem(true);
				moverTroll(ambiente);
				if (ambiente.getSalas()[jogador.getLocalizacao()].isAction() == true) {
					jogador.sobAtaque(ambiente.getSalas()[jogador.getLocalizacao()]);
					ambiente.getSalas()[jogador.getLocalizacao()].setAction(false);
				}
				break;
			case "pickUp":
				jogador.pegarItens(ambiente.getSalas()[jogador.getLocalizacao()], comando);
				break;
			case "drop":
				jogador.soltarItens(ambiente.getSalas()[jogador.getLocalizacao()], comando);
				break;
			case "throwAxe":
				jogador.mandarMachado(ambiente.getSalas()[jogador.getLocalizacao()], comando);
				break;
			case "inventario":
				jogador.printMochila();
				break;
			case "over":
				System.out.println("Game Over");
				i = 1;
				break;
			case "help":
				System.out
						.printf("**Quia Ajuda**Mover para perto de objeto:moveTo <objeto<B door,gold,machado,pocao>>\n"
								+ "Sair da sala: exit\nObservar sala: view\nPegar item: pickup <objeto>\n"
								+ "Largar item: drop<objeto>\nArremessar machado: throwAxe <nome do trhow>\n"
								+ "Enfeiti�ar porta: magia\nSair do jogo: over\n");
				break;
			case "unlock":
				jogador.unlockDoor(ambiente.getSalas()[jogador.getLocalizacao()]);
				break;
			default:
				System.out.println("Comando invalido");
				System.out.println("help para comandos");
				break;
			}
			if (i != 1) {
				System.out.println("SALA ATUAL: " + jogador.getLocalizacao());
			}
		}

	}

}
