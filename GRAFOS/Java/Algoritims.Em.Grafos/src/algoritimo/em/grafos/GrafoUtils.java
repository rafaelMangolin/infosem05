package algoritimo.em.grafos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author rafael
 */
public class GrafoUtils {
    
    //Algoritmos usados para a busca em largura
    
    public static ArvoreLargura buscaEmLargura(Grafo g, String verticeInicial) {
        ArvoreLargura arvoreBusca = new ArvoreLargura();
        List<Vertice> list = new ArrayList<>();
        List<Vertice> listAdjacentes;
        Vertice verticeAux;

        for (String vertice : g.getVertices()) {
            arvoreBusca.addVertice(new Vertice(vertice));
        }
        verticeAux = arvoreBusca.getVertice(verticeInicial);
        setarCinzaLargura(verticeAux, 0, null);
        list.add(verticeAux);

        while (!list.isEmpty()) {
            verticeAux = list.remove(0);
            listAdjacentes = converteVerticeLargura(g.getLista().get(verticeAux.getNome()), arvoreBusca);
            for (Vertice vert : listAdjacentes) {
                if (vert.getEstado() == 1) {
                    setarCinzaLargura(vert, (verticeAux.getDistancia()+1), verticeAux.getNome());
                    list.add(vert);
                }
            }
            verticeAux.setEstado(3);

        }
        return arvoreBusca;
    }

    private static List<Vertice> converteVerticeLargura(List<String> list, ArvoreLargura arvore) {
        List<Vertice> v = new ArrayList<>();
        for (String list1 : list) {
            v.add(arvore.getVertice(list1));
        }
        return v;
    }

    private static void setarCinzaLargura(Vertice vert, int distancia, String pred) {
        vert.setEstado(2);
        vert.setDistancia(distancia);
        vert.setPredescessor(pred);
    }
    // Final dos métodos utilizados para a Busca em largura
    public static ArvoreProfundidade buscaProfundidade(Grafo g, String verticeInicial){
        ArvoreProfundidade arvoreProfundidade = new ArvoreProfundidade();
        List<Vertice> list = new ArrayList<>();
        List<Vertice> listAdjacentes;
        Integer tempo;
        
        arvoreProfundidade.addVertice(new Vertice(verticeInicial));
        for (String vertice : g.getVertices()) {
            arvoreProfundidade.addVertice(new Vertice(vertice));
        }
        tempo = 0;
        for (Vertice vertice : arvoreProfundidade.getList()) {
            if(vertice.getEstado() == 1){
                recBuscaProfundidade(g, arvoreProfundidade, tempo, vertice, null);
            }
        }
        return arvoreProfundidade;
    }
    
    private static void recBuscaProfundidade(Grafo g, ArvoreProfundidade a, Integer tempo, Vertice vert, String pred){
        List<Vertice> listAdjacentes;
        
        setarCinzaLargura(vert, tempo, pred);
        tempo++;
        
        listAdjacentes = converteVerticeProfundidade(g.getLista().get(vert.getNome()), a);
        
        for (Vertice vertAux : listAdjacentes) {
            if(vertAux.getEstado() == 1){
                recBuscaProfundidade(g, a, tempo, vertAux, vert.getNome());
            }else if(vertAux.getEstado() == 2){
                a.addArestaRetorno(new Aresta(vert.getNome(), vertAux.getNome()));
            }else if(vertAux.getEstado() == 3){
                if(vertAux.getTempoSaida() > vert.getTempoEntrada()){
                    a.addArestaAvanco(new Aresta(vert.getNome(), vertAux.getNome()));
                }else if(vertAux.getTempoSaida() < vert.getTempoEntrada()){
                    a.addArestaCruzamento(new Aresta(vert.getNome(), vertAux.getNome()));
                }
            }
        }
        setarPretoProfundade(vert, tempo);
    }
    
    private static List<Vertice> converteVerticeProfundidade(List<String> list, ArvoreProfundidade arvore) {
        List<Vertice> v = new ArrayList<>();
        for (String list1 : list) {
            v.add(arvore.getVertice(list1));
        }
        return v;
    }
    
    private void setarCinzaProfundidade(Vertice vert, int tempo, String pred){
        vert.setEstado(2);
        vert.setPredescessor(pred);
        vert.setTempoEntrada(tempo);
    }
    
    private static void setarPretoProfundade(Vertice vert, int tempo){
        vert.setEstado(3);
        vert.setTempoSaida(tempo);
    }
}
