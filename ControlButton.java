/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import javax.swing.JButton;

/**
 *
 * @author Juha-Pekka
 */
public class ControlButton extends JButton {
    
    public enum ButtonType {
        MINUSBUTTON, PLUSBUTTON, LEFT, CENTER, RIGHT
    }
    
    private String buttonLabel;
    private ButtonType buttonType;
    
    public ControlButton(String buttonText, String buttonLabel, ButtonType buttonType) {
        super(buttonText);
        this.buttonLabel = buttonLabel;
        this.buttonType = buttonType;
    }
    
    public String getButtonLabel() {
        return this.buttonLabel;
    }
    
    public ButtonType getButtonType() {
        return this.buttonType;
    }
}
