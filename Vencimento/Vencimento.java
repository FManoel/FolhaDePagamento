package Vencimento;

import java.util.ArrayList;


public class Vencimento {

	protected ArrayList<Gratificacao> lista;
	private double valorMensal = 0;										//Ciacao de variaveis usadas
	private int contGrat = 0;

	public Vencimento() {
		lista = new ArrayList<Gratificacao>(); 							//Cria minha lista de Gratificacoes

	}

	public ArrayList<Gratificacao> getLista() {
		return lista;
	}
	//Metodo para cadastrar o Gratificacao
	public boolean adicionaNaLista(Gratificacao g) {

		return lista.add(g);

	}
	//Remove Gratificacoes
	public void removeDaLista(int index) {
		lista.remove(index);
	}
	//Metodo para recuperar a lista de Gratificacoes completa do Empregado
	public Gratificacao recuperaDaLista(int index) {

		for (Gratificacao gratificacao : lista) {									//Percorre a lista

			if (lista.indexOf(gratificacao) == index)								//Testa cada Gratificacao para encontrar a procurada
				return gratificacao;
		}
		Gratificacao g = null;														//Caso não encontre nenhuma Pessoa cria uma nova e o atribue nulo
		System.err.println("Gratificacao Inexistente");
		return g;
	}

	public void atualizaData(int index, String nova_data) {
		Gratificacao g = recuperaDaLista(index);
		g.setDataTrabalhada(nova_data);

	}
	//Metodo que recupera toda a lista de Gratificacao da pessoa e mostra ao usuario
	public void recuperaListaDeGratificacao() {

		if (lista.isEmpty()) {
			System.err.println("O empregado não possui gratificações...");
		} else {
			System.out.println("\n-LISTA-DE-VENCIMENTOS-\n");
			for (Gratificacao g : lista) {
				System.out.println("\nGratificação: " + g + "\nIndex: " + lista.indexOf(g));
			}
		}
	}

	public ArrayList<Gratificacao> recuperaListaCompleta() {
		return lista;
	}

	public void setContGrat(int contGrat) {
		this.contGrat = contGrat;
	}

	public int getContGrat() {
		return contGrat;
	}

	public double getValorMensal() {
		return valorMensal;
	}

	public void setValorMensal(double valorMensal) {
		this.valorMensal = valorMensal;
	}
	//Metodo para calcular o valor de todas as Gratificacoes com o salario da Pessoa
	public double valorDaGratificacao() {
		if (!lista.isEmpty() || getLista() != null) {
			setContGrat(0);
			setValorMensal(0);
			for (Gratificacao gratificacao : lista) {
				setContGrat(getContGrat() + 1);
				setValorMensal(gratificacao.getValorDaGraftificacao() + getValorMensal());
			}
			return getValorMensal();
		}
		return 0;
	}

}
