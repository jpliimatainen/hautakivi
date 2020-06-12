/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import javax.swing.Icon;
import javax.swing.JLabel;

/**
 *
 * @author Juha-Pekka
 */
public class EsikatseluJLabel extends JLabel {
    
    private String labelTypeText;
    private String labelTypeText2;
    private int index;
    private boolean chosen;
    
    public EsikatseluJLabel(Icon image, String labelTypeText) {
        super(image);
        this.labelTypeText = labelTypeText;
        index = -1;
        chosen = false;
    }
    
    public EsikatseluJLabel(Icon image, String labelTypeText, int index) {
        super(image);
        this.labelTypeText = labelTypeText;
        this.index = index;
        chosen = false;
    }
    
    public EsikatseluJLabel(Icon image, String labelTypeText, 
            String labelTypeText2, int index) {
        super(image);
        this.labelTypeText = labelTypeText;
        this.labelTypeText2 = labelTypeText2;
        this.index = index;
        chosen = false;
    }
    
    public EsikatseluJLabel(String text, String labelTypeText) {
        super(text);
        this.labelTypeText = labelTypeText;
        index = -1;
        chosen = false;
    }
    
    public EsikatseluJLabel() {
        super();
    }
    
    public String getLabelTypeText() {
        return this.labelTypeText;
    }
    
    public String getLabelTypeText2() {
        return this.labelTypeText2;
    }
    
    public void setLabelTypeText(String labelTypeText) {
        this.labelTypeText = labelTypeText;
    }
    
    public void setLabelTypeText2(String labelTypeText2) {
        this.labelTypeText2 = labelTypeText2;
    }
    
    public int getIndex() {
        return this.index;
    }
    
    public void setIndex(int index) {
        this.index = index;
    }
    
    public boolean isChosen() {
        return this.chosen;
    }
    
    public void setChosen(boolean chosen) {
        this.chosen = chosen;
    }
}