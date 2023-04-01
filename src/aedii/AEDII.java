/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package aedii;
import java.util.Scanner;
/**
 *
 * @author Caroline e Yasmin
 */

public class AEDII {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        int numVertices, op; 
        
        System.out.print("Digite a quantidade de vertices: ");
        numVertices = entrada.nextInt();
        Grafo grafo = new Grafo(numVertices);
        
        // --- VALORES TESTES ----
        grafo.addAresta(1, 2, 5);
        grafo.addAresta(1, 3, 6);
        grafo.addAresta(1, 4, 10);
        grafo.addAresta(2, 5, 13);
        grafo.addAresta(3, 4, 3);
        grafo.addAresta(3, 5, 11);
        grafo.addAresta(3, 6, 6);
        grafo.addAresta(4, 5, 6);
        grafo.addAresta(4, 6, 4);
        grafo.addAresta(5, 7, 3);
        grafo.addAresta(6, 7, 8);
        // -----------------------
       
        do {                
            op = menu();
            switch (op) {
                case 0: //Encerra programa
                    System.out.println("\n\n Saindo ...\n");
                    break;
                case 1: //Cria uma aresta entre dois vértices
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
                case 2: //Print da matriz
                    System.out.println(grafo.toString());
                    break;
                case 3: //Encontra o menor caminho
                    int partida, destino;
                    System.out.print("Digite o vertice de partida: ");
                    partida = entrada.nextInt();
                    System.out.print("Digite o vertice destino: ");
                    destino = entrada.nextInt();
                    if (grafo.dijkstra(partida, destino) == false){
                        System.out.print("\n\nErro!! Vértices invalidos");
                    }
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
        System.out.println("\t 3) Calcular menor caminho");
        System.out.println("\t 0) sair");
        opMenu = entrada.nextInt();
        if (opMenu >= 0 && opMenu <= 3){
            return opMenu;
        }
        return -1;
    }
}
