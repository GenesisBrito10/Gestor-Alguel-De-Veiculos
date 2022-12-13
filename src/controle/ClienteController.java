package controle;

import java.util.ArrayList;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Excecoes.Excecao;

import dao.ClienteDAO;
import model.ClienteModel;
import model.VeiculoModel;
import serializacao.Deserializador;
import serializacao.Serializador;
import view.ViewTelaConsultaCliente;
import view.ViewMenuPrincipal;
import view.ViewTelaAtualizarExcluirCliente;
import view.ViewTelaCadastroCliente;

public class ClienteController {

	private ViewTelaCadastroCliente viewCadastroCliente;
	private ViewTelaConsultaCliente viewConsultaCliente;
	private ViewTelaAtualizarExcluirCliente viewAtualizarCliente;
	private ClienteModel model;

	public ClienteController() {

	}

	public ClienteController(ViewTelaCadastroCliente viewCadastroCliente, ClienteModel model) {
		this.model = model;
		this.viewCadastroCliente = viewCadastroCliente;

	}

	public ClienteController(ViewTelaConsultaCliente viewConsultaCliente, ClienteModel model) {
		this.model = model;
		this.viewConsultaCliente = viewConsultaCliente;
	}

	public ClienteController(ViewTelaAtualizarExcluirCliente viewAtualizarCliente, ClienteModel model) {
		this.model = model;
		this.viewAtualizarCliente = viewAtualizarCliente;
	}

	private static boolean VerificarInteiro(String str) {
		return str != null && str.matches("[0-9]*");
	}

	public void CadastrarCliente(int confirm) throws Excecao {
		String nome = viewCadastroCliente.getCampoNomeCadastroCliente().getText().toUpperCase();
		String cpf = viewCadastroCliente.getCampoCpfCadastroCliente().getText();
		String rg = viewCadastroCliente.getCampoRgCadastroCliente().getText();
		String endereco = viewCadastroCliente.getCampoEnderecoCadastroCliente().getText().toUpperCase();
		String cidade = viewCadastroCliente.getCampoCidadeCadastroCliente().getText().toUpperCase();

		ClienteModel model = new ClienteModel(nome, cpf, rg, endereco, cidade);
		ClienteDAO cadastrarCliente = new ClienteDAO();

		if (confirm == 0) {
			if (VerificarInteiro(cpf) && VerificarInteiro(rg)) {
				if (nome.trim().isEmpty() || cpf.isEmpty() || rg.isEmpty() || endereco.isEmpty() || cidade.isEmpty()) {
					throw new Excecao("Preencha os Campos Corretamente");

				} else {
					try {
						cadastrarCliente.cadastrarCliente(model);
						LimparCamposCadastroCliente();
					} catch (Exception e) {
						throw new Excecao("Erro ao Cadastrar Cliente");
					}
				}

			} else {
				throw new Excecao("Digite um RG/CPF Valido");

			}
		}

	}

	public void SerializarCliente() {

		String nome = viewCadastroCliente.getCampoNomeCadastroCliente().getText();
		String cpf = viewCadastroCliente.getCampoCpfCadastroCliente().getText();
		String rg = viewCadastroCliente.getCampoRgCadastroCliente().getText();
		String endereco = viewCadastroCliente.getCampoEnderecoCadastroCliente().getText();
		String cidade = viewCadastroCliente.getCampoCidadeCadastroCliente().getText();

		ClienteModel model = new ClienteModel(nome, cpf, rg, endereco, cidade); // tem que instanciar pra nao dar null
																				// na serilizacao

		try {
			Serializador s = new Serializador();

			s.serializar("./clientecadastro", model);
		} catch (Exception e) {

		}

	}

	public void DeserializarCliente() {
		ClienteModel model = new ClienteModel();
		try {

			Deserializador d = new Deserializador();
			model = (ClienteModel) d.deserializar("./clientecadastro");
		} catch (Exception e) {

		}
		String nome = model.getNome();
		String cpf = model.getCpf();
		String rg = model.getRg();
		String endereco = model.getEndereco();
		String cidade = model.getCidade();

		viewCadastroCliente.getCampoNomeCadastroCliente().setText(nome);
		viewCadastroCliente.getCampoCpfCadastroCliente().setText(cpf);
		viewCadastroCliente.getCampoRgCadastroCliente().setText(rg);
		viewCadastroCliente.getCampoEnderecoCadastroCliente().setText(endereco);
		viewCadastroCliente.getCampoCidadeCadastroCliente().setText(cidade);

	}

