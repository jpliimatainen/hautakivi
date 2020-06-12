/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.TextAttribute;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.Map;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author Juha-Pekka
 */
public class OpenActionListener implements ActionListener {
    
    private BackgroundPanel esikatseluPanel;
    private MuotoJPanel esikatseluMuotoPanel;
    private JLabel pintaLabel;
    private JRadioButton sahattu;
    private JRadioButton hiottu;
    private JRadioButton louhittu;
    private JTextField sukunimiTxt;
    private JTextField vapaaTxt1;
    private JTextField vapaaTxt2;
    private JTextField vapaaTxt3;
    private JTextField vapaaTxt4;
    private JTextField etunimiTxt1;
    private JTextField etunimiTxt2;
    private JTextField etunimiTxt3;
    private JTextField etunimiTxt4;
    private JTextField osTxt1;
    private JTextField osTxt2;
    private JTextField osTxt3;
    private JTextField osTxt4;
    private JTextField syntymaAikaTxt1;
    private JTextField syntymaAikaTxt2;
    private JTextField syntymaAikaTxt3;
    private JTextField syntymaAikaTxt4;
    private JTextField kuolinAikaTxt1;
    private JTextField kuolinAikaTxt2;
    private JTextField kuolinAikaTxt3;
    private JTextField kuolinAikaTxt4;
    private JTextField yhteysNimiTxt;
    private JTextField yhteysPuhelinTxt;
    private JTextField yhteysEmailTxt;
    private EsikatseluSukunimi esikatseluSukunimi;
    private EsikatseluHenkilo[] esikatseluHenkilo;
    private EsikatseluHenkiloPanel[] esikatseluHenkiloPanel;
    private EsikatseluJLabel[] esikatseluKoristeLabel;
    private EsikatseluJLabel esikatseluYhteystiedotLabel;
    private EsikatseluJLabel esikatseluYhteystiedotNimi;
    private EsikatseluJLabel esikatseluYhteystiedotPuhelin;
    private EsikatseluJLabel esikatseluYhteystiedotEmail;
    private Hautakivi hautakivi;
    
