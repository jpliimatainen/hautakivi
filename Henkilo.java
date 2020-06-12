/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Color;
import java.io.Serializable;

/**
 *
 * @author Juha-Pekka
 */
public class Henkilo  implements Serializable {
          
    public enum Tasaus {
	VASEN, KESKITETTY, OIKEA
    }
    
    private String vapaaTeksti;
    private String etunimet;
    private String os;
    private String syntymaAika;
    private String kuolinAika;
    private float fontWidth;
    private Tasaus tasaus;
    private boolean henkiloKaiverrettu;
    private Color fontColor;
    private float vapaaTekstiFontSize;
    private float etunimetFontSize;
    private float osFontSize;
    private float syntymaJaKuolinAikaFontSize;
    private int fontIndex;
    private float henkiloMetallikirjasinVapaaTekstiKoko;
    private float henkiloMetallikirjasinEtunimetKoko;
    private float henkiloMetallikirjasinOsKoko;
    private float henkiloMetallikirjasinSyntymaJaKuolinAikaKoko;
    private String henkiloMetallikirjasinTyyppi;
    private String henkiloMetallikirjasinAlaTyyppi;
    private int henkiloX;
    private int henkiloY;
        
    public Henkilo(String vapaaTeksti, String etunimet, String os, String syntymaAika, String kuolinAika) {
        this.vapaaTeksti = vapaaTeksti;
        this.etunimet = etunimet;
        this.os = "";
        this.syntymaAika = syntymaAika;
        this.kuolinAika = kuolinAika;
        this.fontWidth = 0f;
        this.tasaus = Tasaus.KESKITETTY;
        this.henkiloKaiverrettu = true;
        this.fontColor = new Color(238, 232, 170);
        this.vapaaTekstiFontSize = 20f;
        this.etunimetFontSize = 20f;
        this.osFontSize = 20f;
        this.syntymaJaKuolinAikaFontSize = 20f;
        this.fontIndex = 4;
        this.henkiloMetallikirjasinVapaaTekstiKoko = 0.03f;
        this.henkiloMetallikirjasinEtunimetKoko = 0.03f;
        this.henkiloMetallikirjasinOsKoko = 0.03f;
        this.henkiloMetallikirjasinSyntymaJaKuolinAikaKoko = 0.03f;
        this.henkiloMetallikirjasinTyyppi = "";
        this.henkiloMetallikirjasinAlaTyyppi = "";
        this.henkiloX = 0;
        this.henkiloY = 0;
    }
        
    public Henkilo() {
        this.vapaaTeksti = "";
        this.etunimet = "";
        this.os = "";
        this.syntymaAika = "";
        this.kuolinAika = "";
        this.fontWidth = 0f;
        this.tasaus = Tasaus.KESKITETTY;
        this.henkiloKaiverrettu = true;
        this.fontColor = new Color(238, 232, 170);
        this.vapaaTekstiFontSize = 20f;
        this.etunimetFontSize = 20f;
        this.osFontSize = 20f;
        this.syntymaJaKuolinAikaFontSize = 20f;
        this.fontIndex = 4;
        this.henkiloMetallikirjasinVapaaTekstiKoko = 0.03f;
        this.henkiloMetallikirjasinEtunimetKoko = 0.03f;
        this.henkiloMetallikirjasinOsKoko = 0.03f;
        this.henkiloMetallikirjasinSyntymaJaKuolinAikaKoko = 0.03f;
        this.henkiloMetallikirjasinTyyppi = "";
        this.henkiloMetallikirjasinAlaTyyppi = "";
        this.henkiloX = 0;
        this.henkiloY = 0;
    }
    
    public boolean isHenkiloKaiverrettu() {
        return this.henkiloKaiverrettu;
    }
    
    public void setHenkiloKaiverrettu(boolean henkiloKaiverrettu) {
        this.henkiloKaiverrettu = henkiloKaiverrettu;
    }
    
    public Tasaus getTasaus() {
        return this.tasaus;
    }
    
    public void setTasaus(Tasaus tasaus) {
        this.tasaus = tasaus;
    }
    
    public String getVapaaTeksti() {
        return this.vapaaTeksti;
    }
        
    public String getEtunimet() {
        return this.etunimet;
    }
        
    public String getOs() {
        return this.os;
    }
        
    public String getSyntymaAika() {
        return this.syntymaAika;
    }
    
    public String getKuolinAika() {
        return this.kuolinAika;
    }
        
    public void setKuolinAika(String kuolinAika) {
        this.kuolinAika = kuolinAika;
    }
    
    public void setVapaaTeksti(String vapaaTeksti) {
        this.vapaaTeksti = vapaaTeksti;
    }
        
    public void setEtunimet(String etunimet) {
        this.etunimet = etunimet;
    }
        
    public void setOs(String os) {
        this.os = os;
    }
        
    public void setSyntymaAika(String syntymaAika) {
        this.syntymaAika = syntymaAika;
    }
        
    public float getVapaaTekstiFontSize() {
        return this.vapaaTekstiFontSize;
    }
    
