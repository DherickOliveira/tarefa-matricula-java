package view;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import controller.AlunoController;

public class TelaAluno extends JFrame {

    private static final long serialVersionUID = 1L;
 
    private JLabel lblId;
    private JLabel lblNome;
    private JLabel lblNomeSocial;
    private JLabel lblCpf;
    private JLabel lblGenero;
    private JLabel lblAfrodescendente;
    private JLabel lblEscolaridadePublica;
    private JLabel lblNacionalidade;
    private JLabel lblResponsavelLegal;
    private JLabel lblSerieModulo;
    private JLabel lblPeriodo;
  
    private  JTextField txtId;
    private  JTextField txtNome;
    private  JTextField txtNomeSocial;
    private  JTextField txtCpf;
    private  JTextField txtGenero;
    private  JTextField txtAfrodescendente;
    private  JTextField txtEscolaridadePublica;
    private  JTextField txtNacionalidade;
    private  JTextField txtResponsavelLegal;
    private  JTextField txtSerieModulo;
    private  JTextField txtPeriodo;
    
    
    private JButton btnNovo;
    private JButton btnSalvar;
    private JButton btnExcluir;
    private JButton btnLimpar;
    
    private JTable tabelaAluno;
    private DefaultTableModel modeloTabela;

    private AlunoController controller;




public TelaAluno() {
    setTitle("Cadastro de Alunos - Java SE 7 + Swing + MySQL");
    setSize(700, 450);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    setLayout(new BorderLayout());

    criarComponentes();

    controller = new AlunoController(this);
    configurarEventos();
    controller.carregarTabela();
}

private void criarComponentes() {
    JPanel painelFormulario = new JPanel(new GridLayout(3, 2, 10, 10));
    painelFormulario.setBorder(BorderFactory.createTitledBorder("Dados do Aluno"));
 
    lblId = new JLabel("ID:");
    txtId = new JTextField();
    txtId.setEditable(false);

    lblNome = new JLabel("Nome:");
    txtNome = new JTextField();

    lblNomeSocial = new JLabel("Nome Social:");
    txtNomeSocial = new JTextField();

    lblCpf = new JLabel("CPF:");
    txtCpf = new JTextField();

    lblGenero = new JLabel("Gênero:");
    txtGenero = new JTextField();

    lblAfrodescendente = new JLabel("Afrodescendente:");
    txtAfrodescendente = new JTextField();

    lblEscolaridadePublica = new JLabel("Escolaridade Pública:");
    txtEscolaridadePublica = new JTextField();

    lblNacionalidade = new JLabel("Nacionalidade:");
    txtNacionalidade = new JTextField();

    lblResponsavelLegal = new JLabel("Responsável Legal:");
    txtResponsavelLegal = new JTextField();

    lblSerieModulo = new JLabel("Série/Módulo:");
    txtSerieModulo = new JTextField();

    lblPeriodo = new JLabel("Período:");
    txtPeriodo = new JTextField();

    painelFormulario.add(lblId);
    painelFormulario.add(txtId);

    painelFormulario.add(lblNome);
    painelFormulario.add(txtNome);

    painelFormulario.add(lblNomeSocial);
    painelFormulario.add(txtNomeSocial);

    painelFormulario.add(lblCpf);
    painelFormulario.add(txtCpf);

    painelFormulario.add(lblGenero);
    painelFormulario.add(txtGenero);

    painelFormulario.add(lblAfrodescendente);
    painelFormulario.add(txtAfrodescendente);

    painelFormulario.add(lblEscolaridadePublica);
    painelFormulario.add(txtEscolaridadePublica);

    painelFormulario.add(lblNacionalidade);
    painelFormulario.add(txtNacionalidade);

    painelFormulario.add(lblResponsavelLegal);
    painelFormulario.add(txtResponsavelLegal);

    painelFormulario.add(lblSerieModulo);
    painelFormulario.add(txtSerieModulo);

    painelFormulario.add(lblPeriodo);
    painelFormulario.add(txtPeriodo);

    add(painelFormulario, BorderLayout.NORTH);

    modeloTabela = new DefaultTableModel(new Object[] { "ID", "Nome", "Nome Social", "CPF", "Gênero", "Afrodescendente", "Escolaridade Pública", "Nacionalidade", "Filiação 1", "Filiação 2", "Responsável Legal", "Grau de Parentesco", "Habilitação", "Série/Módulo", "Período" }, 0) {

        private static final long serialVersionUID = 1L;

        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    tabelaAluno = new JTable(modeloTabela);
    JScrollPane scrollPane = new JScrollPane(tabelaAluno);
    scrollPane.setBorder(BorderFactory.createTitledBorder("Lista de Clientes"));
    add(scrollPane, BorderLayout.CENTER);

    JPanel painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 15, 10));

    btnNovo = new JButton("Novo");
    btnSalvar = new JButton("Salvar");
    btnExcluir = new JButton("Excluir");
    btnLimpar = new JButton("Limpar");

    painelBotoes.add(btnNovo);
    painelBotoes.add(btnSalvar);
    painelBotoes.add(btnExcluir);
    painelBotoes.add(btnLimpar);

    add(painelBotoes, BorderLayout.SOUTH);
    
	}
private void configurarEventos() {
    btnNovo.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
            controller.limpar();
        }
    });

    btnSalvar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
            controller.salvar();
        }
    });

    btnExcluir.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
            controller.excluir();
        }
    });

    btnLimpar.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
            controller.limpar();
        }
    });

    tabelaAluno.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            controller.preencherFormulario();
        }
    });
}

public JTextField getTxtId() {
    return txtId;
}

public JTextField getTxtNome() {
    return txtNome;
}

public JTextField getTxtNomeSocial() {
    return txtNomeSocial;
}

public JTextField getTxtCpf() {
    return txtCpf;
}

public JTextField getTxtGenero() {
    return txtGenero;
}

public JTextField getTxtAfrodescendente() {
    return txtAfrodescendente;
}

public JTextField getTxtEscolaridadePublica() {
    return txtEscolaridadePublica;
}

public JTextField getTxtNacionalidade() {
    return txtNacionalidade;
}

public JTextField getTxtResponsavelLegal() {
    return txtResponsavelLegal;
}


public JTextField getTxtSerieModulo() {
    return txtSerieModulo;
}

public JTextField getTxtPeriodo() {
    return txtPeriodo;
}

public JTable getTabelaAluno() {
    return tabelaAluno;
	}
}