    public OpenActionListener(BackgroundPanel esikatseluPanel, MuotoJPanel esikatseluMuotoPanel, JLabel pintaLabel, 
            JRadioButton sahattu, JRadioButton hiottu, JRadioButton louhittu, JTextField sukunimiTxt, JTextField vapaaTxt1, 
            JTextField vapaaTxt2, JTextField vapaaTxt3, JTextField vapaaTxt4, JTextField etunimiTxt1, JTextField etunimiTxt2, 
            JTextField etunimiTxt3, JTextField etunimiTxt4, JTextField osTxt1, JTextField osTxt2, JTextField osTxt3, JTextField osTxt4, 
            JTextField syntymaAikaTxt1, JTextField syntymaAikaTxt2, JTextField syntymaAikaTxt3, JTextField syntymaAikaTxt4, 
            JTextField kuolinAikaTxt1, JTextField kuolinAikaTxt2, JTextField kuolinAikaTxt3, JTextField kuolinAikaTxt4, JTextField yhteysNimiTxt, 
            JTextField yhteysPuhelinTxt, JTextField yhteysEmailTxt, EsikatseluSukunimi esikatseluSukunimi, EsikatseluHenkilo[] esikatseluHenkilo, 
            EsikatseluHenkiloPanel[] esikatseluHenkiloPanel, EsikatseluJLabel[] esikatseluKoristeLabel, EsikatseluJLabel esikatseluYhteystiedotLabel, 
            EsikatseluJLabel esikatseluYhteystiedotNimi, EsikatseluJLabel esikatseluYhteystiedotPuhelin, EsikatseluJLabel esikatseluYhteystiedotEmail, 
            Hautakivi hautakivi) {
        this.esikatseluPanel = esikatseluPanel;
        this.esikatseluMuotoPanel = esikatseluMuotoPanel;
        this.pintaLabel = pintaLabel;
        this.sahattu = sahattu;
        this.hiottu = hiottu;
        this.louhittu = louhittu;
        this.sukunimiTxt = sukunimiTxt;
        this.vapaaTxt1 = vapaaTxt1;
        this.vapaaTxt2 = vapaaTxt2;
        this.vapaaTxt3 = vapaaTxt3;
        this.vapaaTxt4 = vapaaTxt4;
        this.etunimiTxt1 = etunimiTxt1;
        this.etunimiTxt2 = etunimiTxt2;
        this.etunimiTxt3 = etunimiTxt3;
        this.etunimiTxt4 = etunimiTxt4;
        this.osTxt1 = osTxt1;
        this.osTxt2 = osTxt2;
        this.osTxt3 = osTxt3;
        this.osTxt4 = osTxt4;
        this.syntymaAikaTxt1 = syntymaAikaTxt1;
        this.syntymaAikaTxt2 = syntymaAikaTxt2;
        this.syntymaAikaTxt3 = syntymaAikaTxt3;
        this.syntymaAikaTxt4 = syntymaAikaTxt4;
        this.kuolinAikaTxt1 = kuolinAikaTxt1;
        this.kuolinAikaTxt2 = kuolinAikaTxt2;
        this.kuolinAikaTxt3 = kuolinAikaTxt3;
        this.kuolinAikaTxt4 = kuolinAikaTxt4;
        this.yhteysNimiTxt = yhteysNimiTxt;
        this.yhteysPuhelinTxt = yhteysPuhelinTxt;
        this.yhteysEmailTxt = yhteysEmailTxt;
        this.esikatseluSukunimi = esikatseluSukunimi;
        this.esikatseluHenkilo = esikatseluHenkilo;
        this.esikatseluHenkiloPanel = esikatseluHenkiloPanel;
        this.esikatseluKoristeLabel = esikatseluKoristeLabel;
        this.esikatseluYhteystiedotLabel = esikatseluYhteystiedotLabel;
        this.esikatseluYhteystiedotNimi = esikatseluYhteystiedotNimi;
        this.esikatseluYhteystiedotPuhelin = esikatseluYhteystiedotPuhelin;
        this.esikatseluYhteystiedotEmail = esikatseluYhteystiedotEmail;
        this.hautakivi = hautakivi;
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        
        String description, labelType, henkiloTekstiStr, sukunimiStr, metallikirjasinTyyppiTxt, 
                metallikirjasinAlaTyyppiTxt, kuolinAikaStr, syntymaAikaStr, path;
        int i, index, height, henkiloTekstiLength, j, koristeKierto, leveys, posX, 
                posY, sukunimiLength, width, variIndex;
        float fontWidth;
        double ratio;
        Image[] scaledImages;
        FontImage[] fontImages;
        JLabel[] letters;
        Dimension size;
        Map<TextAttribute, Float> attributes = new HashMap<>();
        JPanel henkiloMetalliTekstit;
        Henkilo.Tasaus tasaus;
        Border emptyBorder = BorderFactory.createEmptyBorder();
        BufferedImage iconImage = null;
        BufferedImage muotoImage = null;
        boolean sahattu, hiottu, louhittu;
        
        JFileChooser openCmd = new JFileChooser();
        FileNameExtensionFilter nameExt = new FileNameExtensionFilter("Hautakivi Files", "hkf");
        openCmd.setFileFilter(nameExt);
        int returnVal = openCmd.showOpenDialog(null);
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            try {
                FileInputStream fileIStream = new FileInputStream(openCmd.getCurrentDirectory().getAbsolutePath()+"/"+openCmd.getSelectedFile().getName());
                ObjectInputStream  objectIStream = new ObjectInputStream(fileIStream);
                Hautakivi readHautakivi = (Hautakivi)objectIStream.readObject();
                objectIStream.close();
                
                /* update the current object */
                this.hautakivi.setTaustaKuvaIndex(readHautakivi.getTaustaKuvaIndex());
                this.hautakivi.setMuotoKuvaDescription(readHautakivi.getMuotoKuvaDescription());
                this.hautakivi.setKivenLeveys(readHautakivi.getKivenLeveys());
                this.hautakivi.setKivenKorkeus(readHautakivi.getKivenKorkeus());
                this.hautakivi.setPintaSahattu(readHautakivi.isPintaSahattu());
                this.hautakivi.setPintaHiottu(readHautakivi.isPintaHiottu());
                this.hautakivi.setPintaLouhittu(readHautakivi.isPintaLouhittu());
                this.hautakivi.setKivenVariIndex(readHautakivi.getKivenVariIndex());
                this.hautakivi.setSukunimi(readHautakivi.getSukunimi());
                this.hautakivi.setSukunimiX(readHautakivi.getSukunimiX());
                this.hautakivi.setSukunimiY(readHautakivi.getSukunimiY());
                this.hautakivi.setSukunimiFontWidth(readHautakivi.getSukunimiFontWidth());
                this.hautakivi.setSukunimiKaiverrettu(readHautakivi.isSukunimiKaiverrettu());
                this.hautakivi.setSukunimiFontColor(readHautakivi.getSukunimiFontColor());
                this.hautakivi.setSukunimiFontSize(readHautakivi.getSukunimiFontSize());
                this.hautakivi.setSukunimiFontIndex(readHautakivi.getSukunimiFontIndex());
                this.hautakivi.setSukunimiMetallikirjasinKoko(readHautakivi.getSukunimiMetallikirjasinKoko());
                this.hautakivi.setSukunimiMetallikirjasinTyyppi(readHautakivi.getSukunimiMetallikirjasinTyyppi());
                this.hautakivi.setSukunimiMetallikirjasinAlaTyyppi(readHautakivi.getSukunimiMetallikirjasinAlaTyyppi());
                this.hautakivi.setKoristeCounter(readHautakivi.getKoristeCounter());
                this.hautakivi.setYhteysNimi(readHautakivi.getYhteysNimi());
                this.hautakivi.setYhteysPuhelin(readHautakivi.getYhteysPuhelin());
                this.hautakivi.setYhteysEmail(readHautakivi.getYhteysEmail());
                
                for (i=0; i<Hautakivi.HENKILOMAARA; i++) {
                    this.hautakivi.getHenkilo(i).setVapaaTeksti(readHautakivi.getHenkilo(i).getVapaaTeksti());
                    this.hautakivi.getHenkilo(i).setEtunimet(readHautakivi.getHenkilo(i).getEtunimet());
                    this.hautakivi.getHenkilo(i).setOs(readHautakivi.getHenkilo(i).getOs());
                    this.hautakivi.getHenkilo(i).setSyntymaAika(readHautakivi.getHenkilo(i).getSyntymaAika());
                    this.hautakivi.getHenkilo(i).setKuolinAika(readHautakivi.getHenkilo(i).getKuolinAika());
                    this.hautakivi.getHenkilo(i).setFontWidth(readHautakivi.getHenkilo(i).getFontWidth());
                    this.hautakivi.getHenkilo(i).setTasaus(readHautakivi.getHenkilo(i).getTasaus());
                    this.hautakivi.getHenkilo(i).setHenkiloKaiverrettu(readHautakivi.getHenkilo(i).isHenkiloKaiverrettu());
                    this.hautakivi.getHenkilo(i).setFontColor(readHautakivi.getHenkilo(i).getFontColor());
                    this.hautakivi.getHenkilo(i).setVapaaTekstiFontSize(readHautakivi.getHenkilo(i).getVapaaTekstiFontSize());
                    this.hautakivi.getHenkilo(i).setEtunimetFontSize(readHautakivi.getHenkilo(i).getEtunimetFontSize());
                    this.hautakivi.getHenkilo(i).setOsFontSize(readHautakivi.getHenkilo(i).getOsFontSize());
                    this.hautakivi.getHenkilo(i).setSyntymaJaKuolinAikaFontSize(readHautakivi.getHenkilo(i).getSyntymaJaKuolinAikaFontSize());
                    this.hautakivi.getHenkilo(i).setFontIndex(readHautakivi.getHenkilo(i).getFontIndex());
                    this.hautakivi.getHenkilo(i).setHenkiloMetallikirjasinVapaaTekstiKoko(readHautakivi.getHenkilo(i).getHenkiloMetallikirjasinVapaaTekstiKoko());
                    this.hautakivi.getHenkilo(i).setHenkiloMetallikirjasinEtunimetKoko(readHautakivi.getHenkilo(i).getHenkiloMetallikirjasinEtunimetKoko());
                    this.hautakivi.getHenkilo(i).setHenkiloMetallikirjasinOsKoko(readHautakivi.getHenkilo(i).getHenkiloMetallikirjasinOsKoko());
                    this.hautakivi.getHenkilo(i).setHenkiloMetallikirjasinSyntymaJaKuolinAikaKoko(readHautakivi.getHenkilo(i).getHenkiloMetallikirjasinSyntymaJaKuolinAikaKoko());
                    this.hautakivi.getHenkilo(i).setHenkiloMetallikirjasinTyyppi(readHautakivi.getHenkilo(i).getHenkiloMetallikirjasinTyyppi());
                    this.hautakivi.getHenkilo(i).setHenkiloMetallikirjasinAlaTyyppi(readHautakivi.getHenkilo(i).getHenkiloMetallikirjasinAlaTyyppi());
                    this.hautakivi.getHenkilo(i).setHenkiloX(readHautakivi.getHenkilo(i).getHenkiloX());
                    this.hautakivi.getHenkilo(i).setHenkiloY(readHautakivi.getHenkilo(i).getHenkiloY());
                }
                
                for (i=0; i<Hautakivi.KORISTEMAARA; i++) {
                    this.hautakivi.getKoriste(i).setKoristeKierto(readHautakivi.getKoriste(i).getKoristeKierto());
                    this.hautakivi.getKoriste(i).setKoristePinossa(readHautakivi.getKoriste(i).getKoristePinossa());
                    this.hautakivi.getKoriste(i).setKoristeKorkeus(readHautakivi.getKoriste(i).getKoristeKorkeus());
                    this.hautakivi.getKoriste(i).setKoristeLeveys(readHautakivi.getKoriste(i).getKoristeLeveys());
                    this.hautakivi.getKoriste(i).setKoristeX(readHautakivi.getKoriste(i).getKoristeX());
                    this.hautakivi.getKoriste(i).setKoristeY(readHautakivi.getKoriste(i).getKoristeY());
                    this.hautakivi.getKoriste(i).setKoristeIndex(readHautakivi.getKoriste(i).getKoristeIndex());
                    this.hautakivi.getKoriste(i).setKoristeLabelType(readHautakivi.getKoriste(i).getKoristeLabelType());
                }
                
                /* update taustakuva */
                index = this.hautakivi.getTaustaKuvaIndex();
                this.esikatseluPanel.setImage(ImageArrays.taustaImages[index]);
        
                /* change font color so that text can be read */
                if (index < 3) {
                    esikatseluYhteystiedotLabel.setForeground(new Color(0, 0, 255));
                    esikatseluYhteystiedotNimi.setForeground(new Color(0, 0, 255));
                    esikatseluYhteystiedotPuhelin.setForeground(new Color(0, 0, 255));
                    esikatseluYhteystiedotEmail.setForeground(new Color(0, 0, 255));
                }
                else {
                    esikatseluYhteystiedotLabel.setForeground(new Color(255, 255, 255));
                    esikatseluYhteystiedotNimi.setForeground(new Color(255, 255, 255));
                    esikatseluYhteystiedotPuhelin.setForeground(new Color(255, 255, 255));
                    esikatseluYhteystiedotEmail.setForeground(new Color(255, 255, 255));
                }
        
                /* update esikatselu panel */
                this.esikatseluPanel.repaint();
                
        
                /* update muotokuva */
                description = this.hautakivi.getMuotoKuvaDescription();
                variIndex = this.hautakivi.getKivenVariIndex();
                width = this.hautakivi.getKivenLeveys();
                height = this.hautakivi.getKivenKorkeus();
                sahattu = this.hautakivi.isPintaSahattu();
                hiottu = this.hautakivi.isPintaHiottu();
                louhittu = this.hautakivi.isPintaLouhittu();
                
                muotoImage = HautakiviShapes.createHautakiviShape(variIndex, width, height, 
                        description, sahattu, hiottu, louhittu);
                this.esikatseluMuotoPanel.setBackground(muotoImage);
                this.esikatseluMuotoPanel.setSize(esikatseluMuotoPanel.getImage().getWidth(null), 
                        esikatseluMuotoPanel.getImage().getHeight(null));
                this.esikatseluMuotoPanel.setLocation(0, 0);
                this.esikatseluMuotoPanel.repaint();
                
                /* set visibility for pinta selection */
                if (description.endsWith("suorakulmio.png") || description.endsWith("kaareva1.png") || 
                        description.endsWith("kaareva2.png") || description.endsWith("kaareva3.png") || 
                        description.endsWith("Hauta03.png") || description.endsWith("Hauta05.png") || 
                        description.endsWith("Hauta07.png") || description.endsWith("Hauta12.png") || 
                        description.endsWith("Hauta41.png") || description.endsWith("Hauta42.png") ||
                        description.endsWith("Hauta43.png") || description.endsWith("Hauta44.png") ||
                        description.endsWith("Hauta45.png") || description.endsWith("Hauta46.png") ||
                        description.endsWith("Hauta47.png") || description.endsWith("Hauta49.png") ||
                        description.endsWith("Hauta50.png") || description.endsWith("Hauta56.png") ||
                        description.endsWith("Hauta58.png") || description.endsWith("Hauta60.png")) {
                    
                    this.pintaLabel.setVisible(true);
                    this.sahattu.setVisible(true);
                    this.hiottu.setVisible(true);
                    this.louhittu.setVisible(true);
                }
                else {
                    this.pintaLabel.setVisible(false);
                    this.sahattu.setVisible(false);
                    this.hiottu.setVisible(false);
                    this.louhittu.setVisible(false);
                }
                
                if (sahattu) {
                    this.sahattu.setSelected(true);
                }
                else if (hiottu) {
                    this.hiottu.setSelected(true);
                }
                else {
                    this.louhittu.setSelected(true);
                }
                
                /* update sukunimi */
                this.sukunimiTxt.setText(this.hautakivi.getSukunimi());
                
                if (this.hautakivi.isSukunimiKaiverrettu()) {
                    this.esikatseluSukunimi.getMetallikirjasinTxt().setChosen(false);
                    this.esikatseluSukunimi.getMetallikirjasinTxt().setVisible(false);
                    this.esikatseluSukunimi.getKaiverrettukirjasinTxt().setChosen(false);
                    this.esikatseluSukunimi.getKaiverrettukirjasinTxt().setVisible(true);
                    this.esikatseluSukunimi.getMetallikirjasinTxt().setBorder(emptyBorder);
                    this.esikatseluSukunimi.getKaiverrettukirjasinTxt().setBorder(emptyBorder);
                    
                    if (!attributes.isEmpty()) {
                        attributes.clear();
                    }
                    attributes.put(TextAttribute.TRACKING, this.hautakivi.getSukunimiFontWidth());
                    
                    this.esikatseluSukunimi.getKaiverrettukirjasinTxt().setForeground(this.hautakivi.getSukunimiFontColor());
                    this.esikatseluSukunimi.getKaiverrettukirjasinTxt().setFont(MyFonts.fontLib[this.hautakivi.getSukunimiFontIndex()].deriveFont(
                            this.hautakivi.getSukunimiFontSize()).deriveFont(attributes));
                    
                    /* calculate new bounds */    
                    size = this.esikatseluSukunimi.getKaiverrettukirjasinTxt().getPreferredSize();
                    width = size.width;
                    height = size.height;
                    posX = this.hautakivi.getSukunimiX();
                    posY = this.hautakivi.getSukunimiY();
                    this.esikatseluSukunimi.getKaiverrettukirjasinTxt().setBounds(posX, posY, width+5, height+5);
            
                    this.esikatseluSukunimi.getKaiverrettukirjasinTxt().revalidate();
                }
                else {
                    this.esikatseluSukunimi.getMetallikirjasinTxt().setChosen(false);
                    this.esikatseluSukunimi.getMetallikirjasinTxt().setVisible(true);
                    this.esikatseluSukunimi.getKaiverrettukirjasinTxt().setChosen(false);
                    this.esikatseluSukunimi.getKaiverrettukirjasinTxt().setVisible(false);
                    this.esikatseluSukunimi.getMetallikirjasinTxt().setBorder(emptyBorder);
                    this.esikatseluSukunimi.getKaiverrettukirjasinTxt().setBorder(emptyBorder);
                    
                    metallikirjasinTyyppiTxt = this.hautakivi.getSukunimiMetallikirjasinTyyppi();
                    metallikirjasinAlaTyyppiTxt = this.hautakivi.getSukunimiMetallikirjasinAlaTyyppi();
                    
                    /* load font images if not yet loaded */
                    loadMetalliFonts(metallikirjasinTyyppiTxt, metallikirjasinAlaTyyppiTxt);
                    
                    sukunimiStr = this.hautakivi.getSukunimi();
                    sukunimiLength = sukunimiStr.length(); 
                    scaledImages = new Image[sukunimiLength];
                    
                    this.esikatseluSukunimi.setMetallikirjasinFontImages(FontImage.getFontImages(sukunimiStr, this.hautakivi.getSukunimiMetallikirjasinTyyppi(), 
                            this.hautakivi.getSukunimiMetallikirjasinAlaTyyppi(), false));
                    fontImages = new FontImage[sukunimiLength];
                    fontImages = this.esikatseluSukunimi.getMetallikirjasinFontImages();
                    
                    for (i=0; i<sukunimiLength; i++) {
                        scaledImages[i] = HautakiviohjelmaUI.scaleImage(fontImages[i].getImage(), fontImages[i].getImage().getWidth(), 
                            fontImages[i].getImage().getHeight(), this.hautakivi.getSukunimiMetallikirjasinKoko());
                    }
                    this.esikatseluSukunimi.insertMetallikirjasinLabels(scaledImages);
            
                    letters = this.esikatseluSukunimi.getMetallikirjasinFontLabels();
                    this.esikatseluSukunimi.getMetallikirjasinTxt().removeAll();
                    fontWidth = this.hautakivi.getSukunimiFontWidth();
                    size = new Dimension((int)(fontWidth*10)+1, 0);
            
                    for (i=0; i<sukunimiLength; i++) {
                        this.esikatseluSukunimi.getMetallikirjasinTxt().add(letters[i]);
                        letters[i].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                        this.esikatseluSukunimi.getMetallikirjasinTxt().add(Box.createRigidArea(size));
                    }
                    /* calculate new bounds */    
                    size = this.esikatseluSukunimi.getMetallikirjasinTxt().getPreferredSize();
                    width = size.width;
                    height = size.height;
                    posX = this.hautakivi.getSukunimiX();
                    posY = this.hautakivi.getSukunimiY();
                    this.esikatseluSukunimi.getMetallikirjasinTxt().setBounds(posX, posY, width+5, height+5);
            
                    this.esikatseluSukunimi.getMetallikirjasinTxt().revalidate();
                }
                
                /* update nimet */
                this.vapaaTxt1.setText(this.hautakivi.getHenkilo(0).getVapaaTeksti());
                this.etunimiTxt1.setText(this.hautakivi.getHenkilo(0).getEtunimet());
                this.osTxt1.setText(this.hautakivi.getHenkilo(0).getOs());
                this.syntymaAikaTxt1.setText(this.hautakivi.getHenkilo(0).getSyntymaAika());
                this.kuolinAikaTxt1.setText(readHautakivi.getHenkilo(0).getKuolinAika());
                
                this.vapaaTxt2.setText(this.hautakivi.getHenkilo(1).getVapaaTeksti());
                this.etunimiTxt2.setText(this.hautakivi.getHenkilo(1).getEtunimet());
                this.osTxt2.setText(this.hautakivi.getHenkilo(1).getOs());
                this.syntymaAikaTxt2.setText(this.hautakivi.getHenkilo(1).getSyntymaAika());
                this.kuolinAikaTxt2.setText(readHautakivi.getHenkilo(1).getKuolinAika());
                
                this.vapaaTxt3.setText(this.hautakivi.getHenkilo(2).getVapaaTeksti());
                this.etunimiTxt3.setText(this.hautakivi.getHenkilo(2).getEtunimet());
                this.osTxt3.setText(this.hautakivi.getHenkilo(2).getOs());
                this.syntymaAikaTxt3.setText(this.hautakivi.getHenkilo(2).getSyntymaAika());
                this.kuolinAikaTxt3.setText(readHautakivi.getHenkilo(2).getKuolinAika());
                
                this.vapaaTxt4.setText(this.hautakivi.getHenkilo(3).getVapaaTeksti());
                this.etunimiTxt4.setText(this.hautakivi.getHenkilo(3).getEtunimet());
                this.osTxt4.setText(this.hautakivi.getHenkilo(3).getOs());
                this.syntymaAikaTxt4.setText(this.hautakivi.getHenkilo(3).getSyntymaAika());
                this.kuolinAikaTxt4.setText(readHautakivi.getHenkilo(3).getKuolinAika());

                for (i=0; i<Hautakivi.HENKILOMAARA; i++) {
                    this.esikatseluHenkiloPanel[i].setBorder(emptyBorder);
                    if (this.hautakivi.getHenkilo(i).isHenkiloKaiverrettu()) {
                        this.esikatseluHenkiloPanel[i].setChosen(false);
                        this.esikatseluHenkilo[i].setKaiverrettuKirjasin(true);
                        
                        this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasin().setVisible(false);
                        this.esikatseluHenkilo[i].getEtunimetMetallikirjasin().setVisible(false);
                        this.esikatseluHenkilo[i].getOsMetallikirjasin().setVisible(false);
                        this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasin().setVisible(false);
                    
                        this.esikatseluHenkilo[i].getVapaaTekstiKaiverrettu().setVisible(true);
                        this.esikatseluHenkilo[i].getEtunimetKaiverrettu().setVisible(true);
                        this.esikatseluHenkilo[i].getOsKaiverrettu().setVisible(true);
                        this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaKaiverrettu().setVisible(true);
                    
                        if (!attributes.isEmpty()) {
                            attributes.clear();
                        }
                        attributes.put(TextAttribute.TRACKING, this.hautakivi.getHenkilo(i).getFontWidth());
                    
                        this.esikatseluHenkilo[i].setForegroundKaiverrettu(this.hautakivi.getHenkilo(i).getFontColor());
                        
                        this.esikatseluHenkilo[i].setVapaaTekstiFontKaiverrettu(MyFonts.fontLib[this.hautakivi.getHenkilo(i).getFontIndex()].deriveFont(
                                this.hautakivi.getHenkilo(i).getVapaaTekstiFontSize()).deriveFont(attributes));
                        this.esikatseluHenkilo[i].setEtunimetFontKaiverrettu(MyFonts.fontLib[this.hautakivi.getHenkilo(i).getFontIndex()].deriveFont(
                                this.hautakivi.getHenkilo(i).getEtunimetFontSize()).deriveFont(attributes));
                        this.esikatseluHenkilo[i].setOsFontKaiverrettu(MyFonts.fontLib[this.hautakivi.getHenkilo(i).getFontIndex()].deriveFont(
                                this.hautakivi.getHenkilo(i).getOsFontSize()).deriveFont(attributes));
                        this.esikatseluHenkilo[i].setSyntymaJaKuolinAikaFontKaiverrettu(MyFonts.fontLib[this.hautakivi.getHenkilo(i).getFontIndex()].deriveFont(
                                this.hautakivi.getHenkilo(i).getSyntymaJaKuolinAikaFontSize()).deriveFont(attributes));
                        
                        /* set tasaus */
                        tasaus = this.hautakivi.getHenkilo(i).getTasaus();
                        if (tasaus == Henkilo.Tasaus.VASEN) {
                            this.esikatseluHenkilo[i].getVapaaTekstiKaiverrettu().setAlignmentX(Component.LEFT_ALIGNMENT);
                            this.esikatseluHenkilo[i].getEtunimetKaiverrettu().setAlignmentX(Component.LEFT_ALIGNMENT);
                            this.esikatseluHenkilo[i].getOsKaiverrettu().setAlignmentX(Component.LEFT_ALIGNMENT);
                            this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaKaiverrettu().setAlignmentX(Component.LEFT_ALIGNMENT);
                        }
                        else if (tasaus == Henkilo.Tasaus.KESKITETTY) {
                            this.esikatseluHenkilo[i].getVapaaTekstiKaiverrettu().setAlignmentX(Component.CENTER_ALIGNMENT);
                            this.esikatseluHenkilo[i].getEtunimetKaiverrettu().setAlignmentX(Component.CENTER_ALIGNMENT);
                            this.esikatseluHenkilo[i].getOsKaiverrettu().setAlignmentX(Component.CENTER_ALIGNMENT);
                            this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaKaiverrettu().setAlignmentX(Component.CENTER_ALIGNMENT);
                        }
                        else if (tasaus == Henkilo.Tasaus.OIKEA) {
                            this.esikatseluHenkilo[i].getVapaaTekstiKaiverrettu().setAlignmentX(Component.RIGHT_ALIGNMENT);
                            this.esikatseluHenkilo[i].getEtunimetKaiverrettu().setAlignmentX(Component.RIGHT_ALIGNMENT);
                            this.esikatseluHenkilo[i].getOsKaiverrettu().setAlignmentX(Component.RIGHT_ALIGNMENT);
                            this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaKaiverrettu().setAlignmentX(Component.RIGHT_ALIGNMENT);
                        }
                        /* calculate new bounds */    
                        size = this.esikatseluHenkiloPanel[i].getPreferredSize();
                        posX = this.hautakivi.getHenkilo(i).getHenkiloX();
                        posY = this.hautakivi.getHenkilo(i).getHenkiloY();
                        if (size.width == 0 && size.height == 0) { // empty henkilo
                            this.esikatseluHenkiloPanel[i].setBounds(posX, posY, size.width, size.height);
                        }
                        else {
                            this.esikatseluHenkiloPanel[i].setBounds(posX, posY, size.width+5, size.height+5);
                        }
                        this.esikatseluHenkiloPanel[i].revalidate();
                    }
                    else {
                        this.esikatseluHenkiloPanel[i].setChosen(false);
                        this.esikatseluHenkilo[i].setKaiverrettuKirjasin(false);
                        
                        this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasin().setVisible(true);
                        this.esikatseluHenkilo[i].getEtunimetMetallikirjasin().setVisible(true);
                        this.esikatseluHenkilo[i].getOsMetallikirjasin().setVisible(true);
                        this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasin().setVisible(true);
                    
                        this.esikatseluHenkilo[i].getVapaaTekstiKaiverrettu().setVisible(false);
                        this.esikatseluHenkilo[i].getEtunimetKaiverrettu().setVisible(false);
                        this.esikatseluHenkilo[i].getOsKaiverrettu().setVisible(false);
                        this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaKaiverrettu().setVisible(false);
                    
                        metallikirjasinTyyppiTxt = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinTyyppi();
                        metallikirjasinAlaTyyppiTxt = this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinAlaTyyppi();
                        
                        /* load font images if not yet loaded */
                        loadMetalliFonts(metallikirjasinTyyppiTxt, metallikirjasinAlaTyyppiTxt);
                    
                        henkiloTekstiStr = this.hautakivi.getHenkilo(i).getVapaaTeksti();
                        if (!"".equals(henkiloTekstiStr)) {
                            henkiloTekstiLength = henkiloTekstiStr.length(); 
                            scaledImages = new Image[henkiloTekstiLength];
                            henkiloMetalliTekstit = this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasin();
            
                        this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                metallikirjasinAlaTyyppiTxt, false), this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontImages());
                        fontImages = new FontImage[henkiloTekstiLength];
                        fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontImages());
                        for (j=0; j<henkiloTekstiLength; j++) {
                            scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                    fontImages[j].getImage().getHeight(), this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinVapaaTekstiKoko());
                        }
            
                        this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontLabels());
                        
