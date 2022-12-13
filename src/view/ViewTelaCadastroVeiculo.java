package view;

import java.awt.EventQueue;

import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import Excecoes.Excecao;
import controle.VeiculoController;
import model.VeiculoModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ViewTelaCadastroVeiculo {

	private JFrame frameCadastroVeiculo;

	private JTextField campoMarca;
	private JTextField campoAno;
	private JTextField campoModelo;
	private JTextField campoPlaca;
	private JTextField campoRenavam;
	private JTextField campoDescricao;
	private JComboBox comboBoxStatus;
	private JComboBox comboBoxEstado;
	private JComboBox comboBoxCor;
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

	public JComboBox getComboBoxCor() {
		return comboBoxCor;
	}

	public void setComboBoxCor(JComboBox comboBoxCor) {
		this.comboBoxCor = comboBoxCor;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTelaCadastroVeiculo window = new ViewTelaCadastroVeiculo();
					window.frameCadastroVeiculo.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public ViewTelaCadastroVeiculo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		this.controller = null;
		
		VeiculoController controller = new VeiculoController(this,model);

		frameCadastroVeiculo = new JFrame();
		frameCadastroVeiculo.setBounds(100, 100, 800, 600);
		frameCadastroVeiculo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		frameCadastroVeiculo.getContentPane().setLayout(null);
		frameCadastroVeiculo.setLocationRelativeTo(null);
		
		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.LimparCamposCadastroVeiculo();
			}
		});
		btnLimparCampos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimparCampos.setBounds(124, 499, 191, 48);
		frameCadastroVeiculo.getContentPane().add(btnLimparCampos);

		JLabel lblEstado = new JLabel("Estado *\r\n");
		lblEstado.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblEstado.setBounds(27, 383, 131, 56);
		frameCadastroVeiculo.getContentPane().add(lblEstado);

		comboBoxEstado = new JComboBox();
		comboBoxEstado.setModel(new DefaultComboBoxModel(new String[] {"NOVO", "SEMINOVO"}));
		comboBoxEstado.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarVeiculo();
			}
		});
		comboBoxEstado.setFont(new Font("Quicksand Light", Font.PLAIN, 15));
		comboBoxEstado.setBackground(Color.WHITE);
		comboBoxEstado.setBounds(27, 426, 333, 30);
		frameCadastroVeiculo.getContentPane().add(comboBoxEstado);

		campoDescricao = new JTextField();
		campoDescricao.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarVeiculo();
			}
		});
		campoDescricao.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoDescricao.setColumns(10);
		campoDescricao.setBounds(418, 347, 333, 100);
		frameCadastroVeiculo.getContentPane().add(campoDescricao);

		JLabel lblDescrio = new JLabel("Descrição");
		lblDescrio.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblDescrio.setBounds(432, 300, 131, 56);
		frameCadastroVeiculo.getContentPane().add(lblDescrio);

		comboBoxStatus = new JComboBox();
		comboBoxStatus.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarVeiculo();
			}
		});
		comboBoxStatus.setModel(new DefaultComboBoxModel(new String[] { "DISPONIVEL", "ALUGADO" }));
		comboBoxStatus.setFont(new Font("Quicksand Light", Font.PLAIN, 15));
		comboBoxStatus.setBackground(Color.WHITE);
		comboBoxStatus.setBounds(27, 347, 333, 30);
		frameCadastroVeiculo.getContentPane().add(comboBoxStatus);

		JLabel lblStatus = new JLabel("Status *\r\n");
		lblStatus.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblStatus.setBounds(27, 304, 131, 56);
		frameCadastroVeiculo.getContentPane().add(lblStatus);

		comboBoxCor = new JComboBox();
		comboBoxCor.setModel(new DefaultComboBoxModel(new String[] {"PRETO", "BRANCO", "CINZA", "VERMELHO"}));
		comboBoxCor.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarVeiculo();
			}
		});
		comboBoxCor.setFont(new Font("Quicksand Light", Font.PLAIN, 15));
		comboBoxCor.setBackground(Color.WHITE);
		comboBoxCor.setBounds(27, 280, 333, 30);
		frameCadastroVeiculo.getContentPane().add(comboBoxCor);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltar.setBounds(650, 514, 124, 23);
		frameCadastroVeiculo.getContentPane().add(btnVoltar);

		JLabel lblNome = new JLabel("Marca");
		lblNome.setFont(new Font("Quicksand Light", Font.PLAIN, 25));
		lblNome.setBounds(27, 84, 131, 36);
		frameCadastroVeiculo.getContentPane().add(lblNome);

		campoMarca = new JTextField();
		campoMarca.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarVeiculo();
			}
		});
		campoMarca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoMarca.setColumns(10);
		campoMarca.setBounds(27, 119, 333, 30);
		frameCadastroVeiculo.getContentPane().add(campoMarca);

		JLabel lblCpf = new JLabel("Modelo");
		lblCpf.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblCpf.setBounds(432, 74, 131, 56);
		frameCadastroVeiculo.getContentPane().add(lblCpf);

		JLabel lblNewLabel_1 = new JLabel("CADASTRO VEICULO");
		lblNewLabel_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 65));
		lblNewLabel_1.setBounds(179, 0, 441, 82);
		frameCadastroVeiculo.getContentPane().add(lblNewLabel_1);

		JLabel lblRg = new JLabel("Ano");
		lblRg.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblRg.setBounds(27, 153, 131, 56);
		frameCadastroVeiculo.getContentPane().add(lblRg);

		JLabel lblEndere = new JLabel("Placa");
		lblEndere.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblEndere.setBounds(432, 149, 131, 56);
		frameCadastroVeiculo.getContentPane().add(lblEndere);

		JLabel lblBairro = new JLabel("Cor");
		lblBairro.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblBairro.setBounds(27, 237, 131, 56);
		frameCadastroVeiculo.getContentPane().add(lblBairro);

		JLabel lblCidade = new JLabel("Renavam");
		lblCidade.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblCidade.setBounds(432, 233, 131, 56);
		frameCadastroVeiculo.getContentPane().add(lblCidade);

		JButton btnCadastrarVeiculo = new JButton("Cadastrar");
		btnCadastrarVeiculo.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnCadastrarVeiculo.setBounds(409, 499, 191, 48);
		frameCadastroVeiculo.getContentPane().add(btnCadastrarVeiculo);

		campoAno = new JTextField();
		campoAno.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarVeiculo();
			}
		});
		campoAno.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoAno.setColumns(10);
		campoAno.setBounds(27, 198, 333, 30);
		frameCadastroVeiculo.getContentPane().add(campoAno);

		campoModelo = new JTextField();
		campoModelo.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarVeiculo();
			}
		});
		campoModelo.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoModelo.setColumns(10);
		campoModelo.setBounds(418, 119, 333, 30);
		frameCadastroVeiculo.getContentPane().add(campoModelo);

		campoPlaca = new JTextField();
		campoPlaca.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarVeiculo();
			}
		});
		campoPlaca.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoPlaca.setColumns(10);
		campoPlaca.setBounds(418, 198, 333, 30);
		frameCadastroVeiculo.getContentPane().add(campoPlaca);

		campoRenavam = new JTextField();
		campoRenavam.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarVeiculo();
			}
		});
		campoRenavam.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoRenavam.setColumns(10);
		campoRenavam.setBounds(418, 280, 333, 30);
		frameCadastroVeiculo.getContentPane().add(campoRenavam);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewTelaCadastroCliente.class
				.getResource("/imagens/—Pngtree—abstract system technology background_1228014.jpg")));
		lblNewLabel.setBounds(0, 0, 784, 561);
		frameCadastroVeiculo.getContentPane().add(lblNewLabel);
		
		controller.DeserializarVeiculo();
		controller.RecuperarDadosCadastroVeiculo();
//funcoes------------------------------------------------------------------------------------------------

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				new ViewMenuDeCadastros().chamarMenuDeCadastros();
				frameCadastroVeiculo.dispose();
			}
		});

		btnCadastrarVeiculo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Confirmar Locacao ?");
				try {
					controller.CadastrarVeiculo(confirm);
				} catch (Excecao e1) {
				
				}

			}
		});
	}

	public void chamarTelaCadastratoVeiculo() {
		frameCadastroVeiculo.setVisible(true);
	}

	public void MinimizarTelaCadastratoVeiculo() {
		frameCadastroVeiculo.dispose();
		;
	}

}
