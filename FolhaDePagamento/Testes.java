package FolhaDePagamento;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.Map;

import javax.xml.crypto.Data;

import org.junit.Test;

import Data.Datas;
import Pessoa.ListaDePessoa;
import Pessoa.Pessoa;
import Vencimento.Desempenho;
import Vencimento.Gratificacao;
import Vencimento.ListaDeGratificacao;
import Vencimento.Vencimento;

public class Testes {
	@Test
	public void TesteadcionaGerente() {

		assertTrue(ListaDePessoa.adcionaPessoa("Jurema", "Gerente"));
		ListaDePessoa.removePessoa(0);
	}

	@Test
	public void TesteadcionaInvalido() {

		assertFalse(ListaDePessoa.adcionaPessoa("Felipe", "Motorista"));
	}

	@Test
	public void TesteadcionaFuncionario() {

		assertTrue(ListaDePessoa.adcionaPessoa("Jubiscreia", "Funcionario"));
		ListaDePessoa.removePessoa(0);
	}

	@Test
	public void TesteRecuperaPessoa() {
		ListaDePessoa.adcionaPessoa("Jucleidy", "Gerente");
		Pessoa p = ListaDePessoa.recuperaPessoa(0);

		assertTrue(p != null);
		ListaDePessoa.removePessoa(0);

	}

	@Test
	public void TesteRecuperaPessoaNome() {
		ListaDePessoa.adcionaPessoa("Jucridy", "Gerente");
		Pessoa p = ListaDePessoa.recuperaPessoa(0);

		assertEquals(p.getNome(), "Jucridy");
		ListaDePessoa.removePessoa(0);

	}

	@Test
	public void TesteRecuperaPessoaSalario() {
		ListaDePessoa.adcionaPessoa("Xerendy", "Gerente");
		Pessoa p = ListaDePessoa.recuperaPessoa(0);
		double resultado = p.getSalario();
		assertTrue(resultado == 4000.0);
		ListaDePessoa.removePessoa(0);

	}

	@Test
	public void TesteRecuperaPessoaCargo() {
		ListaDePessoa.adcionaPessoa("Jubileia", "Gerente");
		Pessoa p = ListaDePessoa.recuperaPessoa(0);
		String resultado = p.getCargo();
		assertEquals(resultado, "Gerente");
		ListaDePessoa.removePessoa(0);

	}

	@Test
	public void TesteRemovePessoa() {
		ListaDePessoa.adcionaPessoa("Jubileia", "Gerente");
		assertTrue(ListaDePessoa.removePessoa(0));

	}

	@Test
	public void TesteRemovePessoaFalse() {
		assertFalse(ListaDePessoa.removePessoa(0));

	}

	@Test
	public void TesteRecuperaListaDePessoa() {
		ArrayList<Pessoa> resultado = ListaDePessoa.getListaDePessoa();
		assertTrue(resultado != null);
	}

	@Test
	public void TesteRecuperaListaDePessoaVazia() {
		ArrayList<Pessoa> resultado = ListaDePessoa.getListaDePessoa();
		assertTrue(resultado.isEmpty());
	}

	@Test
	public void TesteAdicionaGratificacaoDesempenho() {
		ListaDePessoa.adcionaPessoa("Jubiscreyton", "Gerente");
		boolean resultado = ListaDeGratificacao.adicionaGratificacao(0, "10/02");
		assertTrue(resultado);
		ListaDePessoa.removePessoa(0);
	}

	@Test
	public void TesteAdicionaGratificacaoHoraExtra() {
		ListaDePessoa.adcionaPessoa("Jubiscreyton", "Funcionario");
		boolean resultado = ListaDeGratificacao.adicionaGratificacao(0, "10/02", 10);
		assertTrue(resultado);
		ListaDePessoa.removePessoa(0);
	}

	@Test
	public void TesteRemoveGratificacaoDesempenho() {
		ListaDePessoa.adcionaPessoa("Jubiscreyton", "Gerente");
		ListaDeGratificacao.adicionaGratificacao(0, "10/02");
		boolean resultado = ListaDeGratificacao.removeGratificacao(0, 0);
		assertTrue(resultado);
		ListaDePessoa.removePessoa(0);
	}

	@Test
	public void TesteRemoveGratificacaoHoraExtra() {
		ListaDePessoa.adcionaPessoa("Jubiscreyton", "Gerente");
		ListaDeGratificacao.adicionaGratificacao(0, "10/02", 10);
		boolean resultado = ListaDeGratificacao.removeGratificacao(0, 0);
		assertTrue(resultado);
		ListaDePessoa.removePessoa(0);
	}

	@Test
	public void TesteRecuperaListaDeGratificacao() {
		ListaDePessoa.adcionaPessoa("Jubiscreyton", "Gerente");
		ListaDeGratificacao.adicionaGratificacao(0, "25/11");
		ListaDeGratificacao.adicionaGratificacao(0, "10/02", 10);
		Map<Pessoa, Vencimento> resultado = ListaDeGratificacao.getListaDeGratificacoes();
		assertTrue(resultado != null);
		ListaDePessoa.removePessoa(0);
	}

	@Test
	public void TesteadcionaVencimento() {

		Vencimento v = new Vencimento();
		boolean resultado = v.adicionaNaLista(new Desempenho(2500, "10/06"));
		assertTrue(resultado);
	}

	@Test
	public void TesteRemoveVencimento() {

		Vencimento w = new Vencimento();
		w.adicionaNaLista(new Desempenho(2500, "10/06"));
		w.removeDaLista(0);
		ArrayList<Gratificacao> resultado = w.recuperaListaCompleta();
		assertTrue(resultado.isEmpty());

	}

	@Test
	public void TesteModificaVencimento() {

		Vencimento w = new Vencimento();
		w.adicionaNaLista(new Desempenho(2500, "15/09"));
		w.recuperaDaLista(0).setDataTrabalhada("10/06");
		Datas d = w.recuperaDaLista(0).getDataTrabalhada();
		assertEquals(d.toString(),"10/6");

	}

}
