/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
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
public class VaihdaPintaTyyppiActionListener implements ActionListener {
    private MuotoJPanel esikatseluMuotoPanel;
    private Hautakivi hautakivi;
   
    

    public VaihdaPintaTyyppiActionListener(MuotoJPanel esikatseluMuotoPanel,
            Hautakivi hautakivi) {
        this.esikatseluMuotoPanel = esikatseluMuotoPanel;
        this.hautakivi = hautakivi;
       
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        boolean sahattu, hiottu, louhittu;
        
        BufferedImage muotoImage = null;
        int width = this.hautakivi.getKivenLeveys();
        int height = this.hautakivi.getKivenKorkeus();
        String description = this.hautakivi.getMuotoKuvaDescription();
        int variIndex = this.hautakivi.getKivenVariIndex();
        
        switch (actionCommand) {
            case "sahattu":
                sahattu = true;
                hiottu = false;
                louhittu = false;
                break;
            
            case "hiottu":
                sahattu = false;
                hiottu = true;
                louhittu = false;
                break;
                
            case "louhittu":
                sahattu = false;
                hiottu = false;
                louhittu = true;
                break;
                
            default: 
                sahattu = true;
                hiottu = false;
                louhittu = false;
                break;
        }
                
        /* change color */
        muotoImage = HautakiviShapes.createHautakiviShape(variIndex, width, height, 
                description, sahattu, hiottu, louhittu);
        this.esikatseluMuotoPanel.setBackground(muotoImage);

        /* update esikatselu panel */
        this.esikatseluMuotoPanel.repaint();
        
        /* change hautakivi object */
        this.hautakivi.setPintaSahattu(sahattu);
        this.hautakivi.setPintaHiottu(hiottu);
        this.hautakivi.setPintaLouhittu(louhittu);
    }
}