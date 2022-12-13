package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.sound.sampled.BooleanControl;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.JToolBar;
import com.jgoodies.forms.factories.DefaultComponentFactory;

import Excecoes.Excecao;
import controle.ColaboradorController;
import controle.LoginController;
import model.ClienteModel;
import model.ColaboradorModel;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JInternalFrame;
import javax.swing.JToggleButton;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.List;
import javax.swing.JMenu;
import javax.swing.ImageIcon;
import java.awt.Button;
import java.awt.Component;
import java.awt.Point;
import java.awt.Color;
import javax.swing.JSeparator;

public class ViewTelaLogin {

	private JFrame frmTelaDeLogin;
	private JTextField campoLogin;
	private JPasswordField campoSenha;
	private JLabel lblLogin;
	private JLabel lblSenha;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private LoginController controller;
	private ColaboradorModel model;

	public JTextField getCampoLogin() {
		return campoLogin;
	}

	public void setCampoLogin(JTextField campoLogin) {
		this.campoLogin = campoLogin;
	}

	public JPasswordField getCampoSenha() {
		return campoSenha;
	}

	public void setCampoSenha(JPasswordField campoSenha) {
		this.campoSenha = campoSenha;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException | InstantiationException | IllegalAccessException
				| javax.swing.UnsupportedLookAndFeelException ex) {
			System.err.println(ex);
		}

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTelaLogin window = new ViewTelaLogin();
					window.frmTelaDeLogin.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewTelaLogin() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.controller = null;
		LoginController controller = new LoginController(this, model);
		frmTelaDeLogin = new JFrame();
		frmTelaDeLogin.setTitle("Login");
		frmTelaDeLogin.getContentPane().setBackground(Color.WHITE);
		frmTelaDeLogin.setBounds(100, 100, 800, 600);
		frmTelaDeLogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTelaDeLogin.getContentPane().setLayout(null);
		frmTelaDeLogin.setLocationRelativeTo(null);

		JLabel lbltitulologin = new JLabel("Jg autocenter");
		lbltitulologin.setFont(new Font("American Kestrel Laser", Font.PLAIN, 60));
		lbltitulologin.setBounds(119, 63, 529, 43);
		frmTelaDeLogin.getContentPane().add(lbltitulologin);

		campoLogin = new JTextField();
		campoLogin.setBounds(202, 284, 372, 30);
		campoLogin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmTelaDeLogin.getContentPane().add(campoLogin);
		campoLogin.setColumns(10);

		lblLogin = new JLabel("Login");
		lblLogin.setBounds(191, 243, 131, 36);
		lblLogin.setIcon(new ImageIcon(ViewTelaLogin.class.getResource("/imagens/icons8-funcionário-homem-50.png")));
		lblLogin.setFont(new Font("Quicksand Light", Font.PLAIN, 25));
		frmTelaDeLogin.getContentPane().add(lblLogin);

		lblSenha = new JLabel("Senha");
		lblSenha.setBounds(202, 335, 131, 56);
		lblSenha.setIcon(new ImageIcon(ViewTelaLogin.class.getResource("/imagens/icons8-bloqueio-privado-40.png")));
		lblSenha.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frmTelaDeLogin.getContentPane().add(lblSenha);

		campoSenha = new JPasswordField();
		campoSenha.setBounds(202, 392, 372, 30);
		campoSenha.setFont(new Font("Tahoma", Font.PLAIN, 14));
		frmTelaDeLogin.getContentPane().add(campoSenha);

		JButton btnEntrar = new JButton("Entrar");
		btnEntrar.setBounds(622, 520, 149, 30);
		frmTelaDeLogin.getContentPane().add(btnEntrar);

		lblNewLabel = new JLabel("Bem Vindo !");
		lblNewLabel.setFont(new Font("Playball", Font.PLAIN, 50));
		lblNewLabel.setBounds(263, 148, 256, 36);
		frmTelaDeLogin.getContentPane().add(lblNewLabel);

		JSeparator separator = new JSeparator();
		separator.setBounds(131, 110, 504, 11);
		frmTelaDeLogin.getContentPane().add(separator);

		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setIcon(new ImageIcon(ViewTelaLogin.class
				.getResource("/imagens/—Pngtree—abstract system technology background_1228014.jpg")));
		lblNewLabel_1.setBounds(0, 0, 859, 572);
		frmTelaDeLogin.getContentPane().add(lblNewLabel_1);

		// Funcoes
		btnEntrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Confirmar Dados ?");
				try {
					controller.Logar(confirm);
				} catch (Excecao e1) {
					
				}

			}
		});

	}

	public void chamarTelaLogin() {
		frmTelaDeLogin.setVisible(true);
	}

	public void MinimizarTelaLogin() {
		frmTelaDeLogin.dispose();
	}

}
