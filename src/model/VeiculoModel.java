package model;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import conexao.ConexaoDAO;

public class VeiculoModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private String marca, modelo, ano, renavam, placa, cor, status, descricao, estado, dataLocacao, formaPagamento,
			tempoLocacao, cpf_cliente;
	private int codigo;

	public VeiculoModel() {
	}

	public VeiculoModel(String marca, String modelo, String placa, String cor, String descricao, String status,
			String estado, String ano, String renavam, int codigo) {

		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.descricao = descricao;
		this.status = status;
		this.estado = estado;
		this.ano = ano;
		this.renavam = renavam;
		this.codigo = codigo;
	}

	public VeiculoModel(String marca, String modelo, String placa, String cor, String descricao, String status,
			String estado, String ano, String renavam) {

		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.descricao = descricao;
		this.status = status;
		this.estado = estado;
		this.ano = ano;
		this.renavam = renavam;
	}
	
	public VeiculoModel(String marca, String modelo, String placa, String cor, String descricao,
			String estado, String ano, String renavam) {

		this.marca = marca;
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.descricao = descricao;
		this.estado = estado;
		this.ano = ano;
		this.renavam = renavam;
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

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getCor() {
		return cor;
	}

	public void setCor(String cor) {
		this.cor = cor;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
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

	public String getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public String getRenavam() {
		return renavam;
	}

	public void setRenavam(String renavam) {
		this.renavam = renavam;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

}
