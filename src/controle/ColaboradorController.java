package controle;

import java.sql.ResultSet;

import java.util.ArrayList;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Excecoes.Excecao;
import dao.ClienteDAO;
import dao.ColaboradorDAO;
import model.ClienteModel;
import model.ColaboradorModel;
import model.VeiculoModel;
import serializacao.Deserializador;
import serializacao.Serializador;
import view.ViewTelaConsultaColaborador;
import view.ViewMenuPrincipal;
import view.ViewTelaCadastroColaborador;
import view.ViewTelaLogin;
import view.ViewTelaAtualizarExcluirColaborador;

public class ColaboradorController {

	private ViewMenuPrincipal ViewMenuPrincipal;
	private ViewTelaCadastroColaborador ViewCadastroColaborador;
	private ViewTelaConsultaColaborador ViewConsultaColaborador;
	private ViewTelaAtualizarExcluirColaborador ViewTelaAtualizarColaborador;
	private ColaboradorModel model;

	public ColaboradorController() {
		// TODO Auto-generated constructor stub
	}

	public ColaboradorController(ViewTelaCadastroColaborador ViewCadastroColaborador, ColaboradorModel model) {

		this.ViewCadastroColaborador = ViewCadastroColaborador;
		this.model = model;
	}

	public ColaboradorController(ViewTelaConsultaColaborador ViewConsultaColaboradorView, ColaboradorModel model) {
		this.model = model;
		this.ViewConsultaColaborador = ViewConsultaColaboradorView;
	}

	public ColaboradorController(ViewTelaAtualizarExcluirColaborador ViewTelaAtualizarColaborador,
			ColaboradorModel model) {
		this.model = model;
		this.ViewTelaAtualizarColaborador = ViewTelaAtualizarColaborador;
	}

	private static boolean VerificarInteiro(String str) {
		return str != null && str.matches("[0-9]*");
	}

	public void CadastrarColaborador(int confirm) throws Excecao {
		String nome = ViewCadastroColaborador.getCampoNomeCadastroFuncionario().getText().toUpperCase();
		String cpf = ViewCadastroColaborador.getCampoCpfCadastroFuncionario().getText();
		String rg = ViewCadastroColaborador.getCampoRgCadastroFuncionario().getText();
		String endereco = ViewCadastroColaborador.getCampoEnderecoCadastroFuncionario().getText().toUpperCase();
		String cidade = ViewCadastroColaborador.getCampoCidadeCadastroFuncionario().getText().toUpperCase();
		String login = ViewCadastroColaborador.getCampoLoginCadFuncionario().getText();
		String senha = ViewCadastroColaborador.getCampoSenhaCadFuncionario().getText();

		ColaboradorModel model = new ColaboradorModel(nome, cpf, rg, endereco, cidade, senha, login);
		ColaboradorDAO colaboradorDao = new ColaboradorDAO();

		if (confirm == 0) {
			if (VerificarInteiro(rg) && VerificarInteiro(cpf)) {
				if (nome.isEmpty() || cpf.isEmpty() || rg.isEmpty() || endereco.isEmpty() || cidade.isEmpty()
						|| login.isEmpty() || senha.isEmpty()) {
					throw new Excecao("Preencha os Campos Corretamente");
				} else {
					try {
						colaboradorDao.cadastrarColaborador(model);

						ViewMenuPrincipal.chamarMenuPrincipal();
					} catch (Exception e) {
						throw new Excecao("Erro ao cadastrar Colaborador");
					}

				}
			} else
				throw new Excecao("CPF/RG Invalidos");

		}
	}

	public void SerializarColaborador() {

		String nome = ViewCadastroColaborador.getCampoNomeCadastroFuncionario().getText();
		String cpf = ViewCadastroColaborador.getCampoCpfCadastroFuncionario().getText();
		String rg = ViewCadastroColaborador.getCampoRgCadastroFuncionario().getText();
		String endereco = ViewCadastroColaborador.getCampoEnderecoCadastroFuncionario().getText();
		String cidade = ViewCadastroColaborador.getCampoCidadeCadastroFuncionario().getText();
		String login = ViewCadastroColaborador.getCampoLoginCadFuncionario().getText();
		String senha = ViewCadastroColaborador.getCampoSenhaCadFuncionario().getText();

		ColaboradorModel model = new ColaboradorModel(nome, cpf, rg, endereco, cidade, senha, login);

		try {
			Serializador s = new Serializador();

			s.serializar("./colaboradorcadastro", model);
		} catch (Exception e) {

		}

	}

