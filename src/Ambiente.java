
import java.util.ArrayList;
import java.util.Random;

public class Ambiente {
	private Sala[] salas = new Sala[21];
	ArrayList<Troll> trolls = new ArrayList<>();
	private int qtdOuro;
	private int qtdDiamante;

	Ambiente() {
		for (int i = 0; i < 21; i++) {
			this.salas[i] = new Sala(i);
		}
		this.configurarComodos();
		this.distribuirPecas();
		this.salas[5].getPortas().get(1).setStatus(false);
		this.salas[9].getPortas().get(2).setStatus(false);
		this.salas[11].getPortas().get(1).setStatus(false);
		this.salas[18].getPortas().get(1).setStatus(false);
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

	public void distribuirPecas() {
		int randomDiamante, randomGold;
		int randomPocao, randomChave, randomMachado;
		int randomTroll, random;
		int identificacaoTroll = 0;
		int numeroPortasSala = 0;
		int contOuro = 0;
		int contBronze = 0;
		int[] indicePortasSala = new int[3];
		Random rand = new Random();

		// Configurando salas
		for (int i = 0; i < 20; i++) {
			// Configurando as portas de cada sala
			numeroPortasSala = 0;
			for (int k = 0; k < salas[i].getPortas().size(); k++) {
				if ((salas[i].getPortas().get(k).getSala1() == i) || (salas[i].getPortas().get(k).getSala2() == i)) {
					indicePortasSala[numeroPortasSala] = k;
					numeroPortasSala++;
				}
			}
			int[] conjuntoPortas = new int[numeroPortasSala];
			for (int k = 0; k < conjuntoPortas.length; k++) {
				conjuntoPortas[k] = indicePortasSala[k];
			}
			this.salas[i].setConjuntoPortas(conjuntoPortas);

			randomTroll = rand.nextInt(3); // Random Para Qtd Troll

			if (trolls.size() < 5) {
				for (int j = 0; j < randomTroll; j++) {
					random = rand.nextInt(8);
					Troll troll = new Troll(random, identificacaoTroll++, false);
					this.trolls.add(troll);
					this.getSalas()[random].getTrolls().add(troll);

				}
			}
			randomDiamante = rand.nextInt(4); // Random para Diamante
			randomGold = rand.nextInt(6); // Random Para gold
			randomPocao = rand.nextInt(2); // Random Para po��o
			randomChave = rand.nextInt(2); // Random Para chave
			randomMachado = rand.nextInt(3); // Random Para machado
			this.getSalas()[i].getGoldSala().add(new Gold(randomGold));
			this.getSalas()[i].getDiamanteSala().add(new Diamante(randomDiamante));

			for (int j = 0; j < randomMachado; j++) {
				random = rand.nextInt(3);
				if (random == 0) {
					contOuro++;
					if (contOuro == 1) {
						this.getSalas()[i].getMachados().add(new Temouro());
					}
				} else if (random == 1) {
					contBronze++;
					if (contBronze == 1 || contBronze == 2 || contBronze == 3) {
						this.getSalas()[i].getMachados().add(new Tembronze());
					}

				} else {
					this.getSalas()[i].getMachados().add(new Temferro());
				}
			}

			this.getSalas()[i].getPocaoSala().add(new Pocao(randomPocao));
			this.getSalas()[i].getChaveSala().add(new Chave(randomChave));
		}

	}

	public void configurarComodos() {
		char[][] nomesPortas = { { 'A', 'A' }, { 'B', 'A' }, { 'B', 'B' }, { 'A', 'B' }, { 'A', 'A' }, { 'B', 'A' },
				{ 'B', 'A' }, { 'B', 'B' }, { 'C', 'A' }, { 'B', 'A' }, { 'A', 'B' }, { 'B', 'A' }, { 'B', 'B' },
				{ 'A', 'B' }, { 'A', 'A' }, { 'A', 'A' }, { 'B', 'B' }, { 'A', 'A' }, { 'A', 'C' }, { 'B', 'B' },
				{ 'C', 'A' } };
		int[][] salaPortas = { { 00, 5 }, { 0, 1 }, { 05, 6 }, { 6, 11 }, { 11, 10 }, { 10, 15 }, { 15, 16 }, { 16, 17 },
				{ 11, 12 }, { 1, 2 }, { 17, 18 }, { 12, 7 }, { 7, 2 }, { 18, 13 }, { 13, 14 }, { 8, 9 }, { 3, 4 },
				{ 3, 3 }, { 19, 14 }, { 14, 9 }, { 9, 4 } };

		// Atribuindo valores nas portas
		for (int i = 0; i < 21; i++) {
			this.salas[salaPortas[i][0]].getPortas()
					.add(new Porta(nomesPortas[i][0], nomesPortas[i][1], salaPortas[i][0], salaPortas[i][1], true));
			this.salas[salaPortas[i][1]].getPortas()
					.add(new Porta(nomesPortas[i][1], nomesPortas[i][0], salaPortas[i][1], salaPortas[i][0], true));
		}

	}

}