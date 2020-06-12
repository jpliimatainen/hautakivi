/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import javax.swing.JOptionPane;

/**
 *
 * @author Juha-Pekka
 */
public class TulostaActionListener implements ActionListener {

    private BackgroundPanel esikatseluPanel;
    
    
    public TulostaActionListener(BackgroundPanel esikatseluPanel) {
       this.esikatseluPanel = esikatseluPanel;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        PrinterJob printEsikatselu = PrinterJob.getPrinterJob();
        printEsikatselu.setPrintable(this.esikatseluPanel);
        if (printEsikatselu.printDialog()) {
            try {
                printEsikatselu.print();
            } catch (PrinterException pe) {
                JOptionPane.showMessageDialog(null, pe.getMessage(), "Tulostusvirhe", JOptionPane.WARNING_MESSAGE);
            }
        }
    }
}