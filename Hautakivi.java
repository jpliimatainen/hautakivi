/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Color;
import java.awt.Image;
import java.io.Serializable;

/**
 *
 * @author Juha-Pekka
 */
public class Hautakivi implements Serializable {
    
    private int taustaKuvaIndex;
    private String muotoKuvaDescription;
    private int kivenLeveys;
    private int kivenKorkeus;
    private boolean pintaSahattu;
    private boolean pintaHiottu;
    private boolean pintaLouhittu;
    private int kivenVariIndex;
    private String sukunimi;
    private int sukunimiX;
    private int sukunimiY;
    private float sukunimiFontWidth;
    private boolean sukunimiKaiverrettu;
    private Color sukunimiFontColor;
    private float sukunimiFontSize;
    private int sukunimiFontIndex;
    private float sukunimiMetallikirjasinKoko;
    private String sukunimiMetallikirjasinTyyppi;
    private String sukunimiMetallikirjasinAlaTyyppi;
    private Henkilo[] henkilo;
    private Koriste[] koriste;
    private int koristeCounter;
    private String yhteysNimi;
    private String yhteysPuhelin;
    private String yhteysEmail;
    
    protected static final int HENKILOMAARA = 4;
    protected static final int KORISTEMAARA = 5;
    protected static final int SCALINGFACTORY = 5;
    
    public Hautakivi() {
        this.taustaKuvaIndex = 0;
        this.muotoKuvaDescription = "suorakulmio.png";
        this.kivenLeveys = 80;
        this.kivenKorkeus = 60;
        this.pintaSahattu = false;
        this.pintaHiottu = false;
        this.pintaLouhittu = true;
        this.kivenVariIndex = 0;
        this.sukunimi = "Meikäläinen";
        this.sukunimiX = 0;
        this.sukunimiY = 0;
        this.sukunimiFontWidth = 0f;
        this.sukunimiKaiverrettu = true;
        this.sukunimiFontColor = new Color(238, 232, 170);
        this.sukunimiFontSize = 32f;
        this.sukunimiFontIndex = 4;
        this.sukunimiMetallikirjasinKoko = 0.06f;
        this.sukunimiMetallikirjasinTyyppi = "";
        this.sukunimiMetallikirjasinAlaTyyppi = "";
        this.henkilo = new Henkilo[HENKILOMAARA];
        this.henkilo[0] = new Henkilo("", "Matti Heikki", "", "1.1.1930", "31.12.2010");
        
        for (int i=1; i<HENKILOMAARA; i++) {
            this.henkilo[i] = new Henkilo();
        }
        
        this.koriste = new Koriste[KORISTEMAARA];
        
        for (int i=0; i<KORISTEMAARA; i++) {
            this.koriste[i] = new Koriste();
        }
        this.koristeCounter = 0;
        this.yhteysNimi = "";
        this.yhteysPuhelin = "";
        this.yhteysEmail = "";
    }
    
    public int getTaustaKuvaIndex() {
        return this.taustaKuvaIndex;
    }
    
    public String getMuotoKuvaDescription() {
        return this.muotoKuvaDescription;
    }
    
    public int getKivenLeveys() {
        return this.kivenLeveys;
    }

    public int getKivenKorkeus() {
        return this.kivenKorkeus;
    }
    
    public boolean isPintaSahattu() {
        return this.pintaSahattu;
    }
    
    public boolean isPintaHiottu() {
        return this.pintaHiottu;
    }
    
    public boolean isPintaLouhittu() {
        return this.pintaLouhittu;
    }
    
    public int getKivenVariIndex() {
        return this.kivenVariIndex;
    }

    public String getSukunimi() {
        return this.sukunimi;
    }

    public int getSukunimiX() {
        return this.sukunimiX;
    }

    public int getSukunimiY() {
        return this.sukunimiY;
    }

    public float getSukunimiFontWidth() {
        return this.sukunimiFontWidth;
    }

    public boolean isSukunimiKaiverrettu() {
        return this.sukunimiKaiverrettu;
    }

    public Color getSukunimiFontColor() {
        return this.sukunimiFontColor;
    }

    public float getSukunimiFontSize() {
        return this.sukunimiFontSize;
    }
    
    public int getSukunimiFontIndex() {
        return this.sukunimiFontIndex;
    }

    public Henkilo getHenkilo(int index) {
        return this.henkilo[index];
    }

    public Koriste getKoriste(int index) {
        return this.koriste[index];
    }

