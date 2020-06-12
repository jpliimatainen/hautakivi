/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Area;
import java.awt.image.BufferedImage;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

/**
 *
 * @author Juha-Pekka
 */
public class KoristeTyyppiActionListener implements ActionListener {

    private JComboBox koristeAlatyyppi;
    private JComboBox koristeAlatyyppi2;
    private JLabel koristeAlatyyppiOtsikko;
    private JPanel koristeValintaPanel;
    private JScrollBar koristeValintaBar;
    private EsikatseluJLabel[] esikatseluKoristeLabel;
    private Hautakivi hautakivi;
    
    
    public KoristeTyyppiActionListener(JComboBox koristeAlatyyppi, JComboBox koristeAlatyyppi2, 
            JLabel koristeAlatyyppiOtsikko, JPanel koristeValintaPanel, JScrollPane koristeValintaScrollPane, 
            EsikatseluJLabel[] esikatseluKoristeLabel, Hautakivi hautakivi) {
        this.koristeAlatyyppi = koristeAlatyyppi;
        this.koristeAlatyyppi2 = koristeAlatyyppi2;
        this.koristeAlatyyppiOtsikko = koristeAlatyyppiOtsikko;
        this.koristeValintaPanel = koristeValintaPanel;
        koristeValintaBar = koristeValintaScrollPane.getHorizontalScrollBar();
        this.esikatseluKoristeLabel = esikatseluKoristeLabel;
        this.hautakivi = hautakivi;
    }
    
    
    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox koristeTyyppi = (JComboBox)e.getSource();
        String koristeTyyppiText = (String)koristeTyyppi.getSelectedItem();
        String path;
        Image[] tmpImages;
        DescriptionImage[] descImages;
        
        
        if ("Ornamentit".equalsIgnoreCase(koristeTyyppiText))  {
            this.koristeAlatyyppi.setVisible(false);
            this.koristeAlatyyppi2.setVisible(false);
            this.koristeAlatyyppiOtsikko.setVisible(false);         
            
            this.koristeValintaPanel.removeAll();
            
            /* download images if not downloaded yet */
            if (!ImageArrays.ornamentitFlag) {
                path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Ornamentit\\";
                ImageArrays.ornamentitMustaImages =  HautakiviohjelmaUI.loadImages(path);
                tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.ornamentitMustaImages, 0.2f);
                ImageArrays.ornamentitThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "ornamentit", true);
                /* add mouselistener */
                for (EsikatseluJLabel koriste: ImageArrays.ornamentitThumbnails) {
                    koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                }
                ImageArrays.ornamentitFlag = true;
            }
            for (EsikatseluJLabel koriste: ImageArrays.ornamentitThumbnails) {
                this.koristeValintaPanel.add(koriste);
            }
            /* load hopea and kulta images */
            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Ornamentit\\hopea\\";
                ImageArrays.ornamentitHopeaImages =  HautakiviohjelmaUI.loadImages(path);
             path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Ornamentit\\kulta\\";
                ImageArrays.ornamentitKultaImages =  HautakiviohjelmaUI.loadImages(path);

            /* move scrollbar to beginning of the panel */
            koristeValintaBar.setValue(0);
            /* repaint panel */
            koristeValintaPanel.repaint();
        }
        else if ("Pronssilyhdyt".equalsIgnoreCase(koristeTyyppiText))  {
            this.koristeAlatyyppi.setVisible(false);
            this.koristeAlatyyppi2.setVisible(false);
            this.koristeAlatyyppiOtsikko.setVisible(false);         
            
            this.koristeValintaPanel.removeAll();
            
            /* download images if not downloaded yet */
            if (!ImageArrays.pronssilyhdytFlag) {
                path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Pronssilyhdyt\\";
                ImageArrays.pronssilyhdytImages =  HautakiviohjelmaUI.loadImages(path);
                tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.pronssilyhdytImages, 0.3f);
                ImageArrays.pronssilyhdytThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "pronssilyhdyt", true);
                /* add mouselistener */
                for (EsikatseluJLabel koriste: ImageArrays.pronssilyhdytThumbnails) {
                    koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                }
                ImageArrays.pronssilyhdytFlag = true;
            }
            for (EsikatseluJLabel koriste: ImageArrays.pronssilyhdytThumbnails) {
                this.koristeValintaPanel.add(koriste);
            }
            /* move scrollbar to beginning of the panel */
            koristeValintaBar.setValue(0);
            /* repaint panel */
            koristeValintaPanel.repaint();
        }
        else if ("Muistolaatat mallit".equalsIgnoreCase(koristeTyyppiText)) {
            this.koristeAlatyyppi.setVisible(false);
            this.koristeAlatyyppi2.setVisible(false);
            this.koristeAlatyyppiOtsikko.setVisible(false);
            
            this.koristeValintaPanel.removeAll();
            
            /* download images if not downloaded yet */
            if (!ImageArrays.muistolaatatMallitFlag) {
                path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muistolaatat_mallit\\";
                ImageArrays.muistolaatatMallitImages = HautakiviohjelmaUI.loadImages(path);
                tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.muistolaatatMallitImages, 0.15f);
                ImageArrays.muistolaatatMallitThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "muistolaatatMallit", true);
                /* add mouselistener */
                for (EsikatseluJLabel koriste: ImageArrays.muistolaatatMallitThumbnails) {
                    koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                }
                ImageArrays.muistolaatatMallitFlag = true;
            }
            for (EsikatseluJLabel koriste: ImageArrays.muistolaatatMallitThumbnails) {
                this.koristeValintaPanel.add(koriste);
            }
            /* move scrollbar to beginning of the panel */
            koristeValintaBar.setValue(0);
            /* repaint panel */
            koristeValintaPanel.repaint();
        }
        else if ("Muistolaatat pohjat".equalsIgnoreCase(koristeTyyppiText)) {
            this.koristeAlatyyppi.setVisible(false);
            this.koristeAlatyyppi2.setVisible(true);
            this.koristeAlatyyppi2.setSelectedIndex(0);
            this.koristeAlatyyppiOtsikko.setVisible(true);
            
            this.koristeValintaPanel.removeAll();
            
            /* download images if not downloaded yet */
            if (!ImageArrays.muistolaatatPohjatKohovalFlag) {
                path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muistolaatat_pohjat\\Kohoval_laattapohjat\\";
                ImageArrays.muistolaatatPohjatKohovalImages = HautakiviohjelmaUI.loadImages(path);
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
        }
        else if ("Veteraanitunnukset".equalsIgnoreCase(koristeTyyppiText)) {
            this.koristeAlatyyppi.setVisible(false);
            this.koristeAlatyyppi2.setVisible(false);
            this.koristeAlatyyppiOtsikko.setVisible(false);
            
            this.koristeValintaPanel.removeAll();
            
            /* download images if not downloaded yet */
            if (!ImageArrays.veteraanitunnuksetFlag) {
                path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Veteraanitunnukset\\";
                ImageArrays.veteraanitunnuksetImages = HautakiviohjelmaUI.loadImages(path);
                tmpImages = HautakiviohjelmaUI.scaleImages(ImageArrays.veteraanitunnuksetImages, 0.15f);
                ImageArrays.veteraanitunnuksetThumbnails = HautakiviohjelmaUI.createThumbnailImages(tmpImages, "veteraanitunnukset", true);
                /* add mouselistener */
                for (EsikatseluJLabel koriste: ImageArrays.veteraanitunnuksetThumbnails) {
                    koriste.addMouseListener(new KoristeMouseEventListener(esikatseluKoristeLabel, hautakivi));
                }
                ImageArrays.veteraanitunnuksetFlag = true;
            }
            for (EsikatseluJLabel koriste: ImageArrays.veteraanitunnuksetThumbnails) {
                this.koristeValintaPanel.add(koriste);
            }
            /* move scrollbar to beginning of the panel */
            koristeValintaBar.setValue(0);
            /* repaint panel */
            koristeValintaPanel.repaint();
        }
        else {
            this.koristeAlatyyppi.setVisible(true);
            this.koristeAlatyyppi.setSelectedIndex(0);
            this.koristeAlatyyppi2.setVisible(false);
            this.koristeAlatyyppiOtsikko.setVisible(true);
            
            switch (koristeTyyppiText) {
                case "Enkelit":
                    this.koristeValintaPanel.removeAll();

                    for (EsikatseluJLabel koriste: ImageArrays.enkelitKirkasThumbnails) {
                        this.koristeValintaPanel.add(koriste);
                    }
                    /* move scrollbar to beginning of the panel */
                    koristeValintaBar.setValue(0);
                    /* repaint panel */
                    koristeValintaPanel.repaint();
                    break;
                
                case "Holvikehykset":
                    this.koristeValintaPanel.removeAll();
                    
                    /* download images if not downloaded yet */
                    if (!ImageArrays.holvikehyksetKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Holvikehykset\\2_Kirkas\\";
                        ImageArrays.holvikehyksetKirkasImages = HautakiviohjelmaUI.loadImages(path);
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
                     
                case "Kukat":
                    this.koristeValintaPanel.removeAll();
                    
                    /* download images if not downloaded yet */
                    if (!ImageArrays.kukatKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Kukat\\2_Kirkas\\";
                        ImageArrays.kukatKirkasImages = HautakiviohjelmaUI.loadImages(path);
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
                    
                case "Liekit ja lehvät":
                    this.koristeValintaPanel.removeAll();
                    
                    /* download images if not downloaded yet */
                    if (!ImageArrays.liekitJaLehvatKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Liekit_lehvat\\2_Kirkas\\";
                        ImageArrays.liekitJaLehvatKirkasImages = HautakiviohjelmaUI.loadImages(path);
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
                    
                case "Linnut":
                    this.koristeValintaPanel.removeAll();
                    
                    /* download images if not downloaded yet */
                    if (!ImageArrays.linnutKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Linnut\\2_Kirkas\\";
                        ImageArrays.linnutKirkasImages = HautakiviohjelmaUI.loadImages(path);
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
                    break;
                    
                case "Lyhtykehykset":
                    this.koristeValintaPanel.removeAll();
                    
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
                    
                case "Lyhtykehykset risti":
                    this.koristeValintaPanel.removeAll();
                    
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
                    
                case "Muut symbolit":
                    this.koristeValintaPanel.removeAll();
                    
                    /* download images if not downloaded yet */
                    if (!ImageArrays.muutSymbolitKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muut_symbolit\\2_Kirkas\\";
                        ImageArrays.muutSymbolitKirkasImages = HautakiviohjelmaUI.loadImages(path);
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
                    
                case "Puut ja tähkät":
                    this.koristeValintaPanel.removeAll();
                    
                    /* download images if not downloaded yet */
                    if (!ImageArrays.puutJaTahkatKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Puut_tahkat\\2_Kirkas\\";
                        ImageArrays.puutJaTahkatKirkasImages = HautakiviohjelmaUI.loadImages(path);
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
                    
                case "Ristit":
                    this.koristeValintaPanel.removeAll();
                    
                    /* download images if not downloaded yet */
                    if (!ImageArrays.ristitKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Ristit\\2_Kirkas\\";
                        ImageArrays.ristitKirkasImages = HautakiviohjelmaUI.loadImages(path);
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
                    
                case "Yhteenvaletut tekstit":
                     this.koristeValintaPanel.removeAll();
                     
                    /* download images if not downloaded yet */
                    if (!ImageArrays.yhteenvaletutTekstitKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Yhteenvaletut_tekstit\\2_Kirkas\\";
                        ImageArrays.yhteenvaletutTekstitKirkasImages = HautakiviohjelmaUI.loadImages(path);
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
                    
                default: break;
            }
        }
    } 
}