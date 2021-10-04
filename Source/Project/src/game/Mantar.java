/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;


import java.util.Random;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author WE
 */
public class Mantar extends ObjeSinifi {
    int random;
    public Mantar() {
        aralik = 20;
        saniye = 7;
        deger = 50;
        setIcon(new ImageIcon("src/game/mantar.png"));

    }

    @Override
    public void oyuna_gir() {
        Random rand = new Random();
        

        random = rand.nextInt(Map2Node.getNodeList().size());
        while (Map2Node.NodeList.get(random).getKomsular().isEmpty() && Map2Node.NodeList.get(random).placeholder == null) {
            random = rand.nextInt(Map2Node.getNodeList().size());
        }

        setBounds(Map2Node.NodeList.get(random).lokasyon.getX() * 50, Map2Node.NodeList.get(random).lokasyon.getY() * 50, 50, 50);
     
        Map2Node.NodeList.get(random).objeholder = this;
        currentNode = Map2Node.NodeList.get(random);
        Main.harita.add(this);
        try {
            Thread.sleep(20000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Mantar.class.getName()).log(Level.SEVERE, null, ex);
        }
        cik();
    }

    @Override
    public void cik() {
        Map2Node.NodeList.get(random).objeholder=null;
        currentNode=null;
        Main.harita.remove(this);
    }

    public int getRandom() {
        return random;
    }

    public void setRandom(int random) {
        this.random = random;
    }
    
}