	public void DeserializarColaborador() {
		ColaboradorModel model = new ColaboradorModel();
		try {

			Deserializador d = new Deserializador();
			model = (ColaboradorModel) d.deserializar("./colaboradorcadastro");
		} catch (Exception e) {

		}
		String nome = model.getNome();
		String cpf = model.getCpf();
		String rg = model.getRg();
		String endereco = model.getEndereco();
		String cidade = model.getCidade();

		ViewCadastroColaborador.getCampoNomeCadastroFuncionario().setText(nome);
		ViewCadastroColaborador.getCampoCpfCadastroFuncionario().setText(cpf);
		ViewCadastroColaborador.getCampoRgCadastroFuncionario().setText(rg);
		ViewCadastroColaborador.getCampoEnderecoCadastroFuncionario().setText(endereco);
		ViewCadastroColaborador.getCampoCidadeCadastroFuncionario().setText(cidade);

	}

	public void RecuperarDadosCadastroColaborador() throws Excecao {
		if (!ViewCadastroColaborador.getCampoNomeCadastroFuncionario().getText().isEmpty()
				|| !ViewCadastroColaborador.getCampoCpfCadastroFuncionario().getText().isEmpty()
				|| !ViewCadastroColaborador.getCampoRgCadastroFuncionario().getText().isEmpty()
				|| !ViewCadastroColaborador.getCampoEnderecoCadastroFuncionario().getText().isEmpty()
				|| !ViewCadastroColaborador.getCampoCidadeCadastroFuncionario().getText().isEmpty()) {
			int confirm = JOptionPane.showConfirmDialog(null, "Recuperar Dados Anteriores ?");
			if (confirm == 0) {
				try {
					DeserializarColaborador();
				} catch (Exception e) {
					throw new Excecao("Erro ao Recuperar Dados Colaborador");
				}

			} else if (confirm == 1) {
				LimparCamposCadastroColaborador();
			}
		}
	}

	public void LimparCamposCadastroColaborador() {
		ViewCadastroColaborador.getCampoNomeCadastroFuncionario().setText("");
		ViewCadastroColaborador.getCampoCpfCadastroFuncionario().setText("");
		ViewCadastroColaborador.getCampoRgCadastroFuncionario().setText("");
		ViewCadastroColaborador.getCampoEnderecoCadastroFuncionario().setText("");
		ViewCadastroColaborador.getCampoCidadeCadastroFuncionario().setText("");
		ViewCadastroColaborador.getCampoLoginCadFuncionario().setText("");
		ViewCadastroColaborador.getCampoSenhaCadFuncionario().setText("");
	}

	public void LimparCamposAlterarExcluirColaborador() {
		ViewTelaAtualizarColaborador.getCampoNomeAtualizarColaborador().setText("");
		ViewTelaAtualizarColaborador.getCampoCpfAtualizarColaboradoro().setText("");
		ViewTelaAtualizarColaborador.getCampoRgAtualizarColaborador().setText("");
		ViewTelaAtualizarColaborador.getCampoEnderecoAtualizarColaborador().setText("");
		ViewTelaAtualizarColaborador.getCampoCidadeAtualizarColaborador().setText("");

	}

