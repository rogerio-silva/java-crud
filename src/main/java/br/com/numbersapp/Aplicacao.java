package br.com.numbersapp;

import br.com.numbersapp.dao.PessoaDAO;
import br.com.numbersapp.model.Curso;
import br.com.numbersapp.model.Pessoa;

import java.util.List;
import java.util.Optional;

public class  Aplicacao {
    public static void main(String[] args) {
        // Teste de save -- INSERT
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Genoveva");
        pessoa.setCpf("333345457501");
        pessoa.setEmail("geno@email.com");
        pessoa.setDataintegracao(java.time.LocalDate.now());
        pessoa.setCurso(Curso.ENGENHARIA_SOFTWARE);
        Pessoa inserida =  pessoaDAO.save(pessoa);
        inserida.printPessoa();

        // Teste de update -- UPDATE
//        PessoaDAO pessoaDAO = new PessoaDAO();
//        long id0 = 1L;
//        Optional<Pessoa> pessoa = pessoaDAO.findById(id0);
//        pessoa.ifPresentOrElse(Pessoa::printPessoa, () -> System.out.println("Pessoa não encontrada pelo ID: "+ id0));
//        pessoa.ifPresent(p -> {p.setNome("João");});
//        pessoa.ifPresent(p -> {p.setSobrenome("Silva Santos");});
//        pessoa.ifPresent(p -> {p.setDataaniversario(java.time.LocalDate.of(1993, 12, 22));});
//        pessoa.map(pessoaDAO::update);
//        pessoa.ifPresentOrElse(Pessoa::printPessoa, () -> System.out.println("Pessoa não encontrada pelo ID: "+ id0));

        // Teste de delete -- DELETE
//        PessoaDAO pessoaDAO = new PessoaDAO();
//        long id0 = 1L;
//        Optional<Pessoa> pessoa = pessoaDAO.findById(id0);
//        pessoa.ifPresentOrElse(Pessoa::printPessoa, () -> System.out.println("Pessoa não encontrada pelo ID: "+ id0));
//        pessoa.ifPresent(pessoaDAO::delete);
//        pessoa = pessoaDAO.findById(id0);
//        pessoa.ifPresentOrElse(Pessoa::printPessoa, () -> System.out.println("Pessoa não encontrada pelo ID: "+ id0));


        // Teste de findAll
//        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> pessoas = pessoaDAO.findAll();

        for (Pessoa p : pessoas) {
            p.printPessoa();
        }

//        // Testes de findById, findByCpf e findByEmail
//        pessoaDAO = new PessoaDAO();
//
//        long id0 = 1L;
//        Optional<Pessoa> pessoa0 = pessoaDAO.findById(id0);
//        pessoa0.ifPresentOrElse(Pessoa::printPessoa, () -> System.out.println("Pessoa não encontrada pelo ID: "+ id0));
//
//        long id1 = 99L;
//        Optional<Pessoa> pessoa1 = pessoaDAO.findById(id1);
//        pessoa1.ifPresentOrElse(Pessoa::printPessoa, () -> System.out.println("Pessoa não encontrada pelo ID: "+ id1));
//
//        String cpf2 = "333345457501";
//        Optional<Pessoa> pessoa2 = pessoaDAO.findByCpf(cpf2);
//        pessoa2.ifPresentOrElse(Pessoa::printPessoa, () -> System.out.println("Pessoa não encontrada pelo CPF: "+ cpf2));
//
//        String cpf3 = "00100100101"; //Não existe no banco
//        Optional<Pessoa> pessoa3 = pessoaDAO.findByCpf(cpf3);
//        pessoa3.ifPresentOrElse(Pessoa::printPessoa, () -> System.out.println("Pessoa não encontrada pelo CPF: "+ cpf3));
//
//        String email4 = "pedro@email.com";
//        Optional<Pessoa> pessoa4 = pessoaDAO.findByEmail(email4);
//        pessoa4.ifPresentOrElse(Pessoa::printPessoa, () -> System.out.println("Pessoa não encontrada pelo email: "+ email4));
//
//        String email5 = "pessoainexistente@email.com"; //Não existe no banco
//        Optional<Pessoa> pessoa5 = pessoaDAO.findByEmail(email5);
//        pessoa5.ifPresentOrElse(Pessoa::printPessoa, () -> System.out.println("Pessoa não encontrada pelo email: "+ email5));
    }
}

