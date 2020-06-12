/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import javax.swing.JPanel;

/**
 *
 * @author Juha-Pekka
 */
public class SukunimiPanel extends JPanel {
    
    private boolean chosen;
    
    public SukunimiPanel() {
        super();
        chosen = false;
    }
    
    public boolean isChosen() {
        return this.chosen;
    }
    
    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }
}