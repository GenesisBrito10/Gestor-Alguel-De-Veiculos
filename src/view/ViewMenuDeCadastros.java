package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.Font;
import java.awt.Window;

import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import Excecoes.Excecao;

import java.awt.Color;
import javax.swing.JPanel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewMenuDeCadastros {

	private JFrame frmCadastros;
	private JButton btnMenuPrincipalCadastro;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewMenuDeCadastros window = new ViewMenuDeCadastros();
					window.frmCadastros.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewMenuDeCadastros() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCadastros = new JFrame();
		frmCadastros.setTitle("Cadastros");
		frmCadastros.setBounds(100, 100, 882, 600);
		frmCadastros.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCadastros.getContentPane().setLayout(null);
		frmCadastros.setLocationRelativeTo(null);

		JButton btnCadastroFuncionarios_1 = new JButton("");
		btnCadastroFuncionarios_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewTelaDeDevolucao().chamarTelaDevolucao();
				MinimizarMenuDeCadastros();
			}
		});
		btnCadastroFuncionarios_1.setIcon(
				new ImageIcon(ViewMenuDeCadastros.class.getResource("/imagens/icons8-air-recirculation-80.png")));
		btnCadastroFuncionarios_1.setToolTipText("");
		btnCadastroFuncionarios_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastroFuncionarios_1.setBackground(Color.WHITE);
		btnCadastroFuncionarios_1.setBounds(673, 137, 164, 131);
		frmCadastros.getContentPane().add(btnCadastroFuncionarios_1);

		JLabel lblCadastrarDevoluo = new JLabel("Cadastrar Devolução\r\n");
		lblCadastrarDevoluo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastrarDevoluo.setBounds(673, 267, 171, 30);
		frmCadastros.getContentPane().add(lblCadastrarDevoluo);

		JButton btnCadastroClientes = new JButton("");
		btnCadastroClientes.setBackground(Color.WHITE);
		btnCadastroClientes.setToolTipText("");
		btnCadastroClientes.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastroClientes.setBounds(97, 137, 164, 131);
		btnCadastroClientes.setIcon(
				new ImageIcon(ViewMenuDeCadastros.class.getResource("/imagens/icons8-funcionário-homem-80.png")));
		frmCadastros.getContentPane().add(btnCadastroClientes);

		JLabel lblCadastroClientes = new JLabel("Cadastro Clientes");
		lblCadastroClientes.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastroClientes.setBounds(117, 267, 156, 30);
		frmCadastros.getContentPane().add(lblCadastroClientes);

		JButton btnCadastroFuncionarios = new JButton("");
		btnCadastroFuncionarios.setIcon(
				new ImageIcon(ViewMenuDeCadastros.class.getResource("/imagens/icons8-funcionário-homem-80 (1).png")));
		btnCadastroFuncionarios.setToolTipText("");
		btnCadastroFuncionarios.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastroFuncionarios.setBackground(Color.WHITE);
		btnCadastroFuncionarios.setBounds(418, 137, 164, 131);
		frmCadastros.getContentPane().add(btnCadastroFuncionarios);

		JLabel lblCadastroFuncionrio = new JLabel("Cadastro Colaborador\r\n");
		lblCadastroFuncionrio.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastroFuncionrio.setBounds(418, 267, 171, 30);
		frmCadastros.getContentPane().add(lblCadastroFuncionrio);

		JButton btnCadastroVeiculos = new JButton("");
		btnCadastroVeiculos
				.setIcon(new ImageIcon(ViewMenuDeCadastros.class.getResource("/imagens/icons8-car-roof-box-80.png")));
		btnCadastroVeiculos.setToolTipText("");
		btnCadastroVeiculos.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastroVeiculos.setBackground(Color.WHITE);
		btnCadastroVeiculos.setBounds(97, 349, 164, 131);
		frmCadastros.getContentPane().add(btnCadastroVeiculos);

		JLabel lblCadastroVeculos = new JLabel("Cadastro Veículos");
		lblCadastroVeculos.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblCadastroVeculos.setBounds(117, 480, 139, 30);
		frmCadastros.getContentPane().add(lblCadastroVeculos);

		btnMenuPrincipalCadastro = new JButton("");
		btnMenuPrincipalCadastro
				.setIcon(new ImageIcon(ViewMenuDeCadastros.class.getResource("/imagens/icons8-desfazer-80.png")));
		btnMenuPrincipalCadastro.setToolTipText("");
		btnMenuPrincipalCadastro.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnMenuPrincipalCadastro.setBackground(Color.WHITE);
		btnMenuPrincipalCadastro.setBounds(418, 349, 164, 131);
		frmCadastros.getContentPane().add(btnMenuPrincipalCadastro);

		JLabel lblMenuPrincipalCadastros = new JLabel("Menu Principal");
		lblMenuPrincipalCadastros.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMenuPrincipalCadastros.setBounds(443, 480, 139, 30);
		frmCadastros.getContentPane().add(lblMenuPrincipalCadastros);

		JLabel lblNewLabel_1 = new JLabel("CADASTROS");
		lblNewLabel_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 90));
		lblNewLabel_1.setBounds(197, 25, 388, 82);
		frmCadastros.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon(ViewMenuDeCadastros.class
				.getResource("/imagens/—Pngtree—abstract system technology background_1228014.jpg")));
		lblNewLabel_2.setBounds(0, 0, 866, 561);
		frmCadastros.getContentPane().add(lblNewLabel_2);

// Funcoes---------------------------------------------------------------------------------------------

		btnCadastroClientes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					new ViewTelaCadastroCliente().chamarTelaCadastroCliente();
					MinimizarMenuDeCadastros();
				} catch (Excecao e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			

			}
		});

		btnCadastroVeiculos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewTelaCadastroVeiculo().chamarTelaCadastratoVeiculo();
				frmCadastros.dispose();
			}
		});

		btnCadastroFuncionarios.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewTelaCadastroColaborador().chamarTelaCadastroColaborador();
					MinimizarMenuDeCadastros();
				} catch (Excecao e1) {
					
				}
				
			}
		});

		btnMenuPrincipalCadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewMenuPrincipal().chamarMenuPrincipal();
				frmCadastros.dispose();
			}
		});
	}

	public void chamarMenuDeCadastros() {
		frmCadastros.setVisible(true);
	}

	public void MinimizarMenuDeCadastros() {
		frmCadastros.dispose();
	}

}
