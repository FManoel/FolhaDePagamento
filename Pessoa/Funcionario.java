package Pessoa;

public class Funcionario extends Pessoa {

	public Funcionario(String nome) {
		super.setNome(nome);
		super.setCargo("Funcionario");
		super.setSalario(2500);

	}

}