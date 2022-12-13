package view;

import java.awt.Color;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPopupMenu;

import Excecoes.Excecao;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewMenuDeConsultas {

	private JFrame frmConsulta;
	private JFrame frmConsulta_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMenuDeConsultas window = new ViewMenuDeConsultas();
					window.frmConsulta_1.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMenuDeConsultas() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmConsulta = new JFrame();
		frmConsulta.setTitle("consulta");
		frmConsulta.setBounds(100, 100, 800, 600);
		frmConsulta.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frmConsulta_1 = new JFrame();
		frmConsulta_1.setTitle("Consultas");
		frmConsulta_1.setBounds(100, 100, 964, 600);
		frmConsulta_1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmConsulta_1.getContentPane().setLayout(null);
		frmConsulta_1.setLocationRelativeTo(null);

		JLabel lblConsultarLocaesAtivas = new JLabel("Consultar Locações Ativas\r\n");
		lblConsultarLocaesAtivas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsultarLocaesAtivas.setBounds(129, 469, 237, 30);
		frmConsulta_1.getContentPane().add(lblConsultarLocaesAtivas);

		JButton btnConsultaClientes_1_1 = new JButton("");
		btnConsultaClientes_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewTelaConsultaDeLocacoesAtivas().chamarTelaConsultasLocacoes();
					MinimizarTelaMenuDeConsultas();
				} catch (Excecao e1) {

				}

			}
		});
		btnConsultaClientes_1_1.setIcon(
				new ImageIcon(ViewMenuDeConsultas.class.getResource("/imagens/icons8-histórico-de-atividades-80.png")));
		btnConsultaClientes_1_1.setToolTipText("");
		btnConsultaClientes_1_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsultaClientes_1_1.setBackground(Color.WHITE);
		btnConsultaClientes_1_1.setBounds(141, 338, 164, 131);
		frmConsulta_1.getContentPane().add(btnConsultaClientes_1_1);

		JLabel lblConsultarHistricoLocaes = new JLabel("Consultar Histórico Locações\r\n");
		lblConsultarHistricoLocaes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsultarHistricoLocaes.setBounds(447, 469, 237, 30);
		frmConsulta_1.getContentPane().add(lblConsultarHistricoLocaes);

		JButton btnConsultaClientes_1 = new JButton("");
		btnConsultaClientes_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewTelaHistoricoLocacao().chamarTelaHistoricoLocacao();
					MinimizarTelaMenuDeConsultas();

				} catch (Excecao e1) {

				}
			}
		});
		btnConsultaClientes_1.setIcon(
				new ImageIcon(ViewMenuDeConsultas.class.getResource("/imagens/icons8-histórico-de-atividades-80.png")));
		btnConsultaClientes_1.setToolTipText("");
		btnConsultaClientes_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsultaClientes_1.setBackground(Color.WHITE);
		btnConsultaClientes_1.setBounds(462, 338, 164, 131);
		frmConsulta_1.getContentPane().add(btnConsultaClientes_1);

		JButton btnConsultaClientes = new JButton("");
		btnConsultaClientes.setBackground(Color.WHITE);
		btnConsultaClientes.setToolTipText("");
		btnConsultaClientes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsultaClientes.setBounds(141, 137, 164, 131);
		btnConsultaClientes.setIcon(
				new ImageIcon(ViewMenuDeCadastros.class.getResource("/imagens/icons8-funcionário-homem-80.png")));
		frmConsulta_1.getContentPane().add(btnConsultaClientes);

		JLabel lblConsultarClientes = new JLabel("Consultar Clientes");
		lblConsultarClientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblConsultarClientes.setBounds(151, 267, 156, 30);
		frmConsulta_1.getContentPane().add(lblConsultarClientes);

		JButton btnConsultaFuncionario = new JButton("");
		btnConsultaFuncionario.setIcon(
				new ImageIcon(ViewMenuDeCadastros.class.getResource("/imagens/icons8-funcionário-homem-80 (1).png")));
		btnConsultaFuncionario.setToolTipText("");
		btnConsultaFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsultaFuncionario.setBackground(Color.WHITE);
		btnConsultaFuncionario.setBounds(462, 137, 164, 131);
		frmConsulta_1.getContentPane().add(btnConsultaFuncionario);

		JLabel lblCadastroFuncionario = new JLabel("Consultar Colaborador\r\n");
		lblCadastroFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastroFuncionario.setBounds(462, 267, 183, 30);
		frmConsulta_1.getContentPane().add(lblCadastroFuncionario);

		JButton btnConsultaVeiculos = new JButton("");
		btnConsultaVeiculos
				.setIcon(new ImageIcon(ViewMenuDeCadastros.class.getResource("/imagens/icons8-car-roof-box-80.png")));
		btnConsultaVeiculos.setToolTipText("");
		btnConsultaVeiculos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnConsultaVeiculos.setBackground(Color.WHITE);
		btnConsultaVeiculos.setBounds(746, 136, 164, 131);
		frmConsulta_1.getContentPane().add(btnConsultaVeiculos);

		JLabel lblCadastroVeculos = new JLabel("Consultar Veículos");
		lblCadastroVeculos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastroVeculos.setBounds(756, 267, 144, 30);
		frmConsulta_1.getContentPane().add(lblCadastroVeculos);

		JButton btnMenuPrincipalConsulta = new JButton("");
		btnMenuPrincipalConsulta
				.setIcon(new ImageIcon(ViewMenuDeCadastros.class.getResource("/imagens/icons8-desfazer-80.png")));
		btnMenuPrincipalConsulta.setToolTipText("");
		btnMenuPrincipalConsulta.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMenuPrincipalConsulta.setBackground(Color.WHITE);
		btnMenuPrincipalConsulta.setBounds(746, 338, 164, 131);
		frmConsulta_1.getContentPane().add(btnMenuPrincipalConsulta);

		JLabel lblMenuPrincipalConsultas = new JLabel("Menu Principal");
		lblMenuPrincipalConsultas.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMenuPrincipalConsultas.setBounds(771, 469, 139, 30);
		frmConsulta_1.getContentPane().add(lblMenuPrincipalConsultas);

		JLabel lblNewLabel_1 = new JLabel("CONSULTAS");
		lblNewLabel_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 90));
		lblNewLabel_1.setBounds(197, 25, 388, 82);
		frmConsulta_1.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(ViewMenuDeCadastros.class
				.getResource("/imagens/—Pngtree—abstract system technology background_1228014.jpg")));
		lblNewLabel_2.setBounds(0, 0, 948, 561);
		frmConsulta_1.getContentPane().add(lblNewLabel_2);

//FUNÇÕES----------------------------------------------------------------------------------------------------------

		btnMenuPrincipalConsulta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewMenuPrincipal().chamarMenuPrincipal();
				MinimizarTelaMenuDeConsultas();
			}
		});

		btnConsultaFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewTelaConsultaColaborador().chamarTelaConsultaColaborador();
					MinimizarTelaMenuDeConsultas();
				} catch (Excecao e1) {

				}

			}
		});

		btnConsultaVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewTelaDeConsultaVeiculo().chamarTelaConsultaVeiculo();
					MinimizarTelaMenuDeConsultas();
					
				} catch (Excecao e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		btnConsultaClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewTelaConsultaCliente().chamarTelaConsultaClientes();
					MinimizarTelaMenuDeConsultas();
				} catch (Excecao e1) {

				}

			}
		});

	}

	public void chamarTelaMenuDeConsultas() {
		frmConsulta_1.setVisible(true);

	}

	public void MinimizarTelaMenuDeConsultas() {
		frmConsulta_1.dispose();

	}

}
