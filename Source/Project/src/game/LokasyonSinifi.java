/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


/**
 *
 * @author WE
 */
public class LokasyonSinifi {

    int x, y;

    public LokasyonSinifi() {
    }

    public LokasyonSinifi(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }
    public static int xy2nodeId(int x, int y){
    
    return 13*y+x+1;
    }
     public static int xy2nodeIndex(int x, int y){
    
    return 13*y+x;
    }
}
