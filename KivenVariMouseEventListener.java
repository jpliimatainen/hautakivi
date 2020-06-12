/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

/**
 *
 * @author Juha-Pekka
 */
public class KivenVariMouseEventListener extends MouseAdapter {
 
    private MuotoJPanel esikatseluMuotoPanel;
    private Hautakivi hautakivi;
    
    
    public KivenVariMouseEventListener(MuotoJPanel esikatseluMuotoPanel, Hautakivi hautakivi) {
        this.esikatseluMuotoPanel = esikatseluMuotoPanel;
        this.hautakivi = hautakivi;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
  
        EsikatseluJLabel vari = (EsikatseluJLabel)e.getSource();
        int variIndex = vari.getIndex();
        BufferedImage muotoImage = null;
        int width = this.hautakivi.getKivenLeveys();
        int height = this.hautakivi.getKivenKorkeus();
        String description = this.hautakivi.getMuotoKuvaDescription();
        boolean sahattu = this.hautakivi.isPintaSahattu();
        boolean hiottu = this.hautakivi.isPintaHiottu();
        boolean louhittu = this.hautakivi.isPintaLouhittu();
        
        /* change color */
        muotoImage = HautakiviShapes.createHautakiviShape(variIndex, width, height, 
                description, sahattu, hiottu, louhittu);
        this.esikatseluMuotoPanel.setBackground(muotoImage);

        /* update esikatselu panel */
        this.esikatseluMuotoPanel.repaint();
        
        /* change hautakivi object */
        this.hautakivi.setKivenVariIndex(variIndex);
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