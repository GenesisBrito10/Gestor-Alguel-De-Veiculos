package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexao.ConexaoDAO;
import model.DevolucaoModel;
import model.LocacaoModel;

public class DevolucaoDAO {

	public DevolucaoDAO() {
		// TODO Auto-generated constructor stub
	}

	public ArrayList<DevolucaoModel> listarDevolucoesPeloNomeCliente(String nome) {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<DevolucaoModel> locacoes = null;

		String sql = "select nome,cpf_cliente,cidade,codcontrato,marca,estado,modelo,ano,cor,datalocacao,formapagamento,tempolocacao,"
				+ "codveiculo from locacao inner join clientes on cpf_cliente=cpf where nome ~*'" + nome
				+ "' and possui_locacao = 'SIM' order by nome";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				locacoes = new ArrayList<DevolucaoModel>();
				while (rs.next()) {
					DevolucaoModel model = new DevolucaoModel();

					model.setNome(rs.getString("nome"));
					model.setCodContrato(rs.getInt("codcontrato"));
					model.setCpf_cliente(rs.getString("cpf_cliente"));
					model.setCidade(rs.getString("cidade"));
					model.setMarca(rs.getString("marca"));
					model.setModelo(rs.getString("modelo"));
					model.setAno(rs.getString("ano"));
					model.setCor(rs.getString("cor"));
					model.setEstado(rs.getString("estado"));
					model.setDataLocacao(rs.getString("datalocacao"));
					model.setFormaPagamento(rs.getString("formapagamento"));
					model.setTempoLocacao(rs.getString("tempolocacao"));
					model.setCod_veiculo(rs.getInt("codveiculo"));

					locacoes.add(model);

				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Listar Locacoes");
		}
		return locacoes;

	}
	
	public ArrayList<DevolucaoModel> listarHistoricoDevolucoes() {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<DevolucaoModel> locacoes = null;

		String sql = "select * from devolucao";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				locacoes = new ArrayList<DevolucaoModel>();
				while (rs.next()) {
					DevolucaoModel model = new DevolucaoModel();

					model.setNome(rs.getString("nome"));
					model.setCodContrato(rs.getInt("codcontrato"));
					model.setCpf_cliente(rs.getString("cpf"));
					model.setMarca(rs.getString("marca"));
					model.setModelo(rs.getString("modelo"));
					model.setAno(rs.getString("ano"));
					model.setCor(rs.getString("cor"));
					model.setEstado(rs.getString("estado"));
					model.setDataLocacao(rs.getString("datalocacao"));
					model.setDatadevolucao(rs.getString("datadevolucao"));
					model.setFormaPagamento(rs.getString("formapagamento"));
					model.setTempoLocacao(rs.getString("tempolocacao"));
					model.setCod_veiculo(rs.getInt("codveiculo"));
					model.setStatus(rs.getString("status"));

					locacoes.add(model);

				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Listar Historico");
		}
		return locacoes;

	}
	
	
	public ArrayList<DevolucaoModel> listarHistoricoDevolucoesPeloNome(String nome) {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<DevolucaoModel> locacoes = null;

		String sql = "select * from devolucao where nome ~*'" + nome + "'";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				locacoes = new ArrayList<DevolucaoModel>();
				while (rs.next()) {
					DevolucaoModel model = new DevolucaoModel();

					model.setNome(rs.getString("nome"));
					model.setCodContrato(rs.getInt("codcontrato"));
					model.setCpf_cliente(rs.getString("cpf"));
					model.setMarca(rs.getString("marca"));
					model.setModelo(rs.getString("modelo"));
					model.setAno(rs.getString("ano"));
					model.setCor(rs.getString("cor"));
					model.setEstado(rs.getString("estado"));
					model.setDataLocacao(rs.getString("datalocacao"));
					model.setDatadevolucao(rs.getString("datadevolucao"));
					model.setFormaPagamento(rs.getString("formapagamento"));
					model.setTempoLocacao(rs.getString("tempolocacao"));
					model.setCod_veiculo(rs.getInt("codveiculo"));
					model.setStatus(rs.getString("status"));

					locacoes.add(model);

				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Listar Historico");
		}
		return locacoes;

	}
	
	
	public ArrayList<DevolucaoModel> listarHistoricoDevolucoesPeloCpf(String cpf) {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<DevolucaoModel> locacoes = null;

		String sql = "select * from devolucao where cpf ~*'" + cpf + "'";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				locacoes = new ArrayList<DevolucaoModel>();
				while (rs.next()) {
					DevolucaoModel model = new DevolucaoModel();

					model.setNome(rs.getString("nome"));
					model.setCodContrato(rs.getInt("codcontrato"));
					model.setCpf_cliente(rs.getString("cpf"));
					model.setMarca(rs.getString("marca"));
					model.setModelo(rs.getString("modelo"));
					model.setAno(rs.getString("ano"));
					model.setCor(rs.getString("cor"));
					model.setEstado(rs.getString("estado"));
					model.setDataLocacao(rs.getString("datalocacao"));
					model.setDatadevolucao(rs.getString("datadevolucao"));
					model.setFormaPagamento(rs.getString("formapagamento"));
					model.setTempoLocacao(rs.getString("tempolocacao"));
					model.setCod_veiculo(rs.getInt("codveiculo"));
					model.setStatus(rs.getString("status"));

					locacoes.add(model);

				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Listar Historico");
		}
		return locacoes;

	}

