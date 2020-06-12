/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.JLayeredPane;

/**
 *
 * @author Juha-Pekka
 */
public class MuotoJPanel extends JLayeredPane {
    
    Image image;
  
    public MuotoJPanel(Image muotoImage) {
        image = muotoImage;
    }
    
    public void setBackground(Image muotoImage) {
        image = muotoImage;
    }
    
    public Image getImage() {
        return this.image;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        if (image != null) {
                g.drawImage(image, 0, 0, this.getWidth(), this.getHeight(), this);
        }
    }
}