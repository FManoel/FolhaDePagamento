package Menu;

import java.util.Scanner;

import Vencimento.ListaDeGratificacao;

public class MenuPrincipal {
	public static void menu_Principal() {
		System.out.println("\n====== Menu Principal ======\n");
		System.out.println("[1]\tMenu Funcionarios");
		System.out.println("[2]\tFolha de Pagamento");
		System.out.println("[0]\tSAIR");
		System.out.println("==============================\n");
		System.out.print("\nPor favor selecione uma opção: ");

	}

	public static void menuPrincipal() {
		Scanner teclado = new Scanner(System.in);
		int opcao;
		String leitura;
		menu_Principal();
		try {
			leitura = teclado.next();
			for (int i = 0; i < leitura.length(); i++) {
				Character caractere = leitura.charAt(i);
				if (!(Character.isDigit(caractere))) {
					throw new Exception();
				}
			}
			opcao = Integer.valueOf(leitura);
		} catch (Exception e) {
			System.err.println("\nDigite apenas numeros");
			opcao = 99;
			leitura = "erro";
		}

		switch (opcao) {
		case 0:
			break;
		case 1:
			MenuFuncionario.IU();
			break;
		case 2:
			ListaDeGratificacao.mostraFolhaDePagamento();
			menuPrincipal();
			break;

		default:
			System.err.println("Numero invalido!");
			menuPrincipal();
			break;
		}

	}

}
//"Menu Principal"
//
//* Mostra lista de Funcionario
//* Empregado
//
//	"Menu Funcionario"
//
//	- Adiciona Empregado
//	- Acessa Empregado // passa o indice do empregado
//		
//		"SubMenu Funcionario e Gratificacao"
//
//		+ Recupera Dados
//		+ Atualiza Dados
//		+ Mostra Lista de Gratificacao
//		+ Adiciona Gratificacao
//			= Hora Extra
//			= Desemprenho
//		+ Remove Gratificacao // pass o indici da gratificacao 
//		+ Atualiza Gratificacao
//		+ Voltar
//	- Remove Funcionario
//	- Voltar
//* Folha de Pagamento
//* Sair