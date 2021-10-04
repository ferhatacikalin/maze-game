/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import javax.swing.ImageIcon;

/**
 *
 * @author WE
 */
public class GSirin extends OyuncuSinifi {

    int birim = 2;

    public GSirin(int ID, String Ad, int x, int y) {
        super(ID, Ad, x, y);
        setIcon(new ImageIcon("src/game/gozluklu.png"));
        tur = OyuncuTur.GSirin;
    }

    @Override
    public void PuaniGoster() {

        Main.setPuandurumu(getSkor());
    }

    @Override
    public void moveLocation(int x, int y) {
        if (!Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(x, y)).getKomsular().isEmpty()) {

            if (Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(x, y)).placeholder instanceof DusmanSinifi) {

                //collision detect
//                setSkor(getSkor()-1);
                System.out.println("collision");

            } else {
                lokasyon.setX(x);
                lokasyon.setY(y);
                setBounds(lokasyon.getX() * 50, lokasyon.getY() * 50, 50, 50);
                if (lokasyon.getX() == 12 && lokasyon.getY() == 7) {
                    Main.oyunbitti = true;

                }
                if (Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(x, y)).objeholder instanceof Mantar) {

                    setSkor(getSkor() + 50);
                    Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(x, y)).objeholder.cik();
                    System.out.println("mantar");
                }
                if (Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(x, y)).objeholder instanceof Altin) {

                    setSkor(getSkor() + 5);
                    Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(x, y)).objeholder.cik();
                    System.out.println("Altin");
                }
            }

        }

        currentNode.placeholder = null;
        Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(lokasyon.getX(), lokasyon.getY())).placeholder = this;
        currentNode = Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(lokasyon.getX(), lokasyon.getY()));
        updateGraph();

    }

    @Override
    public void updateGraph() {
        System.out.println("currentnode: " + currentNode.getIsim());

        Dijkstra.enKisayYolHesapla(Main.graph, currentNode);
//        System.out.println("--------");
//        for (Node e : Map2Node.getNodeList().get(LokasyonSinifi.xy2nodeIndex(3, 0)).getEnKisaYol()) {
//            System.out.println("x:" + e.lokasyon.getX() + "y:" + e.lokasyon.getY() + " >> ");
//
//        }

    }

    @Override
    public void moveLeft() {
        for (int i = 0; i < birim; i++) {
            moveLocation(lokasyon.getX() - 1, lokasyon.getY());
            Main.harita.add(this);
        }
//        currentNode.placeholder = null;
//        currentNode = Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(lokasyon.getX(), lokasyon.getY()));
//        currentNode.placeholder = this;
//        updateGraph();
    }

    @Override
    public void moveRigth() {
        for (int i = 0; i < birim; i++) {
            moveLocation(lokasyon.getX() + 1, lokasyon.getY());
            Main.harita.add(this);
        }
//        currentNode.placeholder = null;
//        Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(lokasyon.getX(), lokasyon.getY())).placeholder = this;
//        currentNode = Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(lokasyon.getX(), lokasyon.getY()));
//        updateGraph();
    }

    @Override
    public void moveUp() {
        for (int i = 0; i < birim; i++) {
            moveLocation(lokasyon.getX(), lokasyon.getY() - 1);
            Main.harita.add(this);
        }
//        currentNode.placeholder = null;
//        Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(lokasyon.getX(), lokasyon.getY())).placeholder = this;
//        currentNode = Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(lokasyon.getX(), lokasyon.getY()));
//        updateGraph();
    }

    @Override
    public void moveDown() {
        for (int i = 0; i < birim; i++) {
            moveLocation(lokasyon.getX(), lokasyon.getY() + 1);
            Main.harita.add(this);
        }
//        currentNode.placeholder = null;
//        Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(lokasyon.getX(), lokasyon.getY())).placeholder = this;
//        currentNode = Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(lokasyon.getX(), lokasyon.getY()));
//        updateGraph();
    }

}
