package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexao.ConexaoDAO;
import model.LocacaoModel;
import model.VeiculoModel;

public class LocacaoDAO {

	Connection connect;
	PreparedStatement pstm;

	public LocacaoDAO() {
		// TODO Auto-generated constructor stub
	}

	public void CadastrarLocacao(LocacaoModel locacao) {

		connect = new ConexaoDAO().getConexao();

		String sql = "insert into locacao (cpf_cliente,marca,modelo,ano,cor,estado,datalocacao,formapagamento,tempolocacao,codveiculo,status) values (?,?,?,?,?,?,?,?,?,?,'EM ABERTO')";

		try {

			pstm = connect.prepareStatement(sql);
			pstm.setString(1, locacao.getCpf_cliente());
			pstm.setString(2, locacao.getMarca());
			pstm.setString(3, locacao.getModelo());
			pstm.setString(4, locacao.getAno());
			pstm.setString(5, locacao.getCor());
			pstm.setString(6, locacao.getEstado());
			pstm.setString(7, locacao.getDataLocacao());
			pstm.setString(8, locacao.getFormaPagamento());
			pstm.setString(9, locacao.getTempoLocacao());
			pstm.setInt(10, locacao.getCod_veiculo());

			pstm.execute();

			pstm.close();

			JOptionPane.showMessageDialog(null, "Locacao Concluida com Sucesso");

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Cliente Possui Locacao Em Aberto");
		}

	}

	public void AtualizarStatusDoVeiculoAlugado(int codveiculo) {
		connect = new ConexaoDAO().getConexao();

		String sql = "update veiculo set status = 'ALUGADO' WHERE codveiculo in(select codveiculo from locacao where codveiculo = "
				+ codveiculo + " and status = 'EM ABERTO')";

		try {

			pstm = connect.prepareStatement(sql);

			pstm.execute();
			pstm.close();

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao  Locacar");
		}

	}

	public ArrayList<LocacaoModel> listarLocacoesPeloModeloVeiculo(String modelo) {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<LocacaoModel> locacoes = null;

		String sql = "select codcontrato,nome,cpf_cliente,marca,modelo,cor,datalocacao,formapagamento,tempolocacao,codveiculo from locacao inner join clientes on cpf_cliente=cpf where modelo ~*'"
				+ modelo + "'order by modelo";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				locacoes = new ArrayList<LocacaoModel>();
				while (rs.next()) {
					LocacaoModel model = new LocacaoModel();

					model.setCodContrato(rs.getInt("codcontrato"));
					model.setNome(rs.getString("nome"));
					model.setCpf_cliente(rs.getString("cpf_cliente"));
					model.setMarca(rs.getString("marca"));
					model.setModelo(rs.getString("modelo"));
					model.setCor(rs.getString("cor"));
					model.setDataLocacao(rs.getString("datalocacao"));
					model.setFormaPagamento(rs.getString("formapagamento"));
					model.setTempoLocacao(rs.getString("tempolocacao"));
					model.setCod_veiculo(rs.getInt("codveiculo"));

					locacoes.add(model);

				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Consultar Locacoes");
		}
		return locacoes;

	}

	public ArrayList<LocacaoModel> listarLocacoesPeloCpfCliente(String cpf) {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<LocacaoModel> locacoes = null;

		String sql = "select codcontrato,nome,cpf_cliente,marca,modelo,cor,datalocacao,formapagamento,tempolocacao,codveiculo from locacao inner join clientes on cpf_cliente = cpf where cpf_cliente ~*'"
				+ cpf + "'order by cpf_cliente";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				locacoes = new ArrayList<LocacaoModel>();
				while (rs.next()) {
					LocacaoModel model = new LocacaoModel();

					model.setCodContrato(rs.getInt("codcontrato"));
					model.setNome(rs.getString("nome"));
					model.setCpf_cliente(rs.getString("cpf_cliente"));
					model.setMarca(rs.getString("marca"));
					model.setModelo(rs.getString("modelo"));
					model.setCor(rs.getString("cor"));
					model.setDataLocacao(rs.getString("datalocacao"));
					model.setFormaPagamento(rs.getString("formapagamento"));
					model.setTempoLocacao(rs.getString("tempolocacao"));
					model.setCod_veiculo(rs.getInt("codveiculo"));

					locacoes.add(model);

				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Consultar Locacoes");
		}
		return locacoes;

	}

	public ArrayList<LocacaoModel> listarTodasLocacoes() {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<LocacaoModel> locacoes = null;

		String sql = "select codcontrato,nome,cpf_cliente,marca,modelo,cor,datalocacao,formapagamento,tempolocacao,codveiculo from locacao inner join clientes on cpf_cliente = cpf order by modelo";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				locacoes = new ArrayList<LocacaoModel>();
				while (rs.next()) {
					LocacaoModel model = new LocacaoModel();

					model.setCodContrato(rs.getInt("codcontrato"));
					model.setNome(rs.getString("nome"));
					model.setCpf_cliente(rs.getString("cpf_cliente"));
					model.setMarca(rs.getString("marca"));
					model.setModelo(rs.getString("modelo"));
					model.setCor(rs.getString("cor"));
					model.setDataLocacao(rs.getString("datalocacao"));
					model.setFormaPagamento(rs.getString("formapagamento"));
					model.setTempoLocacao(rs.getString("tempolocacao"));
					model.setCod_veiculo(rs.getInt("codveiculo"));

					locacoes.add(model);

				}
			}

		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Erro ao Consultar Locacoes");
		}
		return locacoes;

	}

	public void AtualizarStatusLocacaoCliente(String cpf) {
		Connection connect;
		PreparedStatement pstm;

		connect = new ConexaoDAO().getConexao();

		String sql = "update clientes set possui_locacao = 'SIM' where cpf in(select cpf_cliente from locacao where cpf like'"
				+ cpf + "'and  status = 'EM ABERTO')";

		try {

			pstm = connect.prepareStatement(sql);
			pstm.execute();

			pstm.close();
		} catch (Exception e) {

		}

	}

}
