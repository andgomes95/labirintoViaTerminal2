package pratico.trabalho;

import java.util.Scanner;

import javax.swing.SingleSelectionModel;

public class Main {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		Ambiente ambiente = new Ambiente();
		Player jogador = new Player();
		String selecaoComando;
		System.out.println("Digite um nome de usuario");
		String nome = scan.nextLine();
		jogador.setNome(nome);
		int i = 0;
		System.out.printf("**Guia Ajuda**\nMover para perto de objeto:moveTo <objeto<B door,gold,machado,pocao>>\n"
		         + "Sair da sala: exit\nObservar sala: view\nPegar item: pickup <objeto>\n"
	             +"Largar item: drop<objeto>\nArremessar machado: throwAxe <nome do trhow>\n"
		         + "Enfeitiçar porta: magia\nSair do jogo: over\n" + "abrir inventario: inventario\n");
		System.out.println("SALA ATUAL: " + jogador.getLocalizacao());
		while(i != 1){
			System.out.println("Digite o comando:");
			String comando = scan.nextLine();
			selecaoComando = comando;
			System.out.println("/" + selecaoComando + "\n");
			if(comando.indexOf(" ") > 0){
				selecaoComando = comando.substring(0, comando.indexOf(" "));
			}
			switch(selecaoComando){
			case "view":
				ambiente.view(jogador);
				break;
			case "moveTo":
				ambiente.movePlayer(jogador, comando);
				break;
			case "exit":
				ambiente.sairSala(jogador);
				ambiente.moverTroll();
				break;
			case "pickup":
				ambiente.pegarItens(jogador, comando);
				break;
			case "drop":
				ambiente.soltarItens(jogador, comando);
				break;
			case "throwAxe":
				ambiente.mandarMachado(jogador, comando);
				break;
			case "magia":
				ambiente.enfeiticarPorta(jogador);
				break;
			case "inventario":
				System.out.println(jogador.getInventario());
				break;
			case "over":
				System.out.println("Game Over");
				i = 1;
				break;
			case "help":
				System.out.printf("**Quia Ajuda**Mover para perto de objeto:moveTo <objeto<B door,gold,machado,pocao>>\n"
				         + "Sair da sala: exit\nObservar sala: view\nPegar item: pickup <objeto>\n"
			             +"Largar item: drop<objeto>\nArremessar machado: throwAxe <nome do trhow>\n"
				         + "Enfeitiçar porta: magia\nSair do jogo: over\n");
				break;
			default:
				System.out.println("Comando invalido");
				System.out.println("help para comandos");
				break;
			}
			if(i != 1){
				System.out.println("SALA ATUAL: " + jogador.getLocalizacao());
			}
		}
			
	}

}
