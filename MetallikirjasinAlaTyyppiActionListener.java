/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.border.Border;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Juha-Pekka
 */
public class MetallikirjasinAlaTyyppiActionListener implements ActionListener {

    private JComboBox metallikirjasinTyyppi;
    private EsikatseluJLabel metallikirjasinEsikatselu;
    
    public MetallikirjasinAlaTyyppiActionListener(JComboBox metallikirjasinTyyppi, EsikatseluJLabel metallikirjasinEsikatselu) {
        this.metallikirjasinTyyppi = metallikirjasinTyyppi;
        this.metallikirjasinEsikatselu = metallikirjasinEsikatselu;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox koristeAlaTyyppi = (JComboBox)e.getSource();
        String koristeTyyppiText = (String)koristeAlaTyyppi.getSelectedItem();
        String koristeTyyppiNimi = "";
        String path;
        int height, width;
        BufferedImage scaledImage;
        Border loweredEtchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);

        koristeTyyppiNimi = (String)metallikirjasinTyyppi.getSelectedItem();
        
        switch (koristeTyyppiText) {
            case "Kirkas":  
                if ("Antikva".equals(koristeTyyppiNimi)) {
                    height = ImageArrays.antikvaKirkasImages[1].getImage().getHeight();
                    width = ImageArrays.antikvaKirkasImages[1].getImage().getWidth();
                    scaledImage = ImageArrays.antikvaKirkasImages[1].getImage();
                    scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                    this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                    this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                    metallikirjasinEsikatselu.repaint();
                    break;
                }       
                else if ("Groteski".equals(koristeTyyppiNimi)) {
                    height = ImageArrays.groteskiKirkasImages[1].getImage().getHeight();
                    width = ImageArrays.groteskiKirkasImages[1].getImage().getWidth();
                    scaledImage = ImageArrays.groteskiKirkasImages[1].getImage();
                    scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                    this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                    this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                    metallikirjasinEsikatselu.repaint();
                    break;
                } 
                else if ("Kapea Antikva".equals(koristeTyyppiNimi)) {
                    height = ImageArrays.kapeaAntikvaKirkasImages[1].getImage().getHeight();
                    width = ImageArrays.kapeaAntikvaKirkasImages[1].getImage().getWidth();
                    scaledImage = ImageArrays.kapeaAntikvaKirkasImages[1].getImage();
                    scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                    this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                    this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                    metallikirjasinEsikatselu.repaint();
                    break;
                }  
                else if ("Leveä Antikva".equals(koristeTyyppiNimi)) {
                    height = ImageArrays.leveaAntikvaKirkasImages[1].getImage().getHeight();
                    width = ImageArrays.leveaAntikvaKirkasImages[1].getImage().getWidth();
                    scaledImage = ImageArrays.leveaAntikvaKirkasImages[1].getImage();
                    scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                    this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                    this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                    metallikirjasinEsikatselu.repaint();
                    break;
                }  
                break;
                
            case "Kromaus":
                if ("Antikva".equals(koristeTyyppiNimi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.antikvaKromausFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\3_Antikva\\5_Kromaus\\";
                        ImageArrays.antikvaKromausImages = HautakiviohjelmaUI.loadFontImages(path);
                        ImageArrays.antikvaKromausFlag = true;
                    }
                    height = ImageArrays.antikvaKromausImages[1].getImage().getHeight();
                    width = ImageArrays.antikvaKromausImages[1].getImage().getWidth();
                    scaledImage = ImageArrays.antikvaKromausImages[1].getImage();
                    scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                    this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                    this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                    metallikirjasinEsikatselu.repaint();
                    break;
                }       
                else if ("Groteski".equals(koristeTyyppiNimi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.groteskiKromausFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\1_Groteski\\5_Kromaus\\";
                        ImageArrays.groteskiKromausImages = HautakiviohjelmaUI.loadFontImages(path);
                        ImageArrays.groteskiKromausFlag = true;
                    }
                    height = ImageArrays.groteskiKromausImages[1].getImage().getHeight();
                    width = ImageArrays.groteskiKromausImages[1].getImage().getWidth();
                    scaledImage = ImageArrays.groteskiKromausImages[1].getImage();
                    scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                    this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                    this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                    metallikirjasinEsikatselu.repaint();
                    break;
                } 
                else if ("Kapea Antikva".equals(koristeTyyppiNimi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.kapeaAntikvaKromausFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\6_KapeaAntikva\\5_Kromaus\\";
                        ImageArrays.kapeaAntikvaKromausImages = HautakiviohjelmaUI.loadFontImages(path);
                        ImageArrays.kapeaAntikvaKromausFlag = true;
                    }
                    height = ImageArrays.kapeaAntikvaKromausImages[1].getImage().getHeight();
                    width = ImageArrays.kapeaAntikvaKromausImages[1].getImage().getWidth();
                    scaledImage = ImageArrays.kapeaAntikvaKromausImages[1].getImage();
                    scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                    this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                    this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                    metallikirjasinEsikatselu.repaint();
                    break;
                }  
                else if ("Leveä Antikva".equals(koristeTyyppiNimi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.leveaAntikvaKromausFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\4_LeveaAntikva\\5_Kromaus\\";
                        ImageArrays.leveaAntikvaKromausImages = HautakiviohjelmaUI.loadFontImages(path);
                        ImageArrays.leveaAntikvaKromausFlag = true;
                    }
                    height = ImageArrays.leveaAntikvaKromausImages[1].getImage().getHeight();
                    width = ImageArrays.leveaAntikvaKromausImages[1].getImage().getWidth();
                    scaledImage = ImageArrays.leveaAntikvaKromausImages[1].getImage();
                    scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                    this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                    this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                    metallikirjasinEsikatselu.repaint();
                    break;
                }  
                break;
                
                
            case "Taidepatina":
                if ("Antikva".equals(koristeTyyppiNimi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.antikvaTaidePatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\3_Antikva\\3_Taidepatina\\";
                        ImageArrays.antikvaTaidePatinaImages = HautakiviohjelmaUI.loadFontImages(path);
                        ImageArrays.antikvaTaidePatinaFlag = true;
                    }
                    height = ImageArrays.antikvaTaidePatinaImages[1].getImage().getHeight();
                    width = ImageArrays.antikvaTaidePatinaImages[1].getImage().getWidth();
                    scaledImage = ImageArrays.antikvaTaidePatinaImages[1].getImage();
                    scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                    this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                    this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                    metallikirjasinEsikatselu.repaint();
                    break;
                }       
                else if ("Groteski".equals(koristeTyyppiNimi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.groteskiTaidePatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\1_Groteski\\3_Taidepatina\\";
                        ImageArrays.groteskiTaidePatinaImages = HautakiviohjelmaUI.loadFontImages(path);
                        ImageArrays.groteskiTaidePatinaFlag = true;
                    }
                    height = ImageArrays.groteskiTaidePatinaImages[1].getImage().getHeight();
                    width = ImageArrays.groteskiTaidePatinaImages[1].getImage().getWidth();
                    scaledImage = ImageArrays.groteskiTaidePatinaImages[1].getImage();
                    scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                    this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                    this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                    metallikirjasinEsikatselu.repaint();
                    break;
                } 
                else if ("Kapea Antikva".equals(koristeTyyppiNimi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.kapeaAntikvaTaidePatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\6_KapeaAntikva\\3_Taidepatina\\";
                        ImageArrays.kapeaAntikvaTaidePatinaImages = HautakiviohjelmaUI.loadFontImages(path);
                        ImageArrays.kapeaAntikvaTaidePatinaFlag = true;
                    }
                    height = ImageArrays.kapeaAntikvaTaidePatinaImages[1].getImage().getHeight();
                    width = ImageArrays.kapeaAntikvaTaidePatinaImages[1].getImage().getWidth();
                    scaledImage = ImageArrays.kapeaAntikvaTaidePatinaImages[1].getImage();
                    scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                    this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                    this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                    metallikirjasinEsikatselu.repaint();
                    break;
                }  
                else if ("Leveä Antikva".equals(koristeTyyppiNimi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.leveaAntikvaTaidePatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\4_LeveaAntikva\\3_Taidepatina\\";
                        ImageArrays.leveaAntikvaTaidePatinaImages = HautakiviohjelmaUI.loadFontImages(path);
                        ImageArrays.leveaAntikvaTaidePatinaFlag = true;
                    }
                    height = ImageArrays.leveaAntikvaTaidePatinaImages[1].getImage().getHeight();
                    width = ImageArrays.leveaAntikvaTaidePatinaImages[1].getImage().getWidth();
                    scaledImage = ImageArrays.leveaAntikvaTaidePatinaImages[1].getImage();
                    scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                    this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                    this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                    metallikirjasinEsikatselu.repaint();
                    break;
                }  
                break;
            
            case "Tumma patina":
                if ("Antikva".equals(koristeTyyppiNimi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.antikvaTummaPatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\3_Antikva\\1_Tumma_patina\\";
                        ImageArrays.antikvaTummaPatinaImages = HautakiviohjelmaUI.loadFontImages(path);
                        ImageArrays.antikvaTummaPatinaFlag = true;
                    }
                    height = ImageArrays.antikvaTummaPatinaImages[1].getImage().getHeight();
                    width = ImageArrays.antikvaTummaPatinaImages[1].getImage().getWidth();
                    scaledImage = ImageArrays.antikvaTummaPatinaImages[1].getImage();
                    scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                    this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                    this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                    metallikirjasinEsikatselu.repaint();
                    break;
                }       
                else if ("Groteski".equals(koristeTyyppiNimi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.groteskiTummaPatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\1_Groteski\\1_Tumma_patina\\";
                        ImageArrays.groteskiTummaPatinaImages = HautakiviohjelmaUI.loadFontImages(path);
                        ImageArrays.groteskiTummaPatinaFlag = true;
                    }
                    height = ImageArrays.groteskiTummaPatinaImages[1].getImage().getHeight();
                    width = ImageArrays.groteskiTummaPatinaImages[1].getImage().getWidth();
                    scaledImage = ImageArrays.groteskiTummaPatinaImages[1].getImage();
                    scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                    this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                    this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                    metallikirjasinEsikatselu.repaint();
                    break;
                } 
                else if ("Kapea Antikva".equals(koristeTyyppiNimi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.kapeaAntikvaTummaPatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\6_KapeaAntikva\\1_Tumma_patina\\";
                        ImageArrays.kapeaAntikvaTummaPatinaImages = HautakiviohjelmaUI.loadFontImages(path);
                        ImageArrays.kapeaAntikvaTummaPatinaFlag = true;
                    }
                    height = ImageArrays.kapeaAntikvaTummaPatinaImages[1].getImage().getHeight();
                    width = ImageArrays.kapeaAntikvaTummaPatinaImages[1].getImage().getWidth();
                    scaledImage = ImageArrays.kapeaAntikvaTummaPatinaImages[1].getImage();
                    scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                    this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                    this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                    metallikirjasinEsikatselu.repaint();
                    break;
                }  
                else if ("Leveä Antikva".equals(koristeTyyppiNimi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.leveaAntikvaTummaPatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\4_LeveaAntikva\\1_Tumma_patina\\";
                        ImageArrays.leveaAntikvaTummaPatinaImages = HautakiviohjelmaUI.loadFontImages(path);
                        ImageArrays.leveaAntikvaTummaPatinaFlag = true;
                    }
                    height = ImageArrays.leveaAntikvaTummaPatinaImages[1].getImage().getHeight();
                    width = ImageArrays.leveaAntikvaTummaPatinaImages[1].getImage().getWidth();
                    scaledImage = ImageArrays.leveaAntikvaTummaPatinaImages[1].getImage();
                    scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                    this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                    this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                    metallikirjasinEsikatselu.repaint();
                    break;
                }  
                break;
                
            default: break;
        }
    } 
}