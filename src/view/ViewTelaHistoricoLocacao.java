package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;

import Excecoes.Excecao;
import controle.ClienteController;
import controle.DevolucaoController;
import model.DevolucaoModel;

public class ViewTelaHistoricoLocacao {

	private JFrame frame;
	private JTextField campoNome;
	private JTextField campoCPF;
	private JTable tableHistorico;
	private DevolucaoController controller;
	private DevolucaoModel model;
	
	

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

	public JTable getTableHistorico() {
		return tableHistorico;
	}

	public void setTableHistorico(JTable tableHistorico) {
		this.tableHistorico = tableHistorico;
	}
	
	public void mostrarTodoHistoricoLocacao() throws Excecao {
		DevolucaoController controller = new DevolucaoController(this,model);
		controller.ListarHistoricoLocacoes(tableHistorico);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTelaHistoricoLocacao window = new ViewTelaHistoricoLocacao();
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
	public ViewTelaHistoricoLocacao() throws Excecao {
		initialize();
		mostrarTodoHistoricoLocacao();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		
		DevolucaoController controller = new DevolucaoController(this,model);
		frame = new JFrame();
		frame.setBounds(100, 100, 1892, 752);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JRadioButton btnCPF = new JRadioButton("CPF");

		JButton btnDevolucao = new JButton("Realizar Locação");
		btnDevolucao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewTelaDeLocacoes().chamarTelaDeLocacao();
				MinimizarTelaHistoricoLocacao();
			}
		});
		btnDevolucao.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnDevolucao.setBounds(1073, 595, 203, 48);
		frame.getContentPane().add(btnDevolucao);

		JButton btnPesquisarTodos = new JButton("Pesquisar Todos");
		btnPesquisarTodos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPesquisarTodos.setBounds(802, 595, 191, 48);
		frame.getContentPane().add(btnPesquisarTodos);

		tableHistorico = new JTable();
		tableHistorico.setFont(new Font("Tahoma", Font.PLAIN, 11));
		tableHistorico.setOpaque(false);

		tableHistorico.setColumnSelectionAllowed(true);
		tableHistorico.setBackground(Color.WHITE);

		tableHistorico.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Cod.Contrato", "Nome", "CPF", "Marca", "Modelo", "Ano", "Cor", "Estado", "Data Loca\u00E7\u00E3o", "Data Devolu\u00E7\u00E3o", "Forma de Pagamento", "Tempo de Loca\u00E7\u00E3o", "Cod.Veiculo", "Status"
			}
		) {
			boolean[] columnEditables = new boolean[] {
				false, false, false, false, false, false, true, true, true, true, true, true, true, true
			};
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableHistorico.setBounds(141, 315, 772, 236);
		frame.getContentPane().add(tableHistorico);

		JScrollPane scrollPane = new JScrollPane(tableHistorico);
		scrollPane.setBounds(10, 281, 1856, 236);
		frame.getContentPane().add(scrollPane);

		btnCPF.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		btnCPF.setBounds(985, 187, 109, 30);
		frame.getContentPane().add(btnCPF);

		JRadioButton btnNome = new JRadioButton("NOME\r\n");
		btnNome.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		btnNome.setBackground(UIManager.getColor("CheckBox.background"));
		btnNome.setBounds(595, 187, 109, 30);
		frame.getContentPane().add(btnNome);

		campoCPF = new JTextField();

		campoCPF.setEnabled(false);
		campoCPF.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCPF.setColumns(10);
		campoCPF.setBounds(986, 227, 333, 30);
		frame.getContentPane().add(campoCPF);

		campoNome = new JTextField();

		campoNome.setEnabled(false);
		campoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoNome.setColumns(10);
		campoNome.setBounds(595, 227, 333, 30);
		frame.getContentPane().add(campoNome);

		JLabel lblNewLabel_2_1 = new JLabel(" PESQUISE TODOS OS FUNCIONÁRIO !");
		lblNewLabel_2_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(747, 131, 591, 33);
		frame.getContentPane().add(lblNewLabel_2_1);

		JLabel lblNewLabel_2 = new JLabel("SELECIONE E PREECHA UM DOS CAMPO SELECIONADOS OU");
		lblNewLabel_2.setFont(new Font("Teko SemiBold", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(666, 104, 591, 33);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("HISTÓRICO DE LOCAÇÕES");
		lblNewLabel_1.setBounds(666, 11, 579, 82);
		lblNewLabel_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 65));
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltar.setBounds(1730, 679, 124, 23);
		frame.getContentPane().add(btnVoltar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewTelaCadastroCliente.class
				.getResource("/imagens/—Pngtree—abstract system technology background_1228014.jpg")));
		lblNewLabel.setBounds(0, 0, 1902, 713);
		frame.getContentPane().add(lblNewLabel);

//FUNÇÕES-------------------------------------------------------------------------------------------------------
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewMenuDeConsultas().chamarTelaMenuDeConsultas();
				MinimizarTelaHistoricoLocacao();
			}
		});

		btnPesquisarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					mostrarTodoHistoricoLocacao();
				} catch (Excecao e1) {
					
				}				
			
			}
		});

		campoCPF.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					controller.ListarHistoricoLocacoesPeloCpf(tableHistorico);
				} catch (Excecao e1) {
					
				}
				
			}
		});

		campoNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					controller.ListarHistoricoLocacoesPeloNome(tableHistorico);
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
	
	public void chamarTelaHistoricoLocacao() {
		frame.setVisible(true);

	}

	public void MinimizarTelaHistoricoLocacao() {
		frame.dispose();

	}

}
