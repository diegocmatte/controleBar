/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlebar.tests;

import controlebar.persistence.Cliente;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author 08104810
 */
public class ClienteTest {

    @Test
    public void testeGeneroErrado(){
        Cliente cliente = new Cliente("Carlos", "12332112332", 23, "F");
        assertEquals(null, cliente.getGenero());
    }

    @Test
    public void testeGeneroCorreto(){
        Cliente cliente = new Cliente("Henrique", "14554609234", 30, "H");
        //assert não funciona com Character
        assertEquals("H", cliente.getGenero().toString());
    }

    @Test
    public void testeIdade(){
        Cliente cliente = new Cliente("Vanessa", "14325654344", 20, "M");
        assertEquals(20, cliente.getIdade());
    }

    @Test
    public void testeNome(){
        Cliente cliente = new Cliente("Gabriel", "13223143212", 33, "H");
        assertEquals("Gabriel", cliente.getNome());
    }

    @Test
    public void testeCpfIncorreto(){
        Cliente cliente = new Cliente("Ariel", "6243254", 30, "H");
        assertEquals(null, cliente.getCpf());
    }
}