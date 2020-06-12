/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import javax.swing.ImageIcon;

/**
 *
 * @author Juha-Pekka
 */
public class KoristeActionListener implements ActionListener {

    private EsikatseluJLabel[] esikatseluKoristeLabel;
    private MuotoJPanel esikatseluMuotoPanel;
    private Hautakivi hautakivi;
    
    public KoristeActionListener(EsikatseluJLabel[] esikatseluKoristeLabel, MuotoJPanel esikatseluMuotoPanel, 
            Hautakivi hautakivi) {
        
        this.esikatseluKoristeLabel = esikatseluKoristeLabel;
        this.esikatseluMuotoPanel = esikatseluMuotoPanel;
        this.hautakivi = hautakivi;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        BufferedImage iconImage;
        int height, i, index, koristeKierto, pinossa, width, posX, posY;
        String labelType;
        Dimension size;
        ControlButton button = (ControlButton)e.getSource();
        
        for (i=0; i<esikatseluKoristeLabel.length; i++) {
            if (esikatseluKoristeLabel[i].isChosen()) {
                height = this.hautakivi.getKoriste(i).getKoristeKorkeus();
                width = this.hautakivi.getKoriste(i).getKoristeLeveys();
                koristeKierto = this.hautakivi.getKoriste(i).getKoristeKierto();
                index = esikatseluKoristeLabel[i].getIndex();
                labelType = esikatseluKoristeLabel[i].getLabelTypeText();
                iconImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
                
                switch (button.getButtonLabel()) {
                    case "koristeKoko":
                        if (button.getButtonType() == ControlButton.ButtonType.PLUSBUTTON) {
                            if (height > 360) {
                                break;
                            }
                            if ("enkelitTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.enkelitTummaPatinaImages[index], width, height, 
                                        1.05);
                            }
                            else if ("enkelitKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.enkelitKirkasImages[index], width, height, 
                                        1.05);
                            }
                            else if ("enkelitTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.enkelitTaidePatinaImages[index], width, height, 
                                        1.05);
                            }
                            else if ("enkelitKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.enkelitKromausImages[index], width, height, 
                                        1.05);
                            }
                            
                            else if ("holvikehyksetTummaPatina".equals(labelType)) {
                                if (height == 120) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.holvikehyksetTummaPatinaImages[index], 70, 160);
                                }
                                else if (height == 160) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.holvikehyksetTummaPatinaImages[index], 90, 185);
                                }
                                else {
                                    break;
                                }
                            }
                            else if ("holvikehyksetKirkas".equals(labelType)) {
                                if (height == 120) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.holvikehyksetKirkasImages[index], 70, 160);
                                }
                                else if (height == 160) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.holvikehyksetKirkasImages[index], 90, 185);
                                }
                                else {
                                    break;
                                }
                            }
                            else if ("holvikehyksetTaidePatina".equals(labelType)) {
                                if (height == 120) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.holvikehyksetTaidePatinaImages[index], 70, 160);
                                }
                                else if (height == 160) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.holvikehyksetTaidePatinaImages[index], 90, 185);
                                }
                                else {
                                    break;
                                }
                            }
                            else if ("holvikehyksetKromaus".equals(labelType)) {
                                if (height == 120) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.holvikehyksetKromausImages[index], 70, 160);
                                }
                                else if (height == 160) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.holvikehyksetKromausImages[index], 90, 185);
                                }
                                else {
                                    break;
                                }
                            }
                            
                            else if ("kukatTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.kukatTummaPatinaImages[index], width, height, 
                                        1.05);
                            }
                            else if ("kukatKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.kukatKirkasImages[index], width, height, 
                                        1.05);
                            }
                            else if ("kukatTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.kukatTaidePatinaImages[index], width, height, 
                                        1.05);
                            }
                            else if ("kukatKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.kukatKromausImages[index], width, height, 
                                        1.05);
                            }   
                            
                            else if ("liekitJaLehvatTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.liekitJaLehvatTummaPatinaImages[index], width, height, 
                                        1.05);
                            }
                            else if ("liekitJaLehvatKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.liekitJaLehvatKirkasImages[index], width, height, 
                                        1.05);
                            }
                            else if ("liekitJaLehvatTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.liekitJaLehvatTaidePatinaImages[index], width, height, 
                                        1.05);
                            }
                            else if ("liekitJaLehvatKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.liekitJaLehvatKromausImages[index], width, height, 
                                        1.05);
                            }   
                            
                            else if ("linnutTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.linnutTummaPatinaImages[index], width, height, 
                                        1.05);
                            }
                            else if ("linnutKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.linnutKirkasImages[index], width, height, 
                                        1.05);
                            }
                            else if ("linnutTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.linnutTaidePatinaImages[index], width, height, 
                                        1.05);
                            }
                            else if ("linnutKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.linnutKromausImages[index], width, height, 
                                        1.05);
                            }   
                            
                            else if ("lyhtykehyksetTummaPatina".equals(labelType)) {
                                if (ImageArrays.lyhtykehyksetTummaPatinaImages[index].getDescription().contains("Suorak")) {
                                    if (height == 100) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetTummaPatinaImages[index].getImage(),
                                                70, 130);
                                    }
                                    else { break; }
                                }
                                else if (ImageArrays.lyhtykehyksetTummaPatinaImages[index].getDescription().contains("Ympyra")) {
                                    if (height == 90) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetTummaPatinaImages[index].getImage(),
                                                100, 100);
                                    }
                                    else { break; }
                                }
                                else if (ImageArrays.lyhtykehyksetTummaPatinaImages[index].getDescription().contains("Sydan")) {
                                    if (height == 90) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetTummaPatinaImages[index].getImage(),
                                                105, 115);
                                    }
                                    else { break; }
                                }
                            }
                            else if ("lyhtykehyksetKirkas".equals(labelType)) {
                                if (ImageArrays.lyhtykehyksetKirkasImages[index].getDescription().contains("Suorak")) {
                                    if (height == 100) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetKirkasImages[index].getImage(),
                                                70, 130);
                                    }
                                    else { break; }
                                }
                                else if (ImageArrays.lyhtykehyksetKirkasImages[index].getDescription().contains("Ympyra")) {
                                    if (height == 90) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetKirkasImages[index].getImage(),
                                                100, 100);
                                    }
                                    else { break; }
                                }
                                else if (ImageArrays.lyhtykehyksetKirkasImages[index].getDescription().contains("Sydan")) {
                                    if (height == 90) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetKirkasImages[index].getImage(),
                                                105, 115);
                                    }
                                    else { break; }
                                }
                            }
                            else if ("lyhtykehyksetTaidePatina".equals(labelType)) {
                                if (ImageArrays.lyhtykehyksetTaidePatinaImages[index].getDescription().contains("Suorak")) {
                                    if (height == 100) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetTaidePatinaImages[index].getImage(),
                                                70, 130);
                                    }
                                    else { break; }
                                }
                                else if (ImageArrays.lyhtykehyksetTaidePatinaImages[index].getDescription().contains("Ympyra")) {
                                    if (height == 90) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetTaidePatinaImages[index].getImage(),
                                                100, 100);
                                    }
                                    else { break; }
                                }
                                else if (ImageArrays.lyhtykehyksetTaidePatinaImages[index].getDescription().contains("Sydan")) {
                                    if (height == 90) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetTaidePatinaImages[index].getImage(),
                                                105, 115);
                                    }
                                    else { break; }
                                }
                            }
                            else if ("lyhtykehyksetKromaus".equals(labelType)) {
                                if (ImageArrays.lyhtykehyksetKromausImages[index].getDescription().contains("Suorak")) {
                                    if (height == 100) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetKromausImages[index].getImage(),
                                                70, 130);
                                    }
                                    else { break; }
                                }
                                else if (ImageArrays.lyhtykehyksetKromausImages[index].getDescription().contains("Ympyra")) {
                                    if (height == 90) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetKromausImages[index].getImage(),
                                                100, 100);
                                    }
                                    else { break; }
                                }
                                else if (ImageArrays.lyhtykehyksetKromausImages[index].getDescription().contains("Sydan")) {
                                    if (height == 90) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetKromausImages[index].getImage(),
                                                105, 115);
                                    }
                                    else { break; }
                                }
                            }   
                            
                            else if ("lyhtykehyksetRistiTummaPatina".equals(labelType)) {
                                if (height == 100) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetRistiTummaPatinaImages[index].getImage(),
                                            70, 130);
                                }
                                else { break; }
                            }
                            else if ("lyhtykehyksetRistiKirkas".equals(labelType)) {
                                if (height == 100) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetRistiKirkasImages[index].getImage(),
                                            70, 130);
                                }
                                else { break; }
                            }
                            else if ("lyhtykehyksetRistiTaidePatina".equals(labelType)) {
                                if (height == 100) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetRistiTaidePatinaImages[index].getImage(),
                                            70, 130);
                                }
                                else { break; }
                            }
                            else if ("lyhtykehyksetRistiKromaus".equals(labelType)) {
                                if (height == 100) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetRistiKromausImages[index].getImage(),
                                            70, 130);
                                }
                                else { break; }
                            }   
                            
                            else if ("muistolaatatMallit".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatMallitImages[index], width, height, 
                                        1.05);
                            }   
                            
                            else if ("muistolaatatPohjatKohoval".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatPohjatKohovalImages[index], width, height, 
                                        1.05);
                            }
                            else if ("muistolaatatPohjatLevylle".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatPohjatLevylleImages[index], width, height, 
                                        1.05);
                            }
                            else if ("muistolaatatPohjatRst".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatPohjatRstImages[index], width, height, 
                                        1.05);
                            }
                            else if ("muistolaatatPohjatValetut".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatPohjatValetutImages[index], width, height, 
                                        1.05);
                            }  
                            
                            else if ("muutSymbolitTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muutSymbolitTummaPatinaImages[index], width, height, 
                                        1.05);
                            }
                            else if ("muutSymbolitKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muutSymbolitKirkasImages[index], width, height, 
                                        1.05);
                            }
                            else if ("muutSymbolitTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muutSymbolitTaidePatinaImages[index], width, height, 
                                        1.05);
                            }
                            else if ("muutSymbolitKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muutSymbolitKromausImages[index], width, height, 
                                        1.05);
                            } 
                            
                            else if ("ornamentit".equals(labelType)) {
                                if (this.hautakivi.getHenkilo(0).getFontColor().equals(new Color(0, 0, 0))) {
                                    iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ornamentitMustaImages[index], width, height, 
                                        1.05);
                                }
                                else if (this.hautakivi.getHenkilo(0).getFontColor().equals(new Color(192, 192, 192))) {
                                    iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ornamentitHopeaImages[index], width, height, 
                                        1.05);
                                }
                                else {
                                    iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ornamentitKultaImages[index], width, height, 
                                        1.05);
                                }
                            }   
                            
                            else if ("pronssilyhdyt".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.pronssilyhdytImages[index], width, height, 
                                        1.05);
                            }   
                            
                            else if ("puutJaTahkatTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.puutJaTahkatTummaPatinaImages[index], width, height, 
                                        1.05);
                            }
                            else if ("puutJaTahkatKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.puutJaTahkatKirkasImages[index], width, height, 
                                        1.05);
                            }
                            else if ("puutJaTahkatTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.puutJaTahkatTaidePatinaImages[index], width, height, 
                                        1.05);
                            }
                            else if ("puutJaTahkatKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.puutJaTahkatKromausImages[index], width, height, 
                                        1.05);
                            }   
                            
                            else if ("ristitTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ristitTummaPatinaImages[index], width, height, 
                                        1.05);
                            }
                            else if ("ristitKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ristitKirkasImages[index], width, height, 
                                        1.05);
                            }
                            else if ("ristitTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ristitTaidePatinaImages[index], width, height, 
                                        1.05);
                            }
                            else if ("ristitKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ristitKromausImages[index], width, height, 
                                        1.05);
                            } 
                            
                            else if ("veteraanitunnukset".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.veteraanitunnuksetImages[index], width, height, 
                                        1.05);
                            }
                            
                            else if ("yhteenvaletutTekstitTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.yhteenvaletutTekstitTummaPatinaImages[index], width, height, 
                                        1.05);
                            }
                            else if ("yhteenvaletutTekstitKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.yhteenvaletutTekstitKirkasImages[index], width, height, 
                                        1.05);
                            }
                            else if ("yhteenvaletutTekstitTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.yhteenvaletutTekstitTaidePatinaImages[index], width, height, 
                                        1.05);
                            }
                            else if ("yhteenvaletutTekstitKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.yhteenvaletutTekstitKromausImages[index], width, height, 
                                        1.05);
                            } 
                            
                            else { break; }
                            
                        }
                        else if (button.getButtonType() == ControlButton.ButtonType.MINUSBUTTON) {
                            if (height < 10 || width < 10) {
                                break;
                            }
                            if ("enkelitTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.enkelitTummaPatinaImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("enkelitKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.enkelitKirkasImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("enkelitTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.enkelitTaidePatinaImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("enkelitKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.enkelitKromausImages[index], width, height, 
                                        (1/1.05));
                            }  
                            
                            else if ("holvikehyksetTummaPatina".equals(labelType)) {
                                if (height == 185) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.holvikehyksetTummaPatinaImages[index], 70, 160);
                                }
                                else if (height == 160) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.holvikehyksetTummaPatinaImages[index], 60, 120);
                                }
                                else {
                                    break;
                                }
                            }
                            else if ("holvikehyksetKirkas".equals(labelType)) {
                                if (height == 185) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.holvikehyksetKirkasImages[index], 70, 160);
                                }
                                else if (height == 160) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.holvikehyksetKirkasImages[index], 60, 120);
                                }
                                else {
                                    break;
                                }
                            }
                            else if ("holvikehyksetTaidePatina".equals(labelType)) {
                                if (height == 185) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.holvikehyksetTaidePatinaImages[index], 70, 160);
                                }
                                else if (height == 160) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.holvikehyksetTaidePatinaImages[index], 60, 120);
                                }
                                else {
                                    break;
                                }
                            }
                            else if ("holvikehyksetKromaus".equals(labelType)) {
                                if (height == 185) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.holvikehyksetKromausImages[index], 70, 160);
                                }
                                else if (height == 160) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.holvikehyksetKromausImages[index], 60, 120);
                                }
                                else {
                                    break;
                                }
                            }
                            
                            else if ("kukatTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.kukatTummaPatinaImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("kukatKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.kukatKirkasImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("kukatTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.kukatTaidePatinaImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("kukatKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.kukatKromausImages[index], width, height, 
                                        (1/1.05));
                            } 
                            
                            else if ("liekitJaLehvatTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.liekitJaLehvatTummaPatinaImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("liekitJaLehvatKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.liekitJaLehvatKirkasImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("liekitJaLehvatTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.liekitJaLehvatTaidePatinaImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("liekitJaLehvatKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.liekitJaLehvatKromausImages[index], width, height, 
                                        (1/1.05));
                            } 
                            
                            else if ("linnutTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.linnutTummaPatinaImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("linnutKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.linnutKirkasImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("linnutTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.linnutTaidePatinaImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("linnutKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.linnutKromausImages[index], width, height, 
                                        (1/1.05));
                            } 
                            
                            else if ("lyhtykehyksetTummaPatina".equals(labelType)) {
                                if (ImageArrays.lyhtykehyksetTummaPatinaImages[index].getDescription().contains("Suorak")) {
                                    if (height == 130) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetTummaPatinaImages[index].getImage(),
                                                60, 100);
                                    }
                                    else { break; }
                                }
                                else if (ImageArrays.lyhtykehyksetTummaPatinaImages[index].getDescription().contains("Ympyra")) {
                                    if (height == 100) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetTummaPatinaImages[index].getImage(),
                                                90, 90);
                                    }
                                    else { break; }
                                }
                                else if (ImageArrays.lyhtykehyksetTummaPatinaImages[index].getDescription().contains("Sydan")) {
                                    if (height == 115) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetTummaPatinaImages[index].getImage(),
                                                90, 90);
                                    }
                                    else { break; }
                                }
                            }
                            else if ("lyhtykehyksetKirkas".equals(labelType)) {
                                if (ImageArrays.lyhtykehyksetKirkasImages[index].getDescription().contains("Suorak")) {
                                    if (height == 130) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetKirkasImages[index].getImage(),
                                                60, 100);
                                    }
                                    else { break; }
                                }
                                else if (ImageArrays.lyhtykehyksetKirkasImages[index].getDescription().contains("Ympyra")) {
                                    if (height == 100) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetKirkasImages[index].getImage(),
                                                90, 90);
                                    }
                                    else { break; }
                                }
                                else if (ImageArrays.lyhtykehyksetKirkasImages[index].getDescription().contains("Sydan")) {
                                    if (height == 115) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetKirkasImages[index].getImage(),
                                                90, 90);
                                    }
                                    else { break; }
                                }
                            }
                            else if ("lyhtykehyksetTaidePatina".equals(labelType)) {
                                if (ImageArrays.lyhtykehyksetTaidePatinaImages[index].getDescription().contains("Suorak")) {
                                    if (height == 130) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetTaidePatinaImages[index].getImage(),
                                                60, 100);
                                    }
                                    else { break; }
                                }
                                else if (ImageArrays.lyhtykehyksetTaidePatinaImages[index].getDescription().contains("Ympyra")) {
                                    if (height == 100) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetTaidePatinaImages[index].getImage(),
                                                90, 90);
                                    }
                                    else { break; }
                                }
                                else if (ImageArrays.lyhtykehyksetTaidePatinaImages[index].getDescription().contains("Sydan")) {
                                    if (height == 115) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetTaidePatinaImages[index].getImage(),
                                                90, 90);
                                    }
                                    else { break; }
                                }
                            }
                            else if ("lyhtykehyksetKromaus".equals(labelType)) {
                                if (ImageArrays.lyhtykehyksetKromausImages[index].getDescription().contains("Suorak")) {
                                    if (height == 130) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetKromausImages[index].getImage(),
                                                60, 100);
                                    }
                                    else { break; }
                                }
                                else if (ImageArrays.lyhtykehyksetKromausImages[index].getDescription().contains("Ympyra")) {
                                    if (height == 100) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetKromausImages[index].getImage(),
                                                90, 90);
                                    }
                                    else { break; }
                                }
                                else if (ImageArrays.lyhtykehyksetKromausImages[index].getDescription().contains("Sydan")) {
                                    if (height == 115) {
                                        iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetKromausImages[index].getImage(),
                                                90, 90);
                                    }
                                    else { break; }
                                }
                            } 
                            
                            else if ("lyhtykehyksetRistiTummaPatina".equals(labelType)) {
                                if (height == 130) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetRistiTummaPatinaImages[index].getImage(),
                                            60, 100);
                                }
                                else { break; }
                            }
                            else if ("lyhtykehyksetRistiKirkas".equals(labelType)) {
                                if (height == 130) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetRistiKirkasImages[index].getImage(),
                                            60, 100);
                                }
                                else { break; }
                            }
                            else if ("lyhtykehyksetRistiTaidePatina".equals(labelType)) {
                                if (height == 130) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetRistiTaidePatinaImages[index].getImage(),
                                            60, 100);
                                }
                                else { break; }
                            }
                            else if ("lyhtykehyksetRistiKromaus".equals(labelType)) {
                                if (height == 130) {
                                    iconImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.lyhtykehyksetRistiKromausImages[index].getImage(),
                                            60, 100);
                                }
                                else { break; }
                            } 
                            
                            else if ("muistolaatatMallit".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatMallitImages[index], width, height, 
                                        (1/1.05));
                            }  
                            
                            else if ("muistolaatatPohjatKohoval".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatPohjatKohovalImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("muistolaatatPohjatLevylle".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatPohjatLevylleImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("muistolaatatPohjatRst".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatPohjatRstImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("muistolaatatPohjatValetut".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatPohjatValetutImages[index], width, height, 
                                        (1/1.05));
                            }  
                            
                            else if ("muutSymbolitTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muutSymbolitTummaPatinaImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("muutSymbolitKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muutSymbolitKirkasImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("muutSymbolitTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muutSymbolitTaidePatinaImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("muutSymbolitKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muutSymbolitKromausImages[index], width, height, 
                                        (1/1.05));
                            } 
                            
                            else if ("ornamentit".equals(labelType)) {
                                if (this.hautakivi.getHenkilo(0).getFontColor().equals(new Color(0, 0, 0))) {
                                    iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ornamentitMustaImages[index], width, height, 
                                        (1/1.05));
                                }
                                else if (this.hautakivi.getHenkilo(0).getFontColor().equals(new Color(192, 192, 192))) {
                                    iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ornamentitHopeaImages[index], width, height, 
                                        (1/1.05));
                                }
                                else {
                                    iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ornamentitKultaImages[index], width, height, 
                                        (1/1.05));
                                }
                            }  
                            
                            else if ("pronssilyhdyt".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.pronssilyhdytImages[index], width, height, 
                                        (1/1.05));
                            }  
                            
                            else if ("puutJaTahkatTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.puutJaTahkatTummaPatinaImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("puutJaTahkatKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.puutJaTahkatKirkasImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("puutJaTahkatTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.puutJaTahkatTaidePatinaImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("puutJaTahkatKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.puutJaTahkatKromausImages[index], width, height, 
                                        (1/1.05));
                            } 
                            
                            else if ("ristitTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ristitTummaPatinaImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("ristitKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ristitKirkasImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("ristitTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ristitTaidePatinaImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("ristitKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ristitKromausImages[index], width, height, 
                                        (1/1.05));
                            } 
                            
                            else if ("veteraanitunnukset".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.veteraanitunnuksetImages[index], width, height, 
                                        (1/1.05));
                            }
                            
                            else if ("yhteenvaletutTekstitTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.yhteenvaletutTekstitTummaPatinaImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("yhteenvaletutTekstitKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.yhteenvaletutTekstitKirkasImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("yhteenvaletutTekstitTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.yhteenvaletutTekstitTaidePatinaImages[index], width, height, 
                                        (1/1.05));
                            }
                            else if ("yhteenvaletutTekstitKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.yhteenvaletutTekstitKromausImages[index], width, height, 
                                        (1/1.05));
                            } 
                            
                            else { break; }
                        }
                        /* update the object */
                        this.hautakivi.getKoriste(i).setKoristeKorkeus(iconImage.getHeight());
                        this.hautakivi.getKoriste(i).setKoristeLeveys(iconImage.getWidth());

                        iconImage = HautakiviohjelmaUI.rotateImage(iconImage, StrictMath.toRadians((double)koristeKierto));
                        this.esikatseluKoristeLabel[i].setIcon(new ImageIcon(iconImage));
                        
                        /* calculate new bounds for koriste */
                        size = esikatseluKoristeLabel[i].getPreferredSize();
                        esikatseluKoristeLabel[i].setBounds(esikatseluKoristeLabel[i].getX(), esikatseluKoristeLabel[i].getY(), size.width+5, size.height+5);  
                        
                        break;
                        
                        case "koristeKierto":
                            if (button.getButtonType() == ControlButton.ButtonType.PLUSBUTTON) {
                                /* set a new value for hautakivi object */
                                if (koristeKierto == 355) {
                                    this.hautakivi.getKoriste(i).setKoristeKierto(0);
                                    koristeKierto = 0;
                                }
                                else {
                                    this.hautakivi.getKoriste(i).setKoristeKierto(koristeKierto+5);
                                    koristeKierto += 5;
                                }
                            }
                            else if (button.getButtonType() == ControlButton.ButtonType.MINUSBUTTON) {
                                /* set a new value for hautakivi object */
                                if (koristeKierto == 0) {
                                    this.hautakivi.getKoriste(i).setKoristeKierto(355);
                                    koristeKierto = 355;
                                }
                                else {
                                    this.hautakivi.getKoriste(i).setKoristeKierto(koristeKierto-5);
                                    koristeKierto -= 5;
                                }
                            }
                            
                            if ("enkelitTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.enkelitTummaPatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("enkelitKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.enkelitKirkasImages[index], width, height, 
                                        1.0);
                            }
                            else if ("enkelitTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.enkelitTaidePatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("enkelitKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.enkelitKromausImages[index], width, height, 
                                        1.0);
                            }
                            
                            else if ("holvikehyksetTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.holvikehyksetTummaPatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("holvikehyksetKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.holvikehyksetKirkasImages[index], width, height, 
                                        1.0);
                            }
                            else if ("holvikehyksetTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.holvikehyksetTaidePatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("holvikehyksetKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.holvikehyksetKromausImages[index], width, height, 
                                        1.0);
                            }
                            
                            else if ("kukatTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.kukatTummaPatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("kukatKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.kukatKirkasImages[index], width, height, 
                                        1.0);
                            }
                            else if ("kukatTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.kukatTaidePatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("kukatKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.kukatKromausImages[index], width, height, 
                                        1.0);
                            }   
                            
                            else if ("liekitJaLehvatTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.liekitJaLehvatTummaPatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("liekitJaLehvatKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.liekitJaLehvatKirkasImages[index], width, height, 
                                        1.0);
                            }
                            else if ("liekitJaLehvatTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.liekitJaLehvatTaidePatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("liekitJaLehvatKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.liekitJaLehvatKromausImages[index], width, height, 
                                        1.0);
                            }   
                            
                            else if ("linnutTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.linnutTummaPatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("linnutKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.linnutKirkasImages[index], width, height, 
                                        1.0);
                            }
                            else if ("linnutTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.linnutTaidePatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("linnutKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.linnutKromausImages[index], width, height, 
                                        1.0);
                            }   
                            
                            else if ("lyhtykehyksetTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.lyhtykehyksetTummaPatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("lyhtykehyksetKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.lyhtykehyksetKirkasImages[index], width, height, 
                                        1.0);
                            }
                            else if ("lyhtykehyksetTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.lyhtykehyksetTaidePatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("lyhtykehyksetKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.lyhtykehyksetKromausImages[index], width, height, 
                                        1.0);
                            }   
                            
                            else if ("lyhtykehyksetRistiTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.lyhtykehyksetRistiTummaPatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("lyhtykehyksetRistiKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.lyhtykehyksetRistiKirkasImages[index], width, height, 
                                        1.0);
                            }
                            else if ("lyhtykehyksetRistiTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.lyhtykehyksetRistiTaidePatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("lyhtykehyksetRistiKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.lyhtykehyksetRistiKromausImages[index], width, height, 
                                        1.0);
                            }   
                            
                            else if ("muistolaatatMallit".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatMallitImages[index], width, height, 
                                        1.0);
                            }   
                            
                            else if ("muistolaatatPohjatKohoval".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatPohjatKohovalImages[index], width, height, 
                                        1.0);
                            }
                            else if ("muistolaatatPohjatLevylle".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatPohjatLevylleImages[index], width, height, 
                                        1.0);
                            }
                            else if ("muistolaatatPohjatRst".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatPohjatRstImages[index], width, height, 
                                        1.0);
                            }
                            else if ("muistolaatatPohjatValetut".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatPohjatValetutImages[index], width, height, 
                                        1.0);
                            }  
                            
                            else if ("muutSymbolitTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muutSymbolitTummaPatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("muutSymbolitKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muutSymbolitKirkasImages[index], width, height, 
                                        1.0);
                            }
                            else if ("muutSymbolitTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muutSymbolitTaidePatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("muutSymbolitKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muutSymbolitKromausImages[index], width, height, 
                                        1.0);
                            } 
                            
                            else if ("ornamentit".equals(labelType)) {
                                if (this.hautakivi.getHenkilo(0).getFontColor().equals(new Color(0, 0, 0))) {
                                    iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ornamentitMustaImages[index], width, height, 
                                        1.0);
                                }
                                else if (this.hautakivi.getHenkilo(0).getFontColor().equals(new Color(192, 192, 192))) {
                                    iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ornamentitHopeaImages[index], width, height, 
                                        1.0);
                                }
                                else {
                                    iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ornamentitKultaImages[index], width, height, 
                                        1.0);
                                }
                            }   
                            
                            else if ("pronssilyhdyt".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.pronssilyhdytImages[index], width, height, 
                                        1.0);
                            }   
                            
                            else if ("puutJaTahkatTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.puutJaTahkatTummaPatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("puutJaTahkatKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.puutJaTahkatKirkasImages[index], width, height, 
                                        1.0);
                            }
                            else if ("puutJaTahkatTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.puutJaTahkatTaidePatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("puutJaTahkatKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.puutJaTahkatKromausImages[index], width, height, 
                                        1.0);
                            }   
                            
                            else if ("ristitTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ristitTummaPatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("ristitKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ristitKirkasImages[index], width, height, 
                                        1.0);
                            }
                            else if ("ristitTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ristitTaidePatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("ristitKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ristitKromausImages[index], width, height, 
                                        1.0);
                            } 
                            
                            else if ("veteraanitunnukset".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.veteraanitunnuksetImages[index], width, height, 
                                        1.0);
                            }
                            
                            else if ("yhteenvaletutTekstitTummaPatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.yhteenvaletutTekstitTummaPatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("yhteenvaletutTekstitKirkas".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.yhteenvaletutTekstitKirkasImages[index], width, height, 
                                        1.0);
                            }
                            else if ("yhteenvaletutTekstitTaidePatina".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.yhteenvaletutTekstitTaidePatinaImages[index], width, height, 
                                        1.0);
                            }
                            else if ("yhteenvaletutTekstitKromaus".equals(labelType)) {
                                iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.yhteenvaletutTekstitKromausImages[index], width, height, 
                                        1.0);
                            } 
                            
                            else { break; }
                            iconImage = HautakiviohjelmaUI.rotateImage(iconImage, StrictMath.toRadians((double)koristeKierto));
                            esikatseluKoristeLabel[i].setIcon(new ImageIcon(iconImage));
                            
                            /* calculate new bounds for koriste */
                            size = esikatseluKoristeLabel[i].getPreferredSize();
                            posX = esikatseluKoristeLabel[i].getX();
                            posY = esikatseluKoristeLabel[i].getY();
                            esikatseluKoristeLabel[i].setBounds(posX, posY, size.width+5, size.height+5);
                            esikatseluKoristeLabel[i].revalidate();
                      
                            break;
                            
                         case "koristePinossa":
                            pinossa = this.hautakivi.getKoriste(i).getKoristePinossa();
                            if (button.getButtonType() == ControlButton.ButtonType.PLUSBUTTON && pinossa > 0) {
                                pinossa -= 1;
                                esikatseluMuotoPanel.setPosition(esikatseluKoristeLabel[i], pinossa);
                                esikatseluMuotoPanel.revalidate();
                                /* update the object */
                                this.hautakivi.getKoriste(i).setKoristePinossa(pinossa);
                            }
                            else if (button.getButtonType() == ControlButton.ButtonType.MINUSBUTTON && pinossa < Hautakivi.KORISTEMAARA && 
                                    pinossa < this.hautakivi.getKoristeCounter()) {
                                pinossa += 1;
                                esikatseluMuotoPanel.setPosition(esikatseluKoristeLabel[i], pinossa);
                                esikatseluMuotoPanel.revalidate();
                                /* update the object */
                                this.hautakivi.getKoriste(i).setKoristePinossa(pinossa);
                            }
                            break;

                }
            }
        }
    }
}