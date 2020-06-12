/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Component;
import java.awt.Font;
import java.awt.FontFormatException;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;

/**
 *
 * @author Juha-Pekka
 */
public class MyListCellRenderer extends DefaultListCellRenderer {

    @Override
    public Component getListCellRendererComponent(JList list, Object value, int index, boolean isSelected, boolean cellHasFocus) {
        Component comp = super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);

        switch (value.toString()) {
            case "Alex Brush":
                    setMyFont(comp, System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\alex-brush-regular.ttf", 14f);
                    break;
                case "Black Chancery":
                    setMyFont(comp, System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\black-chancery.ttf", 13f);
                    break;
                case "Coventry Script":
                    setMyFont(comp, System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\coventry-script.ttf", 14f);
                    break;
                case "Open Sans Condensed":
                    setMyFont(comp, System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\openSans-condensed.ttf", 13f);
                    break;
                case "Sanvito Roman":
                    setMyFont(comp, System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\sanvito-roman.otf", 14f);
                    break;
                case "Century Old Style":
                    setMyFont(comp, System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\centold.ttf", 13f);
                    break;
                case "Century Schoolbook":
                    setMyFont(comp, System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\century2.ttf", 13f);
                    break;
                default: break;
            }   
        return comp;
    }
    
    private static void setMyFont(Component textComponent, String path, float size) {
        Font font;
        try {
            font = Font.createFont(Font.TRUETYPE_FONT, new File(path));
            textComponent.setFont(font.deriveFont(size));
        } catch (FontFormatException | IOException ex) {
            Logger.getLogger(HautakiviohjelmaUI.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
