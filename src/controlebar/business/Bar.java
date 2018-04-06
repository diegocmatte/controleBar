/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlebar.business;

import controlebar.persistence.Cliente;
import controlebar.persistence.Socio;
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

    public void registraEntrada() {
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

    public void exibirClientesETotalClientes() {
        if (listaClientes.size() <= 0) {
            System.out.print("não há clientes no momento.");
        } else {
            for (int i = 0; i < listaClientes.size(); i++) {
                System.out.print(listaClientes.get(i).toString());
            }
            System.out.print("Numero de clientes presentes: " + listaClientes.size());
        }
    }

    public void pesquisaClienteCpf(String cpf) {
        for (Cliente c : listaClientes) {
            if (c.getCpf().equals(cpf)) {
                System.out.println("Cliente está presente.");
                break;
            } else {
                System.out.println("Não há clientes com o CPF informado.");
            }
        }
    }

    public void distribuicaoGenero() {
        int nroM = 0, nroH = 0;
        for (Cliente c : listaClientes) {
            if (c.getGenero().equals('H')) {
                nroH++;
            } else {
                nroM++;
            }
        }
        float percentualHomens = (float) nroH / listaClientes.size();
        float percentualMulheres = (float) nroM / listaClientes.size();

        System.out.print("Percentual de homens: " + percentualHomens);
        System.out.println("Percentual de mulheres: " + percentualMulheres);
    }

    public void quantosSocios() {
        int nroSocios = 0;
        for (Cliente c : listaClientes) {
            if (c instanceof Socio) {
                nroSocios++;
            }
        }
        if (nroSocios >= 1) {
            System.out.print("Número de sócios presentes: " + nroSocios);
        } else {
            System.out.print("Não há sócios no momento.");
        }
    }

    public void registraSaida() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite seu CPF (apenas números): ");
        String cpf = sc.next();
        for (Cliente c : listaClientes) {
            if (c.getCpf().equals(cpf)) {
                listaClientes.remove(c);
                break;
            } else {
                System.out.print("Cliente não localizado");
            }
        }
    }
    
    public void registraClientesArquivo(){
        
    }
}
