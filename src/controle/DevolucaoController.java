package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Excecoes.Excecao;
import dao.ClienteDAO;
import dao.DevolucaoDAO;
import model.ClienteModel;
import model.DevolucaoModel;
import view.ViewTelaDeDevolucao;
import view.ViewTelaHistoricoLocacao;

public class DevolucaoController {

	private ViewTelaDeDevolucao viewTelaDeDevolucao;
	private ViewTelaHistoricoLocacao viewTelaHistoricolocacao;
	private DevolucaoModel model;

	public DevolucaoController(ViewTelaDeDevolucao viewTelaDeDevolucao, DevolucaoModel model) {
		this.model = model;
		this.viewTelaDeDevolucao = viewTelaDeDevolucao;
	}

	public DevolucaoController(ViewTelaHistoricoLocacao viewTelaHistoricolocacao, DevolucaoModel model) {
		this.model = model;
		this.viewTelaHistoricolocacao = viewTelaHistoricolocacao;
	}

	public DevolucaoController() {
		// TODO Auto-generated constructor stub
	}

	public void ListarClienteDevolucaoPeloNomeConsulta(JTable tableNome) throws Excecao {
		DevolucaoDAO listarNomeDevolucaoDao = new DevolucaoDAO();

		String nome = viewTelaDeDevolucao.getCampoNome().getText();

		DefaultTableModel tablemodel = (DefaultTableModel) viewTelaDeDevolucao.getTableNome().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<DevolucaoModel> listarTodosClientes = listarNomeDevolucaoDao
					.listarDevolucoesPeloNomeCliente(nome);

			for (DevolucaoModel model : listarTodosClientes) {
				tablemodel.addRow(new Object[] { model.getNome(), model.getCpf_cliente(), model.getCidade(),
						model.getCodContrato(), model.getMarca(), model.getModelo(), model.getAno(), model.getCor(),
						model.getEstado(), model.getDataLocacao(), model.getFormaPagamento(), model.getTempoLocacao(),
						model.getCod_veiculo() });
			}
			tableNome.setModel(tablemodel);

		} catch (Exception e) {

			throw new Excecao("Erro ao Listar Clientes");

		}

	}

	public void SelecionarNomeAtualizarCliente(JTable tableNome, int linha) {

		linha = tableNome.getSelectedRow();

		viewTelaDeDevolucao.getCampoNome().setText((String) tableNome.getValueAt(linha, 0));
		viewTelaDeDevolucao.getCampoCpf().setText((String) tableNome.getValueAt(linha, 1));
		viewTelaDeDevolucao.getCampoCidade().setText((String) tableNome.getValueAt(linha, 2));
		viewTelaDeDevolucao.getCampoCodContrato().setText(String.valueOf(tableNome.getValueAt(linha, 3)));
		viewTelaDeDevolucao.getCampoMarca().setText((String) tableNome.getValueAt(linha, 4));
		viewTelaDeDevolucao.getCampoModelo().setText((String) tableNome.getValueAt(linha, 5));
		viewTelaDeDevolucao.getCampoAno().setText((String) tableNome.getValueAt(linha, 6));
		viewTelaDeDevolucao.getComboBoxCor().addItem(tableNome.getValueAt(linha, 7));
		viewTelaDeDevolucao.getComboBoxEstado().addItem(tableNome.getValueAt(linha, 8));
		viewTelaDeDevolucao.getComboBoxData().addItem(tableNome.getValueAt(linha, 9));
		viewTelaDeDevolucao.getComboBoxPagamento().addItem(tableNome.getValueAt(linha, 10));
		viewTelaDeDevolucao.getComboBoxDias().addItem(tableNome.getValueAt(linha, 11));
		viewTelaDeDevolucao.getCampoCod().setText(String.valueOf(tableNome.getValueAt(linha, 12)));

	}

	public void ConcluirDevolucao(int confirm) throws Excecao {

		String codcontrato = viewTelaDeDevolucao.getCampoCodContrato().getText();
		int cod_contratoconvertido = Integer.valueOf(codcontrato);
		String nome = viewTelaDeDevolucao.getCampoNome().getText();
		String cpf = viewTelaDeDevolucao.getCampoCpf().getText();
		String marca = viewTelaDeDevolucao.getCampoMarca().getText();
		String modelo = viewTelaDeDevolucao.getCampoModelo().getText();
		String ano = viewTelaDeDevolucao.getCampoAno().getText();
		String cor = viewTelaDeDevolucao.getCampoAno().getText();
		String estado = (String) viewTelaDeDevolucao.getComboBoxEstado().getSelectedItem();
		String datalocacao = (String) viewTelaDeDevolucao.getComboBoxData().getSelectedItem();
		String datadevolucao = (String) viewTelaDeDevolucao.getComboBoxDataDevolucao().getSelectedItem();
		String formapagamento = (String) viewTelaDeDevolucao.getComboBoxPagamento().getSelectedItem();
		String tempolocacao = (String) viewTelaDeDevolucao.getComboBoxDias().getSelectedItem();
		String cod_veiculo = viewTelaDeDevolucao.getCampoCod().getText();
		int cod_veiculoconvertido = Integer.valueOf(cod_veiculo);

		DevolucaoDAO DevolucaoDao = new DevolucaoDAO();
		DevolucaoModel model = new DevolucaoModel(cod_contratoconvertido, cod_veiculoconvertido, nome, cpf, marca,
				modelo, ano, cor, estado, datalocacao, formapagamento, tempolocacao, datadevolucao);

		if (confirm == 0) {
			if (cpf.trim().isEmpty()) {

				throw new Excecao("PREENCHA OS CAMPOS CORRETAMENTE !");

			} else {
				try {
					DevolucaoDao.ConcluirDevolucao(model);
					DevolucaoDao.AtualizarStatusLocacaoDoVeiculoDevolvido(cod_veiculoconvertido);
					DevolucaoDao.AtualizarStatusClienteDevolucaoLocacao(cpf);
					DevolucaoDao.AtualizarStatusDoVeiculoDevolvido();
				} catch (Exception e) {
					throw new Excecao("Nao Foi Possivel Concluir a Devolucao !");
				}

			}
		}

	}

	public void ListarHistoricoLocacoes(JTable tablecliente) throws Excecao {
		DevolucaoDAO ListarHistoricoLocacoesDao = new DevolucaoDAO();

		DefaultTableModel tablemodel = (DefaultTableModel) viewTelaHistoricolocacao.getTableHistorico().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<DevolucaoModel> listarTodosClientes = ListarHistoricoLocacoesDao.listarHistoricoDevolucoes();

			for (DevolucaoModel model : listarTodosClientes) {
				tablemodel.addRow(new Object[] { model.getCodContrato(), model.getNome(), model.getCpf_cliente(),
						model.getMarca(), model.getModelo(), model.getAno(), model.getCor(), model.getEstado(),
						model.getDataLocacao(), model.getDatadevolucao(), model.getFormaPagamento(),
						model.getTempoLocacao(), model.getCod_veiculo(), model.getStatus() });
			}
			tablecliente.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Clientes");
		}

	}

	public void ListarHistoricoLocacoesPeloNome(JTable tableHistorico) throws Excecao {
		DevolucaoDAO ListarHistoricoLocacoesDao = new DevolucaoDAO();
		String nome = viewTelaHistoricolocacao.getCampoNome().getText();

		DefaultTableModel tablemodel = (DefaultTableModel) viewTelaHistoricolocacao.getTableHistorico().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<DevolucaoModel> listarHistorico = ListarHistoricoLocacoesDao
					.listarHistoricoDevolucoesPeloNome(nome);

			for (DevolucaoModel model : listarHistorico) {
				tablemodel.addRow(new Object[] { model.getCodContrato(), model.getNome(), model.getCpf_cliente(),
						model.getMarca(), model.getModelo(), model.getAno(), model.getCor(), model.getEstado(),
						model.getDataLocacao(), model.getDatadevolucao(), model.getFormaPagamento(),
						model.getTempoLocacao(), model.getCod_veiculo(), model.getStatus() });
			}
			tableHistorico.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Clientes");
		}

	}

	public void ListarHistoricoLocacoesPeloCpf(JTable tableHistorico) throws Excecao {
		DevolucaoDAO ListarHistoricoLocacoesDao = new DevolucaoDAO();
		String cpf = viewTelaHistoricolocacao.getCampoCPF().getText();

		DefaultTableModel tablemodel = (DefaultTableModel) viewTelaHistoricolocacao.getTableHistorico().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<DevolucaoModel> listarHistorico = ListarHistoricoLocacoesDao
					.listarHistoricoDevolucoesPeloCpf(cpf);

			for (DevolucaoModel model : listarHistorico) {
				tablemodel.addRow(new Object[] { model.getCodContrato(), model.getNome(), model.getCpf_cliente(),
						model.getMarca(), model.getModelo(), model.getAno(), model.getCor(), model.getEstado(),
						model.getDataLocacao(), model.getDatadevolucao(), model.getFormaPagamento(),
						model.getTempoLocacao(), model.getCod_veiculo(), model.getStatus() });
			}
			tableHistorico.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Clientes");
		}

	}

}
