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

import java.awt.event.ActionListener;
import java.awt.event.ItemListener;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.accessibility.AccessibleContext;
import javax.swing.ButtonModel;
import javax.swing.ImageIcon;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.EventListenerList;
import javax.swing.plaf.ComponentUI;

/**
 *
 * @author WE
 */
public class Altin extends ObjeSinifi {
    int random;
    public Altin() {
        aralik = 10;
        saniye = 5;
        deger = 5;
        setIcon(new ImageIcon("src/game/altin.png"));

    }

    public Altin(int random) {
        this();
        this.random = random;
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
//        try {
//            Thread.sleep(5000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Mantar.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        cik();
        Timer t1 = new Timer();
        TimerTask tt1;
        tt1 = new TimerTask() {
            @Override
            public void run() {

        cik();
            }
        ;
        };  
        t1.schedule(tt1, 5000);
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

    @Override
    public Node getCurrentNode() {
        return currentNode;
    }

    @Override
    public void setCurrentNode(Node currentNode) {
        this.currentNode = currentNode;
    }

    @Override
    public LokasyonSinifi getLokasyon() {
        return lokasyon;
    }

    @Override
    public void setLokasyon(LokasyonSinifi lokasyon) {
        this.lokasyon = lokasyon;
    }

    @Override
    public int getSaniye() {
        return saniye;
    }

    @Override
    public void setSaniye(int saniye) {
        this.saniye = saniye;
    }

    @Override
    public int getDeger() {
        return deger;
    }

    @Override
    public void setDeger(int deger) {
        this.deger = deger;
    }

    @Override
    public int getAralik() {
        return aralik;
    }

    @Override
    public void setAralik(int aralik) {
        this.aralik = aralik;
    }

    @Override
    public ButtonModel getModel() {
        return model;
    }

    @Override
    public void setModel(ButtonModel model) {
        this.model = model;
    }

    public ChangeListener getChangeListener() {
        return changeListener;
    }

    public void setChangeListener(ChangeListener changeListener) {
        this.changeListener = changeListener;
    }

    public ActionListener getActionListener() {
        return actionListener;
    }

    public void setActionListener(ActionListener actionListener) {
        this.actionListener = actionListener;
    }

    public ItemListener getItemListener() {
        return itemListener;
    }

    public void setItemListener(ItemListener itemListener) {
        this.itemListener = itemListener;
    }

    public ChangeEvent getChangeEvent() {
        return changeEvent;
    }

    public void setChangeEvent(ChangeEvent changeEvent) {
        this.changeEvent = changeEvent;
    }

    public ComponentUI getUi() {
        return ui;
    }

    public void setUi(ComponentUI ui) {
        this.ui = ui;
    }

    public EventListenerList getListenerList() {
        return listenerList;
    }

    public void setListenerList(EventListenerList listenerList) {
        this.listenerList = listenerList;
    }

    @Override
    public AccessibleContext getAccessibleContext() {
        return accessibleContext;
    }

    public void setAccessibleContext(AccessibleContext accessibleContext) {
        this.accessibleContext = accessibleContext;
    }
    
}
