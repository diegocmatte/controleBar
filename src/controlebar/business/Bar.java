/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlebar.business;


import controlebar.persistence.Cliente;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 08104810
 */
public class Bar {
    
    private ArrayList<Cliente> listaClientes;

    public Bar(ArrayList<Cliente> listaClientes) {
        listaClientes = new ArrayList<>();
    }
    
    public void entraBar(){
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite o seu nome: ");
        String nome = sc.next();
        System.out.print("Digite seu CPF (apenas números): ");
        String cpf = sc.next();
        System.out.print("Digite sua idade: ");
        int idade = sc.nextInt();
        System.out.print("Digite o seu genero (H ou M): ");
        Character genero = sc.next().charAt(0);
        
        listaClientes.add(new Cliente(nome, cpf, idade, genero));    
    }
    
    public void exibirClientesETotalClientes(){
        for (int i = 0; i < listaClientes.size(); i++) {
            System.out.print(listaClientes.get(i).toString());
        }
        System.out.print("Numero de clientes presentes: "+listaClientes.size());
    }
    
    public void pesquisaClienteCpf(String cpf){
        for (Cliente c : listaClientes) {
            if(c.getCpf().equals(cpf)){
                System.out.println("Cliente está presente.");
                break;
            } else {
                System.out.println("Não há clientes com o CPF informado.");
            }
        }
    }
    
    public void distribuicaoGenero(){
        int m = 0, h = 0;
        for (Cliente c : listaClientes) {
            if(c.getGenero().equals('H')){
                h++;
            } else {
                m++;
            }
        }        
    }
}