    public void setVapaaTekstiFontSize(float vapaaTekstiFontSize) {
        this.vapaaTekstiFontSize = vapaaTekstiFontSize;
    }
    
    public float getEtunimetFontSize() {
        return this.etunimetFontSize;
    }
    
    public void setEtunimetFontSize(float etunimetFontSize) {
        this.etunimetFontSize = etunimetFontSize;
    }
    
    public void setFontSize(float fontSize) {
        this.vapaaTekstiFontSize = fontSize;
        this.etunimetFontSize = fontSize;
        this.osFontSize = fontSize;
        this.syntymaJaKuolinAikaFontSize = fontSize;
    }
    
    public float getOsFontSize() {
        return this.osFontSize;
    }
    
    public void setOsFontSize(float osFontSize) {
        this.osFontSize = osFontSize;
    }
    
    public float getSyntymaJaKuolinAikaFontSize() {
        return this.syntymaJaKuolinAikaFontSize;
    }
    
    public void setSyntymaJaKuolinAikaFontSize(float syntymaJaKuolinAikaFontSize) {
        this.syntymaJaKuolinAikaFontSize = syntymaJaKuolinAikaFontSize;
    }
    
    public int getFontIndex() {
        return this.fontIndex;
    }
    
    public void setFontIndex(int fontIndex) {
        this.fontIndex = fontIndex;
    }
    
    public Color getFontColor() {
        return this.fontColor;
    }
    
    public void setFontColor(Color fontColor) {
        this.fontColor = fontColor;
    }
    
    public float getFontWidth() {
        return this.fontWidth;
    }
    
    public void setFontWidth(float fontWidth) {
        this.fontWidth = fontWidth;
    }
    
    public float getHenkiloMetallikirjasinVapaaTekstiKoko() {
        return this.henkiloMetallikirjasinVapaaTekstiKoko;
    }
    
    public float getHenkiloMetallikirjasinEtunimetKoko() {
        return this.henkiloMetallikirjasinEtunimetKoko;
    }
    
    public float getHenkiloMetallikirjasinOsKoko() {
        return this.henkiloMetallikirjasinOsKoko;
    }
    
    public float getHenkiloMetallikirjasinSyntymaJaKuolinAikaKoko() {
        return this.henkiloMetallikirjasinSyntymaJaKuolinAikaKoko;
    }
    
    public String getHenkiloMetallikirjasinTyyppi() {
        return this.henkiloMetallikirjasinTyyppi;
    }
    
    public String getHenkiloMetallikirjasinAlaTyyppi() {
        return this.henkiloMetallikirjasinAlaTyyppi;
    }
    
    public void setHenkiloMetallikirjasinVapaaTekstiKoko(float henkiloMetallikirjasinVapaaTekstiKoko) {
        this.henkiloMetallikirjasinVapaaTekstiKoko = henkiloMetallikirjasinVapaaTekstiKoko;
    }
    
    public void setHenkiloMetallikirjasinEtunimetKoko(float henkiloMetallikirjasinEtunimetKoko) {
        this.henkiloMetallikirjasinEtunimetKoko = henkiloMetallikirjasinEtunimetKoko;
    }
    
    public void setHenkiloMetallikirjasinOsKoko(float henkiloMetallikirjasinOsKoko) {
        this.henkiloMetallikirjasinOsKoko = henkiloMetallikirjasinOsKoko;
    }
    
    public void setHenkiloMetallikirjasinSyntymaJaKuolinAikaKoko(float henkiloMetallikirjasinSyntymaJaKuolinAikaKoko) {
        this.henkiloMetallikirjasinSyntymaJaKuolinAikaKoko = henkiloMetallikirjasinSyntymaJaKuolinAikaKoko;
    }
    
    public void setHenkiloMetallikirjasinKoko(float henkiloMetallikirjasinKoko) {
        this.henkiloMetallikirjasinVapaaTekstiKoko = henkiloMetallikirjasinKoko;
        this.henkiloMetallikirjasinEtunimetKoko = henkiloMetallikirjasinKoko;
        this.henkiloMetallikirjasinOsKoko = henkiloMetallikirjasinKoko;
        this.henkiloMetallikirjasinSyntymaJaKuolinAikaKoko = henkiloMetallikirjasinKoko;
    }
    
    public void setHenkiloMetallikirjasinTyyppi(String henkiloMetallikirjasinTyyppi) {
        this.henkiloMetallikirjasinTyyppi = henkiloMetallikirjasinTyyppi;
    }
    
    public void setHenkiloMetallikirjasinAlaTyyppi(String henkiloMetallikirjasinAlaTyyppi) {
        this.henkiloMetallikirjasinAlaTyyppi = henkiloMetallikirjasinAlaTyyppi;
    }
    
    public int getHenkiloX() {
        return this.henkiloX;
    }
    
    public void setHenkiloX(int henkiloX) {
        this.henkiloX = henkiloX;
    }
    
    public int getHenkiloY() {
        return this.henkiloY;
    }
    
    public void setHenkiloY(int henkiloY) {
        this.henkiloY = henkiloY;
    }
}