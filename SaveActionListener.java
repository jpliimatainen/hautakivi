/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Juha-Pekka
 */
public class SaveActionListener implements ActionListener {
    
    private EsikatseluSukunimi esikatseluSukunimi;
    private EsikatseluHenkiloPanel[] esikatseluHenkiloPanel;
    private EsikatseluJLabel[] esikatseluKoristeLabel;
    private Hautakivi hautakivi;
    
    public SaveActionListener(EsikatseluSukunimi esikatseluSukunimi, EsikatseluHenkiloPanel[] esikatseluHenkiloPanel, 
            EsikatseluJLabel[] esikatseluKoristeLabel, Hautakivi hautakivi) {
        this.esikatseluSukunimi = esikatseluSukunimi;
        this.esikatseluHenkiloPanel = esikatseluHenkiloPanel;
        this.esikatseluKoristeLabel = esikatseluKoristeLabel;
        this.hautakivi = hautakivi;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        int i;
        
        /* store the locations of the component */
        if (this.hautakivi.isSukunimiKaiverrettu()) {
            this.hautakivi.setSukunimiX(this.esikatseluSukunimi.getKaiverrettukirjasinTxt().getX());
            this.hautakivi.setSukunimiY(this.esikatseluSukunimi.getKaiverrettukirjasinTxt().getY());
        }
        else {
            this.hautakivi.setSukunimiX(this.esikatseluSukunimi.getMetallikirjasinTxt().getX());
            this.hautakivi.setSukunimiY(this.esikatseluSukunimi.getMetallikirjasinTxt().getY());
        }
        
        for (i=0; i<Hautakivi.HENKILOMAARA; i++) {
            this.hautakivi.getHenkilo(i).setHenkiloX(this.esikatseluHenkiloPanel[i].getX());
            this.hautakivi.getHenkilo(i).setHenkiloY(this.esikatseluHenkiloPanel[i].getY());
        }
        
        for (i=0; i<Hautakivi.KORISTEMAARA; i++) {
            this.hautakivi.getKoriste(i).setKoristeX(this.esikatseluKoristeLabel[i].getX());
            this.hautakivi.getKoriste(i).setKoristeY(this.esikatseluKoristeLabel[i].getY());
        }
        
        JFileChooser saveCmd = new JFileChooser();
        FileNameExtensionFilter nameExt = new FileNameExtensionFilter("Hautakivi Files", "hkf");
        saveCmd.setFileFilter(nameExt);
        int returnVal = saveCmd.showSaveDialog(null);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                String path = saveCmd.getCurrentDirectory().getAbsolutePath()+"\\"+saveCmd.getSelectedFile().getName();
                if (!path.endsWith(".hkf")) {
                    path = path + ".hkf";
                }
                
                FileOutputStream fileOStream = new FileOutputStream(path, false);
                
                ObjectOutputStream  objectOStream = new ObjectOutputStream(fileOStream);
                objectOStream.writeObject(hautakivi);
                objectOStream.close();
                JOptionPane.showMessageDialog(null, "Tallennus onnistui", "Tallennus onnistui", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Tallennus epäonnistui", JOptionPane.ERROR_MESSAGE);
            }            
        }
    }
}