    public String getYhteysNimi() {
        return this.yhteysNimi;
    }

    public String getYhteysPuhelin() {
        return this.yhteysPuhelin;
    }

    public String getYhteysEmail() {
        return this.yhteysEmail;
    }
    
    public void setTaustaKuvaIndex(int taustaKuvaIndex) {
        this.taustaKuvaIndex = taustaKuvaIndex;
    }
    
    public void setMuotoKuvaDescription(String muotoKuvaDescription) {
        this.muotoKuvaDescription = muotoKuvaDescription;
    }
    
    public void setKivenLeveys(int kivenLeveys) {
        this.kivenLeveys = kivenLeveys;
    }

    public void setKivenKorkeus(int kivenKorkeus) {
        this.kivenKorkeus = kivenKorkeus;
    }
    
    public void setPintaSahattu(boolean pintaSahattu) {
        this.pintaSahattu = pintaSahattu;
    }
    
    public void setPintaHiottu(boolean pintaHiottu) {
        this.pintaHiottu = pintaHiottu;
    }
    
    public void setPintaLouhittu(boolean pintaLouhittu) {
        this.pintaLouhittu = pintaLouhittu;
    }
    
    public void setKivenVariIndex(int kivenVariIndex) {
        this.kivenVariIndex = kivenVariIndex;
    }

    public void setSukunimi(String sukunimi) {
        this.sukunimi = sukunimi;
    }

    public void setSukunimiX(int sukunimiX) {
        this.sukunimiX = sukunimiX;
    }

    public void setSukunimiY(int sukunimiY) {
        this.sukunimiY = sukunimiY;
    }

    public void setSukunimiFontWidth(float sukunimiFontWidth) {
        this.sukunimiFontWidth = sukunimiFontWidth;
    }

    public void setSukunimiKaiverrettu(boolean sukunimiKaiverrettu) {
        this.sukunimiKaiverrettu = sukunimiKaiverrettu;
    }

    public void setSukunimiFontColor(Color sukunimiFontColor) {
        this.sukunimiFontColor = sukunimiFontColor;
    }

    public void setSukunimiFontSize(float sukunimiFontSize) {
        this.sukunimiFontSize = sukunimiFontSize;
    }
    
    public void setSukunimiFontIndex(int sukunimiFontIndex) {
        this.sukunimiFontIndex = sukunimiFontIndex;
    }

    public void setHenkilo(Henkilo[] henkilo) {
        this.henkilo = henkilo;
    }

    public void setKoriste(Koriste koriste, int index) {
        this.koriste[index] = koriste;
    }

    public void setYhteysNimi(String yhteysNimi) {
        this.yhteysNimi = yhteysNimi;
    }

    public void setYhteysPuhelin(String yhteysPuhelin) {
        this.yhteysPuhelin = yhteysPuhelin;
    }

    public void setYhteysEmail(String yhteysEmail) {
        this.yhteysEmail = yhteysEmail;
    }
    
    public float getSukunimiMetallikirjasinKoko() {
        return this.sukunimiMetallikirjasinKoko;
    }
    
    public String getSukunimiMetallikirjasinTyyppi() {
        return this.sukunimiMetallikirjasinTyyppi;
    }
    
    public String getSukunimiMetallikirjasinAlaTyyppi() {
        return this.sukunimiMetallikirjasinAlaTyyppi;
    }
    
    public void setSukunimiMetallikirjasinKoko(float sukunimiMetallikirjasinKoko) {
        this.sukunimiMetallikirjasinKoko = sukunimiMetallikirjasinKoko;
    }
    
    public void setSukunimiMetallikirjasinTyyppi(String sukunimiMetallikirjasinTyyppi) {
        this.sukunimiMetallikirjasinTyyppi = sukunimiMetallikirjasinTyyppi;
    }
    
    public void setSukunimiMetallikirjasinAlaTyyppi(String sukunimiMetallikirjasinAlaTyyppi) {
        this.sukunimiMetallikirjasinAlaTyyppi = sukunimiMetallikirjasinAlaTyyppi;
    }

    public void increaseKoristeCounter() {
        this.koristeCounter++;
    }
    
    public void decreaseKoristeCounter() {
        this.koristeCounter--;
    }
    
    public int getKoristeCounter() {
        return this.koristeCounter;
    }
    
    public void setKoristeCounter(int koristeCounter) {
        this.koristeCounter = koristeCounter;
    }
}