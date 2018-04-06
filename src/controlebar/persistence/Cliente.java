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
    
    private String nome, cpf, genero;
    private int idade;

    public Cliente(String nome, String cpf, int idade, String genero) {
        this.nome = nome;
        setCpf(cpf);
        setIdade(idade);
        setGenero(genero);
    }

    public void setCpf(String cpf) {
        //this.cpf = cpf.length() == 11 ? cpf : null;
        if(cpf.length() != 11){
            System.out.println("CPF inválido");
        } else {
            this.cpf = cpf;
        }
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public void setGenero(String genero) {
        //this.genero = genero.equals('M') || genero.equals('H') ? genero : null;
        if(genero.equalsIgnoreCase("M") || genero.equalsIgnoreCase("H")){
            this.genero = genero;
        } else {
            System.out.println("Genero informado inválido.");
        }
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

    public String getGenero() {
        return genero;
    }

    @Override
    public String toString() {
        return "Cliente{" + "Nome=" + nome + ", CPF=" + cpf + ", Idade=" + idade + ", Genero=" + genero + '}';
    }
    
}
