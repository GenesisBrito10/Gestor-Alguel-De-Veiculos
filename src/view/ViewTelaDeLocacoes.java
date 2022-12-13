package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import java.awt.Font;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.border.LineBorder;

import conexao.ConexaoDAO;
import controle.ClienteController;
import controle.LocacoesController;
import controle.VeiculoController;
import model.ClienteModel;
import model.LocacaoModel;
import model.VeiculoModel;

import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import Excecoes.Excecao;

import javax.swing.JScrollPane;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ViewTelaDeLocacoes {

	private JFrame frame;
	private JTextField campoNome;
	private JTextField campoRg;
	private JTextField campoCpf;
	private JTextField campoEndereco;
	private JTextField campoCidade;
	private JTextField campoMarca;
	private JTextField campoModelo;
	private JTextField campoAno;
	private JTable tableNome;
	private JTable tableModelo;
	private JTextField campoCod;
	private JComboBox comboBoxCor;
	private JComboBox comboBoxStatus;
	private JComboBox comboBoxEstado;
	private JComboBox comboBoxDias;
	private JComboBox comboBoxPagamento;
	private JComboBox comboBoxData;
	private LocacoesController controller;
	private LocacaoModel model;

	public JTextField getCampoNome() {
		return campoNome;
	}

	public void setCampoNome(JTextField campoNome) {
		this.campoNome = campoNome;
	}

	public JTextField getCampoRg() {
		return campoRg;
	}

	public void setCampoRg(JTextField campoRg) {
		this.campoRg = campoRg;
	}

	public JTextField getCampoCpf() {
		return campoCpf;
	}

	public void setCampoCpf(JTextField campoCpf) {
		this.campoCpf = campoCpf;
	}

	public JTextField getCampoEndereco() {
		return campoEndereco;
	}

	public void setCampoEndereco(JTextField campoEndereco) {
		this.campoEndereco = campoEndereco;
	}

	public JTextField getCampoCidade() {
		return campoCidade;
	}

	public void setCampoCidade(JTextField campoCidade) {
		this.campoCidade = campoCidade;
	}

	public JTextField getCampoMarca() {
		return campoMarca;
	}

	public void setCampoMarca(JTextField campoMarca) {
		this.campoMarca = campoMarca;
	}

	public JTextField getCampoModelo() {
		return campoModelo;
	}

	public void setCampoModelo(JTextField campoModelo) {
		this.campoModelo = campoModelo;
	}

	public JTextField getCampoAno() {
		return campoAno;
	}

	public void setCampoAno(JTextField campoAno) {
		this.campoAno = campoAno;
	}

	public JTable getTableNome() {
		return tableNome;
	}

	public void setTableNome(JTable tableNome) {
		this.tableNome = tableNome;
	}

	public JTable getTableModelo() {
		return tableModelo;
	}

	public void setTableModelo(JTable tableModelo) {
		this.tableModelo = tableModelo;
	}

	public JTextField getCampoCod() {
		return campoCod;
	}

	public void setCampoCod(JTextField campoCod) {
		this.campoCod = campoCod;
	}

	public JComboBox getComboBoxCor() {
		return comboBoxCor;
	}

	public void setComboBoxCor(JComboBox comboBoxCor) {
		this.comboBoxCor = comboBoxCor;
	}

	public JComboBox getComboBoxStatus() {
		return comboBoxStatus;
	}

	public void setComboBoxStatus(JComboBox comboBoxStatus) {
		this.comboBoxStatus = comboBoxStatus;
	}

	public JComboBox getComboBoxEstado() {
		return comboBoxEstado;
	}

	public void setComboBoxEstado(JComboBox comboBoxEstado) {
		this.comboBoxEstado = comboBoxEstado;
	}

	public JComboBox getComboBoxDias() {
		return comboBoxDias;
	}

	public void setComboBoxDias(JComboBox comboBoxDias) {
		this.comboBoxDias = comboBoxDias;
	}

	public JComboBox getComboBoxPagamento() {
		return comboBoxPagamento;
	}

	public void setComboBoxPagamento(JComboBox comboBoxPagamento) {
		this.comboBoxPagamento = comboBoxPagamento;
	}

	public JComboBox getComboBoxData() {
		return comboBoxData;
	}

	public void setComboBoxData(JComboBox comboBoxData) {
		this.comboBoxData = comboBoxData;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					ViewTelaDeLocacoes window = new ViewTelaDeLocacoes();
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
	public ViewTelaDeLocacoes() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.controller = null;
		this.model = null;
		LocacoesController controller = new LocacoesController(this, model);

		frame = new JFrame();
		frame.setBounds(100, 100, 1222, 806);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(20, 145, 333, 85);
		scrollPane.setVisible(false);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(424, 326, 333, 73);
		scrollPane_1.setVisible(false);

		

		JLabel lblCod = new JLabel("Cod");
		lblCod.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblCod.setBounds(1141, 257, 131, 56);
		frame.getContentPane().add(lblCod);

		campoCod = new JTextField();

		campoCod.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCod.setColumns(10);
		campoCod.setBounds(1141, 302, 55, 30);
		frame.getContentPane().add(campoCod);

		JLabel campoDias = new JLabel("Dias");
		campoDias.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		campoDias.setBounds(796, 427, 131, 56);
		frame.getContentPane().add(campoDias);

		comboBoxDias = new JComboBox();
		comboBoxDias.setModel(new DefaultComboBoxModel(dias()));
		comboBoxDias.setFont(new Font("Quicksand Light", Font.PLAIN, 15));
		comboBoxDias.setBackground(Color.WHITE);
		comboBoxDias.setBounds(796, 470, 333, 30);
		frame.getContentPane().add(comboBoxDias);

		comboBoxPagamento = new JComboBox();
		comboBoxPagamento.setModel(
				new DefaultComboBoxModel(new String[] { "PIX", "CARTAO DE DEBITO", "CARTAO DE CREDITO", "DINHEIRO" }));
		comboBoxPagamento.setFont(new Font("Quicksand Light", Font.PLAIN, 15));
		comboBoxPagamento.setBackground(Color.WHITE);
		comboBoxPagamento.setBounds(434, 470, 333, 30);
		frame.getContentPane().add(comboBoxPagamento);

		JLabel lblFormaDePagamento = new JLabel("Forma de Pagamento");
		lblFormaDePagamento.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblFormaDePagamento.setBounds(434, 427, 263, 56);
		frame.getContentPane().add(lblFormaDePagamento);
		
		comboBoxData = new JComboBox();
		Date dataAtual = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = dateFormat.format(dataAtual);
		comboBoxData.setModel(new DefaultComboBoxModel(new String[] { dataFormatada }));
		comboBoxData.setFont(new Font("Quicksand Light", Font.PLAIN, 15));
		comboBoxData.setBackground(Color.WHITE);
		comboBoxData.setBounds(20, 470, 333, 30);
		frame.getContentPane().add(comboBoxData);

		JLabel lblData = new JLabel("Data");
		lblData.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblData.setBounds(20, 427, 131, 56);
		frame.getContentPane().add(lblData);
		frame.getContentPane().add(scrollPane_1);

		tableModelo = new JTable();

		tableModelo.setModel(new DefaultTableModel(new Object[][] { { null, null, null, null, null, null, null }, },
				new String[] { "", "", "", "New column", "New column", "", "" }) {
			boolean[] columnEditables = new boolean[] { false, false, true, true, true, false, true };

			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		tableModelo.getColumnModel().getColumn(0).setPreferredWidth(0);
		tableModelo.getColumnModel().getColumn(0).setMinWidth(0);
		tableModelo.getColumnModel().getColumn(0).setMaxWidth(0);
		tableModelo.getColumnModel().getColumn(2).setPreferredWidth(0);
		tableModelo.getColumnModel().getColumn(2).setMinWidth(0);
		tableModelo.getColumnModel().getColumn(2).setMaxWidth(0);
		tableModelo.getColumnModel().getColumn(3).setPreferredWidth(0);
		tableModelo.getColumnModel().getColumn(3).setMinWidth(0);
		tableModelo.getColumnModel().getColumn(3).setMaxWidth(0);
		tableModelo.getColumnModel().getColumn(4).setPreferredWidth(0);
		tableModelo.getColumnModel().getColumn(4).setMinWidth(0);
		tableModelo.getColumnModel().getColumn(4).setMaxWidth(0);
		tableModelo.getColumnModel().getColumn(5).setPreferredWidth(0);
		tableModelo.getColumnModel().getColumn(5).setMinWidth(0);
		tableModelo.getColumnModel().getColumn(5).setMaxWidth(0);
		tableModelo.getColumnModel().getColumn(6).setPreferredWidth(15);
		tableModelo.getColumnModel().getColumn(6).setMinWidth(0);
		tableModelo.getColumnModel().getColumn(6).setMaxWidth(0);
		scrollPane_1.setViewportView(tableModelo);
		frame.getContentPane().add(scrollPane);

		tableNome = new JTable();

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

		campoModelo = new JTextField();
		campoModelo.setBounds(424, 302, 333, 30);
		campoModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoModelo.setColumns(10);
		frame.getContentPane().add(campoModelo);

		comboBoxCor = new JComboBox();
		comboBoxCor.setBounds(20, 386, 333, 30);
		comboBoxCor.setFont(new Font("Quicksand Light", Font.PLAIN, 15));
		comboBoxCor.setBackground(Color.WHITE);
		frame.getContentPane().add(comboBoxCor);

		comboBoxStatus = new JComboBox();
		comboBoxStatus.setBounds(796, 386, 333, 30);
		comboBoxStatus.setFont(new Font("Quicksand Light", Font.PLAIN, 15));
		comboBoxStatus.setBackground(Color.WHITE);
		frame.getContentPane().add(comboBoxStatus);

		JLabel lblEstado_1 = new JLabel("Estado ");
		lblEstado_1.setBounds(434, 343, 131, 56);
		lblEstado_1.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frame.getContentPane().add(lblEstado_1);

		JLabel lblBairro = new JLabel("Cor");
		lblBairro.setBounds(20, 343, 131, 56);
		lblBairro.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frame.getContentPane().add(lblBairro);

		JLabel lblCpf_1 = new JLabel("Modelo*");
		lblCpf_1.setBounds(438, 257, 131, 56);
		lblCpf_1.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frame.getContentPane().add(lblCpf_1);

		JLabel lblAno = new JLabel("Ano");
		lblAno.setBounds(796, 257, 131, 56);
		lblAno.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frame.getContentPane().add(lblAno);

		JLabel lblStatus_1 = new JLabel("Status ");
		lblStatus_1.setBounds(796, 343, 131, 56);
		lblStatus_1.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frame.getContentPane().add(lblStatus_1);

		campoAno = new JTextField();

		campoAno.setBounds(796, 302, 333, 30);
		campoAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoAno.setColumns(10);
		frame.getContentPane().add(campoAno);

		comboBoxEstado = new JComboBox();
		comboBoxEstado.setBounds(434, 386, 333, 30);
		comboBoxEstado.setFont(new Font("Quicksand Light", Font.PLAIN, 15));
		comboBoxEstado.setBackground(Color.WHITE);
		frame.getContentPane().add(comboBoxEstado);

		JLabel lblMarca = new JLabel("Marca");
		lblMarca.setBounds(20, 267, 131, 36);
		lblMarca.setFont(new Font("Quicksand Light", Font.PLAIN, 25));
		frame.getContentPane().add(lblMarca);

		campoMarca = new JTextField();

		campoMarca.setBounds(20, 302, 333, 30);
		campoMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoMarca.setColumns(10);
		frame.getContentPane().add(campoMarca);

		JSeparator separator = new JSeparator();
		separator.setBounds(0, 257, 1206, 23);
		frame.getContentPane().add(separator);

		JLabel lblNewLabel_2 = new JLabel("Campos com \"*\" \r\nsão obrigatórios");
		lblNewLabel_2.setBounds(10, 695, 387, 30);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(lblNewLabel_2);

		JLabel lblNome = new JLabel("Nome *");
		lblNome.setBounds(20, 86, 131, 36);
		lblNome.setFont(new Font("Quicksand Light", Font.PLAIN, 25));
		frame.getContentPane().add(lblNome);

		campoNome = new JTextField();
		campoNome.setBounds(20, 121, 333, 30);
		campoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoNome.setColumns(10);
		frame.getContentPane().add(campoNome);

		JLabel lblCpf = new JLabel("CPF *");
		lblCpf.setBounds(425, 76, 131, 56);
		lblCpf.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frame.getContentPane().add(lblCpf);

		JLabel lblNewLabel_1 = new JLabel("LOCACAO");
		lblNewLabel_1.setBounds(347, 0, 441, 82);
		lblNewLabel_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 65));
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblRg = new JLabel("RG *");
		lblRg.setBounds(796, 76, 131, 56);
		lblRg.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frame.getContentPane().add(lblRg);

		JLabel lblEndere = new JLabel("Endereço *");
		lblEndere.setBounds(425, 151, 131, 56);
		lblEndere.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frame.getContentPane().add(lblEndere);

		JLabel lblCidade = new JLabel("Cidade *");
		lblCidade.setBounds(20, 153, 131, 56);
		lblCidade.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frame.getContentPane().add(lblCidade);

		JButton btnLocar = new JButton("Locar");
		btnLocar.setBounds(375, 684, 191, 48);
		btnLocar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnLocar);

		campoRg = new JTextField();

		campoRg.setBounds(796, 121, 333, 30);
		campoRg.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoRg.setColumns(10);
		frame.getContentPane().add(campoRg);

		campoCpf = new JTextField();

		campoCpf.setBounds(411, 121, 333, 30);
		campoCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCpf.setColumns(10);
		frame.getContentPane().add(campoCpf);

		campoEndereco = new JTextField();

		campoEndereco.setBounds(411, 200, 333, 30);
		campoEndereco.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoEndereco.setColumns(10);
		frame.getContentPane().add(campoEndereco);

		campoCidade = new JTextField();

		campoCidade.setBounds(20, 200, 333, 30);
		campoCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCidade.setColumns(10);
		frame.getContentPane().add(campoCidade);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewMenuPrincipal().chamarMenuPrincipal();
				frame.dispose();
			}
		});
		btnVoltar.setBounds(814, 720, 124, 23);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(btnVoltar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 1206, 767);
		lblNewLabel.setIcon(new ImageIcon(ViewTelaCadastroCliente.class
				.getResource("/imagens/—Pngtree—abstract system technology background_1228014.jpg")));
		frame.getContentPane().add(lblNewLabel);

		campoModelo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				scrollPane_1.setVisible(true);

				try {
					controller.ListarVeiculosPeloModeloLocacao(tableModelo);
				} catch (Excecao e1) {
					
				}

			}
		});

		tableModelo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				controller.SelecionarModeloLocacao(tableModelo, 0);

				scrollPane_1.setVisible(false);

			}
		});

		campoNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
					scrollPane.setVisible(true);
					controller.ListarNomesClientesLocacao(tableNome);
				} catch (Excecao e1) {
				
				}

			}
		});

		tableNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				controller.SelecionarNomeLocacao(tableNome, 0);
				scrollPane.setVisible(false);

			}
		});

		btnLocar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Confirmar Locacao ?");
				try {
					controller.ConcluirLocacao(confirm);
				} catch (Excecao e1) {
					
				}
			}
		});

		// -------------------------------------------------------------------------------------------------------------------------------------------------------------

	}

	public void chamarTelaDeLocacao() {
		frame.setVisible(true);

	}

	public void MinimizarTelaDeLocacao() {

		frame.dispose();
	}

	public String[] dias() {
		int total = 30;
		String[] dias;
		dias = new String[30];
		for (int i = 0; total >= 1; i++) {
			dias[i] = String.valueOf(total);
			total--;
		}

		return dias;
	}

}
