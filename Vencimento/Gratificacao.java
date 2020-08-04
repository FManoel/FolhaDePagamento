package Vencimento;

import Data.Datas;

public abstract class Gratificacao {

	protected double porcentagem;
	protected TipoDeGratificacao tipo;
	protected Datas dataTrabalhada;
	protected double valorDaGraftificacao;

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

	public double calculaGratificacao(double salario) {
		this.valorDaGraftificacao = salario * this.porcentagem;

		return this.valorDaGraftificacao;
	}

	public double calculaGratificacao(double salario, int hora_trabalhada) {
		this.valorDaGraftificacao = salario * this.porcentagem * hora_trabalhada;

		return this.valorDaGraftificacao;
	}

}
