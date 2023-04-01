/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aedii;
import java.util.Scanner;
/**
 *
 * @author carol
 */

public class AEDII {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Scanner entrada = new Scanner(System.in);
        int numVertices, op; 
        
        System.out.print("Digite a quantidade de vertices: ");
        numVertices = entrada.nextInt();
        Grafo grafo = new Grafo(numVertices);
       
        do {                
            op = menu();
            switch (op) {
                case 1:
                    int vertO, vertD, peso;
                    System.out.print("Digite o vertice origem: ");
                    vertO = entrada.nextInt();
                    System.out.print("Digite o vertice destino: ");
                    vertD = entrada.nextInt();
                    System.out.print("Digite o peso da aresta: ");
                    peso = entrada.nextInt();
                    if (grafo.addAresta(vertO, vertD, peso) == false){
                        System.out.print("\n\nErro!! Arestas invalidas");
                    }
                    break;
                case 2:
                    System.out.println(grafo.toString());
                    break;
                case 0:
                    System.out.println("\n\n Saindo ...\n");
                    break;
                default:
                    System.out.println("\n\n DIGITE UM NUMERO VALIDO!!!\n");
                    break;
            }
        } while (op != 0);
        
        
    }
    
    public static int menu(){
        Scanner entrada = new Scanner(System.in);
        int opMenu;
        System.out.println("\n\n\t===== Implementacao de Grafos =====");
        System.out.println("\t 1) Adicionar Arestas");
        System.out.println("\t 2) Mostrar dados");
        System.out.println("\t 0) sair");
        opMenu = entrada.nextInt();
        if (opMenu >= 0 && opMenu < 3){
            return opMenu;
        }
        return -1;
    }
}
