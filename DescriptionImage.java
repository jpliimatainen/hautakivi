/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.image.BufferedImage;

/**
 *
 * @author Juha-Pekka
 */
public class DescriptionImage {
    
    private BufferedImage image;
    private String description;
    
    public DescriptionImage(BufferedImage image, String description) {
        this.image = image;
        this.description = description;
    }
    
    public BufferedImage getImage() {
        return this.image;
    }
    
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
}
