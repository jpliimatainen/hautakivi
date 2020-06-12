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
public class EsikatseluHenkiloPanel extends JPanel {
    
    private boolean chosen;
    private int index;
    
    public EsikatseluHenkiloPanel(int index) {
        super();
        chosen = false;
        this.index = index;
    }
    
    public boolean isChosen() {
        return this.chosen;
    }
    
    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }
    
    public int getIndex() {
        return this.index;
    }
}
