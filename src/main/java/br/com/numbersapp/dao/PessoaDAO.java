package br.com.numbersapp.dao;
import br.com.numbersapp.infra.ConnectionFactory;
import br.com.numbersapp.model.Curso;
import br.com.numbersapp.model.Pessoa;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

public class PessoaDAO implements iPessoaDAO{
    @Override
    public Pessoa save(Pessoa pessoa) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "INSERT INTO pessoas (nome, sobrenome, cpf, email, numerocelular, dataaniversario, dataintegracao, curso) " +
                         "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getSobrenome());
            preparedStatement.setString(3, pessoa.getCpf());
            preparedStatement.setString(4, pessoa.getEmail());
            preparedStatement.setString(5, pessoa.getNumerocelular());
            preparedStatement.setDate(6, java.sql.Date.valueOf(pessoa.getDataaniversario()));
            preparedStatement.setDate(7, java.sql.Date.valueOf(pessoa.getDataintegracao()));
            preparedStatement.setString(8, pessoa.getCurso().toString());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                pessoa.setId(resultSet.getLong("id"));
            }
            preparedStatement.close();
            resultSet.close();
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return pessoa;
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "UPDATE pessoas " +
                         "SET nome=?, sobrenome=?, cpf=?, email=?, numerocelular=?, " +
                         "dataaniversario=?, dataintegracao=?, curso=? " +
                         "WHERE id=?";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getSobrenome());
            preparedStatement.setString(3, pessoa.getCpf());
            preparedStatement.setString(4, pessoa.getEmail());
            preparedStatement.setString(5, pessoa.getNumerocelular());
            preparedStatement.setDate(6, java.sql.Date.valueOf(pessoa.getDataaniversario()));
            preparedStatement.setDate(7, java.sql.Date.valueOf(pessoa.getDataintegracao()));
            preparedStatement.setString(8, pessoa.getCurso().toString());
            preparedStatement.setLong(9, pessoa.getId());
            preparedStatement.executeUpdate();
            preparedStatement.close();
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return pessoa;
    }

    @Override
    public void delete(Pessoa pessoa) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "DELETE FROM pessoas WHERE id = ?";

            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, pessoa.getId());

            preparedStatement.executeUpdate();

            preparedStatement.close();

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
    }

    @Override
    public Optional<Pessoa> findById(Long id) {
        String sql = "SELECT * FROM pessoas WHERE id = ?";
        Pessoa pessoa = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    pessoa = new Pessoa();
                    Pessoa fPessoa = pessoa;
                    pessoa.setId(resultSet.getLong("id"));
                    pessoa.setNome(resultSet.getString("nome"));
                    pessoa.setSobrenome(resultSet.getString("sobrenome"));
                    pessoa.setCpf(resultSet.getString("cpf"));
                    pessoa.setEmail(resultSet.getString("email"));
                    pessoa.setNumerocelular(resultSet.getString("numerocelular"));
                    // Verificar se a data é null antes de converter para LocalDate
                    ofNullable(resultSet.getDate("dataaniversario"))
                            .ifPresent(data -> fPessoa.setDataaniversario(data.toLocalDate()));
                    ofNullable(resultSet.getDate("dataintegracao"))
                            .ifPresent(data -> fPessoa.setDataintegracao(data.toLocalDate()));
                    pessoa.setCurso(Curso.valueOf(resultSet.getString("curso")));
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                preparedStatement.close();
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return ofNullable(pessoa);
    }

    @Override
    public Optional<Pessoa> findByCpf(String cpf) {
        String sql = "SELECT * FROM pessoas WHERE cpf = ?";
        Pessoa pessoa = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, cpf);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    pessoa = new Pessoa();
                    Pessoa fPessoa = pessoa;
                    pessoa.setId(resultSet.getLong("id"));
                    pessoa.setNome(resultSet.getString("nome"));
                    pessoa.setSobrenome(resultSet.getString("sobrenome"));
                    pessoa.setCpf(resultSet.getString("cpf"));
                    pessoa.setEmail(resultSet.getString("email"));
                    pessoa.setNumerocelular(resultSet.getString("numerocelular"));
                    // Verificar se a data é null antes de converter para LocalDate
                    ofNullable(resultSet.getDate("dataaniversario"))
                            .ifPresent(data -> fPessoa.setDataaniversario(data.toLocalDate()));
                    ofNullable(resultSet.getDate("dataintegracao"))
                            .ifPresent(data -> fPessoa.setDataintegracao(data.toLocalDate()));
                    pessoa.setCurso(Curso.valueOf(resultSet.getString("curso")));
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                preparedStatement.close();
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return ofNullable(pessoa);
    }

    @Override
    public Optional<Pessoa> findByEmail(String email) {
        String sql = "SELECT * FROM pessoas WHERE email = ?";
        Pessoa pessoa = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, email);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    pessoa = new Pessoa();
                    Pessoa fPessoa = pessoa;
                    pessoa.setId(resultSet.getLong("id"));
                    pessoa.setNome(resultSet.getString("nome"));
                    pessoa.setSobrenome(resultSet.getString("sobrenome"));
                    pessoa.setCpf(resultSet.getString("cpf"));
                    pessoa.setEmail(resultSet.getString("email"));
                    pessoa.setNumerocelular(resultSet.getString("numerocelular"));
                    // Verificar se a data é null antes de converter para LocalDate
                    ofNullable(resultSet.getDate("dataaniversario"))
                            .ifPresent(data -> fPessoa.setDataaniversario(data.toLocalDate()));
                    ofNullable(resultSet.getDate("dataintegracao"))
                            .ifPresent(data -> fPessoa.setDataintegracao(data.toLocalDate()));
                    pessoa.setCurso(Curso.valueOf(resultSet.getString("curso")));
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                preparedStatement.close();
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return ofNullable(pessoa);
    }

    @Override
    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "SELECT * FROM pessoas";
        try (Connection connection = ConnectionFactory.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {
                    Pessoa pessoa = new Pessoa();
                    Pessoa fPessoa = pessoa;
                    pessoa.setId(resultSet.getLong("id"));
                    pessoa.setNome(resultSet.getString("nome"));
                    pessoa.setSobrenome(resultSet.getString("sobrenome"));
                    pessoa.setCpf(resultSet.getString("cpf"));
                    pessoa.setEmail(resultSet.getString("email"));
                    pessoa.setNumerocelular(resultSet.getString("numerocelular"));
                    // Verificar se a data é null antes de converter para LocalDate
                    ofNullable(resultSet.getDate("dataaniversario"))
                            .ifPresent(data -> fPessoa.setDataaniversario(data.toLocalDate()));
                    ofNullable(resultSet.getDate("dataintegracao"))
                            .ifPresent(data -> fPessoa.setDataintegracao(data.toLocalDate()));
                    pessoa.setCurso(Curso.valueOf(resultSet.getString("curso")));
                    pessoas.add(pessoa);
                }
            } catch (SQLException ex) {
                throw new RuntimeException(ex);
            } finally {
                preparedStatement.close();
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return pessoas;
    }
}
