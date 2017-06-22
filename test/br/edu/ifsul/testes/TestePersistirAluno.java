package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Aluno;
import br.edu.ifsul.modelo.Endereco;
import java.util.Calendar;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Matheus
 * @email omatheusfreitas@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestePersistirAluno {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirAluno() {

    }

    @Before
    public void setUp() {
        emf = Persistence.createEntityManagerFactory("TrabalhoTAModeloPU");
        em = emf.createEntityManager();
    }

    @After
    public void tearDown() {
        em.close();
        emf.close();
    }

    @Test
    public void testePersistirAluno() {
        boolean exception = false;
        try {
            Aluno obj = new Aluno();
            obj.setNome("Maria");
            obj.setEmail("Maria@gmail.com");
            obj.setNascimento(Calendar.getInstance());

            Endereco e = em.find(Endereco.class, "Rua Andradas");
            obj.getEnderecos().add(e);
            em.getTransaction().begin();
            em.persist(obj);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;

        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}
