package controle;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Excecoes.Excecao;
import dao.ClienteDAO;
import dao.LocacaoDAO;
import dao.VeiculoDAO;
import model.ClienteModel;
import model.LocacaoModel;
import model.VeiculoModel;
import serializacao.Deserializador;
import serializacao.Serializador;
import view.ViewTelaConsultaDeLocacoesAtivas;
import view.ViewTelaDeLocacoes;
import view.ViewMenuPrincipal;
import view.ViewTelaDeDevolucao;

public class LocacoesController {

	private ViewTelaDeLocacoes viewLocacoes;
	private ViewTelaConsultaDeLocacoesAtivas viewConsultaDeLocacoes;
	private ViewTelaDeDevolucao viewTelaDeDevolucao;
	private LocacaoModel model;

	public LocacoesController(ViewTelaDeLocacoes viewLocacoes, LocacaoModel model) {
		this.model = model;
		this.viewLocacoes = viewLocacoes;
	}

	public LocacoesController(ViewTelaConsultaDeLocacoesAtivas viewConsultaDeLocacoes,LocacaoModel model) {
		this.model = model;
		this.viewConsultaDeLocacoes = viewConsultaDeLocacoes;
	}

	public LocacoesController(ViewTelaDeDevolucao viewTelaDeDevolucao,LocacaoModel model) {
		this.model = model;
		this.viewTelaDeDevolucao = viewTelaDeDevolucao;
	}

	private static boolean VerificarInteiro(String str) {
		return str != null && str.matches("[0-9]*");
	}

