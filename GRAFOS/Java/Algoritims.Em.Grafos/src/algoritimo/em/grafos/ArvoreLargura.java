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
public class ArvoreLargura {
    private List<Vertice> arvore = new ArrayList<>();

    public boolean addVertice(Vertice vertice){
        return arvore.add(vertice);
    }
    
    public int size(){
        return arvore.size();
    }
    
    public Vertice getVertice(String nome){
        for (Vertice vertice : arvore) {
            if(vertice.getNome().equalsIgnoreCase(nome)){
                return vertice;
            }
        }
        return null;
    }
    
    public void imprimirCaminho(String nome){
         Vertice vert = getVertice(nome);
         while(vert != null){
             System.out.print(vert.getNome()+"   ");
             vert = getVertice(vert.getPredescessor());
         }
         
    }

    public List<Vertice> getArvore() {
        return arvore;
    }
    
    
}
