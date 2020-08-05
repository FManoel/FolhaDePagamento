package Pessoa;

public abstract class Pessoa {
	protected String nome;
	protected String cargo;
	protected double salario;

	/*
	 * Sobrescreve o metodo toString para uma melhor apresentacao ao usuario
	 */
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "----- PERFIL DO FUNCIONÁRIO -----\nNome: " + getNome() + "\nCargo: " + getCargo() + "\nSalário Base: "
				+ getSalario() + "\n";
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(double salario) {
		this.salario = salario;
	}

}
