/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlebar.business;

import controlebar.persistence.Cliente;
import controlebar.persistence.Socio;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author 08104810
 */
public class Bar {

    private ArrayList<Cliente> listaClientes;
    private ArrayList<Cliente> listaClientesSaida;
    private Scanner sc = new Scanner(System.in);
    private File file = new File("lista.txt");

    /**
     * Método construtor da classe Bar
     */
    public Bar() {
        listaClientes = new ArrayList<>();
        listaClientesSaida = new ArrayList<>();
    }

    /**
     * Método que faz o registro a cada cliente que entrar no bar
     */
    public void registraEntrada() {
        System.out.print("Digite o seu nome: ");
        String nome = sc.next();
        System.out.print("Digite seu CPF (apenas números): ");
        String cpf = sc.next();
        System.out.print("Digite sua idade: ");
        int idade = sc.nextInt();
        System.out.print("Digite o seu genero (H/M): ");
        String genero = sc.next();

        System.out.print("Deseja colocar no programa de milhagens (S/N)?: ");
        String resposta = sc.next();
        if (resposta.equalsIgnoreCase("s")) {
            System.out.print("Digite o número de sócio: ");
            int nroSocio = sc.nextInt();
            listaClientes.add(new Socio(nome, cpf, idade, genero, nroSocio));
        } else {
            listaClientes.add(new Cliente(nome, cpf, idade, genero));
        }
        System.out.println("");
    }

    /**
     * Método que mostra o nome dos clientes e o número de total presentes
     */
    public void exibirClientesETotalClientes() {
        if (validaLista()) {
            for (int i = 0; i < listaClientes.size(); i++) {
                System.out.println(listaClientes.get(i).toString());
            }
            System.out.println("Numero de clientes presentes: " + listaClientes.size());
            System.out.println("");
        }
    }

    /**
     * Método que pesquisa um cliente a partir do seu CPF
     */
    public void pesquisaClienteCpf() {
        if (validaLista()) {
            System.out.print("Digite o CPF (apenas números): ");
            String cpf = sc.next();
            for (Cliente c : listaClientes) {
                if (c.getCpf().equals(cpf)) {
                    System.out.println("Cliente está presente.");
                    break;
                } else {
                    System.out.println("Não há clientes com o CPF informado.");
                }
            }
            System.out.println("");
        }
    }

    /**
     * Método que exibie o percentual de homens e mulheres presentes
     */
    public void distribuicaoGenero() {
        if (validaLista()) {
            float nroM = 0, nroH = 0;
            for (Cliente c : listaClientes) {
                if (c.getGenero().equalsIgnoreCase("H")) {
                    nroH++;
                }
                if (c.getGenero().equalsIgnoreCase("m")) {
                    nroM++;
                }
            }
            float percentualHomens = (nroH / listaClientes.size()) * 100;
            float percentualMulheres = (nroM / listaClientes.size()) * 100;

            System.out.println("Percentual de homens: " + percentualHomens);
            System.out.println("Percentual de mulheres: " + percentualMulheres);
            System.out.println("");
        }
    }

    /**
     * Método que mostra quantos sócios estão presentes no momento
     */
    public void quantosSocios() {
        if (validaLista()) {
            int nroSocios = 0;
            for (Cliente c : listaClientes) {
                if (c instanceof Socio) {
                    nroSocios++;
                }
            }
            if (nroSocios >= 1) {
                System.out.println("Número de sócios presentes: " + nroSocios);
            } else {
                System.out.println("Não há sócios no momento. Apenas clientes.");
            }
            System.out.println("");
        }
    }

    /**
     * Método que registra a saída de um cliente e insere o mesmo numa nova lista para fazer balanço no final de cada dia
     */
    public void registraSaida() {
        if (validaLista()) {
            System.out.print("Digite o CPF (apenas números): ");
            String cpf = sc.next();
            for (Cliente c : listaClientes) {
                if (c.getCpf().equals(cpf)) {
                    //registraClientesArquivo();
                    listaClientesSaida.add(c);
                    listaClientes.remove(c);
                    break;
                } else {
                    System.out.println("Cliente não localizado.");
                }
            }
            System.out.println("");
        }
    }

    /**
     * Método que registra os clientes num arquivo. Ainda não está pronto
     */
    public void registraClientesArquivo() {
        try {
            ObjectOutputStream output = new ObjectOutputStream(new FileOutputStream(file));
            output.writeObject(listaClientes);
            output.writeObject(listaClientesSaida);
        } catch (IOException e) {
            System.out.println(e.toString());
        }
    }

    /**
     * Método que valida se já existe cliente na lista
     *
     * @return true se existir clientes, false se lista estiver vazia
     */
    public boolean validaLista() {
        if (listaClientes.size() > 0) {
            return true;
        } else {
            System.out.println("Não há clientes no momento.\n");
            return false;
        }
    }
}
