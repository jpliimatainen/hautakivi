/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;
import java.util.ListIterator;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Juha-Pekka
 */
public class EsikatseluHenkilo {
    
    private EsikatseluJLabel vapaaTekstiKaiverrettu;
    private EsikatseluJLabel etunimetKaiverrettu;
    private EsikatseluJLabel osKaiverrettu;
    private EsikatseluJLabel syntymaJaKuolinAikaKaiverrettu;
    
    private JPanel vapaaTekstiMetallikirjasin;
    private JPanel etunimetMetallikirjasin;
    private JPanel osMetallikirjasin;
    private JPanel syntymaJaKuolinAikaMetallikirjasin;
    
    private ArrayList<FontImage> vapaaTekstiMetallikirjasinFontImages;   
    private ArrayList<JLabel> vapaaTekstiMetallikirjasinFontLabels;
    private ArrayList<FontImage> etunimetMetallikirjasinFontImages;   
    private ArrayList<JLabel> etunimetMetallikirjasinFontLabels;
    private ArrayList<FontImage> osMetallikirjasinFontImages;   
    private ArrayList<JLabel> osMetallikirjasinFontLabels;
    private ArrayList<FontImage> syntymaJaKuolinAikaMetallikirjasinFontImages;   
    private ArrayList<JLabel> syntymaJaKuolinAikaMetallikirjasinFontLabels;
    
    private boolean kaiverrettuKirjasin;
    private int index;
    
    public EsikatseluHenkilo(String vapaaTeksti, String etunimet, String os, String syntymaAika, String kuolinAika, int index) {
        
        this.vapaaTekstiKaiverrettu = new EsikatseluJLabel(vapaaTeksti, "vapaaTeksti" + index);
        this.etunimetKaiverrettu = new EsikatseluJLabel(etunimet, "etunimet" + index);
        this.osKaiverrettu = new EsikatseluJLabel(os, "os" + index);
        syntymaJaKuolinAikaKaiverrettu = new EsikatseluJLabel("*" + syntymaAika + "  †" + kuolinAika, "syntymaJaKuolema" + index);
        
        vapaaTekstiMetallikirjasin = new JPanel();
        etunimetMetallikirjasin = new JPanel();
        osMetallikirjasin = new JPanel();
        syntymaJaKuolinAikaMetallikirjasin = new JPanel();
        
        vapaaTekstiMetallikirjasin.setLayout(new BoxLayout(vapaaTekstiMetallikirjasin, BoxLayout.X_AXIS));
        etunimetMetallikirjasin.setLayout(new BoxLayout(etunimetMetallikirjasin, BoxLayout.X_AXIS));
        osMetallikirjasin.setLayout(new BoxLayout(osMetallikirjasin, BoxLayout.X_AXIS));
        syntymaJaKuolinAikaMetallikirjasin.setLayout(new BoxLayout(syntymaJaKuolinAikaMetallikirjasin, BoxLayout.X_AXIS));
        
        vapaaTekstiMetallikirjasinFontImages = new ArrayList<>();
        vapaaTekstiMetallikirjasinFontLabels = new ArrayList<>();
        etunimetMetallikirjasinFontImages = new ArrayList<>();
        etunimetMetallikirjasinFontLabels = new ArrayList<>();
        osMetallikirjasinFontImages = new ArrayList<>();
        osMetallikirjasinFontLabels = new ArrayList<>();
        syntymaJaKuolinAikaMetallikirjasinFontImages = new ArrayList<>();
        syntymaJaKuolinAikaMetallikirjasinFontLabels = new ArrayList<>();
        
        kaiverrettuKirjasin = true;
        this.index = index;
    }
    
    public void insertMetallikirjasinLabels(Image[] image, ArrayList<JLabel> fontLabels) {
        /*remove old labels */
        fontLabels.clear();
        for (int i=0; i<image.length; i++) {
            fontLabels.add(new JLabel(new ImageIcon(image[i])));
        }
    }
    
    public FontImage[] getMetallikirjasinFontImagesArray(ArrayList<FontImage> fontImages) {
        ListIterator fontImageIterator = fontImages.listIterator();
        FontImage[] fontImagesArray = new FontImage[fontImages.size()];
        int i=0;
        while (fontImageIterator.hasNext()) {
            fontImagesArray[i] = (FontImage)fontImageIterator.next();
            i++;
        }
        return fontImagesArray;
    }

    public JLabel[] getMetallikirjasinFontLabelsArray(ArrayList<JLabel> fontLabels) {
        ListIterator fontLabelIterator = fontLabels.listIterator();
        JLabel[] fontLabelsArray = new JLabel[fontLabels.size()];
        int i=0;
        while (fontLabelIterator.hasNext()) {
            fontLabelsArray[i] = (JLabel)fontLabelIterator.next();
            i++;
        }
        return fontLabelsArray;
    }
    
     public void setMetallikirjasinFontImages(FontImage[] metallikirjasinFontImagesArray, 
             ArrayList<FontImage> metallikirjasinFontImages) {
        /*remove old images */
        metallikirjasinFontImages.clear();
        /* add new images */
        for (int i=0; i<metallikirjasinFontImagesArray.length; i++) {
            metallikirjasinFontImages.add(metallikirjasinFontImagesArray[i]);
        }
    }
    
    public EsikatseluJLabel getVapaaTekstiKaiverrettu() {
        return this.vapaaTekstiKaiverrettu;
    }
    
    public EsikatseluJLabel getEtunimetKaiverrettu() {
        return this.etunimetKaiverrettu;
    }
    
