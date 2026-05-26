package controller;

import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import dao.AlunoDAO;
import model.Aluno;
import view.TelaAluno;

public class AlunoController {

    private TelaAluno tela;
    private AlunoDAO alunoDAO;

    public AlunoController(TelaAluno tela) {
        this.tela = tela;
        this.alunoDAO = new AlunoDAO();
    }

    public void salvar() {

        String nome = tela.getTxtNome().getText().trim();
        String nomeSocial = tela.getTxtNomeSocial().getText().trim();
        String cpf = tela.getTxtCpf().getText().trim();
        String genero = tela.getTxtGenero().getText().trim();
        String afrodescendente = tela.getTxtAfrodescendente().getText().trim();
        String escolaridadePublica = tela.getTxtEscolaridadePublica().getText().trim();
        String nacionalidade = tela.getTxtNacionalidade().getText().trim();
        String responsavelLegal = tela.getTxtResponsavelLegal().getText().trim();
        String serieModulo = tela.getTxtSerieModulo().getText().trim();
        String periodo = tela.getTxtPeriodo().getText().trim();

        if (nome.isEmpty() || cpf.isEmpty()) {

            JOptionPane.showMessageDialog(
                tela,
                "Preencha os campos Nome e CPF.",
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        try {

            String idTexto = tela.getTxtId().getText().trim();

            if (idTexto.isEmpty()) {

            	Aluno aluno = new Aluno(
            		    Integer.parseInt(idTexto),
            		    nome,
            		    nomeSocial,
            		    cpf,
            		    genero,
            		    Boolean.parseBoolean(afrodescendente),
            		    Boolean.parseBoolean(escolaridadePublica),
            		    nacionalidade,
            		    serieModulo,
            		    periodo
            		);
                alunoDAO.salvar(aluno);

                JOptionPane.showMessageDialog(
                    tela,
                    "Aluno salvo com sucesso."
                );

            } else {

            	Aluno aluno = new Aluno(
            		    Integer.parseInt(idTexto),
            		    nome,
            		    nomeSocial,
            		    cpf,
            		    genero,
            		    Boolean.parseBoolean(afrodescendente),
            		    Boolean.parseBoolean(escolaridadePublica),
            		    nacionalidade,
            		    serieModulo,
            		    periodo

                );

                alunoDAO.atualizar(aluno);

                JOptionPane.showMessageDialog(
                    tela,
                    "Aluno atualizado com sucesso."
                );
            }

            limpar();
            carregarTabela();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                tela,
                "Erro ao salvar: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void excluir() {

        int linha = tela.getTabelaAluno().getSelectedRow();

        if (linha == -1) {

            JOptionPane.showMessageDialog(
                tela,
                "Selecione um aluno na tabela para excluir.",
                "Atenção",
                JOptionPane.WARNING_MESSAGE
            );

            return;
        }

        int confirmacao = JOptionPane.showConfirmDialog(
            tela,
            "Deseja realmente excluir o aluno selecionado?",
            "Confirmação",
            JOptionPane.YES_NO_OPTION
        );

        if (confirmacao != JOptionPane.YES_OPTION) {
            return;
        }

        try {

            int id = Integer.parseInt(tela.getTxtId().getText());

            alunoDAO.excluir(id);

            JOptionPane.showMessageDialog(
                tela,
                "Aluno excluído com sucesso."
            );

            limpar();
            carregarTabela();

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                tela,
                "Erro ao excluir: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void limpar() {

        tela.getTxtId().setText("");
        tela.getTxtNome().setText("");
        tela.getTxtNomeSocial().setText("");
        tela.getTxtCpf().setText("");
        tela.getTxtGenero().setText("");
        tela.getTxtAfrodescendente().setText("");
        tela.getTxtEscolaridadePublica().setText("");
        tela.getTxtNacionalidade().setText("");
        tela.getTxtResponsavelLegal().setText("");
        tela.getTxtSerieModulo().setText("");
        tela.getTxtPeriodo().setText("");

        tela.getTxtNome().requestFocus();

        tela.getTabelaAluno().clearSelection();
    }

    public void carregarTabela() {

        DefaultTableModel modelo =
            (DefaultTableModel) tela.getTabelaAluno().getModel();

        modelo.setRowCount(0);

        try {

            List<Aluno> alunos = alunoDAO.listar();

            int i;

            for (i = 0; i < alunos.size(); i++) {

                Aluno a = alunos.get(i);

                modelo.addRow(new Object[] {
                    a.getId(),
                    a.getNome(),
                    a.getNomeSocial(),
                    a.getCpf(),
                    a.getGenero(),
                    a.isAfrodescendente(),
                    a.isEscolaridadePublica(),
                    a.getNacionalidade(),
                    a.getResponsavelLegal(),
                    a.isHabilitacao(),
                    a.getSerieModulo(),
                    a.getPeriodo()
                });
            }

        } catch (Exception e) {

            JOptionPane.showMessageDialog(
                tela,
                "Erro ao carregar tabela: " + e.getMessage(),
                "Erro",
                JOptionPane.ERROR_MESSAGE
            );
        }
    }

    public void preencherFormulario() {

        int linha = tela.getTabelaAluno().getSelectedRow();

        if (linha != -1) {

            tela.getTxtId().setText(
                tela.getTabelaAluno().getValueAt(linha, 0).toString()
            );

            tela.getTxtNome().setText(
                tela.getTabelaAluno().getValueAt(linha, 1).toString()
            );

            tela.getTxtNomeSocial().setText(
                tela.getTabelaAluno().getValueAt(linha, 2).toString()
            );

            tela.getTxtCpf().setText(
                tela.getTabelaAluno().getValueAt(linha, 3).toString()
            );

            tela.getTxtGenero().setText(
                tela.getTabelaAluno().getValueAt(linha, 4).toString()
            );

            tela.getTxtAfrodescendente().setText(
                tela.getTabelaAluno().getValueAt(linha, 5).toString()
            );

            tela.getTxtEscolaridadePublica().setText(
                tela.getTabelaAluno().getValueAt(linha, 6).toString()
            );

            tela.getTxtNacionalidade().setText(
                tela.getTabelaAluno().getValueAt(linha, 7).toString()
            );
            tela.getTxtResponsavelLegal().setText(
                tela.getTabelaAluno().getValueAt(linha, 8).toString()
            );

            tela.getTxtSerieModulo().setText(
                tela.getTabelaAluno().getValueAt(linha, 9).toString()
            );

            tela.getTxtPeriodo().setText(
                tela.getTabelaAluno().getValueAt(linha, 10).toString()
            );
        }
    }
}