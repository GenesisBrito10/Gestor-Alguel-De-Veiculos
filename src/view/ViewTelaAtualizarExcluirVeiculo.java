package view;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import Excecoes.Excecao;
import controle.VeiculoController;
import model.VeiculoModel;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ViewTelaAtualizarExcluirVeiculo {

	private JFrame frame;
	private JTextField campoMarca;
	private JTextField campoAno;
	private JTextField campoModelo;
	private JTextField campoPlaca;
	private JTextField campoRenavam;
	private JTextField campoDescricao;
	private JComboBox comboBoxEstado;
	private JComboBox comboBoxCor;
	private JTable tableModelo;
	private VeiculoController controller;
	private VeiculoModel model;

	public JTextField getCampoMarca() {
		return campoMarca;
	}

	public void setCampoMarca(JTextField campoMarca) {
		this.campoMarca = campoMarca;
	}

	public JTextField getCampoAno() {
		return campoAno;
	}

	public void setCampoAno(JTextField campoAno) {
		this.campoAno = campoAno;
	}

	public JTextField getCampoModelo() {
		return campoModelo;
	}

	public void setCampoModelo(JTextField campoModelo) {
		this.campoModelo = campoModelo;
	}

	public JTextField getCampoPlaca() {
		return campoPlaca;
	}

	public void setCampoPlaca(JTextField campoPlaca) {
		this.campoPlaca = campoPlaca;
	}

	public JTextField getCampoRenavam() {
		return campoRenavam;
	}

	public void setCampoRenavam(JTextField campoRenavam) {
		this.campoRenavam = campoRenavam;
	}

	public JTextField getCampoDescricao() {
		return campoDescricao;
	}

	public void setCampoDescricao(JTextField campoDescricao) {
		this.campoDescricao = campoDescricao;
	}

	public JComboBox getComboBoxEstado() {
		return comboBoxEstado;
	}

	public void setComboBoxEstado(JComboBox comboBoxEstado) {
		this.comboBoxEstado = comboBoxEstado;
	}

	public JComboBox getComboBoxCor() {
		return comboBoxCor;
	}

	public void setComboBoxCor(JComboBox comboBoxCor) {
		this.comboBoxCor = comboBoxCor;
	}

	public JTable getTableModelo() {
		return tableModelo;
	}

	public void setTableModelo(JTable tableModelo) {
		this.tableModelo = tableModelo;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTelaAtualizarExcluirVeiculo window = new ViewTelaAtualizarExcluirVeiculo();
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
	public ViewTelaAtualizarExcluirVeiculo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.controller = null;
		VeiculoController controller = new VeiculoController(this,model);

		frame = new JFrame();
		frame.setBounds(100, 100, 796, 663);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frame.getContentPane().setLayout(null);
		frame.setLocationRelativeTo(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(27, 149, 333, 77);
		scrollPane.setVisible(false);
		
		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.LimparCamposAlterarExcluirVeiculo();
			}
		});
		btnLimparCampos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimparCampos.setBounds(40, 515, 191, 48);
		frame.getContentPane().add(btnLimparCampos);
		
		JLabel lblNewLabel_2_1 = new JLabel("Renavam Não Pode ser Alterado");
		lblNewLabel_2_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2_1.setBounds(230, 49, 467, 30);
		frame.getContentPane().add(lblNewLabel_2_1);
		frame.getContentPane().add(scrollPane);

		tableModelo = new JTable();
		tableModelo.setBorder(null);
		tableModelo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				controller.SelecionarModeloAtualizarVeiculo(tableModelo, 0);
				scrollPane.setVisible(false);
			}
		});
		tableModelo.setModel(
				new DefaultTableModel(new Object[][] {}, new String[] { "", "", "", "", "", "", "", "", "", "" }) {
					boolean[] columnEditables = new boolean[] { false, true, true, true, true, true, true, true, true,
							true };

					public boolean isCellEditable(int row, int column) {
						return columnEditables[column];
					}
				});
		tableModelo.getColumnModel().getColumn(1).setPreferredWidth(15);
		tableModelo.getColumnModel().getColumn(1).setMinWidth(0);
		tableModelo.getColumnModel().getColumn(2).setPreferredWidth(15);
		tableModelo.getColumnModel().getColumn(2).setMinWidth(0);
		tableModelo.getColumnModel().getColumn(3).setPreferredWidth(15);
		tableModelo.getColumnModel().getColumn(3).setMinWidth(0);
		tableModelo.getColumnModel().getColumn(4).setPreferredWidth(15);
		tableModelo.getColumnModel().getColumn(5).setPreferredWidth(15);
		tableModelo.getColumnModel().getColumn(6).setPreferredWidth(15);
		tableModelo.getColumnModel().getColumn(7).setPreferredWidth(15);
		tableModelo.getColumnModel().getColumn(8).setPreferredWidth(15);
		tableModelo.getColumnModel().getColumn(8).setMinWidth(0);
		tableModelo.getColumnModel().getColumn(9).setPreferredWidth(15);
		tableModelo.setOpaque(false);
		tableModelo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tableModelo.setColumnSelectionAllowed(true);
		tableModelo.setBackground(Color.WHITE);
		scrollPane.setViewportView(tableModelo);

		JButton btnExcluirVeiculo = new JButton("Excluir");
		btnExcluirVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Confirmar Exclusao ?");
				try {
					controller.ExcluirVeiculo(confirm);
				} catch (Excecao e1) {
					
				}
			}
		});
		btnExcluirVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnExcluirVeiculo.setBounds(560, 515, 191, 48);
		frame.getContentPane().add(btnExcluirVeiculo);

		JLabel lblEstado = new JLabel("Estado *\r\n");
		lblEstado.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblEstado.setBounds(27, 321, 131, 56);
		frame.getContentPane().add(lblEstado);

		comboBoxEstado = new JComboBox();
		comboBoxEstado.setFont(new Font("Quicksand Light", Font.PLAIN, 15));
		comboBoxEstado.setBackground(Color.WHITE);
		comboBoxEstado.setBounds(27, 364, 333, 30);
		frame.getContentPane().add(comboBoxEstado);

		campoDescricao = new JTextField();
		campoDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoDescricao.setColumns(10);
		campoDescricao.setBounds(418, 347, 333, 100);
		frame.getContentPane().add(campoDescricao);

		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblDescrio.setBounds(418, 300, 131, 56);
		frame.getContentPane().add(lblDescrio);

		comboBoxCor = new JComboBox();
		comboBoxCor.setFont(new Font("Quicksand Light", Font.PLAIN, 15));
		comboBoxCor.setBackground(Color.WHITE);
		comboBoxCor.setBounds(27, 280, 333, 30);
		frame.getContentPane().add(comboBoxCor);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltar.setBounds(646, 590, 124, 23);
		frame.getContentPane().add(btnVoltar);

		JLabel lblNome = new JLabel("Marca");
		lblNome.setFont(new Font("Quicksand Light", Font.PLAIN, 25));
		lblNome.setBounds(418, 84, 131, 36);
		frame.getContentPane().add(lblNome);

		campoMarca = new JTextField();
		campoMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoMarca.setColumns(10);
		campoMarca.setBounds(418, 119, 333, 30);
		frame.getContentPane().add(campoMarca);

		JLabel lblCpf = new JLabel("Modelo");
		lblCpf.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblCpf.setBounds(27, 74, 131, 56);
		frame.getContentPane().add(lblCpf);

		JLabel lblNewLabel_1 = new JLabel("ALTERAR/EXCLUIR VEICULO");
		lblNewLabel_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 50));
		lblNewLabel_1.setBounds(164, -9, 631, 82);
		frame.getContentPane().add(lblNewLabel_1);

		JLabel lblRg = new JLabel("Ano");
		lblRg.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblRg.setBounds(27, 153, 131, 56);
		frame.getContentPane().add(lblRg);

		JLabel lblEndere = new JLabel("Placa");
		lblEndere.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblEndere.setBounds(418, 153, 131, 56);
		frame.getContentPane().add(lblEndere);

		JLabel lblBairro = new JLabel("Cor");
		lblBairro.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblBairro.setBounds(27, 237, 131, 56);
		frame.getContentPane().add(lblBairro);

		JLabel lblCidade = new JLabel("Renavam");
		lblCidade.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblCidade.setBounds(418, 233, 131, 56);
		frame.getContentPane().add(lblCidade);

		JButton btnAlterarVeiculo = new JButton("Alterar");
		btnAlterarVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnAlterarVeiculo.setBounds(298, 515, 191, 48);
		frame.getContentPane().add(btnAlterarVeiculo);

		campoAno = new JTextField();
		campoAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoAno.setColumns(10);
		campoAno.setBounds(27, 198, 333, 30);
		frame.getContentPane().add(campoAno);

		campoModelo = new JTextField();
		campoModelo.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					controller.ListarVeiculosPeloModeloAtualizarExcluir(tableModelo);
					scrollPane.setVisible(true);
				} catch (Excecao e1) {
				
				}
				

			}
		});
		campoModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoModelo.setColumns(10);
		campoModelo.setBounds(27, 119, 333, 30);
		frame.getContentPane().add(campoModelo);

		campoPlaca = new JTextField();
		campoPlaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoPlaca.setColumns(10);
		campoPlaca.setBounds(418, 198, 333, 30);
		frame.getContentPane().add(campoPlaca);

		campoRenavam = new JTextField();
		campoRenavam.setEditable(false);
		campoRenavam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoRenavam.setColumns(10);
		campoRenavam.setBounds(418, 280, 333, 30);
		frame.getContentPane().add(campoRenavam);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewTelaCadastroCliente.class
				.getResource("/imagens/—Pngtree—abstract system technology background_1228014.jpg")));
		lblNewLabel.setBounds(0, 0, 784, 624);
		frame.getContentPane().add(lblNewLabel);

//funcoes------------------------------------------------------------------------------------------------

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					new ViewTelaDeConsultaVeiculo().chamarTelaConsultaVeiculo();
					MinimizarTelaAlterarExcluirVeiculo();
				} catch (Excecao e1) {
					
				}
				
			}
		});

		btnAlterarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Confirmar os dados ?");
				try {
					controller.AtualizarVeiculo(confirm);
				} catch (Excecao e1) {
					
				}

			}
		});
	}

	public void chamarTelaAlterarExcluirVeiculo() {
		frame.setVisible(true);
	}

	public void MinimizarTelaAlterarExcluirVeiculo() {
		frame.dispose();
		;
	}

}
