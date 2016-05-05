import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TesteExercicio51 {
	    static Scanner teclado = new Scanner (System.in);
	    static Font letra = new Font ("Serif",Font.BOLD,50);
		static JFrame Tela;
		static JPanel MenuTela;
		static JPanel Cadastro;
		static JPanel Atualizar;
		static JPanel Excluir;
		static JPanel Consultar;
		static JLabel Titulo;
		static JMenuBar BarraMenu;
		static JMenu menu = new JMenu("Menu");
		static JMenuItem informacao = new JMenuItem("Informações");
		static JMenuItem ajuda = new JMenuItem("Ajuda");
		static JButton Botao = new JButton("Cadastrar");
		static JButton Botao2 = new JButton("Atualizar");
		static JButton Botao3 = new JButton("Excluir");
		static JButton Botao4 = new JButton("Consultar");
		static JTextField Nome;

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
			Tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			MenuTela = new JPanel();
		    MenuTela.setSize(600,400);
		    MenuTela.setBackground(Color.WHITE);
			MenuTela.setLayout(null);
			MenuTela.setVisible(true);
			MenuTela.add(Botao);
			MenuTela.add(Botao2);
			MenuTela.add(Botao3);
			MenuTela.add(Botao4);
			Titulo = new JLabel("Sistema de gerneciamento de clientes");
			Titulo.setFont(letra);
			Titulo.setLocation(500, 500); 
			Titulo.setVisible(true);
			MenuTela.add(Titulo);
            Tela.add(MenuTela);
			
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
					MenuTela.setVisible(false);
					Cadastro();
					
					
				}
			});

			Botao2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MenuTela.setVisible(false);
					Atualizar();
				}
			});

			Botao3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MenuTela.setVisible(false);
					Excluir();
				}
			});
			Botao4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					MenuTela.setVisible(false);
					Consultar();
				}
			});
		}

		static void Cadastro() {
			Cadastro = new JPanel();
			Cadastro.setSize(600,400);
			Cadastro.setBackground(Color.WHITE);
			Cadastro.setLayout(null);
			Cadastro.setVisible(true);
			Nome = new JTextField(30);
			Cadastro.add(Nome);
			Nome.setLocation(50, 50);
			
		}
		
		static void Atualizar() {
			Atualizar = new JPanel();
			Atualizar.setSize(600,400);
			Atualizar.setBackground(Color.WHITE);
			Atualizar.setLayout(null);
			Atualizar.setVisible(true);
			}
		
		static void Excluir() {
			Excluir = new JPanel();
			Excluir.setSize(600,400);
			Excluir.setBackground(Color.WHITE);
			Excluir.setLayout(null);
			Excluir.setVisible(true);
			
		}
		static void Consultar() {
			Consultar = new JPanel();
			Consultar.setSize(600,400);
			Consultar.setBackground(Color.WHITE);
			Consultar.setLayout(null);
			Consultar.setVisible(true);
			
		}
		
	}


