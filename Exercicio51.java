import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.RowFilter;
import javax.swing.UIManager;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import javax.swing.text.MaskFormatter;


public class Ex51Jao {

	static JFrame telaMenu = new JFrame("Cadastro de Clientes");
	static JFrame telaCadastro = new JFrame("Cadastro");
	static JFrame telaEditar = new JFrame("Editar Cliente");
	static JFrame telaTelefone = new JFrame("Cadastrar Telefone");

	static JButton botaoCadastrar = new JButton("Cadastrar Cliente");
	static JButton botaoSalvarCadastro = new JButton("Cadastrar");
	static JButton botaoEditar = new JButton("Editar Cliente");
	static JButton botaoSalvarEdicao = new JButton("Salvar");
	static JButton botaoCadastrarTel = new JButton("Cadastrar/Editar Telefone");
	static JButton botaoExcluir = new JButton("Excluir Cliente");
	static JButton sobre = new JButton("Sobre");
	static JButton botaoVoltarMenu = new JButton("Voltar ao Menu");
	static JButton botaoSair = new JButton("Sair");
	static JButton botaoSalvarTelefone = new JButton("Salvar Telefone");
	static JButton botaoExcluirTelefone = new JButton("Excluir Telefone");
	static JButton botaoLimparPesquisa = new JButton("Limpar pesquisa");

	static JLabel lbCadastroMenu = new JLabel("Cadastro de Clientes");
	static JLabel lbCadastro = new JLabel("Cadastro");
	static JLabel lbCodigo = new JLabel("Código: ");
	static JLabel lbImprimirCodigo = new JLabel();
	static JLabel lbNome = new JLabel("Nome: ");
	static JLabel lbEndereco = new JLabel("Endereço: ");
	static JLabel lbCpf = new JLabel("CPF: ");
	static JLabel lbEditar = new JLabel("Editar");
	static JLabel lbJoao = new JLabel("João Paulo Nunes Marques");
	static JLabel lbTelefone = new JLabel("Cadastrar Telefone");
	static JLabel lbResidencial = new JLabel("Residencial: ");
	static JLabel lbComercial = new JLabel("Comercial: ");
	static JLabel lbCelular = new JLabel("Celular: ");
	static JLabel lbPesquisar = new JLabel("Pesquisar:");

	static JTextField textNome = new JTextField();
	static JTextField textEndereco = new JTextField();
	static JTextField textCpf = new JTextField();
	static JTextField textResidencial = new JTextField();
	static JTextField textComercial = new JTextField();
	static JTextField textCelular = new JTextField();
	static JTextField textPesquisa = new JTextField();

	static MaskFormatter mascaraCPF = null;
	static MaskFormatter mascaraResidencial = null;
	static MaskFormatter mascaraComercial = null;
	static MaskFormatter mascaraCelular = null;

	static JTable tableConsultas = new JTable();
	static JPanel panelConsulta = new JPanel();
	static JScrollPane scrollConsulta = new JScrollPane(tableConsultas);

	private static final String ARIAL = "Arial";
	private static final String INATIVO = "INATIVO";
	private static final String IMAGEM_CADASTRAR = "/com/sun/java/swing/plaf/windows/icons/FloppyDrive.gif";
	private static final String IMAGEM_EXCLUIR = "/javax/swing/plaf/metal/icons/ocean/close.gif";
	private static final String IMAGEM_SOBRE = "/javax/swing/plaf/metal/icons/ocean/info.png";
	private static final String IMAGEM_EDITAR = "/com/sun/java/swing/plaf/windows/icons/TreeOpen.gif";
	static int codigo = 0;
	static int qntcliente = 100;
	static int informacao = 3;
	static String[][] posicao = new String[qntcliente][informacao];
	static String[][] posicaoTelefone = new String[qntcliente][informacao];

	public static void main(String[] args) {

		// alterando tema pelo LookAndFeel
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {

		}

		janelaMenu();
		janelaCadastrar();
		janelaTelefonar();
		janelaEditar();
		janelaExcluir();
		acaoSobre();
		acaoCadastrar();
		acaoSalvarTelefone(posicaoTelefone);
		acaoExcluirTelefone();
		acaoEditar();
		acaoSair();
		acaoLimparPesquisa();

	}

