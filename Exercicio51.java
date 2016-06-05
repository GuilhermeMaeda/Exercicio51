import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class TesteExercicio51 {
	    
	    static Font letra = new Font ("ARIAL",Font.BOLD,30);
		
	    static JFrame tela;
		static JFrame cadastro;
		static JFrame telefone;
		static JFrame atualizar;
		static JFrame atNome;
		static JFrame atCPF;
		static JFrame atEmail;
		static JFrame atEndereco;
		static JFrame atTelefone;
		static JFrame atTodos;
		static JFrame excluir;
		static JFrame consultar;
		static JFrame consulta;
		static JFrame consultaaTele;
		
		static JPanel menuTela;
		
		static JLabel fundo = new JLabel (new ImageIcon("Imagem\\Teste.png"));
		
		static JMenuBar barraMenu;
		static JMenu menu = new JMenu("Menu");
		static JMenuItem informacao = new JMenuItem("Informações");
		static JMenuItem ajuda = new JMenuItem("Ajuda");
		
		static JButton botaoC =  new JButton("Cadastrar");
		static JButton botaoA = new JButton("Atualizar");
		static JButton botaoE = new JButton("Excluir");
		static JButton botaoCo = new JButton("Consultar");
		static JButton botaoSalva = new JButton("Salvar");
		static JButton botaoExclui = new JButton ("Excluir");
		static JButton avancar = new JButton ("Avançar");
		static JButton cTel = new JButton ("Cadastrar telefone");
		
		static JRadioButton opcao = new JRadioButton("Nome", false);
		static JRadioButton opcao1 = new JRadioButton("CPF",false);
		static JRadioButton opcao2 = new JRadioButton("Email",false);
		static JRadioButton opcao3 = new JRadioButton("Telefone",false);
		static JRadioButton opcao4 = new JRadioButton("Endereço",false);
		static JRadioButton opcao5 = new JRadioButton("Todos",false);
		
        static ButtonGroup organiza;
        
        static JTextField identifica;
        static JTextField Nome;
		static MaskFormatter CPF;
		static JTextField Email; 
		static MaskFormatter Fone;
		static MaskFormatter Fone1; 
		static MaskFormatter Fone2;
        static JTextField Endereco;
        static JFormattedTextField jFTCPF;
        static JFormattedTextField jFTFONE;
        static JFormattedTextField jFTFONE1;
        static JFormattedTextField jFTFONE2;
        
		static String [] nomes = {"Identificação","Nome","CPF","Email","Endereço"};
		static String [] cellphone = {"Identificação","Telefone","Telefone 1","Telefone 2"};
		static Object[][] sistema = new Object [100] [6];
		static Object[][] tel = new Object[100] [4];
		static JTable cadastrar = new JTable(sistema, nomes);
		static JTable telefones = new JTable(tel, cellphone);
		
		
		static int identificacao = 1;
		static int infoTel;
		static int total = 0;
		static int somaTel = 1;
		
		
		
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
		    menuTela.setLayout(null);
			menuTela.setVisible(true);
			menuTela.add(botaoC);
			menuTela.add(botaoA);
			menuTela.add(botaoE);
			menuTela.add(botaoCo);
			menuTela.add(fundo);
		    fundo.setBounds(0,0,600,400);
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
			botaoC.setBounds(0, 0, 150, 50);
			botaoA.setBounds(150, 0, 150, 50);
			botaoE.setBounds(300, 0, 150, 50);
			botaoCo.setBounds(450, 0, 150, 50);

			botaoC.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Cadastro();
					
					
				}
			});

			botaoA.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Atualizar();
				}
			});

			botaoE.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					Excluir();
				}
			});
			botaoCo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					consultaa();
				}
			});
			botaoSalva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(Nome.getText().isEmpty() 
           		    || jFTCPF.getText().isEmpty()
                    || Email.getText().isEmpty()
                    || Endereco.getText().isEmpty()){
           	 JOptionPane.showMessageDialog(null, "Informe todos os dados");
					} else {
					if (identificacao<=100){
							   salvar();
							   JOptionPane.showMessageDialog(null,"Salvo com sucesso!");
                            identificacao++;
                           int continua = JOptionPane.showConfirmDialog(null, "Deseja continuar cadastrando?");
                           if (continua == JOptionPane.YES_OPTION){
                        	   cadastro.setVisible(false);
                        	   Cadastro();
                           } else {
                        	   cadastro.dispose();
                           }
				 	  } else {
				 		 JOptionPane.showMessageDialog(null, " Desculpe,limite de cadastro de 100 clientes atingido!");
			             cadastro.dispose();
				 	  }
				   }
				}
			});
			botaoExclui.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(Nome.getText().isEmpty() 
		           		    || jFTCPF.getText().isEmpty()
		                    || Email.getText().isEmpty()
		                    || Endereco.getText().isEmpty()){
		           	 JOptionPane.showMessageDialog(null, "Informe todos os dados");
							} else {
								JOptionPane.showMessageDialog(null,"Excluído com sucesso!");
							}
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
			opcao5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					atualizar.setVisible(false);
					aTodos();
				    
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
	        cadastro.setLayout(new GridLayout (12,10));
			cadastro.setVisible(true);
			JLabel id = new JLabel ("Seu código de identificação é:");
			cadastro.add(id);
			identifica = new JTextField(30);
			identifica.setText("" + identificacao);
			identifica.setEnabled(false);
			identifica.setFont(letra);
			cadastro.add(identifica);
			JLabel nome = new JLabel ("Nome completo");
			cadastro.add(nome);
			Nome = new JTextField(30);
			cadastro.add(Nome);
			JLabel cpf = new JLabel ("CPF");
            cadastro.add(cpf);
		    try {
				CPF = new MaskFormatter("###.###.###-##");
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTCPF = new JFormattedTextField(CPF);
            jFTCPF.setToolTipText("");
			cadastro.add(jFTCPF);
			JLabel email = new JLabel ("E-mail");
			cadastro.add(email);
			Email = new JTextField(30);
			cadastro.add(Email);
			JLabel endereco = new JLabel ("Endereço");
			cadastro.add(endereco);
			Endereco = new JTextField(30);
			cadastro.add(Endereco);
		    cadastro.add(botaoSalva);
		    cadastro.add(cTel);
		    cTel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cadastro.setVisible(false);
					telefonee();
				    
			}
			});
		    
			}
		

		static void telefonee(){
			telefone = new JFrame();
			telefone.setTitle("Cadastrar telefone(s)");
			telefone.setSize(600,400);
			telefone.setResizable(false);
			telefone.setJMenuBar(barraMenu);
			telefone.setLocationRelativeTo(null);
		    telefone.setLayout(new GridLayout (11,10));
		    JLabel id = new JLabel ("Insira seu código de identificação");
			telefone.add(id);
			identifica = new JTextField(30);
			telefone.add(identifica);
			JLabel antigooTelefone = new JLabel ("Telefone padrão");
			telefone.add(antigooTelefone);
			try {
				Fone = new MaskFormatter("(##)####-####");
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTFONE = new JFormattedTextField(Fone);
            jFTFONE.setColumns(10);
            telefone.add(jFTFONE);
			JLabel telefone1 = new JLabel ("Telefone celular");
			telefone.add(telefone1);
			try {
				Fone1 = new MaskFormatter("(##)####-####");
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTFONE1 = new JFormattedTextField(Fone1);
            jFTFONE1.setColumns(10);
			telefone.add(jFTFONE1);
			JLabel telefone2 = new JLabel ("Telefone comercial");
			telefone.add(telefone2);
			try {
				Fone2 = new MaskFormatter("(##)####-####");
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTFONE2 = new JFormattedTextField(Fone2);
            jFTFONE2.setColumns(10);
            telefone.add(jFTFONE2);
			JButton cTel1 = new JButton("Cadastrar telefone(s)");
            telefone.add(cTel1);
			telefone.setVisible(true);
			cTel1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(identifica.getText().isEmpty()
							||Fone.equals("")== true){
						JOptionPane.showMessageDialog(null,"Informe pelo menos o seu código de identificação e o telefone padrão!");
					}else {  
						salvarTel();
						JOptionPane.showMessageDialog(null,"Telefone cadastrado com sucesso!");
					}
				}
				});
			
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
			atualizar.add(opcao5);
			organiza = new ButtonGroup();
			organiza.add(opcao);
			organiza.add(opcao1);
			organiza.add(opcao2);
			organiza.add(opcao3);
			organiza.add(opcao4);
			organiza.add(opcao5);
	        
			}
		
		static void Excluir() {
			excluir = new JFrame();
			excluir.setTitle("Excluir Cadastro");
			excluir.setSize(600,400);
			excluir.setResizable(false);
			excluir.setJMenuBar(barraMenu);
			excluir.setLocationRelativeTo(null);
			excluir.setLayout(new GridLayout (15,10));
			excluir.setVisible(true);
			JLabel nome = new JLabel ("Nome completo");
			excluir.add(nome);
			Nome = new JTextField(30);
			excluir.add(Nome);
			JLabel cpf = new JLabel ("CPF (Somente números)");
			excluir.add(cpf);
			try {
				CPF = new MaskFormatter("###.###.###-##");
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTCPF = new JFormattedTextField(CPF);
            jFTCPF.setToolTipText("");
			excluir.add(jFTCPF);
			JLabel email = new JLabel ("E-mail");
			excluir.add(email);
			Email = new JTextField(30);
			excluir.add(Email);
			JLabel telefone = new JLabel ("Telefone padrão");
			excluir.add(telefone);
			try {
				Fone = new MaskFormatter("(##)####-####");
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTFONE = new JFormattedTextField(Fone);
            jFTFONE.setColumns(10);
			excluir.add(jFTFONE);
			JLabel telefone1 = new JLabel ("Telefone celular");
			excluir.add(telefone1);
			try {
				Fone1 = new MaskFormatter("(##)####-####");
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTFONE1 = new JFormattedTextField(Fone1);
            jFTFONE1.setColumns(10);
			excluir.add(jFTFONE1);
			JLabel telefone2 = new JLabel ("Telefone comercial");
			excluir.add(telefone2);
			try {
				Fone2 = new MaskFormatter("(##)####-####");
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTFONE2 = new JFormattedTextField(Fone2);
            jFTFONE2.setColumns(10);
            excluir.add(jFTFONE2);
			JLabel endereco = new JLabel ("Endereço");
			excluir.add(endereco);
			Endereco = new JTextField(30);
			excluir.add(Endereco);
			excluir.add(botaoExclui);
			}
		static void Consultar() {
			JButton cConsultar = new JButton ("Consultar");
	        consultar.add(cConsultar);
	        cConsultar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					consultar.setVisible(false); 
					consultaa();
				}	
			});
	        JButton cTele = new JButton("Consultar telefone(s)");
	        consultar.add(cTele);
	        cTele.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					consultar.setVisible(false); 
					consultaaTel();
				}	
			});
	       }
       
        static void consultaa(){
        	consulta = new JFrame();
        	consulta.setTitle("Consultar Cadastro");
			consulta.setSize(800,600);
			consulta.setResizable(false);
			consulta.setJMenuBar(barraMenu);
			consulta.setLocationRelativeTo(null);
			consulta.setVisible(true);
			cadastrar.setPreferredScrollableViewportSize( new Dimension (750,490));
			JScrollPane scroll = new JScrollPane(cadastrar);
			cadastrar.setEnabled(false);
			cadastrar.setLayout(null);
			JPanel consult = new JPanel();
			consult.setSize(800,600);
			consult.add(scroll);
			consulta.add(consult, BorderLayout.CENTER);
			scroll.setVisible(true);
			JButton cTele = new JButton("Consultar telefone(s)");
	        consulta.add(cTele,BorderLayout.SOUTH);
	        cTele.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					consulta.setVisible(false); 
					consultaaTel();
				}	
			});
			}
        static void consultaaTel(){
        	consultaaTele = new JFrame();
        	consultaaTele.setTitle("Consultar telefone(s)");
			consultaaTele.setSize(800,600);
			consultaaTele.setResizable(false);
			consultaaTele.setJMenuBar(barraMenu);
			consultaaTele.setLocationRelativeTo(null);
			consultaaTele.setVisible(true);
			telefones.setPreferredScrollableViewportSize( new Dimension (750,490));
			JScrollPane scrollTel = new JScrollPane(telefones);
			telefones.setEnabled(false);
			telefones.setLayout(null);
			JPanel consultaT = new JPanel();
			consultaT.add(scrollTel);
			consultaT.setSize(800,600);
			consultaaTele.add(consultaT, BorderLayout.CENTER);
			scrollTel.setVisible(true);
			JButton volta = new JButton("Voltar");
			consultaT.add(volta, BorderLayout.SOUTH);
			volta.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					consultaaTele.setVisible(false); 
					consultaa();
				}	
			});
        }
		
		static void aNome(){
        	atNome = new JFrame();
        	atNome.setTitle("Atualizar Nome");
			atNome.setSize(600,400);
			atNome.setResizable(false);
			atNome.setJMenuBar(barraMenu);
			atNome.setLocationRelativeTo(null);
			atNome.setLayout(new GridLayout(10,10));
			JLabel id = new JLabel ("Insira seu código de identificação");
			atNome.add(id);
			identifica = new JTextField(30);
			atNome.add(identifica);
			JLabel novonome = new JLabel ("Novo nome");
			atNome.add(novonome);
			Nome = new JTextField(30);
			atNome.add(Nome);
			JButton jbAnome = new JButton ("Atualizar nome");
	        atNome.add(jbAnome);
        	atNome.setVisible(true);
        	jbAnome.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(identifica.getText().isEmpty() 
					   || Nome.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Informe todos os dados!");
					}else{
					int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja atualizar esse campo?");
					if (confirma == JOptionPane.YES_OPTION){
						     int mud = cadastrar.getSelectedRow();
							 int mud1 = (int) cadastrar.getModel().getValueAt(mud, 1);
							 ((DefaultTableModel) cadastrar.getModel()).setValueAt(Nome.getText(),cadastrar.getSelectedRow(),1);
						      sistema[mud1 - 1][1] = Nome.getText();
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
			JLabel id = new JLabel ("Insira seu código de identificação");
			atCPF.add(id);
			identifica = new JTextField(30);
			atCPF.add(identifica);
			JLabel novooCPF = new JLabel ("Novo CPF");
			atCPF.add(novooCPF);
			try {
				CPF = new MaskFormatter("###.###.###-##");
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTCPF = new JFormattedTextField(CPF);
            jFTCPF.setToolTipText("");
			atCPF.add(jFTCPF);
			JButton jbAcpf = new JButton ("Atualizar CPF");
	        atCPF.add(jbAcpf);
        	atCPF.setVisible(true);
        	jbAcpf.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(identifica.getText().isEmpty()
						||jFTCPF.getText().isEmpty()){
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
			JLabel id = new JLabel ("Insira seu código de identificação");
			atEmail.add(id);
			identifica = new JTextField(30);
			atEmail.add(identifica);
			JLabel novooEmail = new JLabel ("Novo Email");
			atEmail.add(novooEmail);
			Email = new JTextField(30);
			atEmail.add(Email);
			JButton jbAemail = new JButton ("Atualizar email");
	        atEmail.add(jbAemail);
            atEmail.setVisible(true);
        	jbAemail.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(identifica.getText().isEmpty()
					   ||Email.getText().isEmpty()){
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
			JLabel id = new JLabel ("Insira seu código de identificação");
			atEndereco.add(id);
			identifica = new JTextField(30);
			atEndereco.add(identifica);
			JLabel novooEndereco = new JLabel ("Novo Endereço");
			atEndereco.add(novooEndereco);
			Endereco = new JTextField(30);
			atEndereco.add(Endereco);
			JButton jbAendereco = new JButton ("Atualizar endereço");
	        atEndereco.add(jbAendereco);
        	atEndereco.setVisible(true);
        	jbAendereco.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(identifica.getText().isEmpty()
						||Endereco.getText().isEmpty()){
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
			JLabel id = new JLabel ("Insira seu código de identificação");
			atTelefone.add(id);
			identifica = new JTextField(30);
			atTelefone.add(identifica);
			JLabel antigooTelefone = new JLabel ("Telefone padrão");
			atTelefone.add(antigooTelefone);
			try {
				Fone = new MaskFormatter("(##)####-####");
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTFONE = new JFormattedTextField(Fone);
            jFTFONE.setColumns(10);
			atTelefone.add(jFTFONE);
			JLabel telefone1 = new JLabel ("Telefone 1");
			atTelefone.add(telefone1);
			try {
				Fone1 = new MaskFormatter("(##)####-####");
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTFONE1 = new JFormattedTextField(Fone1);
            jFTFONE1.setColumns(10);
			atTelefone.add(jFTFONE1);
			JLabel telefone2 = new JLabel ("Telefone 2");
			atTelefone.add(telefone2);
			try {
				Fone2 = new MaskFormatter("(##)####-####");
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTFONE2 = new JFormattedTextField(Fone2);
            jFTFONE2.setColumns(10);
			atTelefone.add(jFTFONE2);
			JButton jbAtelefone = new JButton ("Atualizar telefone(s)");
	        atTelefone.add(jbAtelefone);
        	atTelefone.setVisible(true);
        	jbAtelefone.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(identifica.getText().isEmpty()
					    ||jFTFONE.getText().isEmpty()){
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
         static void aTodos(){
        	atTodos = new JFrame();
        	atTodos.setTitle("Atualizar todos os campos");
        	atTodos.setSize(800,600);
        	atTodos.setResizable(false);
        	atTodos.setJMenuBar(barraMenu);
        	atTodos.setVisible(true);
        	atTodos.setLocationRelativeTo(null);
        	atTodos.setLayout(new GridLayout (17,10));
			JLabel id = new JLabel ("Insira seu código de identificação");
			atTodos.add(id);
			identifica = new JTextField(30);
			atTodos.add(identifica);
			JLabel nome = new JLabel ("Nome completo");
			atTodos.add(nome);
			Nome = new JTextField(30);
			atTodos.add(Nome);
			JLabel cpf = new JLabel ("CPF");
			atTodos.add(cpf);
		    try {
				CPF = new MaskFormatter("###.###.###-##");
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTCPF = new JFormattedTextField(CPF);
            jFTCPF.setToolTipText("");
            atTodos.add(jFTCPF);
			JLabel email = new JLabel ("E-mail");
			JLabel antigooTelefone = new JLabel ("Telefone padrão");
			atTodos.add(antigooTelefone);
			try {
				Fone = new MaskFormatter("(##)####-####");
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTFONE = new JFormattedTextField(Fone);
            jFTFONE.setColumns(10);
            atTodos.add(jFTFONE);
			JLabel telefone1 = new JLabel ("Telefone 1");
			atTodos.add(telefone1);
			try {
				Fone1 = new MaskFormatter("(##)####-####");
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTFONE1 = new JFormattedTextField(Fone1);
            jFTFONE1.setColumns(10);
            atTodos.add(jFTFONE1);
			JLabel telefone2 = new JLabel ("Telefone 2");
			atTodos.add(telefone2);
			try {
				Fone2 = new MaskFormatter("(##)####-####");
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTFONE2 = new JFormattedTextField(Fone2);
            jFTFONE2.setColumns(10);
            atTodos.add(jFTFONE2);
			atTodos.add(email);
			Email = new JTextField(30);
			atTodos.add(Email);
			JLabel endereco = new JLabel ("Endereço");
			atTodos.add(endereco);
			Endereco = new JTextField(30);
			atTodos.add(Endereco);
			JButton jbAtTodos = new JButton ("Atualizar campos");
	        atTodos.add(jbAtTodos);
        	jbAtTodos.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(identifica.getText().isEmpty())
					    //|| Fone.getText().isEmpty())
							{
						JOptionPane.showMessageDialog(null,"Informe todos os campos!");
					}else{
					int confirma = JOptionPane.showConfirmDialog(null,"Tem certeza que deseja atualizar todos os  campo?");
					if (confirma == JOptionPane.YES_OPTION){
						JOptionPane.showMessageDialog(null,"Campos atualizado com sucesso!");
						}
					}
					}
			});
        	 
         }
        static void salvar(){
        	   sistema [total] [0] = identifica.getText();
        	   sistema [total] [1] = Nome.getText();
        	   sistema [total] [2] = jFTCPF.getText();
        	   sistema [total] [3] = Email.getText();
        	   sistema [total] [4] = Endereco.getText();
        	   total++;
        	}
        static void salvarTel(){
     	   tel [infoTel] [0] = identifica.getText();
     	   tel [infoTel] [1] = jFTFONE.getText();
     	   tel [infoTel] [2] = jFTFONE1.getText();
     	   tel [infoTel] [3] = jFTFONE2.getText(); 
     	   infoTel++;
        }
 }
