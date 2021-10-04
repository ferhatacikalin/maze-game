/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package game;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class Node {
    LokasyonSinifi lokasyon;
    public int id;
    KarakterSinifi placeholder;
    ObjeSinifi objeholder;
    public LinkedList<Node> enKisaYol = new LinkedList<>();

    public Integer uzaklik = Integer.MAX_VALUE;

    public Map<Node, Integer> komsular = new HashMap<>();

    public Node(int id,int x, int y) {
        placeholder=null;
        lokasyon= new LokasyonSinifi(x,y);
        this.id = id;
    }

    public void komsuEkle(Node komsu, int uzaklık) {
        komsular.put(komsu, uzaklık);
        
    }

    public int getIsim() {
        return id;
    }

    public void setIsim(int id) {
        this.id = id;
    }

    public LinkedList<Node> getEnKisaYol() {
        return enKisaYol;
    }

    public void setEnKisaYol(LinkedList<Node> n) {
      
       enKisaYol = n;
    }

    public Integer getUzaklik() {
        return uzaklik;
    }

    public void setUzaklik(Integer uzaklik) {
        this.uzaklik = uzaklik;
    }

    public Map<Node, Integer> getKomsular() {
        return komsular;
    }

    public void setKomsular(Map<Node, Integer> komsular) {
        this.komsular = komsular;
    }

    public LokasyonSinifi getLokasyon() {
        return lokasyon;
    }

    public int getId() {
        return id;
    }

    public KarakterSinifi getPlaceholder() {
        return placeholder;
    }

   
}