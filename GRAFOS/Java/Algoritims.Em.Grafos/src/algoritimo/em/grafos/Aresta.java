/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package algoritimo.em.grafos;

/**
 *
 * @author rafael
 */
public class Aresta {
    private String x;
    private String y;

    public Aresta(String x, String y) {
        this.x = x;
        this.y = y;
    }
    
    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
    
    public void imprimeArresta(){
        System.out.println("("+this.x+","+this.y+")");
    }
       
       
}
