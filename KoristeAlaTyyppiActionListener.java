/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 *
 * @author Juha-Pekka
 */
public class KoristeAlaTyyppiActionListener implements ActionListener {

    private JComboBox koristeTyyppi;
    private JPanel koristeValintaPanel;
    private JScrollBar koristeValintaBar;
    private EsikatseluJLabel[] esikatseluKoristeLabel;
    private Hautakivi hautakivi;
    
    public KoristeAlaTyyppiActionListener(JComboBox koristeTyyppi, JPanel koristeValintaPanel, JScrollPane koristeValintaScrollPane, 
            EsikatseluJLabel[] esikatseluKoristeLabel, Hautakivi hautakivi) {
        this.koristeTyyppi = koristeTyyppi;
        this.koristeValintaPanel = koristeValintaPanel;
        koristeValintaBar = koristeValintaScrollPane.getHorizontalScrollBar();
        this.esikatseluKoristeLabel = esikatseluKoristeLabel;
        this.hautakivi = hautakivi;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox koristeAlaTyyppi = (JComboBox)e.getSource();
        String koristeTyyppiText = (String)koristeAlaTyyppi.getSelectedItem();
        String koristeTyyppiNimi = "";
        String path;
        Image[] tmpImages;
        DescriptionImage[] descImages;
        
        switch (koristeTyyppiText) {
            case "Kohoval. laattapohjat":
                this.koristeValintaPanel.removeAll();
                /* download images if not downloaded yet */
                if (!ImageArrays.muistolaatatPohjatKohovalFlag) {
                    path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muistolaatat_pohjat\\Kohoval_laattapohjat\\";
                    ImageArrays.muistolaatatPohjatKohovalImages =  HautakiviohjelmaUI.loadImages(path);
                    tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.muistolaatatPohjatKohovalImages, 0.2f);
                    ImageArrays.muistolaatatPohjatKohovalThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "muistolaatatPohjatKohoval", true);
                    /* add mouselistener */
                    for (EsikatseluJLabel koriste: ImageArrays.muistolaatatPohjatKohovalThumbnails) {
                        koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                    }
                    ImageArrays.muistolaatatPohjatKohovalFlag = true;
                }
                for (EsikatseluJLabel koriste: ImageArrays.muistolaatatPohjatKohovalThumbnails) {
                    this.koristeValintaPanel.add(koriste);
                }
                /* move scrollbar to beginning of the panel */
                koristeValintaBar.setValue(0);
                /* repaint panel */
                koristeValintaPanel.repaint();
                break;
            
