package aedii;
import java.util.Scanner;

/**
 *
 * @author Caroline e Yasmin
 */

public class AEDII {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        Grafo []grafo = new Grafo[2];
        int op;
        
        
        /*//-- Digitando manualmente o grafo --
          int numVertices; 
          System.out.print("Digite a quantidade de vertices: ");
          numVertices = entrada.nextInt();
          grafo[2] = new Grafo(numVertices); 
        */
        

        // --- INSERINDO VALORES TESTES GRAFO 2----
        grafo[0] = new Grafo(7);
        grafo[0].addAresta(1, 2, 5);
        grafo[0].addAresta(1, 3, 6);
        grafo[0].addAresta(1, 4, 10);
        grafo[0].addAresta(2, 5, 13);
        grafo[0].addAresta(3, 4, 3);
        grafo[0].addAresta(3, 5, 11);
        grafo[0].addAresta(3, 6, 6);
        grafo[0].addAresta(4, 5, 6);
        grafo[0].addAresta(4, 6, 4);
        grafo[0].addAresta(5, 7, 3);
        grafo[0].addAresta(6, 7, 8);
        // -----------------------
       
        // --- INSERINDO VALORES TESTES GRAFO 1----
        grafo[1] = new Grafo(9);
        grafo[1].addAresta(1, 2, 4);
        grafo[1].addAresta(1, 8, 9);
        grafo[1].addAresta(2, 8, 11);
        grafo[1].addAresta(2, 3, 8);
        grafo[1].addAresta(8, 9, 7);
        grafo[1].addAresta(8, 7, 1);
        grafo[1].addAresta(9, 3, 2);
        grafo[1].addAresta(9, 7, 6);
        grafo[1].addAresta(3, 4, 7);
        grafo[1].addAresta(3, 6, 4);
        grafo[1].addAresta(7, 6, 2);
        grafo[1].addAresta(4, 6, 15);
        grafo[1].addAresta(4, 5, 10);
        grafo[1].addAresta(6, 5, 11);
        // -----------------------
        
        do {                
            op = menu();
            switch (op) {
                case 0: //Encerra programa
                    System.out.println("\n\n Saindo ...\n");
                    break;
                    
                case 1: //Cria uma aresta entre dois vértices
                    int vertO, vertD, peso, op2;
                    System.out.print("Digite o vertice origem: ");
                    vertO = entrada.nextInt();
                    System.out.print("Digite o vertice destino: ");
                    vertD = entrada.nextInt();
                    System.out.print("Digite o peso da aresta: ");
                    peso = entrada.nextInt();
                    
                    System.out.print("Escolha qual grafo deseja adicionar a aresta: \n");
                    for (int i = 0; i < grafo.length; i++) {
                        System.out.println("-- " + (i+1));
                    }
                    op2 = entrada.nextInt() - 1;
                    
                    if (op2 > grafo.length && grafo[op2].addAresta(vertO, vertD, peso) == false){
                        System.out.print("\n\nErro!! Arestas invalidas");
                    }
                    break;
                    
                case 2: //Print da matriz
                    for (int i = 0; i < grafo.length; i++) {
                        System.out.print("\n\n--- Matriz de Adjacencia Grafo "+ (i+1) + "---\n\n");
                        System.out.println(grafo[i].toString());
                    }
                    break;
                    
                case 3: //Encontra o menor caminho
                    int partida, destino;
                    Dijkstra funcaoDijkstra = new Dijkstra(grafo[0]);
                    System.out.print("Digite o vertice de partida: ");
                    partida = entrada.nextInt();
                    System.out.print("Digite o vertice destino: ");
                    destino = entrada.nextInt();
                    if (funcaoDijkstra.dijkstra(partida, destino) == false){
                        System.out.print("\n\nErro!! Vértices invalidos");
                    }
                    break;
                    
                case 4:
                    for (int i = 0; i < grafo.length; i++) {
                        System.out.println("\n\nEXEMPLO " + (i + 1));
                        Kruskal funcaoKruskal = new Kruskal(grafo[i]);
                        funcaoKruskal.kruskal();
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
        System.out.println("\t 1) Adicionar arestas");
        System.out.println("\t 2) Mostrar matriz");
        System.out.println("\t 3) Calcular menor caminho Diskra");
        System.out.println("\t 4) Calcular menor caminho Kruskal");
        System.out.println("\t 0) sair");
        opMenu = entrada.nextInt();
        if (opMenu >= 0 && opMenu <= 4){
            return opMenu;
        }
        return -1;
    }
}
