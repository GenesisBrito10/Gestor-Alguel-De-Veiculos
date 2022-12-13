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
import controle.ColaboradorController;

import model.ColaboradorModel;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class ViewTelaCadastroColaborador {

	private JFrame frameCadastroFuncionario;
	private JTextField campoNomeCadastroFuncionario;
	private JTextField campoRgCadastroFuncionario;
	private JTextField campoCpfCadastroFuncionario;
	private JTextField campoEnderecoCadastroFuncionario;
	private JTextField campoCidadeCadastroFuncionario;
	private JTextField campoLoginCadFuncionario;
	private JTextField campoSenhaCadFuncionario;
	private ColaboradorController controller;
	private ColaboradorModel model;

	public JTextField getCampoNomeCadastroFuncionario() {
		return campoNomeCadastroFuncionario;
	}

	public void setCampoNomeCadastroFuncionario(JTextField campoNomeCadastroFuncionario) {
		this.campoNomeCadastroFuncionario = campoNomeCadastroFuncionario;
	}

	public JTextField getCampoRgCadastroFuncionario() {
		return campoRgCadastroFuncionario;
	}

	public void setCampoRgCadastroFuncionario(JTextField campoRgCadastroFuncionario) {
		this.campoRgCadastroFuncionario = campoRgCadastroFuncionario;
	}

	public JTextField getCampoCpfCadastroFuncionario() {
		return campoCpfCadastroFuncionario;
	}

	public void setCampoCpfCadastroFuncionario(JTextField campoCpfCadastroFuncionario) {
		this.campoCpfCadastroFuncionario = campoCpfCadastroFuncionario;
	}

	public JTextField getCampoEnderecoCadastroFuncionario() {
		return campoEnderecoCadastroFuncionario;
	}

	public void setCampoEnderecoCadastroFuncionario(JTextField campoEnderecoCadastroFuncionario) {
		this.campoEnderecoCadastroFuncionario = campoEnderecoCadastroFuncionario;
	}

	public JTextField getCampoCidadeCadastroFuncionario() {
		return campoCidadeCadastroFuncionario;
	}

	public void setCampoCidadeCadastroFuncionario(JTextField campoCidadeCadastroFuncionario) {
		this.campoCidadeCadastroFuncionario = campoCidadeCadastroFuncionario;
	}

	public JTextField getCampoLoginCadFuncionario() {
		return campoLoginCadFuncionario;
	}

	public void setCampoLoginCadFuncionario(JTextField campoLoginCadFuncionario) {
		this.campoLoginCadFuncionario = campoLoginCadFuncionario;
	}

	public JTextField getCampoSenhaCadFuncionario() {
		return campoSenhaCadFuncionario;
	}

	public void setCampoSenhaCadFuncionario(JTextField campoSenhaCadFuncionario) {
		this.campoSenhaCadFuncionario = campoSenhaCadFuncionario;
	}

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewTelaCadastroColaborador window = new ViewTelaCadastroColaborador();
					window.frameCadastroFuncionario.setVisible(true);
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
	public ViewTelaCadastroColaborador() throws Excecao {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 * @throws Excecao 
	 */
	private void initialize() throws Excecao {
		this.controller = null;
		ColaboradorController controller = new ColaboradorController(this, model);

		frameCadastroFuncionario = new JFrame();
		frameCadastroFuncionario.setBounds(100, 100, 800, 600);
		frameCadastroFuncionario.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frameCadastroFuncionario.getContentPane().setLayout(null);
		frameCadastroFuncionario.setLocationRelativeTo(null);

		campoSenhaCadFuncionario = new JTextField();
		campoSenhaCadFuncionario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarColaborador();
			}
		});
		
		JButton btnLimparCampos = new JButton("Limpar Campos");
		btnLimparCampos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				controller.LimparCamposCadastroColaborador();
			}
		});
		btnLimparCampos.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnLimparCampos.setBounds(133, 487, 191, 48);
		frameCadastroFuncionario.getContentPane().add(btnLimparCampos);
		campoSenhaCadFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoSenhaCadFuncionario.setColumns(10);
		campoSenhaCadFuncionario.setBounds(411, 413, 333, 30);
		frameCadastroFuncionario.getContentPane().add(campoSenhaCadFuncionario);

		JLabel lblLogin_1 = new JLabel("Senha *");
		lblLogin_1.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblLogin_1.setBounds(411, 369, 131, 56);
		frameCadastroFuncionario.getContentPane().add(lblLogin_1);

		JLabel lblLogin = new JLabel("Login *");
		lblLogin.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		lblLogin.setBounds(20, 369, 131, 56);
		frameCadastroFuncionario.getContentPane().add(lblLogin);

		campoLoginCadFuncionario = new JTextField();
		campoLoginCadFuncionario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarColaborador();
			}
		});
		campoLoginCadFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoLoginCadFuncionario.setColumns(10);
		campoLoginCadFuncionario.setBounds(20, 413, 333, 30);
		frameCadastroFuncionario.getContentPane().add(campoLoginCadFuncionario);

		JLabel lblNome = new JLabel("Nome *");
		lblNome.setBounds(20, 86, 131, 36);
		lblNome.setFont(new Font("Quicksand Light", Font.PLAIN, 25));
		frameCadastroFuncionario.getContentPane().add(lblNome);

		campoNomeCadastroFuncionario = new JTextField();
		campoNomeCadastroFuncionario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarColaborador();
			}
		});
		campoNomeCadastroFuncionario.setBounds(20, 121, 333, 30);
		campoNomeCadastroFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoNomeCadastroFuncionario.setColumns(10);
		frameCadastroFuncionario.getContentPane().add(campoNomeCadastroFuncionario);

		JLabel lblCpf = new JLabel("CPF *");
		lblCpf.setBounds(425, 76, 131, 56);
		lblCpf.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frameCadastroFuncionario.getContentPane().add(lblCpf);

		JLabel lblNewLabel_1 = new JLabel("CADASTRO COLABORADOR");
		lblNewLabel_1.setBounds(111, 0, 586, 82);
		lblNewLabel_1.setFont(new Font("Teko SemiBold", Font.PLAIN, 65));
		frameCadastroFuncionario.getContentPane().add(lblNewLabel_1);

		JLabel lblRg = new JLabel("RG *");
		lblRg.setBounds(20, 155, 131, 56);
		lblRg.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frameCadastroFuncionario.getContentPane().add(lblRg);

		JLabel lblEndere = new JLabel("Endereço *");
		lblEndere.setBounds(425, 151, 131, 56);
		lblEndere.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frameCadastroFuncionario.getContentPane().add(lblEndere);

		JLabel lblCidade = new JLabel("Cidade *");
		lblCidade.setBounds(20, 222, 131, 56);
		lblCidade.setFont(new Font("Quicksand Light", Font.PLAIN, 24));
		frameCadastroFuncionario.getContentPane().add(lblCidade);

		JButton btnCadastrarFuncionario = new JButton("Cadastrar");
		btnCadastrarFuncionario.setBounds(411, 487, 191, 48);
		btnCadastrarFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		frameCadastroFuncionario.getContentPane().add(btnCadastrarFuncionario);

		campoRgCadastroFuncionario = new JTextField();
		campoRgCadastroFuncionario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarColaborador();
			}
		});
		campoRgCadastroFuncionario.setBounds(20, 200, 333, 30);
		campoRgCadastroFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoRgCadastroFuncionario.setColumns(10);
		frameCadastroFuncionario.getContentPane().add(campoRgCadastroFuncionario);

		campoCpfCadastroFuncionario = new JTextField();
		campoCpfCadastroFuncionario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarColaborador();
			}
		});
		campoCpfCadastroFuncionario.setBounds(411, 121, 333, 30);
		campoCpfCadastroFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCpfCadastroFuncionario.setColumns(10);
		frameCadastroFuncionario.getContentPane().add(campoCpfCadastroFuncionario);

		campoEnderecoCadastroFuncionario = new JTextField();
		campoEnderecoCadastroFuncionario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarColaborador();
			}
		});
		campoEnderecoCadastroFuncionario.setBounds(411, 200, 333, 30);
		campoEnderecoCadastroFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoEnderecoCadastroFuncionario.setColumns(10);
		frameCadastroFuncionario.getContentPane().add(campoEnderecoCadastroFuncionario);

		campoCidadeCadastroFuncionario = new JTextField();
		campoCidadeCadastroFuncionario.addFocusListener(new FocusAdapter() {
			@Override
			public void focusLost(FocusEvent e) {
				controller.SerializarColaborador();
			}
		});
		campoCidadeCadastroFuncionario.setBounds(20, 269, 333, 30);
		campoCidadeCadastroFuncionario.setFont(new Font("Tahoma", Font.PLAIN, 14));
		campoCidadeCadastroFuncionario.setColumns(10);
		frameCadastroFuncionario.getContentPane().add(campoCidadeCadastroFuncionario);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnVoltar.setBounds(650, 512, 124, 23);
		frameCadastroFuncionario.getContentPane().add(btnVoltar);

		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(ViewTelaCadastroCliente.class
				.getResource("/imagens/—Pngtree—abstract system technology background_1228014.jpg")));
		lblNewLabel.setBounds(0, 0, 784, 561);
		frameCadastroFuncionario.getContentPane().add(lblNewLabel);
		
		controller.DeserializarColaborador();
		controller.RecuperarDadosCadastroColaborador();

//FUNÇÕES---------------------------------------------------------------------------------		
		btnCadastrarFuncionario.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int confirm = JOptionPane.showConfirmDialog(null, "Confirmar Dados ?");

				try {
					controller.CadastrarColaborador(confirm);
				} catch (Excecao e1) {
					
				}

			}
		});

		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new ViewMenuDeCadastros().chamarMenuDeCadastros();
				frameCadastroFuncionario.dispose();

			}
		});

	}

	public void chamarTelaCadastroColaborador() {
		frameCadastroFuncionario.setVisible(true);
	}

	public void MinimizarTelaCadastroColaborador() {
		frameCadastroFuncionario.dispose();
	}

}
