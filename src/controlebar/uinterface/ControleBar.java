/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlebar.uinterface;

import controlebar.business.Bar;
import java.util.Scanner;

/**
 *
 * @author 08104810
 */
public class ControleBar {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner sc = new Scanner(System.in);
        Bar bar = new Bar();
        int opcao;
        String cpf;
        
        do{
            System.out.println("--- Menu de opções ---");
            System.out.println("1 - Registrar entrada de cliente");
            System.out.println("2 - Pesquiar cliente por CPF");
            System.out.println("3 - Exibir sócios presentes");
            System.out.println("7 - Exibir clientes presentes");
            System.out.println("8 - Registrar saída de cliente");
            System.out.println("9 - Sair do sistema");
            System.out.println("---------");
            System.out.print("Digite a sua opção: ");
            opcao = sc.nextInt();
            System.out.print("---------\n\n");
            
            switch(opcao){
                case 1:
                    bar.registraEntrada();
                    break;
                case 2:
                    System.out.print("Digite o cpf (somente números): ");
                    cpf = sc.next();
                    bar.pesquisaClienteCpf(cpf);
                    break;
                case 3:
                    bar.quantosSocios();
                    break;
                case 7:
                    bar.exibirClientesETotalClientes();
                    break;
                case 8:
                    System.out.print("Digite o CPF (apenas números): ");
                    cpf = sc.next();
                    bar.registraSaida(cpf);
                case 9:
                    System.out.println("--- Fim da execução ---");
                    System.exit(opcao);
                    break;
                default:
                    System.out.println("Opção inválida!");
                    break;
            }
        } while (opcao !=0);
    }
    
}
