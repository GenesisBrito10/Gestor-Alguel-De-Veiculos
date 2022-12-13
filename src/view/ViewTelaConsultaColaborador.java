package view;

import controle.ClienteController;

import controle.ColaboradorController;

import model.ClienteModel;
import model.ColaboradorModel;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.w3c.dom.Text;

import Excecoes.Excecao;
import conexao.ConexaoDAO;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import java.awt.SystemColor;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ViewTelaConsultaColaborador {

	private JFrame frame;
	private JTextField campoNome;
	private JTextField campoCPF;
	private JTable tableColaborador;
	private ColaboradorController controller;
	private ColaboradorModel model;

	public JTextField getCampoNome() {
		return campoNome;
	}

	public void setCampoNome(JTextField campoNome) {
		this.campoNome = campoNome;
	}

	public JTextField getCampoCPF() {
		return campoCPF;
	}

	public void setCampoCPF(JTextField campoCPF) {
		this.campoCPF = campoCPF;
	}

	public JTable getTableColaborador() {
		return tableColaborador;
	}

	public void setTableColaborador(JTable tableColaborador) {
		this.tableColaborador = tableColaborador;
	}

	public void ConsultarTodosColaboradores() throws Excecao {
		ColaboradorController controller = new ColaboradorController(this,model);
		controller.ConsultarTodosColaboradores(tableColaborador);

	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTelaConsultaColaborador window = new ViewTelaConsultaColaborador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * @throws Excecao 
	 */
	public ViewTelaConsultaColaborador() throws Excecao {
		initialize();
		ConsultarTodosColaboradores();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.controller = null;
		ColaboradorController controller = new ColaboradorController(this,model);

		frame = new JFrame();
		frame.setBounds(100, 100, 967, 752);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JButton btnExcluir = new JButton("Alterar/Excluir");
		btnExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewTelaAtualizarExcluirColaborador().chamarTelaAtualizarColaborador();
				frame.dispose();
			}
		});
		btnExcluir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExcluir.setBounds(610, 607, 191, 48);
		frame.getContentPane().add(btnExcluir);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(57, 290, 772, 236);
		frame.getContentPane().add(scrollPane);

		tableColaborador = new JTable();
		tableColaborador.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "Nome", "CPF", "RG", "Endere\u00E7o", "Cidade" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableColaborador.setOpaque(false);
		tableColaborador.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableColaborador.setColumnSelectionAllowed(true);
		tableColaborador.setBackground(Color.WHITE);
		scrollPane.setViewportView(tableColaborador);

		JRadioButton btnNome = new JRadioButton("NOME\r\n");
		btnNome.setBounds(77, 198, 109, 30);
		btnNome.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		btnNome.setBackground(SystemColor.menu);
		frame.getContentPane().add(btnNome);

		campoCPF = new JTextField();
		campoCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					controller.ConsultarColaboradorPeloCpf(tableColaborador);
				} catch (Excecao e1) {
					
				}
			}
		});
		campoCPF.setBounds(468, 238, 333, 30);
		campoCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCPF.setEnabled(false);
		campoCPF.setColumns(10);
		frame.getContentPane().add(campoCPF);

		campoNome = new JTextField();
		campoNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					controller.ConsultarColaboradorPeloNome(tableColaborador);
				} catch (Excecao e1) {
				
				}
			}
		});
		campoNome.setBounds(77, 238, 333, 30);
		campoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoNome.setEnabled(false);
		campoNome.setColumns(10);
		frame.getContentPane().add(campoNome);

		JRadioButton btnCPF = new JRadioButton("CPF");
		btnCPF.setBounds(467, 198, 109, 30);
		btnCPF.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frame.getContentPane().add(btnCPF);

		JLabel lblNewLabel_2_1 = new JLabel(" PESQUISE TODOS OS FUNCIONÁRIO !");
		lblNewLabel_2_1.setBounds(183, 138, 591, 33);
		lblNewLabel_2_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 30));
		frame.getContentPane().add(lblNewLabel_2_1);

		JButton btnPesquisarTodos = new JButton("Pesquisar Todos");
		btnPesquisarTodos.setBounds(344, 607, 191, 48);
		btnPesquisarTodos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnPesquisarTodos);

		JLabel lblNewLabel_2 = new JLabel("SELECIONE E PREECHA O CAMPO SELECIONADO OU");
		lblNewLabel_2.setBounds(111, 108, 591, 33);
		lblNewLabel_2.setFont(new Font("Teko SemiBold", Font.PLAIN, 30));
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("CONSULTAR FUNCIONÁRIO");
		lblNewLabel_1.setBounds(111, 0, 579, 82);
		lblNewLabel_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 65));
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnPesquisarFuncionario = new JButton("Cadastrar");
		btnPesquisarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewTelaCadastroColaborador().chamarTelaCadastroColaborador();
					MinimizarTelaConsultaColaborador();
				} catch (Excecao e1) {
					
				}
				
			}
		});
		btnPesquisarFuncionario.setBounds(55, 607, 191, 48);
		btnPesquisarFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnPesquisarFuncionario);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(817, 665, 124, 23);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(btnVoltar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 951, 724);
		lblNewLabel.setIcon(new ImageIcon(ViewTelaCadastroCliente.class
				.getResource("/imagens/—Pngtree—abstract system technology background_1228014.jpg")));
		frame.getContentPane().add(lblNewLabel);

//FUNÇÕES-------------------------------------------------------------------------------------------------------

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewMenuDeConsultas().chamarTelaMenuDeConsultas();
				frame.dispose();
			}
		});

		btnPesquisarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ConsultarTodosColaboradores();
				} catch (Excecao e1) {
				
				}

			}
		});

		btnCPF.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnCPF.isSelected()) {
					campoNome.setEnabled(false);
					campoCPF.setEnabled(true);
					btnNome.setSelected(false);

				} else {
					campoCPF.setEnabled(false);
				}

			}
		});

		btnNome.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnNome.isSelected()) {
					campoNome.setEnabled(true);
					campoCPF.setEnabled(false);
					btnCPF.setSelected(false);

				} else {
					campoNome.setEnabled(false);
					btnNome.setSelected(false);
				}
			}
		});

	}

	public void chamarTelaConsultaColaborador() {
		frame.setVisible(true);

	}

	public void MinimizarTelaConsultaColaborador() {
		frame.dispose();

	}

}
