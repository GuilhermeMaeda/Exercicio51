import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Scanner;

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
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
public class TesteExercicio51 {
	    static Scanner teclado = new Scanner (System.in);
	    static Font letra = new Font ("Serif",Font.BOLD,20);
		
	    static JFrame tela;
		static JFrame cadastro;
		static JFrame telefone;
		static JFrame atualizar;
		static JFrame atNome;
		static JFrame atCPF;
		static JFrame atEmail;
		static JFrame atEndereco;
		static JFrame atTelefone;
		static JFrame excluir;
		static JFrame consultar;
		static JFrame consulta;
		
		static JPanel menuTela;
		
		static JLabel fundo = new JLabel (new ImageIcon("Imagem\\Teste.png"));
		static JLabel titulo;
		
		static JMenuBar barraMenu;
		static JMenu menu = new JMenu("Menu");
		static JMenuItem informacao = new JMenuItem("Informações");
		static JMenuItem ajuda = new JMenuItem("Ajuda");
		
		static JButton botao =  new JButton("Cadastrar");
		static JButton botao2 = new JButton("Atualizar");
		static JButton botao3 = new JButton("Excluir");
		static JButton botao4 = new JButton("Consultar");
		static JButton botao5 = new JButton("Salvar");
		static JButton botao6 = new JButton ("Excluir");
		static JButton avancar = new JButton ("Avançar");
		
		static JRadioButton opcao = new JRadioButton("Nome", false);
		static JRadioButton opcao1 = new JRadioButton("CPF",false);
		static JRadioButton opcao2 = new JRadioButton("Email",false);
		static JRadioButton opcao3 = new JRadioButton("Telefone",false);
		static JRadioButton opcao4 = new JRadioButton("Endereço",false);
		
        static ButtonGroup organiza;
		
		static JTextField Nome; 
		static JTextField CPF;
		static JTextField identifica;
		static JTextField Email; 
		static JTextField Fone;
		static JTextField Fone1; 
		static JTextField Fone2; 
        static JTextField Endereco;
		static JTextField antigoNome;
		static JTextField antigoCPF;
		static JTextField novoNome;
		static JTextField novoCPF;
		static JTextField antigoEmail;
		static JTextField novoEmail;
		static JTextField antigoEndereco;
		static JTextField novoEndereco;
		
		static JTable cadastrar = new JTable();
		
		static int identificacao = 1;
		static int info = 0;
		static int total = 0;
		static String[][] sistema = new String [100] [5];
		
		
		public static void main(String[] args) {
			tela = new JFrame();
			barraMenu = new JMenuBar();
			tela();
			menu();
			botao();
		}

		static void tela() {

			tela.setTitle("Cadastro de clientes");
			tela.setSize(600, 400);
			tela.setLocationRelativeTo(null);
			tela.setResizable(false);
			tela.setVisible(true);
			tela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			
			menuTela = new JPanel();
		    menuTela.setSize(600,400);
		    menuTela.add(fundo);
		    fundo.setBounds(0,0,600,400);
		    menuTela.setLayout(null);
			menuTela.setVisible(true);
			menuTela.add(botao);
			menuTela.add(botao2);
			menuTela.add(botao3);
			menuTela.add(botao4);
			tela.add(menuTela);
		} 