	static void janelaMenu() {

		telaMenu.add(botaoSair);
		botaoSair.setBounds(650, 590, 200, 50);

		componentesMenu();

		telaMenu.setLayout(null);
		telaMenu.setSize(900, 700);
		telaMenu.getContentPane().setBackground(Color.WHITE);
		telaMenu.setResizable(false);
		telaMenu.setLocationRelativeTo(null);
		telaMenu.setVisible(true);
		telaMenu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		telaMenu.add(lbCadastroMenu);
		lbCadastroMenu.setBounds(325, -255, 600, 600);
		lbCadastroMenu.setFont(new Font(ARIAL, Font.BOLD, 25));

		telaMenu.add(lbJoao);
		lbJoao.setFont(new Font(ARIAL, Font.PLAIN, 15));
		lbJoao.setBounds(395, 360, 600, 600);
		lbJoao.setFont(new Font(ARIAL, Font.BOLD, 10));

	}

	@SuppressWarnings("serial")
	static void componentesMenu() {

		telaMenu.add(botaoCadastrar);
		botaoCadastrar.setFont(new Font(ARIAL, Font.BOLD, 13));
		botaoCadastrar.setToolTipText("Clique para cadastrar um cliente");
		botaoCadastrar.setBounds(50, 90, 200, 50);
		//botaoCadastrar.setIcon(new ImageIcon(Exercicio51.class.getResource(IMAGEM_CADASTRAR)));

		telaMenu.add(lbPesquisar);
		lbPesquisar.setBounds(50, 155, 100, 30);
		lbPesquisar.setFont(new Font(ARIAL, Font.BOLD, 13));

		telaMenu.add(textPesquisa);
		textPesquisa.setBounds(120, 158, 225, 25);

		telaMenu.add(botaoCadastrarTel);
		botaoCadastrarTel.setFont(new Font(ARIAL, Font.BOLD, 13));
		botaoCadastrarTel.setToolTipText("Clique para cadastrar um telefone");
		botaoCadastrarTel.setBounds(50, 590, 220, 50);
		//botaoCadastrarTel.setIcon(new ImageIcon(Exercicio51.class.getResource(IMAGEM_CADASTRAR)));

		telaMenu.add(botaoExcluirTelefone);
		botaoExcluirTelefone.setFont(new Font(ARIAL, Font.BOLD, 13));
		botaoExcluirTelefone.setToolTipText("Clique para excluir o telefone");
		botaoExcluirTelefone.setBounds(280, 590, 200, 50);
		//botaoExcluirTelefone.setIcon(new ImageIcon(Exercicio51.class.getResource(IMAGEM_EXCLUIR)));

		telaMenu.add(botaoEditar);
		botaoEditar.setFont(new Font(ARIAL, Font.BOLD, 13));
		botaoEditar.setToolTipText("Clique para atualizar um cliente");
		botaoEditar.setBounds(260, 90, 200, 50);
		//botaoEditar.setIcon(new ImageIcon(Exercicio51.class.getResource(IMAGEM_EDITAR)));

		telaMenu.add(botaoExcluir);
		botaoExcluir.setFont(new Font(ARIAL, Font.BOLD, 13));
		botaoExcluir.setToolTipText("Clique para excluir um cliente");
		botaoExcluir.setBounds(470, 90, 200, 50);
		//botaoExcluir.setIcon(new ImageIcon(Exercicio51.class.getResource(IMAGEM_EXCLUIR)));

		telaMenu.add(sobre);
		sobre.setBounds(505, 590, 120, 50);
		sobre.setFont(new Font(ARIAL, Font.ITALIC, 15));
		//sobre.setIcon(new ImageIcon(Exercicio51.class.getResource(IMAGEM_SOBRE)));

		tableConsultas.setLayout(null);
		tableConsultas.revalidate();
		tableConsultas.setBounds(0, 0, 800, 500);
		tableConsultas.setModel(new DefaultTableModel(
				new Object[] { "Código", "Nome", "Endereço", "CPF", "Tel. Residencial", "Tel. Comercial", "Celular" },
				0) {
			// bloqueando a edição das linhas
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}

		});

