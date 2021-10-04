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
public class OyuncuSinifi extends KarakterSinifi {

    int OyuncuID;
    int Skor;
    String OyuncuAdi;
    static enum OyuncuTur{
        GSirin,
        TSirin;
    }
    OyuncuTur tur;

    public OyuncuSinifi() {
    }
    

    public OyuncuSinifi(int ID, String Ad, int x, int y) {
        super(ID, Ad,x,y);
        this.OyuncuAdi = Ad;
        this.OyuncuID = ID;
        Skor=20;

    }

    public void PuaniGoster() {
        System.out.println(Skor);
    }

    public  int getSkor() {
        return Skor;
    }

    public  void setSkor(int s) {
       Skor = s;
    }

    public int getOyuncuID() {
        return OyuncuID;
    }

    public void setOyuncuID(int OyuncuID) {
        this.OyuncuID = OyuncuID;
    }

    public String getOyuncuAdi() {
        return OyuncuAdi;
    }

    public void setOyuncuAdi(String OyuncuAdi) {
        this.OyuncuAdi = OyuncuAdi;
    }

    public void moveLocation(int x, int y) {

    }

    public void moveLeft() {

    }

    public void moveRigth() {

    }

    public void moveUp() {

    }

    public void moveDown() {

    }
    public void updateGraph(){
    
    
    }

    public OyuncuTur getTur() {
        return tur;
    }

    public void setTur(OyuncuTur tur) {
        this.tur = tur;
    }

    
}
