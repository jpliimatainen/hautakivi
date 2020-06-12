/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Dimension;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/**
 *
 * @author Juha-Pekka
 */
public class TekstitDocumentListener implements DocumentListener {

    private JTextField tekstiKentta;
    private JTextField tekstiKentta2; // for syntymä- ja kuolinaika
    private EsikatseluJLabel esikatseluTeksti;
    private EsikatseluSukunimi esikatseluSukunimi;
    private JPanel esikatseluHenkiloPanel;
    private int index;
    private Hautakivi hautakivi;
    
    public TekstitDocumentListener(JTextField tekstiKentta, EsikatseluJLabel esikatseluTeksti, JPanel esikatseluHenkiloPanel, int index, Hautakivi hautakivi) {
        
        this.tekstiKentta = tekstiKentta;
        this.esikatseluTeksti = esikatseluTeksti;
        this.esikatseluHenkiloPanel = esikatseluHenkiloPanel;
        this.index = index;
        this.hautakivi = hautakivi;
    }
    
     public TekstitDocumentListener(JTextField tekstiKentta, EsikatseluSukunimi esikatseluSukunimi, Hautakivi hautakivi) {
        
        this.tekstiKentta = tekstiKentta;
        esikatseluTeksti = esikatseluSukunimi.getKaiverrettukirjasinTxt();
        this.esikatseluSukunimi = esikatseluSukunimi;
        this.hautakivi = hautakivi;
    }
    
    /* for syntymä- ja kuolinaika */
    public TekstitDocumentListener(JTextField tekstiKentta, JTextField tekstiKentta2, EsikatseluJLabel esikatseluTeksti, 
            JPanel esikatseluHenkiloPanel, int index, Hautakivi hautakivi) {
        
        this.tekstiKentta = tekstiKentta;
        this.tekstiKentta2 = tekstiKentta2;
        this.esikatseluTeksti = esikatseluTeksti;
        this.esikatseluHenkiloPanel = esikatseluHenkiloPanel;
        this.index = index;
        this.hautakivi = hautakivi;
    }
    
    @Override
    public void changedUpdate(DocumentEvent e) {
    
        /* syntymä- ja kuolinaika */
        if (this.tekstiKentta2 != null) {
            if ("".equals(this.tekstiKentta.getText()) && "".equals(this.tekstiKentta2.getText())) {
                this.esikatseluTeksti.setText(""); 
                /* update the object */
                this.hautakivi.getHenkilo(this.index).setSyntymaAika(this.tekstiKentta.getText());
                this.hautakivi.getHenkilo(this.index).setKuolinAika(this.tekstiKentta2.getText());
            }
            else if ("".equals(this.tekstiKentta.getText())) {
                this.esikatseluTeksti.setText("†" + this.tekstiKentta2.getText()); 
                 /* update the object */
                this.hautakivi.getHenkilo(this.index).setSyntymaAika(this.tekstiKentta.getText());
                this.hautakivi.getHenkilo(this.index).setKuolinAika(this.tekstiKentta2.getText());
            }
            else if ("".equals(this.tekstiKentta2.getText())) {
                this.esikatseluTeksti.setText("*" + this.tekstiKentta.getText());
                 /* update the object */
                this.hautakivi.getHenkilo(this.index).setSyntymaAika(this.tekstiKentta.getText());
                this.hautakivi.getHenkilo(this.index).setKuolinAika(this.tekstiKentta2.getText());
            }
            else {
                this.esikatseluTeksti.setText("*" + this.tekstiKentta.getText() + "  †" + this.tekstiKentta2.getText());
                /* update the object */
                this.hautakivi.getHenkilo(this.index).setSyntymaAika(this.tekstiKentta.getText());
                this.hautakivi.getHenkilo(this.index).setKuolinAika(this.tekstiKentta2.getText());
            }
        }
        
        /* sukunimi */
        else if (this.esikatseluTeksti.getLabelTypeText().equals("sukunimi")){
            /* add a new text onto the panel */
            this.esikatseluTeksti.setText(this.tekstiKentta.getText());
            /* update the object */
            this.hautakivi.setSukunimi(this.tekstiKentta.getText());
        }
        
        /* vapaateksti */
        else if (this.esikatseluTeksti.getLabelTypeText().startsWith("vapaaTeksti")){
            /* add a new text onto the panel */
            this.esikatseluTeksti.setText(this.tekstiKentta.getText());
            /* update the object */
            this.hautakivi.getHenkilo(this.index).setVapaaTeksti(this.tekstiKentta.getText());
        }
        
        /* etunimet */
        else if (this.esikatseluTeksti.getLabelTypeText().startsWith("etunimet")){
            /* add a new text onto the panel */
            this.esikatseluTeksti.setText(this.tekstiKentta.getText());
            /* update the object */
            this.hautakivi.getHenkilo(this.index).setEtunimet(this.tekstiKentta.getText());
        }
        
        /* o.s. */
        else if (this.esikatseluTeksti.getLabelTypeText().startsWith("os")) {
            if ("".equals(this.tekstiKentta.getText())) {
                this.esikatseluTeksti.setText("");   
            }
            else if (" ".equals(this.tekstiKentta.getText())) {
                this.esikatseluTeksti.setText(" ");   
            }
            else {
                this.esikatseluTeksti.setText("o.s. " + this.tekstiKentta.getText()); 
            }   
            /* update the object */
            this.hautakivi.getHenkilo(this.index).setOs(this.tekstiKentta.getText());
        }
        
        
        if (this.esikatseluHenkiloPanel != null) {
            /* calculate new bounds for henkilotiedot */
            Dimension size = this.esikatseluHenkiloPanel.getPreferredSize();
            this.esikatseluHenkiloPanel.setBounds(this.esikatseluHenkiloPanel.getX(), this.esikatseluHenkiloPanel.getY(), size.width+5, size.height+5);
        }
        else {
            /* calculate new bounds for sukunimi */
            Dimension size = this.esikatseluTeksti.getPreferredSize();
            this.esikatseluTeksti.setBounds(this.esikatseluTeksti.getX(), this.esikatseluTeksti.getY(), size.width+5, size.height+5);
        }
    }
    