		static void menu() {

			tela.setJMenuBar(barraMenu);
			barraMenu.add(menu);
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
			botao.setBounds(0, 0, 150, 50);
			botao2.setBounds(150, 0, 150, 50);
			botao3.setBounds(300, 0, 150, 50);
			botao4.setBounds(450, 0, 150, 50);

			botao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cadastro();
					
					
				}
			});

			botao2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Atualizar();
				}
			});

			botao3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Excluir();
				}
			});
			botao4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Consultar();
				}
			});
			botao5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(Nome.getText().isEmpty() 
           		    || CPF.getText().isEmpty()
                    || Email.getText().isEmpty()
                    || Endereco.getText().isEmpty()){
           	 JOptionPane.showMessageDialog(null, "Informe todos os dados");
					} else {
						 int teleFone = JOptionPane.showConfirmDialog(null,"Deseja cadastrar telefone(s)?");
						 if (teleFone == JOptionPane.YES_OPTION){
							 cadastro.setVisible(false);
							 telefonee();
						 }else if (total<=100){
							   salvar();
							   total++;
					        	JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
                          identificacao++;
				         } else {
				        	 JOptionPane.showMessageDialog(null, "Limite de cadastro de 100 clientes atingido!");
				         }
				 	  } 
				   }
			});
			botao6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							"Excluído com sucesso!");
				}
			});
			opcao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					atualizar.setVisible(false);
					aNome();
				    
			}
			});
			opcao1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					atualizar.setVisible(false);
					aCPF();
				    
			}
			});
			opcao2.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					atualizar.setVisible(false);
					aEmail();
				    
			}
			});
			opcao3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					atualizar.setVisible(false);
					aTelefone();
				    
			}
			});
			opcao4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					atualizar.setVisible(false);
					aEndereco();
				    
			}
			});
		}

		static void Cadastro() {
			cadastro = new JFrame();
			cadastro.setTitle("Cadastrar novo cliente");
			cadastro.setSize(600,400);
			cadastro.setResizable(false);
			cadastro.setJMenuBar(barraMenu);
			cadastro.setLocationRelativeTo(null);
	        cadastro.setLayout(new GridLayout (11,10));
			cadastro.setVisible(true);
			JLabel id = new JLabel (" Seu código de identificação é:");
			cadastro.add(id);
			identifica = new JTextField(30);
			identifica.setText("" + identificacao);
			identifica.setEnabled(false);
			cadastro.add(identifica);
			JLabel nome = new JLabel ("Nome completo");
			cadastro.add(nome);
			Nome = new JTextField(30);
			cadastro.add(Nome);
			JLabel cpf = new JLabel ("CPF (Somente números)");
			cadastro.add(cpf);
			CPF = new JTextField(30);
			cadastro.add(CPF);
			JLabel email = new JLabel ("E-mail");
			cadastro.add(email);
			Email = new JTextField(30);
			cadastro.add(Email);
			JLabel endereco = new JLabel ("Endereço");
			cadastro.add(endereco);
			Endereco = new JTextField(30);
			cadastro.add(Endereco);
		    cadastro.add(botao5);
			}
		static void telefonee(){
			telefone = new JFrame();
			telefone.setTitle("Cadastrar telefone(s)");
			telefone.setSize(600,400);
			telefone.setResizable(false);
			telefone.setJMenuBar(barraMenu);
			telefone.setLocationRelativeTo(null);
		    telefone.setLayout(new GridLayout (11,10));
		    JLabel nome = new JLabel ("Nome do titular");
			telefone.add(nome);
			Nome = new JTextField(30);
			telefone.add(Nome);
			JLabel antigooTelefone = new JLabel ("Telefone padrão");
			telefone.add(antigooTelefone);
			Fone = new JTextField(30);
			telefone.add(Fone);
			JLabel telefone1 = new JLabel ("Telefone 1");
			telefone.add(telefone1);
			Fone1 = new JTextField(30);
			telefone.add(Fone1);
			JLabel telefone2 = new JLabel ("Telefone 2");
			telefone.add(telefone2);
			Fone2 = new JTextField(30);
			telefone.add(Fone2);
			telefone.setVisible(true);
			
		}
		
		static void Atualizar() {
			atualizar = new JFrame();
			atualizar.setTitle("Atualizar Cadastro");
			atualizar.setSize(600,400);
			atualizar.setResizable(false);
			atualizar.setJMenuBar(barraMenu);
			atualizar.setLocationRelativeTo(null);
			atualizar.setLayout(new GridLayout(10,10));
			atualizar.setVisible(true);
			JLabel pergunta = new JLabel ("O que você deseja atualizar?");
			pergunta.setHorizontalAlignment(SwingConstants.CENTER);
			atualizar.add(pergunta);
			atualizar.add(opcao);
			atualizar.add(opcao1);
			atualizar.add(opcao2);
			atualizar.add(opcao3);
			atualizar.add(opcao4);
			organiza = new ButtonGroup();
			organiza.add(opcao);
			organiza.add(opcao1);
			organiza.add(opcao2);
			organiza.add(opcao3);
			organiza.add(opcao4);
	        
			}
		
		static void Excluir() {
			excluir = new JFrame();
			excluir.setTitle("Excluir Cadastro");
			excluir.setSize(600,400);
			excluir.setResizable(false);
			excluir.setJMenuBar(barraMenu);
			excluir.setLocationRelativeTo(null);
			excluir.setLayout(new GridLayout (11,10));
			excluir.setVisible(true);
			JLabel nome = new JLabel ("Nome completo");
			excluir.add(nome);
			Nome = new JTextField(30);
			excluir.add(Nome);
			JLabel cpf = new JLabel ("CPF (Somente números)");
			excluir.add(cpf);
			CPF = new JTextField(30);
			excluir.add(CPF);
			JLabel email = new JLabel ("E-mail");
			excluir.add(email);
			Email = new JTextField(30);
			excluir.add(Email);
			JLabel telefone = new JLabel ("Telefone - Ex: (44)12345678");
			excluir.add(telefone);
			Fone = new JTextField(30);
			excluir.add(Fone);
			JLabel endereco = new JLabel ("Endereço");
			excluir.add(endereco);
			Endereco = new JTextField(30);
			excluir.add(Endereco);
			excluir.add(botao6);
			}
		static void Consultar() {
			consultar = new JFrame();
			consultar.setTitle("Consultar Cadastro");
			consultar.setSize(600,400);
			consultar.setResizable(false);
			consultar.setJMenuBar(barraMenu);
			consultar.setLocationRelativeTo(null);
			consultar.setLayout(new GridLayout (11,10));
			consultar.setVisible(true);
			JLabel nome = new JLabel ("Nome completo");
			consultar.add(nome);
			Nome = new JTextField(30);
			consultar.add(Nome);
			JLabel cpf = new JLabel ("CPF (Somente números)");
			consultar.add(cpf);
			CPF = new JTextField(30);
			consultar.add(CPF);
			JLabel email = new JLabel ("E-mail");
			consultar.add(email);
			Email = new JTextField(30);
			consultar.add(Email);
			JLabel telefone = new JLabel ("Telefone - Ex: (44)12345678");
			consultar.add(telefone);
			Fone = new JTextField(30);
			consultar.add(Fone);
			JLabel endereco = new JLabel ("Endereço");
			consultar.add(endereco);
			Endereco = new JTextField(30);
			consultar.add(Endereco);
			JButton cConsultar = new JButton ("Consultar");
	        consultar.add(cConsultar);
	        cConsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					consultar.setVisible(false); 
					consultaa();
				}	
			});
	       }
       
        static void consultaa(){
        	consulta = new JFrame();
        	consulta.setTitle("Consultar Cadastro");
			consulta.setSize(600,400);
			consulta.setResizable(false);
			consulta.setJMenuBar(barraMenu);
			consulta.setLocationRelativeTo(null);
			consulta.setLayout(null);
			consulta.setVisible(true);
			cadastrar.setBounds(0, 0, 600, 400);
			cadastrar.setLayout(null);
			cadastrar.setModel(new DefaultTableModel(new Object[] { "Identificação", "Nome", "CPF", "Email","Endereço"},0));
			consulta.add(cadastrar);
			cadastrar.setVisible(true);
	}
		
		static void aNome(){
        	atNome = new JFrame();
        	atNome.setTitle("Atualizar Nome");
			atNome.setSize(600,400);
			atNome.setResizable(false);
			atNome.setJMenuBar(barraMenu);
			atNome.setLocationRelativeTo(null);
			atNome.setLayout(new GridLayout(10,10));
			JLabel antigooNome = new JLabel ("Nome a ser mudado");
			atNome.add(antigooNome);
			antigoNome = new JTextField(30);
			atNome.add(antigoNome);
			JLabel novonome = new JLabel ("Novo nome");
			atNome.add(novonome);
			novoNome = new JTextField(30);
			atNome.add(novoNome);
			atNome.add(avancar);
        	atNome.setVisible(true);
        	avancar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(antigoNome.getText().isEmpty()
							|| novoNome.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Informe todos os dados!");
					}else{
					int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja atualizar esse campo?");
					if (confirma == JOptionPane.YES_OPTION){
						JOptionPane.showMessageDialog(null,"Campo atualizado com sucesso!");
						}
					}
					}
			});
        	}
        static void aCPF(){
        	atCPF = new JFrame();
        	atCPF.setTitle("Atualizar CPF");
			atCPF.setSize(600,400);
			atCPF.setResizable(false);
			atCPF.setJMenuBar(barraMenu);
			atCPF.setLocationRelativeTo(null);
			atCPF.setLayout(new GridLayout(10,10));
			JLabel nome = new JLabel ("Nome do titular");
			atCPF.add(nome);
			Nome = new JTextField(30);
			atCPF.add(Nome);
			JLabel antigooCPF = new JLabel ("CPF a ser mudado");
			atCPF.add(antigooCPF);
			antigoCPF = new JTextField(30);
			atCPF.add(antigoCPF);
			JLabel novooCPF = new JLabel ("Novo CPF");
			atCPF.add(novooCPF);
			novoCPF = new JTextField(30);
			atCPF.add(novoCPF);
			atCPF.add(avancar);
        	atCPF.setVisible(true);
        	avancar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(Nome.getText().isEmpty()
							||antigoCPF.getText().isEmpty()
							|| novoCPF.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Informe todos os dados!");
					}else{
					int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja atualizar esse campo?");
					if (confirma == JOptionPane.YES_OPTION){
						JOptionPane.showMessageDialog(null,"Campo atualizado com sucesso!");
						}
					}
					}
			});
        	}
        static void aEmail(){
        	atEmail = new JFrame();
        	atEmail.setTitle("Atualizar Email");
			atEmail.setSize(600,400);
			atEmail.setResizable(false);
			atEmail.setJMenuBar(barraMenu);
			atEmail.setLocationRelativeTo(null);
			atEmail.setLayout(new GridLayout(10,10));
			JLabel nome = new JLabel ("Nome do titular");
			atEmail.add(nome);
			Nome = new JTextField(30);
			atEmail.add(Nome);
			JLabel antigooEmail = new JLabel ("Email a ser mudado");
			atEmail.add(antigooEmail);
			antigoEmail = new JTextField(30);
			atEmail.add(antigoEmail);
			JLabel novooEmail = new JLabel ("Novo Email");
			atEmail.add(novooEmail);
			novoEmail = new JTextField(30);
			atEmail.add(novoEmail);
			atEmail.add(avancar);
        	atEmail.setVisible(true);
        	avancar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(Nome.getText().isEmpty()
							||antigoEmail.getText().isEmpty()
							||novoEmail.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Informe todos os dados!");
					}else{
					int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja atualizar esse campo?");
					if (confirma == JOptionPane.YES_OPTION){
						JOptionPane.showMessageDialog(null,"Campo atualizado com sucesso!");
						}
					}
					}
			});
        	
        }
        static void aEndereco(){
        	atEndereco = new JFrame();
        	atEndereco.setTitle("Atualizar Endereço");
			atEndereco.setSize(600,400);
			atEndereco.setResizable(false);
			atEndereco.setJMenuBar(barraMenu);
			atEndereco.setLocationRelativeTo(null);
			atEndereco.setLayout(new GridLayout(10,10));
			JLabel nome = new JLabel ("Nome do titular");
			atEndereco.add(nome);
			Nome = new JTextField(30);
			atEndereco.add(Nome);
			JLabel antigooEndereco = new JLabel ("Endereço a ser mudado");
			atEndereco.add(antigooEndereco);
			antigoEndereco = new JTextField(30);
			atEndereco.add(antigoEndereco);
			JLabel novooEndereco = new JLabel ("Novo Endereço");
			atEmail.add(novooEndereco);
			novoEndereco = new JTextField(30);
			atEndereco.add(novoEndereco);
			atEndereco.add(avancar);
        	atEndereco.setVisible(true);
        	avancar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(Nome.getText().isEmpty()
							||antigoEndereco.getText().isEmpty()
							|| novoEndereco.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Informe todos os dados!");
					}else{
					int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja atualizar esse campo?");
					if (confirma == JOptionPane.YES_OPTION){
						JOptionPane.showMessageDialog(null,"Campo atualizado com sucesso!");
						}
					}
					}
			});
        }
        static void aTelefone(){
        	atTelefone = new JFrame();
        	atTelefone.setTitle("Atualizar Telefone");
			atTelefone.setSize(600,400);
			atTelefone.setResizable(false);
			atTelefone.setJMenuBar(barraMenu);
			atTelefone.setLocationRelativeTo(null);
			atTelefone.setLayout(new GridLayout(10,10));
			JLabel nome = new JLabel ("Nome do titular");
			atTelefone.add(nome);
			Nome = new JTextField(30);
			atTelefone.add(Nome);
			JLabel antigooTelefone = new JLabel ("Telefone padrão");
			atTelefone.add(antigooTelefone);
			Fone = new JTextField(30);
			atTelefone.add(Fone);
			JLabel telefone1 = new JLabel ("Telefone 1");
			atTelefone.add(telefone1);
			Fone1 = new JTextField(30);
			atTelefone.add(Fone1);
			JLabel telefone2 = new JLabel ("Telefone 2");
			atTelefone.add(telefone2);
			Fone2 = new JTextField(30);
			atTelefone.add(Fone2);
			atTelefone.add(avancar);
        	atTelefone.setVisible(true);
        	avancar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(Nome.getText().isEmpty()
					    || Fone.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Informe seu nome e o telefone padrão!");
					}else{
					int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja atualizar esse campo?");
					if (confirma == JOptionPane.YES_OPTION){
						JOptionPane.showMessageDialog(null,"Campo atualizado com sucesso!");
						}
					}
					}
			});
        }
        static void salvar(){
        	   sistema [total] [info] = Nome.getText();
        	   sistema [total] [info + 1] = CPF.getText();
        	   sistema [total] [info + 2] = Email.getText();
        	   sistema [total] [info + 3] = Endereco.getText();
        	   sistema [total] [info + 4] = Fone.getText();
        	   total++;
        	}
 }
