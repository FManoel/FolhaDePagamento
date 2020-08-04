package Vencimento;

import Data.Datas;

public class HoraExtra extends Gratificacao {
	public HoraExtra(double salario, String dataTrabalhada, int horaExtra) {
		super.setPorcentagem(0.001);
		super.dataTrabalhada = new Datas(dataTrabalhada);
		super.setTipo(TipoDeGratificacao.HoraExtra);
		super.calculaGratificacao(salario, horaExtra);

	}

}
