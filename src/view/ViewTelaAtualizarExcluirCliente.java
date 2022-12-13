package view;

import java.awt.Color;

import java.awt.EventQueue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Excecoes.Excecao;

import controle.ClienteController;
import model.ClienteModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewTelaAtualizarExcluirCliente {

	private JFrame frameCadastroCliente;
	private JTextField campoNomeAtualizarCliente;
	private JTextField campoRgAtualizarCliente;
	private JTextField campoCpfAtualizarCliente;
	private JTextField campoEnderecoAtualizarCliente;
	private JTextField campoCidadeAtualizarCliente;
	private JTable tableNome;
	private ViewTelaConsultaCliente viewConsultaCliente;
	private ClienteController controller;
	private ClienteModel model;

	public JTextField getCampoNomeAtualizarCliente() {
		return campoNomeAtualizarCliente;
	}

	public void setCampoNomeAtualizarCliente(JTextField campoNomeAtualizarCliente) {
		this.campoNomeAtualizarCliente = campoNomeAtualizarCliente;
	}

	public JTextField getCampoRgAtualizarCliente() {
		return campoRgAtualizarCliente;
	}

	public void setCampoRgAtualizarCliente(JTextField campoRgAtualizarCliente) {
		this.campoRgAtualizarCliente = campoRgAtualizarCliente;
	}

	public JTextField getCampoCpfAtualizarCliente() {
		return campoCpfAtualizarCliente;
	}

	public void setCampoCpfAtualizarCliente(JTextField campoCpfAtualizarCliente) {
		this.campoCpfAtualizarCliente = campoCpfAtualizarCliente;
	}

	public JTextField getCampoEnderecoAtualizarCliente() {
		return campoEnderecoAtualizarCliente;
	}

	public void setCampoEnderecoAtualizarCliente(JTextField campoEnderecoAtualizarCliente) {
		this.campoEnderecoAtualizarCliente = campoEnderecoAtualizarCliente;
	}

	public JTextField getCampoCidadeAtualizarCliente() {
		return campoCidadeAtualizarCliente;
	}

	public void setCampoCidadeAtualizarCliente(JTextField campoCidadeAtualizarCliente) {
		this.campoCidadeAtualizarCliente = campoCidadeAtualizarCliente;
	}

	public JTable getTableNome() {
		return tableNome;
	}

	public void setTableNome(JTable tableNome) {
		this.tableNome = tableNome;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					ViewTelaAtualizarExcluirCliente window = new ViewTelaAtualizarExcluirCliente();
					window.frameCadastroCliente.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewTelaAtualizarExcluirCliente() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		ClienteController controller = new ClienteController(this, model);

		frameCadastroCliente = new JFrame();
		frameCadastroCliente.setBounds(100, 100, 800, 600);
		frameCadastroCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCadastroCliente.getContentPane().setLayout(null);
		frameCadastroCliente.setLocationRelativeTo(null);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(38, 208, 333, 56);
		scrollPane_1.setVisible(false);

		JButton btnExcluirCliente = new JButton("Excluir");
		btnExcluirCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Confirmar Exclusao ?");

				try {
					controller.ExcluirCliente(confirm);
				} catch (Excecao e1) {

				}

			}
		});

		JButton btnLimparCampos = new JButton("Limpar Campos\r\n");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.LimparCamposAlterarExcluirCliente();
			}
		});
		btnLimparCampos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimparCampos.setBounds(36, 452, 191, 48);
		frameCadastroCliente.getContentPane().add(btnLimparCampos);
		btnExcluirCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExcluirCliente.setBounds(554, 452, 191, 48);
		frameCadastroCliente.getContentPane().add(btnExcluirCliente);
		frameCadastroCliente.getContentPane().add(scrollPane_1);

		tableNome = new JTable();
		tableNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.SelecionarNomeAtualizarCliente(tableNome, 0);
				scrollPane_1.setVisible(false);
			}
		});

		tableNome.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null }, },
				new String[] { "", "", "New column", "New column", "New column" }) {
			boolean[] columnEditables = new boolean[] { false, true, true, true, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableNome.getColumnModel().getColumn(1).setPreferredWidth(0);
		tableNome.getColumnModel().getColumn(1).setMinWidth(0);
		tableNome.getColumnModel().getColumn(1).setMaxWidth(0);
		tableNome.getColumnModel().getColumn(2).setPreferredWidth(0);
		tableNome.getColumnModel().getColumn(2).setMinWidth(0);
		tableNome.getColumnModel().getColumn(2).setMaxWidth(0);
		tableNome.getColumnModel().getColumn(3).setPreferredWidth(0);
		tableNome.getColumnModel().getColumn(3).setMinWidth(0);
		tableNome.getColumnModel().getColumn(3).setMaxWidth(0);
		tableNome.getColumnModel().getColumn(4).setPreferredWidth(0);
		tableNome.getColumnModel().getColumn(4).setMinWidth(0);
		tableNome.getColumnModel().getColumn(4).setMaxWidth(0);
		tableNome.setOpaque(false);
		tableNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableNome.setColumnSelectionAllowed(true);
		tableNome.setBackground(Color.WHITE);

		scrollPane_1.setViewportView(tableNome);

		JLabel lblNewLabel_2_1 = new JLabel("CPF e RG Não Podem ser Alterados");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(168, 81, 467, 30);
		frameCadastroCliente.getContentPane().add(lblNewLabel_2_1);

		JLabel lblNome = new JLabel("Nome *");
		lblNome.setBounds(38, 147, 131, 36);
		lblNome.setFont(new Font("Quicksand Light", Font.PLAIN, 25));
		frameCadastroCliente.getContentPane().add(lblNome);

		campoNomeAtualizarCliente = new JTextField();
		campoNomeAtualizarCliente.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				scrollPane_1.setVisible(true);

				try {
					controller.ListarNomesClientesAtualizacao(tableNome);
				} catch (Excecao e1) {

				}

			}
		});
		campoNomeAtualizarCliente.setBounds(38, 182, 333, 30);
		campoNomeAtualizarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoNomeAtualizarCliente.setColumns(10);
		frameCadastroCliente.getContentPane().add(campoNomeAtualizarCliente);

		JLabel lblCpf = new JLabel("CPF *");
		lblCpf.setBounds(443, 137, 131, 56);
		lblCpf.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frameCadastroCliente.getContentPane().add(lblCpf);

		JLabel lblNewLabel_1 = new JLabel("ATUALIZAR/EXCLUIR CLIENTE");
		lblNewLabel_1.setBounds(77, 0, 730, 82);
		lblNewLabel_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 65));
		frameCadastroCliente.getContentPane().add(lblNewLabel_1);

		JLabel lblRg = new JLabel("RG *");
		lblRg.setBounds(38, 216, 131, 56);
		lblRg.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frameCadastroCliente.getContentPane().add(lblRg);

		JLabel lblEndere = new JLabel("Endereço *");
		lblEndere.setBounds(443, 212, 131, 56);
		lblEndere.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frameCadastroCliente.getContentPane().add(lblEndere);

		JLabel lblCidade = new JLabel("Cidade *");
		lblCidade.setBounds(38, 302, 131, 56);
		lblCidade.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frameCadastroCliente.getContentPane().add(lblCidade);

		JButton btnAtualizarCliente = new JButton("Atualizar");
		btnAtualizarCliente.setBounds(296, 452, 191, 48);
		btnAtualizarCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frameCadastroCliente.getContentPane().add(btnAtualizarCliente);

		campoRgAtualizarCliente = new JTextField();
		campoRgAtualizarCliente.setEditable(false);
		campoRgAtualizarCliente.setBounds(38, 261, 333, 30);
		campoRgAtualizarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoRgAtualizarCliente.setColumns(10);
		frameCadastroCliente.getContentPane().add(campoRgAtualizarCliente);

		campoCpfAtualizarCliente = new JTextField();
		campoCpfAtualizarCliente.setEditable(false);
		campoCpfAtualizarCliente.setBounds(429, 182, 333, 30);
		campoCpfAtualizarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCpfAtualizarCliente.setColumns(10);
		frameCadastroCliente.getContentPane().add(campoCpfAtualizarCliente);

		campoEnderecoAtualizarCliente = new JTextField();
		campoEnderecoAtualizarCliente.setBounds(429, 261, 333, 30);
		campoEnderecoAtualizarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoEnderecoAtualizarCliente.setColumns(10);
		frameCadastroCliente.getContentPane().add(campoEnderecoAtualizarCliente);

		campoCidadeAtualizarCliente = new JTextField();
		campoCidadeAtualizarCliente.setBounds(38, 349, 333, 30);
		campoCidadeAtualizarCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCidadeAtualizarCliente.setColumns(10);
		frameCadastroCliente.getContentPane().add(campoCidadeAtualizarCliente);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltar.setBounds(650, 527, 124, 23);
		frameCadastroCliente.getContentPane().add(btnVoltar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewTelaAtualizarExcluirCliente.class
				.getResource("/imagens/—Pngtree—abstract system technology background_1228014.jpg")));
		lblNewLabel.setBounds(0, 0, 784, 561);
		frameCadastroCliente.getContentPane().add(lblNewLabel);

		// Funcoes
		btnAtualizarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Confirmar Atualizacao ?");
				try {
					controller.AtualizarCliente(confirm);
				} catch (Excecao e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					new ViewTelaConsultaCliente().chamarTelaConsultaClientes();
					MinimizarTelaAtualizarCliente();
				} catch (Excecao e1) {

				}

			}
		});

	}

	public void chamarTelaAtualizarCliente() {
		frameCadastroCliente.setVisible(true);

	}

	public void MinimizarTelaAtualizarCliente() {
		frameCadastroCliente.dispose();

	}
}
