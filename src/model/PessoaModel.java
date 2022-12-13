package model;

import java.io.Serializable;

public class PessoaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private String nome;
	private String cpf;
	private String rg;
	private String endereco;
	private String cidade;
	private int codigo;

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public PessoaModel(String nome, String cpf, String rg, String endereco, String cidade) {

		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.cidade = cidade;

	}

	public PessoaModel(String nome, String cpf, String rg, String endereco, String cidade, int codigo) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.rg = rg;
		this.endereco = endereco;
		this.cidade = cidade;
		this.codigo = codigo;
	}

	public PessoaModel() {

	}

	public PessoaModel(String nome, String endereco, String cidade) {
		this.nome = nome;
		this.endereco = endereco;
		this.cidade = cidade;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
