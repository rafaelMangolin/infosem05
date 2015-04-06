/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimo.em.grafos;

import java.util.*;

/**
 *
 * @author rafael
 */
public class Grafo {

    private List<String> vertices;
    private List<Aresta> arestas;
    private int matriz[][];
    private Map<String, List> lista;

    public Grafo(List<String> vertices, List<Aresta> arestas) {
        this.vertices = vertices;
        this.arestas = arestas;
        this.matriz = gerarMatriz();
        this.lista = gerarLista();
    }

    public List<String> getVertices() {
        return vertices;
    }

    public void setVertices(List<String> vertices) {
        this.vertices = vertices;
    }

    public List<Aresta> getArestas() {
        return arestas;
    }

    public void setArestas(List<Aresta> arestas) {
        this.arestas = arestas;
    }

    public int[][] getMatriz() {
        return matriz;
    }

    public Map<String, List> getLista() {
        return lista;
    }
    
    public void imprimirMatriz() {
        System.out.println("Matriz de Adjacência:\n");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("     " + i);
        }
        System.out.println("");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print("______");
        }
        System.out.println("");
        for (int i = 0; i < matriz.length; i++) {
            System.out.print(i + "   |");
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.print(matriz[i][j] + "     ");
            }
            System.out.println("");
        }
    }
    
    public void imprimirLista(){
        System.out.println("Lista de adjacência:");
        System.out.println("");
        System.out.println("Vertices|           Arestas");
        System.out.println("___________________________________________________");
        for (String vertice : vertices) {
            System.out.print("   "+vertice+"    |->");
            List<String> list = lista.get(vertice);
            for (String nodo : list) {
                System.out.print("  "+nodo + "  ->");
            }
            System.out.println("||");
        }
        
    }

    private int[][] gerarMatriz() {
        int aux = this.vertices.size();
        int matriz[][] = new int[aux][aux];

        for (int i = 0; i < aux; i++) {
            for (int j = 0; j < aux; j++) {
                matriz[i][j] = 0;
            }
        }

        for (Aresta a : arestas) {
            String s = a.getX();
            String v = a.getY();
            int x = Integer.parseInt(s);
            int y = Integer.parseInt(v);
            matriz[x][y] = 1;
            matriz[y][x] = 1;
        }
        return matriz;
    }

    private Map<String, List> gerarLista() {
        Map<String, List> mAux = new HashMap<>();

        for (String vertice : vertices) {
            List<String> list = new ArrayList<>();
            for (Aresta aresta : arestas) {
                String x = aresta.getX();
                String y = aresta.getY();
                if (vertice.equals(x)) {
                    list.add(y);
                } else if (vertice.equals(y)) {
                    list.add(x);
                }
            }
            mAux.put(vertice,list);
        }
        return mAux;
    }
}
