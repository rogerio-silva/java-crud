package br.com.numbersapp.dao;

import br.com.numbersapp.model.Pessoa;
import java.util.List;
import java.util.Optional;

public interface iPessoaDAO {
    Pessoa save(Pessoa pessoa);
    Pessoa update(Pessoa pessoa);
    void delete(Pessoa pessoa);
    Optional<Pessoa> findById(Long id);
    Optional<Pessoa> findByCpf(String cpf);
    Optional<Pessoa> findByEmail(String email);
    List<Pessoa> findAll();

}
