package Vencimento;

import java.util.HashMap;
import java.util.Map;

import Data.Datas;
import Pessoa.ListaDePessoa;
import Pessoa.Pessoa;

public class ListaDeGratificacao {
	private static Datas dataTest = new Datas();
	private static Map<Pessoa, Vencimento> listaDeGratificacao; // Criacao de um mapa para referenciar a Pessoa
																// a sua lista de Gratificacao

	public static Map<Pessoa, Vencimento> getListaDeGratificacoes() {
		return listaDeGratificacao;
	}

	public static void setListaDeGratificacoes(Map<Pessoa, Vencimento> listaDeGratificacoes) {
		ListaDeGratificacao.listaDeGratificacao = listaDeGratificacoes;
	}

	// Metodo para adicionar uma nova Gratificacao (Por desempenho) a Pessoa
	public static boolean adicionaGratificacao(int index_funcionario, String data_trabalhada) {
		Vencimento v;
		Pessoa e = ListaDePessoa.recuperaPessoa(index_funcionario);

		if (listaDeGratificacao == null) {
			listaDeGratificacao = new HashMap<>();
		}

		if (dataTest.setdata(data_trabalhada)) {
			v = (Vencimento) listaDeGratificacao.get(e);
			v.adicionaNaLista(new Desempenho(e.getSalario(), data_trabalhada));
			return true;
		}
		return false;

	}

	// Metodo para adicionar uma nova Gratificacao (Por hora extra) a Pessoa
	public static boolean adicionaGratificacao(int index_funcionario, String data_trabalhada, int horas_trabalhadas) {
		Vencimento v;
		Pessoa e = ListaDePessoa.recuperaPessoa(index_funcionario);

		if (listaDeGratificacao == null) {
			listaDeGratificacao = new HashMap<>();
		}

		if (horas_trabalhadas > 0 && dataTest.setdata(data_trabalhada)) {
			v = (Vencimento) listaDeGratificacao.get(e);
			v.adicionaNaLista(new HoraExtra(e.getSalario(), data_trabalhada, horas_trabalhadas));
			return true;
		} else if (horas_trabalhadas <= 0) {
			System.out.println("VERIFIQUE O AS HORAS TRABALHADAS");
		}
		return false;

	}

	// Metodo para a remocao de uma Gratificacao da Pessoa
	public static boolean removeGratificacao(int index_funcionario, int index_gratificacao) {
		if (!listaDeGratificacao.isEmpty() || listaDeGratificacao != null) { // Testa para saber se a Pessoa possui
																				// Gratificacoes
			Pessoa e = ListaDePessoa.getListaDePessoa().get(index_funcionario); // Se tiver recupera a Pessoa
			Vencimento v = (Vencimento) listaDeGratificacao.get(e); // Recupera a lista de Gratificacoes da Pessoa
			v.removeDaLista(index_gratificacao); // Remove a Gratifiacacao escolhida
			return true;
		}
		return false;
	}

	// Metodo para mostrar ao usuario a lista de gratificacoes da Pessoa
	public static void mostraLista(int index_funcionario) {
		Pessoa e = ListaDePessoa.recuperaPessoa(index_funcionario);
		Vencimento v = listaDeGratificacao.get(e);
		v.recuperaListaDeGratificacao();
	}

	public static Gratificacao recuperaGratificacao(int index_funcionario, int index_gratificacao) {
		Pessoa e = ListaDePessoa.getListaDePessoa().get(index_funcionario);
		Vencimento v = (Vencimento) listaDeGratificacao.get(e);
		Gratificacao g = v.recuperaDaLista(index_gratificacao);
		if (g == null)
			System.out.println("Gratificacao Inexistente");
		return g;
	}

	// Metodo para mostar toda a Folha de Pagamento ao Usuario
	public static void mostraFolhaDePagamento() {
		System.out.println(
				"-------------------------------------------------- FOLHA DE PAGAMENTO ---------------------------------------------------\n");
		System.out.println(
				"Nome\t\tCargo\t\tSalário Base\tQtde. de Gratificações\t   Valor das Gratificações\tVencimento mensal\n");
		if (listaDeGratificacao == null || listaDeGratificacao.isEmpty()) {
			System.err.println("\t\t\t\t\t\tLista Vazia\n");

		} else {

			for (Pessoa pessoa : ListaDePessoa.getListaDePessoa()) {

				listaDeGratificacao.get(pessoa).valorDaGratificacao();

				System.out.printf("%-16s%-17sR$ %-10s%12s\t\t\t  R$ %-23sR$ %-17s\n", pessoa.getNome(),
						pessoa.getCargo(), pessoa.getSalario(), listaDeGratificacao.get(pessoa).getContGrat(),
						listaDeGratificacao.get(pessoa).getValorMensal(),
						(pessoa.getSalario() + listaDeGratificacao.get(pessoa).getValorMensal()));

			}
//			 System.out.println(
//						"------------------------------------------------------------------------------------------------------------------------\n");
		}

	}

	// Metodo para refenciar uma nova Pessoa a sua lista de Gratificacao
	public static void criaEmpregado(Pessoa e, Vencimento v) {
		if (listaDeGratificacao == null) {
			listaDeGratificacao = new HashMap<>();
		}
		listaDeGratificacao.put(e, v);
	}

}
