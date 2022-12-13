package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JDesktopPane;
import java.awt.BorderLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.lang.System.Logger;
import java.lang.System.Logger.Level;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Rectangle;
import java.awt.Button;
import javax.swing.UIManager;

import Excecoes.Excecao;
import conexao.ConexaoDAO;
import controle.MenuPrincipalController;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Component;

public class ViewMenuPrincipal {

	private JFrame frame;
	private MenuPrincipalController controller;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMenuPrincipal window = new ViewMenuPrincipal();
					window.frame.setVisible(true);
					ConexaoDAO connect = new ConexaoDAO();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMenuPrincipal() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	public void initialize() {
		this.controller = null;
		MenuPrincipalController controller = new MenuPrincipalController(this);

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 720);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLocationRelativeTo(null);

		JDesktopPane desktopPane = new JDesktopPane();
		frame.getContentPane().add(desktopPane, BorderLayout.CENTER);

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 784, 681);
		desktopPane.add(panel);
		panel.setLayout(null);

		JButton btnNewButton = new JButton("LOCAÇÕES");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] opcoes = { "Realizar Locação", "Historico de Locação","Locações Ativas" };

				int confirm = JOptionPane.showOptionDialog(null, "Escolha o Setor para Locações", "Escolha uma opcao",
						JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes, opcoes[0]);
				try {
					controller.EscolherOpcaoLocacao(confirm);
				} catch (Excecao e1) {
					
				}
			}
		});

		JButton btnAlteraesexcluso = new JButton("ALTERAÇÕES/\r\nEXCLUSÃO");
		btnAlteraesexcluso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String[] opcoes = { "Cliente", "Colaborador", "Veiculo" };

				int confirm = JOptionPane.showOptionDialog(null, "Escolha o Setor para Alteração/Exclusão",
						"Escolha uma opcao", JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opcoes,
						opcoes[0]);
				try {
					controller.EscolherOpcaoAlterarExcluir(confirm);
				} catch (Excecao e1) {
					
				}

			}
		});

		JButton btnDevolues = new JButton("DEVOLUÇÕES");
		btnDevolues.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewTelaDeDevolucao().chamarTelaDevolucao();
				frame.dispose();
			}
		});
		btnDevolues.setVerticalAlignment(SwingConstants.TOP);
		btnDevolues.setFont(new Font("Teko SemiBold", Font.PLAIN, 58));
		btnDevolues.setBorder(UIManager.getBorder("Button.border"));
		btnDevolues.setAlignmentY(10.0f);
		btnDevolues.setBounds(212, 211, 351, 76);
		panel.add(btnDevolues);
		btnAlteraesexcluso.setVerticalAlignment(SwingConstants.TOP);
		btnAlteraesexcluso.setFont(new Font("Teko SemiBold", Font.PLAIN, 36));
		btnAlteraesexcluso.setBorder(UIManager.getBorder("Button.border"));
		btnAlteraesexcluso.setAlignmentY(10.0f);
		btnAlteraesexcluso.setBounds(212, 495, 351, 65);
		panel.add(btnAlteraesexcluso);
		btnNewButton.setAlignmentY(10.0f);
		btnNewButton.setFont(new Font("Teko SemiBold", Font.PLAIN, 58));
		btnNewButton.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton.setBorder(UIManager.getBorder("Button.border"));
		btnNewButton.setBounds(212, 126, 351, 76);
		panel.add(btnNewButton);

		JLabel lblNewLabel_1 = new JLabel("MENU PRINCIPAL");
		lblNewLabel_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 90));
		lblNewLabel_1.setBounds(139, 11, 536, 82);
		panel.add(lblNewLabel_1);

		JButton btnCadastros = new JButton("CADASTROS");
		btnCadastros.setVerticalAlignment(SwingConstants.TOP);
		btnCadastros.setFont(new Font("Teko SemiBold", Font.PLAIN, 58));
		btnCadastros.setBorder(UIManager.getBorder("Button.border"));
		btnCadastros.setAlignmentY(10.0f);
		btnCadastros.setBounds(212, 298, 351, 76);
		panel.add(btnCadastros);

		JButton btnConsultas = new JButton("CONSULTAS");
		btnConsultas.setVerticalAlignment(SwingConstants.TOP);
		btnConsultas.setFont(new Font("Teko SemiBold", Font.PLAIN, 58));
		btnConsultas.setBorder(UIManager.getBorder("Button.border"));
		btnConsultas.setAlignmentY(10.0f);
		btnConsultas.setBounds(212, 397, 351, 76);
		panel.add(btnConsultas);

		JButton btnLogout = new JButton("LOGOUT");
		btnLogout.setVerticalAlignment(SwingConstants.TOP);
		btnLogout.setFont(new Font("Teko SemiBold", Font.PLAIN, 58));
		btnLogout.setBorder(UIManager.getBorder("Button.border"));
		btnLogout.setAlignmentY(10.0f);
		btnLogout.setBounds(212, 579, 351, 76);
		panel.add(btnLogout);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewMenuPrincipal.class
				.getResource("/imagens/—Pngtree—abstract system technology background_1228014.jpg")));
		lblNewLabel.setBounds(0, 0, 784, 681);
		panel.add(lblNewLabel);

//FUNÇÕES----------------------------------------------------------------------------------------------------------

		btnCadastros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewMenuDeCadastros().chamarMenuDeCadastros();
				MinimizarMenuPrincipal();
			}
		});

		btnLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MinimizarMenuPrincipal();
				new ViewTelaLogin().chamarTelaLogin();

			}
		});

		btnConsultas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewMenuDeConsultas().chamarTelaMenuDeConsultas();
				MinimizarMenuPrincipal();

			}
		});

	}

	public void chamarMenuPrincipal() {
		frame.setVisible(true);

	}

	public void MinimizarMenuPrincipal() {
		frame.dispose();

	}
}
