import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.Scanner;

import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class TesteExercicio51 {
	        static Scanner teclado = new Scanner (System.in);
	        static Font letra = new Font ("Serif",Font.BOLD,20);
		static JFrame Tela;
		static JPanel MenuTela;
		static JLabel Fundo = new JLabel (new ImageIcon("Imagem\\Teste.png"));
		static JFrame Cadastro;
		static JFrame Atualizar;
		static JFrame Excluir;
		static JFrame Consultar;
		static JLabel Titulo;
		static JMenuBar BarraMenu;
		static JMenu menu = new JMenu("Menu");
		static JMenuItem informacao = new JMenuItem("Informações");
		static JMenuItem ajuda = new JMenuItem("Ajuda");
		static JButton Botao =  new JButton("Cadastrar");
		static JButton Botao2 = new JButton("Atualizar");
		static JButton Botao3 = new JButton("Excluir");
		static JButton Botao4 = new JButton("Consultar");
		static JButton Botao5 = new JButton("Salvar");
		static JButton Botao6 = new JButton ("Excluir");
		static ButtonGroup Organiza;
		static JTextField Nome;
		static JTextField CPF;
		static JTextField Email;
		static JTextField Telefone;
		static JTextField Endereco;
		String[] cadastro = new String [100];
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
			Tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			MenuTela = new JPanel();
		    MenuTela.setSize(600,400);
		    MenuTela.add(Fundo);
		    Fundo.setBounds(0,0,600,400);
		    MenuTela.setLayout(null);
			MenuTela.setVisible(true);
			MenuTela.add(Botao);
			MenuTela.add(Botao2);
			MenuTela.add(Botao3);
			MenuTela.add(Botao4);
			Titulo = new JLabel("Sistema de gerenciamento de clientes");
			Titulo.setFont(letra);
			Titulo.setHorizontalAlignment(SwingConstants.CENTER);
			Titulo.setVisible(true);
			Tela.add(MenuTela);
			MenuTela.add(Titulo);
            
			
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
					//MenuTela.setVisible(false);
					Cadastro();
					
					
				}
			});

			Botao2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//MenuTela.setVisible(false);
					Atualizar();
				}
			});

			Botao3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//MenuTela.setVisible(false);
					Excluir();
				}
			});
			Botao4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					//MenuTela.setVisible(false);
					Consultar();
				}
			});
			Botao5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							"Salvo com sucesso!");
				}
			});
			Botao6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							"Excluído com sucesso!");
				}
			});
		}

		static void Cadastro() {
			Cadastro = new JFrame();
			Cadastro.setTitle("Cadastrar novo cliente");
			Cadastro.setSize(600,400);
			Cadastro.setResizable(false);
			Cadastro.setJMenuBar(BarraMenu);
			Cadastro.setLocationRelativeTo(null);
	        Cadastro.setBackground(Color.BLUE);
			Cadastro.setLayout(new GridLayout (11,10));
			Cadastro.setVisible(true);
			JLabel nome = new JLabel ("Nome completo");
			Cadastro.add(nome);
			Nome = new JTextField(30);
			Cadastro.add(Nome);
			JLabel cpf = new JLabel ("CPF (Somente números)");
			Cadastro.add(cpf);
			CPF = new JTextField(30);
			Cadastro.add(CPF);
			JLabel email = new JLabel ("E-mail");
			Cadastro.add(email);
			Email = new JTextField(30);
			Cadastro.add(Email);
			JLabel telefone = new JLabel ("Telefone - Ex: (44)12345678");
			Cadastro.add(telefone);
			Telefone = new JTextField(30);
			Cadastro.add(Telefone);
			JLabel endereco = new JLabel ("Endereço");
			Cadastro.add(endereco);
			Endereco = new JTextField(30);
			Cadastro.add(Endereco);
			Cadastro.add (Botao5);
		}
		
		static void Atualizar() {
			Atualizar = new JFrame();
			Atualizar.setTitle("Atualizar Cadastro");
			Atualizar.setSize(600,400);
			Atualizar.setResizable(false);
			Atualizar.setJMenuBar(BarraMenu);
			Atualizar.setLocationRelativeTo(null);
			Atualizar.setBackground(Color.BLUE);
			Atualizar.setLayout(new GridLayout(10,10));
			Atualizar.setVisible(true);
			JLabel pergunta = new JLabel ("O que você deseja atualizar?");
			pergunta.setHorizontalAlignment(SwingConstants.CENTER);
			Atualizar.add(pergunta);
			JRadioButton opcao = new JRadioButton("Nome");
			JRadioButton opcao1 = new JRadioButton("CPF");
			JRadioButton opcao2 = new JRadioButton("Email");
			JRadioButton opcao3 = new JRadioButton("Telefone");
			JRadioButton opcao4 = new JRadioButton("Endereço");
			Atualizar.add(opcao);
			Atualizar.add(opcao1);
			Atualizar.add(opcao2);
			Atualizar.add(opcao3);
			Atualizar.add(opcao4);
			Organiza = new ButtonGroup();
			Organiza.add(opcao);
			Organiza.add(opcao1);
			Organiza.add(opcao2);
			Organiza.add(opcao3);
			Organiza.add(opcao4);
			JButton avancar = new JButton ("Avançar");
	        Atualizar.add(avancar);
			}
		
		static void Excluir() {
			Excluir = new JFrame();
			Excluir.setTitle("Excluir Cadastro");
			Excluir.setSize(600,400);
			Excluir.setResizable(false);
			Excluir.setJMenuBar(BarraMenu);
			Excluir.setLocationRelativeTo(null);
			Excluir.setBackground(Color.BLUE);
			Excluir.setLayout(new GridLayout (11,10));
			Excluir.setVisible(true);
			JLabel nome = new JLabel ("Nome completo");
			Excluir.add(nome);
			Nome = new JTextField(30);
			Excluir.add(Nome);
			JLabel cpf = new JLabel ("CPF (Somente números)");
			Excluir.add(cpf);
			CPF = new JTextField(30);
			Excluir.add(CPF);
			JLabel email = new JLabel ("E-mail");
			Excluir.add(email);
			Email = new JTextField(30);
			Excluir.add(Email);
			JLabel telefone = new JLabel ("Telefone - Ex: (44)12345678");
			Excluir.add(telefone);
			Telefone = new JTextField(30);
			Excluir.add(Telefone);
			JLabel endereco = new JLabel ("Endereço");
			Excluir.add(endereco);
			Endereco = new JTextField(30);
			Excluir.add(Endereco);
			Excluir.add(Botao6);
			}
		static void Consultar() {
			Consultar = new JFrame();
			Consultar.setTitle("Consultar Cadastro");
			Consultar.setSize(600,400);
			Consultar.setResizable(false);
			Consultar.setJMenuBar(BarraMenu);
			Consultar.setLocationRelativeTo(null);
			Consultar.setBackground(Color.BLUE);
			Consultar.setLayout(new GridLayout (11,10));
			Consultar.setVisible(true);
			JLabel nome = new JLabel ("Nome completo");
			Consultar.add(nome);
			Nome = new JTextField(30);
			Consultar.add(Nome);
			JLabel cpf = new JLabel ("CPF (Somente números)");
			Consultar.add(cpf);
			CPF = new JTextField(30);
			Consultar.add(CPF);
			JLabel email = new JLabel ("E-mail");
			Consultar.add(email);
			Email = new JTextField(30);
			Consultar.add(Email);
			JLabel telefone = new JLabel ("Telefone - Ex: (44)12345678");
			Consultar.add(telefone);
			Telefone = new JTextField(30);
			Consultar.add(Telefone);
			JLabel endereco = new JLabel ("Endereço");
			Consultar.add(endereco);
			Endereco = new JTextField(30);
			Consultar.add(Endereco);
			JButton consultar = new JButton ("Consultar");
	        Consultar.add(consultar);
		}
	}


