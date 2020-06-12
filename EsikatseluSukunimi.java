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

/**
 *
 * @author Juha-Pekka
 */
public class EsikatseluSukunimi {
    
    private EsikatseluJLabel kaiverrettukirjasinTxt;
    private ArrayList<FontImage> metallikirjasinFontImages;   
    private ArrayList<JLabel> metallikirjasinFontLabels;
    private SukunimiPanel metallikirjasinTxt;
    private Font sukunimiFont;
    private Color sukunimiFontColor;
    
    
    public EsikatseluSukunimi(Font sukunimiFont, Color sukunimiFontColor, String sukunimiTxt) {
        kaiverrettukirjasinTxt = new EsikatseluJLabel(sukunimiTxt, "sukunimi");
        metallikirjasinFontImages = new ArrayList<>();
        metallikirjasinFontLabels = new ArrayList<>();
        metallikirjasinTxt = new SukunimiPanel();
        this.sukunimiFont = sukunimiFont;
        this.sukunimiFontColor = sukunimiFontColor;
        
        kaiverrettukirjasinTxt.setOpaque(false);
        metallikirjasinTxt.setOpaque(false);
        
        kaiverrettukirjasinTxt.setForeground(this.sukunimiFontColor);
        kaiverrettukirjasinTxt.setFont(this.sukunimiFont);
        
        metallikirjasinTxt.setLayout(new BoxLayout(metallikirjasinTxt, BoxLayout.X_AXIS));
    }

    public void insertMetallikirjasinLabels(Image[] image) {
        /*remove old labels */
        this.metallikirjasinFontLabels.clear();
        for (int i=0; i<image.length; i++) {
            this.metallikirjasinFontLabels.add(new JLabel(new ImageIcon(image[i])));
        }
    }

    public EsikatseluJLabel getKaiverrettukirjasinTxt() {
        return kaiverrettukirjasinTxt;
    }

    public FontImage[] getMetallikirjasinFontImages() {
        ListIterator fontImageIterator = this.metallikirjasinFontImages.listIterator();
        FontImage[] fontImages = new FontImage[this.metallikirjasinFontImages.size()];
        int i=0;
        while (fontImageIterator.hasNext()) {
            fontImages[i] = (FontImage)fontImageIterator.next();
            i++;
        }
        return fontImages;
    }

    public JLabel[] getMetallikirjasinFontLabels() {
        ListIterator fontLabelIterator = this.metallikirjasinFontLabels.listIterator();
        JLabel[] fontLabels = new JLabel[this.metallikirjasinFontLabels.size()];
        int i=0;
        while (fontLabelIterator.hasNext()) {
            fontLabels[i] = (JLabel)fontLabelIterator.next();
            i++;
        }
        return fontLabels;
    }

    public SukunimiPanel getMetallikirjasinTxt() {
        return metallikirjasinTxt;
    }

    public Font getSukunimiFont() {
        return sukunimiFont;
    }

    public Color getSukunimiFontColor() {
        return sukunimiFontColor;
    }

    public void setKaiverrettukirjasinTxt(EsikatseluJLabel kaiverrettukirjasinTxt) {
        this.kaiverrettukirjasinTxt = kaiverrettukirjasinTxt;
    }

    public void setMetallikirjasinFontImages(FontImage[] metallikirjasinFontImages) {
        /*remove old images */
        this.metallikirjasinFontImages.clear();
        /* add new images */
        for (int i=0; i<metallikirjasinFontImages.length; i++) {
            this.metallikirjasinFontImages.add(metallikirjasinFontImages[i]);
        }
    }

    public void setSukunimiFont(Font sukunimiFont) {
        this.sukunimiFont = sukunimiFont;
    }

    public void setSukunimiFontColor(Color sukunimiFontColor) {
        this.sukunimiFontColor = sukunimiFontColor;
    }
}
