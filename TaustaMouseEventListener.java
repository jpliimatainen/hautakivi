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

/**
 *
 * @author Juha-Pekka
 */
public class TaustaMouseEventListener extends MouseAdapter {
 
    private BackgroundPanel esikatseluPanel;
    private EsikatseluJLabel esikatseluYhteystiedotLabel;
    private EsikatseluJLabel esikatseluYhteystiedotNimi;
    private EsikatseluJLabel esikatseluYhteystiedotPuhelin;
    private EsikatseluJLabel esikatseluYhteystiedotEmail;
    private Hautakivi hautakivi;
    
    
    public TaustaMouseEventListener(BackgroundPanel esikatseluPanel, EsikatseluJLabel esikatseluYhteystiedotLabel, 
            EsikatseluJLabel esikatseluYhteystiedotNimi, EsikatseluJLabel esikatseluYhteystiedotPuhelin, 
            EsikatseluJLabel esikatseluYhteystiedotEmail, Hautakivi hautakivi) {
        this.esikatseluPanel = esikatseluPanel;
        this.esikatseluYhteystiedotLabel = esikatseluYhteystiedotLabel;
        this.esikatseluYhteystiedotNimi = esikatseluYhteystiedotNimi;
        this.esikatseluYhteystiedotPuhelin = esikatseluYhteystiedotPuhelin;
        this.esikatseluYhteystiedotEmail = esikatseluYhteystiedotEmail;
        this.hautakivi = hautakivi;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
  
        EsikatseluJLabel tausta = (EsikatseluJLabel)e.getSource();
        int index = tausta.getIndex();
        
        /* change tausta image */
        this.esikatseluPanel.setImage(ImageArrays.taustaImages[index]);
        
        /* change font color so that text can be read */
        if (index < 3) {
            esikatseluYhteystiedotLabel.setForeground(new Color(0, 0, 255));
            esikatseluYhteystiedotNimi.setForeground(new Color(0, 0, 255));
            esikatseluYhteystiedotPuhelin.setForeground(new Color(0, 0, 255));
            esikatseluYhteystiedotEmail.setForeground(new Color(0, 0, 255));
        }
        else {
            esikatseluYhteystiedotLabel.setForeground(new Color(255, 255, 255));
            esikatseluYhteystiedotNimi.setForeground(new Color(255, 255, 255));
            esikatseluYhteystiedotPuhelin.setForeground(new Color(255, 255, 255));
            esikatseluYhteystiedotEmail.setForeground(new Color(255, 255, 255));
        }
        
        /* update esikatselu panel */
        this.esikatseluPanel.repaint();
        
        /* change hautakivi object */
        this.hautakivi.setTaustaKuvaIndex(index);
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