package view;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;

import Excecoes.Excecao;
import controle.ClienteController;
import controle.LoginController;
import model.ClienteModel;

import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ViewTelaCadastroCliente {

	private JFrame frameCadastroCliente;
	private JTextField campoNomeCadastroCliente;
	private JTextField campoRgCadastroCliente;
	private JTextField campoCpfCadastroCliente;
	private JTextField campoEnderecoCadastroCliente;
	private JTextField campoCidadeCadastroCliente;
	private ClienteController controller;
	private ClienteModel model;

	public JTextField getCampoNomeCadastroCliente() {
		return campoNomeCadastroCliente;
	}

	public void setCampoNomeCadastroCliente(JTextField campoNomeCadastroCliente) {
		this.campoNomeCadastroCliente = campoNomeCadastroCliente;
	}

	public JTextField getCampoRgCadastroCliente() {
		return campoRgCadastroCliente;
	}

	public void setCampoRgCadastroCliente(JTextField campoRgCadastroCliente) {
		this.campoRgCadastroCliente = campoRgCadastroCliente;
	}

	public JTextField getCampoCpfCadastroCliente() {
		return campoCpfCadastroCliente;
	}

	public void setCampoCpfCadastroCliente(JTextField campoCpfCadastroCliente) {
		this.campoCpfCadastroCliente = campoCpfCadastroCliente;
	}

	public JTextField getCampoEnderecoCadastroCliente() {
		return campoEnderecoCadastroCliente;
	}

	public void setCampoEnderecoCadastroCliente(JTextField campoEnderecoCadastroCliente) {
		this.campoEnderecoCadastroCliente = campoEnderecoCadastroCliente;
	}

	public JTextField getCampoCidadeCadastroCliente() {
		return campoCidadeCadastroCliente;
	}

	public void setCampoCidadeCadastroCliente(JTextField campoCidadeCadastroCliente) {
		this.campoCidadeCadastroCliente = campoCidadeCadastroCliente;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {

					ViewTelaCadastroCliente window = new ViewTelaCadastroCliente();
					window.frameCadastroCliente.setVisible(true);
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
	 */
	public ViewTelaCadastroCliente() throws Excecao {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * 
	 * @throws Excecao
	 */
	private void initialize() throws Excecao {
		this.controller = null;
		this.model = null;
		ClienteController controller = new ClienteController(this, model);

		frameCadastroCliente = new JFrame();
		frameCadastroCliente.setBounds(100, 100, 800, 600);
		frameCadastroCliente.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCadastroCliente.getContentPane().setLayout(null);
		frameCadastroCliente.setLocationRelativeTo(null);

		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.LimparCamposCadastroCliente();
			}
		});
		btnLimparCampos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimparCampos.setBounds(462, 453, 201, 48);
		frameCadastroCliente.getContentPane().add(btnLimparCampos);

		JLabel lblNewLabel_2 = new JLabel("Campos com \"*\" \r\nsão obrigatórios");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(10, 350, 387, 30);
		frameCadastroCliente.getContentPane().add(lblNewLabel_2);

		JLabel lblNome = new JLabel("Nome *");
		lblNome.setBounds(20, 86, 131, 36);
		lblNome.setFont(new Font("Quicksand Light", Font.PLAIN, 25));
		frameCadastroCliente.getContentPane().add(lblNome);

		campoNomeCadastroCliente = new JTextField();
		campoNomeCadastroCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarCliente();
			}
		});
		campoNomeCadastroCliente.setBounds(20, 121, 333, 30);
		campoNomeCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoNomeCadastroCliente.setColumns(10);
		frameCadastroCliente.getContentPane().add(campoNomeCadastroCliente);

		JLabel lblCpf = new JLabel("CPF *");
		lblCpf.setBounds(425, 76, 131, 56);
		lblCpf.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frameCadastroCliente.getContentPane().add(lblCpf);

		JLabel lblNewLabel_1 = new JLabel("CADASTRO CLIENTE");
		lblNewLabel_1.setBounds(179, 0, 441, 82);
		lblNewLabel_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 65));
		frameCadastroCliente.getContentPane().add(lblNewLabel_1);

		JLabel lblRg = new JLabel("RG *");
		lblRg.setBounds(20, 155, 131, 56);
		lblRg.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frameCadastroCliente.getContentPane().add(lblRg);

		JLabel lblEndere = new JLabel("Endereço *");
		lblEndere.setBounds(425, 151, 131, 56);
		lblEndere.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frameCadastroCliente.getContentPane().add(lblEndere);

		JLabel lblCidade = new JLabel("Cidade *");
		lblCidade.setBounds(20, 241, 131, 56);
		lblCidade.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frameCadastroCliente.getContentPane().add(lblCidade);

		JButton btnCadastrarCliente = new JButton("Cadastrar");
		btnCadastrarCliente.setBounds(114, 453, 191, 48);
		btnCadastrarCliente.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frameCadastroCliente.getContentPane().add(btnCadastrarCliente);

		campoRgCadastroCliente = new JTextField();
		campoRgCadastroCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarCliente();
			}
		});
		campoRgCadastroCliente.setBounds(20, 200, 333, 30);
		campoRgCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoRgCadastroCliente.setColumns(10);
		frameCadastroCliente.getContentPane().add(campoRgCadastroCliente);

		campoCpfCadastroCliente = new JTextField();
		campoCpfCadastroCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarCliente();
			}
		});
		campoCpfCadastroCliente.setBounds(411, 121, 333, 30);
		campoCpfCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCpfCadastroCliente.setColumns(10);
		frameCadastroCliente.getContentPane().add(campoCpfCadastroCliente);

		campoEnderecoCadastroCliente = new JTextField();
		campoEnderecoCadastroCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarCliente();
			}
		});
		campoEnderecoCadastroCliente.setBounds(411, 200, 333, 30);
		campoEnderecoCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoEnderecoCadastroCliente.setColumns(10);
		frameCadastroCliente.getContentPane().add(campoEnderecoCadastroCliente);

		campoCidadeCadastroCliente = new JTextField();
		campoCidadeCadastroCliente.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarCliente();
			}
		});

		campoCidadeCadastroCliente.setBounds(20, 288, 333, 30);
		campoCidadeCadastroCliente.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCidadeCadastroCliente.setColumns(10);
		frameCadastroCliente.getContentPane().add(campoCidadeCadastroCliente);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltar.setBounds(650, 527, 124, 23);
		frameCadastroCliente.getContentPane().add(btnVoltar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewTelaCadastroCliente.class
				.getResource("/imagens/—Pngtree—abstract system technology background_1228014.jpg")));
		lblNewLabel.setBounds(0, 0, 784, 561);
		frameCadastroCliente.getContentPane().add(lblNewLabel);

		controller.DeserializarCliente();

		controller.RecuperarDadosCadastro();

		// Funcoes

		btnCadastrarCliente.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int confirm = JOptionPane.showConfirmDialog(null, "Confirmar Dados ?");
				try {
					controller.CadastrarCliente(confirm);
				} catch (Excecao e1) {

				}

			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewMenuDeCadastros().chamarMenuDeCadastros();
				frameCadastroCliente.dispose();
			}
		});

	}

	public void chamarTelaCadastroCliente() {
		frameCadastroCliente.setVisible(true);

	}

	public void MinimizarTelaCadastroCliente() {
		frameCadastroCliente.dispose();

	}

}
