/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.JButton;

/**
 *
 * @author WE
 */
public class ObjeSinifi extends JButton {
     Node currentNode;
    LokasyonSinifi lokasyon;
    int saniye;
    int deger;
    int aralik;
    public ObjeSinifi() {
        
    }
    public void oyuna_gir(){
    
    }
       public void cik() {}

    public Node getCurrentNode() {
        return currentNode;
    }

    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    public LokasyonSinifi getLokasyon() {
        return lokasyon;
    }

    public void setLokasyon(LokasyonSinifi lokasyon) {
        this.lokasyon = lokasyon;
    }

    public int getSaniye() {
        return saniye;
    }

    public void setSaniye(int saniye) {
        this.saniye = saniye;
    }

    public int getDeger() {
        return deger;
    }

    public void setDeger(int deger) {
        this.deger = deger;
    }

    public int getAralik() {
        return aralik;
    }

    public void setAralik(int aralik) {
        this.aralik = aralik;
    }
       
}
