package controle;

import java.util.ArrayList;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import Excecoes.Excecao;
import dao.ColaboradorDAO;
import dao.VeiculoDAO;
import model.ColaboradorModel;
import model.VeiculoModel;
import serializacao.Deserializador;
import serializacao.Serializador;
import view.ViewTelaDeConsultaVeiculo;
import view.ViewTelaDeLocacoes;
import view.ViewMenuPrincipal;
import view.ViewTelaAtualizarExcluirVeiculo;
import view.ViewTelaCadastroVeiculo;

public class VeiculoController {

	private ViewTelaCadastroVeiculo viewCadastroVeiculo;
	private ViewTelaDeConsultaVeiculo viewConsultaVeiculo;
	private ViewTelaAtualizarExcluirVeiculo viewTelaAtualizarExcluirVeiculo;
	private VeiculoModel model;
	private VeiculoDAO veiculoDao;

	public VeiculoController() {

	}

	public VeiculoController(ViewTelaCadastroVeiculo viewCadastroVeiculo, VeiculoModel model) {
		this.viewCadastroVeiculo = viewCadastroVeiculo;
		this.model = model;
	}

	public VeiculoController(ViewTelaDeConsultaVeiculo viewConsultaVeiculo, VeiculoModel model) {
		this.viewConsultaVeiculo = viewConsultaVeiculo;
		this.model = model;
	}

	public VeiculoController(ViewTelaAtualizarExcluirVeiculo viewTelaAtualizarExcluirVeiculo, VeiculoModel model) {
		this.viewTelaAtualizarExcluirVeiculo = viewTelaAtualizarExcluirVeiculo;
		this.model = model;
	}

	private static boolean VerificarInteiro(String str) {
		return str != null && str.matches("[0-9]*");
	}

	public void CadastrarVeiculo(int confirm) throws Excecao {
		String marca = viewCadastroVeiculo.getCampoMarca().getText().toUpperCase();
		String modelo = viewCadastroVeiculo.getCampoModelo().getText().toUpperCase();
		String placa = viewCadastroVeiculo.getCampoPlaca().getText().toUpperCase();
		String descricao = viewCadastroVeiculo.getCampoDescricao().getText().toUpperCase();
		String status = String.valueOf(viewCadastroVeiculo.getComboBoxStatus().getSelectedItem());
		String estado = String.valueOf(viewCadastroVeiculo.getComboBoxEstado().getSelectedItem());
		String ano = viewCadastroVeiculo.getCampoAno().getText();
		String renavam = viewCadastroVeiculo.getCampoRenavam().getText();
		String cor = String.valueOf(viewCadastroVeiculo.getComboBoxCor().getSelectedItem());

		VeiculoModel model = new VeiculoModel(marca, modelo, placa, cor, descricao, status, estado, ano, renavam);
		VeiculoDAO veiculoDao = new VeiculoDAO();

		if (confirm == 0) {
			if (VerificarInteiro(ano) && VerificarInteiro(renavam)) {
				if (marca.trim().isEmpty() && modelo.trim().isEmpty() && placa.trim().isEmpty() && ano.trim().isEmpty()
						&& renavam.trim().isEmpty()) {
					throw new Excecao("Preencha Corretamente os Campos");

				} else {
					try {
						veiculoDao.cadastrarVeiculo(model);

						new ViewMenuPrincipal().chamarMenuPrincipal();
						viewCadastroVeiculo.MinimizarTelaCadastratoVeiculo();
					} catch (Exception e) {
						throw new Excecao("Nao Foi Possivel Cadastrar o Veiculo");
					}

				}
			} else {
				throw new Excecao("Digite um Ano/Renavam Valido");

			}

		}

	}

	public void SerializarVeiculo() {

		String marca = viewCadastroVeiculo.getCampoMarca().getText();
		String modelo = viewCadastroVeiculo.getCampoModelo().getText();
		String placa = viewCadastroVeiculo.getCampoPlaca().getText();
		String descricao = viewCadastroVeiculo.getCampoDescricao().getText();
		String status = String.valueOf(viewCadastroVeiculo.getComboBoxStatus().getSelectedItem());
		String estado = String.valueOf(viewCadastroVeiculo.getComboBoxEstado().getSelectedItem());
		String ano = viewCadastroVeiculo.getCampoAno().getText();
		String renavam = viewCadastroVeiculo.getCampoRenavam().getText();
		String cor = String.valueOf(viewCadastroVeiculo.getComboBoxCor().getSelectedItem());

		VeiculoModel model = new VeiculoModel(marca, modelo, placa, cor, descricao, status, estado, ano, renavam);

		try {
			Serializador s = new Serializador();

			s.serializar("./veiculocadastro", model);
		} catch (Exception e) {
			
		}

	}