    @Override
    public void insertUpdate(DocumentEvent e) {
        
        /* syntymä- ja kuolinaika */
        if (this.tekstiKentta2 != null) {
            if ("".equals(this.tekstiKentta.getText()) && "".equals(this.tekstiKentta2.getText())) {
                this.esikatseluTeksti.setText(""); 
                /* update the object */
                this.hautakivi.getHenkilo(this.index).setSyntymaAika(this.tekstiKentta.getText());
                this.hautakivi.getHenkilo(this.index).setKuolinAika(this.tekstiKentta2.getText());
            }
            else if ("".equals(this.tekstiKentta.getText())) {
                this.esikatseluTeksti.setText("†" + this.tekstiKentta2.getText()); 
                /* update the object */
                this.hautakivi.getHenkilo(this.index).setSyntymaAika(this.tekstiKentta.getText());
                this.hautakivi.getHenkilo(this.index).setKuolinAika(this.tekstiKentta2.getText());
            }
            else if ("".equals(this.tekstiKentta2.getText())) {
                this.esikatseluTeksti.setText("*" + this.tekstiKentta.getText());
                /* update the object */
                this.hautakivi.getHenkilo(this.index).setSyntymaAika(this.tekstiKentta.getText());
                this.hautakivi.getHenkilo(this.index).setKuolinAika(this.tekstiKentta2.getText());
            }
            else {
                this.esikatseluTeksti.setText("*" + this.tekstiKentta.getText() + "  †" + this.tekstiKentta2.getText());
                /* update the object */
                this.hautakivi.getHenkilo(this.index).setSyntymaAika(this.tekstiKentta.getText());
                this.hautakivi.getHenkilo(this.index).setKuolinAika(this.tekstiKentta2.getText());
            }
        }
        
        /* sukunimi */
        else if (this.esikatseluTeksti.getLabelTypeText().equals("sukunimi")){
            /* add a new text onto the panel */
            this.esikatseluTeksti.setText(this.tekstiKentta.getText());
            /* update the object */
            this.hautakivi.setSukunimi(this.tekstiKentta.getText());
        }
        
        /* vapaateksti */
        else if (this.esikatseluTeksti.getLabelTypeText().startsWith("vapaaTeksti")){
            /* add a new text onto the panel */
            this.esikatseluTeksti.setText(this.tekstiKentta.getText());
            /* update the object */
            this.hautakivi.getHenkilo(this.index).setVapaaTeksti(this.tekstiKentta.getText());
        }
        
        /* etunimet */
        else if (this.esikatseluTeksti.getLabelTypeText().startsWith("etunimet")){
            /* add a new text onto the panel */
            this.esikatseluTeksti.setText(this.tekstiKentta.getText());
            /* update the object */
            this.hautakivi.getHenkilo(this.index).setEtunimet(this.tekstiKentta.getText());
        }
        
        /* o.s. */
        else if (this.esikatseluTeksti.getLabelTypeText().startsWith("os")) {
            if ("".equals(this.tekstiKentta.getText())) {
                this.esikatseluTeksti.setText("");   
            }
            else if (" ".equals(this.tekstiKentta.getText())) {
                this.esikatseluTeksti.setText(" ");   
            }
            else {
                this.esikatseluTeksti.setText("o.s. " + this.tekstiKentta.getText()); 
            }   
            /* update the object */
            this.hautakivi.getHenkilo(this.index).setOs(this.tekstiKentta.getText());
        }
        
        if (this.esikatseluHenkiloPanel != null) {
            /* calculate new bounds for henkilotiedot */
            Dimension size = this.esikatseluHenkiloPanel.getPreferredSize();
            this.esikatseluHenkiloPanel.setBounds(this.esikatseluHenkiloPanel.getX(), this.esikatseluHenkiloPanel.getY(), size.width+5, size.height+5);
        }
        else {
            /* calculate new bounds for sukunimi */
            Dimension size = this.esikatseluTeksti.getPreferredSize();
            this.esikatseluTeksti.setBounds(this.esikatseluTeksti.getX(), this.esikatseluTeksti.getY(), size.width+5, size.height+5);
        }
    }
    