		scrollConsulta.add(tableConsultas);
		scrollConsulta.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
		scrollConsulta.setBounds(0, 0, 800, 360);
		scrollConsulta.setViewportView(tableConsultas);

		telaMenu.add(panelConsulta);
		panelConsulta.add(scrollConsulta);
		panelConsulta.setLayout(null);
		panelConsulta.setBounds(50, 200, 800, 360);

		for (int i = 0; i < codigo; i++) {
			DefaultTableModel valores = (DefaultTableModel) tableConsultas.getModel();
			valores.addRow(new Object[] { i + 1, posicao[i][0], posicao[i][1], posicao[i][2], posicaoTelefone[i][0],
					posicaoTelefone[i][1], posicaoTelefone[i][2] });
			acaoPesquisar(tableConsultas);
		}

	}

	static void janelaCadastrar() {

		botaoCadastrar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				limparPesquisa();

				textNome.setText(null);
				textEndereco.setText(null);
				textCpf.setText(null);

				componentesCadastar();

				telaCadastro.add(botaoVoltarMenu);
				acaoVoltarMenu();
				botaoVoltarMenu.setBounds(550, 490, 200, 50);

				telaCadastro.setLayout(null);
				telaCadastro.setSize(800, 600);
				telaCadastro.getContentPane().setBackground(Color.WHITE);
				telaCadastro.setResizable(false);
				telaCadastro.setLocationRelativeTo(null);
				telaCadastro.setVisible(true);
				telaCadastro.add(lbCadastro);

				lbCadastro.setBounds(345, -220, 600, 600);
				lbCadastro.setFont(new Font(ARIAL, Font.BOLD, 30));

			}
		});

	}

	static void componentesCadastar() {

		telaCadastro.add(lbCodigo);
		lbCodigo.setBounds(50, 150, 200, 50);
		lbCodigo.setFont(new Font(ARIAL, Font.PLAIN, 15));

		telaCadastro.add(lbImprimirCodigo);
		lbImprimirCodigo.setBounds(110, 150, 200, 50);
		lbImprimirCodigo.setText(String.valueOf(codigo + 1));
		lbImprimirCodigo.setFont(new Font(ARIAL, Font.BOLD, 15));

		telaCadastro.add(lbNome);
		lbNome.setBounds(140, 150, 200, 50);
		lbNome.setFont(new Font(ARIAL, Font.PLAIN, 15));

		telaCadastro.add(textNome);
		textNome.setBounds(190, 160, 555, 30);

		telaCadastro.add(lbEndereco);
		lbEndereco.setBounds(50, 250, 200, 50);
		lbEndereco.setFont(new Font(ARIAL, Font.PLAIN, 15));

		telaCadastro.add(textEndereco);
		textEndereco.setBounds(125, 260, 620, 30);

		telaCadastro.add(lbCpf);
		lbCpf.setBounds(50, 350, 200, 50);
		lbCpf.setFont(new Font(ARIAL, Font.PLAIN, 15));

		telaCadastro.add(textCpf);
		textCpf.setBounds(90, 360, 655, 30);

		telaCadastro.add(botaoSalvarCadastro);
		botaoSalvarCadastro.setToolTipText("Clique para confirmar o cadastro");
		botaoSalvarCadastro.setBounds(300, 420, 200, 50);

	}

	static void acaoCadastrar() {

		botaoSalvarCadastro.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// validção de todos campos preenchidos
				if (textNome.getText().trim().isEmpty() || textEndereco.getText().trim().isEmpty()
						|| textCpf.getText().trim().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Preencha os campos!");
					componentesCadastar();

				} else {

					posicao[codigo][0] = textNome.getText().toUpperCase();
					posicao[codigo][1] = textEndereco.getText().toUpperCase();
					posicao[codigo][2] = textCpf.getText().toUpperCase();

					DefaultTableModel valores = (DefaultTableModel) tableConsultas.getModel();
					valores.addRow(new Object[] { (codigo + 1), posicao[codigo][0], posicao[codigo][1],
							posicao[codigo][2], posicaoTelefone[codigo][0], posicaoTelefone[codigo][1],
							posicaoTelefone[codigo][2] });

					// validação do codigo chegar somente no 100
					if (codigo < 100) {

						codigo++;

						int desejo = JOptionPane.showConfirmDialog(null, "Deseja continuar cadastrando?");
						// validando se sim ou se nao do JOption
						if (desejo == JOptionPane.YES_OPTION) {

							componentesCadastar();
							textNome.setText(null);
							textEndereco.setText(null);
							textCpf.setText(null);

						} else {

							textNome.setText(null);
							textEndereco.setText(null);
							textCpf.setText(null);
							telaCadastro.dispose();
							janelaMenu();

						}
					} else {

						textNome.setEnabled(false);
						textEndereco.setEnabled(false);
						textCpf.setEnabled(false);

						JOptionPane.showMessageDialog(null, "Espaço insulficiente para novos cadastros");

						telaCadastro.dispose();
						janelaMenu();

					}

				}

			}

		});

	}

	static int verificandoLinha() {

		int selectLinha = tableConsultas.getSelectedRow();
		int posMatriz = (int) tableConsultas.getValueAt(selectLinha, 0);

		return posMatriz;
	}

	static void janelaEditar() {

		botaoEditar.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				// validação se selecionou alguma linha (usado em outras funções
				// tambem)
				if (tableConsultas.getSelectedRow() != -1) {

					componentesEditar();

					telaEditar.add(botaoVoltarMenu);
					acaoVoltarMenu();

					telaEditar.setLayout(null);
					telaEditar.setSize(800, 600);
					telaEditar.getContentPane().setBackground(Color.WHITE);
					telaEditar.setResizable(false);
					telaEditar.setLocationRelativeTo(null);
					telaEditar.setVisible(true);

					telaEditar.add(lbEditar);
					lbEditar.setBounds(380, -220, 600, 600);
					lbEditar.setFont(new Font(ARIAL, Font.BOLD, 30));

				} else {

					JOptionPane.showMessageDialog(null, "Selecione a linha que deseja editar!");

				}

			}
		});

	}

	static void componentesEditar() {

		telaEditar.add(lbCodigo);
		lbCodigo.setBounds(50, 150, 200, 50);
		lbCodigo.setFont(new Font(ARIAL, Font.PLAIN, 15));

		int posMatriz = verificandoLinha();

		telaEditar.add(lbImprimirCodigo);
		lbImprimirCodigo.setVisible(true);
		lbImprimirCodigo.setBounds(110, 150, 200, 50);
		lbImprimirCodigo.setText(String.valueOf(posMatriz));
		lbImprimirCodigo.setFont(new Font(ARIAL, Font.BOLD, 15));

		telaEditar.add(lbNome);
		lbNome.setBounds(140, 150, 200, 50);
		lbNome.setFont(new Font(ARIAL, Font.PLAIN, 15));

		String posNome = (String) tableConsultas.getModel().getValueAt(posMatriz - 1, 1);
		telaEditar.add(textNome);
		textNome.setBounds(190, 160, 555, 30);
		textNome.setText(posNome);

		telaEditar.add(lbEndereco);
		lbEndereco.setBounds(50, 250, 200, 50);
		lbEndereco.setFont(new Font(ARIAL, Font.PLAIN, 15));

		String posEndereco = (String) tableConsultas.getModel().getValueAt(posMatriz - 1, 2);
		telaEditar.add(textEndereco);
		textEndereco.setBounds(125, 260, 620, 30);
		textEndereco.setText(posEndereco);

		telaEditar.add(lbCpf);
		lbCpf.setBounds(50, 350, 200, 50);
		lbCpf.setFont(new Font(ARIAL, Font.PLAIN, 15));

		String posCpf = (String) tableConsultas.getModel().getValueAt(posMatriz - 1, 3);
		telaEditar.add(textCpf);
		textCpf.setBounds(90, 360, 655, 30);
		textCpf.setText(posCpf);

		telaEditar.add(botaoSalvarEdicao);
		botaoSalvarEdicao.setVisible(true);
		botaoSalvarEdicao.setToolTipText("Clique para confirmar a edição");
		botaoSalvarEdicao.setBounds(300, 420, 200, 50);

	}

	static void acaoEditar() {

		botaoSalvarEdicao.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (textNome.getText().trim().isEmpty() || textEndereco.getText().trim().isEmpty()
						|| textCpf.getText().trim().isEmpty()) {

					JOptionPane.showMessageDialog(null, "Preencha os campos!");
					componentesEditar();

				} else {

					int deseja = JOptionPane.showConfirmDialog(null, "Deseja salvar a alteração?");
					if (deseja == JOptionPane.YES_OPTION) {

						int posMatriz = verificandoLinha();

						((DefaultTableModel) tableConsultas.getModel()).setValueAt(textNome.getText(), posMatriz - 1,
								1);
						((DefaultTableModel) tableConsultas.getModel()).setValueAt(textEndereco.getText(),
								posMatriz - 1, 2);
						((DefaultTableModel) tableConsultas.getModel()).setValueAt(textCpf.getText(), posMatriz - 1, 3);
						((DefaultTableModel) tableConsultas.getModel()).setValueAt("", posMatriz - 1, 4);
						((DefaultTableModel) tableConsultas.getModel()).setValueAt("", posMatriz - 1, 5);
						((DefaultTableModel) tableConsultas.getModel()).setValueAt("", posMatriz - 1, 6);

						posicao[posMatriz - 1][0] = textNome.getText();
						posicao[posMatriz - 1][1] = textEndereco.getText();
						posicao[posMatriz - 1][2] = textCpf.getText();
						posicaoTelefone[posMatriz - 1][0] = "";
						posicaoTelefone[posMatriz - 1][1] = "";
						posicaoTelefone[posMatriz - 1][2] = "";

						telaEditar.dispose();

					} else if (deseja == JOptionPane.CANCEL_OPTION) {

						janelaEditar();

					} else {

						telaEditar.dispose();

					}

					textNome.setText(null);
					textEndereco.setText(null);
					textCpf.setText(null);
				}
			}
		});

	}

	static void janelaExcluir() {

		botaoExcluir.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (tableConsultas.getSelectedRow() != -1) {

					int deseja = JOptionPane.showConfirmDialog(null, "Deseja deixar o usuário inativo?");

					if (deseja == JOptionPane.YES_OPTION) {

						int posMatriz = verificandoLinha();

						((DefaultTableModel) tableConsultas.getModel()).setValueAt(INATIVO,

						posMatriz - 1, 1);
						((DefaultTableModel) tableConsultas.getModel()).setValueAt(INATIVO, posMatriz - 1, 2);
						((DefaultTableModel) tableConsultas.getModel()).setValueAt(INATIVO, posMatriz - 1, 3);
						((DefaultTableModel) tableConsultas.getModel()).setValueAt(INATIVO, posMatriz - 1, 4);
						((DefaultTableModel) tableConsultas.getModel()).setValueAt(INATIVO, posMatriz - 1, 5);
						((DefaultTableModel) tableConsultas.getModel()).setValueAt(INATIVO, posMatriz - 1, 6);

						componentesExcluir();

					}

				} else {

					JOptionPane.showMessageDialog(null, "Selecione a linha que deseja inativar!");

				}

			}
		});

	}

	static void componentesExcluir() {

		int selectLinha = tableConsultas.getSelectedRow();
		int posMatriz = verificandoLinha();

		String valorNome = (String) tableConsultas.getModel().getValueAt(selectLinha, 1);
		String valorEnd = (String) tableConsultas.getValueAt(selectLinha, 2);
		String valorCPF = (String) tableConsultas.getValueAt(selectLinha, 3);
		String valorResidencial = (String) tableConsultas.getValueAt(selectLinha, 4);
		String valorComercial = (String) tableConsultas.getValueAt(selectLinha, 5);
		String valorCelular = (String) tableConsultas.getValueAt(selectLinha, 6);

		posicao[posMatriz - 1][0] = valorNome;
		posicao[posMatriz - 1][1] = valorEnd;
		posicao[posMatriz - 1][2] = valorCPF;
		posicaoTelefone[posMatriz - 1][0] = valorResidencial;
		posicaoTelefone[posMatriz - 1][1] = valorComercial;
		posicaoTelefone[posMatriz - 1][2] = valorCelular;

	}

	static void janelaTelefonar() {

		botaoCadastrarTel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (tableConsultas.getSelectedRow() != -1) {

					int posMatriz = verificandoLinha();
					if (posicao[posMatriz - 1][1] != "INATIVO") {

						textResidencial.setText(null);
						textComercial.setText(null);
						textCelular.setText(null);

						componentesTelefonar();

						telaTelefone.add(botaoVoltarMenu);
						acaoVoltarMenu();
						botaoVoltarMenu.setBounds(550, 490, 200, 50);

						telaTelefone.setLayout(null);
						telaTelefone.setSize(800, 600);
						telaTelefone.getContentPane().setBackground(Color.WHITE);
						telaTelefone.setResizable(false);
						telaTelefone.setLocationRelativeTo(null);
						telaTelefone.setVisible(true);

						telaTelefone.add(lbTelefone);
						lbTelefone.setBounds(290, -220, 600, 600);
						lbTelefone.setFont(new Font(ARIAL, Font.BOLD, 25));

					} else {

						JOptionPane.showMessageDialog(null,
								"Não é possivel alterar essa linha pois o cliente está inativo!");

					}

				} else {

					JOptionPane.showMessageDialog(null, "Selecione o cliente que deseja adicionar telefones!");

				}

			}
		});

	}

	static void componentesTelefonar() {

		telaTelefone.add(lbCodigo);
		lbCodigo.setBounds(50, 150, 200, 50);
		lbCodigo.setFont(new Font(ARIAL, Font.PLAIN, 15));

		int posMatriz = verificandoLinha();

		telaTelefone.add(lbImprimirCodigo);
		lbImprimirCodigo.setBounds(110, 150, 200, 50);
		lbImprimirCodigo.setText(String.valueOf(posMatriz));
		lbImprimirCodigo.setFont(new Font(ARIAL, Font.BOLD, 15));

		telaTelefone.add(lbResidencial);
		lbResidencial.setBounds(140, 150, 200, 50);
		lbResidencial.setFont(new Font(ARIAL, Font.PLAIN, 15));

		String valorRes = (String) tableConsultas.getModel().getValueAt(posMatriz - 1, 4);

		telaTelefone.add(textResidencial);
		textResidencial.setBounds(225, 160, 520, 30);
		textResidencial.setText(valorRes);

		telaTelefone.add(lbComercial);
		lbComercial.setBounds(50, 250, 200, 50);
		lbComercial.setFont(new Font(ARIAL, Font.PLAIN, 15));

		String valorCom = (String) tableConsultas.getModel().getValueAt(posMatriz - 1, 5);

		telaTelefone.add(textComercial);
		textComercial.setBounds(125, 260, 620, 30);
		textComercial.setText(valorCom);

		telaTelefone.add(lbCelular);
		lbCelular.setBounds(50, 350, 200, 50);
		lbCelular.setFont(new Font(ARIAL, Font.PLAIN, 15));

		String valorCel = (String) tableConsultas.getModel().getValueAt(posMatriz - 1, 6);

		telaTelefone.add(textCelular);
		textCelular.setBounds(105, 360, 640, 30);
		textCelular.setText(valorCel);

		telaTelefone.add(botaoSalvarTelefone);
		botaoSalvarTelefone.setToolTipText("Clique para salvar o telefone");
		botaoSalvarTelefone.setBounds(300, 420, 200, 50);

	}

	static void acaoSalvarTelefone(String[][] x) {

		botaoSalvarTelefone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int posMatriz = verificandoLinha();

				x[posMatriz - 1][0] = textResidencial.getText();
				x[posMatriz - 1][1] = textComercial.getText();
				x[posMatriz - 1][2] = textCelular.getText();

				((DefaultTableModel) tableConsultas.getModel()).setValueAt(x[posMatriz - 1][0], posMatriz - 1, 4);
				((DefaultTableModel) tableConsultas.getModel()).setValueAt(x[posMatriz - 1][1], posMatriz - 1, 5);
				((DefaultTableModel) tableConsultas.getModel()).setValueAt(x[posMatriz - 1][2], posMatriz - 1, 6);

				telaTelefone.dispose();

			}
		});

	}

	static void acaoExcluirTelefone() {

		botaoExcluirTelefone.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				if (tableConsultas.getSelectedRow() != -1) {
					if (tableConsultas.getSelectedColumn() >= 4) {

						int posMatriz = verificandoLinha();
						int selectColumn = tableConsultas.getSelectedColumn();

						((DefaultTableModel) tableConsultas.getModel()).setValueAt("", posMatriz - 1, selectColumn);

						componentesExcluirTel();

					} else {

						JOptionPane.showMessageDialog(null,
								"Selecione somente colunas referentes a telefone para exclui-la");

					}

				} else {

					JOptionPane.showMessageDialog(null, "Selecione a coluna do telefone que deseja excluir!");

				}
			}
		});

	}

	static void componentesExcluirTel() {

		int selectLinha = tableConsultas.getSelectedRow();
		int selectColumn = tableConsultas.getSelectedColumn();

		String valor = (String) tableConsultas.getValueAt(selectLinha, selectColumn);

		// contando a partir das colunas do telefone ignorando as 4 colunas que
		// trata sobre cliente
		int coluna = selectColumn - 4;

		posicaoTelefone[selectLinha][coluna] = valor;

	}

	static void acaoPesquisar(JTable x) {

		textPesquisa.addKeyListener(new java.awt.event.KeyListener() {

			@Override
			public void keyPressed(KeyEvent e) {
				
				acaoBuscar(x);

			}

			@Override
			public void keyReleased(KeyEvent e) {

				acaoBuscar(x);

			}

			@Override
			public void keyTyped(KeyEvent e) {

				acaoBuscar(x);

			}
		});

	}

	@SuppressWarnings("unchecked")
	static void acaoBuscar(JTable x) {

		DefaultTableModel model = (DefaultTableModel) tableConsultas.getModel();

		@SuppressWarnings({ "rawtypes" })
		TableRowSorter sorter = new TableRowSorter(model);
		x.setRowSorter(sorter);
		String text = textPesquisa.getText().toUpperCase();

		if (text.length() == 0) {
			sorter.setRowFilter(null);
		} else {
			sorter.setRowFilter(RowFilter.regexFilter(text));
		}

	}

	@SuppressWarnings({ "rawtypes", "unchecked" })
	static void limparPesquisa() {

		DefaultTableModel model = (DefaultTableModel) tableConsultas.getModel();
		TableRowSorter sorter = new TableRowSorter(model);
		tableConsultas.setRowSorter(sorter);
		textPesquisa.setText(null);

	}

	static void acaoLimparPesquisa() {

		telaMenu.add(botaoLimparPesquisa);
		botaoLimparPesquisa.setBounds(350, 158, 130, 25);

		botaoLimparPesquisa.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				limparPesquisa();

			}
		});

	}

	static void acaoSobre() {

		sobre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				JOptionPane.showMessageDialog(null,
						" " + "                       Cadastro de Clientes" + "\n"
								+ "\n - Versão 1.0;" + "\n"
								+ "\n - Desenvolvido por João Paulo Nunes Marques;" + "\n"
								+ "\n - Matéria Algoritmo 2;" + "\n"
								+ "\n - Orientado pelo Professor Altieres de Matos;		                    "
								+ "\n" + "\n - Faculdade Alvorada de Maringá" + "\n" + "\n");

			}
		});

	}

	static void acaoVoltarMenu() {

		botaoVoltarMenu.setVisible(true);
		botaoVoltarMenu.setToolTipText("Clique para voltar ao menu");
		//botaoVoltarMenu.setIcon(
				//new ImageIcon(Exercicio51.class.getResource("/com/sun/java/swing/plaf/windows/icons/HomeFolder.gif")));

		botaoVoltarMenu.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				telaEditar.dispose();
				telaCadastro.dispose();
				telaTelefone.dispose();
				janelaMenu();

			}
		});

	}

	static void acaoSair() {

		botaoSair.setVisible(true);
		botaoSair.setFont(new Font(ARIAL, Font.BOLD, 15));
		botaoSair.setToolTipText("Clique para fechar o programa");
		botaoSair.setIcon(new ImageIcon(IMAGEM_CADASTRAR));

		botaoSair.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				int desejo = JOptionPane.showConfirmDialog(null,
						"Todos os registros serão perdidos, deseja fechar o programa?");
				if (desejo == JOptionPane.YES_OPTION) {
					telaMenu.dispose();
				}

			}
		});

	}

}
