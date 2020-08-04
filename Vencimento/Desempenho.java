package Vencimento;

import Data.Datas;

public class Desempenho extends Gratificacao {

	public Desempenho(double salario, String dataTrabalhada) {
		super.setPorcentagem(0.005);
		super.dataTrabalhada = new Datas(dataTrabalhada);
		super.setTipo(TipoDeGratificacao.Desempenho);
		super.calculaGratificacao(salario);

	}

}
