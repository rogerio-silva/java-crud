package br.com.numbersapp.dao;

import br.com.numbersapp.infra.ConnectionFactory;
import br.com.numbersapp.model.Curso;
import br.com.numbersapp.model.Pessoa;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class PessoaDAO implements iPessoaDAO{
    @Override
    public Pessoa save(Pessoa pessoa) {
        try (Connection connection = ConnectionFactory.getConnection()) {
            String sql = "insert into pessoas (nome, cpf, email, dataintegracao, curso) values (?, ?, ?, ?, ?)";
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, pessoa.getNome());
            preparedStatement.setString(2, pessoa.getCpf());
            preparedStatement.setString(3, pessoa.getEmail());
            preparedStatement.setDate(4, java.sql.Date.valueOf(pessoa.getDataintegracao()));
            preparedStatement.setString(5, pessoa.getCurso().toString());
            preparedStatement.executeUpdate();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            if (resultSet.next()) {
                pessoa.setId(resultSet.getLong("id"));
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return pessoa;
    }

    @Override
    public Pessoa update(Pessoa pessoa) {
        return null;
    }

    @Override
    public void delete(Long id) {

    }

    @Override
    public Optional<Pessoa> findById(Long id) {
        String sql = "select * from pessoas where id = ?";
        Pessoa pessoa = null;
        try (Connection connection = ConnectionFactory.getConnection()) {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setLong(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                pessoa = new Pessoa();
                pessoa.setId(resultSet.getLong("id"));
                pessoa.setNome(resultSet.getString("nome"));
                pessoa.setCpf(resultSet.getString("cpf"));
                pessoa.setEmail(resultSet.getString("email"));
                pessoa.setDataintegracao(resultSet.getDate("dataintegracao").toLocalDate());
                pessoa.setCurso(Curso.valueOf(resultSet.getString("curso")));

            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return Optional.ofNullable(pessoa);
    }

    @Override
    public Optional<Pessoa> findByCpf(String cpf) {
        return Optional.empty();
    }

    @Override
    public Optional<Pessoa> findByEmail(String email) {
        return Optional.empty();
    }

    @Override
    public List<Pessoa> findAll() {
        List<Pessoa> pessoas = new ArrayList<>();
        String sql = "select * from pessoas";
        try (Connection connection = ConnectionFactory.getConnection()) {
            assert connection != null;
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Pessoa pessoa = new Pessoa();
                pessoa.setId(resultSet.getLong("id"));
                pessoa.setNome(resultSet.getString("nome"));
                pessoa.setCpf(resultSet.getString("cpf"));
                pessoa.setEmail(resultSet.getString("email"));
                pessoa.setDataintegracao(resultSet.getDate("dataintegracao").toLocalDate());
                pessoa.setCurso(Curso.valueOf(resultSet.getString("curso")));
                pessoas.add(pessoa);
            }
        }
        catch (SQLException ex){
            throw new RuntimeException(ex);
        }
        return pessoas;
    }
}
