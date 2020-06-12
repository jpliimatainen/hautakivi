/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Juha-Pekka
 */
public class YhteystiedotDocumentListener implements DocumentListener {

    private JTextField tekstiKentta;
    private EsikatseluJLabel esikatseluTeksti;
    private JPanel esikatseluYhteystiedotPanel;
    private Hautakivi hautakivi;
    
    public YhteystiedotDocumentListener(JTextField tekstiKentta, EsikatseluJLabel esikatseluTeksti, 
            JPanel esikatseluYhteystiedotPanel, Hautakivi hautakivi) {
        
        this.tekstiKentta = tekstiKentta;
        this.esikatseluTeksti = esikatseluTeksti;
        this.esikatseluYhteystiedotPanel = esikatseluYhteystiedotPanel;
        this.hautakivi = hautakivi;
    }
  
    
    @Override
    public void changedUpdate(DocumentEvent e) {
        
        String labelType;
        
        /* add a new text onto the panel */
        this.esikatseluTeksti.setText(this.tekstiKentta.getText());
        this.esikatseluYhteystiedotPanel.setSize(this.esikatseluYhteystiedotPanel.getPreferredSize());
        
        /* update the object */
        labelType = this.esikatseluTeksti.getLabelTypeText();
        switch (labelType) {
            case "yhteystiedotNimi":
                this.hautakivi.setYhteysNimi(this.tekstiKentta.getText());
                break;
            case "yhteystiedotPuhelin":
                this.hautakivi.setYhteysPuhelin(this.tekstiKentta.getText());
                break;
            case "yhteystiedotEmail":
                this.hautakivi.setYhteysEmail(this.tekstiKentta.getText());
                break;
            default: break;
        }
    }
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        
        String labelType;
        
        /* add a new text onto the panel */
        this.esikatseluTeksti.setText(this.tekstiKentta.getText());
        this.esikatseluYhteystiedotPanel.setSize(this.esikatseluYhteystiedotPanel.getPreferredSize());
        
        /* update the object */
        labelType = this.esikatseluTeksti.getLabelTypeText();
        switch (labelType) {
            case "yhteystiedotNimi":
                this.hautakivi.setYhteysNimi(this.tekstiKentta.getText());
                break;
            case "yhteystiedotPuhelin":
                this.hautakivi.setYhteysPuhelin(this.tekstiKentta.getText());
                break;
            case "yhteystiedotEmail":
                this.hautakivi.setYhteysEmail(this.tekstiKentta.getText());
                break;
            default: break;
        }
    }
    
    @Override
    public void removeUpdate(DocumentEvent e) {
        
        String labelType;
        
        /* add a new text onto the panel */
        this.esikatseluTeksti.setText(this.tekstiKentta.getText());
        this.esikatseluYhteystiedotPanel.setSize(this.esikatseluYhteystiedotPanel.getPreferredSize());
        
        /* update the object */
        labelType = this.esikatseluTeksti.getLabelTypeText();
        switch (labelType) {
            case "yhteystiedotNimi":
                this.hautakivi.setYhteysNimi(this.tekstiKentta.getText());
                break;
            case "yhteystiedotPuhelin":
                this.hautakivi.setYhteysPuhelin(this.tekstiKentta.getText());
                break;
            case "yhteystiedotEmail":
                this.hautakivi.setYhteysEmail(this.tekstiKentta.getText());
                break;
            default: break;
        }
    }
}