	public void RecuperarDadosCadastro() throws Excecao {
		if (!viewCadastroCliente.getCampoNomeCadastroCliente().getText().isEmpty()
				|| !viewCadastroCliente.getCampoCpfCadastroCliente().getText().isEmpty()
				|| !viewCadastroCliente.getCampoRgCadastroCliente().getText().isEmpty()
				|| !viewCadastroCliente.getCampoEnderecoCadastroCliente().getText().isEmpty()
				|| !viewCadastroCliente.getCampoCidadeCadastroCliente().getText().isEmpty()) {
			int confirm = JOptionPane.showConfirmDialog(null, "Recuperar Dados Anteriores ?");

			if (confirm == 0) {
				try {
					DeserializarCliente();
				} catch (Exception e) {
					throw new Excecao("Erro ao Recuperar os Dados");
				}

			} else if (confirm == 1) {
				LimparCamposCadastroCliente();
			}
		}
	}

	public void LimparCamposCadastroCliente() {
		viewCadastroCliente.getCampoNomeCadastroCliente().setText("");
		viewCadastroCliente.getCampoCpfCadastroCliente().setText("");
		viewCadastroCliente.getCampoRgCadastroCliente().setText("");
		viewCadastroCliente.getCampoEnderecoCadastroCliente().setText("");
		viewCadastroCliente.getCampoCidadeCadastroCliente().setText("");
	}

	public void LimparCamposAlterarExcluirCliente() {
		viewAtualizarCliente.getCampoNomeAtualizarCliente().setText("");
		viewAtualizarCliente.getCampoCpfAtualizarCliente().setText("");
		viewAtualizarCliente.getCampoRgAtualizarCliente().setText("");
		viewAtualizarCliente.getCampoEnderecoAtualizarCliente().setText("");
		viewAtualizarCliente.getCampoCidadeAtualizarCliente().setText("");
	}

