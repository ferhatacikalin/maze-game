package game;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileNotFoundException;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.Map;
import java.util.TimerTask;
import java.util.Timer;

public class Main {

    static JFrame frame;
    static JPanel harita;
    static Graph graph;

    static OyuncuSinifi oyuncu;
    static HashMap<String, String> dosya_dusman;
    static boolean pause;
    static boolean oyunbitti;
    static ArrayList<DusmanSinifi> dusmanlar;
    static JLabel puan;
    static int harita_kaynak[][];


    public Main() {

    }

    public static void main(String[] args) throws InterruptedException, FileNotFoundException {
        dosya_dusman = new HashMap<String, String>();
        DosyaOkuma.Okuma();
        harita_kaynak = DosyaOkuma.getHarita_kaynak().clone();
        pause = true;
        oyunbitti = false;
        graph = new Graph();
        frame = new JFrame("Prolab 2-1");
        harita = new JPanel();
        dusmanlar = new ArrayList();
        Mantar mantar = new Mantar();
        ArrayList<Altin> altinlar = new ArrayList();
        Map2Node ks = new Map2Node(harita_kaynak);
        ks.parseMap();
        ks.printMap();
        Map2Node.getNodeList();
        int scaleFactor = 50;

        harita.setBounds(75, 125, 13 * scaleFactor, 11 * scaleFactor);
        harita.setBackground(Color.white);
        harita.setBorder(null);
        harita.setLayout(null);
        for (Node e : Map2Node.getNodeList()) {
            if (e.getKomsular().isEmpty()) {

                JButton temp = new JButton();
                temp.setEnabled(false);
                temp.setBounds(e.lokasyon.getX() * scaleFactor, e.lokasyon.getY() * scaleFactor, 50, 50);
                temp.setBackground(Color.yellow);
                harita.add(temp);
            }

        }
        JButton sirine = new JButton(new ImageIcon("src/game/sirine.png"));
        sirine.setEnabled(true);
        sirine.setBounds(725, 475, 50, 50);

        frame.add(sirine);
        JFrame select = new JFrame();
        JDialog player_select = new JDialog(select, "Oyuncu Seçin", true);
        player_select.setLayout(new FlowLayout());
        JButton o1 = new JButton("Gözlüklü Şirin");
        o1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oyuncu = new GSirin(0, "Gözlüklü Şirin", 6, 5);
                player_select.setVisible(false);
                select.remove(player_select);
            }
        });
        JButton o2 = new JButton("Tembel Şirin");
        o2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                oyuncu = new TSirin(0, "Tembel Şirin", 6, 5);
                player_select.setVisible(false);
                select.remove(player_select);
            }
        });

        player_select.add(o1);
        player_select.add(o2);
        player_select.setLocationRelativeTo(null);
        player_select.setSize(300, 100);
        player_select.setVisible(true);

        oyuncu.currentNode = Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(6, 5));
        oyuncu.currentNode.placeholder = oyuncu;
        oyuncu.moveLocation(oyuncu.originlokasyon.getX(), oyuncu.originlokasyon.getY());
        System.out.println(Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(6, 5)).placeholder.Ad);
        harita.add(oyuncu);

        JLabel puanui = new JLabel("PUAN:");
        puanui.setFont(new Font("Arial", Font.BOLD, 32));
        puanui.setForeground(Color.ORANGE);
        puanui.setBounds(75, 10, 200, 100);
        frame.add(puanui);
        puan = new JLabel(Integer.toString(1));
        puan.setFont(new Font("Arial", Font.BOLD, 32));
        puan.setForeground(Color.ORANGE);
        puan.setBounds(175, 10, 200, 100);
        frame.add(puan);
//        gg = new Gargamel(1, "Gargamel", 3, 0);

        HashMap<String, int[]> kapi = new HashMap<String, int[]>();

        kapi.put("A", new int[]{3, 0});

        kapi.put("B", new int[]{10, 0});
        kapi.put("C", new int[]{0, 5});
        kapi.put("D", new int[]{3, 10});

//        dosya_dusman.put("Azman", "A");
//        dosya_dusman.put("Gargamel", "B");
        int id = 0;
        for (Map.Entry m : dosya_dusman.entrySet()) {
            String d = m.getValue().toString();
            String k = m.getKey().toString();
            System.out.println(kapi.get(k)[0] + " " + kapi.get(k)[1]);
            if (d.equals("Azman")) {
                System.out.println(d);
                Azman temp = new Azman(id, "Azman", kapi.get(k)[0], kapi.get(k)[1]);
                temp.currentNode = Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(kapi.get(k)[0], kapi.get(k)[1]));
                temp.currentNode.placeholder = temp;
                dusmanlar.add(temp);
            } else if (d.equals("Gargamel")) {
                Gargamel temp = new Gargamel(id, "Gargamel", kapi.get(k)[0], kapi.get(k)[1]);
                temp.currentNode = Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(kapi.get(k)[0], kapi.get(k)[1]));
                temp.currentNode.placeholder = temp;
                dusmanlar.add(temp);
            }
            id++;
        }
