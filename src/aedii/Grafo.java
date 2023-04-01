/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aedii;

/**
 *
 * @author Caroline e yasmin
 */
public class Grafo {
    private int vertices;
    private int [][]matriz;
    private int [][]tabelaDeControleDijkstra; //[0]flag [1]Distancia [2]VérticeAnterior
    private static final int MAX = 2147483647;

    //Inicialização das variáveis 
    public Grafo(int vertices) {
        if (vertices < 0){ //Quantidade de vértices deve ser no mininimo 1 e no máximo 20
            this.vertices = 1;
            matriz = new int[1][1];
        } else if(vertices > 20){
            this.vertices = 20; 
            matriz = new int[20][20];
        } else{
            this.vertices = vertices;
            matriz = new int[vertices][vertices];
        }
        
        for (int i = 0; i < this.vertices; i++){ //-1 indica que não possui aresta conectando os vértices
            for (int j = 0; j < this.vertices; j++){
                this.matriz[i][j] = -1;
            }
        }
        
        this.tabelaDeControleDijkstra = new int[vertices][3]; //[0]flag [1]Distancia [2]VérticeAnterior
    }
    
    //Adiciona arestas no grafo
    public boolean addAresta(int verticeA, int verticeB, int peso){
        if (verticeA > 0 && verticeA <= vertices && verticeB > 0 && verticeB <= vertices){
            matriz[verticeA - 1][verticeB - 1] = peso;
            matriz[verticeB - 1][verticeA - 1] = peso;
            return true;
        }
        return false;
    }
    
    //Percorre os vértices até encontrar o caminho
    public boolean dijkstra(int origem, int destino){
        int indiceVertAtual = origem -1;
        
        //Testa se origem e destino estão detro dos limites
        if (origem < 1 || destino < 1 || origem > this.vertices || destino > this.vertices){
            return false;
        }
        
        //Inicializa tabela de controle 
        for (int i = 0; i < this.vertices; i++){ //[0]flag [1]Distancia [2]VérticeAnterior
            tabelaDeControleDijkstra[i][0] = -1;
            tabelaDeControleDijkstra[i][1] = MAX;
            tabelaDeControleDijkstra[i][2] = -1;
        }
        
        //.............................................................
        
        //Vértice de origem possui distancia 0 e já inicia como fechado
        tabelaDeControleDijkstra[origem - 1][0] = 1;
        tabelaDeControleDijkstra[origem - 1][1] = 0;
        tabelaDeControleDijkstra[origem - 1][2] = 0;
        
        while (!verificaFlag(destino - 1)) {  //Executa o algorítimo até encontrar o menor caminho até o vértice de destino          
            for (int i = 0; i < this.vertices; i++){ //Verifica vértices adjacentes 
                if (this.matriz[indiceVertAtual][i] != -1 && !verificaFlag(i)) { //Precisa existir uma conexão com outro vértice e a flag tem que ser 0
                    calculaDistancia(i, indiceVertAtual); 
                }
            }
            
            int indiceMenorDistancia = testaMenorCaminho(); //Testa quem é o vértice que possui o menor caminho e ativa a flag
            ativaFlag(indiceMenorDistancia); 
            indiceVertAtual = indiceMenorDistancia; //Vai para o vértice de menor caminho e repete o processo, calculando a distância entre os vértices adjacentes 
        }  
        
        //Encontrou o menor caminho
        System.out.println("\nMenor Distancia possivel: " + tabelaDeControleDijkstra[destino - 1][1]);
        mostraMenorCaminho(origem - 1, destino - 1);
        
        return true;
    }
    
    //Vértice esta fechado?
    private boolean verificaFlag(int indice){
        if (tabelaDeControleDijkstra[indice][0] == 1){
            return true;
        } else {
            return false;
        }
    }
    
    //Marca vertice como fechado
    private void ativaFlag(int indice){
        this.tabelaDeControleDijkstra[indice][0] = 1;
    }
    
    //Calcula distância do vértice até o seu adjacente, optanto pelo menor caminho
    private int calculaDistancia(int indice, int indiceVertAtual){
        int distancia = matriz[indiceVertAtual][indice] + this.tabelaDeControleDijkstra[indiceVertAtual][1];
        if (distancia < this.tabelaDeControleDijkstra[indice][1]){
                this.tabelaDeControleDijkstra[indice][1] = distancia;
                this.tabelaDeControleDijkstra[indice][2] =  indiceVertAtual;
        }
        return this.tabelaDeControleDijkstra[indice][1];
    }
    
    //Verifica quem será o próximo vértice a ser marcado
    //Condição: ter o menor caminho
    private int testaMenorCaminho(){
        int tamanhoMenorDistancia = MAX, indiceMenorDistancia = MAX;
        for (int i = 0; i < this.vertices; i++) {
            if (this.tabelaDeControleDijkstra[i][1] < MAX  && !verificaFlag(i) && this.tabelaDeControleDijkstra[i][1] < tamanhoMenorDistancia){
                tamanhoMenorDistancia = this.tabelaDeControleDijkstra[i][1];
                indiceMenorDistancia = i;
            }
        }
        return indiceMenorDistancia;
    }
    
    //Mostra o caminho realizado com o menor peso, utilizando a informação do vértice anterior
    private int mostraMenorCaminho(int indiceOrigem, int indiceDestino){
        int []caminho = new int[this.vertices];
        int vertAtual = indiceDestino;
        caminho[0] = indiceDestino + 1;
        for (int i = 1; vertAtual != indiceOrigem; i++) {
            caminho[i] = tabelaDeControleDijkstra[vertAtual][2] + 1;
            vertAtual = tabelaDeControleDijkstra[vertAtual][2];
        }
        
        System.out.print("Vertices percorridos: ");
        for (int i = this.vertices - 1; i >= 0; i--) {
            if(caminho[i] != 0){
                System.out.print(" -> " + caminho[i]);
            }
        }
        return 0;
    }
    
    @Override
    public String toString(){
        String mostraGrafo = new String();
      
        for (int i = 0; i < vertices; i++) {
            mostraGrafo += "\t";
            mostraGrafo += i + 1;
        }
        for (int i = 0; i < vertices; i++) {
            mostraGrafo += "\n";
            mostraGrafo += i + 1;
            for (int j = 0; j < vertices; j++) {
                mostraGrafo += "\t";
                if (matriz[i][j] == -1){
                    mostraGrafo += "_";
                } else{
                    mostraGrafo += matriz[i][j];
                }
            }
        }
        return mostraGrafo;
    }
}
