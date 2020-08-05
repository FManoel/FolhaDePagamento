package Vencimento;

import Data.Datas;

public abstract class Gratificacao {

	protected double porcentagem;
	protected TipoDeGratificacao tipo;
	protected Datas dataTrabalhada;
	protected double valorDaGraftificacao;
	/*
	 * Sobrescreve o metodo toString para uma melhor apresentacao ao usuario
	 */
	@Override
	public String toString() {

		return "Tipo gratificação: " + getTipo() + "\nValor da gratificação: " + getValorDaGraftificacao()
				+ "\nData trabalhada: " + getDataTrabalhada();
	}

	public double getValorDaGraftificacao() {
		return valorDaGraftificacao;
	}

	public void setValorDaGraftificacao(double valorDaGraftificacao) {
		this.valorDaGraftificacao = valorDaGraftificacao;
	}

	public Datas getDataTrabalhada() {
		return dataTrabalhada;
	}

	public void setDataTrabalhada(String dataTrabalhada) {
		this.dataTrabalhada.setdata(dataTrabalhada);
	}

	public TipoDeGratificacao getTipo() {
		return tipo;
	}

	public void setTipo(TipoDeGratificacao tipo) {
		this.tipo = tipo;
	}

	public double getPorcentagem() {
		return porcentagem;
	}

	public void setPorcentagem(double porcentagem) {
		this.porcentagem = porcentagem;
	}
	//Calcula o valor da gatificacao (de desempenho) atraves da porcentagem e o salario
	public double calculaGratificacao(double salario) {
		this.valorDaGraftificacao = salario * this.porcentagem;

		return this.valorDaGraftificacao;
	}

	//Calcula o valor da gatificacao (de hora extra) atraves da porcentagem e o salario
		public double calculaGratificacao(double salario, int hora_trabalhada) {
			try {
				if(hora_trabalhada <= 0)
					throw new Exception();
				this.valorDaGraftificacao = salario * this.porcentagem * hora_trabalhada;
			} catch(Exception e) {
				System.out.println("VERIFIQUE O AS HORAS TRABALHADAS");
			}
			

			return this.valorDaGraftificacao;
		}

}
