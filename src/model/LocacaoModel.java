package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import conexao.ConexaoDAO;

public class LocacaoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private int codContrato, cod_veiculo;
	private String nome, cpf_cliente, cidade, marca, modelo, ano, cor, estado, dataLocacao, formaPagamento, tempoLocacao,
			status, rg, endereco;

	public LocacaoModel(int codContrato, int cod_veiculo, String cpf_cliente, String marca, String modelo, String ano,
			String cor, String estado, String dataLocacao, String formaPagamento, String tempoLocacao) {

		this.codContrato = codContrato;
		this.cod_veiculo = cod_veiculo;
		this.cpf_cliente = cpf_cliente;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.estado = estado;
		this.dataLocacao = dataLocacao;
		this.formaPagamento = formaPagamento;
		this.tempoLocacao = tempoLocacao;

	}

	public LocacaoModel(int cod_veiculo, String cpf_cliente, String marca, String modelo, String ano, String cor,
			String estado, String dataLocacao, String formaPagamento, String tempoLocacao) {

		this.cod_veiculo = cod_veiculo;
		this.cpf_cliente = cpf_cliente;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.estado = estado;
		this.dataLocacao = dataLocacao;
		this.formaPagamento = formaPagamento;
		this.tempoLocacao = tempoLocacao;

	}

	public LocacaoModel(int codContrato, int cod_veiculo, String cpf_cliente, String marca, String modelo, String cor,
			String dataLocacao, String formaPagamento, String tempoLocacao) {

		this.codContrato = codContrato;
		this.cod_veiculo = cod_veiculo;
		this.cpf_cliente = cpf_cliente;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.dataLocacao = dataLocacao;
		this.formaPagamento = formaPagamento;
		this.tempoLocacao = tempoLocacao;

	}

	public LocacaoModel(String nome, String cpf_cliente, String cidade, String rg, String endereco) {
		super();
		this.nome = nome;
		this.cpf_cliente = cpf_cliente;
		this.cidade = cidade;
		this.rg = rg;
		this.endereco = endereco;
	}

	public LocacaoModel(int codContrato,int cod_veiculo, String nome, String cpf_cliente, String marca, String modelo, String cor,
			String dataLocacao, String formaPagamento, String tempoLocacao) {
		super();
		this.cod_veiculo = cod_veiculo;
		this.codContrato = codContrato;
		this.nome = nome;
		this.cpf_cliente = cpf_cliente;
		this.marca = marca;
		this.modelo = modelo;
		this.cor = cor;
		this.dataLocacao = dataLocacao;
		this.formaPagamento = formaPagamento;
		this.tempoLocacao = tempoLocacao;
	}

	public int getCodContrato() {
		return codContrato;
	}

	public void setCodContrato(int codContrato) {
		this.codContrato = codContrato;
	}

	public int getCod_veiculo() {
		return cod_veiculo;
	}

	public void setCod_veiculo(int cod_veiculo) {
		this.cod_veiculo = cod_veiculo;
	}

	public String getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getDataLocacao() {
		return dataLocacao;
	}

	public void setDataLocacao(String dataLocacao) {
		this.dataLocacao = dataLocacao;
	}

	public String getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(String formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getTempoLocacao() {
		return tempoLocacao;
	}

	public void setTempoLocacao(String tempoLocacao) {
		this.tempoLocacao = tempoLocacao;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
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

	public LocacaoModel() {
		// TODO Auto-generated constructor stub
	}

}
