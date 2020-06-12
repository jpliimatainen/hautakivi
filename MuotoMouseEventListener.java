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
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author Juha-Pekka
 */
public class MuotoMouseEventListener extends MouseAdapter {
 
    private MuotoJPanel esikatseluMuotoPanel;
    private JLabel pintaLabel;
    private JRadioButton sahattu;
    private JRadioButton hiottu;
    private JRadioButton louhittu;
    private Hautakivi hautakivi;
    
    
    public MuotoMouseEventListener(MuotoJPanel esikatseluMuoto, JLabel pintaLabel,
            JRadioButton sahattu, JRadioButton hiottu, JRadioButton louhittu, 
            Hautakivi hautakivi) {
        this.esikatseluMuotoPanel = esikatseluMuoto;
        this.pintaLabel = pintaLabel;
        this.sahattu = sahattu;
        this.hiottu = hiottu;
        this.louhittu = louhittu;
        this.hautakivi = hautakivi;
    }

    @Override
    public void mouseClicked(MouseEvent e) {

        EsikatseluJLabel muoto = (EsikatseluJLabel)e.getSource();
        String description = muoto.getLabelTypeText();
        BufferedImage muotoImage = null;
        int variIndex = this.hautakivi.getKivenVariIndex();
        int kivenLeveys = this.hautakivi.getKivenLeveys();
        int kivenKorkeus = this.hautakivi.getKivenKorkeus();

        /* set visibility for pinta selection */
        if (description.endsWith("suorakulmio.png") || description.endsWith("kaareva1.png") || 
            description.endsWith("kaareva2.png") || description.endsWith("kaareva3.png") || 
                description.endsWith("Hauta03.png") || description.endsWith("Hauta05.png") || 
                description.endsWith("Hauta07.png") || description.endsWith("Hauta12.png") ||
                description.endsWith("Hauta41.png") || description.endsWith("Hauta42.png") ||
                description.endsWith("Hauta43.png") || description.endsWith("Hauta44.png") ||
                description.endsWith("Hauta45.png") || description.endsWith("Hauta46.png") ||
                description.endsWith("Hauta47.png") || description.endsWith("Hauta49.png") ||
                description.endsWith("Hauta50.png") || description.endsWith("Hauta56.png") ||
                description.endsWith("Hauta58.png") || description.endsWith("Hauta60.png")) {
                    
            this.pintaLabel.setVisible(true);
            this.sahattu.setVisible(true);
            this.hiottu.setVisible(true);
            this.louhittu.setVisible(true);
        }
        else {
            this.pintaLabel.setVisible(false);
            this.sahattu.setVisible(false);
            this.hiottu.setVisible(false);
            this.louhittu.setVisible(false);
            
            // louhitut kivet
            this.hautakivi.setPintaSahattu(false);
            this.hautakivi.setPintaHiottu(false);
            this.hautakivi.setPintaLouhittu(true);
            this.louhittu.setSelected(true);
        }
        
        boolean sahattu = this.hautakivi.isPintaSahattu();
        boolean hiottu = this.hautakivi.isPintaHiottu();
        boolean louhittu = this.hautakivi.isPintaLouhittu();
        
        muotoImage = HautakiviShapes.createHautakiviShape(variIndex, kivenLeveys, kivenKorkeus, 
                description, sahattu, hiottu, louhittu);
        this.esikatseluMuotoPanel.setBackground(muotoImage);
        
        /* update esikatselu panel */
        this.esikatseluMuotoPanel.setSize(esikatseluMuotoPanel.getImage().getWidth(null), 
                esikatseluMuotoPanel.getImage().getHeight(null));
        this.esikatseluMuotoPanel.setLocation(0, 0);
        this.esikatseluMuotoPanel.repaint();
        
        /* change hautakivi object */
        this.hautakivi.setMuotoKuvaDescription(description);
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
