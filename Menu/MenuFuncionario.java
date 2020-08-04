package Menu;

import java.util.Scanner;
import Pessoa.ListaDePessoa;
import Vencimento.ListaDeGratificacao;

public class MenuFuncionario {
	static Scanner teclado = new Scanner(System.in);

	private static void ImprimeMenu() {
		System.out.println("\n==== Menu de Funcionarios ====\n");
		System.out.println("[1]\tAdicionar");
		System.out.println("[2]\tRemover");
		System.out.println("[3]\tModificar");
		System.out.println("[4]\tLista de funcionario");
		System.out.println("[0]\tRETORNAR");
		System.out.println("==============================\n");
		System.out.print("\nPor favor selecione uma opção: ");

	}

	public static void IU() {

		int op, id, cargoInt;
		String nome, cargo;
		ImprimeMenu();
		op = teclado.nextInt();

		switch (op) {
		case 0:
			MenuPrincipal.menuPrincipal();
			break;
		case 1:
			System.out.print("Digite o nome: ");
			nome = teclado.next();
			System.out.println("Escolha o cargo: ");
			System.out.println("[1]\tGerente");
			System.out.println("[2]\tFuncionario");
			cargoInt = teclado.nextInt();
			switch (cargoInt) {
			case 1:
				ListaDePessoa.adcionaPessoa(nome, "Gerente");
				System.out.println("Gerente adicionado com sucesso");
				IU();
				break;
			case 2:
				ListaDePessoa.adcionaPessoa(nome, "Funcionario");
				System.out.println("Funcionario adicionado com sucesso");
				IU();
				break;
			default:
				System.err.println("Opção invalida");
				IU();
				break;
			}
			IU();
		case 2:
			System.out.print("Digite o id do funcionario: ");
			id = teclado.nextInt();
			ListaDePessoa.removePessoa(id);
			IU();
			break;
		case 3:
			if (ListaDePessoa.getListaDePessoa() != null) {
				System.out.println("Digite o id do funcionario: ");
				id = teclado.nextInt();
				SubMenuFuncionario.modificacoes(id);
			}
			System.err.println("\nA lista de funcionarios esta vazia: ");
			IU();
			break;

		case 4:
			try {
				ListaDePessoa.mostraListaDePessoa();
			} catch (Exception e) {
				// TODO: handle exception
				System.err.println("\nErro! Não existe lista de Empregados");
				System.out.println("Por favor. Cadastre um Empregado\n");
				IU();
			}

		default:
			// System.err.println("Numero invalido!");
			IU();
			break;

		}
	}

}
