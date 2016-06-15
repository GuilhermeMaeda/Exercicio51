import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

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
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

public class Ex51 {
	    
	    static Font letra = new Font ("ARIAL",Font.BOLD,30);
	     static final String EXCLUIDO = "Excluído";
		
	    static JFrame tela;
		static JFrame cadastro;
		static JFrame telefone;
		static JFrame atualizar;		
		static JFrame atTelefone;
		static JFrame excluir;
		static JFrame consultar;
		static JFrame consulta;
		static JFrame consultaaTele;
		static JFrame edit;
		static JFrame editT;
		
		static JPanel menuTela;
		
		static JLabel fundo = new JLabel (new ImageIcon("Imagem\\Teste.png"));
		
		static JMenuBar barraMenu;
		static JMenu menu = new JMenu("Menu");
		static JMenuItem informacao = new JMenuItem("Informações");
		static JMenuItem ajuda = new JMenuItem("Ajuda");
		static JMenuItem sobre = new JMenuItem("Sobre o software");
		
		static JButton botaoC =  new JButton("Cadastrar");
		static JButton botaoA = new JButton("Atualizar");
		static JButton botaoE = new JButton("Excluir");
		static JButton botaoCo = new JButton("Consultar");
		static JButton botaoSalva = new JButton("Salvar");
		static JButton botaoExclui = new JButton ("Excluir");
		static JButton avancar = new JButton ("Avançar");
		static JButton cTel = new JButton ("Cadastrar telefone");
		static JButton editar = new JButton ("Editar Cadastro");
		static JButton acaoeditar = new JButton ("Salvar alterações");
		static JButton atualizaT = new JButton ("Atualizar telefone(s)");
		static JButton atualizaTel = new JButton ("Editar telefone(s)");
		static JButton acaoAtTel = new JButton ("Salvar alterações");
        
        static JTextField identifica;
        static JTextField jtNome;
		static MaskFormatter jmCPF;
		static JTextField jtEmail; 
		static MaskFormatter jmFone;
		static MaskFormatter jmFone1; 
		static MaskFormatter jmFone2;
        static JTextField jtEndereco;
        static JFormattedTextField jFTCPF;
        static JFormattedTextField jFTFONE;
        static JFormattedTextField jFTFONE1;
        static JFormattedTextField jFTFONE2;
        
