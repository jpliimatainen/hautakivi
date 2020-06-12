/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Juha-Pekka
 */
public class VaihdaMetallikirjasinFonttiActionListener implements ActionListener {
    
    private EsikatseluSukunimi esikatseluSukunimi;
    private EsikatseluHenkiloPanel[] esikatseluHenkiloPanel;
    private EsikatseluHenkilo[] esikatseluHenkilo;
    private JComboBox metallikirjasinTyyppi;
    private JComboBox metallikirjasinAlaTyyppi;
    private Hautakivi hautakivi;
    
    public VaihdaMetallikirjasinFonttiActionListener(EsikatseluSukunimi esikatseluSukunimi, EsikatseluHenkiloPanel[] esikatseluHenkiloPanel, 
            EsikatseluHenkilo[] esikatseluHenkilo, JComboBox metallikirjasinTyyppi, JComboBox metallikirjasinAlaTyyppi, Hautakivi hautakivi) {
        
        this.esikatseluSukunimi = esikatseluSukunimi;
        this.esikatseluHenkiloPanel = esikatseluHenkiloPanel;
        this.esikatseluHenkilo = esikatseluHenkilo;
        this.metallikirjasinTyyppi = metallikirjasinTyyppi;
        this.metallikirjasinAlaTyyppi = metallikirjasinAlaTyyppi;
        this.hautakivi = hautakivi;
    }
          
