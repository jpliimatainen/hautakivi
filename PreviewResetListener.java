/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.JButton;

/**
 *
 * @author Juha-Pekka
 */
public class PreviewResetListener extends MouseAdapter { 
    
    private EsikatseluSukunimi esikatseluSukunimi;
    private EsikatseluHenkiloPanel[] esikatseluHenkiloPanel;
    private EsikatseluJLabel[] esikatseluKoristeLabel;
    private JButton vaihdaKaiverrettunakirjasinFontti;
    private JButton vaihdaMetallikirjasinFontti;
    
    public PreviewResetListener(EsikatseluSukunimi esikatseluSukunimi, EsikatseluHenkiloPanel[] esikatseluHenkiloPanel, 
            EsikatseluJLabel[] esikatseluKoristeLabel, JButton vaihdaKaiverrettunakirjasinFontti, JButton vaihdaMetallikirjasinFontti) {
        this.esikatseluSukunimi = esikatseluSukunimi;
        this.esikatseluHenkiloPanel = esikatseluHenkiloPanel;
        this.esikatseluKoristeLabel = esikatseluKoristeLabel;
        this.vaihdaKaiverrettunakirjasinFontti = vaihdaKaiverrettunakirjasinFontti;
        this.vaihdaMetallikirjasinFontti = vaihdaMetallikirjasinFontti;
    }
    
    
    @Override
    public void mouseClicked(MouseEvent e) {
        
        /* mark all objects as unselected */
        esikatseluSukunimi.getKaiverrettukirjasinTxt().setChosen(false);
        esikatseluSukunimi.getKaiverrettukirjasinTxt().setBorder(BorderFactory.createEmptyBorder());
        
        esikatseluSukunimi.getMetallikirjasinTxt().setChosen(false);
        esikatseluSukunimi.getMetallikirjasinTxt().setBorder(BorderFactory.createEmptyBorder());
        
        for (int j=0; j<Hautakivi.HENKILOMAARA; j++) {
            esikatseluHenkiloPanel[j].setChosen(false);
            esikatseluHenkiloPanel[j].setBorder(BorderFactory.createEmptyBorder());
        }
        
        for (int j=0; j<Hautakivi.KORISTEMAARA; j++) {
            esikatseluKoristeLabel[j].setChosen(false);
            esikatseluKoristeLabel[j].setBorder(BorderFactory.createEmptyBorder());
        }
        
        
        /* set elements invisible */
        this.vaihdaMetallikirjasinFontti.setVisible(false);
        this.vaihdaKaiverrettunakirjasinFontti.setVisible(false);
    }
}