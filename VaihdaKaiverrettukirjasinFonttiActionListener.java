/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JList;
import javax.swing.border.EtchedBorder;

/**
 *
 * @author Juha-Pekka
 */
public class VaihdaKaiverrettukirjasinFonttiActionListener implements ActionListener {
    
    private EsikatseluSukunimi esikatseluSukunimi;
    private EsikatseluHenkiloPanel[] esikatseluHenkiloPanel;
    private EsikatseluHenkilo[] esikatseluHenkilo;
    private JList fontList;
    private Hautakivi hautakivi;

    public VaihdaKaiverrettukirjasinFonttiActionListener(EsikatseluSukunimi esikatseluSukunimi, EsikatseluHenkiloPanel[] esikatseluHenkiloPanel, 
            EsikatseluHenkilo[] esikatseluHenkilo, JList fontList, Hautakivi hautakivi) {
        
        this.esikatseluSukunimi = esikatseluSukunimi;
        this.esikatseluHenkiloPanel = esikatseluHenkiloPanel;
        this.esikatseluHenkilo = esikatseluHenkilo;
        this.fontList = fontList;
        this.hautakivi = hautakivi;
    }
       
            
    @Override
    public void actionPerformed(ActionEvent e) {
        /* get the index for a selected font */
        int index = fontList.getMinSelectionIndex();
        
        Dimension size;
        float fontSize;
        EsikatseluJLabel sukunimiKaiverrettu = this.esikatseluSukunimi.getKaiverrettukirjasinTxt();
        SukunimiPanel sukunimiMetallikirjasin = this.esikatseluSukunimi.getMetallikirjasinTxt();
        
        /* change font for sukunimi */
        if (sukunimiKaiverrettu.isChosen()) {
            fontSize =  this.hautakivi.getSukunimiFontSize();
            sukunimiKaiverrettu.setFont(MyFonts.fontLib[index].deriveFont((float)fontSize));

            /* calculate new bounds for sukunimi */
            size = sukunimiKaiverrettu.getPreferredSize();
            sukunimiKaiverrettu.setBounds(sukunimiKaiverrettu.getX(), sukunimiKaiverrettu.getY(), size.width+5, size.height+5);
            
            /* update the object */
            this.hautakivi.setSukunimiKaiverrettu(true);
            this.hautakivi.setSukunimiFontIndex(index);
            this.hautakivi.setSukunimiFontWidth(0);
        }
        else if (sukunimiMetallikirjasin.isChosen()) {
            fontSize =  this.hautakivi.getSukunimiFontSize();
            sukunimiKaiverrettu.setFont(MyFonts.fontLib[index].deriveFont((float)fontSize));
            
            /* calculate new bounds for sukunimi */
            size = sukunimiKaiverrettu.getPreferredSize();
            sukunimiKaiverrettu.setBounds(sukunimiMetallikirjasin.getX(), sukunimiMetallikirjasin.getY(), size.width+5, size.height+5);
            sukunimiKaiverrettu.setBorder(BorderFactory.createEtchedBorder(EtchedBorder.LOWERED));
            
            /* update the object */
            this.hautakivi.setSukunimiKaiverrettu(true);
            this.hautakivi.setSukunimiFontIndex(index);
            this.hautakivi.setSukunimiFontWidth(0);
            
            /* switch from metallikirjasin to kaiverrettu one */
            sukunimiMetallikirjasin.setChosen(false);
            sukunimiMetallikirjasin.setVisible(false);
            sukunimiKaiverrettu.setChosen(true);
            sukunimiKaiverrettu.setVisible(true);
        }
        /* change font for henkilo */
        else {
            for (int i=0; i<this.esikatseluHenkiloPanel.length; i++) {
                if (this.esikatseluHenkiloPanel[i].isChosen()) {
                    this.esikatseluHenkilo[i].setFontKaiverrettu(MyFonts.fontLib[index].deriveFont((float)20f));
                    
                    if (!this.esikatseluHenkilo[i].isKaiverrettuKirjasin()) {
                        /* switch from metallikirjasin to kaiverrettu one */
                        this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasin().setVisible(false);
                        this.esikatseluHenkilo[i].getEtunimetMetallikirjasin().setVisible(false);
                        this.esikatseluHenkilo[i].getOsMetallikirjasin().setVisible(false);
                        this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasin().setVisible(false);
                    
                        this.esikatseluHenkilo[i].getVapaaTekstiKaiverrettu().setVisible(true);
                        this.esikatseluHenkilo[i].getEtunimetKaiverrettu().setVisible(true);
                        this.esikatseluHenkilo[i].getOsKaiverrettu().setVisible(true);
                        this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaKaiverrettu().setVisible(true);
                        
                        this.esikatseluHenkilo[i].setKaiverrettuKirjasin(true);
                        
                        this.hautakivi.getHenkilo(i).setHenkiloKaiverrettu(true);
                    }
                    
                    /* calculate new bounds for esikatseluhenkilopanel */
                    size = this.esikatseluHenkiloPanel[i].getPreferredSize();
                    this.esikatseluHenkiloPanel[i].setBounds(this.esikatseluHenkiloPanel[i].getX(), this.esikatseluHenkiloPanel[i].getY(), 
                            size.width+5, size.height+5);
                    this.esikatseluHenkiloPanel[i].revalidate();
                    
                    /* update the object */
                    this.hautakivi.getHenkilo(i).setFontWidth(0);
                    this.hautakivi.getHenkilo(i).setFontIndex(index);
                    this.hautakivi.getHenkilo(i).setFontSize(20f);
                    
                    break;
                }
            }
        }
    }
}