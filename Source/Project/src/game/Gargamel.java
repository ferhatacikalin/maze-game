/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;

import static game.Main.oyuncu;

import java.util.ArrayList;
import java.util.LinkedList;
import javax.swing.ImageIcon;
import javax.swing.JButton;

/**
 *
 * @author WE
 */
public class Gargamel extends DusmanSinifi {

    int birim = 2;
    Node currentNode;
    LinkedList<Node> sPath;
    ArrayList<JButton> spathElementList;

    public Gargamel(int ID, String Ad, int x, int y) {

        super(ID, Ad, x, y);

        setIcon(new ImageIcon("src/game/gargamel.png"));
        tur = DusmanSinifi.DusmanTuru.Azman;
        spathElementList = new ArrayList();

    }

    @Override
    public void moveLocation(int x, int y) {
        if (!Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(x, y)).getKomsular().isEmpty()) {
            lokasyon.setX(x);
            lokasyon.setY(y);
            setBounds(lokasyon.getX() * 50, lokasyon.getY() * 50, 50, 50);

            if (Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(x, y)).placeholder instanceof OyuncuSinifi) {

                //collision detect
//                Main.oyuncu.setSkor(Main.oyuncu.getSkor()-1);
                if (Main.oyuncu.tur == OyuncuSinifi.OyuncuTur.GSirin) {

                    Main.oyuncu.setSkor(Main.oyuncu.getSkor() - 15);
                } else if (Main.oyuncu.tur == OyuncuSinifi.OyuncuTur.TSirin) {

                    Main.oyuncu.setSkor(Main.oyuncu.getSkor() - 15);

                }

                spath_Clear();
                System.out.println("collision");
                resetlevel();
                return;
            }
            currentNode.enKisaYol.removeLast();

            currentNode.placeholder = null;
            currentNode = Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(lokasyon.getX(), lokasyon.getY()));
            currentNode.placeholder = this;
            if (!(currentNode.enKisaYol.getLast().placeholder instanceof OyuncuSinifi) || (currentNode.lokasyon.getX() == originlokasyon.getX() && currentNode.lokasyon.getX() == originlokasyon.getX())) {

                currentNode.enKisaYol.removeLast();
            }
        }

    }

    @Override
    void moveOn() {

        sPath = Map2Node.getNodeList().get(LokasyonSinifi.xy2nodeIndex(lokasyon.getX(), lokasyon.getY())).getEnKisaYol();

        if (Main.pause == false) {

            spath_Draw();
            moveLocation(currentNode.enKisaYol.getLast().lokasyon.getX(), currentNode.enKisaYol.getLast().lokasyon.getY());
        }

    }

    @Override
    public void spath_Draw() {
        spath_Clear();
        for (Node e : sPath) {
            System.out.println("x:" + e.lokasyon.getX() + "y:" + e.lokasyon.getY() + " >> ");
            JButton temp = new JButton(new ImageIcon("src/game/path.png"));
            temp.setVisible(true);
            temp.setBounds(e.lokasyon.getX() * 50 + 15, e.lokasyon.getY() * 50 + 15, 20, 20);

            spathElementList.add(temp);
            Main.harita.add(temp);

        }

        Main.harita.revalidate();
        Main.harita.repaint();

    }

    @Override
    public void spath_Clear() {
        for (JButton b : spathElementList) {
            Main.harita.remove(b);

        }
        spathElementList.clear();
        Main.harita.revalidate();
        Main.harita.repaint();
    }

    @Override
    void resetlevel() {
        currentNode.enKisaYol.clear();
        currentNode.placeholder = null;
        currentNode = Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(originlokasyon.getX(), originlokasyon.getY()));
        currentNode.placeholder = this;
        moveLocation(originlokasyon.getX(), originlokasyon.getY());
        Dijkstra.enKisayYolHesapla(Main.graph, oyuncu.currentNode);

    }
}
