package model;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.DefaultListModel;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

import conexao.ConexaoDAO;
import controle.ClienteController;
import view.ViewTelaConsultaCliente;

public class ClienteModel extends PessoaModel {
	
	

	public ClienteModel(String nome, String cpf, String rg, String endereco, String cidade, int codigo) {
		super(nome, cpf, rg, endereco, cidade, codigo);

	}

	public ClienteModel(String nome, String cpf, String rg, String endereco, String cidade) {
		super(nome, cpf, rg, endereco, cidade);

	}

	public ClienteModel(String nome, String endereco, String cidade) {
		super(nome, endereco, cidade);

	}
	
	
	

	@Override
	public String toString() {
		return "Nome=" + getNome() + ", Cpf" + getCpf() + ", Rg" + getRg()
				+ ", Endereco" + getEndereco() + ",Cidade" + getCidade() + "]";
	}

	public ClienteModel() {
		// TODO Auto-generated constructor stub
	}

}
