package view;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Excecoes.Excecao;
import controle.ClienteController;
import controle.VeiculoController;
import model.ClienteModel;
import model.VeiculoModel;

import java.awt.SystemColor;
import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewTelaDeConsultaVeiculo {

	private JFrame frame;
	private JTextField campoMarca;
	private JTable tableVeiculo;
	private JComboBox comboBoxAno;
	private VeiculoController controller;
	private VeiculoModel model;

	public JTextField getCampoMarca() {
		return campoMarca;
	}

	public void setCampoMarca(JTextField campoMarca) {
		this.campoMarca = campoMarca;
	}

	public JTable getTableVeiculo() {
		return tableVeiculo;
	}

	public void setTableVeiculo(JTable tableVeiculo) {
		this.tableVeiculo = tableVeiculo;
	}

	public JComboBox getComboBoxAno() {
		return comboBoxAno;
	}

	public void setComboBoxAno(JComboBox comboBoxAno) {
		this.comboBoxAno = comboBoxAno;
	}

	public void ListarTodosVeiculos() throws Excecao {
		VeiculoController controller = new VeiculoController(this,model);
		controller.ListarTodosVeiculos(tableVeiculo);
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTelaDeConsultaVeiculo window = new ViewTelaDeConsultaVeiculo();
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
	public ViewTelaDeConsultaVeiculo() throws Excecao {
		initialize();
		ListarTodosVeiculos();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.controller = null;
		VeiculoController controller = new VeiculoController(this,model);

		frame = new JFrame();
		frame.setBounds(100, 100, 1054, 752);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		comboBoxAno = new JComboBox();
		comboBoxAno.setEnabled(false);
		comboBoxAno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.ListarVeiculosPeloAno(tableVeiculo);
				} catch (Excecao e1) {
					
				}
			}
		});
		
		JButton btnCadastrat = new JButton("Cadastrar");
		btnCadastrat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewTelaCadastroVeiculo().chamarTelaCadastratoVeiculo();
				frame.dispose();
			}
		});
		
		JButton btnPesquisarAlugados = new JButton("Pesquisar Alugados\r\n");
		btnPesquisarAlugados.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.ListarVeiculosAlugados(tableVeiculo);
				} catch (Excecao e1) {
				
				}
			}
		});
		btnPesquisarAlugados.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPesquisarAlugados.setBounds(645, 580, 249, 48);
		frame.getContentPane().add(btnPesquisarAlugados);
		btnCadastrat.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCadastrat.setBounds(904, 580, 124, 48);
		frame.getContentPane().add(btnCadastrat);

		comboBoxAno.setModel(new DefaultComboBoxModel(listaAnos()));
		comboBoxAno.setBounds(500, 212, 308, 27);
		frame.getContentPane().add(comboBoxAno);

		JButton btnPesquisarDisponiveis = new JButton("Pesquisar Disponiveis");
		btnPesquisarDisponiveis.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPesquisarDisponiveis.setBounds(392, 580, 243, 48);
		frame.getContentPane().add(btnPesquisarDisponiveis);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(21, 269, 951, 236);
		frame.getContentPane().add(scrollPane);

		tableVeiculo = new JTable();
		tableVeiculo.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "ID", "MARCA", "MODELO", "ANO", "PLACA", "COR", "ESTADO", "STATUS" }) {
			boolean[] columnEditables = new boolean[] { false, false, true, true, false, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(tableVeiculo);

		JRadioButton btnMarca = new JRadioButton("MARCA");
		btnMarca.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		btnMarca.setBackground(SystemColor.menu);
		btnMarca.setBounds(110, 175, 109, 30);
		frame.getContentPane().add(btnMarca);

		JRadioButton btnAno = new JRadioButton("ANO");
		btnAno.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		btnAno.setBounds(500, 175, 153, 30);
		frame.getContentPane().add(btnAno);

		campoMarca = new JTextField();
		campoMarca.setEnabled(false);
		campoMarca.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					controller.ListarVeiculoPelaMarca(tableVeiculo);
				} catch (Excecao e1) {
					
				}

			}
		});
		campoMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoMarca.setColumns(10);
		campoMarca.setBounds(110, 212, 333, 30);
		frame.getContentPane().add(campoMarca);

		JLabel lblNewLabel_2_1 = new JLabel(" PESQUISE TODOS OS VEÍCULOS !");
		lblNewLabel_2_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(279, 106, 591, 33);
		frame.getContentPane().add(lblNewLabel_2_1);

		JButton btnPesquisarTodos = new JButton("Pesquisar Todos");
		btnPesquisarTodos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnPesquisarTodos.setBounds(189, 580, 189, 48);
		frame.getContentPane().add(btnPesquisarTodos);

		JLabel lblNewLabel_2 = new JLabel("SELECIONE E PREECHA O CAMPO SELECIONADO OU");
		lblNewLabel_2.setFont(new Font("Teko SemiBold", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(207, 76, 591, 33);
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNewLabel_1 = new JLabel("CONSULTAR VEÍCULO\r\n");
		lblNewLabel_1.setBounds(207, 0, 579, 82);
		lblNewLabel_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 65));
		frame.getContentPane().add(lblNewLabel_1);

		JButton btnPesquisarVeiculo = new JButton("Alterar/Excluir");
		btnPesquisarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewTelaAtualizarExcluirVeiculo().chamarTelaAlterarExcluirVeiculo();
				frame.dispose();
			}
		});
		btnPesquisarVeiculo.setBounds(10, 580, 169, 48);
		btnPesquisarVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnPesquisarVeiculo);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltar.setBounds(817, 665, 124, 23);
		frame.getContentPane().add(btnVoltar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewTelaCadastroCliente.class
				.getResource("/imagens/—Pngtree—abstract system technology background_1228014.jpg")));
		lblNewLabel.setBounds(0, 0, 1038, 713);
		frame.getContentPane().add(lblNewLabel);

//FUNÇÕES--------------------------------------------------------------------------------------------

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewMenuDeConsultas().chamarTelaMenuDeConsultas();
				frame.dispose();
			}
		});

		btnPesquisarTodos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ListarTodosVeiculos();
				} catch (Excecao e1) {
					
				}

			}
		});

		btnPesquisarDisponiveis.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					controller.ListarVeiculosDisponiveis(tableVeiculo);
				} catch (Excecao e1) {
					
				}

			}
		});

		btnMarca.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnMarca.isSelected()) {
					comboBoxAno.setEnabled(false);
					campoMarca.setEnabled(true);
					btnAno.setSelected(false);

				} else {
					campoMarca.setEnabled(false);
				}

			}
		});

		btnAno.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (btnAno.isSelected()) {
					comboBoxAno.setEnabled(true);
					campoMarca.setEnabled(false);
					btnMarca.setSelected(false);

				} else {
					comboBoxAno.setEnabled(false);
					btnAno.setSelected(false);
				}
			}
		});

	}

	public void chamarTelaConsultaVeiculo() {
		frame.setVisible(true);

	}
	public void MinimizarTelaConsultaVeiculo() {
		frame.dispose();

	}

	public String[] listaAnos() {
		String[] dados;
		Date hoje = new Date();
		String formato = "yyyy";

		SimpleDateFormat formatter = new SimpleDateFormat(formato);
		int anoatual = Integer.parseInt(formatter.format(hoje));
		dados = new String[anoatual - 1996];

		for (int i = 0; anoatual >= 1998; i++) {
			dados[i] = String.valueOf(anoatual);
			anoatual--;
		}
		return dados;
	}
}
