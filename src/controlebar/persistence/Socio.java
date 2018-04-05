/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlebar.persistence;

/**
 *
 * @author 08104810
 */
public class Socio extends Cliente{
    
    private int numero;
    
    public Socio(String nome, String cpf, int idade, Character genero, int numero) {
        super(nome, cpf, idade, genero);
        this.numero = numero;
    }

    public int getNumero() {
        return numero;
    }

    @Override
    public String toString() {
        return "Socio{" + "numero=" + numero + '}';
    }
    
}