                        letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasinFontLabels());
                        henkiloMetalliTekstit.removeAll();
                        fontWidth = this.hautakivi.getHenkilo(i).getFontWidth();
                        size = new Dimension((int)(fontWidth*10)+1, 10);
                        for (j=0; j<henkiloTekstiLength; j++) {
                            henkiloMetalliTekstit.add(letters[j]);
                            letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                            henkiloMetalliTekstit.add(Box.createRigidArea(size));
                        }
                        /* calculate new bounds */    
                        size = henkiloMetalliTekstit.getPreferredSize();
                        width = size.width;
                        height = size.height;
                        henkiloMetalliTekstit.setBounds(0, 0, width, height);
                        henkiloMetalliTekstit.revalidate();
                    }

                    henkiloTekstiStr = this.hautakivi.getHenkilo(i).getEtunimet();
                    if (!"".equals(henkiloTekstiStr)) {
                        henkiloTekstiLength = henkiloTekstiStr.length(); 
                        scaledImages = new Image[henkiloTekstiLength];
                        henkiloMetalliTekstit = this.esikatseluHenkilo[i].getEtunimetMetallikirjasin();
            
                        this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                metallikirjasinAlaTyyppiTxt, false), this.esikatseluHenkilo[i].getEtunimetMetallikirjasinFontImages());
                        fontImages = new FontImage[henkiloTekstiLength];
                        fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getEtunimetMetallikirjasinFontImages());
                        for (j=0; j<henkiloTekstiLength; j++) {
                            scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                    fontImages[j].getImage().getHeight(), this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinEtunimetKoko());
                        }
            
                        this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getEtunimetMetallikirjasinFontLabels());
            
                        letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getEtunimetMetallikirjasinFontLabels());
                        henkiloMetalliTekstit.removeAll();
                        fontWidth = this.hautakivi.getHenkilo(i).getFontWidth();
                        size = new Dimension((int)(fontWidth*10)+1, 10);
                        for (j=0; j<henkiloTekstiLength; j++) {
                            henkiloMetalliTekstit.add(letters[j]);
                            letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                            henkiloMetalliTekstit.add(Box.createRigidArea(size));
                        }
                        /* calculate new bounds */    
                        size = henkiloMetalliTekstit.getPreferredSize();
                        width = size.width;
                        height = size.height;
                        henkiloMetalliTekstit.setBounds(0, 0, width, height);
                        henkiloMetalliTekstit.revalidate();
                    }

                    henkiloTekstiStr = this.hautakivi.getHenkilo(i).getOs();
                    if (!"".equals(henkiloTekstiStr)) {
                        if (!" ".equals(henkiloTekstiStr)) {
                            henkiloTekstiStr = "o.s. " + henkiloTekstiStr;
                        }
                        henkiloTekstiLength = henkiloTekstiStr.length(); 
                        scaledImages = new Image[henkiloTekstiLength];
                        henkiloMetalliTekstit = this.esikatseluHenkilo[i].getOsMetallikirjasin();
            
                        this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                metallikirjasinAlaTyyppiTxt, true), this.esikatseluHenkilo[i].getOsMetallikirjasinFontImages());
                        fontImages = new FontImage[henkiloTekstiLength];
                        fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getOsMetallikirjasinFontImages());
                        for (j=0; j<henkiloTekstiLength; j++) {
                            scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                    fontImages[j].getImage().getHeight(), this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinOsKoko());
                        }
            
                        this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getOsMetallikirjasinFontLabels());
            
                        letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getOsMetallikirjasinFontLabels());
                        henkiloMetalliTekstit.removeAll();
                        fontWidth = this.hautakivi.getHenkilo(i).getFontWidth();
                        size = new Dimension((int)(fontWidth*10)+1, 10);
                        for (j=0; j<henkiloTekstiLength; j++) {
                            henkiloMetalliTekstit.add(letters[j]);
                            letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                            henkiloMetalliTekstit.add(Box.createRigidArea(size));
                        }
                        /* calculate new bounds */    
                        size = henkiloMetalliTekstit.getPreferredSize();
                        width = size.width;
                        height = size.height;
                        henkiloMetalliTekstit.setBounds(0, 0, width, height);
                        henkiloMetalliTekstit.revalidate();
                    }

                    henkiloMetalliTekstit = this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasin();
                    syntymaAikaStr = this.hautakivi.getHenkilo(i).getSyntymaAika();
                    kuolinAikaStr = this.hautakivi.getHenkilo(i).getKuolinAika();
                    if (syntymaAikaStr.length() > 0 && kuolinAikaStr.length() > 0) {
                        henkiloTekstiStr = "*" + this.hautakivi.getHenkilo(i).getSyntymaAika() + "†" + this.hautakivi.getHenkilo(i).getKuolinAika();
                    }
                    else if (syntymaAikaStr.length() > 0) {
                        henkiloTekstiStr = "*" + this.hautakivi.getHenkilo(i).getSyntymaAika();
                    }
                    else if (kuolinAikaStr.length() > 0) {
                        henkiloTekstiStr = "†" + this.hautakivi.getHenkilo(i).getKuolinAika();
                    }
                    else {
                        henkiloTekstiStr = null;
                        henkiloMetalliTekstit.removeAll();
                    }
                    if (henkiloTekstiStr != null) {
                        henkiloTekstiLength = henkiloTekstiStr.length(); 
                        scaledImages = new Image[henkiloTekstiLength];
                        
            
                        this.esikatseluHenkilo[i].setMetallikirjasinFontImages(FontImage.getFontImages(henkiloTekstiStr, metallikirjasinTyyppiTxt, 
                                metallikirjasinAlaTyyppiTxt, false), this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontImages());
                        fontImages = new FontImage[henkiloTekstiLength];
                        fontImages = esikatseluHenkilo[i].getMetallikirjasinFontImagesArray(esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontImages());
                        
                        for (j=0; j<henkiloTekstiLength; j++) {
                            scaledImages[j] = HautakiviohjelmaUI.scaleImage(fontImages[j].getImage(), fontImages[j].getImage().getWidth(), 
                                    fontImages[j].getImage().getHeight(), this.hautakivi.getHenkilo(i).getHenkiloMetallikirjasinSyntymaJaKuolinAikaKoko());
                        }
            
                        this.esikatseluHenkilo[i].insertMetallikirjasinLabels(scaledImages, this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontLabels());
            
                        letters = this.esikatseluHenkilo[i].getMetallikirjasinFontLabelsArray(this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasinFontLabels());
                        henkiloMetalliTekstit.removeAll();
                        fontWidth = this.hautakivi.getHenkilo(i).getFontWidth();
                        size = new Dimension((int)(fontWidth*10)+1, 10);
                        for (j=0; j<henkiloTekstiLength; j++) {
                            henkiloMetalliTekstit.add(letters[j]);
                            letters[j].setAlignmentY(Component.BOTTOM_ALIGNMENT);
                            henkiloMetalliTekstit.add(Box.createRigidArea(size));
                        }
                        /* calculate new bounds */    
                        size = henkiloMetalliTekstit.getPreferredSize();
                        width = size.width;
                        height = size.height;
                        henkiloMetalliTekstit.setBounds(0, 0, width, height);
                        henkiloMetalliTekstit.revalidate();
                    }
                    /* set tasaus */
                    tasaus = this.hautakivi.getHenkilo(i).getTasaus();
                        
                    if (tasaus == Henkilo.Tasaus.VASEN) {
                        this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasin().setAlignmentX(Component.LEFT_ALIGNMENT);
                        this.esikatseluHenkilo[i].getEtunimetMetallikirjasin().setAlignmentX(Component.LEFT_ALIGNMENT);
                        this.esikatseluHenkilo[i].getOsMetallikirjasin().setAlignmentX(Component.LEFT_ALIGNMENT);
                        this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasin().setAlignmentX(Component.LEFT_ALIGNMENT);
                    }
                    else if (tasaus == Henkilo.Tasaus.KESKITETTY) {
                        this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasin().setAlignmentX(Component.CENTER_ALIGNMENT);
                        this.esikatseluHenkilo[i].getEtunimetMetallikirjasin().setAlignmentX(Component.CENTER_ALIGNMENT);
                        this.esikatseluHenkilo[i].getOsMetallikirjasin().setAlignmentX(Component.CENTER_ALIGNMENT);
                        this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasin().setAlignmentX(Component.CENTER_ALIGNMENT);
                    }
                    else if (tasaus == Henkilo.Tasaus.OIKEA) {
                        this.esikatseluHenkilo[i].getVapaaTekstiMetallikirjasin().setAlignmentX(Component.RIGHT_ALIGNMENT);
                        this.esikatseluHenkilo[i].getEtunimetMetallikirjasin().setAlignmentX(Component.RIGHT_ALIGNMENT);
                        this.esikatseluHenkilo[i].getOsMetallikirjasin().setAlignmentX(Component.RIGHT_ALIGNMENT);
                        this.esikatseluHenkilo[i].getSyntymaJaKuolinAikaMetallikirjasin().setAlignmentX(Component.RIGHT_ALIGNMENT);
                    }

                    /* calculate new bounds for esikatseluhenkilopanel */
                    size = this.esikatseluHenkiloPanel[i].getPreferredSize();
                    posX = this.hautakivi.getHenkilo(i).getHenkiloX();
                    posY = this.hautakivi.getHenkilo(i).getHenkiloY();
                    if (size.width == 0 && size.height == 0) { // empty henkilo
                        this.esikatseluHenkiloPanel[i].setBounds(posX, posY, size.width, size.height);
                    }
                    else {
                        this.esikatseluHenkiloPanel[i].setBounds(posX, posY, size.width+5, size.height+5);
                    }
                    this.esikatseluHenkiloPanel[i].revalidate();
                }
            }
                
            /* setup koristeet */
            for (i=0; i<Hautakivi.KORISTEMAARA; i++) {
                /* check if koriste exists */
                if (this.hautakivi.getKoriste(i).getKoristeLeveys() == 0) {
                    esikatseluKoristeLabel[i].setIcon(null);
                    esikatseluKoristeLabel[i].setLabelTypeText("");
                    esikatseluKoristeLabel[i].setIndex(-1);
                    esikatseluKoristeLabel[i].setChosen(false);
                    esikatseluKoristeLabel[i].setBorder(BorderFactory.createEmptyBorder());
                    esikatseluMuotoPanel.setPosition(esikatseluKoristeLabel[i], i);
                    
                    /* calculate new bounds for koriste */
                    size = esikatseluKoristeLabel[i].getPreferredSize();
                    posX = this.hautakivi.getKoriste(i).getKoristeX();
                    posY = this.hautakivi.getKoriste(i).getKoristeY();
                    esikatseluKoristeLabel[i].setBounds(posX, posY, size.width, size.height);
                    esikatseluKoristeLabel[i].revalidate();
                }
                else {    
                    esikatseluKoristeLabel[i].setChosen(false);
                    esikatseluKoristeLabel[i].setBorder(BorderFactory.createEmptyBorder());
                    index = this.hautakivi.getKoriste(i).getKoristeIndex();
                    width = this.hautakivi.getKoriste(i).getKoristeLeveys();
                    height = this.hautakivi.getKoriste(i).getKoristeKorkeus();
                    labelType = this.hautakivi.getKoriste(i).getKoristeLabelType();
                    koristeKierto = this.hautakivi.getKoriste(i).getKoristeKierto();
                    
                    if ("enkelitTummaPatina".equals(labelType)) {
                        /* download images */
                        if (ImageArrays.enkelitTummaPatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Enkelit\\1_Tumma_patina\\";
                            ImageArrays.enkelitTummaPatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.enkelitTummaPatinaImages[index], width, height, 1.0);
                    }
                    else if ("enkelitKirkas".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.enkelitKirkasImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Enkelit\\2_Kirkas\\";
                            ImageArrays.enkelitKirkasImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.enkelitKirkasImages[index], width, height, 1.0);
                    }
                    else if ("enkelitTaidePatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.enkelitTaidePatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Enkelit\\3_Taidepatina\\";
                            ImageArrays.enkelitTaidePatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.enkelitTaidePatinaImages[index], width, height, 1.0);
                    }
                    else if ("enkelitKromaus".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.enkelitKromausImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Enkelit\\5_Kromaus\\";
                            ImageArrays.enkelitKromausImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.enkelitKromausImages[index], width, height, 1.0);
                    }
                    
                    else if ("holvikehyksetTummaPatina".equals(labelType)) {
                        /* download images */
                        if (ImageArrays.holvikehyksetTummaPatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Holvikehykset\\1_Tumma_patina\\";
                            ImageArrays.holvikehyksetTummaPatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.holvikehyksetTummaPatinaImages[index], width, height, 1.0);
                    }
                    else if ("holvikehyksetKirkas".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.holvikehyksetKirkasImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Holvikehykset\\2_Kirkas\\";
                            ImageArrays.holvikehyksetKirkasImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.holvikehyksetKirkasImages[index], width, height, 1.0);
                    }
                    else if ("holvikehyksetTaidePatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.holvikehyksetTaidePatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Holvikehykset\\3_Taidepatina\\";
                            ImageArrays.holvikehyksetTaidePatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.holvikehyksetTaidePatinaImages[index], width, height, 1.0);
                    }
                    else if ("holvikehyksetKromaus".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.holvikehyksetKromausImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Holvikehykset\\5_Kromaus\\";
                            ImageArrays.holvikehyksetKromausImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.holvikehyksetKromausImages[index], width, height, 1.0);
                    }
                    
                    else if ("kukatTummaPatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.kukatTummaPatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Kukat\\1_Tumma_patina\\";
                            ImageArrays.kukatTummaPatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.kukatTummaPatinaImages[index], width, height, 1.0);
                    }
                    else if ("kukatKirkas".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.kukatKirkasImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Kukat\\2_Kirkas\\";
                            ImageArrays.kukatKirkasImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.kukatKirkasImages[index], width, height, 1.0);
                    }
                    else if ("kukatTaidePatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.kukatTaidePatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Kukat\\3_Taidepatina\\";
                            ImageArrays.kukatTaidePatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.kukatTaidePatinaImages[index], width, height, 1.0);
                    }
                    else if ("kukatKromaus".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.kukatKromausImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Kukat\\5_Kromaus\\";
                            ImageArrays.kukatKromausImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.kukatKromausImages[index], width, height, 1.0);
                    }
                        
                    else if ("liekitJaLehvatTummaPatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.liekitJaLehvatTummaPatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Liekit_lehvat\\1_Tumma_patina\\";
                            ImageArrays.liekitJaLehvatTummaPatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.liekitJaLehvatTummaPatinaImages[index], width, height, 1.0);
                    }
                    else if ("liekitJaLehvatKirkas".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.liekitJaLehvatKirkasImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Liekit_lehvat\\2_Kirkas\\";
                            ImageArrays.liekitJaLehvatKirkasImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.liekitJaLehvatKirkasImages[index], width, height, 1.0);
                    }
                    else if ("liekitJaLehvatTaidePatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.liekitJaLehvatTaidePatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Liekit_lehvat\\3_Taidepatina\\";
                            ImageArrays.liekitJaLehvatTaidePatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.liekitJaLehvatTaidePatinaImages[index], width, height, 1.0);
                    }
                    else if ("liekitJaLehvatKromaus".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.liekitJaLehvatKromausImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Liekit_lehvat\\5_Kromaus\\";
                            ImageArrays.liekitJaLehvatKromausImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.liekitJaLehvatKromausImages[index], width, height, 1.0);
                    }
                            
                    else if ("linnutTummaPatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.linnutTummaPatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Linnut\\1_Tumma_patina\\";
                            ImageArrays.linnutTummaPatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.linnutTummaPatinaImages[index], width, height, 1.0);
                    }
                    else if ("linnutKirkas".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.linnutKirkasImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Linnut\\2_Kirkas\\";
                            ImageArrays.linnutKirkasImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.linnutKirkasImages[index], width, height, 1.0);
                    }
                    else if ("linnutTaidePatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.linnutTaidePatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Linnut\\3_Taidepatina\\";
                            ImageArrays.linnutTaidePatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.linnutTaidePatinaImages[index], width, height, 1.0);
                    }
                    else if ("linnutKromaus".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.linnutKromausImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Linnut\\5_Kromaus\\";
                            ImageArrays.linnutKromausImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.linnutKromausImages[index], width, height, 1.0);
                    }
                            
                    else if ("lyhtykehyksetTummaPatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.lyhtykehyksetTummaPatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Lyhtykehykset\\1_Tumma_patina\\";
                            ImageArrays.lyhtykehyksetTummaPatinaImages =  HautakiviohjelmaUI.loadDescriptionImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.lyhtykehyksetTummaPatinaImages[index], width, height, 1.0);
                    }
                    else if ("lyhtykehyksetKirkas".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.lyhtykehyksetKirkasImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Lyhtykehykset\\2_Kirkas\\";
                            ImageArrays.lyhtykehyksetKirkasImages =  HautakiviohjelmaUI.loadDescriptionImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.lyhtykehyksetKirkasImages[index], width, height, 1.0);
                    }
                    else if ("lyhtykehyksetTaidePatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.lyhtykehyksetTaidePatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Lyhtykehykset\\3_Taidepatina\\";
                            ImageArrays.lyhtykehyksetTaidePatinaImages =  HautakiviohjelmaUI.loadDescriptionImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.lyhtykehyksetTaidePatinaImages[index], width, height, 1.0);
                    }
                    else if ("lyhtykehyksetKromaus".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.lyhtykehyksetKromausImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Lyhtykehykset\\5_Kromaus\\";
                            ImageArrays.lyhtykehyksetKromausImages =  HautakiviohjelmaUI.loadDescriptionImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.lyhtykehyksetKromausImages[index], width, height, 1.0);
                    }
                            
                    else if ("lyhtykehyksetRistiTummaPatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.lyhtykehyksetRistiTummaPatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Lyhtykehykset_risti\\1_Tumma_patina\\";
                            ImageArrays.lyhtykehyksetRistiTummaPatinaImages =  HautakiviohjelmaUI.loadDescriptionImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.lyhtykehyksetRistiTummaPatinaImages[index], width, height, 1.0);
                    }
                    else if ("lyhtykehyksetRistiKirkas".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.lyhtykehyksetRistiKirkasImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Lyhtykehykset_risti\\2_Kirkas\\";
                            ImageArrays.lyhtykehyksetRistiKirkasImages =  HautakiviohjelmaUI.loadDescriptionImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.lyhtykehyksetRistiKirkasImages[index], width, height, 1.0);
                    }
                    else if ("lyhtykehyksetRistiTaidePatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.lyhtykehyksetRistiTaidePatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Lyhtykehykset_risti\\3_Taidepatina\\";
                            ImageArrays.lyhtykehyksetRistiTaidePatinaImages =  HautakiviohjelmaUI.loadDescriptionImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.lyhtykehyksetRistiTaidePatinaImages[index], width, height, 1.0);
                    }
                    else if ("lyhtykehyksetRistiKromaus".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.lyhtykehyksetRistiKromausImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Lyhtykehykset_risti\\5_Kromaus\\";
                            ImageArrays.lyhtykehyksetRistiKromausImages =  HautakiviohjelmaUI.loadDescriptionImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.lyhtykehyksetRistiKromausImages[index], width, height, 1.0);
                    }  
                            
                    else if ("muistolaatatMallit".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.muistolaatatMallitImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muistolaatat_mallit\\";
                            ImageArrays.muistolaatatMallitImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatMallitImages[index], width, height, 1.0);
                    }
                            
                    else if ("muistolaatatPohjatKohoval".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.muistolaatatPohjatKohovalImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muistolaatat_pohjat\\Kohoval_laattapohjat\\";
                            ImageArrays.muistolaatatPohjatKohovalImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatPohjatKohovalImages[index], width, height, 1.0);
                    }
                    else if ("muistolaatatPohjatLevylle".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.muistolaatatPohjatLevylleImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muistolaatat_pohjat\\Levylle_kaiv_laattapohjat\\";
                            ImageArrays.muistolaatatPohjatLevylleImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatPohjatLevylleImages[index], width, height, 1.0);
                    }
                    else if ("muistolaatatPohjatRst".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.muistolaatatPohjatRstImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muistolaatat_pohjat\\Rst_laatta\\";
                            ImageArrays.muistolaatatPohjatRstImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatPohjatRstImages[index], width, height, 1.0);
                    }
                    else if ("muistolaatatPohjatValetut".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.muistolaatatPohjatValetutImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muistolaatat_pohjat\\Valetut_laatat_kaiv_teksti\\";
                            ImageArrays.muistolaatatPohjatValetutImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muistolaatatPohjatValetutImages[index], width, height, 1.0);
                    }
                            
                    else if ("muutSymbolitTummaPatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.muutSymbolitTummaPatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muut_symbolit\\1_Tumma_patina\\";
                            ImageArrays.muutSymbolitTummaPatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muutSymbolitTummaPatinaImages[index], width, height, 1.0);
                    }
                    else if ("muutSymbolitKirkas".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.muutSymbolitKirkasImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muut_symbolit\\2_Kirkas\\";
                            ImageArrays.muutSymbolitKirkasImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muutSymbolitKirkasImages[index], width, height, 1.0);
                    }
                    else if ("muutSymbolitTaidePatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.muutSymbolitTaidePatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muut_symbolit\\3_Taidepatina\\";
                            ImageArrays.muutSymbolitTaidePatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muutSymbolitTaidePatinaImages[index], width, height, 1.0);
                    }
                    else if ("muutSymbolitKromaus".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.muutSymbolitKromausImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Muut_symbolit\\5_Kromaus\\";
                            ImageArrays.muutSymbolitKromausImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.muutSymbolitKromausImages[index], width, height, 1.0);
                    }
                            
                    else if ("ornamentit".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.ornamentitMustaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Ornamentit\\";
                            ImageArrays.ornamentitMustaImages =  HautakiviohjelmaUI.loadImages(path);
                            
                            /* load hopea and kulta images */
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Ornamentit\\hopea\\";
                            ImageArrays.ornamentitHopeaImages =  HautakiviohjelmaUI.loadImages(path);
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Ornamentit\\kulta\\";
                            ImageArrays.ornamentitKultaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        if (this.hautakivi.getHenkilo(0).getFontColor().equals(new Color(0, 0, 0))) {
                            iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ornamentitMustaImages[index], width, height, 1.0);
                        }
                        else if (this.hautakivi.getHenkilo(0).getFontColor().equals(new Color(192, 192, 192))) {
                            iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ornamentitHopeaImages[index], width, height, 1.0);
                        }
                        else {
                            iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ornamentitKultaImages[index], width, height, 1.0);   
                        }
                    }
                                
                    else if ("pronssilyhdyt".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.pronssilyhdytImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Pronssilyhdyt\\";
                            ImageArrays.pronssilyhdytImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.pronssilyhdytImages[index], width, height, 1.0);
                    }
                            
                    else if ("puutJaTahkatTummaPatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.puutJaTahkatTummaPatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Puut_tahkat\\1_Tumma_patina\\";
                            ImageArrays.puutJaTahkatTummaPatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.puutJaTahkatTummaPatinaImages[index], width, height, 1.0);
                    }
                    else if ("puutJaTahkatKirkas".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.puutJaTahkatKirkasImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Puut_tahkat\\2_Kirkas\\";
                            ImageArrays.puutJaTahkatKirkasImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.puutJaTahkatKirkasImages[index], width, height, 1.0);
                    }
                    else if ("puutJaTahkatTaidePatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.puutJaTahkatTaidePatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Puut_tahkat\\3_Taidepatina\\";
                            ImageArrays.puutJaTahkatTaidePatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.puutJaTahkatTaidePatinaImages[index], width, height, 1.0);
                    }
                    else if ("puutJaTahkatKromaus".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.puutJaTahkatKromausImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Puut_tahkat\\5_Kromaus\\";
                            ImageArrays.puutJaTahkatKromausImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.puutJaTahkatKromausImages[index], width, height, 1.0);
                    } 
                            
                    else if ("ristitTummaPatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.ristitTummaPatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Ristit\\1_Tumma_patina\\";
                            ImageArrays.ristitTummaPatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ristitTummaPatinaImages[index], width, height, 1.0);
                    }
                    else if ("ristitKirkas".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.ristitKirkasImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Ristit\\2_Kirkas\\";
                            ImageArrays.ristitKirkasImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ristitKirkasImages[index], width, height, 1.0);
                    }
                    else if ("ristitTaidePatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.ristitTaidePatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Ristit\\3_Taidepatina\\";
                            ImageArrays.ristitTaidePatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ristitTaidePatinaImages[index], width, height, 1.0);
                    }
                    else if ("ristitKromaus".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.ristitKromausImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Ristit\\5_Kromaus\\";
                            ImageArrays.ristitKromausImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.ristitKromausImages[index], width, height, 1.0);
                    } 
                            
                    else if ("veteraanitunnukset".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.veteraanitunnuksetImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Veteraanitunnukset\\";
                            ImageArrays.veteraanitunnuksetImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.veteraanitunnuksetImages[index], width, height, 1.0);
                    } 
                            
                    else if ("yhteenvaletutTekstitTummaPatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.yhteenvaletutTekstitTummaPatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Yhteenvaletut_tekstit\\1_Tumma_patina\\";
                            ImageArrays.yhteenvaletutTekstitTummaPatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.yhteenvaletutTekstitTummaPatinaImages[index], width, height, 1.0);
                    }
                    else if ("yhteenvaletutTekstitKirkas".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.yhteenvaletutTekstitKirkasImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Yhteenvaletut_tekstit\\2_Kirkas\\";
                            ImageArrays.yhteenvaletutTekstitKirkasImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.yhteenvaletutTekstitKirkasImages[index], width, height, 1.0);
                    }
                    else if ("yhteenvaletutTekstitTaidePatina".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.yhteenvaletutTekstitTaidePatinaImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Yhteenvaletut_tekstit\\3_Taidepatina\\";
                            ImageArrays.yhteenvaletutTekstitTaidePatinaImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.yhteenvaletutTekstitTaidePatinaImages[index], width, height, 1.0);
                    }
                    else if ("yhteenvaletutTekstitKromaus".equals(labelType)) {
                        /* download images if not downloaded yet */
                        if (ImageArrays.yhteenvaletutTekstitKromausImages == null) {
                            path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\kuvat\\koristeet\\Yhteenvaletut_tekstit\\5_Kromaus\\";
                            ImageArrays.yhteenvaletutTekstitKromausImages =  HautakiviohjelmaUI.loadImages(path);
                        }
                        iconImage = HautakiviohjelmaUI.scaleImage(ImageArrays.yhteenvaletutTekstitKromausImages[index], width, height, 1.0);
                    }
                    else { continue; }
                    
                    iconImage = HautakiviohjelmaUI.rotateImage(iconImage, StrictMath.toRadians((double)this.hautakivi.getKoriste(i).getKoristeKierto()));
                    this.esikatseluKoristeLabel[i].setIcon(new ImageIcon(iconImage));
                    this.esikatseluKoristeLabel[i].setLabelTypeText(labelType);
                    this.esikatseluKoristeLabel[i].setIndex(index);
                            
                    /* calculate new bounds for koriste */
                    size = esikatseluKoristeLabel[i].getPreferredSize();
                    posX = this.hautakivi.getKoriste(i).getKoristeX();
                    posY = this.hautakivi.getKoriste(i).getKoristeY();
                    esikatseluKoristeLabel[i].setBounds(posX, posY, size.width+5, size.height+5);
                    esikatseluKoristeLabel[i].revalidate();
                }
            }
            
            /* update yhteystiedot */
            this.yhteysNimiTxt.setText(this.hautakivi.getYhteysNimi());
            this.yhteysPuhelinTxt.setText(this.hautakivi.getYhteysPuhelin());
            this.yhteysEmailTxt.setText(this.hautakivi.getYhteysEmail());
            
            JOptionPane.showMessageDialog(null, "Tiedoston avaaminen onnistui", "Tiedoston avaaminen onnistui", JOptionPane.INFORMATION_MESSAGE);
                
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Tiedoston avaaminen epäonnistui", JOptionPane.ERROR_MESSAGE);
                ex.printStackTrace();
            }            
        }
    }
    
    /* helper function */
    private static void loadMetalliFonts(String metallikirjasinTyyppi, String metallikirjasinAlaTyyppi) {
        String path;
        
        switch (metallikirjasinTyyppi) {
            case "Antikva":
                if ("Kromaus".equals(metallikirjasinAlaTyyppi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.antikvaKromausFlag) {       
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\3_Antikva\\5_Kromaus\\";
                        ImageArrays.antikvaKromausImages = HautakiviohjelmaUI.loadFontImages(path); 
                        ImageArrays.antikvaKromausFlag = true;
                    }
                    break;
                }
                else if ("Taidepatina".equals(metallikirjasinAlaTyyppi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.antikvaTaidePatinaFlag) {       
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\3_Antikva\\3_Taidepatina\\";
                        ImageArrays.antikvaTaidePatinaImages = HautakiviohjelmaUI.loadFontImages(path); 
                        ImageArrays.antikvaTaidePatinaFlag = true;
                    }
                    break;
                }
                else if ("Tumma patina".equals(metallikirjasinAlaTyyppi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.antikvaTummaPatinaFlag) {       
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\3_Antikva\\1_Tumma_patina\\";
                        ImageArrays.antikvaTummaPatinaImages = HautakiviohjelmaUI.loadFontImages(path); 
                        ImageArrays.antikvaTummaPatinaFlag = true;
                    }
                    break;
                }
            
            case "Groteski":
                if ("Kirkas".equals(metallikirjasinAlaTyyppi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.groteskiKirkasFlag) {       
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\1_Groteski\\2_Kirkas\\";
                        ImageArrays.groteskiKirkasImages = HautakiviohjelmaUI.loadFontImages(path); 
                        ImageArrays.groteskiKirkasFlag = true;
                    }
                    break;
                }
                else if ("Kromaus".equals(metallikirjasinAlaTyyppi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.groteskiKromausFlag) {       
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\1_Groteski\\5_Kromaus\\";
                        ImageArrays.groteskiKromausImages = HautakiviohjelmaUI.loadFontImages(path); 
                        ImageArrays.groteskiKromausFlag = true;
                    }
                    break;
                }
                else if ("Taidepatina".equals(metallikirjasinAlaTyyppi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.groteskiTaidePatinaFlag) {       
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\1_Groteski\\3_Taidepatina\\";
                        ImageArrays.groteskiTaidePatinaImages = HautakiviohjelmaUI.loadFontImages(path); 
                        ImageArrays.groteskiTaidePatinaFlag = true;
                    }
                    break;
                }
                else if ("Tumma patina".equals(metallikirjasinAlaTyyppi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.groteskiTummaPatinaFlag) {       
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\1_Groteski\\1_Tumma_patina\\";
                        ImageArrays.groteskiTummaPatinaImages = HautakiviohjelmaUI.loadFontImages(path); 
                        ImageArrays.groteskiTummaPatinaFlag = true;
                    }
                    break;
                }
                
            case "Kapea Antikva":
                if ("Kirkas".equals(metallikirjasinAlaTyyppi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.kapeaAntikvaKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\6_KapeaAntikva\\2_Kirkas\\";
                        ImageArrays.kapeaAntikvaKirkasImages = HautakiviohjelmaUI.loadFontImages(path); 
                        ImageArrays.kapeaAntikvaKirkasFlag = true;
                    }
                    break;  
                }
                else if ("Kromaus".equals(metallikirjasinAlaTyyppi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.kapeaAntikvaKromausFlag) {       
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\6_KapeaAntikva\\5_Kromaus\\";
                        ImageArrays.kapeaAntikvaKromausImages = HautakiviohjelmaUI.loadFontImages(path); 
                        ImageArrays.kapeaAntikvaKromausFlag = true;
                    }
                    break;
                }
                else if ("Taidepatina".equals(metallikirjasinAlaTyyppi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.kapeaAntikvaTaidePatinaFlag) {       
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\6_KapeaAntikva\\3_Taidepatina\\";
                        ImageArrays.kapeaAntikvaTaidePatinaImages = HautakiviohjelmaUI.loadFontImages(path); 
                        ImageArrays.kapeaAntikvaTaidePatinaFlag = true;
                    }
                    break;
                }
                else if ("Tumma patina".equals(metallikirjasinAlaTyyppi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.kapeaAntikvaTummaPatinaFlag) {       
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\6_KapeaAntikva\\1_Tumma_patina\\";
                        ImageArrays.kapeaAntikvaTummaPatinaImages = HautakiviohjelmaUI.loadFontImages(path); 
                        ImageArrays.kapeaAntikvaTummaPatinaFlag = true;
                    }
                    break;
                }
                
            case "Leveä Antikva":
                if ("Kirkas".equals(metallikirjasinAlaTyyppi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.leveaAntikvaKirkasFlag) {
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\4_LeveaAntikva\\2_Kirkas\\";
                        ImageArrays.leveaAntikvaKirkasImages = HautakiviohjelmaUI.loadFontImages(path); 
                        ImageArrays.leveaAntikvaKirkasFlag = true;
                    }
                    break;  
                }
                else if ("Kromaus".equals(metallikirjasinAlaTyyppi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.leveaAntikvaKromausFlag) {       
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\4_LeveaAntikva\\5_Kromaus\\";
                        ImageArrays.leveaAntikvaKromausImages = HautakiviohjelmaUI.loadFontImages(path); 
                        ImageArrays.leveaAntikvaKromausFlag = true;
                    }
                    break;
                }
                else if ("Taidepatina".equals(metallikirjasinAlaTyyppi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.leveaAntikvaTaidePatinaFlag) {       
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\4_LeveaAntikva\\3_Taidepatina\\";
                        ImageArrays.leveaAntikvaTaidePatinaImages = HautakiviohjelmaUI.loadFontImages(path); 
                        ImageArrays.leveaAntikvaTaidePatinaFlag = true;
                    }
                    break;
                }
                else if ("Tumma patina".equals(metallikirjasinAlaTyyppi)) {
                    /*download images if not yet downloaded */
                    if (!ImageArrays.leveaAntikvaTummaPatinaFlag) {       
                        path = System.getProperty("user.home") + "\\Documents\\Hautakiviohjelma\\fontit\\4_LeveaAntikva\\1_Tumma_patina\\";
                        ImageArrays.leveaAntikvaTummaPatinaImages = HautakiviohjelmaUI.loadFontImages(path); 
                        ImageArrays.leveaAntikvaTummaPatinaFlag = true;
                    }
                    break;
                }
                    
            default: break;
        }
    }
}