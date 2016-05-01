import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;


public class Exercicio51 {
    static Font letra = new Font ("Serif",Font.BOLD,50);
	static JFrame Tela;
	static JLabel capa = new JLabel("Sistema de gerneciamento de clientes");
	static JMenuBar BarraMenu;
	static JMenu menu = new JMenu("Menu");
	static JMenuItem informacao = new JMenuItem("Informações");
	static JMenuItem ajuda = new JMenuItem("Ajuda");
	static JButton Botao = new JButton("Cadastrar");
	static JButton Botao2 = new JButton("Atualizar");
	static JButton Botao3 = new JButton("Excluir");
	static JButton Botao4 = new JButton("Consultar");

	public static void main(String[] args) {
		Tela = new JFrame();
		BarraMenu = new JMenuBar();
		Tela();
		Menu();
		botao();
	}

	static void Tela() {

		Tela.setTitle("Cadastro de clientes");
		Tela.setSize(600, 400);
		Tela.setLocationRelativeTo(null);
		Tela.setResizable(false);
		Tela.setVisible(true);
		Tela.setLayout(null);
		Tela.add(Botao);
		Tela.add(Botao2);
		Tela.add(Botao3);
		Tela.add(Botao4);
		Tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Tela.getContentPane().setBackground(Color.blue);
		Tela.add(capa);
		capa.setLocation(500,500);
		capa.setFont(letra);
		capa.setVisible(true);
	}

	static void Menu() {

		Tela.setJMenuBar(BarraMenu);
		BarraMenu.add(menu);
		menu.add(informacao);
		menu.add(ajuda);
		informacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Desenvolvido por Guilherme Maeda");
			}
		});
		ajuda.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						"Sistema de cadastro, atualização, exclusão e consulta de clientes");
			}
		});
	}

	static void botao() {
		Botao.setBounds(0, 0, 150, 50);
		Botao2.setBounds(150, 0, 150, 50);
		Botao3.setBounds(300, 0, 150, 50);
		Botao4.setBounds(450, 0, 150, 50);

		Botao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Cadastrar novo cliente");
			}
		});

		Botao2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Atualizar cadastro");
			}
		});

		Botao3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Excluir cadastro");
			}
		});
		Botao4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null, "Consultar cadastro");
			}
		});
	}
}
