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

/**
 *
 * @author Juha-Pekka
 */
public class PoistaKoristeActionListener implements ActionListener {

    private EsikatseluJLabel[] esikatseluKoristeLabel;
    private MuotoJPanel esikatseluMuotoPanel;
    private Hautakivi hautakivi;
    
    
    public PoistaKoristeActionListener(EsikatseluJLabel[] esikatseluKoristeLabel, MuotoJPanel esikatseluMuotoPanel, 
            Hautakivi hautakivi) {
       this.esikatseluKoristeLabel = esikatseluKoristeLabel;
       this.esikatseluMuotoPanel = esikatseluMuotoPanel;
       this.hautakivi = hautakivi;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        int koristeCount = 0;
        Dimension size;
        int posX, posY;
        
        /* remove a chosen koriste from esikatselu panel */
        for (int i=0; i<esikatseluKoristeLabel.length; i++) {
            if (esikatseluKoristeLabel[i].isChosen()) {
                esikatseluKoristeLabel[i].setIcon(null);
                esikatseluKoristeLabel[i].setLabelTypeText("");
                esikatseluKoristeLabel[i].setIndex(-1);
                esikatseluKoristeLabel[i].setChosen(false);
                esikatseluKoristeLabel[i].setBorder(BorderFactory.createEmptyBorder());
                
                size = esikatseluKoristeLabel[i].getPreferredSize();
                posX = esikatseluKoristeLabel[i].getX();
                posY = esikatseluKoristeLabel[i].getY();
                esikatseluKoristeLabel[i].setBounds(posX, posY, size.width, size.height);
                esikatseluKoristeLabel[i].revalidate();
                esikatseluMuotoPanel.setPosition(esikatseluKoristeLabel[i], i);
                esikatseluMuotoPanel.revalidate();
                
                /* reset properties of the object */
                this.hautakivi.getKoriste(i).setKoristeKierto(0);
                this.hautakivi.getKoriste(i).setKoristePinossa(i);
                this.hautakivi.getKoriste(i).setKoristeKorkeus(0);
                this.hautakivi.getKoriste(i).setKoristeLeveys(0);
                this.hautakivi.getKoriste(i).setKoristeIndex(-1);
                break;
            } 
        }
        /* count number of koristeet */
        for (int i=0; i<Hautakivi.KORISTEMAARA; i++) {
            if (this.esikatseluKoristeLabel[i].getIcon() != null) {
                koristeCount++;
            }
        }
        this.hautakivi.setKoristeCounter(koristeCount);
    }
}