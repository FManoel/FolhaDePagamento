package Pessoa;

import java.util.ArrayList;
import java.util.Map;

import Vencimento.ListaDeGratificacao;
import Vencimento.Vencimento;

public class ListaDePessoa {
	static int id = 0;

	static ArrayList<Pessoa> listaDePessoa;

	public static boolean adcionaPessoa(String nome, String cargo) {
		if (listaDePessoa == null) {
			listaDePessoa = new ArrayList<Pessoa>();
		}
		switch (cargo) {
		case "Funcionario":
			Pessoa funcionario = new Funcionario(nome);
			Vencimento v = new Vencimento();
			ListaDeGratificacao.criaEmpregado(funcionario, v);
			return listaDePessoa.add(funcionario); 

		case "Gerente":
			Pessoa gerente = new Gerente(nome);
			Vencimento w = new Vencimento();
			ListaDeGratificacao.criaEmpregado(gerente, w);
			return listaDePessoa.add(gerente);

		default:
			System.out.println("Opção inválida!");
			return false;
		}

	}

	public static boolean removePessoa(int index) {
		
		if (recuperaPessoa(index) != null) {
			Pessoa p = recuperaPessoa(index);
			ListaDeGratificacao.getListaDeGratificacoes().remove(p);
			listaDePessoa.remove(index);
			System.out.println("\nEMPREGADO EXCLUIDO");
			return true;
		}
		return false;

	}

	public static void atualizaNomeESalario(int id, String nomeNovo, double salario) {
		Pessoa pe;
		pe = listaDePessoa.get(id);
		pe.setNome(nomeNovo);
		pe.setSalario(salario);
	}

	public static void atualizaSalario(int id, double salario) {
		Pessoa pe;
		pe = listaDePessoa.get(id);
		pe.setSalario(salario);

	}

	public static void atualizaNome(int id, String nomeNovo) {
		Pessoa pe;
		pe = listaDePessoa.get(id);
		pe.setNome(nomeNovo);

	}

	public static void mostraListaDePessoa() {
		System.out.println("\nLISTA DE FUNCIONÁRIOS\n");
		for (Pessoa pessoa : listaDePessoa) {
			System.out.println("Nome: " + pessoa.getNome() + "\nCargo: " + pessoa.getCargo() + "\nSalário: "
					+ pessoa.getSalario() + "\nId: " + listaDePessoa.indexOf(pessoa) + "\n===================\n");
		}

	}

	public static Pessoa recuperaPessoa(int index) {

		if (listaDePessoa != null) {
			for (Pessoa pessoa : listaDePessoa) {
				if (listaDePessoa.indexOf(pessoa) == index)
					return pessoa;
			}
		}
		Pessoa e = null;
		System.err.println("Empregado Inexistente");
		return e;
	}

	public static ArrayList<Pessoa> getListaDePessoa() {
		return listaDePessoa;

	}

}