		static String [] nomes = {"Identificação","Nome","CPF","Email","Endereço"};
		static String [] cellphone = {"Identificação","Telefone padrão","Telefone celular","Telefone comercial"};
		static Object[][] sistema = new Object [100] [6];
		static Object[][] tel = new Object[100] [4];
		static JTable cadastrar = new JTable(sistema, nomes);
		static JTable telefones = new JTable(tel, cellphone);
		
		
		static int identificacao = 1;
		static int identificacaoT;
		static int infoTel;
		static int total = 0;
		
		
		
		
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
			menu.add(sobre);
			informacao.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							"Limite máximo de 100 cadastros\n Ao sair, todos os dados serão perdidos\n"
							+ "O cadastro de telefones só será possível se tiver ao menos um cliente cadastrado!");
				}
			});
			ajuda.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							"Sistema de cadastro, atualização, exclusão e consulta de clientes");
				}
			});
			sobre.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					JOptionPane.showMessageDialog(null,
							"Desenvolvido por Guilherme Maeda\n Acadêmico do curso de ciência da computação");
				}
			});
		}
		static int linhaselecionada(){
			int escolha = cadastrar.getSelectedRow();
			int pSistema = (int) cadastrar.getValueAt(escolha, 0);
			return pSistema;
			}
		static int linhaselecionadaTel(){
			int escolhaT = telefones.getSelectedRow();
			int pTelefone = (int) telefones.getValueAt(escolhaT, 0);
			return pTelefone;
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
					JOptionPane.showMessageDialog(null,"Selecione o cliente a ser excluído");
				}
			});
			botaoCo.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					consultaa();
				}
			});
			botaoSalva.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(jtNome.getText().isEmpty() 
           		    || jFTCPF.getText().isEmpty()
                    || jtEmail.getText().isEmpty()
                    || jtEndereco.getText().isEmpty()){
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
                        	   cTel.setEnabled(true);
                           } else {
                        	  int tele = JOptionPane.showConfirmDialog(null,"Deseja cadastrar telefone(s) agora?");
                        	  if(tele == JOptionPane.YES_OPTION){
                        		  JOptionPane.showMessageDialog(null," Por favor,clique em cadastrar telefone(s)");
                        	  } else {
                        		cadastro.dispose();  
                        	  }
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
					int certeza = JOptionPane.showConfirmDialog(null,"Tem certeza que quer excluir esse cadastro?");
					if(certeza==JOptionPane.YES_OPTION){
						 ((DefaultTableModel)cadastrar.getModel()).removeRow(cadastrar.getSelectedRow());
						JOptionPane.showMessageDialog(null,"Excluído com sucesso!");	
					}else {
						excluir.dispose();
					}
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
	        cadastro.setLayout(new GridLayout (13,10));
			cadastro.setVisible(true);
			JLabel info = new JLabel ("*Informe todos os dados!*");
			cadastro.add(info);
			JLabel id = new JLabel ("Seu código de identificação é:");
			cadastro.add(id);
			identifica = new JTextField(30);
			identifica.setText("" + identificacao);
			identifica.setEditable(false);
			identifica.setFont(letra);
			cadastro.add(identifica);
			JLabel nome = new JLabel ("Nome completo");
			cadastro.add(nome);
			jtNome = new JTextField(30);
			cadastro.add(jtNome);
			JLabel cpf = new JLabel ("CPF");
            cadastro.add(cpf);
		    try {
				jmCPF = new MaskFormatter("###.###.###-##");
				jmCPF.setPlaceholderCharacter('_');
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTCPF = new JFormattedTextField(jmCPF);
            jFTCPF.setToolTipText("");
			cadastro.add(jFTCPF);
			JLabel email = new JLabel ("E-mail");
			cadastro.add(email);
			jtEmail = new JTextField(30);
			cadastro.add(jtEmail);
			JLabel endereco = new JLabel ("Endereço - Ex: Avenida Brasil - 1122, Maringá-PR");
			cadastro.add(endereco);
			jtEndereco = new JTextField(30);
			cadastro.add(jtEndereco);
		    cadastro.add(botaoSalva);
		    cadastro.add(cTel);
		    //cTel.setEnabled(false);
		    cTel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(identificacao>1){
						cTel.setEnabled(true);
						cadastro.setVisible(false);
						telefonee();
					} else if(jtNome.getText().isEmpty() 
		           		    || jFTCPF.getText().isEmpty()
		                    || jtEmail.getText().isEmpty()
		                    || jtEndereco.getText().isEmpty()){
		           	 JOptionPane.showMessageDialog(null, "Informe todos os dados");
					} else {
					int permissao = JOptionPane.showConfirmDialog(null,"Cadastrar telefone(s)?");
					if (permissao == JOptionPane.YES_OPTION){
						int certo = JOptionPane.showConfirmDialog(null, "Deseja salvar este cadastro antes?");
						if(certo == JOptionPane.YES_OPTION){
							salvar();
							JOptionPane.showMessageDialog(null, "Cliente salvo com sucesso!");
							cadastro.setVisible(false);
							telefonee();
						}else {
						cadastro.setVisible(false);
						telefonee();
						}
					} else{
				        JOptionPane.showMessageDialog(null,"Para cadastrar telefone(s)é necessário "
										+ "ter ao menos um cliente cadastrado!, clique em Salvar");
				        } 
					}
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
				jmFone = new MaskFormatter("(##)####-####");
				jmFone.setPlaceholderCharacter('_');
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTFONE = new JFormattedTextField(jmFone);
            jFTFONE.setColumns(10);
            telefone.add(jFTFONE);
			JLabel telefone1 = new JLabel ("Telefone celular");
			telefone.add(telefone1);
			try {
				jmFone1 = new MaskFormatter("(##)####-####");
				jmFone1.setPlaceholderCharacter('_');
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTFONE1 = new JFormattedTextField(jmFone1);
            jFTFONE1.setColumns(10);
			telefone.add(jFTFONE1);
			JLabel telefone2 = new JLabel ("Telefone comercial");
			telefone.add(telefone2);
			try {
				jmFone2 = new MaskFormatter("(##)####-####");
				jmFone2.setPlaceholderCharacter('_');
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTFONE2 = new JFormattedTextField(jmFone2);
            jFTFONE2.setColumns(10);
            telefone.add(jFTFONE2);
			JButton cTel1 = new JButton("Cadastrar telefone(s)");
            telefone.add(cTel1);
			telefone.setVisible(true);
			cTel1.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(identifica.getText().isEmpty()
							||jFTFONE.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Informe pelo menos o seu código de identificação e o telefone padrão!");
					}else if (identificacaoT > identificacao){
									JOptionPane.showMessageDialog(null,"Identificação de cliente não encontrado, verifique se a Identificação do cliente existe!");
					} else {
						salvarTel();
						JOptionPane.showMessageDialog(null,"Telefone(s)cadastrado(s) com sucesso!");
						telefone.dispose();
					}
				}
				});
			
		}
		
		static void Atualizar() {
			atualizar = new JFrame();
			atualizar.setTitle("Atualizar Cadastro");
			atualizar.setSize(800,600);
			atualizar.setResizable(false);
			atualizar.setJMenuBar(barraMenu);
			atualizar.setLocationRelativeTo(null);
			atualizar.setVisible(true);
			cadastrar.setPreferredScrollableViewportSize( new Dimension (700,490));
			JScrollPane scroll2 = new JScrollPane(cadastrar);
			cadastrar.setLayout(null);
			JPanel atual = new JPanel();
			atual.setSize(800,600);
			atual.add(scroll2);
			atualizar.add(atual, BorderLayout.CENTER);
			scroll2.setVisible(true);
			atual.add(editar,BorderLayout.SOUTH);
			atual.add(atualizaT,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"Escolha o cadastro a ser atualizado e clique em editar cadastro");
			editar.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						atualizar.setVisible(false);
						edita();
					}	
				});
			atualizaT.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					atualizar.setVisible(false);
					aTel();
				}	
			});
			}
		static void edita(){
			edit = new JFrame();
			edit.setTitle("Atualizar cadastro");
			edit.setSize(600,400);
			edit.setResizable(false);
			edit.setJMenuBar(barraMenu);
			edit.setLocationRelativeTo(null);
			edit.setLayout(new GridLayout (12,10));
			edit.setVisible(true);
			JLabel id = new JLabel ("Insira seu código de identificação");
			edit.add(id);
			identifica = new JTextField(30);
			edit.add(identifica);
			JLabel nome = new JLabel ("Novo nome");
			edit.add(nome);
			jtNome = new JTextField(30);
			edit.add(jtNome);
			JLabel cpf = new JLabel ("Novo CPF");
            edit.add(cpf);
		    try {
				jmCPF = new MaskFormatter("###.###.###-##");
				jmCPF.setPlaceholderCharacter('_');
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTCPF = new JFormattedTextField(jmCPF);
            jFTCPF.setToolTipText("");
            edit.add(jFTCPF);
			JLabel email = new JLabel ("Novo E-mail");
			edit.add(email);
			jtEmail = new JTextField(30);
			edit.add(jtEmail);
			JLabel endereco = new JLabel ("Novo Endereço - Ex: Avenida Brasil - 1122, Maringá-PR");
			edit.add(endereco);
			jtEndereco = new JTextField(30);
			edit.add(jtEndereco);
			edit.add(acaoeditar);
			acaoeditar.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(jtNome.getText().isEmpty() 
		           		    || jFTCPF.getText().isEmpty()
		                    || jtEmail.getText().isEmpty()
		                    || jtEndereco.getText().isEmpty()){
		           	 JOptionPane.showMessageDialog(null, "Informe todos os dados");
					}else {
					int avanca = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja atualizar este cadastro?");
					if (avanca == JOptionPane.YES_OPTION){
						int pSistema = linhaselecionada();
                        ((DefaultTableModel) cadastrar.getModel()).setValueAt(jtNome.getText(), pSistema - 1,
						        1);
						((DefaultTableModel) cadastrar.getModel()).setValueAt(jFTCPF.getText(),
								pSistema - 1, 2);
						((DefaultTableModel) cadastrar.getModel()).setValueAt(jtEmail.getText(), 
								pSistema - 1, 3);
						((DefaultTableModel) cadastrar.getModel()).setValueAt(jtEndereco.getText(), 
								pSistema - 1, 4);
						cadastrar.repaint();

						sistema[pSistema - 1][1] = jtNome.getText();
						sistema[pSistema - 1][2] = jFTCPF.getText();
						sistema[pSistema - 1][3] = jtEmail.getText();
						sistema [pSistema -1][4] = jtEndereco.getText();
						
				} else{
					edit.dispose();
				  }
				 }
				}
			});
			
		}
		static void aTel(){
			atTelefone = new JFrame();
			atTelefone.setTitle("Atualizar telefone(s)");
			atTelefone.setSize(800,600);
			atTelefone.setResizable(false);
			atTelefone.setJMenuBar(barraMenu);
			atTelefone.setLocationRelativeTo(null);
			atTelefone.setVisible(true);
			telefones.setPreferredScrollableViewportSize( new Dimension (700,490));
			JScrollPane scroll3 = new JScrollPane(telefones);
			telefones.setLayout(null);
			JPanel atualT = new JPanel();
			atualT.setSize(800,600);
			atualT.add(scroll3);
			atTelefone.add(atualT, BorderLayout.CENTER);
			scroll3.setVisible(true);
			atTelefone.add(atualizaTel,BorderLayout.SOUTH);
			JOptionPane.showMessageDialog(null,"Escolha o(s)telefone(s) a ser(em) atualizado(s) e clique em editar telefone(s)");
			atualizaTel.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
					atTelefone.dispose();
					  aTelephone();
					}	
				});
		}
		static void aTelephone(){
			editT = new JFrame();
			editT.setTitle("Atualizar telefone(s)");
			editT.setSize(600,400);
			editT.setResizable(false);
			editT.setJMenuBar(barraMenu);
			editT.setLocationRelativeTo(null);
			editT.setVisible(true);
			editT.setLayout(new GridLayout (11,10));
		    JLabel id = new JLabel ("Insira seu código de identificação");
		    editT.add(id);
			identifica = new JTextField(30);
			editT.add(identifica);
			JLabel antigooTelefone = new JLabel (" Novo Telefone padrão");
			editT.add(antigooTelefone);
			try {
				jmFone = new MaskFormatter("(##)####-####");
				jmFone.setPlaceholderCharacter('_');
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTFONE = new JFormattedTextField(jmFone);
            jFTFONE.setColumns(10);
            editT.add(jFTFONE);
			JLabel telefone1 = new JLabel (" Novo Telefone celular");
			editT.add(telefone1);
			try {
				jmFone1 = new MaskFormatter("(##)####-####");
				jmFone1.setPlaceholderCharacter('_');
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTFONE1 = new JFormattedTextField(jmFone1);
            jFTFONE1.setColumns(10);
            editT.add(jFTFONE1);
			JLabel telefone2 = new JLabel ("Novo Telefone comercial");
			editT.add(telefone2);
			try {
				jmFone2 = new MaskFormatter("(##)####-####");
				jmFone2.setPlaceholderCharacter('_');
			} catch (ParseException e) {
				e.printStackTrace();
			}
            jFTFONE2 = new JFormattedTextField(jmFone2);
            jFTFONE2.setColumns(10);
            editT.add(jFTFONE2);
            editT.add(acaoAtTel);
            acaoAtTel.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					if(identifica.getText().isEmpty()
							||jFTFONE.getText().isEmpty()){
						JOptionPane.showMessageDialog(null,"Informe pelo menos"
								+ " o seu código de identificação e o telefone padrão!");
					}else{
						int avanca = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja atualizar este cadastro?");
					if (avanca == JOptionPane.YES_OPTION){
						int pTelefone = linhaselecionadaTel();
                        ((DefaultTableModel) telefones.getModel()).setValueAt(jFTFONE.getText(), pTelefone - 1,
						        1);
						((DefaultTableModel) telefones.getModel()).setValueAt(jFTFONE1.getText(),
								pTelefone - 1, 2);
						((DefaultTableModel) telefones.getModel()).setValueAt(jFTFONE2.getText(), 
								pTelefone - 1, 3);
						telefones.repaint();

						tel[pTelefone - 1][1] = jtNome.getText();
						tel[pTelefone - 1][2] = jFTCPF.getText();
						tel[pTelefone - 1][3] = jtEmail.getText();
						tel [pTelefone -1][4] = jtEndereco.getText();
						
				} else{
					editT.dispose();
				}
				}
				}
			});

		}
		static void Excluir() {
			excluir = new JFrame();
			excluir.setTitle("Excluir Cadastro");
			excluir.setSize(800,600);
			excluir.setResizable(false);
			excluir.setJMenuBar(barraMenu);
			excluir.setLocationRelativeTo(null);
			excluir.setVisible(true);
			cadastrar.setPreferredScrollableViewportSize( new Dimension (550,500));
			JScrollPane scroll1 = new JScrollPane(cadastrar);
			cadastrar.setLayout(null);
			JPanel exclui = new JPanel();
			exclui.setSize(800,600);
			exclui.add(scroll1);
			excluir.add(exclui, BorderLayout.CENTER);
			scroll1.setVisible(true);
			excluir.add(botaoExclui,BorderLayout.SOUTH);
			 JButton eTele = new JButton("Excluir telefone(s)");
			 exclui.add(eTele,BorderLayout.SOUTH);
		        eTele.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						excluir.setVisible(false);
						excluirTel();
						JOptionPane.showMessageDialog(null, "Selecione a linha com os telefones a serem excluídos\n "
								+ "Ou exclua apenas o desejado");
					}	
				});
			}
		 static void excluirTel(){
			    consultaaTele = new JFrame();
	        	consultaaTele.setTitle("Excluir telefone(s)");
				consultaaTele.setSize(800,600);
				consultaaTele.setResizable(false);
				consultaaTele.setJMenuBar(barraMenu);
				consultaaTele.setLocationRelativeTo(null);
				consultaaTele.setVisible(true);
				telefones.setPreferredScrollableViewportSize( new Dimension (750,490));
				JScrollPane scrollTel = new JScrollPane(telefones);
				telefones.setLayout(null);
				JPanel excluiT = new JPanel();
				excluiT.add(scrollTel);
				excluiT.setSize(800,600);
				consultaaTele.add(excluiT, BorderLayout.CENTER);
				scrollTel.setVisible(true);
				JButton excT = new JButton("Excluir telefone(s)");
				excluiT.add(excT, BorderLayout.SOUTH);
				excT.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						((DefaultTableModel)telefones.getModel()).removeRow(telefones.getSelectedRow());
						JOptionPane.showMessageDialog(null,"Excluído com sucesso!");
					}	
				});
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
		
        static void salvar(){
        	   sistema [total] [0] = identifica.getText();
        	   sistema [total] [1] = jtNome.getText();
        	   sistema [total] [2] = jFTCPF.getText();
        	   sistema [total] [3] = jtEmail.getText();
        	   sistema [total] [4] = jtEndereco.getText();
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