    public EsikatseluJLabel getOsKaiverrettu() {
        return this.osKaiverrettu;
    }
    
    public EsikatseluJLabel getSyntymaJaKuolinAikaKaiverrettu() {
        return this.syntymaJaKuolinAikaKaiverrettu;
    }
    
    public EsikatseluHenkilo resetSyntymaJaKuolinAikaKaiverrettu() {
        this.syntymaJaKuolinAikaKaiverrettu.setText("");
        return this;
    }
    
    public Font getVapaaTekstiFontKaiverrettu() {
        return this.vapaaTekstiKaiverrettu.getFont();
    }
    
    public Font getEtunimetFontKaiverrettu() {
        return this.etunimetKaiverrettu.getFont();
    }
    
    public Font getOsFontKaiverrettu() {
        return this.osKaiverrettu.getFont();
    }
    
    public Font getSyntymaJaKuolinAikaFontKaiverrettu() {
        return syntymaJaKuolinAikaKaiverrettu.getFont();
    }
    
    public void setVapaaTekstiFontKaiverrettu(Font font) {
        this.vapaaTekstiKaiverrettu.setFont(font);
    }
    
    public void setEtunimetFontKaiverrettu(Font font) {
        this.etunimetKaiverrettu.setFont(font);
    }
    
    public void setOsFontKaiverrettu(Font font) {
        this.osKaiverrettu.setFont(font);
    }
    
    public void setSyntymaJaKuolinAikaFontKaiverrettu(Font font) {
        syntymaJaKuolinAikaKaiverrettu.setFont(font);
    }
    
    public void setFontKaiverrettu(Font font) {
        this.vapaaTekstiKaiverrettu.setFont(font);
        this.etunimetKaiverrettu.setFont(font);
        this.osKaiverrettu.setFont(font);
        syntymaJaKuolinAikaKaiverrettu.setFont(font);
    }
    
    public void setForegroundKaiverrettu(Color color) {
        this.vapaaTekstiKaiverrettu.setForeground(color);
        this.etunimetKaiverrettu.setForeground(color);
        this.osKaiverrettu.setForeground(color);
        syntymaJaKuolinAikaKaiverrettu.setForeground(color);
    }
    
    public void setOpaque(boolean opacity) {
        this.vapaaTekstiKaiverrettu.setOpaque(opacity);
        this.etunimetKaiverrettu.setOpaque(opacity);
        this.osKaiverrettu.setOpaque(opacity);
        syntymaJaKuolinAikaKaiverrettu.setOpaque(opacity);
        
        this.vapaaTekstiMetallikirjasin.setOpaque(opacity);
        this.etunimetMetallikirjasin.setOpaque(opacity);
        this.osMetallikirjasin.setOpaque(opacity);
        syntymaJaKuolinAikaMetallikirjasin.setOpaque(opacity);
    }
    
    public boolean isKaiverrettuKirjasin() {
        return this.kaiverrettuKirjasin;
    }
    
    public void setKaiverrettuKirjasin(boolean kaiverrettuKirjasin) {
        this.kaiverrettuKirjasin = kaiverrettuKirjasin;
    }
    
    public JPanel getEtunimetMetallikirjasin() {
        return this.etunimetMetallikirjasin;
    }
    
    public JPanel getOsMetallikirjasin() {
        return this.osMetallikirjasin;
    }
    
    public JPanel getSyntymaJaKuolinAikaMetallikirjasin() {
        return this.syntymaJaKuolinAikaMetallikirjasin;
    }
    
    public JPanel getVapaaTekstiMetallikirjasin() {
        return this.vapaaTekstiMetallikirjasin;
    }

    public ArrayList<FontImage> getVapaaTekstiMetallikirjasinFontImages() {
        return vapaaTekstiMetallikirjasinFontImages;
    }

    public ArrayList<JLabel> getVapaaTekstiMetallikirjasinFontLabels() {
        return vapaaTekstiMetallikirjasinFontLabels;
    }

    public ArrayList<FontImage> getEtunimetMetallikirjasinFontImages() {
        return etunimetMetallikirjasinFontImages;
    }

    public ArrayList<JLabel> getEtunimetMetallikirjasinFontLabels() {
        return etunimetMetallikirjasinFontLabels;
    }
    
    public ArrayList<FontImage> getOsMetallikirjasinFontImages() {
        return osMetallikirjasinFontImages;
    }

    public ArrayList<JLabel> getOsMetallikirjasinFontLabels() {
        return osMetallikirjasinFontLabels;
    }

    public ArrayList<FontImage> getSyntymaJaKuolinAikaMetallikirjasinFontImages() {
        return syntymaJaKuolinAikaMetallikirjasinFontImages;
    }

    public ArrayList<JLabel> getSyntymaJaKuolinAikaMetallikirjasinFontLabels() {
        return syntymaJaKuolinAikaMetallikirjasinFontLabels;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public void revalidateKaiverrettu() {
        this.vapaaTekstiKaiverrettu.revalidate();
        this.etunimetKaiverrettu.revalidate();
        this.osKaiverrettu.revalidate();
        this.syntymaJaKuolinAikaKaiverrettu.revalidate();
    }
    
    public void revalidateMetallikirjasin() {
        this.vapaaTekstiMetallikirjasin.revalidate();
        this.etunimetMetallikirjasin.revalidate();
        this.osMetallikirjasin.revalidate();
        this.syntymaJaKuolinAikaMetallikirjasin.revalidate();
    }
}
