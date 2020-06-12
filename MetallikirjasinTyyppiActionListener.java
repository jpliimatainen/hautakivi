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
public class MetallikirjasinTyyppiActionListener implements ActionListener {

    private JComboBox metallikirjasinAlaTyyppi;
    private EsikatseluJLabel metallikirjasinEsikatselu;
    
    
    public MetallikirjasinTyyppiActionListener(JComboBox metallikirjasinAlaTyyppi, EsikatseluJLabel metallikirjasinEsikatselu) {
        this.metallikirjasinAlaTyyppi = metallikirjasinAlaTyyppi;
        this.metallikirjasinEsikatselu = metallikirjasinEsikatselu;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox metallikirjasinTyyppi = (JComboBox)e.getSource();
        String metallikirjasinTyyppiText = (String)metallikirjasinTyyppi.getSelectedItem();
      
        int height, width;
        BufferedImage scaledImage;
        String path;
        Border loweredEtchedBorder = BorderFactory.createEtchedBorder(EtchedBorder.LOWERED);
        
        switch (metallikirjasinTyyppiText) {
            case "Antikva":
                this.metallikirjasinAlaTyyppi.setSelectedIndex(0);
                height = ImageArrays.antikvaKirkasImages[1].getImage().getHeight();
                width = ImageArrays.antikvaKirkasImages[1].getImage().getWidth();
                scaledImage = ImageArrays.antikvaKirkasImages[1].getImage();
                scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                metallikirjasinEsikatselu.repaint();
                break;
                
            case "Groteski":
                /*download images if not yet downloaded */
                if (!ImageArrays.groteskiKirkasFlag) {       
                    path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\1_Groteski\\2_Kirkas\\";
                    ImageArrays.groteskiKirkasImages = HautakiviohjelmaUI.loadFontImages(path); 
                    ImageArrays.groteskiKirkasFlag = true;
                }
                this.metallikirjasinAlaTyyppi.setSelectedIndex(0);
                height = ImageArrays.groteskiKirkasImages[1].getImage().getHeight();
                width = ImageArrays.groteskiKirkasImages[1].getImage().getWidth();
                scaledImage = ImageArrays.groteskiKirkasImages[1].getImage();
                scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                metallikirjasinEsikatselu.repaint();
                break;
                
            case "Kapea Antikva":
                /*download images if not yet downloaded */
                if (!ImageArrays.kapeaAntikvaKirkasFlag) {
                    path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\6_KapeaAntikva\\2_Kirkas\\";
                    ImageArrays.kapeaAntikvaKirkasImages = HautakiviohjelmaUI.loadFontImages(path); 
                    ImageArrays.kapeaAntikvaKirkasFlag = true;
                }
                this.metallikirjasinAlaTyyppi.setSelectedIndex(0);
                height = ImageArrays.kapeaAntikvaKirkasImages[1].getImage().getHeight();
                width = ImageArrays.kapeaAntikvaKirkasImages[1].getImage().getWidth();
                scaledImage = ImageArrays.kapeaAntikvaKirkasImages[1].getImage();
                scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                break;  
                
            case "Leveä Antikva":
                 /*download images if not yet downloaded */
                if (!ImageArrays.leveaAntikvaKirkasFlag) {
                    path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\4_LeveaAntikva\\2_Kirkas\\";
                    ImageArrays.leveaAntikvaKirkasImages = HautakiviohjelmaUI.loadFontImages(path); 
                    ImageArrays.leveaAntikvaKirkasFlag = true;
                }
                this.metallikirjasinAlaTyyppi.setSelectedIndex(0);
                height = ImageArrays.leveaAntikvaKirkasImages[1].getImage().getHeight();
                width = ImageArrays.leveaAntikvaKirkasImages[1].getImage().getWidth();
                scaledImage = ImageArrays.leveaAntikvaKirkasImages[1].getImage();
                scaledImage = HautakiviohjelmaUI.scaleImage(scaledImage, width, height, 0.25);
                this.metallikirjasinEsikatselu.setIcon(new ImageIcon(scaledImage));
                this.metallikirjasinEsikatselu.setBorder(loweredEtchedBorder);
                metallikirjasinEsikatselu.repaint();
                break;       
                    
            default: break;
        }
    } 
}