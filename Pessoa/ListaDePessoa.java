package Pessoa;

import java.util.ArrayList;
import java.util.Map;

import Vencimento.ListaDeGratificacao;
import Vencimento.Vencimento;

public class ListaDePessoa {
	static int id = 0;

	static ArrayList<Pessoa> listaDePessoa;

	public static boolean adcionaPessoa(String nome, String cargo) {
		if (listaDePessoa == null) {										//Primeiro Testa para saber se a lista de pessoa ja existe
			listaDePessoa = new ArrayList<Pessoa>();						//Se nao existe ele cria uma nova
		}
		switch (cargo) {													//Vai selecionar o tipo do cargo da pessoa
		case "Funcionario":
			Pessoa funcionario = new Funcionario(nome);						//Cria um Novo Empregado do tipo Funcionario
			Vencimento v = new Vencimento();								//Vencimento é onde ficam as listas de gratificacoes de cada Pessoa
			ListaDeGratificacao.criaEmpregado(funcionario, v);              //Adiciona a nova Pessoa a lista
			return listaDePessoa.add(funcionario);							//Referencia a Pessoa a sua respectiva lista de Gratifiçacâo

		case "Gerente":														//Cria um Novo Empregado do tipo Gerente
			Pessoa gerente = new Gerente(nome);								//Vencimento é onde ficam as listas de gratificacao de cada Pessoa
			Vencimento w = new Vencimento();								//Adiciona a nova Pessoa a lista
			ListaDeGratificacao.criaEmpregado(gerente, w);					//Referencia a Pessoa a sua respectiva lista de Gratificaçacão
			return listaDePessoa.add(gerente);

		default:															//Caso o usuario tente adicionar um Empregado diferente
			System.out.println("Opção inválida!");
			return false;
		}

	}
	//Remove a pessoa e sua respectiva lista de gratificacoes
	public static boolean removePessoa(int index) {

		if (recuperaPessoa(index) != null) {								//Primeiro ele testa para saber se a pessoa existe (se nao é nulo)
			Pessoa p = recuperaPessoa(index);								//Se existir ele recupera e atribue a uma variavel
			ListaDeGratificacao.getListaDeGratificacoes().remove(p);		//Remove sua lista de gratificacao
			listaDePessoa.remove(index);									//Remove a pessoa da lista
			System.out.println("\nEMPREGADO EXCLUIDO");
			return true;
		}
		return false;

	}
	//Metodo que troca o nome e o salario da Pessoa
	public static void atualizaNomeESalario(int id, String nomeNovo, double salario) {
		Pessoa pe;
		pe = listaDePessoa.get(id);
		pe.setNome(nomeNovo);
		pe.setSalario(salario);
	}
	//Metodo que troca o  salario da Pessoa
	public static void atualizaSalario(int id, double salario) {
		Pessoa pe;
		pe = listaDePessoa.get(id);
		pe.setSalario(salario);

	}
	//Metodo que troca o nome da Pessoa
	public static void atualizaNome(int id, String nomeNovo) {
		Pessoa pe;
		pe = listaDePessoa.get(id);
		pe.setNome(nomeNovo);

	}
	//Metodo que recupera toda a lista de Pessoa e mostra ao usuario
	public static void mostraListaDePessoa() {
		System.out.println("\nLISTA DE FUNCIONÁRIOS\n");
		for (Pessoa pessoa : listaDePessoa) {
			System.out.println("Nome: " + pessoa.getNome() + "\nCargo: " + pessoa.getCargo() + "\nSalário: "
					+ pessoa.getSalario() + "\nId: " + listaDePessoa.indexOf(pessoa) + "\n===================\n");
		}

	}
	//Criacao de Geters e Seters renomeados
	public static Pessoa recuperaPessoa(int index) {

		if (listaDePessoa != null) {							//Testa para saber se a lista de Pessoa esta vazia
			for (Pessoa pessoa : listaDePessoa) {               //Percorre a lista
				if (listaDePessoa.indexOf(pessoa) == index)     //Testa cada Pessoa para encontrar o procurado
					return pessoa;
			}
		}
		Pessoa e = null;										//Caso não encontre nenhuma Pessoa cria um novo e o atribue nulo
		System.err.println("Empregado Inexistente");
		return e;
	}

	public static ArrayList<Pessoa> getListaDePessoa() {
		return listaDePessoa;

	}

}