    @Override
    public void actionPerformed(ActionEvent e) {
        String sukunimiStr, henkiloTekstiStr, kuolinAikaStr, syntymaAikaStr;
        char charItem;
        int i, j, sukunimiLength, henkiloTekstiLength, height, width, posX, posY, cumX = 0;
        Image scaledImage;
        Dimension dimension;
        Image[] scaledImages;
        FontImage[] fontImages;
        JLabel[] letters;
        JPanel henkiloMetalliTekstit = new JPanel();
        
        String metallikirjasinTyyppiTxt = (String)this.metallikirjasinTyyppi.getSelectedItem();
        String metallikirjasinAlaTyyppiTxt = (String)this.metallikirjasinAlaTyyppi.getSelectedItem();
        
        EsikatseluJLabel sukunimiKaiverrettu = this.esikatseluSukunimi.getKaiverrettukirjasinTxt();
        SukunimiPanel sukunimiMetallikirjasin = this.esikatseluSukunimi.getMetallikirjasinTxt();
        
        if (sukunimiKaiverrettu.isChosen()) {
            sukunimiStr = this.hautakivi.getSukunimi();
            sukunimiLength = sukunimiStr.length(); 
            scaledImages = new Image[sukunimiLength];
            
            posX = sukunimiKaiverrettu.getX();
            posY = sukunimiKaiverrettu.getY();
            
            this.esikatseluSukunimi.setMetallikirjasinFontImages(FontImage.getFontImages(sukunimiStr, metallikirjasinTyyppiTxt, 
                    metallikirjasinAlaTyyppiTxt, false));
            fontImages = new FontImage[sukunimiLength];
            fontImages = this.esikatseluSukunimi.getMetallikirjasinFontImages();
            for (i=0; i<sukunimiLength; i++) {
                scaledImages[i] = HautakiviohjelmaUI.scaleImage(fontImages[i].getImage(), fontImages[i].getImage().getWidth(), 
                        fontImages[i].getImage().getHeight(), 0.06);
            }
            
            this.esikatseluSukunimi.insertMetallikirjasinLabels(scaledImages);
            
            letters = this.esikatseluSukunimi.getMetallikirjasinFontLabels();
            sukunimiMetallikirjasin.removeAll();
            for (i=0; i<sukunimiLength; i++) {
                sukunimiMetallikirjasin.add(letters[i]);
                letters[i].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                sukunimiMetallikirjasin.add(Box.createRigidArea(new Dimension(1, 0)));
            }
            /* calculate new bounds */    
            dimension = sukunimiMetallikirjasin.getPreferredSize();
            width = dimension.width;
            height = dimension.height;
            sukunimiMetallikirjasin.setBounds(posX, posY, width+5, height+5);
            
            /* switch from kaiverrettukirjasin to metalli one */
            sukunimiMetallikirjasin.setChosen(true);
            sukunimiMetallikirjasin.setVisible(true);
            sukunimiMetallikirjasin.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
            sukunimiKaiverrettu.setChosen(false);
            sukunimiKaiverrettu.setVisible(false);
            sukunimiKaiverrettu.setBorder(BorderFactory.createEmptyBorder());
            
            sukunimiMetallikirjasin.revalidate();
            
            /* update the object */
            this.hautakivi.setSukunimiMetallikirjasinKoko(0.06f);
            this.hautakivi.setSukunimiFontWidth(0f);
            this.hautakivi.setSukunimiMetallikirjasinTyyppi(metallikirjasinTyyppiTxt);
            this.hautakivi.setSukunimiMetallikirjasinAlaTyyppi(metallikirjasinAlaTyyppiTxt);
            this.hautakivi.setSukunimiKaiverrettu(false);
        }   
        else if (sukunimiMetallikirjasin.isChosen()) {
            sukunimiStr = this.hautakivi.getSukunimi();
            sukunimiLength = sukunimiStr.length(); 
            scaledImages = new Image[sukunimiLength];
            
            posX = sukunimiMetallikirjasin.getX();
            posY = sukunimiMetallikirjasin.getY();
            
            this.esikatseluSukunimi.setMetallikirjasinFontImages(FontImage.getFontImages(sukunimiStr, metallikirjasinTyyppiTxt, 
                    metallikirjasinAlaTyyppiTxt, false));
            fontImages = new FontImage[sukunimiLength];
            fontImages = this.esikatseluSukunimi.getMetallikirjasinFontImages();
            for (i=0; i<sukunimiLength; i++) {
                scaledImages[i] = HautakiviohjelmaUI.scaleImage(fontImages[i].getImage(), fontImages[i].getImage().getWidth(), 
                        fontImages[i].getImage().getHeight(), 0.06);
            }
            this.esikatseluSukunimi.insertMetallikirjasinLabels(scaledImages);
            
            letters = this.esikatseluSukunimi.getMetallikirjasinFontLabels();
            sukunimiMetallikirjasin.removeAll();
            for (i=0; i<sukunimiLength; i++) {
                sukunimiMetallikirjasin.add(letters[i]);
                letters[i].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                sukunimiMetallikirjasin.add(Box.createRigidArea(new Dimension(1, 0)));
            }
            /* calculate new bounds */    
            dimension = sukunimiMetallikirjasin.getPreferredSize();
            width = dimension.width;
            height = dimension.height;
            sukunimiMetallikirjasin.setBounds(posX, posY, width+5, height+5);
            
            sukunimiMetallikirjasin.revalidate();
            
            /* update the object */
            this.hautakivi.setSukunimiMetallikirjasinKoko(0.06f);
            this.hautakivi.setSukunimiFontWidth(0f);
            this.hautakivi.setSukunimiMetallikirjasinTyyppi(metallikirjasinTyyppiTxt);
            this.hautakivi.setSukunimiMetallikirjasinAlaTyyppi(metallikirjasinAlaTyyppiTxt);
        }  
        else {
            for (i=0; i<this.esikatseluHenkiloPanel.length; i++) {
                if (this.esikatseluHenkiloPanel[i].isChosen()) {
                    henkiloTekstiStr = this.hautakivi.getHenkilo(i).getVapaaTeksti();
                    henkiloMetalliTekstit = this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasin();
                    henkiloMetalliTekstit.removeAll();
                    if (!"".equals(henkiloTekstiStr)) {
                        henkiloTekstiLength = henkiloTekstiStr.length(); 
                        scaledImages = new Image[henkiloTekstiLength];
                        this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                metallikirjasinAlaTyyppiTxt, false), this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontImages());
                        fontImages = new FontImage[henkiloTekstiLength];
                        fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontImages());
                        for (j=0; j<henkiloTekstiLength; j++) {
                            scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                    fontImages[j].getImage().getHeight(), 0.03);
                        }
            
                        this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontLabels());
                        
