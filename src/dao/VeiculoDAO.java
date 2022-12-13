package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import Excecoes.Excecao;
import conexao.ConexaoDAO;
import model.ClienteModel;
import model.VeiculoModel;

public class VeiculoDAO {

	public VeiculoDAO() {
		// TODO Auto-generated constructor stub
	}

	Connection connect;
	PreparedStatement pstm;

	public void cadastrarVeiculo(VeiculoModel veiculo) {

		String sql = "INSERT INTO veiculo (marca,modelo,ano,placa,cor,renavam,status,estado_veiculo,descricao) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			pstm.setString(1, veiculo.getMarca());
			pstm.setString(2, veiculo.getModelo());
			pstm.setString(3, veiculo.getAno());
			pstm.setString(4, veiculo.getPlaca());
			pstm.setString(5, veiculo.getCor());
			pstm.setString(6, veiculo.getRenavam());
			pstm.setString(7, veiculo.getStatus());
			pstm.setString(8, veiculo.getEstado());
			pstm.setString(9, veiculo.getDescricao());

			pstm.execute();
			JOptionPane.showMessageDialog(null, "Veiculo Cadastrado com Sucesso!");
			pstm.close();

		} catch (Exception e) {
			
			
		}

	}

	public ArrayList<VeiculoModel> listarTodosVeiculos() {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<VeiculoModel> veiculos = null;

		String sql = "select codveiculo,marca,modelo,ano,placa,cor,estado_veiculo,status from veiculo order by marca";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				veiculos = new ArrayList<VeiculoModel>();
				while (rs.next()) {
					VeiculoModel veiculo = new VeiculoModel();

					veiculo.setCodigo(rs.getInt("codveiculo"));
					veiculo.setMarca(rs.getString("marca"));
					veiculo.setModelo(rs.getString("modelo"));
					veiculo.setAno(rs.getString("ano"));
					veiculo.setPlaca(rs.getString("placa"));
					veiculo.setCor(rs.getString("cor"));
					veiculo.setEstado(rs.getString("estado_veiculo"));
					veiculo.setStatus(rs.getString("status"));

					veiculos.add(veiculo);

				}
			}

		} catch (Exception e) {
			
		}
		return veiculos;

	}

	public ArrayList<VeiculoModel> listarVeiculosMarca(String marca) {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<VeiculoModel> veiculos = null;

		String sql = "select codveiculo,marca,modelo,ano,placa,cor,estado_veiculo,status from veiculo where marca ~*'"
				+ marca + "' order by marca";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				veiculos = new ArrayList<VeiculoModel>();
				while (rs.next()) {
					VeiculoModel veiculo = new VeiculoModel();

					veiculo.setCodigo(rs.getInt("codveiculo"));
					veiculo.setMarca(rs.getString("marca"));
					veiculo.setModelo(rs.getString("modelo"));
					veiculo.setAno(rs.getString("ano"));
					veiculo.setPlaca(rs.getString("placa"));
					veiculo.setCor(rs.getString("cor"));
					veiculo.setEstado(rs.getString("estado_veiculo"));
					veiculo.setStatus(rs.getString("status"));

					veiculos.add(veiculo);

				}
			}

		} catch (Exception e) {
			
		}
		return veiculos;

	}

	public ArrayList<VeiculoModel> listarVeiculosPeloModeloDisponivel(String modelo) {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<VeiculoModel> veiculos = null;

		String sql = "select codveiculo,marca,modelo,ano,placa,cor,estado_veiculo,status from veiculo where modelo ~*'"
				+ modelo + "' and status like 'DISPONIVEL' order by modelo";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				veiculos = new ArrayList<VeiculoModel>();
				while (rs.next()) {
					VeiculoModel veiculo = new VeiculoModel();

					veiculo.setModelo(rs.getString("modelo"));
					veiculo.setCodigo(rs.getInt("codveiculo"));
					veiculo.setMarca(rs.getString("marca"));
					veiculo.setAno(rs.getString("ano"));
					veiculo.setPlaca(rs.getString("placa"));
					veiculo.setCor(rs.getString("cor"));
					veiculo.setEstado(rs.getString("estado_veiculo"));
					veiculo.setStatus(rs.getString("status"));

					veiculos.add(veiculo);

				}
			}

		} catch (Exception e) {
			
		}
		return veiculos;

	}

	public ArrayList<VeiculoModel> listarVeiculosPeloModeloAtualizarExcluir(String modelo) {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<VeiculoModel> veiculos = null;

		String sql = "select * from veiculo where modelo ~*'" + modelo + "' order by modelo";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				veiculos = new ArrayList<VeiculoModel>();
				while (rs.next()) {
					VeiculoModel veiculo = new VeiculoModel();

					veiculo.setModelo(rs.getString("modelo"));
					veiculo.setCodigo(rs.getInt("codveiculo"));
					veiculo.setMarca(rs.getString("marca"));
					veiculo.setAno(rs.getString("ano"));
					veiculo.setPlaca(rs.getString("placa"));
					veiculo.setCor(rs.getString("cor"));
					veiculo.setRenavam(rs.getString("renavam"));
					veiculo.setDescricao(rs.getString("descricao"));
					veiculo.setEstado(rs.getString("estado_veiculo"));
					veiculo.setStatus(rs.getString("status"));

					veiculos.add(veiculo);

				}
			}

		} catch (Exception e) {
			
		}
		return veiculos;

	}

	public ArrayList<VeiculoModel> listarVeiculosDisponiveis() {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<VeiculoModel> veiculos = null;

		String sql = "select codveiculo,marca,modelo,ano,placa,cor,status,estado_veiculo from veiculo where status like 'DISPONIVEL' order by modelo";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				veiculos = new ArrayList<VeiculoModel>();
				while (rs.next()) {
					VeiculoModel veiculo = new VeiculoModel();

					veiculo.setCodigo(rs.getInt("codveiculo"));
					veiculo.setMarca(rs.getString("marca"));
					veiculo.setModelo(rs.getString("modelo"));
					veiculo.setAno(rs.getString("ano"));
					veiculo.setPlaca(rs.getString("placa"));
					veiculo.setCor(rs.getString("cor"));
					veiculo.setStatus(rs.getString("status"));
					veiculo.setEstado(rs.getString("estado_veiculo"));

					veiculos.add(veiculo);

				}
			}

		} catch (Exception e) {
			
		}
		return veiculos;

	}

	public ArrayList<VeiculoModel> listarVeiculosAlugados() {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<VeiculoModel> veiculos = null;

		String sql = "select codveiculo,marca,modelo,ano,placa,cor,status,estado_veiculo from veiculo where status like 'ALUGADO' order by modelo";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				veiculos = new ArrayList<VeiculoModel>();
				while (rs.next()) {
					VeiculoModel veiculo = new VeiculoModel();

					veiculo.setCodigo(rs.getInt("codveiculo"));
					veiculo.setMarca(rs.getString("marca"));
					veiculo.setModelo(rs.getString("modelo"));
					veiculo.setAno(rs.getString("ano"));
					veiculo.setPlaca(rs.getString("placa"));
					veiculo.setCor(rs.getString("cor"));
					veiculo.setStatus(rs.getString("status"));
					veiculo.setEstado(rs.getString("estado_veiculo"));

					veiculos.add(veiculo);

				}
			}

		} catch (Exception e) {
			
		}
		return veiculos;

	}

	public ArrayList<VeiculoModel> listarVeiculosAno(String ano) {

		Connection connect;
		PreparedStatement pstm;
		ResultSet rs;
		ArrayList<VeiculoModel> veiculos = null;

		String sql = "select codveiculo,marca,modelo,ano,placa,cor,estado_veiculo,status from veiculo where ano like '%"
				+ ano + "%' order by marca";

		connect = new ConexaoDAO().getConexao();

		try {

			pstm = connect.prepareStatement(sql);
			rs = pstm.executeQuery();
			if (rs != null) {
				veiculos = new ArrayList<VeiculoModel>();
				while (rs.next()) {
					VeiculoModel veiculo = new VeiculoModel();

					veiculo.setCodigo(rs.getInt("codveiculo"));
					veiculo.setMarca(rs.getString("marca"));
					veiculo.setModelo(rs.getString("modelo"));
					veiculo.setAno(rs.getString("ano"));
					veiculo.setPlaca(rs.getString("placa"));
					veiculo.setCor(rs.getString("cor"));
					veiculo.setEstado(rs.getString("estado_veiculo"));
					veiculo.setStatus(rs.getString("status"));

					veiculos.add(veiculo);

				}
			}

		} catch (Exception e) {
			
		}
		return veiculos;

	}

	public void AtualizarVeiculo(VeiculoModel veiculo, String renavam) {
		Connection connect;
		PreparedStatement pstm;

		connect = new ConexaoDAO().getConexao();

		String sql = "update veiculo set marca = ?,modelo = ?,ano = ?,placa=?,cor=?,descricao=?,estado_veiculo=? where renavam = '"
				+ renavam + "'";

		try {

			pstm = connect.prepareStatement(sql);
			pstm.setString(1, veiculo.getMarca());
			pstm.setString(2, veiculo.getModelo());
			pstm.setString(3, veiculo.getAno());
			pstm.setString(4, veiculo.getPlaca());
			pstm.setString(5, veiculo.getCor());
			pstm.setString(6, veiculo.getDescricao());
			pstm.setString(7, veiculo.getEstado());

			pstm.execute();

			JOptionPane.showMessageDialog(null, "Veiculo Alterado com Sucesso");

			pstm.close();
		} catch (Exception e) {

		}

	}

	public void ExcluirVeiculo(String renavam) {
		Connection connect;
		PreparedStatement pstm;

		connect = new ConexaoDAO().getConexao();

		String sql = "delete from veiculo where renavam = '" + renavam + "'";

		try {

			pstm = connect.prepareStatement(sql);

			pstm.execute();

			JOptionPane.showMessageDialog(null, "Cliente Excluido com Sucesso");

			pstm.close();
		} catch (Exception e) {

		}
	}

}