    @Override
    public void removeUpdate(DocumentEvent e) {
        
        /* syntymä- ja kuolinaika */
        if (this.tekstiKentta2 != null) {
            if ("".equals(this.tekstiKentta.getText()) && "".equals(this.tekstiKentta2.getText())) {
                this.esikatseluTeksti.setText(""); 
                /* update the object */
                this.hautakivi.getHenkilo(this.index).setSyntymaAika(this.tekstiKentta.getText());
                this.hautakivi.getHenkilo(this.index).setKuolinAika(this.tekstiKentta2.getText());
            }
            else if ("".equals(this.tekstiKentta.getText())) {
                this.esikatseluTeksti.setText("†" + this.tekstiKentta2.getText()); 
                /* update the object */
                this.hautakivi.getHenkilo(this.index).setSyntymaAika(this.tekstiKentta.getText());
                this.hautakivi.getHenkilo(this.index).setKuolinAika(this.tekstiKentta2.getText());
            }
            else if ("".equals(this.tekstiKentta2.getText())) {
                this.esikatseluTeksti.setText("*" + this.tekstiKentta.getText());
                /* update the object */
                this.hautakivi.getHenkilo(this.index).setSyntymaAika(this.tekstiKentta.getText());
                this.hautakivi.getHenkilo(this.index).setKuolinAika(this.tekstiKentta2.getText());
            }
            else {
                this.esikatseluTeksti.setText("*" + this.tekstiKentta.getText() + "  †" + this.tekstiKentta2.getText());
                /* update the object */
                this.hautakivi.getHenkilo(this.index).setSyntymaAika(this.tekstiKentta.getText());
                this.hautakivi.getHenkilo(this.index).setKuolinAika(this.tekstiKentta2.getText());
            }
        }
        
        /* sukunimi */
        else if (this.esikatseluTeksti.getLabelTypeText().equals("sukunimi")){
            /* add a new text onto the panel */
            this.esikatseluTeksti.setText(this.tekstiKentta.getText());
            /* update the object */
            this.hautakivi.setSukunimi(this.tekstiKentta.getText());
        }
        
        /* vapaateksti */
        else if (this.esikatseluTeksti.getLabelTypeText().startsWith("vapaaTeksti")){
            /* add a new text onto the panel */
            this.esikatseluTeksti.setText(this.tekstiKentta.getText());
            /* update the object */
            this.hautakivi.getHenkilo(this.index).setVapaaTeksti(this.tekstiKentta.getText());
        }
        
        /* etunimet */
        else if (this.esikatseluTeksti.getLabelTypeText().startsWith("etunimet")){
            /* add a new text onto the panel */
            this.esikatseluTeksti.setText(this.tekstiKentta.getText());
            /* update the object */
            this.hautakivi.getHenkilo(this.index).setEtunimet(this.tekstiKentta.getText());
        }
        
        /* o.s. */
        else if (this.esikatseluTeksti.getLabelTypeText().startsWith("os")) {
            if ("".equals(this.tekstiKentta.getText())) {
                this.esikatseluTeksti.setText("");   
            }
            else if (" ".equals(this.tekstiKentta.getText())) {
                this.esikatseluTeksti.setText(" ");   
            }
            else {
                this.esikatseluTeksti.setText("o.s. " + this.tekstiKentta.getText()); 
            }   
            /* update the object */
            this.hautakivi.getHenkilo(this.index).setOs(this.tekstiKentta.getText());
        }
        
        
        if (this.esikatseluHenkiloPanel != null) {
            /* calculate new bounds for henkilotiedot */
            Dimension size = this.esikatseluHenkiloPanel.getPreferredSize();
            this.esikatseluHenkiloPanel.setBounds(this.esikatseluHenkiloPanel.getX(), this.esikatseluHenkiloPanel.getY(), size.width+5, size.height+5);
        }
        else {
            /* calculate new bounds for sukunimi */
            Dimension size = this.esikatseluTeksti.getPreferredSize();
            this.esikatseluTeksti.setBounds(this.esikatseluTeksti.getX(), this.esikatseluTeksti.getY(), size.width+5, size.height+5);
        }
    }
}