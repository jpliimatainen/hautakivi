/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Juha-Pekka
 */
public class KirjasinVariMouseEventListener extends MouseAdapter {
    
    private EsikatseluJLabel esikatseluSukunimi;
    private EsikatseluHenkiloPanel[] esikatseluHenkiloPanel;
    private EsikatseluHenkilo[] esikatseluHenkilo;
    private EsikatseluJLabel[] esikatseluKoristeLabel;
    private Hautakivi hautakivi;
    
    
    public KirjasinVariMouseEventListener(EsikatseluJLabel esikatseluSukunimi, EsikatseluHenkiloPanel[] esikatseluHenkiloPanel, 
            EsikatseluHenkilo[] esikatseluHenkilo, EsikatseluJLabel[] esikatseluKoristeLabel, Hautakivi hautakivi) {
        this.esikatseluSukunimi = esikatseluSukunimi;
        this.esikatseluHenkiloPanel = esikatseluHenkiloPanel;
        this.esikatseluHenkilo = esikatseluHenkilo;
        this.esikatseluKoristeLabel = esikatseluKoristeLabel;
        this.hautakivi = hautakivi;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        EsikatseluJLabel colorLabel = (EsikatseluJLabel)e.getComponent();
        Color color;
        int index, koristeKierto, width, height;
        BufferedImage coloredImage;
        
        if (this.esikatseluSukunimi.isChosen()) {
            switch (colorLabel.getLabelTypeText()) {
                case "hopea":
                    color = new Color(192, 192, 192);
                    this.esikatseluSukunimi.setForeground(color);
                    
                    /* update the object */
                    this.hautakivi.setSukunimiFontColor(color);
                    break;
                case "kulta":
                    color = new Color(238, 232, 170);
                    this.esikatseluSukunimi.setForeground(color);
                    
                    /* update the object */
                    this.hautakivi.setSukunimiFontColor(color);
                    break;
                case "musta":
                    color = new Color(0, 0, 0);
                    this.esikatseluSukunimi.setForeground(color);
                    
                    /* update the object */
                    this.hautakivi.setSukunimiFontColor(color);
                    break;
                default: break;
            }
        }
        else {
            for (int i=0; i<this.esikatseluHenkiloPanel.length; i++) {
                if (this.esikatseluHenkiloPanel[i].isChosen()) {
                    switch (colorLabel.getLabelTypeText()) {
                        case "hopea":
                            color = new Color(192, 192, 192);
                            this.esikatseluHenkilo[i].setForegroundKaiverrettu(color);
                            
                            for (int j=0; j<this.hautakivi.getKoristeCounter(); j++) {
                                if (this.esikatseluKoristeLabel[j].getLabelTypeText().equals("ornamentit")) {
                                    height = this.hautakivi.getKoriste(j).getKoristeKorkeus();
                                    width = this.hautakivi.getKoriste(j).getKoristeLeveys();
                                    koristeKierto = this.hautakivi.getKoriste(j).getKoristeKierto();
                                    index = this.esikatseluKoristeLabel[j].getIndex();
                                    coloredImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                                    coloredImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.ornamentitHopeaImages[index], 
                                        width, height);
                                    coloredImage = HautakiviohjelmaUI.rotateImage(coloredImage, 
                                            StrictMath.toRadians((double)koristeKierto));
                                    this.esikatseluKoristeLabel[j].setIcon(new ImageIcon(coloredImage));
                                }
                            }
                            /* update the object */
                            this.hautakivi.getHenkilo(i).setFontColor(color);
                            break;
                        case "kulta":
                            color = new Color(238, 232, 170);
                            this.esikatseluHenkilo[i].setForegroundKaiverrettu(color);
                            
                            for (int j=0; j<this.hautakivi.getKoristeCounter(); j++) {
                                if (this.esikatseluKoristeLabel[j].getLabelTypeText().equals("ornamentit")) {
                                    height = this.hautakivi.getKoriste(j).getKoristeKorkeus();
                                    width = this.hautakivi.getKoriste(j).getKoristeLeveys();
                                    koristeKierto = this.hautakivi.getKoriste(j).getKoristeKierto();
                                    index = this.esikatseluKoristeLabel[j].getIndex();
                                    coloredImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                                    coloredImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.ornamentitKultaImages[index], 
                                        width, height);
                                    coloredImage = HautakiviohjelmaUI.rotateImage(coloredImage, 
                                            StrictMath.toRadians((double)koristeKierto));
                                    this.esikatseluKoristeLabel[j].setIcon(new ImageIcon(coloredImage));
                                }
                            }
                            /* update the object */
                            this.hautakivi.getHenkilo(i).setFontColor(color);
                            break;
                        case "musta":
                            color = new Color(0, 0, 0);
                            this.esikatseluHenkilo[i].setForegroundKaiverrettu(color);

                            for (int j=0; j<this.hautakivi.getKoristeCounter(); j++) {
                                if (this.esikatseluKoristeLabel[j].getLabelTypeText().equals("ornamentit")) {
                                    height = this.hautakivi.getKoriste(j).getKoristeKorkeus();
                                    width = this.hautakivi.getKoriste(j).getKoristeLeveys();
                                    koristeKierto = this.hautakivi.getKoriste(j).getKoristeKierto();
                                    index = this.esikatseluKoristeLabel[j].getIndex();
                                    coloredImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                                    coloredImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.ornamentitMustaImages[index], 
                                        width, height);
                                    coloredImage = HautakiviohjelmaUI.rotateImage(coloredImage, 
                                            StrictMath.toRadians((double)koristeKierto));
                                    this.esikatseluKoristeLabel[j].setIcon(new ImageIcon(coloredImage));
                                }
                            }
                            /* update the object */
                            this.hautakivi.getHenkilo(i).setFontColor(color);
                            break;
                        default: break;
                    }
                }
            }
        }
    }
    
    @Override
    public void mouseEntered(MouseEvent e) {
        Cursor handCursor = new Cursor(Cursor.HAND_CURSOR);
        e.getComponent().setCursor(handCursor);
    }
    
    @Override
    public void mouseExited(MouseEvent e) {
        Cursor defaultCursor = new Cursor(Cursor.DEFAULT_CURSOR);
        e.getComponent().setCursor(defaultCursor);
    }
}
