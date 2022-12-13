package view;

import java.awt.EventQueue;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import org.w3c.dom.Text;

import Excecoes.Excecao;

import controle.ClienteController;
import model.ClienteModel;
import model.ColaboradorModel;

import javax.swing.JList;
import javax.swing.JOptionPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JRadioButtonMenuItem;
import java.awt.SystemColor;
import javax.swing.JCheckBox;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JPanel;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ViewTelaConsultaCliente {

	private JFrame frame;
	private JTextField campoNome;
	private JTextField campoCPF;
	private JTable tableCliente;
	private ViewTelaConsultaCliente viewConsultaCliente;
	private ClienteController controller;
	private ClienteModel model;

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

	public JTable getTableCliente() {
		return tableCliente;
	}

	public void setTableCliente(JTable tableCliente) {
		this.tableCliente = tableCliente;
	}

	public void mostrarTodosClientes() throws Excecao {
		ClienteController controller = new ClienteController(this, model);
		controller.ListarTodosClienteConsulta(tableCliente);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					ViewTelaConsultaCliente window = new ViewTelaConsultaCliente();
					window.frame.setVisible(true);
				} catch (Excecao e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 * 
	 * @throws Excecao
	 * 
	 * @throws ListarClientesException
	 */
	public ViewTelaConsultaCliente() throws Excecao {
		initialize();
		mostrarTodosClientes();
	}

	public ViewTelaConsultaCliente(ViewTelaConsultaCliente viewConsultaCliente) {
		this.viewConsultaCliente = viewConsultaCliente;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		ClienteController controller = new ClienteController(this, model);

		frame = new JFrame();
		frame.setBounds(100, 100, 967, 752);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JRadioButton btnCPF = new JRadioButton("CPF");

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewTelaCadastroCliente().chamarTelaCadastroCliente();
					frame.dispose();
				} catch (Excecao e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		btnCadastrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCadastrar.setBounds(624, 599, 191, 48);
		frame.getContentPane().add(btnCadastrar);

		JButton btnPesquisarTodos = new JButton("Pesquisar Todos");
		btnPesquisarTodos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPesquisarTodos.setBounds(353, 599, 191, 48);
		frame.getContentPane().add(btnPesquisarTodos);

		tableCliente = new JTable();
		tableCliente.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableCliente.setOpaque(false);

		tableCliente.setColumnSelectionAllowed(true);
		tableCliente.setBackground(Color.WHITE);

		tableCliente.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "C\u00F3digo", "Nome", "CPF", "RG", "Endere\u00E7o", "Cidade" }) {
			boolean[] columnEditables = new boolean[] { false, false, false, false, false, false };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableCliente.setBounds(141, 315, 772, 236);
		frame.getContentPane().add(tableCliente);

		JScrollPane scrollPane = new JScrollPane(tableCliente);
		scrollPane.setBounds(10, 281, 931, 236);
		frame.getContentPane().add(scrollPane);

		btnCPF.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		btnCPF.setBounds(490, 190, 109, 30);
		frame.getContentPane().add(btnCPF);

		JRadioButton btnNome = new JRadioButton("NOME\r\n");
		btnNome.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		btnNome.setBackground(UIManager.getColor("CheckBox.background"));
		btnNome.setBounds(100, 190, 109, 30);
		frame.getContentPane().add(btnNome);

		campoCPF = new JTextField();

		campoCPF.setEnabled(false);
		campoCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCPF.setColumns(10);
		campoCPF.setBounds(491, 230, 333, 30);
		frame.getContentPane().add(campoCPF);

		campoNome = new JTextField();

		campoNome.setEnabled(false);
		campoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoNome.setColumns(10);
		campoNome.setBounds(100, 230, 333, 30);
		frame.getContentPane().add(campoNome);

		JLabel lblNewLabel_2_1 = new JLabel(" PESQUISE TODOS OS FUNCIONÁRIO !");
		lblNewLabel_2_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(274, 131, 591, 33);
		frame.getContentPane().add(lblNewLabel_2_1);

		JLabel lblNewLabel_2 = new JLabel("SELECIONE E PREECHA UM DOS CAMPO SELECIONADOS OU");
		lblNewLabel_2.setFont(new Font("Teko SemiBold", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(193, 104, 591, 33);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("CONSULTAR CLIENTE");
		lblNewLabel_1.setBounds(224, 11, 579, 82);
		lblNewLabel_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 65));
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnAlterarExcluir = new JButton("Alterar/Excluir");
		btnAlterarExcluir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewTelaAtualizarExcluirCliente().chamarTelaAtualizarCliente();

				frame.dispose();

			}
		});
		btnAlterarExcluir.setBounds(54, 599, 191, 48);
		btnAlterarExcluir.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnAlterarExcluir);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltar.setBounds(817, 679, 124, 23);
		frame.getContentPane().add(btnVoltar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewTelaCadastroCliente.class
				.getResource("/imagens/—Pngtree—abstract system technology background_1228014.jpg")));
		lblNewLabel.setBounds(0, 0, 951, 713);
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
					mostrarTodosClientes();
				} catch (Excecao e1) {

				}

			}
		});

		campoCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					controller.ListarClientePeloCpfConsulta(tableCliente);
				} catch (Excecao e1) {
					
				}

			}
		});

		campoNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					controller.ListarClientePeloNomeConsulta(tableCliente);
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

	public void chamarTelaConsultaClientes() {
		frame.setVisible(true);

	}

	public void MinimizarTelaConsultaClientes() {
		frame.dispose();

	}
}
