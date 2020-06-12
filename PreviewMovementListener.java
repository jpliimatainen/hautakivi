/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Component;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JRadioButton;
import javax.swing.JTabbedPane;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Juha-Pekka
 */
public class PreviewMovementListener extends MouseAdapter { 
    
    EsikatseluJLabel esikatseluJLabelComp;
    EsikatseluHenkiloPanel henkiloComp;
    SukunimiPanel sukunimiPanelComp;
    Component comp;
    int posX;
    int posY;
    static int offsetX;
    static int offsetY;
    
    private EsikatseluSukunimi esikatseluSukunimi;
    private EsikatseluHenkiloPanel[] esikatseluHenkiloPanel;
    private EsikatseluHenkilo[] esikatseluHenkilo;
    private EsikatseluJLabel[] esikatseluKoristeLabel;
    private JTabbedPane tabbedPane;
    private JList fontList;
    private JButton vaihdaKaiverrettukirjasinFontti;
    private JButton vaihdaMetallikirjasinFontti;
    private JRadioButton metallikirjasin;
    
    public PreviewMovementListener(EsikatseluSukunimi esikatseluSukunimi, EsikatseluHenkiloPanel[] esikatseluHenkiloPanel, 
            EsikatseluHenkilo[] esikatseluHenkilo, EsikatseluJLabel[] esikatseluKoristeLabel, JTabbedPane tabbedPane, JList fontList, 
            JButton vaihdaKaiverrettukirjasinFontti, JButton vaihdaMetallikirjasinFontti, JRadioButton metallikirjasin) {
        this.esikatseluSukunimi = esikatseluSukunimi;
        this.esikatseluHenkiloPanel = esikatseluHenkiloPanel;
        this.esikatseluHenkilo = esikatseluHenkilo;
        this.esikatseluKoristeLabel = esikatseluKoristeLabel;
        this.tabbedPane = tabbedPane;
        this.fontList = fontList;
        this.vaihdaKaiverrettukirjasinFontti = vaihdaKaiverrettukirjasinFontti;
        this.vaihdaMetallikirjasinFontti = vaihdaMetallikirjasinFontti;
        this.metallikirjasin = metallikirjasin;
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
    
    @Override
    public void mousePressed(MouseEvent e) {
        offsetX = e.getX();
        offsetY = e.getY();
    }
    
    @Override
    public void mouseDragged(MouseEvent e) {
    
        /* update preview panel */
        comp = e.getComponent();
        posX = comp.getX() - offsetX + e.getX();
        posY = comp.getY() - offsetY + e.getY();
        comp.setLocation(posX, posY);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        String fontName;
        int index;
        
        /* set vaihda fontti button visible if metallifontti selected */
        if (this.metallikirjasin.isSelected()) {
            this.vaihdaMetallikirjasinFontti.setVisible(true);
            this.vaihdaKaiverrettukirjasinFontti.setVisible(false);
        }
        else {
            this.vaihdaKaiverrettukirjasinFontti.setVisible(true);
            this.vaihdaMetallikirjasinFontti.setVisible(false);
        }
        /* mark all objects as unselected */
        this.esikatseluSukunimi.getKaiverrettukirjasinTxt().setChosen(false);
        this.esikatseluSukunimi.getKaiverrettukirjasinTxt().setBorder(BorderFactory.createEmptyBorder());
        
        this.esikatseluSukunimi.getMetallikirjasinTxt().setChosen(false);
        this.esikatseluSukunimi.getMetallikirjasinTxt().setBorder(BorderFactory.createEmptyBorder());
        
        for (int j=0; j<Hautakivi.HENKILOMAARA; j++) {
            this.esikatseluHenkiloPanel[j].setChosen(false);
            this.esikatseluHenkiloPanel[j].setBorder(BorderFactory.createEmptyBorder());
        }
        
        for (int j=0; j<Hautakivi.KORISTEMAARA; j++) {
            this.esikatseluKoristeLabel[j].setChosen(false);
            this.esikatseluKoristeLabel[j].setBorder(BorderFactory.createEmptyBorder());
        }

        comp = e.getComponent();
        
        /* mark this object as selected */
        if (comp instanceof EsikatseluJLabel) {
            esikatseluJLabelComp = (EsikatseluJLabel)comp;
            esikatseluJLabelComp.setChosen(true);
            esikatseluJLabelComp.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
            if ("sukunimi".equals(esikatseluJLabelComp.getLabelTypeText())) {  // kaiverrettu sukunimi
                this.tabbedPane.setSelectedIndex(this.tabbedPane.indexOfTab("Tekstit")); // activate tekstit tab
                /* set selected item in the fontlist */
                fontName = esikatseluJLabelComp.getFont().getName();
                
                switch (fontName) {
                    case "Alex Brush":
                        this.fontList.setSelectedIndex(0);
                        break;
                    case "BlackChancery":
                        this.fontList.setSelectedIndex(1);
                        break;
                    case "CoventryScriptFLF":
                        this.fontList.setSelectedIndex(2);
                        break;
                    case "Optima Bold":
                        this.fontList.setSelectedIndex(3);
                        break;
                    case "Sanvito-Roman":
                        this.fontList.setSelectedIndex(4);
                        break;
                    default: break;
                }
            }
            else { // koriste selected
                this.tabbedPane.setSelectedIndex(this.tabbedPane.indexOfTab("Koristeet")); // activate koristeet tab        
            } 
        }
        else if (comp instanceof SukunimiPanel) { // metallikirjasin sukunimi
            sukunimiPanelComp = (SukunimiPanel)comp;
            sukunimiPanelComp.setChosen(true);
            sukunimiPanelComp.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
            this.tabbedPane.setSelectedIndex(this.tabbedPane.indexOfTab("Tekstit")); // activate tekstit tab
        }
        else if (comp instanceof EsikatseluHenkiloPanel) {
            henkiloComp = (EsikatseluHenkiloPanel)comp;
            henkiloComp.setChosen(true);
            henkiloComp.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
            this.tabbedPane.setSelectedIndex(this.tabbedPane.indexOfTab("Tekstit")); // activate tekstit tab
            index = henkiloComp.getIndex();
            if (this.esikatseluHenkilo[index].isKaiverrettuKirjasin()) {
                /* set selected item in the fontlist */
                fontName = this.esikatseluHenkilo[henkiloComp.getIndex()].getVapaaTekstiFontKaiverrettu().getName();
            
                switch (fontName) {
                    case "Alex Brush":
                        this.fontList.setSelectedIndex(0);
                        break;
                    case "BlackChancery":
                        this.fontList.setSelectedIndex(1);
                        break;
                    case "CoventryScriptFLF":
                        this.fontList.setSelectedIndex(2);
                        break;
                    case "Optima Bold":
                        this.fontList.setSelectedIndex(3);
                        break;
                    case "Sanvito-Roman":
                        this.fontList.setSelectedIndex(4);
                        break;
                    default: break;
                }
            }
            else { // metallikirjasin
                this.tabbedPane.setSelectedIndex(this.tabbedPane.indexOfTab("Tekstit")); // activate tekstit tab
            }
        }
    }
}