package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Excecoes.Excecao;
import conexao.ConexaoDAO;
import model.ClienteModel;
import model.LocacaoModel;

public class ClienteDAO {

	ConexaoDAO conexao = new ConexaoDAO();

	public ClienteDAO() {
		// TODO Auto-generated constructor stub
	}

	public void cadastrarCliente(ClienteModel cliente) {
		Connection connect;
		PreparedStatement pstm;

		String sql = "INSERT INTO clientes (nome,cpf,rg,endereco,cidade,possui_locacao) VALUES (?,?,?,?,?,'NÃO')";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getCpf());
			pstm.setString(3, cliente.getRg());
			pstm.setString(4, cliente.getEndereco());
			pstm.setString(5, cliente.getCidade());

			pstm.execute();
			JOptionPane.showMessageDialog(null, "Cliente Cadastrado com Sucesso");
			pstm.close();

		} catch (SQLException e) {

		}

	}

	public ArrayList<ClienteModel> listarTodosClientes() {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<ClienteModel> clientes = null;

		String sql = "select * from clientes order by nome";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				clientes = new ArrayList<ClienteModel>();
				while (rs.next()) {
					ClienteModel cliente = new ClienteModel();

					cliente.setCodigo(rs.getInt("id_cliente"));
					cliente.setNome(rs.getString("nome"));
					cliente.setCpf(rs.getString("cpf"));
					cliente.setRg(rs.getString("rg"));
					cliente.setEndereco(rs.getString("endereco"));
					cliente.setCidade(rs.getString("cidade"));

					clientes.add(cliente);

				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Consultar Cliente" + e);
		}
		return clientes;

	}

	public ArrayList<ClienteModel> listarClienteCPF(String cpf) {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<ClienteModel> clientes = null;

		String sql = "select * from clientes where cpf like'%" + cpf + "%' order by nome";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				clientes = new ArrayList<ClienteModel>();
				while (rs.next()) {
					ClienteModel cliente = new ClienteModel();

					cliente.setCodigo(rs.getInt("id_cliente"));
					cliente.setNome(rs.getString("nome"));
					cliente.setCpf(rs.getString("cpf"));
					cliente.setRg(rs.getString("rg"));
					cliente.setEndereco(rs.getString("endereco"));
					cliente.setCidade(rs.getString("cidade"));

					clientes.add(cliente);

				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Consultar Cliente" + e);
		}
		return clientes;

	}

	public ArrayList<ClienteModel> listarClienteNome(String nome) {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<ClienteModel> clientes = null;

		String sql = "select * from clientes where nome ~*'" + nome + "' order by nome";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				clientes = new ArrayList<ClienteModel>();
				while (rs.next()) {
					ClienteModel cliente = new ClienteModel();

					cliente.setCodigo(rs.getInt("id_cliente"));
					cliente.setNome(rs.getString("nome"));
					cliente.setCpf(rs.getString("cpf"));
					cliente.setRg(rs.getString("rg"));
					cliente.setEndereco(rs.getString("endereco"));
					cliente.setCidade(rs.getString("cidade"));

					clientes.add(cliente);

				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Consultar Cliente" + e);
		}
		return clientes;

	}

	public ArrayList<ClienteModel> PesquisaClientesLocacao() {

		Connection connect = null;
		PreparedStatement pstm;
		ResultSet rs;

		ArrayList<ClienteModel> clientes = null;

		String sql = "select nome,cpf,rg,endereco,cidade from clientes order by nome ";

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				clientes = new ArrayList<ClienteModel>();
				while (rs.next()) {
					ClienteModel cliente = new ClienteModel();

					cliente.setNome(rs.getString("nome"));
					cliente.setCpf(rs.getString("cpf"));
					cliente.setRg(rs.getString("rg"));
					cliente.setEndereco(rs.getString("endereco"));
					cliente.setCidade(rs.getString("cidade"));

					clientes.add(cliente);

				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Consultar Cliente" + e);
		}
		return clientes;

	}

	public ArrayList<ClienteModel> listarDevolucoesPeloCpf(String cpf) {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<ClienteModel> clientes = null;

		String sql = "select nome,cpf,cidade from clientes inner join locacao on cpf=cpf_cliente where cpf ~*'" + cpf
				+ "' order by cpf ";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				clientes = new ArrayList<ClienteModel>();
				while (rs.next()) {
					ClienteModel cliente = new ClienteModel();

					cliente.setNome(rs.getString("nome"));
					cliente.setCpf(rs.getString("cpf"));
					cliente.setCidade(rs.getString("cidade"));

					clientes.add(cliente);
				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Consultar Locacoes");
		}
		return clientes;

	}

	public void AtualizarCliente(ClienteModel cliente, String cpf) {
		Connection connect;
		PreparedStatement pstm;

		connect = new ConexaoDAO().getConexao();

		String sql = "update clientes set nome = ?,endereco = ?,cidade = ? where cpf = '" + cpf + "'";

		try {

			pstm = connect.prepareStatement(sql);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getEndereco());
			pstm.setString(3, cliente.getCidade());

			pstm.execute();
			JOptionPane.showMessageDialog(null, "Cliente Alterado com Sucesso");
			pstm.close();
		} catch (Exception e) {

		}

	}

	public void ExcluirCliente(String cpf) throws Excecao {
		Connection connect;
		PreparedStatement pstm;

		connect = new ConexaoDAO().getConexao();

		String sql = "delete from clientes where cpf = '" + cpf + "'";

		try {

			pstm = connect.prepareStatement(sql);

			pstm.execute();
			JOptionPane.showMessageDialog(null, "Cliente Excluido com Sucesso");
			pstm.close();
		} catch (Exception e) {
			
		}

	}

}