	public void ConcluirDevolucao(DevolucaoModel model) {
		Connection connect = new ConexaoDAO().getConexao();

		String sql = "insert into devolucao(codcontrato,nome,cpf,marca,modelo,ano,cor,estado,datalocacao,datadevolucao,formapagamento,tempolocacao,codveiculo,status)"
				+ "values(?,?,?,?,?,?,?,?,?,?,?,?,?,'DEVOLUCAO CONCLUIDA')";

		try {
			PreparedStatement pstm = connect.prepareStatement(sql);

			pstm.setInt(1, model.getCodContrato());
			pstm.setString(2, model.getNome());
			pstm.setString(3, model.getCpf_cliente());
			pstm.setString(4, model.getMarca());
			pstm.setString(5, model.getModelo());
			pstm.setString(6, model.getAno());
			pstm.setString(7, model.getCor());
			pstm.setString(8, model.getEstado());
			pstm.setString(9, model.getDataLocacao());
			pstm.setString(10, model.getDatadevolucao());
			pstm.setString(11, model.getFormaPagamento());
			pstm.setString(12, model.getTempoLocacao());
			pstm.setInt(13, model.getCod_veiculo());
			

			pstm.execute();
			pstm.close();

			JOptionPane.showMessageDialog(null, "Devolucao Concluida com Sucesso");

		} catch (Exception e) {
			
		}

	}

	public void AtualizarStatusClienteDevolucaoLocacao(String cpf) {
		Connection connect;
		PreparedStatement pstm;

		connect = new ConexaoDAO().getConexao();

		String sql = "update clientes\r\n" + "set possui_locacao = 'NÃO'\r\n"
				+ "where cpf not in(select cpf_cliente from locacao where cpf like'" + cpf
				+ "' and  status = 'DEVOLUCAO CONCLUIDA')\r\n" + "";

		try {

			pstm = connect.prepareStatement(sql);
			pstm.execute();

			pstm.close();
		} catch (Exception e) {

		}

	}

	public void AtualizarStatusDoVeiculoDevolvido() {

		Connection connect;
		PreparedStatement pstm;
		connect = new ConexaoDAO().getConexao();

		String sql = "update veiculo set status = 'DISPONIVEL' WHERE codveiculo not in(select codveiculo from locacao where status = 'EM ABERTO')\r\n"
				+ "";

		try {

			pstm = connect.prepareStatement(sql);

			pstm.execute();
			pstm.close();

		} catch (Exception e) {

		}

	}

	public void AtualizarStatusLocacaoDoVeiculoDevolvido(int codveiculo) {

		Connection connect;
		PreparedStatement pstm;
		connect = new ConexaoDAO().getConexao();

		String sql = "delete from locacao where codveiculo = " + codveiculo + "";

		try {

			pstm = connect.prepareStatement(sql);

			pstm.execute();
			pstm.close();

		} catch (Exception e) {

		}

	}
	
	
	

}
