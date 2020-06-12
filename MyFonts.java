/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Juha-Pekka
 */
public class MyFonts {
    
    public static Font[] fontLib = new Font[10];
    
    public static Font addFonts(String path) {
        
        Font font = null;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(MyFonts.class.getName()).log(Level.SEVERE, null, ex);
        }
        return font;
    }
}
