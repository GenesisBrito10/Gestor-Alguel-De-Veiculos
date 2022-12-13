package view;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Excecoes.Excecao;
import controle.LocacoesController;
import controle.VeiculoController;
import model.LocacaoModel;

public class ViewTelaConsultaDeLocacoesAtivas {

	private JFrame frame;
	private JTextField campoModelo;
	private JTable tableLocacao;
	private JTextField campoCpfCliente;
	private LocacoesController controller;
	private LocacaoModel model;

	public JTextField getCampoModelo() {
		return campoModelo;
	}

	public void setCampoModelo(JTextField campoModelo) {
		this.campoModelo = campoModelo;
	}

	public JTable getTableVeiculo() {
		return tableLocacao;
	}

	public void setTableVeiculo(JTable tableVeiculo) {
		this.tableLocacao = tableVeiculo;
	}

	public JTextField getCampoCpfCliente() {
		return campoCpfCliente;
	}

	public void setCampoCpfCliente(JTextField campoCpfCliente) {
		this.campoCpfCliente = campoCpfCliente;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTelaConsultaDeLocacoesAtivas window = new ViewTelaConsultaDeLocacoesAtivas();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public void ListarTodasLocacoes() throws Excecao {
		LocacoesController controller = new LocacoesController(this,model);
		controller.ListarTodasLocacoes(tableLocacao);
	}

	/**
	 * Create the application.
	 * @throws Excecao 
	 */
	public ViewTelaConsultaDeLocacoesAtivas() throws Excecao {
		initialize();
		ListarTodasLocacoes();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.controller = null;
		LocacoesController controller = new LocacoesController(this,model);

		frame = new JFrame();
		frame.setBounds(100, 100, 1159, 752);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JButton btnCadastrat = new JButton("Fazer Devolução");
		btnCadastrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewTelaDeDevolucao().chamarTelaDevolucao();
				MinimizarTelaConsultaLocacoes();
			}
		});

		campoCpfCliente = new JTextField();
		campoCpfCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					controller.ListarLocacoesPeloCpfCliente(tableLocacao);
				} catch (Excecao e1) {
					
				}
			}
		});
		campoCpfCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCpfCliente.setEnabled(false);
		campoCpfCliente.setColumns(10);
		campoCpfCliente.setBounds(500, 212, 333, 30);
		frame.getContentPane().add(campoCpfCliente);
		btnCadastrat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCadastrat.setBounds(638, 580, 232, 48);
		frame.getContentPane().add(btnCadastrat);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(21, 269, 1095, 236);
		frame.getContentPane().add(scrollPane);

		tableLocacao = new JTable();
		tableLocacao.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tableLocacao.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"CONTRATO", "NOME", "CPF", "MARCA", "MODELO", "COR", "DATA LOCACAO", "FORMA PAGAMENTO", "TEMPO DE LOCACAO", "COD.VEICULO"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, true, true, false, true, true, true, true, false
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tableLocacao);

		JRadioButton btnModelo = new JRadioButton("MODELO");

		btnModelo.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		btnModelo.setBackground(SystemColor.menu);
		btnModelo.setBounds(110, 175, 153, 30);
		frame.getContentPane().add(btnModelo);

		JRadioButton btnCpfCliente = new JRadioButton("CPF CLIENTE");
		btnCpfCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnCpfCliente.isSelected()) {
					campoCpfCliente.setEnabled(true);
					campoModelo.setEnabled(false);
					btnModelo.setSelected(false);

				} else {
					campoCpfCliente.setEnabled(false);
					btnCpfCliente.setSelected(false);
				}
			}
		});
		btnCpfCliente.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		btnCpfCliente.setBounds(500, 175, 180, 30);
		frame.getContentPane().add(btnCpfCliente);

		campoModelo = new JTextField();
		campoModelo.setEnabled(false);
		campoModelo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					controller.ListarLocacoesPeloModelo(tableLocacao);
				} catch (Excecao e1) {
					
				}

			}
		});
		campoModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoModelo.setColumns(10);
		campoModelo.setBounds(110, 212, 333, 30);
		frame.getContentPane().add(campoModelo);

		JLabel lblNewLabel_2_1 = new JLabel(" PESQUISE TODOAS AS LOCAÇÕES !");
		lblNewLabel_2_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(420, 106, 591, 33);
		frame.getContentPane().add(lblNewLabel_2_1);

		JButton btnPesquisarTodos = new JButton("Pesquisar Todos");
		btnPesquisarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ListarTodasLocacoes();
				} catch (Excecao e1) {
					
				}
			}
		});
		btnPesquisarTodos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPesquisarTodos.setBounds(378, 580, 191, 48);
		frame.getContentPane().add(btnPesquisarTodos);

		JLabel lblNewLabel_2 = new JLabel("SELECIONE E PREECHA O CAMPO SELECIONADO OU");
		lblNewLabel_2.setFont(new Font("Teko SemiBold", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(348, 76, 591, 33);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("CONSULTAR LOCAÇÕES ATIVAS\r\n");
		lblNewLabel_1.setBounds(261, 0, 724, 82);
		lblNewLabel_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 65));
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewMenuDeConsultas().chamarTelaMenuDeConsultas();
				 MinimizarTelaConsultaLocacoes();
			}
		});
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltar.setBounds(1009, 679, 124, 23);
		frame.getContentPane().add(btnVoltar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewTelaCadastroCliente.class
				.getResource("/imagens/—Pngtree—abstract system technology background_1228014.jpg")));
		lblNewLabel.setBounds(0, 0, 1143, 713);
		frame.getContentPane().add(lblNewLabel);

		btnModelo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnModelo.isSelected()) {
					campoCpfCliente.setEnabled(false);
					campoModelo.setEnabled(true);
					btnCpfCliente.setSelected(false);

				} else {
					campoModelo.setEnabled(false);
				}
			}
		});
	}
	
	
	public void chamarTelaConsultasLocacoes() {
		frame.setVisible(true);

	}	
	public void MinimizarTelaConsultaLocacoes() {
		frame.dispose();

	}
}