	public void DeserializarVeiculo() {
		VeiculoModel model = new VeiculoModel();
		try {

			Deserializador d = new Deserializador();
			model = (VeiculoModel) d.deserializar("./veiculocadastro");
		} catch (Exception e) {

		}
		String marca = model.getMarca();
		String modelo = model.getModelo();
		String placa = model.getPlaca();
		String descricao = model.getDescricao();
		String ano = model.getAno();
		String renavam = model.getRenavam();

		viewCadastroVeiculo.getCampoMarca().setText(marca);
		viewCadastroVeiculo.getCampoModelo().setText(modelo);
		viewCadastroVeiculo.getCampoPlaca().setText(placa);
		viewCadastroVeiculo.getCampoDescricao().setText(descricao);
		viewCadastroVeiculo.getCampoAno().setText(ano);
		viewCadastroVeiculo.getCampoRenavam().setText(renavam);

	}

	public void RecuperarDadosCadastroVeiculo() {
		if (!viewCadastroVeiculo.getCampoMarca().getText().isEmpty()) {
			int confirm = JOptionPane.showConfirmDialog(null, "Recuperar Dados Anteriores ?");
			if (confirm == 0) {
				try {
					DeserializarVeiculo();
				} catch (Exception e) {

				}

			} else if (confirm == 1) {
				LimparCamposCadastroVeiculo();
			}
		}
	}

	public void LimparCamposCadastroVeiculo() {
		viewCadastroVeiculo.getCampoMarca().setText("");
		viewCadastroVeiculo.getCampoModelo().setText("");
		viewCadastroVeiculo.getCampoPlaca().setText("");
		viewCadastroVeiculo.getCampoDescricao().setText("");
		viewCadastroVeiculo.getCampoAno().setText("");
		viewCadastroVeiculo.getCampoRenavam().setText("");

	}

	public void LimparCamposAlterarExcluirVeiculo() {
		viewTelaAtualizarExcluirVeiculo.getCampoMarca().setText("");
		viewTelaAtualizarExcluirVeiculo.getCampoModelo().setText("");
		viewTelaAtualizarExcluirVeiculo.getCampoPlaca().setText("");
		viewTelaAtualizarExcluirVeiculo.getCampoDescricao().setText("");
		viewTelaAtualizarExcluirVeiculo.getCampoAno().setText("");
		viewTelaAtualizarExcluirVeiculo.getCampoRenavam().setText("");

	}

	public void ListarTodosVeiculos(JTable tableveiculo) throws Excecao {
		VeiculoDAO veiculoDao = new VeiculoDAO();

		ArrayList<VeiculoModel> listarTodosVeiculos = veiculoDao.listarTodosVeiculos();

		try {
			DefaultTableModel tablemodel = (DefaultTableModel) viewConsultaVeiculo.getTableVeiculo().getModel();
			tablemodel.setRowCount(0);

			for (VeiculoModel model : listarTodosVeiculos) {
				tablemodel.addRow(new Object[] { model.getCodigo(), model.getMarca(), model.getModelo(), model.getAno(),
						model.getPlaca(), model.getCor(), model.getEstado(), model.getStatus() });
			}
			viewConsultaVeiculo.setTableVeiculo(tableveiculo);

		} catch (Exception e) {
			
			throw new Excecao("Erro ao Listar Veiculo");
		}

	}

	public void ListarVeiculoPelaMarca(JTable tableveiculo) throws Excecao {

		VeiculoDAO veiculoDao = new VeiculoDAO();

		String marca = viewConsultaVeiculo.getCampoMarca().getText();

		ArrayList<VeiculoModel> listarVeiculosMarca = veiculoDao.listarVeiculosMarca(marca);

		try {
			DefaultTableModel tablemodel = (DefaultTableModel) viewConsultaVeiculo.getTableVeiculo().getModel();
			tablemodel.setRowCount(0);

			for (VeiculoModel model : listarVeiculosMarca) {
				tablemodel.addRow(new Object[] { model.getCodigo(), model.getMarca(), model.getModelo(), model.getAno(),
						model.getPlaca(), model.getCor(), model.getEstado(), model.getStatus() });
			}
			tableveiculo.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Veiculo");
		}

	}

