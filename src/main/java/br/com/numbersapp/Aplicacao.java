package br.com.numbersapp;

import br.com.numbersapp.dao.PessoaDAO;
import br.com.numbersapp.model.Curso;
import br.com.numbersapp.model.Pessoa;

import java.util.List;
import java.util.Optional;

public class Aplicacao {
    public static void main(String[] args) {
//        PessoaDAO pessoaDAO = new PessoaDAO();
//        Pessoa pessoa = new Pessoa();
//        pessoa.setNome("Genoveva");
//        pessoa.setCpf("333345457501");
//        pessoa.setEmail("geno@email.com");
//        pessoa.setDataintegracao(java.time.LocalDate.now());
//        pessoa.setCurso(Curso.ENGENHARIA_SOFTWARE);
//        Pessoa inserida =  pessoaDAO.save(pessoa);
//    System.out.println("Pessoa inserida (ID): "+ inserida.getId() + " Nome: " + inserida.getNome());

//        PessoaDAO pessoaDAO = new PessoaDAO();
//        List<Pessoa> pessoas = pessoaDAO.findAll();
//
//        for (Pessoa p : pessoas) {
//            p.printPessoa();
//        }

        PessoaDAO pessoaDAO = new PessoaDAO();
        Optional<Pessoa> pessoa = pessoaDAO.findById(2L);
        pessoa.ifPresent(Pessoa::printPessoa);
    }

}