	public void ConsultarColaboradorPeloCpf(JTable tableColaborador) throws Excecao {
		ColaboradorDAO colaboradorDao = new ColaboradorDAO();

		String cpf = ViewConsultaColaborador.getCampoCPF().getText();

		DefaultTableModel tablemodel = (DefaultTableModel) ViewConsultaColaborador.getTableColaborador().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<ColaboradorModel> colaborador = colaboradorDao.listarColaboradorCPF(cpf);
			for (ColaboradorModel colab : colaborador) {

				tablemodel.addRow(new Object[] { colab.getCodigo(), colab.getNome(), colab.getCpf(), colab.getRg(),
						colab.getEndereco(), colab.getCidade() });
			}

			tableColaborador.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Colaborador");
		}

	}

	public void ConsultarColaboradorPeloNome(JTable tableColaborador) throws Excecao {
		ColaboradorDAO colaboradorDao = new ColaboradorDAO();

		String nome = ViewConsultaColaborador.getCampoNome().getText();

		DefaultTableModel tablemodel = (DefaultTableModel) ViewConsultaColaborador.getTableColaborador().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<ColaboradorModel> colaborador = colaboradorDao.listarColaboradorNome(nome);
			for (ColaboradorModel colab : colaborador) {

				tablemodel.addRow(new Object[] { colab.getCodigo(), colab.getNome(), colab.getCpf(), colab.getRg(),
						colab.getEndereco(), colab.getCidade() });
			}

			tableColaborador.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Colaborador");
		}

	}

	public void ConsultarTodosColaboradores(JTable tableColaborador) throws Excecao {
		ColaboradorDAO colaboradorDao = new ColaboradorDAO();

		DefaultTableModel tablemodel = (DefaultTableModel) ViewConsultaColaborador.getTableColaborador().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<ColaboradorModel> colaborador = colaboradorDao.listarTodosColaboradores();
			for (ColaboradorModel colab : colaborador) {

				tablemodel.addRow(new Object[] { colab.getCodigo(), colab.getNome(), colab.getCpf(), colab.getRg(),
						colab.getEndereco(), colab.getCidade() });
			}

			tableColaborador.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Colaborador");
		}

	}

	public void ListarNomesColaboradorAtualizacao(JTable tableNome) throws Excecao {
		ColaboradorDAO colaboradorDao = new ColaboradorDAO();

		String nome = ViewTelaAtualizarColaborador.getCampoNomeAtualizarColaborador().getText();

		DefaultTableModel tablemodel = (DefaultTableModel) ViewTelaAtualizarColaborador.getTableNome().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<ColaboradorModel> listarColaboradores = colaboradorDao.listarColaboradorNome(nome);

			for (ColaboradorModel model : listarColaboradores) {
				tablemodel.addRow(new Object[] { model.getNome(), model.getCpf(), model.getRg(), model.getEndereco(),
						model.getCidade() });
			}
			tableNome.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Colaborador");
		}
	}

	public void SelecionarNomeAtualizarColaborador(JTable tableNome, int linha) {

		linha = tableNome.getSelectedRow();

		ViewTelaAtualizarColaborador.getCampoNomeAtualizarColaborador()
				.setText((String) tableNome.getValueAt(linha, 0));
		ViewTelaAtualizarColaborador.getCampoCpfAtualizarColaboradoro()
				.setText((String) tableNome.getValueAt(linha, 1));
		ViewTelaAtualizarColaborador.getCampoRgAtualizarColaborador().setText((String) tableNome.getValueAt(linha, 2));
		ViewTelaAtualizarColaborador.getCampoEnderecoAtualizarColaborador()
				.setText((String) tableNome.getValueAt(linha, 3));
		ViewTelaAtualizarColaborador.getCampoCidadeAtualizarColaborador()
				.setText((String) tableNome.getValueAt(linha, 4));
	}

	public void AtualizarColaborador(int confirm) throws Excecao {

		String nome = ViewTelaAtualizarColaborador.getCampoNomeAtualizarColaborador().getText().toUpperCase();
		String cpf = ViewTelaAtualizarColaborador.getCampoCpfAtualizarColaboradoro().getText(); // usado para o Dao
		String endereco = ViewTelaAtualizarColaborador.getCampoEnderecoAtualizarColaborador().getText().toUpperCase();
		String cidade = ViewTelaAtualizarColaborador.getCampoCidadeAtualizarColaborador().getText().toUpperCase();

		ColaboradorModel model = new ColaboradorModel(nome, endereco, cidade);
		ColaboradorDAO colaboradorDao = new ColaboradorDAO();

		if (confirm == 0) {
			if (nome.trim().isEmpty() && endereco.trim().isEmpty() && cidade.trim().isEmpty()) {
				JOptionPane.showMessageDialog(null, "Preencha os Campos Corretamente");
			} else {
				try {
					colaboradorDao.AtualizarColaborador(model, cpf);

					new ViewMenuPrincipal().chamarMenuPrincipal();
					ViewTelaAtualizarColaborador.MinimizarTelaAtualizarColaborador();

				} catch (Exception e) {
					throw new Excecao("Erro ao Atualizar Colaborador");
				}

			}

		}

	}

	public void ExcluirColaborador(int confirm) throws Excecao {
		String nome = ViewTelaAtualizarColaborador.getCampoNomeAtualizarColaborador().getText();
		String cpf = ViewTelaAtualizarColaborador.getCampoCpfAtualizarColaboradoro().getText();
		ColaboradorDAO colaboradorDao = new ColaboradorDAO();

		if (confirm == 0) {
			if (cpf.trim().isEmpty() && nome.trim().isEmpty()) {
				throw new Excecao("Preencha os Campos Corretamente");
			} else {
				try {

					colaboradorDao.ExcluirColaborador(cpf);

					new ViewMenuPrincipal().chamarMenuPrincipal();
					ViewTelaAtualizarColaborador.MinimizarTelaAtualizarColaborador();
				} catch (Exception e) {
					throw new Excecao("Erro ao Excluir Colaborador");
				}

			}

		}
	}
}
