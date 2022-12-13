package model;

public class DevolucaoModel {

	private int codContrato, cod_veiculo;
	private String nome, cpf_cliente, cidade, marca, modelo, ano, cor, estado, dataLocacao, formaPagamento,
			tempoLocacao, status,datadevolucao;

	public DevolucaoModel(int codContrato, int cod_veiculo, String nome, String cpf_cliente, String cidade,
			String marca, String modelo, String ano, String cor, String estado, String dataLocacao,
			String formaPagamento, String tempoLocacao, String status) {

		this.codContrato = codContrato;
		this.cod_veiculo = cod_veiculo;
		this.nome = nome;
		this.cpf_cliente = cpf_cliente;
		this.cidade = cidade;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.estado = estado;
		this.dataLocacao = dataLocacao;
		this.formaPagamento = formaPagamento;
		this.tempoLocacao = tempoLocacao;
		this.status = status;
	}

	public DevolucaoModel(int codContrato, int cod_veiculo, String nome, String cpf_cliente,
			String marca, String modelo, String ano, String cor, String estado, String dataLocacao,
			String formaPagamento, String tempoLocacao, String datadevolucao) {
		super();
		this.codContrato = codContrato;
		this.cod_veiculo = cod_veiculo;
		this.nome = nome;
		this.cpf_cliente = cpf_cliente;
		this.marca = marca;
		this.modelo = modelo;
		this.ano = ano;
		this.cor = cor;
		this.estado = estado;
		this.dataLocacao = dataLocacao;
		this.formaPagamento = formaPagamento;
		this.tempoLocacao = tempoLocacao;
		this.datadevolucao = datadevolucao;
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

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf_cliente() {
		return cpf_cliente;
	}

	public void setCpf_cliente(String cpf_cliente) {
		this.cpf_cliente = cpf_cliente;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
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

	public String getDatadevolucao() {
		return datadevolucao;
	}

	public void setDatadevolucao(String datadevolucao) {
		this.datadevolucao = datadevolucao;
	}

	public DevolucaoModel() {
		// TODO Auto-generated constructor stub
	}

}
