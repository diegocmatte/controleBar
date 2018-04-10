/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlebar.business;

import controlebar.persistence.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Diego Cansi Matte <diego.cansi at ibm.com>
 */
public class BarTest {
    
    private Bar barTetste;

    public BarTest() {
        barTetste = new Bar();
    }

    /**
     * Test of registraEntrada method, of class Bar.
     */
    @Test
    public void testRegistraEntrada() {
        System.out.println("registraEntrada");
        String nome = "Joao";
        int idade = 23;
        String genero = "h";
        String cpf = "11111111111";
        Cliente c = new Cliente(nome, cpf, idade, genero);
        barTetste.registraEntrada();
        
        
    }

    /**
     * Test of exibirClientesETotalClientes method, of class Bar.
     */
    @Test
    public void testExibirClientesETotalClientes() {
        System.out.println("exibirClientesETotalClientes");
        Bar instance = new Bar();
        instance.exibirClientesETotalClientes();
        
    }

    /**
     * Test of pesquisaClienteCpf method, of class Bar.
     */
    @Test
    public void testPesquisaClienteCpf() {
        System.out.println("pesquisaClienteCpf");
        Bar instance = new Bar();
        instance.pesquisaClienteCpf();
        
    }

    /**
     * Test of distribuicaoGenero method, of class Bar.
     */
    @Test
    public void testDistribuicaoGenero() {
        System.out.println("distribuicaoGenero");
        Bar instance = new Bar();
        instance.distribuicaoGenero();
        
    }

    /**
     * Test of quantosSocios method, of class Bar.
     */
    @Test
    public void testQuantosSocios() {
        System.out.println("quantosSocios");
        Bar instance = new Bar();
        instance.quantosSocios();
        
    }

    /**
     * Test of registraSaida method, of class Bar.
     */
    @Test
    public void testRegistraSaida() {
        System.out.println("registraSaida");
        Bar instance = new Bar();
        instance.registraSaida();
        
    }

    /**
     * Test of registraClientesArquivo method, of class Bar.
     */
    @Test
    public void testRegistraClientesArquivo() {
        System.out.println("registraClientesArquivo");
        Bar instance = new Bar();
        instance.registraClientesArquivo();
        
    }

    /**
     * Test of validaLista method, of class Bar.
     */
    @Test
    public void testValidaLista() {
        System.out.println("validaLista");
        Bar instance = new Bar();
        boolean expResult = false;
        boolean result = instance.validaLista();
        assertEquals(expResult, result);
        
    }

}
