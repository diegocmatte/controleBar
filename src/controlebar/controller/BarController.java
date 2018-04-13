/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlebar.controller;

import controlebar.business.Bar;
import controlebar.persistence.Cliente;
import controlebar.persistence.Socio;
import java.util.ArrayList;

/**
 *
 * @author Diego Cansi Matte <diego.cansi at ibm.com>
 */
public class BarController {

    private ArrayList<Cliente> lista;
    Bar bar;

    public BarController() {
        lista = new ArrayList<>();
    }

    public Cliente consultaCliente(String cpf) {
        for (Cliente cli : lista) {
            if (cli.getCpf().equals(cpf)) {
                return cli;
            }
        }
        return null;
    }

    public void adicionaCliente(String nome, String cpf, int idade, String genero) {
        if (lista.contains(cpf) != true) {
            lista.add(new Cliente(nome, cpf, idade, genero));
        }
    }

    public void adicionaSocio(String nome, String cpf, int idade, String genero, int nroSocio) {
        if (lista.contains(cpf) != true) {
            lista.add(new Socio(nome, cpf, idade, genero, nroSocio));
        }
    }

    public void removeCliente(String cpf) {
        for (Cliente cli : lista) {
            if (cli.getCpf().equals(cpf)) {
                lista.remove(cli);
                //break para fechar a thread do do while
                break;
            }
        }
    }

    public int numeroClientes() {
        return lista.size();
    }

    public int numeroClientesPorGenero(String genero) {
        int numeroPorGenero = 0;
        for (Cliente cli : lista) {
            if (cli.getGenero().equalsIgnoreCase(genero)) {
                numeroPorGenero++;
            }
        }
        return numeroPorGenero;
    }

    public String numeroClientesPorGeneroString() {
        float nroM = 0, nroH = 0;
        for (Cliente c : lista) {
            if (c.getGenero().equalsIgnoreCase("H")) {
                nroH++;
            }
            if (c.getGenero().equalsIgnoreCase("m")) {
                nroM++;
            }
        }
        float percentualHomens = (nroH / lista.size()) * 100;
        float percentualMulheres = (nroM / lista.size()) * 100;
        return "Homens: " + percentualHomens + "%\nMulheres: " + percentualMulheres + "%";
    }

    public boolean containsCliente(String cpf) {
        for (Cliente cli : lista) {
            if (cli.getCpf().equals(cpf)) {
                return true;
            }
        }
        return false;
    }

    public ArrayList<String> mostraClientes() {
        ArrayList<String> listaCli = new ArrayList<>();
        for (Cliente cli : lista) {
            if (cli instanceof Socio) {
                listaCli.add(cli.getNome());
            }
        }
        return listaCli;
    }

    public ArrayList<String> mostraSocios() {
        ArrayList<String> listaCli = new ArrayList<>();
        for (Cliente cli : lista) {
            if (cli instanceof Socio) {
                listaCli.add(cli.getNome());
            }
        }
        return listaCli;
    }
}
