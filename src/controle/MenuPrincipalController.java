package controle;

import javax.swing.JOptionPane;

import Excecoes.Excecao;
import view.ViewMenuPrincipal;
import view.ViewTelaAtualizarExcluirCliente;
import view.ViewTelaAtualizarExcluirColaborador;
import view.ViewTelaAtualizarExcluirVeiculo;
import view.ViewTelaConsultaDeLocacoesAtivas;
import view.ViewTelaDeDevolucao;
import view.ViewTelaDeLocacoes;
import view.ViewTelaHistoricoLocacao;

public class MenuPrincipalController {

	private ViewMenuPrincipal ViewMenuPrincipal;

	public MenuPrincipalController() {
		// TODO Auto-generated constructor stub
	}

	public MenuPrincipalController(ViewMenuPrincipal ViewMenuPrincipal) {
		this.ViewMenuPrincipal = ViewMenuPrincipal;
	}

	public int EscolherOpcaoAlterarExcluir(int confirm) throws Excecao {

		if (confirm == 0) {
			try {
				new ViewTelaAtualizarExcluirCliente().chamarTelaAtualizarCliente();
				ViewMenuPrincipal.MinimizarMenuPrincipal();

			} catch (Exception e) {
				throw new Excecao("Nao Foi Possivel Acessar essa Tela");
			}

		} else if (confirm == 1) {
			try {
				new ViewTelaAtualizarExcluirColaborador().chamarTelaAtualizarColaborador();
				ViewMenuPrincipal.MinimizarMenuPrincipal();
			} catch (Exception e) {
				throw new Excecao("Nao Foi Possivel Acessar essa Tela");
			}

		} else if (confirm == 2) {
			try {
				new ViewTelaAtualizarExcluirVeiculo().chamarTelaAlterarExcluirVeiculo();
				ViewMenuPrincipal.MinimizarMenuPrincipal();
			} catch (Exception e) {
				throw new Excecao("Nao Foi Possivel Acessar essa Tela");
			}

		}
		return confirm;

	}

	public int EscolherOpcaoLocacao(int confirm) throws Excecao {

		if (confirm == 0) {
			try {
				new ViewTelaDeLocacoes().chamarTelaDeLocacao();
				ViewMenuPrincipal.MinimizarMenuPrincipal();
			} catch (Exception e) {
				throw new Excecao("Nao Foi Possivel Acessar essa Tela");
			}

		} else if (confirm == 1) {
			try {
				new ViewTelaHistoricoLocacao().chamarTelaHistoricoLocacao();
				ViewMenuPrincipal.MinimizarMenuPrincipal();
			} catch (Exception e) {
				throw new Excecao("Nao Foi Possivel Acessar essa Tela");
			}

		} else if (confirm == 2) {
			try {
				new ViewTelaConsultaDeLocacoesAtivas().chamarTelaConsultasLocacoes();
				ViewMenuPrincipal.MinimizarMenuPrincipal();

			} catch (Exception e) {
				throw new Excecao("Nao Foi Possivel Acessar essa Tela");
			}

		}
		return confirm;

	}

}
