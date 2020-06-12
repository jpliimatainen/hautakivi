/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

/**
 *
 * @author Juha-Pekka
 */
public class VaihdaKirjasinTyyppiActionListener implements ActionListener {

    private JLabel valitseFonttiVariLbl;
    private JPanel valitseVariPanel;
    private JScrollPane fontListScrollPane;
    private JLabel valitseFonttiLbl;
    private JLabel metallikirjasinTyyppiLbl;
    private JComboBox metallikirjasinTyyppiCbox;
    private JLabel metallikirjasinAlaTyyppiLbl;
    private JComboBox metallikirjasinAlaTyyppiCbox;
    private JLabel metallikirjasinEsikatseluLabel;
    private EsikatseluJLabel metallikirjasinEsikatselu;
    private JButton vaihdaMetallikirjasinFontti;
    private JButton vaihdaKaiverrettukirjasinFontti;
    private JTextField sukunimiTxt;
    private JTextField vapaaTxt1;
    private JTextField vapaaTxt2;
    private JTextField vapaaTxt3;
    private JTextField vapaaTxt4;
    private JTextField etunimiTxt1;
    private JTextField etunimiTxt2;
    private JTextField etunimiTxt3;
    private JTextField etunimiTxt4;
    private JTextField osTxt1;
    private JTextField osTxt2;
    private JTextField osTxt3;
    private JTextField osTxt4;
    private JTextField syntymaAikaTxt1;
    private JTextField syntymaAikaTxt2;
    private JTextField syntymaAikaTxt3;
    private JTextField syntymaAikaTxt4;
    private JTextField kuolinAikaTxt1;
    private JTextField kuolinAikaTxt2;
    private JTextField kuolinAikaTxt3;
    private JTextField kuolinAikaTxt4;
    private EsikatseluSukunimi esikatseluSukunimi;
    private EsikatseluHenkiloPanel[] esikatseluHenkiloPanel;
    

