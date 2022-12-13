package view;

import java.awt.Color;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Excecoes.Excecao;
import controle.DevolucaoController;
import controle.LocacoesController;
import dao.DevolucaoDAO;
import model.DevolucaoModel;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ViewTelaDeDevolucao {

	private JFrame frame;
	private JTextField campoNome;
	private JTextField campoCidade;
	private JTextField campoCpf;
	private JTextField campoMarca;
	private JTextField campoModelo;
	private JTextField campoAno;
	private JTable tableNome;
	private JTextField campoCod;
	private JComboBox comboBoxCor;
	private JComboBox comboBoxEstado;
	private JComboBox comboBoxDias;
	private JComboBox comboBoxPagamento;
	private JComboBox comboBoxData;
	private JTextField campoCodContrato;
	private JComboBox comboBoxDataDevolucao;
	private DevolucaoController controller;
	private DevolucaoModel model;

	public JTextField getCampoNome() {
		return campoNome;
	}

	public void setCampoNome(JTextField campoNome) {
		this.campoNome = campoNome;
	}

	public JTextField getCampoCidade() {
		return campoCidade;
	}

	public void setCampoCidade(JTextField campoCidade) {
		this.campoCidade = campoCidade;
	}

	public JTextField getCampoCpf() {
		return campoCpf;
	}

	public void setCampoCpf(JTextField campoCpf) {
		this.campoCpf = campoCpf;
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

	public JTextField getCampoCodContrato() {
		return campoCodContrato;
	}

	public void setCampoCodContrato(JTextField campoCodContrato) {
		this.campoCodContrato = campoCodContrato;
	}

	public JComboBox getComboBoxDataDevolucao() {
		return comboBoxDataDevolucao;
	}

	public void setComboBoxDataDevolucao(JComboBox comboBoxDataDevolucao) {
		this.comboBoxDataDevolucao = comboBoxDataDevolucao;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTelaDeDevolucao window = new ViewTelaDeDevolucao();
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
	public ViewTelaDeDevolucao() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.controller = null;
		DevolucaoController controller = new DevolucaoController(this, model);

		frame = new JFrame();
		frame.setBounds(100, 100, 1222, 806);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JScrollPane scrollPane = new JScrollPane((Component) null);
		scrollPane.setBounds(20, 145, 174, 85);
		scrollPane.setVisible(false);

		JLabel lblDataDevolucao = new JLabel("Data Devolucao");
		lblDataDevolucao.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblDataDevolucao.setBounds(20, 410, 174, 56);
		frame.getContentPane().add(lblDataDevolucao);

		comboBoxDataDevolucao = new JComboBox();
		comboBoxData = new JComboBox();
		Date dataAtual = new Date();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		String dataFormatada = dateFormat.format(dataAtual);
		comboBoxDataDevolucao.setModel(new DefaultComboBoxModel(new String[] { dataFormatada }));

		comboBoxDataDevolucao.setFont(new Font("Quicksand Light", Font.PLAIN, 15));
		comboBoxDataDevolucao.setBackground(Color.WHITE);
		comboBoxDataDevolucao.setBounds(20, 453, 333, 30);
		frame.getContentPane().add(comboBoxDataDevolucao);
		frame.getContentPane().add(scrollPane);

		tableNome = new JTable();
		tableNome.setShowGrid(false);
		tableNome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.SelecionarNomeAtualizarCliente(tableNome, 0);
				scrollPane.setVisible(false);

			}
		});

		tableNome.setModel(new DefaultTableModel(new Object[][] {},
				new String[] { "", "", "New column", "New column", "New column", "", "", "", "", "", "", "", "" }) {
			boolean[] columnEditables = new boolean[] { false, true, true, true, true, true, true, true, true, true,
					true, true, true };

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
		tableNome.getColumnModel().getColumn(5).setResizable(false);
		tableNome.getColumnModel().getColumn(5).setPreferredWidth(15);
		tableNome.getColumnModel().getColumn(5).setMinWidth(0);
		tableNome.getColumnModel().getColumn(6).setResizable(false);
		tableNome.getColumnModel().getColumn(6).setPreferredWidth(15);
		tableNome.getColumnModel().getColumn(6).setMinWidth(0);
		tableNome.getColumnModel().getColumn(7).setResizable(false);
		tableNome.getColumnModel().getColumn(7).setPreferredWidth(15);
		tableNome.getColumnModel().getColumn(7).setMinWidth(0);
		tableNome.getColumnModel().getColumn(8).setResizable(false);
		tableNome.getColumnModel().getColumn(8).setPreferredWidth(15);
		tableNome.getColumnModel().getColumn(8).setMinWidth(0);
		tableNome.getColumnModel().getColumn(9).setResizable(false);
		tableNome.getColumnModel().getColumn(9).setPreferredWidth(15);
		tableNome.getColumnModel().getColumn(9).setMinWidth(0);
		tableNome.getColumnModel().getColumn(10).setResizable(false);
		tableNome.getColumnModel().getColumn(10).setPreferredWidth(15);
		tableNome.getColumnModel().getColumn(10).setMinWidth(0);
		tableNome.getColumnModel().getColumn(11).setResizable(false);
		tableNome.getColumnModel().getColumn(11).setPreferredWidth(15);
		tableNome.getColumnModel().getColumn(11).setMinWidth(0);
		tableNome.getColumnModel().getColumn(12).setResizable(false);
		tableNome.getColumnModel().getColumn(12).setPreferredWidth(15);
		tableNome.getColumnModel().getColumn(12).setMinWidth(0);
		tableNome.setOpaque(false);
		tableNome.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableNome.setColumnSelectionAllowed(true);
		tableNome.setBackground(Color.WHITE);

		scrollPane.setColumnHeaderView(tableNome);

		JLabel lblCodcontrato = new JLabel("Cod.Contrato");
		lblCodcontrato.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblCodcontrato.setBounds(20, 155, 154, 56);
		frame.getContentPane().add(lblCodcontrato);

		campoCodContrato = new JTextField();
		campoCodContrato.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCodContrato.setColumns(10);
		campoCodContrato.setBounds(20, 200, 55, 30);
		frame.getContentPane().add(campoCodContrato);

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
		campoDias.setBounds(796, 410, 131, 56);
		frame.getContentPane().add(campoDias);

		comboBoxDias = new JComboBox();
		comboBoxDias.setModel(new DefaultComboBoxModel());
		comboBoxDias.setFont(new Font("Quicksand Light", Font.PLAIN, 15));
		comboBoxDias.setBackground(Color.WHITE);
		comboBoxDias.setBounds(796, 453, 333, 30);
		frame.getContentPane().add(comboBoxDias);

		comboBoxPagamento = new JComboBox();
		comboBoxPagamento.setFont(new Font("Quicksand Light", Font.PLAIN, 15));
		comboBoxPagamento.setBackground(Color.WHITE);
		comboBoxPagamento.setBounds(424, 453, 333, 30);
		frame.getContentPane().add(comboBoxPagamento);

		JLabel lblFormaDePagamento = new JLabel("Forma de Pagamento");
		lblFormaDePagamento.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblFormaDePagamento.setBounds(424, 410, 263, 56);
		frame.getContentPane().add(lblFormaDePagamento);
		comboBoxData.setFont(new Font("Quicksand Light", Font.PLAIN, 15));
		comboBoxData.setBackground(Color.WHITE);
		comboBoxData.setBounds(796, 386, 333, 30);
		frame.getContentPane().add(comboBoxData);

		JLabel lblData = new JLabel("Data Locacao");
		lblData.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblData.setBounds(796, 343, 154, 56);
		frame.getContentPane().add(lblData);

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

		JLabel lblEstado_1 = new JLabel("Estado ");
		lblEstado_1.setBounds(424, 343, 131, 56);
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

		campoAno = new JTextField();
		campoAno.setBounds(796, 302, 333, 30);
		campoAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoAno.setColumns(10);
		frame.getContentPane().add(campoAno);

		comboBoxEstado = new JComboBox();
		comboBoxEstado.setBounds(424, 386, 333, 30);
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

		JLabel lblNome = new JLabel("Nome ");
		lblNome.setBounds(20, 86, 131, 36);
		lblNome.setFont(new Font("Quicksand Light", Font.PLAIN, 25));
		frame.getContentPane().add(lblNome);

		campoNome = new JTextField();
		campoNome.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					controller.ListarClienteDevolucaoPeloNomeConsulta(tableNome);
					scrollPane.setVisible(true);
				} catch (Excecao e1) {
					
				}
				
			}
		});
		campoNome.setBounds(20, 121, 333, 30);
		campoNome.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoNome.setColumns(10);
		frame.getContentPane().add(campoNome);

		JLabel lblCpf = new JLabel("CPF *");
		lblCpf.setBounds(425, 76, 131, 56);
		lblCpf.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frame.getContentPane().add(lblCpf);

		JLabel lblNewLabel_1 = new JLabel("DEVOLUÇÃO");
		lblNewLabel_1.setBounds(493, 0, 441, 82);
		lblNewLabel_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 65));
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblCidade = new JLabel("Cidade ");
		lblCidade.setBounds(796, 76, 131, 41);
		lblCidade.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frame.getContentPane().add(lblCidade);

		JButton btnLocar = new JButton("REALIZAR DEVOLUCAO");
		btnLocar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int confirm = JOptionPane.showConfirmDialog(null, "Confirmar Devolucao ?");
				try {
					controller.ConcluirDevolucao(confirm);
				} catch (Excecao e1) {
					
				}
			}
		});
		btnLocar.setBounds(438, 687, 246, 48);
		btnLocar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frame.getContentPane().add(btnLocar);

		campoCidade = new JTextField();
		campoCidade.setBounds(796, 121, 333, 30);
		campoCidade.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCidade.setColumns(10);
		frame.getContentPane().add(campoCidade);

		campoCpf = new JTextField();

		campoCpf.setBounds(411, 121, 333, 30);
		campoCpf.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCpf.setColumns(10);
		frame.getContentPane().add(campoCpf);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewMenuPrincipal().chamarMenuPrincipal();
				MinimizarTelaDevolucao();
			}
		});
		btnVoltar.setBounds(1072, 719, 124, 23);
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		frame.getContentPane().add(btnVoltar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(0, 0, 1206, 767);
		lblNewLabel.setIcon(new ImageIcon(ViewTelaCadastroCliente.class
				.getResource("/imagens/—Pngtree—abstract system technology background_1228014.jpg")));
		frame.getContentPane().add(lblNewLabel);
	}

	public void chamarTelaDevolucao() {
		frame.setVisible(true);

	}

	public void MinimizarTelaDevolucao() {
		frame.dispose();

	}
}
