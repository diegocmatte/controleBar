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
public class Cliente {
    
    private String nome, cpf;
    private int idade;
    private Character genero;

    public Cliente(String nome, String cpf, int idade, Character genero) {
        this.nome = nome;
        setCpf(cpf);
        setIdade(idade);
        setGenero(genero);
    }

    public void setCpf(String cpf) {
        this.cpf = cpf.length() == 11 ? cpf : null;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setGenero(Character genero) {
        this.genero = genero.equals('M') || genero.equals('H') ? genero : null;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public int getIdade() {
        return idade;
    }

    public Character getGenero() {
        return genero;
    }
    
    
    
}
