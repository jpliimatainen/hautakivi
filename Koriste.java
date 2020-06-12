/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.io.Serializable;

/**
 *
 * @author Juha-Pekka
 */
public class Koriste  implements Serializable {

    private int koristeKierto;
    private int koristePinossa;
    private int koristeKorkeus;
    private int koristeLeveys;
    private int koristeX;
    private int koristeY;
    private int koristeIndex;
    private String koristeLabelType;
        
    public Koriste() {
        koristeKierto = 0;
        koristePinossa = 0;
        koristeKorkeus = 0;
        koristeLeveys = 0;
        koristeX = 0;
        koristeY = 0;
        koristeIndex = -1;
    }
    
    public int getKoristeKierto() {
        return this.koristeKierto;
    }
    
    public void setKoristeKierto(int koristeKierto) {
        this.koristeKierto = koristeKierto;
    }
    
    public int getKoristePinossa() {
        return this.koristePinossa;
    }
    
    public void setKoristePinossa(int koristePinossa) {
        this.koristePinossa = koristePinossa;
    }
    
    public int getKoristeKorkeus() {
        return this.koristeKorkeus;
    }
    
    public void setKoristeKorkeus(int koristeKorkeus) {
        this.koristeKorkeus = koristeKorkeus;
    }
    
    public int getKoristeLeveys() {
        return this.koristeLeveys;
    }
    
    public void setKoristeLeveys(int koristeLeveys) {
        this.koristeLeveys = koristeLeveys;
    }
    
    public int getKoristeX() {
        return this.koristeX;
    }
    
    public void setKoristeX(int koristeX) {
        this.koristeX = koristeX;
    }
    
    public int getKoristeY() {
        return this.koristeY;
    }
    
    public void setKoristeY(int koristeY) {
        this.koristeY = koristeY;
    }
    
    public int getKoristeIndex() {
        return this.koristeIndex;
    }
    
    public void setKoristeIndex(int koristeIndex) {
        this.koristeIndex = koristeIndex;
    }
    
    public String getKoristeLabelType() {
        return this.koristeLabelType;
    }
    
    public void setKoristeLabelType(String koristeLabelType) {
        this.koristeLabelType = koristeLabelType;
    }
}