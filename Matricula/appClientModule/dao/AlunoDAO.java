package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Aluno;
import util.Conexao;

public class AlunoDAO {

    public void salvar(Aluno aluno) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql =
            "INSERT INTO aluno (" +
            "nome, nome_social, cpf, genero, afrodescendente, " +
            "escolaridade_publica, nacionalidade, responsavel_legal, " +
            "serie_modulo, periodo" +
            ") VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {

            conn = Conexao.conectar();

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getNomeSocial());
            stmt.setString(3, aluno.getCpf());
            stmt.setString(4, aluno.getGenero());
            stmt.setBoolean(5, aluno.isAfrodescendente());
            stmt.setBoolean(6, aluno.isEscolaridadePublica());
            stmt.setString(7, aluno.getNacionalidade());
            stmt.setString(11, aluno.getResponsavelLegal());
            stmt.setBoolean(13, aluno.isHabilitacao());
            stmt.setString(14, aluno.getSerieModulo());
            stmt.setString(15, aluno.getPeriodo());

            stmt.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException(
                "Erro ao salvar aluno: " + e.getMessage()
            );

        } finally {

            try {

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void atualizar(Aluno aluno) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql =
            "UPDATE aluno SET " +
            "nome = ?, " +
            "nome_social = ?, " +
            "cpf = ?, " +
            "genero = ?, " +
            "afrodescendente = ?, " +
            "escolaridade_publica = ?, " +
            "nacionalidade = ?, " +
            "responsavel_legal = ?, " +
            "habilitacao = ?, " +
            "serie_modulo = ?, " +
            "periodo = ? " +
            "WHERE id = ?";

        try {

            conn = Conexao.conectar();

            stmt = conn.prepareStatement(sql);

            stmt.setString(1, aluno.getNome());
            stmt.setString(2, aluno.getNomeSocial());
            stmt.setString(3, aluno.getCpf());
            stmt.setString(4, aluno.getGenero());
            stmt.setBoolean(5, aluno.isAfrodescendente());
            stmt.setBoolean(6, aluno.isEscolaridadePublica());
            stmt.setString(7, aluno.getNacionalidade());
            stmt.setString(11, aluno.getResponsavelLegal());
            stmt.setBoolean(13, aluno.isHabilitacao());
            stmt.setString(14, aluno.getSerieModulo());
            stmt.setString(15, aluno.getPeriodo());
            stmt.setInt(16, aluno.getId());

            stmt.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException(
                "Erro ao atualizar aluno: " + e.getMessage()
            );

        } finally {

            try {

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void excluir(int id) {

        Connection conn = null;
        PreparedStatement stmt = null;

        String sql = "DELETE FROM aluno WHERE id = ?";

        try {

            conn = Conexao.conectar();

            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            stmt.executeUpdate();

        } catch (Exception e) {

            throw new RuntimeException(
                "Erro ao excluir aluno: " + e.getMessage()
            );

        } finally {

            try {

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public List<Aluno> listar() {

        List<Aluno> lista = new ArrayList<Aluno>();

        Connection conn = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;

        String sql = "SELECT * FROM aluno ORDER BY id DESC";

        try {

            conn = Conexao.conectar();

            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while (rs.next()) {

                Aluno aluno = new Aluno();

                aluno.setId(rs.getInt("id"));
                aluno.setNome(rs.getString("nome"));
                aluno.setNomeSocial(rs.getString("nome_social"));
                aluno.setCpf(rs.getString("cpf"));
                aluno.setGenero(rs.getString("genero"));
                aluno.setAfrodescendente(rs.getBoolean("afrodescendente"));
                aluno.setEscolaridadePublica(rs.getBoolean("escolaridade_publica"));
                aluno.setNacionalidade(rs.getString("nacionalidade"));
                aluno.setResponsavelLegal(rs.getString("responsavel_legal"));
                aluno.setHabilitacao(rs.getBoolean("habilitacao"));
                aluno.setSerieModulo(rs.getString("serie_modulo"));
                aluno.setPeriodo(rs.getString("periodo"));

                lista.add(aluno);
            }

        } catch (Exception e) {

            throw new RuntimeException(
                "Erro ao listar alunos: " + e.getMessage()
            );

        } finally {

            try {

                if (rs != null) {
                    rs.close();
                }

                if (stmt != null) {
                    stmt.close();
                }

                if (conn != null) {
                    conn.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return lista;
    }
}