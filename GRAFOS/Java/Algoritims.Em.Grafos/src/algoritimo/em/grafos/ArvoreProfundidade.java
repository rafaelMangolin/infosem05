/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimo.em.grafos;

import java.util.ArrayList;
import java.util.List;

public class ArvoreProfundidade {
    List<Vertice> list = new ArrayList<>();
    List<Aresta> retorno = new ArrayList<>();
    List<Aresta> avanco = new ArrayList<>();
    List<Aresta> cruzamento = new ArrayList<>();

    
    public boolean addVertice(Vertice vertice){
        
        if(getVertice(vertice.getNome()) == null){
            return list.add(vertice);
        }
        return false;
    }
    
    public boolean addArestaRetorno(Aresta arest){
        return retorno.add(arest);
    }
    
    public boolean addArestaAvanco(Aresta arest){
        return avanco.add(arest);
    }
    
    public boolean addArestaCruzamento(Aresta arest){
        return cruzamento.add(arest);
    }
    
    public Vertice getVertice(String nome){
        for (Vertice vertice : list) {
            if(vertice.getNome().equalsIgnoreCase(nome)){
                return vertice;
            }
        }
        return null;
    }
    
    public Vertice getVertice(int index){
        return list.get(index);
    }
    
    public void imprimirCaminho(String nome){
         Vertice vert = getVertice(nome);
         while(vert != null){
             System.out.print(vert.getNome()+"   ");
             vert = getVertice(vert.getPredescessor());
         }
         
    }

    public List<Vertice> getList() {
        return list;
    }
    
    
}
