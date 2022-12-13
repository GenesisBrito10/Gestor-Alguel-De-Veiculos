package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexao.ConexaoDAO;

public class ColaboradorModel extends PessoaModel {

	private String senha;
	private String login;

	public ColaboradorModel(String nome, String cpf, String rg, String endereco, String cidade, String senha,
			String login) {
		super(nome, cpf, rg, endereco, cidade);

		this.senha = senha;
		this.login = login;
	}

	public ColaboradorModel(String login, String senha) {
		this.senha = senha;
		this.login = login;
	}

	public ColaboradorModel(String nome, String endereco, String cidade) {
		super(nome, endereco, cidade);

	}

	public ColaboradorModel() {
		// TODO Auto-generated constructor stub
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

}
