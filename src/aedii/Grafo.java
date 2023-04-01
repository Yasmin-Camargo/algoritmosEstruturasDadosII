/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package aedii;

/**
 *
 * @author carol e yasmin
 */
public class Grafo {
    private int vertices;
    private int [][]matriz;

    public Grafo(int vertices) {
        if (vertices < 0){
            this.vertices = 1;
            matriz = new int[1][1];
        } else if(vertices > 20){
            this.vertices = 20; 
            matriz = new int[20][20];
        } else{
            this.vertices = vertices;
            matriz = new int[vertices][vertices];
        }
        
        for (int i = 0; i < this.vertices; i++){
            for (int j = 0; j < this.vertices; j++){
                this.matriz[i][j] = -1;
            }
        }
        
    }

    public boolean addAresta(int verticeA, int verticeB, int peso){
        if (verticeA > 0 && verticeA <= vertices && verticeB > 0 && verticeB <= vertices){
            matriz[verticeA - 1][verticeB - 1] = peso;
            matriz[verticeB - 1][verticeA - 1] = peso;
            return true;
        }
        return false;
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