	public void ListarTodosClienteConsulta(JTable tablecliente) throws Excecao {
		ClienteDAO listarTodosClienteDao = new ClienteDAO();

		DefaultTableModel tablemodel = (DefaultTableModel) viewConsultaCliente.getTableCliente().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<ClienteModel> listarTodosClientes = listarTodosClienteDao.listarTodosClientes();

			for (ClienteModel model : listarTodosClientes) {
				tablemodel.addRow(new Object[] { model.getCodigo(), model.getNome(), model.getCpf(), model.getRg(),
						model.getEndereco(), model.getCidade() });
			}
			tablecliente.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Clientes");
		}

	}

	public void ListarClientePeloNomeConsulta(JTable tablecliente) throws Excecao {
		ClienteDAO listarTodosClienteDao = new ClienteDAO();

		String nome = viewConsultaCliente.getCampoNome().getText();

		DefaultTableModel tablemodel = (DefaultTableModel) viewConsultaCliente.getTableCliente().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<ClienteModel> listarTodosClientes = listarTodosClienteDao.listarClienteNome(nome);

			for (ClienteModel model : listarTodosClientes) {
				tablemodel.addRow(new Object[] { model.getCodigo(), model.getNome(), model.getCpf(), model.getRg(),
						model.getEndereco(), model.getCidade() });
			}
			tablecliente.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Clientes");
		}
	}

	public void ListarClientePeloCpfConsulta(JTable tablecliente) throws Excecao {
		ClienteDAO listarTodosClienteDao = new ClienteDAO();

		String cpf = viewConsultaCliente.getCampoCPF().getText();

		DefaultTableModel tablemodel = (DefaultTableModel) viewConsultaCliente.getTableCliente().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<ClienteModel> listarTodosClientes = listarTodosClienteDao.listarClienteCPF(cpf);

			for (ClienteModel model : listarTodosClientes) {
				tablemodel.addRow(new Object[] { model.getCodigo(), model.getNome(), model.getCpf(), model.getRg(),
						model.getEndereco(), model.getCidade() });
			}
			tablecliente.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Clientes");
		}

	}

	public void ListarNomesClientesAtualizacao(JTable tableNome) throws Excecao {
		ClienteDAO listarTodosClienteDao = new ClienteDAO();

		String nome = viewAtualizarCliente.getCampoNomeAtualizarCliente().getText();

		DefaultTableModel tablemodel = (DefaultTableModel) viewAtualizarCliente.getTableNome().getModel();
		tablemodel.setRowCount(0);

		try {
			ArrayList<ClienteModel> listarTodosClientes = listarTodosClienteDao.listarClienteNome(nome);

			for (ClienteModel model : listarTodosClientes) {
				tablemodel.addRow(new Object[] { model.getNome(), model.getCpf(), model.getRg(), model.getEndereco(),
						model.getCidade(), model.getCodigo() });
			}
			tableNome.setModel(tablemodel);

		} catch (Exception e) {
			throw new Excecao("Erro ao Listar Clientes");
		}
	}

	public void SelecionarNomeAtualizarCliente(JTable tableNome, int linha) {

		linha = tableNome.getSelectedRow();

		viewAtualizarCliente.getCampoNomeAtualizarCliente().setText((String) tableNome.getValueAt(linha, 0));
		viewAtualizarCliente.getCampoCpfAtualizarCliente().setText((String) tableNome.getValueAt(linha, 1));
		viewAtualizarCliente.getCampoRgAtualizarCliente().setText((String) tableNome.getValueAt(linha, 2));
		viewAtualizarCliente.getCampoEnderecoAtualizarCliente().setText((String) tableNome.getValueAt(linha, 3));
		viewAtualizarCliente.getCampoCidadeAtualizarCliente().setText((String) tableNome.getValueAt(linha, 4));
	}

	public void AtualizarCliente(int confirm) throws Excecao {

		String nome = viewAtualizarCliente.getCampoNomeAtualizarCliente().getText().toUpperCase();
		String cpf = viewAtualizarCliente.getCampoCpfAtualizarCliente().getText(); // usado para o Dao
		String endereco = viewAtualizarCliente.getCampoEnderecoAtualizarCliente().getText().toUpperCase();
		String cidade = viewAtualizarCliente.getCampoCidadeAtualizarCliente().getText().toUpperCase();

		ClienteModel model = new ClienteModel(nome, endereco, cidade);
		ClienteDAO atualizarCliente = new ClienteDAO();

		try {

			if (confirm == 0) {
				if (nome.trim().isEmpty() || endereco.trim().isEmpty() || cidade.trim().isEmpty()) {

					throw new Excecao("Preencha os Campos Corretamente");
				} else {
					try {
						atualizarCliente.AtualizarCliente(model, cpf);

						new ViewMenuPrincipal().chamarMenuPrincipal();
						viewAtualizarCliente.MinimizarTelaAtualizarCliente();

					} catch (Exception e) {
						throw new Excecao("Nao Foi Possivel Atualizar o Cliente");
					}

				}

			}
		} catch (Excecao e) {

		}

	}

	public void ExcluirCliente(int confirm) throws Excecao {
		String nome = viewAtualizarCliente.getCampoNomeAtualizarCliente().getText();
		String cpf = viewAtualizarCliente.getCampoCpfAtualizarCliente().getText();
		String endereco = viewAtualizarCliente.getCampoEnderecoAtualizarCliente().getText();
		String cidade = viewAtualizarCliente.getCampoCidadeAtualizarCliente().getText();
		ClienteDAO excluirCliente = new ClienteDAO();

		if (confirm == 0) {

			if (cpf.trim().isEmpty() || nome.trim().isEmpty() || endereco.trim().isEmpty() || cidade.trim().isEmpty()) {
				throw new Excecao("Preencha os Campos Corretamente");
			} else {
				try {
					excluirCliente.ExcluirCliente(cpf);

					LimparCamposAlterarExcluirCliente();

				} catch (Exception e) {
					throw new Excecao("Nao foi Possivel Excluir o Cliente");
				}

			}

		}
	}
}
