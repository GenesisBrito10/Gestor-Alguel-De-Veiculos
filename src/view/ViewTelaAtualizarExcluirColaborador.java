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
import controle.ColaboradorController;
import model.ColaboradorModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewTelaAtualizarExcluirColaborador {

	private JFrame frame;
	private JTextField campoNomeAtualizarColaborador;
	private JTextField campoRgAtualizarColaborador;
	private JTextField campoCpfAtualizarColaboradoro;
	private JTextField campoEnderecoAtualizarColaborador;
	private JTextField campoCidadeAtualizarColaborador;
	private JTable tableNome;
	private ColaboradorController controller;
	private ColaboradorModel model;

	public JTextField getCampoNomeAtualizarColaborador() {
		return campoNomeAtualizarColaborador;
	}

	public void setCampoNomeAtualizarColaborador(JTextField campoNomeAtualizarColaborador) {
		this.campoNomeAtualizarColaborador = campoNomeAtualizarColaborador;
	}

	public JTextField getCampoRgAtualizarColaborador() {
		return campoRgAtualizarColaborador;
	}

	public void setCampoRgAtualizarColaborador(JTextField campoRgAtualizarColaborador) {
		this.campoRgAtualizarColaborador = campoRgAtualizarColaborador;
	}

	public JTextField getCampoCpfAtualizarColaboradoro() {
		return campoCpfAtualizarColaboradoro;
	}

	public void setCampoCpfAtualizarColaboradoro(JTextField campoCpfAtualizarColaboradoro) {
		this.campoCpfAtualizarColaboradoro = campoCpfAtualizarColaboradoro;
	}

	public JTextField getCampoEnderecoAtualizarColaborador() {
		return campoEnderecoAtualizarColaborador;
	}

	public void setCampoEnderecoAtualizarColaborador(JTextField campoEnderecoAtualizarColaborador) {
		this.campoEnderecoAtualizarColaborador = campoEnderecoAtualizarColaborador;
	}

	public JTextField getCampoCidadeAtualizarColaborador() {
		return campoCidadeAtualizarColaborador;
	}

	public void setCampoCidadeAtualizarColaborador(JTextField campoCidadeAtualizarColaborador) {
		this.campoCidadeAtualizarColaborador = campoCidadeAtualizarColaborador;
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
					ViewTelaAtualizarExcluirColaborador window = new ViewTelaAtualizarExcluirColaborador();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewTelaAtualizarExcluirColaborador() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {

		this.controller = null;
		ColaboradorController controller = new ColaboradorController(this, model);

		frame = new JFrame();
		frame.setBounds(100, 100, 800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(20, 210, 333, 67);
		scrollPane.setVisible(false);

		JButton btnLimparCampos = new JButton("Limpar Campos\r\n");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.LimparCamposAlterarExcluirColaborador();
			}
		});
		btnLimparCampos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimparCampos.setBounds(20, 444, 191, 48);
		frame.getContentPane().add(btnLimparCampos);
		frame.getContentPane().add(scrollPane);

		tableNome = new JTable();
		tableNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.SelecionarNomeAtualizarColaborador(tableNome, 0);
				scrollPane.setVisible(false);
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
		scrollPane.setViewportView(tableNome);

		JButton btnExcluirColaborador = new JButton("Excluir");
		btnExcluirColaborador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Confirmar Exclusão ?");
				try {
					controller.ExcluirColaborador(confirm);
				} catch (Excecao e1) {

				}
			}
		});
		btnExcluirColaborador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExcluirColaborador.setBounds(553, 444, 191, 48);
		frame.getContentPane().add(btnExcluirColaborador);

		JLabel lblNewLabel_1 = new JLabel("ATUALIZAR/EXCLUIR COLABORADOR");
		lblNewLabel_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 60));
		lblNewLabel_1.setBounds(20, -7, 764, 82);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblNewLabel_2_1 = new JLabel("CPF e RG Não Podem ser Alterados");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(150, 64, 467, 30);
		frame.getContentPane().add(lblNewLabel_2_1);

		JLabel lblNome = new JLabel("Nome *");
		lblNome.setBounds(20, 145, 131, 36);
		lblNome.setFont(new Font("Quicksand Light", Font.PLAIN, 25));
		frame.getContentPane().add(lblNome);

		campoNomeAtualizarColaborador = new JTextField();
		campoNomeAtualizarColaborador.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {

				try {
					controller.ListarNomesColaboradorAtualizacao(tableNome);
					scrollPane.setVisible(true);
				} catch (Excecao e1) {

				}

			}
		});
		campoNomeAtualizarColaborador.setBounds(20, 180, 333, 30);
		campoNomeAtualizarColaborador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoNomeAtualizarColaborador.setColumns(10);
		frame.getContentPane().add(campoNomeAtualizarColaborador);

		JLabel lblCpf = new JLabel("CPF *");
		lblCpf.setBounds(425, 135, 131, 56);
		lblCpf.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frame.getContentPane().add(lblCpf);

		JLabel lblRg = new JLabel("RG *");
		lblRg.setBounds(20, 214, 131, 56);
		lblRg.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frame.getContentPane().add(lblRg);

		JLabel lblEndere = new JLabel("Endereço *");
		lblEndere.setBounds(425, 210, 131, 56);
		lblEndere.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frame.getContentPane().add(lblEndere);

		JLabel lblCidade = new JLabel("Cidade *");
		lblCidade.setBounds(20, 281, 131, 56);
		lblCidade.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frame.getContentPane().add(lblCidade);

		JButton btnAtualizarColaborador = new JButton("Atualizar");
		btnAtualizarColaborador.setBounds(266, 444, 191, 48);
		btnAtualizarColaborador.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnAtualizarColaborador);

		campoRgAtualizarColaborador = new JTextField();
		campoRgAtualizarColaborador.setEditable(false);
		campoRgAtualizarColaborador.setBounds(20, 259, 333, 30);
		campoRgAtualizarColaborador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoRgAtualizarColaborador.setColumns(10);
		frame.getContentPane().add(campoRgAtualizarColaborador);

		campoCpfAtualizarColaboradoro = new JTextField();
		campoCpfAtualizarColaboradoro.setEditable(false);
		campoCpfAtualizarColaboradoro.setBounds(411, 180, 333, 30);
		campoCpfAtualizarColaboradoro.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCpfAtualizarColaboradoro.setColumns(10);
		frame.getContentPane().add(campoCpfAtualizarColaboradoro);

		campoEnderecoAtualizarColaborador = new JTextField();
		campoEnderecoAtualizarColaborador.setBounds(411, 259, 333, 30);
		campoEnderecoAtualizarColaborador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoEnderecoAtualizarColaborador.setColumns(10);
		frame.getContentPane().add(campoEnderecoAtualizarColaborador);

		campoCidadeAtualizarColaborador = new JTextField();
		campoCidadeAtualizarColaborador.setBounds(20, 328, 333, 30);
		campoCidadeAtualizarColaborador.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCidadeAtualizarColaborador.setColumns(10);
		frame.getContentPane().add(campoCidadeAtualizarColaborador);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltar.setBounds(650, 527, 124, 23);
		frame.getContentPane().add(btnVoltar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewTelaCadastroCliente.class
				.getResource("/imagens/—Pngtree—abstract system technology background_1228014.jpg")));
		lblNewLabel.setBounds(0, 0, 784, 561);
		frame.getContentPane().add(lblNewLabel);

//FUNÇÕES---------------------------------------------------------------------------------		
		btnAtualizarColaborador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int confirm = JOptionPane.showConfirmDialog(null, "Confirmar Atualização ?");
				try {
					controller.AtualizarColaborador(confirm);
				} catch (Excecao e1) {

				}

			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewMenuDeCadastros().chamarMenuDeCadastros();
				frame.dispose();

			}
		});

	}

	public void chamarTelaAtualizarColaborador() {
		frame.setVisible(true);
	}

	public void MinimizarTelaAtualizarColaborador() {
		frame.dispose();
	}

}
