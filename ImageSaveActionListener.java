/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Juha-Pekka
 */
public class ImageSaveActionListener implements ActionListener {
    
    private BackgroundPanel esikatseluPanel;
    
    public ImageSaveActionListener(BackgroundPanel esikatseluPanel) {
        this.esikatseluPanel = esikatseluPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
                
        JFileChooser saveCmd = new JFileChooser();
        FileNameExtensionFilter nameExt = new FileNameExtensionFilter("JPEG Tiedostot", "jpg", "jpeg");
        saveCmd.setFileFilter(nameExt);
        int returnVal = saveCmd.showSaveDialog(null);
        
        int width = this.esikatseluPanel.getWidth();
        int height = this.esikatseluPanel.getHeight();
        
        BufferedImage saveImg = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics2D g2d = saveImg.createGraphics();
        
        this.esikatseluPanel.paint(g2d);
        g2d.dispose();
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            String path = saveCmd.getCurrentDirectory().getAbsolutePath()+"\\"+saveCmd.getSelectedFile().getName();
            if (!path.endsWith(".jpg")) {
                    path = path + ".jpg";
                }
            File outputFile = new File(path);
            try {
                ImageIO.write(saveImg, "jpg", outputFile);
                JOptionPane.showMessageDialog(null, "Tallennus onnistui", "Tallennus onnistui", JOptionPane.INFORMATION_MESSAGE);      
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Tallennus epäonnistui", JOptionPane.ERROR_MESSAGE);
            }
                  
        }
    }
}