    public VaihdaKirjasinTyyppiActionListener(JLabel valitseFonttiVariLbl, JPanel valitseVariPanel, JScrollPane fontListScrollPane, JLabel valitseFonttiLbl, 
            JLabel metallikirjasinTyyppiLbl, JComboBox metallikirjasinTyyppiCbox, JLabel metallikirjasinAlaTyyppiLbl, JComboBox metallikirjasinAlaTyyppiCbox,
            JLabel metallikirjasinEsikatseluLabel, EsikatseluJLabel metallikirjasinEsikatselu, JButton vaihdaMetallikirjasinFontti, JButton vaihdaKaiverrettukirjasinFontti, 
            JTextField sukunimiTxt, JTextField vapaaTxt1, JTextField vapaaTxt2, JTextField vapaaTxt3, JTextField vapaaTxt4, JTextField etunimiTxt1, JTextField etunimiTxt2, 
            JTextField etunimiTxt3, JTextField etunimiTxt4, JTextField osTxt1, JTextField osTxt2, JTextField osTxt3, JTextField osTxt4, JTextField syntymaAikaTxt1, 
            JTextField syntymaAikaTxt2, JTextField syntymaAikaTxt3, JTextField syntymaAikaTxt4, JTextField kuolinAikaTxt1, JTextField kuolinAikaTxt2, JTextField kuolinAikaTxt3, 
            JTextField kuolinAikaTxt4, EsikatseluSukunimi esikatseluSukunimi, EsikatseluHenkiloPanel[] esikatseluHenkiloPanel) {
        
        this.valitseFonttiVariLbl = valitseFonttiVariLbl;
        this.valitseVariPanel = valitseVariPanel;
        this.fontListScrollPane = fontListScrollPane;
        this.valitseFonttiLbl = valitseFonttiLbl;
        this.metallikirjasinTyyppiLbl = metallikirjasinTyyppiLbl;
        this.metallikirjasinTyyppiCbox = metallikirjasinTyyppiCbox;
        this.metallikirjasinAlaTyyppiLbl = metallikirjasinAlaTyyppiLbl;
        this.metallikirjasinAlaTyyppiCbox = metallikirjasinAlaTyyppiCbox;
        this.metallikirjasinEsikatseluLabel = metallikirjasinEsikatseluLabel;
        this.metallikirjasinEsikatselu = metallikirjasinEsikatselu;
        this.vaihdaMetallikirjasinFontti = vaihdaMetallikirjasinFontti;
        this.vaihdaKaiverrettukirjasinFontti = vaihdaKaiverrettukirjasinFontti;
        this.sukunimiTxt = sukunimiTxt;
        this.vapaaTxt1 = vapaaTxt1;
        this.vapaaTxt2 = vapaaTxt2;
        this.vapaaTxt3 = vapaaTxt3;
        this.vapaaTxt4 = vapaaTxt4;
        this.etunimiTxt1 = etunimiTxt1;
        this.etunimiTxt2 = etunimiTxt2;
        this.etunimiTxt3 = etunimiTxt3;
        this.etunimiTxt4 = etunimiTxt4;
        this.osTxt1 = osTxt1;
        this.osTxt2 = osTxt2;
        this.osTxt3 = osTxt3;
        this.osTxt4 = osTxt4;
        this.syntymaAikaTxt1 = syntymaAikaTxt1;
        this.syntymaAikaTxt2 = syntymaAikaTxt2;
        this.syntymaAikaTxt3 = syntymaAikaTxt3;
        this.syntymaAikaTxt4 = syntymaAikaTxt4;
        this.kuolinAikaTxt1 = kuolinAikaTxt1;
        this.kuolinAikaTxt2 = kuolinAikaTxt2;
        this.kuolinAikaTxt3 = kuolinAikaTxt3;
        this.kuolinAikaTxt4 = kuolinAikaTxt4;
        this.esikatseluSukunimi = esikatseluSukunimi;
        this.esikatseluHenkiloPanel = esikatseluHenkiloPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        
        switch (actionCommand) {
            case "kaiverrettuna":
                this.valitseFonttiVariLbl.setVisible(true);
                this.valitseVariPanel.setVisible(true);
                this.fontListScrollPane.setVisible(true);
                this.valitseFonttiLbl.setVisible(true);
                
                this.sukunimiTxt.setEnabled(true);
                this.vapaaTxt1.setEnabled(true);
                this.vapaaTxt2.setEnabled(true);
                this.vapaaTxt3.setEnabled(true);
                this.vapaaTxt4.setEnabled(true);
                this.etunimiTxt1.setEnabled(true);
                this.etunimiTxt2.setEnabled(true);
                this.etunimiTxt3.setEnabled(true);
                this.etunimiTxt4.setEnabled(true);
                this.osTxt1.setEnabled(true);
                this.osTxt2.setEnabled(true);
                this.osTxt3.setEnabled(true);
                this.osTxt4.setEnabled(true);
                this.syntymaAikaTxt1.setEnabled(true);
                this.syntymaAikaTxt2.setEnabled(true);
                this.syntymaAikaTxt3.setEnabled(true);
                this.syntymaAikaTxt4.setEnabled(true);
                this.kuolinAikaTxt1.setEnabled(true);
                this.kuolinAikaTxt2.setEnabled(true);
                this.kuolinAikaTxt3.setEnabled(true);
                this.kuolinAikaTxt4.setEnabled(true);
                
                if (this.esikatseluSukunimi.getKaiverrettukirjasinTxt().isChosen()) {
                    this.vaihdaKaiverrettukirjasinFontti.setVisible(true);
                }
                else if (this.esikatseluSukunimi.getMetallikirjasinTxt().isChosen()) {
                    this.vaihdaKaiverrettukirjasinFontti.setVisible(true);
                }
                else {
                    for (EsikatseluHenkiloPanel esikatseluHlo : esikatseluHenkiloPanel) {
                        if (esikatseluHlo.isChosen()) {
                            this.vaihdaKaiverrettukirjasinFontti.setVisible(true);
                            break;
                        }
                    }  
                } 
                
                this.metallikirjasinTyyppiLbl.setVisible(false);
                this.metallikirjasinTyyppiCbox.setVisible(false);
                this.metallikirjasinAlaTyyppiLbl.setVisible(false);
                this.metallikirjasinAlaTyyppiCbox.setVisible(false);
                this.metallikirjasinEsikatseluLabel.setVisible(false);
                this.metallikirjasinEsikatselu.setVisible(false);
                this.vaihdaMetallikirjasinFontti.setVisible(false);
                
                break;
                
            case "metallikirjasin":
                this.metallikirjasinTyyppiLbl.setVisible(true);
                this.metallikirjasinTyyppiCbox.setVisible(true);
                this.metallikirjasinAlaTyyppiLbl.setVisible(true);
                this.metallikirjasinAlaTyyppiCbox.setVisible(true);
                this.metallikirjasinTyyppiCbox.setSelectedIndex(0);
                this.metallikirjasinAlaTyyppiCbox.setSelectedIndex(0);
                this.metallikirjasinEsikatseluLabel.setVisible(true);
                this.metallikirjasinEsikatselu.setVisible(true);
                
                if (this.esikatseluSukunimi.getKaiverrettukirjasinTxt().isChosen()) {
                    this.vaihdaMetallikirjasinFontti.setVisible(true);
                }
                else if (this.esikatseluSukunimi.getMetallikirjasinTxt().isChosen()) {
                    this.vaihdaMetallikirjasinFontti.setVisible(true);
                }
                else {
                    for (EsikatseluHenkiloPanel esikatseluHlo : esikatseluHenkiloPanel) {
                        if (esikatseluHlo.isChosen()) {
                            this.vaihdaMetallikirjasinFontti.setVisible(true);
                            break;
                        }
                    }  
                } 
                
                this.valitseFonttiVariLbl.setVisible(false);
                this.valitseVariPanel.setVisible(false);
                this.fontListScrollPane.setVisible(false);
                this.valitseFonttiLbl.setVisible(false);
                this.vaihdaKaiverrettukirjasinFontti.setVisible(false);
                
                this.sukunimiTxt.setEnabled(false);
                this.vapaaTxt1.setEnabled(false);
                this.vapaaTxt2.setEnabled(false);
                this.vapaaTxt3.setEnabled(false);
                this.vapaaTxt4.setEnabled(false);
                this.etunimiTxt1.setEnabled(false);
                this.etunimiTxt2.setEnabled(false);
                this.etunimiTxt3.setEnabled(false);
                this.etunimiTxt4.setEnabled(false);
                this.osTxt1.setEnabled(false);
                this.osTxt2.setEnabled(false);
                this.osTxt3.setEnabled(false);
                this.osTxt4.setEnabled(false);
                this.syntymaAikaTxt1.setEnabled(false);
                this.syntymaAikaTxt2.setEnabled(false);
                this.syntymaAikaTxt3.setEnabled(false);
                this.syntymaAikaTxt4.setEnabled(false);
                this.kuolinAikaTxt1.setEnabled(false);
                this.kuolinAikaTxt2.setEnabled(false);
                this.kuolinAikaTxt3.setEnabled(false);
                this.kuolinAikaTxt4.setEnabled(false);
                
                break;
            default: break;
        }
    }
}