//        System.out.println(Map2Node.NodeList.get(LokasyonSinifi.xy2nodeIndex(3, 0)).getEnKisaYol());
        for (DusmanSinifi d : dusmanlar) {
            harita.add(d);

        }

        harita.setComponentZOrder(oyuncu, 0);

        frame.add(harita);

        frame.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {
                String c = KeyEvent.getKeyText(e.getKeyCode());
//                System.out.println("Key Typed: " + c);

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (pause == true) {
//                    spath_Draw();
                    pause = false;
                }
                String c = KeyEvent.getKeyText(e.getKeyCode());
//                System.out.println("Key Pressed: " + c + " " + e.getKeyCode());
                if (e.getKeyCode() == 38 && oyuncu.getBounds().y > 0) {
                    //up  
//                    oy.setBounds(oy.getBounds().x, oy.getBounds().y - 50, 50, 50);
                    oyuncu.moveUp();
                }
                if (e.getKeyCode() == 40 && oyuncu.getBounds().y < 500) {
                    //down
//                    oy.setBounds(oy.getBounds().x, oy.getBounds().y + 50, 50, 50);
                    oyuncu.moveDown();
                }
                if (e.getKeyCode() == 39 && oyuncu.getBounds().x < 600) {
                    //right
//                    oy.setBounds(oy.getBounds().x + 50, oy.getBounds().y, 50, 50);
                    oyuncu.moveRigth();
                }
                if (e.getKeyCode() == 37 && oyuncu.getBounds().x > 0) {
                    //left
//                    oy.setBounds(oy.getBounds().x - 50, oy.getBounds().y, 50, 50);
                    oyuncu.moveLeft();
                }

            }

            @Override
            public void keyReleased(KeyEvent e) {
                String c = KeyEvent.getKeyText(e.getKeyCode());
//    System.out.println("Key Released: " + c);
//...
            }
        });

        frame.setSize(16 * scaleFactor, 16 * scaleFactor);
        frame.setResizable(false);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setFocusable(true);
        frame.setVisible(true);
        Timer t = new Timer();
        TimerTask tt;
        tt = new TimerTask() {
            @Override
            public void run() {
                   if (pause == false) {

                mantar.oyuna_gir();
                   }
            }
        ;
        };  
        t.schedule(tt, 2000, 17000);
        for (int i = 0; i < 5; i++) {
            Altin temp = new Altin();
            altinlar.add(temp);
        }
        Timer t1 = new Timer();
        TimerTask tt1;
        tt1 = new TimerTask() {
            @Override
            public void run() {
                if (pause == false) {

                    altinlar.get(0).oyuna_gir();
                    altinlar.get(1).oyuna_gir();
                    altinlar.get(2).oyuna_gir();
                    altinlar.get(3).oyuna_gir();
                    altinlar.get(4).oyuna_gir();
                }

            }
        ;
        };  
        t1.schedule(tt1, 2000, 10000);

//        int i=0;
//        for (i = 0; i < 5; i++) {
//                    Timer t1 = new Timer();
//        TimerTask tt1;
//        tt1 = new TimerTask() {
//            @Override
//            public void run() {
//                if(altinlar)
//            }
//        ;
//        };  
//        t1.schedule(tt1, 2000, 5000);
//        }
        while (oyuncu.getSkor() > 0 && oyunbitti == false) {
            System.out.println("game loop");
            try {

                for (DusmanSinifi d : dusmanlar) {
                    d.moveOn();
                }

                oyuncu.PuaniGoster();

            } catch (Exception e) {

            }
            Thread.sleep(600);
        }
        if (oyuncu.getSkor() <= 0) {
            JOptionPane.showMessageDialog(frame, "<html><font color=#FF0000 size=72>Kaybettiniz !!!</font></html>", "prolab-2", JOptionPane.PLAIN_MESSAGE);

        } else {
            JOptionPane.showMessageDialog(frame, "<html><font color=#008000	 size=72>Kazandınız !!!</font></html>", "prolab-2", JOptionPane.PLAIN_MESSAGE);

        }
        System.exit(0);
    }

    static void setPuandurumu(int p) {
        puan.setText(Integer.toString(p));
        frame.revalidate();
        frame.repaint();
    }

    public static int[][] getHarita_kaynak() {
        return harita_kaynak;
    }

    public static void setHarita_kaynak(int[][] harita_kaynak) {
        Main.harita_kaynak = harita_kaynak;
    }
    

}
