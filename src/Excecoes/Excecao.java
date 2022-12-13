package Excecoes;

import javax.swing.JOptionPane;

public class Excecao extends Exception {

	public Excecao(String msg) {
		JOptionPane.showMessageDialog(null, msg);
		
	}

}
