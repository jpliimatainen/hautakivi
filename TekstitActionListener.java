/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Checkbox;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.util.HashMap;
import java.util.Map;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Juha-Pekka
 */
public class TekstitActionListener implements ActionListener {

    private EsikatseluSukunimi esikatseluSukunimi;
    private EsikatseluHenkiloPanel[] esikatseluHenkiloPanel;
    private EsikatseluHenkilo[] esikatseluHenkilo;
    private JComboBox metallikirjasinTyyppi;
    private JComboBox metallikirjasinAlaTyyppi;
    private Checkbox vapaaTeksti;
    private Checkbox etunimi;
    private Checkbox os;
    private Checkbox syntymaAika;
    private Hautakivi hautakivi;
    
    public TekstitActionListener(EsikatseluSukunimi esikatseluSukunimi, EsikatseluHenkiloPanel[] esikatseluHenkiloPanel, 
            EsikatseluHenkilo[] esikatseluHenkilo, JComboBox metallikirjasinTyyppi, JComboBox metallikirjasinAlaTyyppi, 
            Checkbox vapaaTeksti, Checkbox etunimi, Checkbox os, Checkbox syntymaAika, Hautakivi hautakivi) {
        
        this.esikatseluSukunimi = esikatseluSukunimi;
        this.esikatseluHenkiloPanel = esikatseluHenkiloPanel;
        this.esikatseluHenkilo = esikatseluHenkilo;
        this.metallikirjasinTyyppi = metallikirjasinTyyppi;
        this.metallikirjasinAlaTyyppi = metallikirjasinAlaTyyppi;
        this.vapaaTeksti = vapaaTeksti;
        this.etunimi = etunimi;
        this.os = os;
        this.syntymaAika = syntymaAika;
        this.hautakivi = hautakivi;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
    
        int height, henkiloTekstiLength, width, posX, posY, i, j;
        float fontSize, fontWidth, fontSizeMetalli;
        Font font;
        Dimension size;
        ControlButton button = (ControlButton)e.getSource();
        Map<TextAttribute, Float> attributes = new HashMap<>();
        FontImage[] fontImages;
        Image[] scaledImages;
        JPanel metallikirjasinTekstit;
        EsikatseluJLabel kaiverrettuSukunimi;
        SukunimiPanel metallikirjasinSukunimi;
        Component[] components;
        FlowLayout flow;
        JLabel[] letters;
        JLabel letter;
        String henkiloTekstiStr, kuolinAikaStr, metallikirjasinTyyppiTxt, metallikirjasinAlaTyyppiTxt, syntymaAikaStr;
        
        switch (button.getButtonLabel()) {
            case "kirjasinLeveys":
                if (button.getButtonType() == ControlButton.ButtonType.PLUSBUTTON) {
                    if (this.esikatseluSukunimi.getKaiverrettukirjasinTxt().isChosen()) {
                        fontWidth = this.hautakivi.getSukunimiFontWidth()+0.1f;
                        if (fontWidth > 2.0f) {
                            break;
                        }
                        kaiverrettuSukunimi = this.esikatseluSukunimi.getKaiverrettukirjasinTxt();
                        if (!attributes.isEmpty()) {
                            attributes.clear();
                        }
                        attributes.put(TextAttribute.TRACKING, fontWidth);
                        kaiverrettuSukunimi.setFont(kaiverrettuSukunimi.getFont().deriveFont(attributes));
                        kaiverrettuSukunimi.setFont(kaiverrettuSukunimi.getFont().deriveFont(this.hautakivi.getSukunimiFontSize()));
                        
                        /* calculate new bounds for sukunimi */
                        size = kaiverrettuSukunimi.getPreferredSize();
                        kaiverrettuSukunimi.setBounds(kaiverrettuSukunimi.getX(), kaiverrettuSukunimi.getY(), size.width+5, size.height+5);
            
                        /* update the object */
                        this.hautakivi.setSukunimiFontWidth(fontWidth);
                    }
                    else if (this.esikatseluSukunimi.getMetallikirjasinTxt().isChosen()) {
                        fontWidth = this.hautakivi.getSukunimiFontWidth()+0.1f;
                        if (fontWidth > 2.0f) {
                            break;
                        }
                        metallikirjasinSukunimi = this.esikatseluSukunimi.getMetallikirjasinTxt();
                        components = metallikirjasinSukunimi.getComponents();
                        metallikirjasinSukunimi.removeAll();
                        size = new Dimension((int)(fontWidth*10)+1, 0);

                        for (Component comp : components) {
                            if (comp instanceof JLabel) {
                                letter = (JLabel)comp;
                                metallikirjasinSukunimi.add(letter);
                                letter.setAlignmentY(Component.BOTTOM_ALIGNMENT);
                                metallikirjasinSukunimi.add(Box.createRigidArea(size));
                            }
                        }
                        /* calculate new bounds for sukunimi */
                        size = metallikirjasinSukunimi.getPreferredSize();
                        metallikirjasinSukunimi.setBounds(metallikirjasinSukunimi.getX(), metallikirjasinSukunimi.getY(), size.width+5, size.height+5);
                        metallikirjasinSukunimi.revalidate();
                        
                        /* update the object */
                        this.hautakivi.setSukunimiFontWidth(fontWidth);
                    }
                    
                    else {
                        for (i=0; i<this.esikatseluHenkiloPanel.length; i++) {
                            fontWidth = this.hautakivi.getHenkilo(i).getFontWidth()+0.1f;
                                if (fontWidth > 2.0f) {
                                    break;
                                }
                            if (this.esikatseluHenkiloPanel[i].isChosen() && this.esikatseluHenkilo[i].isKaiverrettuKirjasin()) {
                                // kaiverrettukirjasin
                                if (!attributes.isEmpty()) {
                                    attributes.clear();
                                }
                                attributes.put(TextAttribute.TRACKING, fontWidth);
                                this.esikatseluHenkilo[i].setVapaaTekstiFontKaiverrettu(this.esikatseluHenkilo[i].getVapaaTekstiFontKaiverrettu().deriveFont(attributes));
                                this.esikatseluHenkilo[i].setVapaaTekstiFontKaiverrettu(this.esikatseluHenkilo[i].getVapaaTekstiFontKaiverrettu().deriveFont(
                                    this.hautakivi.getHenkilo(i).getVapaaTekstiFontSize()));
                                this.esikatseluHenkilo[i].setEtunimetFontKaiverrettu(this.esikatseluHenkilo[i].getEtunimetFontKaiverrettu().deriveFont(attributes));
                                this.esikatseluHenkilo[i].setEtunimetFontKaiverrettu(this.esikatseluHenkilo[i].getEtunimetFontKaiverrettu().deriveFont(
                                    this.hautakivi.getHenkilo(i).getEtunimetFontSize()));
                                this.esikatseluHenkilo[i].setOsFontKaiverrettu(this.esikatseluHenkilo[i].getOsFontKaiverrettu().deriveFont(attributes));
                                this.esikatseluHenkilo[i].setOsFontKaiverrettu(this.esikatseluHenkilo[i].getOsFontKaiverrettu().deriveFont(
                                    this.hautakivi.getHenkilo(i).getOsFontSize()));
                                this.esikatseluHenkilo[i].setSyntymaJaKuolinAikaFontKaiverrettu(this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaFontKaiverrettu().deriveFont(attributes));
                                this.esikatseluHenkilo[i].setSyntymaJaKuolinAikaFontKaiverrettu(this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaFontKaiverrettu().deriveFont(
                                    this.hautakivi.getHenkilo(i).getSyntymaJaKuolinAikaFontSize()));
                                
                                /* calculate new bounds for henkilo */
                                size = this.esikatseluHenkiloPanel[i].getPreferredSize();
                                this.esikatseluHenkiloPanel[i].setBounds(this.esikatseluHenkiloPanel[i].getX(), 
                                        this.esikatseluHenkiloPanel[i].getY(), size.width+5, size.height+5);
            
                                /* update the object */
                                this.hautakivi.getHenkilo(i).setFontWidth(fontWidth);
                                break;
                            }
                            else if (this.esikatseluHenkiloPanel[i].isChosen() && !this.esikatseluHenkilo[i].isKaiverrettuKirjasin()) {
                                // metallikirjasin    
                                metallikirjasinTyyppiTxt = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinTyyppi();
                                metallikirjasinAlaTyyppiTxt = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinAlaTyyppi();
                                
                                henkiloTekstiStr = this.hautakivi.getHenkilo(i).getVapaaTeksti();
                                metallikirjasinTekstit = this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasin();
                                metallikirjasinTekstit.removeAll();
                                if (!"".equals(henkiloTekstiStr)) {
                                    fontSizeMetalli = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinVapaaTekstiKoko();
                                    henkiloTekstiLength = henkiloTekstiStr.length(); 
                                    scaledImages = new Image[henkiloTekstiLength];
                                    this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                        metallikirjasinAlaTyyppiTxt, false), this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontImages());
                                    fontImages = new FontImage[henkiloTekstiLength];
                                    fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontImages());
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                            fontImages[j].getImage().getHeight(), fontSizeMetalli);
                                    }
            
                                    this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontLabels());
                        
                                    letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontLabels());
                                    size = new Dimension((int)(fontWidth*10)+1, 10);
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        metallikirjasinTekstit.add(letters[j]);
                                        letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                                        metallikirjasinTekstit.add(Box.createRigidArea(size));
                                    }
                                }
                                
                                /* calculate new bounds */
                                size = metallikirjasinTekstit.getPreferredSize();
                                metallikirjasinTekstit.setBounds(metallikirjasinTekstit.getX(), metallikirjasinTekstit.getY(), size.width, size.height);
                                metallikirjasinTekstit.revalidate();
                                
                                henkiloTekstiStr = this.hautakivi.getHenkilo(i).getEtunimet();
                                metallikirjasinTekstit = this.esikatseluHenkilo[i].getEtunimetMetallikirjasin();
                                metallikirjasinTekstit.removeAll();
                                if (!"".equals(henkiloTekstiStr)) {
                                    fontSizeMetalli = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinEtunimetKoko();
                                    henkiloTekstiLength = henkiloTekstiStr.length(); 
                                    scaledImages = new Image[henkiloTekstiLength];
                                    this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                        metallikirjasinAlaTyyppiTxt, false), this.esikatseluHenkilo[i].getEtunimetMetallikirjasinFontImages());
                                    fontImages = new FontImage[henkiloTekstiLength];
                                    fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getEtunimetMetallikirjasinFontImages());
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                            fontImages[j].getImage().getHeight(), fontSizeMetalli);
                                    }
            
                                    this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getEtunimetMetallikirjasinFontLabels());
                        
                                    letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getEtunimetMetallikirjasinFontLabels());
                                    size = new Dimension((int)(fontWidth*10)+1, 10);
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        metallikirjasinTekstit.add(letters[j]);
                                        letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                                        metallikirjasinTekstit.add(Box.createRigidArea(size));
                                    }
                                }
                                
                                /* calculate new bounds */
                                size = metallikirjasinTekstit.getPreferredSize();
                                metallikirjasinTekstit.setBounds(metallikirjasinTekstit.getX(), metallikirjasinTekstit.getY(), size.width, size.height);
                                metallikirjasinTekstit.revalidate();
                                
                                henkiloTekstiStr = this.hautakivi.getHenkilo(i).getOs();
                                metallikirjasinTekstit = this.esikatseluHenkilo[i].getOsMetallikirjasin();
                                metallikirjasinTekstit.removeAll();
                                if (!"".equals(henkiloTekstiStr)) {
                                    if (!" ".equals(henkiloTekstiStr)) {
                                        henkiloTekstiStr = "o.s. " + henkiloTekstiStr;
                                    }
                                    fontSizeMetalli = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinOsKoko();
                                    henkiloTekstiLength = henkiloTekstiStr.length(); 
                                    scaledImages = new Image[henkiloTekstiLength];
                                    this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                        metallikirjasinAlaTyyppiTxt, true), this.esikatseluHenkilo[i].getOsMetallikirjasinFontImages());
                                    fontImages = new FontImage[henkiloTekstiLength];
                                    fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getOsMetallikirjasinFontImages());
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                            fontImages[j].getImage().getHeight(), fontSizeMetalli);
                                    }
            
                                    this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getOsMetallikirjasinFontLabels());
                        
                                    letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getOsMetallikirjasinFontLabels());
                                    size = new Dimension((int)(fontWidth*10)+1, 10);
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        metallikirjasinTekstit.add(letters[j]);
                                        letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                                        metallikirjasinTekstit.add(Box.createRigidArea(size));
                                    }
                                }
                                
                                /* calculate new bounds */
                                size = metallikirjasinTekstit.getPreferredSize();
                                metallikirjasinTekstit.setBounds(metallikirjasinTekstit.getX(), metallikirjasinTekstit.getY(), size.width, size.height);
                                metallikirjasinTekstit.revalidate();
                                
                                metallikirjasinTekstit = this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasin();
                                metallikirjasinTekstit.removeAll();
                                
                                syntymaAikaStr = this.hautakivi.getHenkilo(i).getSyntymaAika();
                                kuolinAikaStr = this.hautakivi.getHenkilo(i).getKuolinAika();
                                if (syntymaAikaStr.length() > 0 && kuolinAikaStr.length() > 0) {
                                    henkiloTekstiStr = "*" + this.hautakivi.getHenkilo(i).getSyntymaAika() + "†" + this.hautakivi.getHenkilo(i).getKuolinAika();
                                }
                                else if (syntymaAikaStr.length() > 0) {
                                    henkiloTekstiStr = "*" + this.hautakivi.getHenkilo(i).getSyntymaAika();
                                }
                                else if (kuolinAikaStr.length() > 0) {
                                    henkiloTekstiStr = "†" + this.hautakivi.getHenkilo(i).getKuolinAika();
                                }
                                else {
                                    henkiloTekstiStr = null;
                                    metallikirjasinTekstit.removeAll();
                                }
                                if (henkiloTekstiStr != null) {
                                    fontSizeMetalli = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinSyntymaJaKuolinAikaKoko();
                                    henkiloTekstiLength = henkiloTekstiStr.length(); 
                                    scaledImages = new Image[henkiloTekstiLength];
            
                                    this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                            metallikirjasinAlaTyyppiTxt, false), this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontImages());
                                    fontImages = new FontImage[henkiloTekstiLength];
                                    fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontImages());
                        
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                            fontImages[j].getImage().getHeight(), fontSizeMetalli);
                                    }
            
                                    this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontLabels());
            
                                    letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontLabels());
                                    size = new Dimension((int)(fontWidth*10)+1, 10);
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        metallikirjasinTekstit.add(letters[j]);
                                        letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                                        metallikirjasinTekstit.add(Box.createRigidArea(size));
                                    }
                                }
                                /* calculate new bounds */
                                size = metallikirjasinTekstit.getPreferredSize();
                                metallikirjasinTekstit.setBounds(metallikirjasinTekstit.getX(), metallikirjasinTekstit.getY(), size.width, size.height);
                                metallikirjasinTekstit.revalidate();
                                
                                
                                /* calculate new bounds for henkilo */
                                size = this.esikatseluHenkiloPanel[i].getPreferredSize();
                                this.esikatseluHenkiloPanel[i].setBounds(this.esikatseluHenkiloPanel[i].getX(), 
                                        this.esikatseluHenkiloPanel[i].getY(), size.width+5, size.height+5);
            
                                /* update the object */
                                this.hautakivi.getHenkilo(i).setFontWidth(fontWidth);
                                break;
                            }
                        }
                    }        
                }
                else if (button.getButtonType() == ControlButton.ButtonType.MINUSBUTTON) {
                    if (this.esikatseluSukunimi.getKaiverrettukirjasinTxt().isChosen()) {
                        fontWidth = this.hautakivi.getSukunimiFontWidth()-0.1f;
                        if (fontWidth < 0.0f) {
                            break;
                        }
                        kaiverrettuSukunimi = this.esikatseluSukunimi.getKaiverrettukirjasinTxt();
                        if (!attributes.isEmpty()) {
                            attributes.clear();
                        }
                        attributes.put(TextAttribute.TRACKING, fontWidth);
                        kaiverrettuSukunimi.setFont(kaiverrettuSukunimi.getFont().deriveFont(attributes));
                        kaiverrettuSukunimi.setFont(kaiverrettuSukunimi.getFont().deriveFont(this.hautakivi.getSukunimiFontSize()));
                        
                        /* calculate new bounds for sukunimi */
                        size = kaiverrettuSukunimi.getPreferredSize();
                        kaiverrettuSukunimi.setBounds(kaiverrettuSukunimi.getX(), kaiverrettuSukunimi.getY(), size.width+5, size.height+5);
            
                        /* update the object */
                        this.hautakivi.setSukunimiFontWidth(fontWidth);
                    }
                    else if (this.esikatseluSukunimi.getMetallikirjasinTxt().isChosen()) {
                        fontWidth = this.hautakivi.getSukunimiFontWidth()-0.1f;
                        if (fontWidth < 0.0f) {
                            break;
                        }
                        metallikirjasinSukunimi = this.esikatseluSukunimi.getMetallikirjasinTxt();
                        components = metallikirjasinSukunimi.getComponents();
                        metallikirjasinSukunimi.removeAll();
                        size = new Dimension((int)(fontWidth*10)+1, 0);
                        for (Component comp : components) {
                            if (comp instanceof JLabel) {
                                letter = (JLabel)comp;
                                metallikirjasinSukunimi.add(letter);
                                letter.setAlignmentY(Component.BOTTOM_ALIGNMENT);
                                metallikirjasinSukunimi.add(Box.createRigidArea(size));
                            }
                        }
                        /* calculate new bounds for sukunimi */
                        size = metallikirjasinSukunimi.getPreferredSize();
                        metallikirjasinSukunimi.setBounds(metallikirjasinSukunimi.getX(), metallikirjasinSukunimi.getY(), size.width+5, size.height+5);
                        metallikirjasinSukunimi.revalidate();
                        
                        /* update the object */
                        this.hautakivi.setSukunimiFontWidth(fontWidth);
                    }
                    
                    else {
                        for (i=0; i<this.esikatseluHenkiloPanel.length; i++) {
                            fontWidth = this.hautakivi.getHenkilo(i).getFontWidth()-0.1f;
                                if (fontWidth < 0.0f) {
                                    break;
                                }
                            if (this.esikatseluHenkiloPanel[i].isChosen() && this.esikatseluHenkilo[i].isKaiverrettuKirjasin()) {
                                // kaiverrettukirjasin
                                if (!attributes.isEmpty()) {
                                    attributes.clear();
                                }
                                attributes.put(TextAttribute.TRACKING, fontWidth);
                                this.esikatseluHenkilo[i].setVapaaTekstiFontKaiverrettu(this.esikatseluHenkilo[i].getVapaaTekstiFontKaiverrettu().deriveFont(attributes));
                                this.esikatseluHenkilo[i].setVapaaTekstiFontKaiverrettu(this.esikatseluHenkilo[i].getVapaaTekstiFontKaiverrettu().deriveFont(
                                    this.hautakivi.getHenkilo(i).getVapaaTekstiFontSize()));
                                this.esikatseluHenkilo[i].setEtunimetFontKaiverrettu(this.esikatseluHenkilo[i].getEtunimetFontKaiverrettu().deriveFont(attributes));
                                this.esikatseluHenkilo[i].setEtunimetFontKaiverrettu(this.esikatseluHenkilo[i].getEtunimetFontKaiverrettu().deriveFont(
                                    this.hautakivi.getHenkilo(i).getEtunimetFontSize()));
                                this.esikatseluHenkilo[i].setOsFontKaiverrettu(this.esikatseluHenkilo[i].getOsFontKaiverrettu().deriveFont(attributes));
                                this.esikatseluHenkilo[i].setOsFontKaiverrettu(this.esikatseluHenkilo[i].getOsFontKaiverrettu().deriveFont(
                                    this.hautakivi.getHenkilo(i).getOsFontSize()));
                                this.esikatseluHenkilo[i].setSyntymaJaKuolinAikaFontKaiverrettu(this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaFontKaiverrettu().deriveFont(attributes));
                                this.esikatseluHenkilo[i].setSyntymaJaKuolinAikaFontKaiverrettu(this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaFontKaiverrettu().deriveFont(
                                    this.hautakivi.getHenkilo(i).getSyntymaJaKuolinAikaFontSize()));
                        
                                /* calculate new bounds for henkilo */
                                size = this.esikatseluHenkiloPanel[i].getPreferredSize();
                                this.esikatseluHenkiloPanel[i].setBounds(this.esikatseluHenkiloPanel[i].getX(), 
                                        this.esikatseluHenkiloPanel[i].getY(), size.width+5, size.height+5);
            
                                /* update the object */
                                this.hautakivi.getHenkilo(i).setFontWidth(fontWidth);
                                break;
                            }
                            else if (this.esikatseluHenkiloPanel[i].isChosen() && !this.esikatseluHenkilo[i].isKaiverrettuKirjasin()) {
                                // metallikirjasin
                                metallikirjasinTyyppiTxt = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinTyyppi();
                                metallikirjasinAlaTyyppiTxt = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinAlaTyyppi();
                                
                                henkiloTekstiStr = this.hautakivi.getHenkilo(i).getVapaaTeksti();
                                metallikirjasinTekstit = this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasin();
                                metallikirjasinTekstit.removeAll();
                                if (!"".equals(henkiloTekstiStr)) {
                                    fontSizeMetalli = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinVapaaTekstiKoko();
                                    henkiloTekstiLength = henkiloTekstiStr.length(); 
                                    scaledImages = new Image[henkiloTekstiLength];
                                    this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                        metallikirjasinAlaTyyppiTxt, false), this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontImages());
                                    fontImages = new FontImage[henkiloTekstiLength];
                                    fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontImages());
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                            fontImages[j].getImage().getHeight(), fontSizeMetalli);
                                    }
            
                                    this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontLabels());
                        
                                    letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontLabels());
                                    size = new Dimension((int)(fontWidth*10)+1, 10);
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        metallikirjasinTekstit.add(letters[j]);
                                        letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                                        metallikirjasinTekstit.add(Box.createRigidArea(size));
                                    }
                                }
                                
                                /* calculate new bounds */
                                size = metallikirjasinTekstit.getPreferredSize();
                                metallikirjasinTekstit.setBounds(metallikirjasinTekstit.getX(), metallikirjasinTekstit.getY(), size.width, size.height);
                                metallikirjasinTekstit.revalidate();
                                
                                henkiloTekstiStr = this.hautakivi.getHenkilo(i).getEtunimet();
                                metallikirjasinTekstit = this.esikatseluHenkilo[i].getEtunimetMetallikirjasin();
                                metallikirjasinTekstit.removeAll();
                                if (!"".equals(henkiloTekstiStr)) {
                                    fontSizeMetalli = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinEtunimetKoko();
                                    henkiloTekstiLength = henkiloTekstiStr.length(); 
                                    scaledImages = new Image[henkiloTekstiLength];
                                    this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                        metallikirjasinAlaTyyppiTxt, false), this.esikatseluHenkilo[i].getEtunimetMetallikirjasinFontImages());
                                    fontImages = new FontImage[henkiloTekstiLength];
                                    fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getEtunimetMetallikirjasinFontImages());
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                            fontImages[j].getImage().getHeight(), fontSizeMetalli);
                                    }
            
                                    this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getEtunimetMetallikirjasinFontLabels());
                        
                                    letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getEtunimetMetallikirjasinFontLabels());
                                    size = new Dimension((int)(fontWidth*10)+1, 10);
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        metallikirjasinTekstit.add(letters[j]);
                                        letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                                        metallikirjasinTekstit.add(Box.createRigidArea(size));
                                    }
                                }
                                
                                /* calculate new bounds */
                                size = metallikirjasinTekstit.getPreferredSize();
                                metallikirjasinTekstit.setBounds(metallikirjasinTekstit.getX(), metallikirjasinTekstit.getY(), size.width, size.height);
                                metallikirjasinTekstit.revalidate();
                                
                                henkiloTekstiStr = this.hautakivi.getHenkilo(i).getOs();
                                metallikirjasinTekstit = this.esikatseluHenkilo[i].getOsMetallikirjasin();
                                metallikirjasinTekstit.removeAll();
                                if (!"".equals(henkiloTekstiStr)) {
                                    if (!" ".equals(henkiloTekstiStr)) {
                                        henkiloTekstiStr = "o.s. " + henkiloTekstiStr;
                                    }
                                    fontSizeMetalli = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinOsKoko();
                                    henkiloTekstiLength = henkiloTekstiStr.length(); 
                                    scaledImages = new Image[henkiloTekstiLength];
                                    this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                        metallikirjasinAlaTyyppiTxt, true), this.esikatseluHenkilo[i].getOsMetallikirjasinFontImages());
                                    fontImages = new FontImage[henkiloTekstiLength];
                                    fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getOsMetallikirjasinFontImages());
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                            fontImages[j].getImage().getHeight(), fontSizeMetalli);
                                    }
            
                                    this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getOsMetallikirjasinFontLabels());
                        
                                    letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getOsMetallikirjasinFontLabels());
                                    size = new Dimension((int)(fontWidth*10)+1, 10);
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        metallikirjasinTekstit.add(letters[j]);
                                        letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                                        metallikirjasinTekstit.add(Box.createRigidArea(size));
                                    }
                                }
                                
                                /* calculate new bounds */
                                size = metallikirjasinTekstit.getPreferredSize();
                                metallikirjasinTekstit.setBounds(metallikirjasinTekstit.getX(), metallikirjasinTekstit.getY(), size.width, size.height);
                                metallikirjasinTekstit.revalidate();
                                
                                metallikirjasinTekstit = this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasin();
                                metallikirjasinTekstit.removeAll();
                                
                                syntymaAikaStr = this.hautakivi.getHenkilo(i).getSyntymaAika();
                                kuolinAikaStr = this.hautakivi.getHenkilo(i).getKuolinAika();
                                if (syntymaAikaStr.length() > 0 && kuolinAikaStr.length() > 0) {
                                    henkiloTekstiStr = "*" + this.hautakivi.getHenkilo(i).getSyntymaAika() + "†" + this.hautakivi.getHenkilo(i).getKuolinAika();
                                }
                                else if (syntymaAikaStr.length() > 0) {
                                    henkiloTekstiStr = "*" + this.hautakivi.getHenkilo(i).getSyntymaAika();
                                }
                                else if (kuolinAikaStr.length() > 0) {
                                    henkiloTekstiStr = "†" + this.hautakivi.getHenkilo(i).getKuolinAika();
                                }
                                else {
                                    henkiloTekstiStr = null;
                                    metallikirjasinTekstit.removeAll();
                                }
                                if (henkiloTekstiStr != null) {
                                    fontSizeMetalli = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinSyntymaJaKuolinAikaKoko();
                                    henkiloTekstiLength = henkiloTekstiStr.length(); 
                                    scaledImages = new Image[henkiloTekstiLength];
            
                                    this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                            metallikirjasinAlaTyyppiTxt, false), this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontImages());
                                    fontImages = new FontImage[henkiloTekstiLength];
                                    fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontImages());
                        
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                            fontImages[j].getImage().getHeight(), fontSizeMetalli);
                                    }
            
                                    this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontLabels());
            
                                    letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontLabels());
                                    size = new Dimension((int)(fontWidth*10)+1, 10);
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        metallikirjasinTekstit.add(letters[j]);
                                        letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                                        metallikirjasinTekstit.add(Box.createRigidArea(size));
                                    }
                                }
                                /* calculate new bounds */
                                size = metallikirjasinTekstit.getPreferredSize();
                                metallikirjasinTekstit.setBounds(metallikirjasinTekstit.getX(), metallikirjasinTekstit.getY(), size.width, size.height);
                                metallikirjasinTekstit.revalidate();
                                
                                /* calculate new bounds for henkilo */
                                size = this.esikatseluHenkiloPanel[i].getPreferredSize();
                                this.esikatseluHenkiloPanel[i].setBounds(this.esikatseluHenkiloPanel[i].getX(), 
                                        this.esikatseluHenkiloPanel[i].getY(), size.width+5, size.height+5);
            
                                /* update the object */
                                this.hautakivi.getHenkilo(i).setFontWidth(fontWidth);
                                break;
                            }
                        }
                    }        
                }
            break;
            
            case "kirjasinKoko":
                if (button.getButtonType() == ControlButton.ButtonType.PLUSBUTTON) {
                    if (this.esikatseluSukunimi.getKaiverrettukirjasinTxt().isChosen()) {
                        kaiverrettuSukunimi = this.esikatseluSukunimi.getKaiverrettukirjasinTxt();
                        font = kaiverrettuSukunimi.getFont();
                        fontSize = this.hautakivi.getSukunimiFontSize()+1;
                        kaiverrettuSukunimi.setFont(font.deriveFont(fontSize));
                        
                        /* calculate new bounds for sukunimi */
                        size = kaiverrettuSukunimi.getPreferredSize();
                        kaiverrettuSukunimi.setBounds(kaiverrettuSukunimi.getX(), kaiverrettuSukunimi.getY(), size.width+5, size.height+5);
            
                        /* update the object */
                        this.hautakivi.setSukunimiFontSize(fontSize);   
                    }
                    else if (this.esikatseluSukunimi.getMetallikirjasinTxt().isChosen()) {
                        metallikirjasinSukunimi = this.esikatseluSukunimi.getMetallikirjasinTxt();
                        
                        /* get font size */
                        fontSizeMetalli = this.hautakivi.getSukunimiMetallikirjasinKoko();
                        fontSizeMetalli += 0.01f;

                        posX = metallikirjasinSukunimi.getX();
                        posY = metallikirjasinSukunimi.getY();
            
                        fontImages = this.esikatseluSukunimi.getMetallikirjasinFontImages();
                        scaledImages = new Image[fontImages.length];
                        
                        for (i=0; i<fontImages.length; i++) {
                            scaledImages[i] = HautakiviohjelmaUI.scaleImage(fontImages[i].getImage(), fontImages[i].getImage().getWidth(), 
                                    fontImages[i].getImage().getHeight(), fontSizeMetalli);
                        }
                        this.esikatseluSukunimi.insertMetallikirjasinLabels(scaledImages);
            
                        letters = this.esikatseluSukunimi.getMetallikirjasinFontLabels();
                        metallikirjasinSukunimi.removeAll();
                        
                        fontWidth = this.hautakivi.getSukunimiFontWidth();
                        size = new Dimension((int)(fontWidth*10)+1, 0);
                        
                        for (i=0; i<letters.length; i++) {
                            metallikirjasinSukunimi.add(letters[i]);
                            letters[i].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                            metallikirjasinSukunimi.add(Box.createRigidArea(size));
                        }
                        
                        /* calculate new bounds */    
                        size = metallikirjasinSukunimi.getPreferredSize();
                        width = size.width;
                        height = size.height;
                        metallikirjasinSukunimi.setBounds(posX, posY, width+5, height+5);
            
                        metallikirjasinSukunimi.revalidate();
                        
                        /* update the object */
                        this.hautakivi.setSukunimiMetallikirjasinKoko(fontSizeMetalli);
                    }
                    else {
                        for (i=0; i<this.esikatseluHenkiloPanel.length; i++) {
                            if (this.esikatseluHenkiloPanel[i].isChosen() && this.esikatseluHenkilo[i].isKaiverrettuKirjasin()) {
                                if (this.vapaaTeksti.getState()) {
                                    font = esikatseluHenkilo[i].getVapaaTekstiFontKaiverrettu();
                                    fontSize = this.hautakivi.getHenkilo(i).getVapaaTekstiFontSize()+1f;
                                    this.esikatseluHenkilo[i].setVapaaTekstiFontKaiverrettu(font.deriveFont(fontSize));
                                    /* update the object */
                                    this.hautakivi.getHenkilo(i).setVapaaTekstiFontSize(fontSize);
                                }
                                if (this.etunimi.getState()) {
                                    font = esikatseluHenkilo[i].getEtunimetFontKaiverrettu();
                                    fontSize = this.hautakivi.getHenkilo(i).getEtunimetFontSize()+1f;
                                    this.esikatseluHenkilo[i].setEtunimetFontKaiverrettu(font.deriveFont(fontSize));
                                    /* update the object */
                                    this.hautakivi.getHenkilo(i).setEtunimetFontSize(fontSize);
                                }
                                if (this.os.getState()) {
                                    font = esikatseluHenkilo[i].getOsFontKaiverrettu();
                                    fontSize = this.hautakivi.getHenkilo(i).getOsFontSize()+1f;
                                    this.esikatseluHenkilo[i].setOsFontKaiverrettu(font.deriveFont(fontSize));
                                    /* update the object */
                                    this.hautakivi.getHenkilo(i).setOsFontSize(fontSize);
                                }
                                if (this.syntymaAika.getState()) {
                                    font = esikatseluHenkilo[i].getSyntymaJaKuolinAikaFontKaiverrettu();
                                    fontSize = this.hautakivi.getHenkilo(i).getSyntymaJaKuolinAikaFontSize()+1f;
                                    this.esikatseluHenkilo[i].setSyntymaJaKuolinAikaFontKaiverrettu(font.deriveFont(fontSize));
                                    /* update the object */
                                    this.hautakivi.getHenkilo(i).setSyntymaJaKuolinAikaFontSize(fontSize);
                                }
                                /* calculate new bounds for henkilo */
                                size = this.esikatseluHenkiloPanel[i].getPreferredSize();
                                this.esikatseluHenkiloPanel[i].setBounds(this.esikatseluHenkiloPanel[i].getX(), this.esikatseluHenkiloPanel[i].getY(), 
                                        size.width+5, size.height+5);
                                break;
                            }
                            else if (this.esikatseluHenkiloPanel[i].isChosen() && !this.esikatseluHenkilo[i].isKaiverrettuKirjasin()) {
                                // metallikirjasin   
                                metallikirjasinTyyppiTxt = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinTyyppi();
                                metallikirjasinAlaTyyppiTxt = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinAlaTyyppi();
                                
                                fontWidth = this.hautakivi.getHenkilo(i).getFontWidth();
                                
                                henkiloTekstiStr = this.hautakivi.getHenkilo(i).getVapaaTeksti();
                                metallikirjasinTekstit = this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasin();
                                metallikirjasinTekstit.removeAll();
                                if (!"".equals(henkiloTekstiStr)) {
                                    /* get font size */
                                    fontSizeMetalli = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinVapaaTekstiKoko();
                                    if (vapaaTeksti.getState()) {
                                        fontSizeMetalli += 0.01f;
                                        /* update the object */
                                        this.hautakivi.getHenkilo(i).setHenkiloMetallikirjasinVapaaTekstiKoko(fontSizeMetalli);
                                    }
                                    henkiloTekstiLength = henkiloTekstiStr.length(); 
                                    scaledImages = new Image[henkiloTekstiLength];
                                    this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                        metallikirjasinAlaTyyppiTxt, false), this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontImages());
                                    fontImages = new FontImage[henkiloTekstiLength];
                                    fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontImages());
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                            fontImages[j].getImage().getHeight(), fontSizeMetalli);
                                    }
            
                                    this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontLabels());
                        
                                    letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontLabels());
                                    size = new Dimension((int)(fontWidth*10)+1, 10);
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        metallikirjasinTekstit.add(letters[j]);
                                        letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                                        metallikirjasinTekstit.add(Box.createRigidArea(size));
                                    }
                                }
                                
                                /* calculate new bounds */
                                size = metallikirjasinTekstit.getPreferredSize();
                                metallikirjasinTekstit.setBounds(metallikirjasinTekstit.getX(), metallikirjasinTekstit.getY(), size.width, size.height);
                                metallikirjasinTekstit.revalidate();
                                
                                henkiloTekstiStr = this.hautakivi.getHenkilo(i).getEtunimet();
                                metallikirjasinTekstit = this.esikatseluHenkilo[i].getEtunimetMetallikirjasin();
                                metallikirjasinTekstit.removeAll();
                                if (!"".equals(henkiloTekstiStr)) {
                                    /* get font size */
                                    fontSizeMetalli = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinEtunimetKoko();
                                    if (etunimi.getState()) {
                                        fontSizeMetalli += 0.01f;
                                        /* update the object */
                                        this.hautakivi.getHenkilo(i).setHenkiloMetallikirjasinEtunimetKoko(fontSizeMetalli);
                                    }
                                    
                                    henkiloTekstiLength = henkiloTekstiStr.length(); 
                                    scaledImages = new Image[henkiloTekstiLength];
                                    this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                        metallikirjasinAlaTyyppiTxt, false), this.esikatseluHenkilo[i].getEtunimetMetallikirjasinFontImages());
                                    fontImages = new FontImage[henkiloTekstiLength];
                                    fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getEtunimetMetallikirjasinFontImages());
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                            fontImages[j].getImage().getHeight(), fontSizeMetalli);
                                    }
            
                                    this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getEtunimetMetallikirjasinFontLabels());
                        
                                    letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getEtunimetMetallikirjasinFontLabels());
                                    size = new Dimension((int)(fontWidth*10)+1, 10);
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        metallikirjasinTekstit.add(letters[j]);
                                        letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                                        metallikirjasinTekstit.add(Box.createRigidArea(size));
                                    }
                                }
                                
                                /* calculate new bounds */
                                size = metallikirjasinTekstit.getPreferredSize();
                                metallikirjasinTekstit.setBounds(metallikirjasinTekstit.getX(), metallikirjasinTekstit.getY(), size.width, size.height);
                                metallikirjasinTekstit.revalidate();
                                
                                henkiloTekstiStr = this.hautakivi.getHenkilo(i).getOs();
                                metallikirjasinTekstit = this.esikatseluHenkilo[i].getOsMetallikirjasin();
                                metallikirjasinTekstit.removeAll();
                                if (!"".equals(henkiloTekstiStr)) {
                                    if (!" ".equals(henkiloTekstiStr)) {
                                        henkiloTekstiStr = "o.s. " + henkiloTekstiStr;
                                    }
                                    /* get font size */
                                    fontSizeMetalli = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinOsKoko();
                                    if (os.getState()) {
                                        fontSizeMetalli += 0.01f;
                                        /* update the object */
                                        this.hautakivi.getHenkilo(i).setHenkiloMetallikirjasinOsKoko(fontSizeMetalli);   
                                    }
                                    
                                    henkiloTekstiLength = henkiloTekstiStr.length(); 
                                    scaledImages = new Image[henkiloTekstiLength];
                                    this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                        metallikirjasinAlaTyyppiTxt, true), this.esikatseluHenkilo[i].getOsMetallikirjasinFontImages());
                                    fontImages = new FontImage[henkiloTekstiLength];
                                    fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getOsMetallikirjasinFontImages());
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                            fontImages[j].getImage().getHeight(), fontSizeMetalli);
                                    }
            
                                    this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getOsMetallikirjasinFontLabels());
                        
                                    letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getOsMetallikirjasinFontLabels());
                                    size = new Dimension((int)(fontWidth*10)+1, 10);
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        metallikirjasinTekstit.add(letters[j]);
                                        letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                                        metallikirjasinTekstit.add(Box.createRigidArea(size));
                                    }
                                }
                                
                                /* calculate new bounds */
                                size = metallikirjasinTekstit.getPreferredSize();
                                metallikirjasinTekstit.setBounds(metallikirjasinTekstit.getX(), metallikirjasinTekstit.getY(), size.width, size.height);
                                metallikirjasinTekstit.revalidate();
                                
                                metallikirjasinTekstit = this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasin();
                                metallikirjasinTekstit.removeAll();
                                
                                syntymaAikaStr = this.hautakivi.getHenkilo(i).getSyntymaAika();
                                kuolinAikaStr = this.hautakivi.getHenkilo(i).getKuolinAika();
                                if (syntymaAikaStr.length() > 0 && kuolinAikaStr.length() > 0) {
                                    henkiloTekstiStr = "*" + this.hautakivi.getHenkilo(i).getSyntymaAika() + "†" + this.hautakivi.getHenkilo(i).getKuolinAika();
                                }
                                else if (syntymaAikaStr.length() > 0) {
                                    henkiloTekstiStr = "*" + this.hautakivi.getHenkilo(i).getSyntymaAika();
                                }
                                else if (kuolinAikaStr.length() > 0) {
                                    henkiloTekstiStr = "†" + this.hautakivi.getHenkilo(i).getKuolinAika();
                                }
                                else {
                                    henkiloTekstiStr = null;
                                    metallikirjasinTekstit.removeAll();
                                }
                                if (henkiloTekstiStr != null) {
                                    /* get font size */
                                    fontSizeMetalli = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinSyntymaJaKuolinAikaKoko();
                                    if (syntymaAika.getState()) {
                                        fontSizeMetalli += 0.01f;
                                        /* update the object */
                                        this.hautakivi.getHenkilo(i).setHenkiloMetallikirjasinSyntymaJaKuolinAikaKoko(fontSizeMetalli);
                                    }
                                    henkiloTekstiLength = henkiloTekstiStr.length(); 
                                    scaledImages = new Image[henkiloTekstiLength];
            
                                    this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                            metallikirjasinAlaTyyppiTxt, false), this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontImages());
                                    fontImages = new FontImage[henkiloTekstiLength];
                                    fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontImages());
                        
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                            fontImages[j].getImage().getHeight(), fontSizeMetalli);
                                    }
            
                                    this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontLabels());
            
                                    letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontLabels());
                                    size = new Dimension((int)(fontWidth*10)+1, 0);
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        metallikirjasinTekstit.add(letters[j]);
                                        letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                                        metallikirjasinTekstit.add(Box.createRigidArea(size));
                                    }
                                }
                                /* calculate new bounds */
                                size = metallikirjasinTekstit.getPreferredSize();
                                metallikirjasinTekstit.setBounds(metallikirjasinTekstit.getX(), metallikirjasinTekstit.getY(), size.width, size.height);
                                metallikirjasinTekstit.revalidate();
                                
                                /* calculate new bounds for henkilo */
                                size = this.esikatseluHenkiloPanel[i].getPreferredSize();
                                this.esikatseluHenkiloPanel[i].setBounds(this.esikatseluHenkiloPanel[i].getX(), 
                                        this.esikatseluHenkiloPanel[i].getY(), size.width+5, size.height+5);
                                this.esikatseluHenkiloPanel[i].revalidate();
            
                                break;
                            }
                        }
                    }      
                }
                else if (button.getButtonType() == ControlButton.ButtonType.MINUSBUTTON) {
                    if (this.esikatseluSukunimi.getKaiverrettukirjasinTxt().isChosen()) {
                        kaiverrettuSukunimi = this.esikatseluSukunimi.getKaiverrettukirjasinTxt();
                        font = kaiverrettuSukunimi.getFont();
                        fontSize = this.hautakivi.getSukunimiFontSize()-1f;
                        if (fontSize < 2.0f) {
                            break;
                        }
                        kaiverrettuSukunimi.setFont(font.deriveFont(fontSize));
                        
                        /* calculate new bounds for sukunimi */
                        size = kaiverrettuSukunimi.getPreferredSize();
                        kaiverrettuSukunimi.setBounds(kaiverrettuSukunimi.getX(), kaiverrettuSukunimi.getY(), size.width+5, size.height+5);
            
                        /* update the object */
                        this.hautakivi.setSukunimiFontSize(fontSize);   
                    }
                    else if (this.esikatseluSukunimi.getMetallikirjasinTxt().isChosen()) {
                        metallikirjasinSukunimi = this.esikatseluSukunimi.getMetallikirjasinTxt();
                        
                        /* get font size */
                        fontSizeMetalli = this.hautakivi.getSukunimiMetallikirjasinKoko();
                        if (fontSizeMetalli < 0.04f) {
                            break;
                        }
                        fontSizeMetalli -= 0.01f;

                        posX = metallikirjasinSukunimi.getX();
                        posY = metallikirjasinSukunimi.getY();
            
                        fontImages = this.esikatseluSukunimi.getMetallikirjasinFontImages();
                        scaledImages = new Image[fontImages.length];
                        
                        for (i=0; i<fontImages.length; i++) {
                            scaledImages[i] = HautakiviohjelmaUI.scaleImage(fontImages[i].getImage(), fontImages[i].getImage().getWidth(), 
                                    fontImages[i].getImage().getHeight(), fontSizeMetalli);
                        }
                        this.esikatseluSukunimi.insertMetallikirjasinLabels(scaledImages);
            
                        letters = this.esikatseluSukunimi.getMetallikirjasinFontLabels();
                        metallikirjasinSukunimi.removeAll();
                        fontWidth = this.hautakivi.getSukunimiFontWidth();
                        size = new Dimension((int)(fontWidth*10)+1, 0);

                        for (i=0; i<letters.length; i++) {
                            metallikirjasinSukunimi.add(letters[i]);
                            letters[i].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                            metallikirjasinSukunimi.add(Box.createRigidArea(size));
                        }
                        
                        /* calculate new bounds */    
                        size = metallikirjasinSukunimi.getPreferredSize();
                        width = size.width;
                        height = size.height;
                        metallikirjasinSukunimi.setBounds(posX, posY, width+5, height+5);
            
                        metallikirjasinSukunimi.revalidate();
                        
                        /* update the object */
                        this.hautakivi.setSukunimiMetallikirjasinKoko(fontSizeMetalli);
                    }
                    else {
                        for (i=0; i<this.esikatseluHenkiloPanel.length; i++) {
                            if (this.esikatseluHenkiloPanel[i].isChosen() && this.esikatseluHenkilo[i].isKaiverrettuKirjasin()) {
                                if (vapaaTeksti.getState()) {
                                    font = esikatseluHenkilo[i].getVapaaTekstiFontKaiverrettu();
                                    fontSize = this.hautakivi.getHenkilo(i).getVapaaTekstiFontSize()-1f;
                                    if (fontSize >= 2.0f) {
                                        this.esikatseluHenkilo[i].setVapaaTekstiFontKaiverrettu(font.deriveFont(fontSize));
                                        /* update the object */
                                        this.hautakivi.getHenkilo(i).setVapaaTekstiFontSize(fontSize);
                                    }
                                }
                                if (etunimi.getState()) {
                                    font = esikatseluHenkilo[i].getEtunimetFontKaiverrettu();
                                    fontSize = this.hautakivi.getHenkilo(i).getEtunimetFontSize()-1f;
                                    if (fontSize >= 2.0f) {
                                        this.esikatseluHenkilo[i].setEtunimetFontKaiverrettu(font.deriveFont(fontSize));
                                        /* update the object */
                                        this.hautakivi.getHenkilo(i).setEtunimetFontSize(fontSize);
                                    }
                                }
                                if (os.getState()) {
                                    font = esikatseluHenkilo[i].getOsFontKaiverrettu();
                                    fontSize = this.hautakivi.getHenkilo(i).getOsFontSize()-1f;
                                    if (fontSize >= 2.0f) {
                                        this.esikatseluHenkilo[i].setOsFontKaiverrettu(font.deriveFont(fontSize));
                                        /* update the object */
                                        this.hautakivi.getHenkilo(i).setOsFontSize(fontSize);
                                    }
                                }
                                if (syntymaAika.getState()) {
                                    font = esikatseluHenkilo[i].getSyntymaJaKuolinAikaFontKaiverrettu();
                                    fontSize = this.hautakivi.getHenkilo(i).getSyntymaJaKuolinAikaFontSize()-1f;
                                    if (fontSize >= 2.0f) {
                                        this.esikatseluHenkilo[i].setSyntymaJaKuolinAikaFontKaiverrettu(font.deriveFont(fontSize));
                                        /* update the object */
                                        this.hautakivi.getHenkilo(i).setSyntymaJaKuolinAikaFontSize(fontSize);
                                    }
                                }
                                
                                /* calculate new bounds for henkilo */
                                size = this.esikatseluHenkiloPanel[i].getPreferredSize();
                                this.esikatseluHenkiloPanel[i].setBounds(this.esikatseluHenkiloPanel[i].getX(), this.esikatseluHenkiloPanel[i].getY(), 
                                        size.width+5, size.height+5);
            
                                break;
                            }
                            else if (this.esikatseluHenkiloPanel[i].isChosen() && !this.esikatseluHenkilo[i].isKaiverrettuKirjasin()) {
                                // metallikirjasin   
                                metallikirjasinTyyppiTxt = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinTyyppi();
                                metallikirjasinAlaTyyppiTxt = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinAlaTyyppi();
                                fontWidth = this.hautakivi.getHenkilo(i).getFontWidth();
                                
                                henkiloTekstiStr = this.hautakivi.getHenkilo(i).getVapaaTeksti();
                                metallikirjasinTekstit = this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasin();
                                
                                if (!"".equals(henkiloTekstiStr)) {
                                    /* get font size */
                                    fontSizeMetalli = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinVapaaTekstiKoko();
                                    if (fontSizeMetalli < 0.03f) {
                                        break;
                                    }
                                    if (vapaaTeksti.getState()) {
                                        fontSizeMetalli -= 0.01f;
                                        /* update the object */
                                        this.hautakivi.getHenkilo(i).setHenkiloMetallikirjasinVapaaTekstiKoko(fontSizeMetalli);
                                    }
                                    metallikirjasinTekstit.removeAll();
                                    henkiloTekstiLength = henkiloTekstiStr.length(); 
                                    scaledImages = new Image[henkiloTekstiLength];
                                    this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                        metallikirjasinAlaTyyppiTxt, false), this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontImages());
                                    fontImages = new FontImage[henkiloTekstiLength];
                                    fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontImages());
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                            fontImages[j].getImage().getHeight(), fontSizeMetalli);
                                    }
            
                                    this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontLabels());
                        
                                    letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontLabels());
                                    size = new Dimension((int)(fontWidth*10)+1, 10);
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        metallikirjasinTekstit.add(letters[j]);
                                        letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                                        metallikirjasinTekstit.add(Box.createRigidArea(size));
                                    }
                                }
                                
                                /* calculate new bounds */
                                size = metallikirjasinTekstit.getPreferredSize();
                                metallikirjasinTekstit.setBounds(metallikirjasinTekstit.getX(), metallikirjasinTekstit.getY(), size.width, size.height);
                                metallikirjasinTekstit.revalidate();
                                
                                henkiloTekstiStr = this.hautakivi.getHenkilo(i).getEtunimet();
                                metallikirjasinTekstit = this.esikatseluHenkilo[i].getEtunimetMetallikirjasin();
                                
                                if (!"".equals(henkiloTekstiStr)) {
                                    /* get font size */
                                    fontSizeMetalli = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinEtunimetKoko();
                                    if (fontSizeMetalli < 0.03f) {
                                        break;
                                    }
                                    if (etunimi.getState()) {
                                        fontSizeMetalli -= 0.01f;
                                        /* update the object */
                                        this.hautakivi.getHenkilo(i).setHenkiloMetallikirjasinEtunimetKoko(fontSizeMetalli);
                                    }
                                    metallikirjasinTekstit.removeAll();
                                    henkiloTekstiLength = henkiloTekstiStr.length(); 
                                    scaledImages = new Image[henkiloTekstiLength];
                                    this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                        metallikirjasinAlaTyyppiTxt, false), this.esikatseluHenkilo[i].getEtunimetMetallikirjasinFontImages());
                                    fontImages = new FontImage[henkiloTekstiLength];
                                    fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getEtunimetMetallikirjasinFontImages());
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                            fontImages[j].getImage().getHeight(), fontSizeMetalli);
                                    }
            
                                    this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getEtunimetMetallikirjasinFontLabels());
                        
                                    letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getEtunimetMetallikirjasinFontLabels());
                                    size = new Dimension((int)(fontWidth*10)+1, 10);
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        metallikirjasinTekstit.add(letters[j]);
                                        letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                                        metallikirjasinTekstit.add(Box.createRigidArea(size));
                                    }
                                }
                                
                                /* calculate new bounds */
                                size = metallikirjasinTekstit.getPreferredSize();
                                metallikirjasinTekstit.setBounds(metallikirjasinTekstit.getX(), metallikirjasinTekstit.getY(), size.width, size.height);
                                metallikirjasinTekstit.revalidate();
                                
                                henkiloTekstiStr = this.hautakivi.getHenkilo(i).getOs();
                                metallikirjasinTekstit = this.esikatseluHenkilo[i].getOsMetallikirjasin();
                                
                                if (!"".equals(henkiloTekstiStr)) {
                                    if (!" ".equals(henkiloTekstiStr)) {
                                        henkiloTekstiStr = "o.s. " + henkiloTekstiStr;
                                    }
                                    /* get font size */
                                    fontSizeMetalli = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinOsKoko();
                                    if (fontSizeMetalli < 0.03f) {
                                        break;
                                    }
                                    if (os.getState()) {
                                        fontSizeMetalli -= 0.01f;
                                        /* update the object */
                                        this.hautakivi.getHenkilo(i).setHenkiloMetallikirjasinOsKoko(fontSizeMetalli);
                                    }
                                    metallikirjasinTekstit.removeAll();
                                    henkiloTekstiLength = henkiloTekstiStr.length(); 
                                    scaledImages = new Image[henkiloTekstiLength];
                                    this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                        metallikirjasinAlaTyyppiTxt, true), this.esikatseluHenkilo[i].getOsMetallikirjasinFontImages());
                                    fontImages = new FontImage[henkiloTekstiLength];
                                    fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getOsMetallikirjasinFontImages());
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                            fontImages[j].getImage().getHeight(), fontSizeMetalli);
                                    }
            
                                    this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getOsMetallikirjasinFontLabels());
                        
                                    letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getOsMetallikirjasinFontLabels());
                                    size = new Dimension((int)(fontWidth*10)+1, 10);
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        metallikirjasinTekstit.add(letters[j]);
                                        letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                                        metallikirjasinTekstit.add(Box.createRigidArea(size));
                                    }
                                }
                                
                                /* calculate new bounds */
                                size = metallikirjasinTekstit.getPreferredSize();
                                metallikirjasinTekstit.setBounds(metallikirjasinTekstit.getX(), metallikirjasinTekstit.getY(), size.width, size.height);
                                metallikirjasinTekstit.revalidate();
                                
                                metallikirjasinTekstit = this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasin();
                                
                                syntymaAikaStr = this.hautakivi.getHenkilo(i).getSyntymaAika();
                                kuolinAikaStr = this.hautakivi.getHenkilo(i).getKuolinAika();
                                if (syntymaAikaStr.length() > 0 && kuolinAikaStr.length() > 0) {
                                    henkiloTekstiStr = "*" + this.hautakivi.getHenkilo(i).getSyntymaAika() + "†" + this.hautakivi.getHenkilo(i).getKuolinAika();
                                }
                                else if (syntymaAikaStr.length() > 0) {
                                    henkiloTekstiStr = "*" + this.hautakivi.getHenkilo(i).getSyntymaAika();
                                }
                                else if (kuolinAikaStr.length() > 0) {
                                    henkiloTekstiStr = "†" + this.hautakivi.getHenkilo(i).getKuolinAika();
                                }
                                else {
                                    henkiloTekstiStr = null;
                                    metallikirjasinTekstit.removeAll();
                                }
                                if (henkiloTekstiStr != null) {
                                    /* get font size */
                                    fontSizeMetalli = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinSyntymaJaKuolinAikaKoko();
                                    if (fontSizeMetalli < 0.03f) {
                                        break;
                                    }
                                    if (syntymaAika.getState()) {
                                        fontSizeMetalli -= 0.01f;
                                        /* update the object */
                                        this.hautakivi.getHenkilo(i).setHenkiloMetallikirjasinSyntymaJaKuolinAikaKoko(fontSizeMetalli);
                                    }
                                    metallikirjasinTekstit.removeAll();
                                    henkiloTekstiLength = henkiloTekstiStr.length(); 
                                    scaledImages = new Image[henkiloTekstiLength];
            
                                    this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                            metallikirjasinAlaTyyppiTxt, false), this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontImages());
                                    fontImages = new FontImage[henkiloTekstiLength];
                                    fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontImages());
                        
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                            fontImages[j].getImage().getHeight(), fontSizeMetalli);
                                    }
            
                                    this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontLabels());
            
                                    letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontLabels());
                                    size = new Dimension((int)(fontWidth*10)+1, 0);
                                    for (j=0; j<henkiloTekstiLength; j++) {
                                        metallikirjasinTekstit.add(letters[j]);
                                        letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                                        metallikirjasinTekstit.add(Box.createRigidArea(size));
                                    }
                                }
                                /* calculate new bounds */
                                size = metallikirjasinTekstit.getPreferredSize();
                                metallikirjasinTekstit.setBounds(metallikirjasinTekstit.getX(), metallikirjasinTekstit.getY(), size.width, size.height);
                                metallikirjasinTekstit.revalidate();
                                
                                /* calculate new bounds for henkilo */
                                size = this.esikatseluHenkiloPanel[i].getPreferredSize();
                                this.esikatseluHenkiloPanel[i].setBounds(this.esikatseluHenkiloPanel[i].getX(), 
                                        this.esikatseluHenkiloPanel[i].getY(), size.width+5, size.height+5);
                                this.esikatseluHenkiloPanel[i].revalidate();
            
                                break;
                            }
                        }
                    }  
                }
            break;
                
            case "kirjasinTasaus":
                    
                    if (button.getButtonType() == ControlButton.ButtonType.LEFT) {
                        for (i=0; i<this.esikatseluHenkiloPanel.length; i++) {
                            if (this.esikatseluHenkiloPanel[i].isChosen() && this.esikatseluHenkilo[i].isKaiverrettuKirjasin()) {
                                esikatseluHenkilo[i].getVapaaTekstiKaiverrettu().setAlignmentX(Component.LEFT_ALIGNMENT);
                                esikatseluHenkilo[i].getEtunimetKaiverrettu().setAlignmentX(Component.LEFT_ALIGNMENT);
                                esikatseluHenkilo[i].getOsKaiverrettu().setAlignmentX(Component.LEFT_ALIGNMENT);
                                esikatseluHenkilo[i].getSyntymaJaKuolinAikaKaiverrettu().setAlignmentX(Component.LEFT_ALIGNMENT);
                                
                                /* calculate new bounds for henkilo */
                                size = this.esikatseluHenkiloPanel[i].getPreferredSize();
                                this.esikatseluHenkiloPanel[i].setBounds(this.esikatseluHenkiloPanel[i].getX(), 
                                        this.esikatseluHenkiloPanel[i].getY(), size.width+5, size.height+5);
                                esikatseluHenkiloPanel[i].revalidate();
                                
                                /* update the object */
                                this.hautakivi.getHenkilo(i).setTasaus(Henkilo.Tasaus.VASEN);
                                break;
                            }
                            else if (this.esikatseluHenkiloPanel[i].isChosen() && !this.esikatseluHenkilo[i].isKaiverrettuKirjasin()) {
                                // metallikirjasin
                                esikatseluHenkilo[i].getVapaaTekstiMetallikirjasin().setAlignmentX(Component.LEFT_ALIGNMENT);
                                esikatseluHenkilo[i].getEtunimetMetallikirjasin().setAlignmentX(Component.LEFT_ALIGNMENT);
                                esikatseluHenkilo[i].getOsMetallikirjasin().setAlignmentX(Component.LEFT_ALIGNMENT);
                                esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasin().setAlignmentX(Component.LEFT_ALIGNMENT);
                                
                                /* calculate new bounds for henkilo */
                                size = this.esikatseluHenkiloPanel[i].getPreferredSize();
                                this.esikatseluHenkiloPanel[i].setBounds(this.esikatseluHenkiloPanel[i].getX(), 
                                        this.esikatseluHenkiloPanel[i].getY(), size.width+5, size.height+5);
                                esikatseluHenkiloPanel[i].revalidate();
                                
                                /* update the object */
                                this.hautakivi.getHenkilo(i).setTasaus(Henkilo.Tasaus.VASEN);
                                break;
                            }
                        }
                    }
                    else if (button.getButtonType() == ControlButton.ButtonType.CENTER) {
                         for (i=0; i<this.esikatseluHenkiloPanel.length; i++) {
                            if (this.esikatseluHenkiloPanel[i].isChosen() && this.esikatseluHenkilo[i].isKaiverrettuKirjasin()) {
                                esikatseluHenkilo[i].getVapaaTekstiKaiverrettu().setAlignmentX(Component.CENTER_ALIGNMENT);
                                esikatseluHenkilo[i].getEtunimetKaiverrettu().setAlignmentX(Component.CENTER_ALIGNMENT);
                                esikatseluHenkilo[i].getOsKaiverrettu().setAlignmentX(Component.CENTER_ALIGNMENT);
                                esikatseluHenkilo[i].getSyntymaJaKuolinAikaKaiverrettu().setAlignmentX(Component.CENTER_ALIGNMENT);
                                
                                /* calculate new bounds for henkilo */
                                size = this.esikatseluHenkiloPanel[i].getPreferredSize();
                                this.esikatseluHenkiloPanel[i].setBounds(this.esikatseluHenkiloPanel[i].getX(), 
                                        this.esikatseluHenkiloPanel[i].getY(), size.width+5, size.height+5);
                                esikatseluHenkiloPanel[i].revalidate();
                                
                                /* update the object */
                                this.hautakivi.getHenkilo(i).setTasaus(Henkilo.Tasaus.KESKITETTY);
                                break;
                            }
                            else if (this.esikatseluHenkiloPanel[i].isChosen() && !this.esikatseluHenkilo[i].isKaiverrettuKirjasin()) {
                                // metallikirjasin
                                esikatseluHenkilo[i].getVapaaTekstiMetallikirjasin().setAlignmentX(Component.CENTER_ALIGNMENT);
                                esikatseluHenkilo[i].getEtunimetMetallikirjasin().setAlignmentX(Component.CENTER_ALIGNMENT);
                                esikatseluHenkilo[i].getOsMetallikirjasin().setAlignmentX(Component.CENTER_ALIGNMENT);
                                esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasin().setAlignmentX(Component.CENTER_ALIGNMENT);
                                
                                /* calculate new bounds for henkilo */
                                size = this.esikatseluHenkiloPanel[i].getPreferredSize();
                                this.esikatseluHenkiloPanel[i].setBounds(this.esikatseluHenkiloPanel[i].getX(), 
                                        this.esikatseluHenkiloPanel[i].getY(), size.width+5, size.height+5);
                                esikatseluHenkiloPanel[i].revalidate();
                                
                                /* update the object */
                                this.hautakivi.getHenkilo(i).setTasaus(Henkilo.Tasaus.KESKITETTY);
                                break;
                            }
                        }
                    }
                    else if (button.getButtonType() == ControlButton.ButtonType.RIGHT) {
                         for (i=0; i<this.esikatseluHenkiloPanel.length; i++) {
                            if (this.esikatseluHenkiloPanel[i].isChosen() && this.esikatseluHenkilo[i].isKaiverrettuKirjasin()) {
                                esikatseluHenkilo[i].getVapaaTekstiKaiverrettu().setAlignmentX(Component.RIGHT_ALIGNMENT);
                                esikatseluHenkilo[i].getEtunimetKaiverrettu().setAlignmentX(Component.RIGHT_ALIGNMENT);
                                esikatseluHenkilo[i].getOsKaiverrettu().setAlignmentX(Component.RIGHT_ALIGNMENT);
                                esikatseluHenkilo[i].getSyntymaJaKuolinAikaKaiverrettu().setAlignmentX(Component.RIGHT_ALIGNMENT);
                                
                                /* calculate new bounds for henkilo */
                                size = this.esikatseluHenkiloPanel[i].getPreferredSize();
                                this.esikatseluHenkiloPanel[i].setBounds(this.esikatseluHenkiloPanel[i].getX(), 
                                        this.esikatseluHenkiloPanel[i].getY(), size.width+5, size.height+5);
                                esikatseluHenkiloPanel[i].revalidate();
                                
                                /* update the object */
                                this.hautakivi.getHenkilo(i).setTasaus(Henkilo.Tasaus.OIKEA);
                                break;
                            }
                            else if (this.esikatseluHenkiloPanel[i].isChosen() && !this.esikatseluHenkilo[i].isKaiverrettuKirjasin()) {
                                // metallikirjasin
                                esikatseluHenkilo[i].getVapaaTekstiMetallikirjasin().setAlignmentX(Component.RIGHT_ALIGNMENT);
                                esikatseluHenkilo[i].getEtunimetMetallikirjasin().setAlignmentX(Component.RIGHT_ALIGNMENT);
                                esikatseluHenkilo[i].getOsMetallikirjasin().setAlignmentX(Component.RIGHT_ALIGNMENT);
                                esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasin().setAlignmentX(Component.RIGHT_ALIGNMENT);
                                
                                /* calculate new bounds for henkilo */
                                size = this.esikatseluHenkiloPanel[i].getPreferredSize();
                                this.esikatseluHenkiloPanel[i].setBounds(this.esikatseluHenkiloPanel[i].getX(), 
                                        this.esikatseluHenkiloPanel[i].getY(), size.width+5, size.height+5);    
                                esikatseluHenkiloPanel[i].revalidate();
                                
                                /* update the object */
                                this.hautakivi.getHenkilo(i).setTasaus(Henkilo.Tasaus.OIKEA);
                                break;
                            }
                        }
                    }
            break;
        }
    }
}