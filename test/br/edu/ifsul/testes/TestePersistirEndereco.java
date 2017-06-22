/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.testes;

import br.edu.ifsul.modelo.Endereco;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author Matheus
 * @email omatheusfreitas@gmail.com
 * @organization IFSUL - Campus Passo Fundo
 */
public class TestePersistirEndereco {

    EntityManagerFactory emf;
    EntityManager em;

    public TestePersistirEndereco() {

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
    public void testePersistirPais() {
        boolean exception = false;
        try {
            Endereco e1 = new Endereco();
            e1.setRua("Rua Andradas");
            e1.setBairro("Sao Cristovao");
            e1.setCidade("Passo Fundo");
            Endereco e2 = new Endereco();
            e2.setRua("Av Pipoca");
            e2.setBairro("Monarcas");
            e2.setCidade("Sao Paulo");

            em.getTransaction().begin();
            em.persist(e1);
            em.persist(e2);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            exception = true;

        }
        // verificando se o resultado é igual ao esperado
        Assert.assertEquals(false, exception);
    }

}
