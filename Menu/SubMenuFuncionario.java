package Menu;

import java.util.Scanner;

import Pessoa.ListaDePessoa;
import Pessoa.Pessoa;
import Vencimento.ListaDeGratificacao;
import Vencimento.Vencimento;

public class SubMenuFuncionario {
	static Scanner teclado = new Scanner(System.in);

	public static void ImprimeMenuModificacoes(int id) {
		Pessoa p = ListaDePessoa.recuperaPessoa(id);
		System.out.println("\n========== " + p.getNome() + " ==========\n");
		System.out.println("[1]\t Mudar nome e salario");
		System.out.println("[2]\t Mudar nome");
		System.out.println("[3]\t Mudar salario");
		System.out.println("[4]\t Adicionar Gratificação");
		System.out.println("[5]\t Remover Gratificação");
		System.out.println("[6]\t Lista de Gratificações");
		System.out.println("[0]\t RETORNAR");
		System.out.println("==============================\n");
		System.out.print("\nPor favor selecione uma opção: ");

	}

	public static void modificacoes(int id) {
		double salario;
		int escolha, tipo, horas_trabalhadas, index_gratificacao;
		String nomeAtual,leitura, data_trabalhada;

		ImprimeMenuModificacoes(id);
		try {
			leitura = teclado.next();
			for (int i = 0; i < leitura.length(); i++) {
				Character caractere = leitura.charAt(i);
				if (!(Character.isDigit(caractere))) {
					throw new Exception();
				}
			}
			escolha = Integer.valueOf(leitura);
		} catch (Exception erro) {
			System.err.println("\nDigite apenas numeros");
			escolha = 99;
			leitura = "erro";
		}

		switch (escolha) {
		case 0:
			MenuFuncionario.IU();
			break;
		case 1:
			System.out.print("Digite o novo nome: ");
			nomeAtual = teclado.next();
			System.out.print("Digite o novo salario ");
			salario = teclado.nextDouble();
			ListaDePessoa.atualizaNomeESalario(id, nomeAtual, salario);
			modificacoes(id);
			break;
		case 2:
			System.out.print("Digite o novo nome: ");
			nomeAtual = teclado.next();
			ListaDePessoa.atualizaNome(id, nomeAtual);
			modificacoes(id);
			break;

		case 3:
			System.out.print("Digite o novo salario");
			salario = teclado.nextDouble();
			ListaDePessoa.atualizaSalario(id, salario);
			modificacoes(id);
			break;
		case 4:

			System.out.println("Digite o tipo de gratificação");
			System.out.println("[1]\t Hora Extra");
			System.out.println("[2]\t Desempenho");
			tipo = teclado.nextInt();
			switch (tipo) {
			case 1:
				System.out.println("\nDigite a data trabalhada");
				data_trabalhada = teclado.next();
				System.out.println("\nDigite o numero de horas trabalhadas");
				horas_trabalhadas = teclado.nextInt();
				ListaDeGratificacao.adicionaGratificacao(id, data_trabalhada, horas_trabalhadas);
				modificacoes(id);
				break;
			case 2:
				System.err.println("\nDigite a data trabalhada");
				data_trabalhada = teclado.next();
				ListaDeGratificacao.adicionaGratificacao(id, data_trabalhada);
				modificacoes(id);
				break;
			}
		case 5:
			System.err.println("\nDigite o id da gratificação");
			index_gratificacao = teclado.nextInt();
			ListaDeGratificacao.removeGratificacao(id, index_gratificacao);
			modificacoes(id);
			break;
		case 6:
			ListaDeGratificacao.mostraLista(id);
			modificacoes(id);
			break;
		default:
			System.err.println("Numero invalido!");
			modificacoes(id);
			break;
		}
	}

}
