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
public class DusmanSinifi extends KarakterSinifi {

    int DusmanID;
    String DusmanAdi;

    static enum DusmanTuru {
        Gargamel,
        Azman;
    };
    DusmanTuru tur;

    public DusmanSinifi() {
    }

    public DusmanSinifi(int ID, String Ad, int x, int y) {
        super(ID, Ad, x, y);
        this.DusmanAdi = Ad;
        this.DusmanID = ID;

    }

    public int getDusmanID() {
        return DusmanID;
    }

    public void setDusmanID(int DusmanID) {
        this.DusmanID = DusmanID;
    }

    public String getDusmanAdi() {
        return DusmanAdi;
    }

    public void setDusmanAdi(String DusmanAdi) {
        this.DusmanAdi = DusmanAdi;
    }

    public void spath_Clear() {
    }

    public void spath_Draw() {
    }

    void moveOn() {
        System.out.println("ss");
    }

    public void moveLocation(int x, int y) {
    }
        void resetlevel() {}

    public DusmanTuru getTur() {
        return tur;
    }

    public void setTur(DusmanTuru tur) {
        this.tur = tur;
    }
        
        
}
