package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Excecoes.Excecao;
import conexao.ConexaoDAO;
import model.ClienteModel;
import model.ColaboradorModel;

public class ColaboradorDAO {

	public ColaboradorDAO() {
		// TODO Auto-generated constructor stub
	}

	Connection connect;
	PreparedStatement pstm;
	ResultSet rs;

	public void cadastrarColaborador(ColaboradorModel colaborador) {

		String sql = "INSERT INTO colaborador (nome,cpf,rg,endereco,cidade,login,senha) VALUES (?,?,?,?,?,?,?)";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			pstm.setString(1, colaborador.getNome());
			pstm.setString(2, colaborador.getCpf());
			pstm.setString(3, colaborador.getRg());
			pstm.setString(4, colaborador.getEndereco());
			pstm.setString(5, colaborador.getCidade());
			pstm.setString(6, colaborador.getLogin());
			pstm.setString(7, colaborador.getSenha());

			pstm.execute();
			JOptionPane.showMessageDialog(null, "Colaborador Cadastrado com Sucesso!");
			pstm.close();

		} catch (Exception e) {
			

		}

	}

	public boolean loginColaborador(ColaboradorModel colaborador) {
		connect = new ConexaoDAO().getConexao();

		String sql = "Select * from colaborador where login = ? and senha = ?";

		try {
			pstm = connect.prepareStatement(sql);

			pstm.setString(1, colaborador.getLogin());
			pstm.setString(2, colaborador.getSenha());
			rs = pstm.executeQuery();

			return rs.next();

		} catch (Exception e) {

		}
		return false;

	}

	public ArrayList<ColaboradorModel> listarTodosColaboradores()  {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<ColaboradorModel> colaborador = null;

		String sql = "select * from colaborador order by nome";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				colaborador = new ArrayList<ColaboradorModel>();
				while (rs.next()) {
					ColaboradorModel colaboradores = new ColaboradorModel();

					colaboradores.setCodigo(rs.getInt("id_colaborador"));
					colaboradores.setNome(rs.getString("nome"));
					colaboradores.setCpf(rs.getString("cpf"));
					colaboradores.setRg(rs.getString("rg"));
					colaboradores.setEndereco(rs.getString("endereco"));
					colaboradores.setCidade(rs.getString("cidade"));

					colaborador.add(colaboradores);

				}
			}

		} catch (Exception e) {
			

		}
		return colaborador;

	}

	public ArrayList<ColaboradorModel> listarColaboradorCPF(String cpf)  {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<ColaboradorModel> colaboradores = null;

		String sql = "select * from colaborador where cpf like'%" + cpf + "%' order by nome";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				colaboradores = new ArrayList<ColaboradorModel>();
				while (rs.next()) {
					ColaboradorModel colaborador = new ColaboradorModel();

					colaborador.setCodigo(rs.getInt("id_colaborador"));
					colaborador.setNome(rs.getString("nome"));
					colaborador.setCpf(rs.getString("cpf"));
					colaborador.setRg(rs.getString("rg"));
					colaborador.setEndereco(rs.getString("endereco"));
					colaborador.setCidade(rs.getString("cidade"));

					colaboradores.add(colaborador);

				}
			}

		} catch (Exception e) {
			
		}
		return colaboradores;

	}

	public ArrayList<ColaboradorModel> listarColaboradorNome(String nome)  {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<ColaboradorModel> colaboradores = null;

		String sql = "select * from colaborador where nome ~*'" + nome + "' order by nome";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				colaboradores = new ArrayList<ColaboradorModel>();
				while (rs.next()) {
					ColaboradorModel colaborador = new ColaboradorModel();

					colaborador.setCodigo(rs.getInt("id_colaborador"));
					colaborador.setNome(rs.getString("nome"));
					colaborador.setCpf(rs.getString("cpf"));
					colaborador.setRg(rs.getString("rg"));
					colaborador.setEndereco(rs.getString("endereco"));
					colaborador.setCidade(rs.getString("cidade"));

					colaboradores.add(colaborador);

				}
			}

		} catch (Exception e) {
			
		}
		return colaboradores;

	}

	public void AtualizarColaborador(ColaboradorModel colaborador, String cpf)  {
		Connection connect;
		PreparedStatement pstm;

		connect = new ConexaoDAO().getConexao();

		String sql = "update colaborador set nome = ?,endereco = ?,cidade = ? where cpf = '" + cpf + "'";

		try {

			pstm = connect.prepareStatement(sql);
			pstm.setString(1, colaborador.getNome());
			pstm.setString(2, colaborador.getEndereco());
			pstm.setString(3, colaborador.getCidade());

			pstm.execute();
			JOptionPane.showMessageDialog(null, "Colaborador Alterado com Sucesso");
			pstm.close();
		} catch (Exception e) {
			
		}

	}

	public void ExcluirColaborador(String cpf)  {
		Connection connect;
		PreparedStatement pstm;

		connect = new ConexaoDAO().getConexao();

		String sql = "delete from colaborador where cpf = '" + cpf + "'";

		try {

			pstm = connect.prepareStatement(sql);

			pstm.execute();

			JOptionPane.showMessageDialog(null, "Cliente Excluido com Sucesso");

			pstm.close();
		} catch (Exception e) {
			
		}

	}

}
