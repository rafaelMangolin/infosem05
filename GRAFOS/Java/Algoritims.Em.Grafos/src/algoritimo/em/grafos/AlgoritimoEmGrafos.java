/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimo.em.grafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafael
 */
public class AlgoritimoEmGrafos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        List<String> listV = new ArrayList<>();
        for (Integer i = 0; i < 4; i++) {
            listV.add(i.toString());
        }

        
        List<Aresta> listA = new ArrayList<>();
        listA.add(new Aresta("1", "0"));
        listA.add(new Aresta("1", "2"));
        listA.add(new Aresta("1", "3"));
        listA.add(new Aresta("2", "0"));
        listA.add(new Aresta("2", "3"));
        
        
        Grafo grafo = new Grafo(listV ,listA);
        grafo.imprimirLista();
        ArvoreProfundidade arv = GrafoUtils.buscaProfundidade(grafo, "2");
        arv.imprimirCaminho("3");
    }
    
}