	public void ListarVeiculosPeloAno(JTable tableveiculo) throws Excecao {

		VeiculoDAO veiculoDao = new VeiculoDAO();

		String ano = String.valueOf(viewConsultaVeiculo.getComboBoxAno().getSelectedItem());

		DefaultTableModel tablemodel = (DefaultTableModel) viewConsultaVeiculo.getTableVeiculo().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<VeiculoModel> veiculosAno = veiculoDao.listarVeiculosAno(ano);

			for (VeiculoModel model : veiculosAno) {
				tablemodel.addRow(new Object[] { model.getCodigo(), model.getMarca(), model.getModelo(), model.getAno(),
						model.getPlaca(), model.getCor(), model.getEstado(), model.getStatus() });
			}
			tableveiculo.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Veiculo");
		}

	}

	public void ListarVeiculosDisponiveis(JTable tableveiculo) throws Excecao {

		VeiculoDAO veiculoDao = new VeiculoDAO();

		DefaultTableModel tablemodel = (DefaultTableModel) viewConsultaVeiculo.getTableVeiculo().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<VeiculoModel> veiculosDisponiveis = veiculoDao.listarVeiculosDisponiveis();

			for (VeiculoModel model : veiculosDisponiveis) {
				tablemodel.addRow(new Object[] { model.getCodigo(), model.getMarca(), model.getModelo(), model.getAno(),
						model.getPlaca(), model.getCor(), model.getEstado(), model.getStatus() });
			}
			tableveiculo.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Veiculo");
		}

	}

	public void ListarVeiculosAlugados(JTable tableveiculo) throws Excecao {

		VeiculoDAO veiculoDao = new VeiculoDAO();

		DefaultTableModel tablemodel = (DefaultTableModel) viewConsultaVeiculo.getTableVeiculo().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<VeiculoModel> veiculosDisponiveis = veiculoDao.listarVeiculosAlugados();

			for (VeiculoModel model : veiculosDisponiveis) {
				tablemodel.addRow(new Object[] { model.getCodigo(), model.getMarca(), model.getModelo(), model.getAno(),
						model.getPlaca(), model.getCor(), model.getEstado(), model.getStatus() });
			}
			tableveiculo.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Veiculo");
		}

	}

	public void ListarVeiculosPeloModeloAtualizarExcluir(JTable tableveiculo) throws Excecao {

		VeiculoDAO veiculoDao = new VeiculoDAO();

		String modelo = viewTelaAtualizarExcluirVeiculo.getCampoModelo().getText();

		DefaultTableModel tablemodel = (DefaultTableModel) viewTelaAtualizarExcluirVeiculo.getTableModelo().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<VeiculoModel> veiculosModelo = veiculoDao.listarVeiculosPeloModeloAtualizarExcluir(modelo);

			for (VeiculoModel model : veiculosModelo) {
				tablemodel.addRow(new Object[] { model.getModelo(), model.getMarca(), model.getAno(), model.getPlaca(),
						model.getCor(), model.getRenavam(), model.getDescricao(), model.getEstado() });
			}
			tableveiculo.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Veiculo");
		}

	}

	public void SelecionarModeloAtualizarVeiculo(JTable tableModelo, int linha) {

		linha = tableModelo.getSelectedRow();

		JComboBox cor = viewTelaAtualizarExcluirVeiculo.getComboBoxCor();
		JComboBox estado = viewTelaAtualizarExcluirVeiculo.getComboBoxEstado();
		estado.removeAllItems(); // nao tava setando quando o estado e diferente , por isso esse remove

		viewTelaAtualizarExcluirVeiculo.getCampoModelo().setText((String) tableModelo.getValueAt(linha, 0));
		viewTelaAtualizarExcluirVeiculo.getCampoMarca().setText((String) tableModelo.getValueAt(linha, 1));
		viewTelaAtualizarExcluirVeiculo.getCampoAno().setText((String) tableModelo.getValueAt(linha, 2));
		viewTelaAtualizarExcluirVeiculo.getCampoPlaca().setText((String) tableModelo.getValueAt(linha, 3));
		cor.addItem(tableModelo.getValueAt(linha, 4));
		viewTelaAtualizarExcluirVeiculo.getCampoRenavam().setText((String) tableModelo.getValueAt(linha, 5));
		viewTelaAtualizarExcluirVeiculo.getCampoDescricao().setText((String) tableModelo.getValueAt(linha, 6));
		estado.addItem(tableModelo.getValueAt(linha, 7));

		if (estado.getSelectedItem().equals("NOVO")) {
			estado.addItem("SEMINOVO");
		} else {

			estado.addItem("NOVO");
		}

		if (cor.getSelectedItem().equals("PRETO")) {
			cor.removeAllItems();
			cor.addItem("BRANCO");
			cor.addItem("CINZA");
			cor.addItem("VERMELHO");
			cor.addItem("PRATA");
		} else if (cor.getSelectedItem().equals("BRANCO")) {
			cor.removeAllItems();
			cor.addItem("PRETO");
			cor.addItem("CINZA");
			cor.addItem("VERMELHO");
			cor.addItem("PRATA");
		} else if (cor.getSelectedItem().equals("CINZA")) {
			cor.removeAllItems();
			cor.addItem("PRETO");
			cor.addItem("BRANCO");
			cor.addItem("VERMELHO");
			cor.addItem("PRATA");
		} else if (cor.getSelectedItem().equals("VERMELHO")) {
			cor.removeAllItems();
			cor.addItem("PRETO");
			cor.addItem("BRANCO");
			cor.addItem("CINZA");
			cor.addItem("PRATA");
		} else {
			cor.removeAllItems();
			cor.addItem("PRETO");
			cor.addItem("BRANCO");
			cor.addItem("CINZA");
			cor.addItem("VERMELHO");
		}

	}

	public void AtualizarVeiculo(int confirm) throws Excecao {

		String marca = viewTelaAtualizarExcluirVeiculo.getCampoMarca().getText().toUpperCase();
		String modelo = viewTelaAtualizarExcluirVeiculo.getCampoModelo().getText().toUpperCase();
		String ano = viewTelaAtualizarExcluirVeiculo.getCampoAno().getText();
		String placa = viewTelaAtualizarExcluirVeiculo.getCampoPlaca().getText();
		String cor = (String) viewTelaAtualizarExcluirVeiculo.getComboBoxCor().getSelectedItem();
		String renavam = viewTelaAtualizarExcluirVeiculo.getCampoRenavam().getText();
		String descricao = viewTelaAtualizarExcluirVeiculo.getCampoDescricao().getText().toUpperCase();
		String estado = (String) viewTelaAtualizarExcluirVeiculo.getComboBoxEstado().getSelectedItem();

		VeiculoModel model = new VeiculoModel(marca, modelo, placa, cor, descricao, estado, ano, renavam);
		VeiculoDAO veiculoDao = new VeiculoDAO();

		if (confirm == 0) {
			if (marca.trim().isEmpty() && modelo.trim().isEmpty() && ano.trim().isEmpty() && placa.trim().isEmpty()) {
				throw new Excecao("Preencha Corretamente os Campos");
			} else {
				try {
					veiculoDao.AtualizarVeiculo(model, renavam);

					new ViewMenuPrincipal().chamarMenuPrincipal();
					viewTelaAtualizarExcluirVeiculo.MinimizarTelaAlterarExcluirVeiculo();

				} catch (Exception e) {
					throw new Excecao("Nao Foi Possivel Atualizar o Veiculo");
				}
			}

		}

	}

	public void ExcluirVeiculo(int confirm) throws Excecao {
		String marca = viewTelaAtualizarExcluirVeiculo.getCampoMarca().getText();
		String modelo = viewTelaAtualizarExcluirVeiculo.getCampoModelo().getText();
		String renavam = viewTelaAtualizarExcluirVeiculo.getCampoRenavam().getText();

		VeiculoDAO veiculoDao = new VeiculoDAO();

		/**/

		if (confirm == 0) {
			if (marca.trim().isEmpty() && modelo.trim().isEmpty()) {
				throw new Excecao("Preencha Corretamente os Campos");
			} else {
				try {

					veiculoDao.ExcluirVeiculo(renavam);

					new ViewMenuPrincipal().chamarMenuPrincipal();
					viewTelaAtualizarExcluirVeiculo.MinimizarTelaAlterarExcluirVeiculo();

				} catch (Exception e) {
					throw new Excecao("Nao Foi Possivel Excluir o Veiculo");
				}
			}

		}
	}
}
