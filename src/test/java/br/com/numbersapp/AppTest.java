package br.com.numbersapp;

import br.com.numbersapp.dao.PessoaDAO;
import br.com.numbersapp.model.Curso;
import br.com.numbersapp.model.Pessoa;
import org.junit.jupiter.api.Test;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;


public class AppTest {

    @Test
    public void testFindAll() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        List<Pessoa> pessoas = pessoaDAO.findAll();

        // Verifique se a lista não está vazia
        assertFalse(pessoas.isEmpty());

        for (Pessoa p : pessoas) {
            // Verifique se cada pessoa na lista não é nula
            assertNotNull(p);
        }
    }

    @Test
    public void testFindById() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        long id0 = 1L;
        Optional<Pessoa> pessoa = pessoaDAO.findById(id0);

        // Verifique se a pessoa é encontrada
        assertTrue(pessoa.isPresent());

        // Verifique se o ID da pessoa é o esperado
        assertEquals(id0, pessoa.get().getId());
    }

    // Teste para o método save da classe PessoaDAO
    @Test
    public void testSave_Todos_os_campos() {
        PessoaDAO pessoaDAO = new PessoaDAO();
        Pessoa pessoa = new Pessoa();
        pessoa.setNome("Pessoa");
        pessoa.setSobrenome("Para o Teste");
        pessoa.setCpf("123.456.789-00");
        pessoa.setEmail("teste@email.com");
        pessoa.setNumerocelular("123456789");
        pessoa.setDataaniversario(LocalDate.of(2000, 1, 1));
        pessoa.setDataintegracao(LocalDate.now());
        pessoa.setCurso(Curso.ENGENHARIA_SOFTWARE);
        // Salve a pessoa
        pessoaDAO.save(pessoa);

        // Verifique se a pessoa foi salva
        assertNotNull(pessoa.getId());
    }
}