	public void ListarVeiculosPeloModeloLocacao(JTable tableveiculo) throws Excecao {

		VeiculoDAO listarVeiculoModeloDao = new VeiculoDAO();

		String modelo = viewLocacoes.getCampoModelo().getText();

		DefaultTableModel tablemodel = (DefaultTableModel) viewLocacoes.getTableModelo().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<VeiculoModel> veiculosModelo = listarVeiculoModeloDao.listarVeiculosPeloModeloDisponivel(modelo);

			for (VeiculoModel model : veiculosModelo) {
				tablemodel.addRow(new Object[] { model.getMarca(), model.getModelo(), model.getAno(), model.getCor(),
						model.getStatus(), model.getEstado(), model.getCodigo(), });
			}
			tableveiculo.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Veiculo");
		}

	}

	public void ListarNomesClientesLocacao(JTable tablecliente) throws Excecao {
		ClienteDAO listarTodosClienteDao = new ClienteDAO();

		String nome = viewLocacoes.getCampoNome().getText();

		DefaultTableModel tablemodel = (DefaultTableModel) viewLocacoes.getTableNome().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<ClienteModel> listarTodosClientes = listarTodosClienteDao.listarClienteNome(nome);

			for (ClienteModel model : listarTodosClientes) {
				tablemodel.addRow(new Object[] { model.getNome(), model.getCpf(), model.getRg(), model.getEndereco(),
						model.getCidade(), model.getCodigo() });
			}
			tablecliente.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Nomes");
		}
	}

	public void ListarModelosDisponiveisLocacao(JTable tablecliente) throws Excecao {
		VeiculoDAO listarModelosDao = new VeiculoDAO();

		String modelo = viewLocacoes.getCampoModelo().getText();

		DefaultTableModel tablemodel = (DefaultTableModel) viewLocacoes.getTableModelo().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<VeiculoModel> listarTodosModelosDisponiveis = listarModelosDao
					.listarVeiculosPeloModeloDisponivel(modelo);

			for (VeiculoModel model : listarTodosModelosDisponiveis) {
				tablemodel.addRow(new Object[] { model.getCodigo(), model.getMarca(), model.getModelo(), model.getAno(),
						model.getCor(), model.getEstado(), model.getStatus() });
			}
			tablecliente.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Veiculo");
		}
	}

	public void SelecionarNomeLocacao(JTable tableNome, int linha) {

		linha = tableNome.getSelectedRow();

		viewLocacoes.getCampoNome().setText((String) tableNome.getValueAt(linha, 0));
		viewLocacoes.getCampoCpf().setText((String) tableNome.getValueAt(linha, 1));
		viewLocacoes.getCampoRg().setText((String) tableNome.getValueAt(linha, 2));
		viewLocacoes.getCampoEndereco().setText((String) tableNome.getValueAt(linha, 3));
		viewLocacoes.getCampoCidade().setText((String) tableNome.getValueAt(linha, 4));
	}

	public void SelecionarModeloLocacao(JTable tableModelo, int linha) {
		linha = tableModelo.getSelectedRow();

		viewLocacoes.getCampoMarca().setText((String) tableModelo.getValueAt(linha, 0));
		viewLocacoes.getCampoModelo().setText((String) tableModelo.getValueAt(linha, 1));
		viewLocacoes.getCampoAno().setText((String) tableModelo.getValueAt(linha, 2));
		viewLocacoes.getComboBoxCor().addItem(tableModelo.getValueAt(linha, 3));
		viewLocacoes.getComboBoxStatus().addItem(tableModelo.getValueAt(linha, 4));
		viewLocacoes.getComboBoxEstado().addItem(tableModelo.getValueAt(linha, 5));
		viewLocacoes.getCampoCod().setText(String.valueOf(tableModelo.getValueAt(linha, 6)));

	}

	public void ConcluirLocacao(int confirm) throws Excecao {

		String cod_veiculo = viewLocacoes.getCampoCod().getText();
		int cod_veiculoconvertido = Integer.valueOf(cod_veiculo);
		String cpf_cliente = viewLocacoes.getCampoCpf().getText();
		String marca = viewLocacoes.getCampoMarca().getText().toUpperCase();
		String modelo = viewLocacoes.getCampoModelo().getText().toUpperCase();
		String ano = (String) viewLocacoes.getCampoAno().getText();
		String cor = (String) viewLocacoes.getComboBoxCor().getSelectedItem();
		String estado = String.valueOf(viewLocacoes.getComboBoxEstado().getSelectedItem());
		String dataLocacao = String.valueOf(viewLocacoes.getComboBoxData().getSelectedItem());
		String formaPagamento = String.valueOf(viewLocacoes.getComboBoxPagamento().getSelectedItem());
		String tempoLocacao = String.valueOf(viewLocacoes.getComboBoxDias().getSelectedItem());

		LocacaoModel model = new LocacaoModel(cod_veiculoconvertido, cpf_cliente, marca, modelo, ano, cor, estado,
				dataLocacao, formaPagamento, tempoLocacao);

		LocacaoDAO concluirLocacao = new LocacaoDAO();
		LocacaoDAO alterarStatusVeiculo = new LocacaoDAO();
		LocacaoDAO alterarStatusLocacaoCliente = new LocacaoDAO();

		if (confirm == 0) {
			if (cpf_cliente.trim().isEmpty() || modelo.trim().isEmpty()) {
				throw new Excecao("Preencha os Campos Corretamente");

			} else {
				try {
					concluirLocacao.CadastrarLocacao(model);
					alterarStatusVeiculo.AtualizarStatusDoVeiculoAlugado(cod_veiculoconvertido);
					alterarStatusLocacaoCliente.AtualizarStatusLocacaoCliente(cpf_cliente);

				} catch (Exception e) {
					throw new Excecao("Nao Foi Possivel Concluir a Locacao");
				}
			}

		}

	}

	public void ListarLocacoesPeloModelo(JTable tableLocacao) throws Excecao {
		LocacaoDAO listarLocacaoModeloDao = new LocacaoDAO();

		String modelo = viewConsultaDeLocacoes.getCampoModelo().getText();

		DefaultTableModel tablemodel = (DefaultTableModel) viewConsultaDeLocacoes.getTableVeiculo().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<LocacaoModel> listarTodosModelosDisponiveis = listarLocacaoModeloDao
					.listarLocacoesPeloModeloVeiculo(modelo);

			for (LocacaoModel model : listarTodosModelosDisponiveis) {
				tablemodel.addRow(new Object[] { model.getCodContrato(), model.getNome(), model.getCpf_cliente(),
						model.getMarca(), model.getModelo(), model.getCor(), model.getDataLocacao(),
						model.getFormaPagamento(), model.getTempoLocacao(), model.getCod_veiculo() });
			}
			tableLocacao.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Locacoes");
		}
	}

	public void ListarLocacoesPeloCpfCliente(JTable tableLocacao) throws Excecao {
		LocacaoDAO listarsLocacaoCpfDao = new LocacaoDAO();

		String cpf = viewConsultaDeLocacoes.getCampoCpfCliente().getText();

		DefaultTableModel tablemodel = (DefaultTableModel) viewConsultaDeLocacoes.getTableVeiculo().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<LocacaoModel> listarTodosModelosDisponiveis = listarsLocacaoCpfDao
					.listarLocacoesPeloCpfCliente(cpf);

			for (LocacaoModel model : listarTodosModelosDisponiveis) {
				tablemodel.addRow(new Object[] { model.getCodContrato(), model.getNome(), model.getCpf_cliente(),
						model.getMarca(), model.getModelo(), model.getCor(), model.getDataLocacao(),
						model.getFormaPagamento(), model.getTempoLocacao(), model.getCod_veiculo() });
			}
			tableLocacao.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Locacoes");
		}
	}

	public void ListarTodasLocacoes(JTable tableLocacao) throws Excecao {
		LocacaoDAO listarModelosLocacaoDao = new LocacaoDAO();

		DefaultTableModel tablemodel = (DefaultTableModel) viewConsultaDeLocacoes.getTableVeiculo().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<LocacaoModel> listarTodosModelosDisponiveis = listarModelosLocacaoDao.listarTodasLocacoes();

			for (LocacaoModel model : listarTodosModelosDisponiveis) {
				tablemodel.addRow(new Object[] { model.getCodContrato(), model.getNome(), model.getCpf_cliente(),
						model.getMarca(), model.getModelo(), model.getCor(), model.getDataLocacao(),
						model.getFormaPagamento(), model.getTempoLocacao(), model.getCod_veiculo() });
			}
			tableLocacao.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Locacoes");
		}
	}

}