                        letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontLabels());
                        for (j=0; j<henkiloTekstiLength; j++) {
                            henkiloMetalliTekstit.add(letters[j]);
                            letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                            henkiloMetalliTekstit.add(Box.createRigidArea(new Dimension(1, 10)));
                        }
                    }
                    /* calculate new bounds */    
                    dimension = henkiloMetalliTekstit.getPreferredSize();
                    width = dimension.width;
                    height = dimension.height;
                    henkiloMetalliTekstit.setBounds(henkiloMetalliTekstit.getX(), henkiloMetalliTekstit.getY(), width, height);
                    henkiloMetalliTekstit.revalidate();

                    henkiloTekstiStr = this.hautakivi.getHenkilo(i).getEtunimet();
                    henkiloMetalliTekstit = this.esikatseluHenkilo[i].getEtunimetMetallikirjasin();
                    henkiloMetalliTekstit.removeAll();
                    if (!"".equals(henkiloTekstiStr)) {
                        henkiloTekstiLength = henkiloTekstiStr.length(); 
                        scaledImages = new Image[henkiloTekstiLength];
            
                        this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                metallikirjasinAlaTyyppiTxt, false), this.esikatseluHenkilo[i].getEtunimetMetallikirjasinFontImages());
                        fontImages = new FontImage[henkiloTekstiLength];
                        fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getEtunimetMetallikirjasinFontImages());
                        for (j=0; j<henkiloTekstiLength; j++) {
                            scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                    fontImages[j].getImage().getHeight(), 0.03);
                        }
            
                        this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getEtunimetMetallikirjasinFontLabels());
            
                        letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getEtunimetMetallikirjasinFontLabels());
                        for (j=0; j<henkiloTekstiLength; j++) {
                            henkiloMetalliTekstit.add(letters[j]);
                            letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                            henkiloMetalliTekstit.add(Box.createRigidArea(new Dimension(1, 10)));
                        }
                    }
                    /* calculate new bounds */    
                    dimension = henkiloMetalliTekstit.getPreferredSize();
                    width = dimension.width;
                    height = dimension.height;
                    henkiloMetalliTekstit.setBounds(henkiloMetalliTekstit.getX(), henkiloMetalliTekstit.getY(), width, height);
                    henkiloMetalliTekstit.revalidate();

                    henkiloTekstiStr = this.hautakivi.getHenkilo(i).getOs();
                    henkiloMetalliTekstit = this.esikatseluHenkilo[i].getOsMetallikirjasin();
                    henkiloMetalliTekstit.removeAll();
                    if (!"".equals(henkiloTekstiStr)) {
                        if (!" ".equals(henkiloTekstiStr)) {
                            henkiloTekstiStr = "o.s. " + henkiloTekstiStr;
                        }
                        henkiloTekstiLength = henkiloTekstiStr.length(); 
                        scaledImages = new Image[henkiloTekstiLength];
            
                        this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, 
                                metallikirjasinTyyppiTxt, metallikirjasinAlaTyyppiTxt, true), this.esikatseluHenkilo[i].getOsMetallikirjasinFontImages());
                        fontImages = new FontImage[henkiloTekstiLength];
                        fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getOsMetallikirjasinFontImages());
                        for (j=0; j<henkiloTekstiLength; j++) {
                            scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                    fontImages[j].getImage().getHeight(), 0.03);
                        }
            
                        this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getOsMetallikirjasinFontLabels());
            
                        letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getOsMetallikirjasinFontLabels());
                        for (j=0; j<henkiloTekstiLength; j++) {
                            henkiloMetalliTekstit.add(letters[j]);
                            letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                            henkiloMetalliTekstit.add(Box.createRigidArea(new Dimension(1, 10)));
                        }
                    }
                    /* calculate new bounds */    
                    dimension = henkiloMetalliTekstit.getPreferredSize();
                    width = dimension.width;
                    height = dimension.height;
                    henkiloMetalliTekstit.setBounds(henkiloMetalliTekstit.getX(), henkiloMetalliTekstit.getY(), width, height);
                    henkiloMetalliTekstit.revalidate();

                    henkiloMetalliTekstit = this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasin();
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
                        henkiloMetalliTekstit.removeAll();
                    }
                    if (henkiloTekstiStr != null) {
                        henkiloTekstiLength = henkiloTekstiStr.length(); 
                        scaledImages = new Image[henkiloTekstiLength];
            
                        this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                metallikirjasinAlaTyyppiTxt, false), this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontImages());
                        fontImages = new FontImage[henkiloTekstiLength];
                        fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontImages());
                        
                        for (j=0; j<henkiloTekstiLength; j++) {
                            scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                    fontImages[j].getImage().getHeight(), 0.03);
                        }
            
                        this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontLabels());
            
                        letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontLabels());
                        henkiloMetalliTekstit.removeAll();
                        for (j=0; j<henkiloTekstiLength; j++) {
                            henkiloMetalliTekstit.add(letters[j]);
                            letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                            henkiloMetalliTekstit.add(Box.createRigidArea(new Dimension(1, 0)));
                        }
                        /* calculate new bounds */    
                        dimension = henkiloMetalliTekstit.getPreferredSize();
                        width = dimension.width;
                        height = dimension.height;
                        henkiloMetalliTekstit.setBounds(henkiloMetalliTekstit.getX(), henkiloMetalliTekstit.getY(), width, height);
                        henkiloMetalliTekstit.revalidate();
                    }
                    
                    if (this.esikatseluHenkilo[i].isKaiverrettuKirjasin()) {
                        /* switch from kaiverrettukirjasin to metalli one */
                        this.hautakivi.getHenkilo(i).setHenkiloKaiverrettu(false);
                        
                        this.esikatseluHenkilo[i].setKaiverrettuKirjasin(false);
                        
                        this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasin().setVisible(true);
                        this.esikatseluHenkilo[i].getEtunimetMetallikirjasin().setVisible(true);
                        this.esikatseluHenkilo[i].getOsMetallikirjasin().setVisible(true);
                        this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasin().setVisible(true);
                    
                        this.esikatseluHenkilo[i].getVapaaTekstiKaiverrettu().setVisible(false);
                        this.esikatseluHenkilo[i].getEtunimetKaiverrettu().setVisible(false);
                        this.esikatseluHenkilo[i].getOsKaiverrettu().setVisible(false);
                        this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaKaiverrettu().setVisible(false);
                    }

                    /* calculate new bounds for esikatseluhenkilopanel */
                    dimension = this.esikatseluHenkiloPanel[i].getPreferredSize();
                    this.esikatseluHenkiloPanel[i].setBounds(this.esikatseluHenkiloPanel[i].getX(), this.esikatseluHenkiloPanel[i].getY(), 
                            dimension.width+5, dimension.height+5);
                    this.esikatseluHenkiloPanel[i].revalidate();

                    /* update the object */
                    this.hautakivi.getHenkilo(i).setHenkiloMetallikirjasinKoko(0.03f);
                    this.hautakivi.getHenkilo(i).setFontWidth(0f);
                    this.hautakivi.getHenkilo(i).setHenkiloMetallikirjasinTyyppi(metallikirjasinTyyppiTxt);
                    this.hautakivi.getHenkilo(i).setHenkiloMetallikirjasinAlaTyyppi(metallikirjasinAlaTyyppiTxt);
                    break;
                }
            }
        }
    }
}