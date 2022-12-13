package controle;

import javax.swing.JOptionPane;

import Excecoes.Excecao;
import dao.ColaboradorDAO;
import model.ColaboradorModel;
import view.ViewMenuPrincipal;
import view.ViewTelaLogin;

public class LoginController {

	private ViewTelaLogin view;
	private ViewMenuPrincipal menuPrincipalView;
	private ColaboradorModel model;

	public LoginController() {

	}

	public LoginController(ViewTelaLogin view, ColaboradorModel model) {
		this.model = model;
		this.view = view;

	}

	public void Logar(int confirm) throws Excecao {

		String usuario = view.getCampoLogin().getText();
		String senha = view.getCampoSenha().getText();
		ColaboradorModel model = new ColaboradorModel(usuario, senha);
		ColaboradorDAO LogarNoSistema = new ColaboradorDAO();

		if (confirm == 0) {
			if (LogarNoSistema.loginColaborador(model)) {
				JOptionPane.showMessageDialog(null, "Bem Vindo ao Sistema");
				menuPrincipalView = new ViewMenuPrincipal();
				menuPrincipalView.chamarMenuPrincipal();
				view.MinimizarTelaLogin();
			} else {
				throw new Excecao("Usuario Nao Cadastrado no Sistema");

			}

		}

	}

}