            case "Levylle kaiv. laattapohjat":
                this.koristeValintaPanel.removeAll();
                /* download images if not downloaded yet */
                if (!ImageArrays.muistolaatatPohjatLevylleFlag) {
                    path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muistolaatat_pohjat\\Levylle_kaiv_laattapohjat\\";
                    ImageArrays.muistolaatatPohjatLevylleImages =  HautakiviohjelmaUI.loadImages(path);
                    tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.muistolaatatPohjatLevylleImages, 0.2f);
                    ImageArrays.muistolaatatPohjatLevylleThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "muistolaatatPohjatLevylle", true);
                    /* add mouselistener */
                    for (EsikatseluJLabel koriste: ImageArrays.muistolaatatPohjatLevylleThumbnails) {
                        koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                    }
                    ImageArrays.muistolaatatPohjatLevylleFlag = true;
                }
                for (EsikatseluJLabel koriste: ImageArrays.muistolaatatPohjatLevylleThumbnails) {
                    this.koristeValintaPanel.add(koriste);
                }
                /* move scrollbar to beginning of the panel */
                koristeValintaBar.setValue(0);
                /* repaint panel */
                koristeValintaPanel.repaint();
                break;
            
            case "Rst laatta":
                this.koristeValintaPanel.removeAll();
                /* download images if not downloaded yet */
                if (!ImageArrays.muistolaatatPohjatRstFlag) {
                    path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muistolaatat_pohjat\\Rst_laatta\\";
                    ImageArrays.muistolaatatPohjatRstImages =  HautakiviohjelmaUI.loadImages(path);
                    tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.muistolaatatPohjatRstImages, 0.2f);
                    ImageArrays.muistolaatatPohjatRstThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "muistolaatatPohjatRst", true);
                    /* add mouselistener */
                    for (EsikatseluJLabel koriste: ImageArrays.muistolaatatPohjatRstThumbnails) {
                        koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                    }
                    ImageArrays.muistolaatatPohjatRstFlag = true;
                }
                for (EsikatseluJLabel koriste: ImageArrays.muistolaatatPohjatRstThumbnails) {
                    this.koristeValintaPanel.add(koriste);
                }
                /* move scrollbar to beginning of the panel */
                koristeValintaBar.setValue(0);
                /* repaint panel */
                koristeValintaPanel.repaint();
                break;
                
            case "Valetut laatat kaiv. teksti":
                this.koristeValintaPanel.removeAll();
                /* download images if not downloaded yet */
                if (!ImageArrays.muistolaatatPohjatValetutFlag) {
                    path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muistolaatat_pohjat\\Valetut_laatat_kaiv_teksti\\";
                    ImageArrays.muistolaatatPohjatValetutImages =  HautakiviohjelmaUI.loadImages(path);
                    tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.muistolaatatPohjatValetutImages, 0.2f);
                    ImageArrays.muistolaatatPohjatValetutThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "muistolaatatPohjatValetut", true);
                    /* add mouselistener */
                    for (EsikatseluJLabel koriste: ImageArrays.muistolaatatPohjatValetutThumbnails) {
                        koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                    }
                    ImageArrays.muistolaatatPohjatValetutFlag = true;
                }
                for (EsikatseluJLabel koriste: ImageArrays.muistolaatatPohjatValetutThumbnails) {
                    this.koristeValintaPanel.add(koriste);
                }
                /* move scrollbar to beginning of the panel */
                koristeValintaBar.setValue(0);
                /* repaint panel */
                koristeValintaPanel.repaint();
                break;
                
            case "Kirkas":
                this.koristeValintaPanel.removeAll();
                koristeTyyppiNimi = (String)koristeTyyppi.getSelectedItem();
                if ("Enkelit".equals(koristeTyyppiNimi)) {
                    if (!ImageArrays.enkelitKirkasFlag) {
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.enkelitKirkasThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.enkelitKirkasFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.enkelitKirkasThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }  
                else if ("Holvikehykset".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.holvikehyksetKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Holvikehykset\\2_Kirkas\\";
                        ImageArrays.holvikehyksetKirkasImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImagesXY(ImageArrays.holvikehyksetKirkasImages, 60, 120);
                        ImageArrays.holvikehyksetKirkasThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "holvikehyksetKirkas", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.holvikehyksetKirkasThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.holvikehyksetKirkasFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.holvikehyksetKirkasThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Kukat".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.kukatKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Kukat\\2_Kirkas\\";
                        ImageArrays.kukatKirkasImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.kukatKirkasImages, 0.15f);
                        ImageArrays.kukatKirkasThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "kukatKirkas", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.kukatKirkasThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.kukatKirkasFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.kukatKirkasThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Liekit ja lehvät".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.liekitJaLehvatKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Liekit_lehvat\\2_Kirkas\\";
                        ImageArrays.liekitJaLehvatKirkasImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.liekitJaLehvatKirkasImages, 0.15f);
                        ImageArrays.liekitJaLehvatKirkasThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "liekitJaLehvatKirkas", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.liekitJaLehvatKirkasThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.liekitJaLehvatKirkasFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.liekitJaLehvatKirkasThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Linnut".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.linnutKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Linnut\\2_Kirkas\\";
                        ImageArrays.linnutKirkasImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.linnutKirkasImages, 0.15f);
                        ImageArrays.linnutKirkasThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "linnutKirkas", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.linnutKirkasThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.linnutKirkasFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.linnutKirkasThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                }
                else if ("Lyhtykehykset".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.lyhtykehyksetKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Lyhtykehykset\\2_Kirkas\\";
                        ImageArrays.lyhtykehyksetKirkasImages =  HautakiviohjelmaUI.loadDescriptionImages(path);
                        descImages = HautakiviohjelmaUI.scaleImages(ImageArrays.lyhtykehyksetKirkasImages, 0.2f);
                        ImageArrays.lyhtykehyksetKirkasThumbnails = HautakiviohjelmaUI.createThumbnailImages(descImages, "lyhtykehyksetKirkas", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.lyhtykehyksetKirkasThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.lyhtykehyksetKirkasFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.lyhtykehyksetKirkasThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Lyhtykehykset risti".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.lyhtykehyksetRistiKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Lyhtykehykset_risti\\2_Kirkas\\";
                        ImageArrays.lyhtykehyksetRistiKirkasImages =  HautakiviohjelmaUI.loadDescriptionImages(path);
                        descImages = HautakiviohjelmaUI.scaleImages(ImageArrays.lyhtykehyksetRistiKirkasImages, 0.2f);
                        ImageArrays.lyhtykehyksetRistiKirkasThumbnails = HautakiviohjelmaUI.createThumbnailImages(descImages, "lyhtykehyksetRistiKirkas", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.lyhtykehyksetRistiKirkasThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.lyhtykehyksetRistiKirkasFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.lyhtykehyksetRistiKirkasThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Muut symbolit".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.muutSymbolitKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muut_symbolit\\2_Kirkas\\";
                        ImageArrays.muutSymbolitKirkasImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.muutSymbolitKirkasImages, 0.15f);
                        ImageArrays.muutSymbolitKirkasThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "muutSymbolitKirkas", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.muutSymbolitKirkasThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.muutSymbolitKirkasFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.muutSymbolitKirkasThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Puut ja tähkät".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.puutJaTahkatKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Puut_tahkat\\2_Kirkas\\";
                        ImageArrays.puutJaTahkatKirkasImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.puutJaTahkatKirkasImages, 0.15f);
                        ImageArrays.puutJaTahkatKirkasThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "puutJaTahkatKirkas", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.puutJaTahkatKirkasThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.puutJaTahkatKirkasFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.puutJaTahkatKirkasThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Ristit".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.ristitKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Ristit\\2_Kirkas\\";
                        ImageArrays.ristitKirkasImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.ristitKirkasImages, 0.15f);
                        ImageArrays.ristitKirkasThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "ristitKirkas", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.ristitKirkasThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.ristitKirkasFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.ristitKirkasThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Yhteenvaletut tekstit".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.yhteenvaletutTekstitKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Yhteenvaletut_tekstit\\2_Kirkas\\";
                        ImageArrays.yhteenvaletutTekstitKirkasImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.yhteenvaletutTekstitKirkasImages, 0.5f);
                        ImageArrays.yhteenvaletutTekstitKirkasThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "yhteenvaletutTekstitKirkas", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.yhteenvaletutTekstitKirkasThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.yhteenvaletutTekstitKirkasFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.yhteenvaletutTekstitKirkasThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                break;
                
            case "Kromaus":
                this.koristeValintaPanel.removeAll();
                koristeTyyppiNimi = (String)koristeTyyppi.getSelectedItem();
                if ("Enkelit".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.enkelitKromausFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Enkelit\\5_Kromaus\\";
                        ImageArrays.enkelitKromausImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.enkelitKromausImages, 0.15f);
                        ImageArrays.enkelitKromausThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "enkelitKromaus", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.enkelitKromausThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.enkelitKromausFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.enkelitKromausThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }       
                if ("Holvikehykset".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.holvikehyksetKromausFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Holvikehykset\\5_Kromaus\\";
                        ImageArrays.holvikehyksetKromausImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImagesXY(ImageArrays.holvikehyksetKromausImages, 60, 120);
                        ImageArrays.holvikehyksetKromausThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "holvikehyksetKromaus", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.holvikehyksetKromausThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.holvikehyksetKromausFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.holvikehyksetKromausThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }       
                else if ("Kukat".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.kukatKromausFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Kukat\\5_Kromaus\\";
                        ImageArrays.kukatKromausImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.kukatKromausImages, 0.15f);
                        ImageArrays.kukatKromausThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "kukatKromaus", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.kukatKromausThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.kukatKromausFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.kukatKromausThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Liekit ja lehvät".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.liekitJaLehvatKromausFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Liekit_lehvat\\5_Kromaus\\";
                        ImageArrays.liekitJaLehvatKromausImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.liekitJaLehvatKromausImages, 0.15f);
                        ImageArrays.liekitJaLehvatKromausThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "liekitJaLehvatKromaus", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.liekitJaLehvatKromausThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.liekitJaLehvatKromausFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.liekitJaLehvatKromausThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Linnut".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.linnutKromausFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Linnut\\5_Kromaus\\";
                        ImageArrays.linnutKromausImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.linnutKromausImages, 0.15f);
                        ImageArrays.linnutKromausThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "linnutKromaus", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.linnutKromausThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.linnutKromausFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.linnutKromausThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                }
                else if ("Lyhtykehykset".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.lyhtykehyksetKromausFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Lyhtykehykset\\5_Kromaus\\";
                        ImageArrays.lyhtykehyksetKromausImages =  HautakiviohjelmaUI.loadDescriptionImages(path);
                        descImages = HautakiviohjelmaUI.scaleImages(ImageArrays.lyhtykehyksetKromausImages, 0.2f);
                        ImageArrays.lyhtykehyksetKromausThumbnails = HautakiviohjelmaUI.createThumbnailImages(descImages, "lyhtykehyksetKromaus", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.lyhtykehyksetKromausThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.lyhtykehyksetKromausFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.lyhtykehyksetKromausThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Lyhtykehykset risti".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.lyhtykehyksetRistiKromausFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Lyhtykehykset_risti\\5_Kromaus\\";
                        ImageArrays.lyhtykehyksetRistiKromausImages =  HautakiviohjelmaUI.loadDescriptionImages(path);
                        descImages = HautakiviohjelmaUI.scaleImages(ImageArrays.lyhtykehyksetRistiKromausImages, 0.2f);
                        ImageArrays.lyhtykehyksetRistiKromausThumbnails = HautakiviohjelmaUI.createThumbnailImages(descImages, "lyhtykehyksetRistiKromaus", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.lyhtykehyksetRistiKromausThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.lyhtykehyksetRistiKromausFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.lyhtykehyksetRistiKromausThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Muut symbolit".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.muutSymbolitKromausFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muut_symbolit\\5_Kromaus\\";
                        ImageArrays.muutSymbolitKromausImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.muutSymbolitKromausImages, 0.15f);
                        ImageArrays.muutSymbolitKromausThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "muutSymbolitKromaus", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.muutSymbolitKromausThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.muutSymbolitKromausFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.muutSymbolitKromausThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Puut ja tähkät".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.puutJaTahkatKromausFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Puut_tahkat\\5_Kromaus\\";
                        ImageArrays.puutJaTahkatKromausImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.puutJaTahkatKromausImages, 0.15f);
                        ImageArrays.puutJaTahkatKromausThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "puutJaTahkatKromaus", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.puutJaTahkatKromausThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.puutJaTahkatKromausFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.puutJaTahkatKromausThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Ristit".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.ristitKromausFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Ristit\\5_Kromaus\\";
                        ImageArrays.ristitKromausImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.ristitKromausImages, 0.15f);
                        ImageArrays.ristitKromausThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "ristitKromaus", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.ristitKromausThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.ristitKromausFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.ristitKromausThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Yhteenvaletut tekstit".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.yhteenvaletutTekstitKromausFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Yhteenvaletut_tekstit\\5_Kromaus\\";
                        ImageArrays.yhteenvaletutTekstitKromausImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.yhteenvaletutTekstitKromausImages, 0.5f);
                        ImageArrays.yhteenvaletutTekstitKromausThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "yhteenvaletutTekstitKromaus", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.yhteenvaletutTekstitKromausThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.yhteenvaletutTekstitKromausFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.yhteenvaletutTekstitKromausThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                break;
                
            case "Taidepatina":
                this.koristeValintaPanel.removeAll();
                koristeTyyppiNimi = (String)koristeTyyppi.getSelectedItem();
                if ("Enkelit".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.enkelitTaidePatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Enkelit\\3_Taidepatina\\";
                        ImageArrays.enkelitTaidePatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.enkelitTaidePatinaImages, 0.15f);
                        ImageArrays.enkelitTaidePatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "enkelitTaidePatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.enkelitTaidePatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.enkelitTaidePatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.enkelitTaidePatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                } 
                if ("Holvikehykset".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.holvikehyksetTaidePatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Holvikehykset\\3_Taidepatina\\";
                        ImageArrays.holvikehyksetTaidePatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImagesXY(ImageArrays.holvikehyksetTaidePatinaImages, 60, 120);
                        ImageArrays.holvikehyksetTaidePatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "holvikehyksetTaidePatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.holvikehyksetTaidePatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.holvikehyksetTaidePatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.holvikehyksetTaidePatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }       
                else if ("Kukat".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.kukatTaidePatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Kukat\\3_Taidepatina\\";
                        ImageArrays.kukatTaidePatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.kukatTaidePatinaImages, 0.15f);
                        ImageArrays.kukatTaidePatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "kukatTaidePatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.kukatTaidePatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.kukatTaidePatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.kukatTaidePatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Liekit ja lehvät".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.liekitJaLehvatTaidePatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Liekit_lehvat\\3_Taidepatina\\";
                        ImageArrays.liekitJaLehvatTaidePatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.liekitJaLehvatTaidePatinaImages, 0.15f);
                        ImageArrays.liekitJaLehvatTaidePatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "liekitJaLehvatTaidePatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.liekitJaLehvatTaidePatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.liekitJaLehvatTaidePatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.liekitJaLehvatTaidePatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Linnut".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.linnutTaidePatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Linnut\\3_Taidepatina\\";
                        ImageArrays.linnutTaidePatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.linnutTaidePatinaImages, 0.15f);
                        ImageArrays.linnutTaidePatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "linnutTaidePatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.linnutTaidePatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.linnutTaidePatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.linnutTaidePatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                }
                else if ("Lyhtykehykset".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.lyhtykehyksetTaidePatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Lyhtykehykset\\3_Taidepatina\\";
                        ImageArrays.lyhtykehyksetTaidePatinaImages =  HautakiviohjelmaUI.loadDescriptionImages(path);
                        descImages = HautakiviohjelmaUI.scaleImages(ImageArrays.lyhtykehyksetTaidePatinaImages, 0.2f);
                        ImageArrays.lyhtykehyksetTaidePatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(descImages, "lyhtykehyksetTaidePatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.lyhtykehyksetTaidePatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.lyhtykehyksetTaidePatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.lyhtykehyksetTaidePatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Lyhtykehykset risti".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.lyhtykehyksetRistiTaidePatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Lyhtykehykset_risti\\3_Taidepatina\\";
                        ImageArrays.lyhtykehyksetRistiTaidePatinaImages =  HautakiviohjelmaUI.loadDescriptionImages(path);
                        descImages = HautakiviohjelmaUI.scaleImages(ImageArrays.lyhtykehyksetRistiTaidePatinaImages, 0.2f);
                        ImageArrays.lyhtykehyksetRistiTaidePatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(descImages, "lyhtykehyksetRistiTaidePatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.lyhtykehyksetRistiTaidePatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.lyhtykehyksetRistiTaidePatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.lyhtykehyksetRistiTaidePatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Muut symbolit".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.muutSymbolitTaidePatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muut_symbolit\\3_Taidepatina\\";
                        ImageArrays.muutSymbolitTaidePatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.muutSymbolitTaidePatinaImages, 0.15f);
                        ImageArrays.muutSymbolitTaidePatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "muutSymbolitTaidePatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.muutSymbolitTaidePatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.muutSymbolitTaidePatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.muutSymbolitTaidePatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Puut ja tähkät".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.puutJaTahkatTaidePatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Puut_tahkat\\3_Taidepatina\\";
                        ImageArrays.puutJaTahkatTaidePatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.puutJaTahkatTaidePatinaImages, 0.15f);
                        ImageArrays.puutJaTahkatTaidePatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "puutJaTahkatTaidePatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.puutJaTahkatTaidePatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.puutJaTahkatTaidePatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.puutJaTahkatTaidePatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Ristit".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.ristitTaidePatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Ristit\\3_Taidepatina\\";
                        ImageArrays.ristitTaidePatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.ristitTaidePatinaImages, 0.15f);
                        ImageArrays.ristitTaidePatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "ristitTaidePatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.ristitTaidePatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.ristitTaidePatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.ristitTaidePatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Yhteenvaletut tekstit".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.yhteenvaletutTekstitTaidePatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Yhteenvaletut_tekstit\\3_Taidepatina\\";
                        ImageArrays.yhteenvaletutTekstitTaidePatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.yhteenvaletutTekstitTaidePatinaImages, 0.5f);
                        ImageArrays.yhteenvaletutTekstitTaidePatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "yhteenvaletutTekstitTaidePatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.yhteenvaletutTekstitTaidePatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.yhteenvaletutTekstitTaidePatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.yhteenvaletutTekstitTaidePatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                break;
            
            case "Tumma patina":
                this.koristeValintaPanel.removeAll();
                koristeTyyppiNimi = (String)koristeTyyppi.getSelectedItem();
                if ("Enkelit".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.enkelitTummaPatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Enkelit\\1_Tumma_patina\\";
                        ImageArrays.enkelitTummaPatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.enkelitTummaPatinaImages, 0.15f);
                        ImageArrays.enkelitTummaPatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "enkelitTummaPatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.enkelitTummaPatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.enkelitTummaPatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.enkelitTummaPatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }   
                if ("Holvikehykset".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.holvikehyksetTummaPatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Holvikehykset\\1_Tumma_patina\\";
                        ImageArrays.holvikehyksetTummaPatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImagesXY(ImageArrays.holvikehyksetTummaPatinaImages, 60, 120);
                        ImageArrays.holvikehyksetTummaPatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "holvikehyksetTummaPatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.holvikehyksetTummaPatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.holvikehyksetTummaPatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.holvikehyksetTummaPatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }       
                else if ("Kukat".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.kukatTummaPatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Kukat\\1_Tumma_patina\\";
                        ImageArrays.kukatTummaPatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.kukatTummaPatinaImages, 0.15f);
                        ImageArrays.kukatTummaPatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "kukatTummaPatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.kukatTummaPatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.kukatTummaPatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.kukatTummaPatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Liekit ja lehvät".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.liekitJaLehvatTummaPatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Liekit_lehvat\\1_Tumma_patina\\";
                        ImageArrays.liekitJaLehvatTummaPatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.liekitJaLehvatTummaPatinaImages, 0.15f);
                        ImageArrays.liekitJaLehvatTummaPatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "liekitJaLehvatTummaPatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.liekitJaLehvatTummaPatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.liekitJaLehvatTummaPatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.liekitJaLehvatTummaPatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Linnut".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.linnutTummaPatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Linnut\\1_Tumma_patina\\";
                        ImageArrays.linnutTummaPatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.linnutTummaPatinaImages, 0.15f);
                        ImageArrays.linnutTummaPatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "linnutTummaPatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.linnutTummaPatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.linnutTummaPatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.linnutTummaPatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                }
                else if ("Lyhtykehykset".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.lyhtykehyksetTummaPatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Lyhtykehykset\\1_Tumma_patina\\";
                        ImageArrays.lyhtykehyksetTummaPatinaImages =  HautakiviohjelmaUI.loadDescriptionImages(path);
                        descImages = HautakiviohjelmaUI.scaleImages(ImageArrays.lyhtykehyksetTummaPatinaImages, 0.2f);
                        ImageArrays.lyhtykehyksetTummaPatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(descImages, "lyhtykehyksetTummaPatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.lyhtykehyksetTummaPatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.lyhtykehyksetTummaPatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.lyhtykehyksetTummaPatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Lyhtykehykset risti".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.lyhtykehyksetRistiTummaPatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Lyhtykehykset_risti\\1_Tumma_patina\\";
                        ImageArrays.lyhtykehyksetRistiTummaPatinaImages =  HautakiviohjelmaUI.loadDescriptionImages(path);
                        descImages = HautakiviohjelmaUI.scaleImages(ImageArrays.lyhtykehyksetRistiTummaPatinaImages, 0.2f);
                        ImageArrays.lyhtykehyksetRistiTummaPatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(descImages, "lyhtykehyksetRistiTummaPatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.lyhtykehyksetRistiTummaPatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.lyhtykehyksetRistiTummaPatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.lyhtykehyksetRistiTummaPatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Muut symbolit".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.muutSymbolitTummaPatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muut_symbolit\\1_Tumma_patina\\";
                        ImageArrays.muutSymbolitTummaPatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.muutSymbolitTummaPatinaImages, 0.15f);
                        ImageArrays.muutSymbolitTummaPatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "muutSymbolitTummaPatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.muutSymbolitTummaPatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.muutSymbolitTummaPatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.muutSymbolitTummaPatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Puut ja tähkät".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.puutJaTahkatTummaPatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Puut_tahkat\\1_Tumma_patina\\";
                        ImageArrays.puutJaTahkatTummaPatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.puutJaTahkatTummaPatinaImages, 0.15f);
                        ImageArrays.puutJaTahkatTummaPatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "puutJaTahkatTummaPatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.puutJaTahkatTummaPatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.puutJaTahkatTummaPatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.puutJaTahkatTummaPatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Ristit".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.ristitTummaPatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Ristit\\1_Tumma_patina\\";
                        ImageArrays.ristitTummaPatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.ristitTummaPatinaImages, 0.15f);
                        ImageArrays.ristitTummaPatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "ristitTummaPatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.ristitTummaPatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.ristitTummaPatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.ristitTummaPatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                else if ("Yhteenvaletut tekstit".equals(koristeTyyppiNimi)) {
                    /* download images if not downloaded yet */
                    if (!ImageArrays.yhteenvaletutTekstitTummaPatinaFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Yhteenvaletut_tekstit\\1_Tumma_patina\\";
                        ImageArrays.yhteenvaletutTekstitTummaPatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.yhteenvaletutTekstitTummaPatinaImages, 0.5f);
                        ImageArrays.yhteenvaletutTekstitTummaPatinaThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "yhteenvaletutTekstitTummaPatina", true);
                        /* add mouselistener */
                        for (EsikatseluJLabel koriste: ImageArrays.yhteenvaletutTekstitTummaPatinaThumbnails) {
                            koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                        }
                        ImageArrays.yhteenvaletutTekstitTummaPatinaFlag = true;
                    }
                    for (EsikatseluJLabel koriste: ImageArrays.yhteenvaletutTekstitTummaPatinaThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                }
                break;
                
            default: break;
        }
    } 
}