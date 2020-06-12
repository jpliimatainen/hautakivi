/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author Juha-Pekka
 */
public class BackgroundPanel  extends JPanel implements Printable {
    Image image;
  
    public BackgroundPanel(String path) {
        try {
            image = ImageIO.read(new File(path));
        }
        catch (Exception e) {
            System.out.println("No image found");
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); 
        if (image != null) {
            g.drawImage(image, 10,20,this.getWidth()-20,this.getHeight()-30,this);
        }
    }
  
    @Override
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) throws PrinterException {
        if (pageIndex > 0) {
            return NO_SUCH_PAGE;
        }
        Graphics2D g2d = (Graphics2D)graphics;
        
        /*double paperWidth = pageFormat.getImageableWidth();
        double panelWidth = this.getWidth();
        double paperHeight = pageFormat.getImageableHeight();
        double panelHeight = this.getHeight();*/
        double scalingRatio = 0.7; 
        
        g2d.scale(scalingRatio, scalingRatio);
        g2d.translate(pageFormat.getImageableX()+20, pageFormat.getImageableY()+50);
        this.printAll(g2d);
        
        return PAGE_EXISTS;
    }
    
    public void setImage(Image image) {
        this.image = image;
    }
}