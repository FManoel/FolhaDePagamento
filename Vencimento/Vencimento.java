package Vencimento;

import java.util.ArrayList;

public class Vencimento {

	protected ArrayList<Gratificacao> lista;
	private double valorMensal = 0;
	private int contGrat = 0;

	public Vencimento() {
		lista = new ArrayList<Gratificacao>();
	}

	public ArrayList<Gratificacao> getLista() {
		return lista;
	}

	public boolean adicionaNaLista(Gratificacao g) {

		return lista.add(g);

	}

	public void removeDaLista(int index) {
		lista.remove(index);
	}

	public Gratificacao recuperaDaLista(int index) {

		return lista.get(index);
	}

	public void atualizaData(int index, String nova_data) {
		Gratificacao g = recuperaDaLista(index);
		g.setDataTrabalhada(nova_data);

	}

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
