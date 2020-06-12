/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.math.BigDecimal;
import java.math.MathContext;
import javax.swing.JTextField;

/**
 *
 * @author Juha-Pekka
 */
public class MuotoActionListener implements ActionListener {

    private JTextField kivenLeveys;
    private JTextField kivenKorkeus;
    private MuotoJPanel esikatseluMuotoPanel;
    private Hautakivi hautakivi;
    
    
    public MuotoActionListener(JTextField kivenLeveys, JTextField kivenKorkeus, MuotoJPanel esikatseluMuotoPanel, Hautakivi hautakivi) {
        this.kivenLeveys = kivenLeveys;
        this.kivenKorkeus = kivenKorkeus;
        this.esikatseluMuotoPanel = esikatseluMuotoPanel;
        this.hautakivi = hautakivi;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {

        int index, height, width;
        BufferedImage muotoImage = null;
        String description = this.hautakivi.getMuotoKuvaDescription();
        int variIndex = this.hautakivi.getKivenVariIndex();
        boolean sahattu = this.hautakivi.isPintaSahattu();
        boolean hiottu = this.hautakivi.isPintaHiottu();
        boolean louhittu = this.hautakivi.isPintaLouhittu();
        
        /* set the new dimension */
        this.hautakivi.setKivenLeveys(Integer.parseInt(kivenLeveys.getText()));
        this.hautakivi.setKivenKorkeus(Integer.parseInt(kivenKorkeus.getText()));
        
        width = this.hautakivi.getKivenLeveys();
        height = this.hautakivi.getKivenKorkeus();

        muotoImage = HautakiviShapes.createHautakiviShape(variIndex, width, height, 
                description, sahattu, hiottu, louhittu);
        this.esikatseluMuotoPanel.setBackground(muotoImage);
        
        /* update esikatselu panel */
        this.esikatseluMuotoPanel.setSize(esikatseluMuotoPanel.getImage().getWidth(null), 
                esikatseluMuotoPanel.getImage().getHeight(null));
        this.esikatseluMuotoPanel.setLocation(0, 0);
        this.esikatseluMuotoPanel.repaint();
    }
}
