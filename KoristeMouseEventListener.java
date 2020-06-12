/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import javax.swing.Icon;
import javax.swing.ImageIcon;

/**
 *
 * @author Juha-Pekka
 */
public class KoristeMouseEventListener extends MouseAdapter {

    private EsikatseluJLabel[] esikatseluKoristeLabel;
    private MuotoJPanel esikatseluMuoto;
    private Hautakivi hautakivi;
    
    public KoristeMouseEventListener(EsikatseluJLabel[] esikatseluKoristeLabel, Hautakivi hautakivi) {
        this.esikatseluKoristeLabel = esikatseluKoristeLabel;
        this.hautakivi = hautakivi;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
  
        BufferedImage coloredImage;
        int width, height;
        
        EsikatseluJLabel component = (EsikatseluJLabel)e.getComponent();
        
        /* get the icon */
        Icon icon = component.getIcon();
        
        /* get the labeltype */
        String labelType = component.getLabelTypeText();
        
        /* get the index */
        int index = component.getIndex();
        
        int koristeCount = 0;
        
        if (labelType.equals("ornamentit")) {
            width = icon.getIconWidth();
            height = icon.getIconHeight();
            coloredImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_ARGB);
            if (this.hautakivi.getHenkilo(0).getFontColor().equals(new Color(192, 192, 192))) {
                coloredImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.ornamentitHopeaImages[index], 
                        width, height);
            icon = new ImageIcon(coloredImage);
            }
            else if (this.hautakivi.getHenkilo(0).getFontColor().equals(new Color(238, 232, 170))) {
                coloredImage = HautakiviohjelmaUI.scaleImageXY(ImageArrays.ornamentitKultaImages[index], 
                        width, height);
            icon = new ImageIcon(coloredImage);
            }
        }

        /* add koriste to esikatselupanel to the first free slot */
        for (int i=0; i<Hautakivi.KORISTEMAARA; i++) {
            if (this.esikatseluKoristeLabel[i].getIcon() == null) {
                this.esikatseluKoristeLabel[i].setIcon(icon);
                this.esikatseluKoristeLabel[i].setLabelTypeText(labelType);
                this.esikatseluKoristeLabel[i].setIndex(index);

                /* calculate new bounds for koriste */
                Dimension size = this.esikatseluKoristeLabel[i].getPreferredSize();
                this.esikatseluKoristeLabel[i].setBounds(this.esikatseluKoristeLabel[i].getX(), 
                        this.esikatseluKoristeLabel[i].getY(), size.width+5, size.height+5);
                this.esikatseluKoristeLabel[i].revalidate();

                /* change hautakivi object */
                this.hautakivi.getKoriste(i).setKoristeKierto(0);
                this.hautakivi.getKoriste(i).setKoristePinossa(i);
                this.hautakivi.getKoriste(i).setKoristeKorkeus(this.esikatseluKoristeLabel[i].getIcon().getIconHeight());
                this.hautakivi.getKoriste(i).setKoristeLeveys(this.esikatseluKoristeLabel[i].getIcon().getIconWidth());
                this.hautakivi.getKoriste(i).setKoristeIndex(index);
                this.hautakivi.getKoriste(i).setKoristeLabelType(labelType);
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