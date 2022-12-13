package view;

import conexao.ConexaoDAO;
import model.ClienteModel;
import model.PessoaModel;

import serializacao.Serializador;
import serializacao.Deserializador;

public class Main {

	private static ConexaoDAO conectar = null;

	public static void main(String[] args) {
		conectar = new ConexaoDAO();
		ViewTelaLogin v = new ViewTelaLogin();
		v.main(args);

	}
}
