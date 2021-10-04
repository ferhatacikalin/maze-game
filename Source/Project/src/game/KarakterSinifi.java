/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.*;

/**
 *
 * @author WE
 */
public class KarakterSinifi extends JButton {

    int ID;
    String Ad;
    LokasyonSinifi lokasyon;
    LokasyonSinifi originlokasyon;
    Node currentNode;

    enum karakterturu {
        Oyuncu,
        Dusman;
    }

    public KarakterSinifi() {
        lokasyon = new LokasyonSinifi();
        originlokasyon = new LokasyonSinifi();

    }

    public KarakterSinifi(int ID, String Ad, int x, int y) {
        this();
        this.ID = ID;
        this.Ad = Ad;
        originlokasyon.setX(x);
        originlokasyon.setY(y);
        lokasyon.setX(x);
        lokasyon.setY(y);
        setBounds(lokasyon.getX() * 50, lokasyon.getY() * 50, 50, 50);

    }

    public Graph EnKisaYol(Graph graph, Node baslangic) {
        return Dijkstra.enKisayYolHesapla(graph, baslangic);
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getAd() {
        return Ad;
    }

    public void setAd(String Ad) {
        this.Ad = Ad;
    }

    public LokasyonSinifi getLokasyon() {
        return lokasyon;
    }

    public void setLokasyon(LokasyonSinifi lokasyon) {
        this.lokasyon = lokasyon;
    }

}
