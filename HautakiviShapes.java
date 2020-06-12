/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;


import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.TexturePaint;
import java.awt.geom.AffineTransform;
import java.awt.geom.Area;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.awt.image.RescaleOp;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.imageio.ImageIO;

/**
 *
 * @author Juha-Pekka
 */
public class HautakiviShapes {
    private static final int TOPPADDING = 0;
    private static final int THREED = 20;
    
    public static BufferedImage createHautakiviShape(int variIndex, int kivenLeveys, int kivenKorkeus, 
            String description, boolean sahattu, boolean hiottu, boolean louhittu) {
        
        int muotoWidth = Hautakivi.SCALINGFACTORY*kivenLeveys;
        int muotoHeight = Hautakivi.SCALINGFACTORY*kivenKorkeus;
        int jalustaWidth;
        int jalustaLeftPadding;
        int jalustaHeight = 70;
        int rosoPintaX = 0;
        int rosoPintaY = 0;
        int offset = 0;
        int leftPadding = 0;
        int rightPadding = 0;
        int bottomPadding = 0;
        int sideImageLeftPadding = 0;
        int sideImageTopPadding = 0;
        
        String imageName = "";
        
        BufferedImage fillImage = ImageArrays.kivenVariImages[variIndex];
       
        BufferedImage frontImage = null;
        BufferedImage sideImage = null;
        BufferedImage jalustaImage = null;
        BufferedImage sideSahattuImage = null;
        BufferedImage sideHiottuImage = null;
        
        Area frontArea = new Area();
        Area sideArea = new Area();
        Rectangle2D frontRectangle;
        Rectangle2D sideRectangle;
        Rectangle subArea;
        TexturePaint tp;
        Map<RenderingHints.Key, Object> hints = new HashMap<>();
        AffineTransform at;
        Graphics2D hiottuReuna;
        RescaleOp rOp;
        
        if (variIndex != 0 && hiottu) {
            rOp = new RescaleOp(1.4f, 0, null);
        }
        else if (variIndex == 0 && hiottu) {
            rOp = new RescaleOp(1.1f, 0, null);
        }
        else if (variIndex != 0) {
            rOp = new RescaleOp(2f, 0, null);
        }
        else {
            rOp = new RescaleOp(1.3f, 0, null);
        }
        
        hints.put(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
        hints.put(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        
        try {
            jalustaImage = ImageIO.read(new File(System.getProperty("user.home") +
                        "/Documents/Hautakiviohjelma/kuvat/muodot/isot/jalusta.png"));
        } catch (IOException ex) {
            System.out.println("Opening image failed: " + ex.getMessage());
        }
        
        if (description.endsWith("suorakulmio.png")) {
            try {
                frontImage = ImageIO.read(new File(System.getProperty("user.home") +
                        "/Documents/Hautakiviohjelma/kuvat/muodot/isot/suorakulmio.png"));
                if (sahattu) {
                    sideImage = ImageIO.read(new File(System.getProperty("user.home") +
                        "/Documents/Hautakiviohjelma/kuvat/muodot/isot/reunat/suorakulmio_sahattu.png"));
                }
                else if (hiottu) {
                    sideImage = ImageIO.read(new File(System.getProperty("user.home") +
                        "/Documents/Hautakiviohjelma/kuvat/muodot/isot/reunat/suorakulmio_sahattu.png"));
                    sideArea = drawArea(sideImage);
                    
                    sideHiottuImage = rOp.filter(ImageArrays.kivenVariImages[variIndex], null);
                    sideRectangle = new Rectangle2D.Double(0, 0, muotoWidth, muotoHeight);
                    tp = new TexturePaint(sideHiottuImage, sideRectangle);
           
                    hiottuReuna = sideImage.createGraphics();
                    hiottuReuna.setRenderingHints(hints);
                    hiottuReuna.setPaint(tp);
                    hiottuReuna.fill(sideArea);
                    
                    hiottuReuna.dispose();
                }
                else { // louhittu
                    sideImage = ImageIO.read(new File(System.getProperty("user.home") +
                        "/Documents/Hautakiviohjelma/kuvat/muodot/isot/reunat/suorakulmio_sahattu.png"));
                    sideArea = drawArea(sideImage);
                    
                    sideHiottuImage = rOp.filter(ImageArrays.kivenVariImages[variIndex], null);
                    sideRectangle = new Rectangle2D.Double(0, 0, muotoWidth, muotoHeight);
                    tp = new TexturePaint(sideHiottuImage, sideRectangle);
           
                    hiottuReuna = sideImage.createGraphics();
                    hiottuReuna.setRenderingHints(hints);
                    hiottuReuna.setPaint(tp);
                    hiottuReuna.fill(sideArea);
                    
                    hiottuReuna.dispose();
                }
            } catch (IOException ex) {
                System.out.println("Opening image failed: " + ex.getMessage());
            }
            imageName = "suorakulmio.png";
        }
        else if (description.endsWith("kaareva1.png")) {
            try {
                frontImage = ImageIO.read(new File(System.getProperty("user.home") +
                        "/Documents/Hautakiviohjelma/kuvat/muodot/isot/kaareva1.png"));
                if (sahattu) {
                    sideImage = ImageIO.read(new File(System.getProperty("user.home") +
                        "/Documents/Hautakiviohjelma/kuvat/muodot/isot/reunat/kaareva1_sahattu.png"));
                }
                else if (hiottu) {
                    sideImage = ImageIO.read(new File(System.getProperty("user.home") +
                        "/Documents/Hautakiviohjelma/kuvat/muodot/isot/reunat/kaareva1_sahattu.png"));
                    sideArea = drawArea(sideImage);
                  
                    sideHiottuImage = rOp.filter(ImageArrays.kivenVariImages[variIndex], null);
                    sideRectangle = new Rectangle2D.Double(0, 0, muotoWidth, muotoHeight);
                    tp = new TexturePaint(sideHiottuImage, sideRectangle);
           
                    hiottuReuna = sideImage.createGraphics();
                    hiottuReuna.setRenderingHints(hints);
                    hiottuReuna.setPaint(tp);
                    hiottuReuna.fill(sideArea);
                    
                    hiottuReuna.dispose();
                }
                else { // louhittu
                    sideImage = ImageIO.read(new File(System.getProperty("user.home") +
                        "/Documents/Hautakiviohjelma/kuvat/muodot/isot/reunat/kaareva1_sahattu.png"));
                    sideArea = drawArea(sideImage);
                  
                    sideHiottuImage = rOp.filter(ImageArrays.kivenVariImages[variIndex], null);
                    sideRectangle = new Rectangle2D.Double(0, 0, muotoWidth, muotoHeight);
                    tp = new TexturePaint(sideHiottuImage, sideRectangle);
           
                    hiottuReuna = sideImage.createGraphics();
                    hiottuReuna.setRenderingHints(hints);
                    hiottuReuna.setPaint(tp);
                    hiottuReuna.fill(sideArea);
                    
                    hiottuReuna.dispose();
                }
            } catch (IOException ex) {
                System.out.println("Opening image failed: " + ex.getMessage());
            }
            imageName = "kaareva1.png";
        }
        else if (description.endsWith("kaareva2.png")) {
            try {
                frontImage = ImageIO.read(new File(System.getProperty("user.home") +
                        "/Documents/Hautakiviohjelma/kuvat/muodot/isot/kaareva2.png"));
                if (sahattu) {
                    sideImage = ImageIO.read(new File(System.getProperty("user.home") +
                        "/Documents/Hautakiviohjelma/kuvat/muodot/isot/reunat/kaareva2_sahattu.png"));
                }
                else if (hiottu) {
                    sideImage = ImageIO.read(new File(System.getProperty("user.home") +
                        "/Documents/Hautakiviohjelma/kuvat/muodot/isot/reunat/kaareva2_sahattu.png"));
                    sideArea = drawArea(sideImage);

                    sideHiottuImage = rOp.filter(ImageArrays.kivenVariImages[variIndex], null);
                    sideRectangle = new Rectangle2D.Double(0, 0, muotoWidth, muotoHeight);
                    tp = new TexturePaint(sideHiottuImage, sideRectangle);
           
                    hiottuReuna = sideImage.createGraphics();
                    hiottuReuna.setRenderingHints(hints);
                    hiottuReuna.setPaint(tp);
                    hiottuReuna.fill(sideArea);
                    
                    hiottuReuna.dispose();
                }
                else { // louhittu
                    sideImage = ImageIO.read(new File(System.getProperty("user.home") +
                        "/Documents/Hautakiviohjelma/kuvat/muodot/isot/reunat/kaareva2_sahattu.png"));
                    sideArea = drawArea(sideImage);

                    sideHiottuImage = rOp.filter(ImageArrays.kivenVariImages[variIndex], null);
                    sideRectangle = new Rectangle2D.Double(0, 0, muotoWidth, muotoHeight);
                    tp = new TexturePaint(sideHiottuImage, sideRectangle);
           
                    hiottuReuna = sideImage.createGraphics();
                    hiottuReuna.setRenderingHints(hints);
                    hiottuReuna.setPaint(tp);
                    hiottuReuna.fill(sideArea);
                    
                    hiottuReuna.dispose();
                }
            } catch (IOException ex) {
                System.out.println("Opening image failed: " + ex.getMessage());
            }
            imageName = "kaareva2.png";
        }
        else if (description.endsWith("kaareva3.png")) {
            try {
                frontImage = ImageIO.read(new File(System.getProperty("user.home") +
                        "/Documents/Hautakiviohjelma/kuvat/muodot/isot/kaareva3.png"));
                if (sahattu) {
                    sideImage = ImageIO.read(new File(System.getProperty("user.home") +
                        "/Documents/Hautakiviohjelma/kuvat/muodot/isot/reunat/kaareva3_sahattu.png"));
                }
                else if (hiottu) {
                    sideImage = ImageIO.read(new File(System.getProperty("user.home") +
                        "/Documents/Hautakiviohjelma/kuvat/muodot/isot/reunat/kaareva3_sahattu.png"));
                    sideArea = drawArea(sideImage);

                    sideHiottuImage = rOp.filter(ImageArrays.kivenVariImages[variIndex], null);
                    sideRectangle = new Rectangle2D.Double(0, 0, muotoWidth, muotoHeight);
                    tp = new TexturePaint(sideHiottuImage, sideRectangle);
           
                    hiottuReuna = sideImage.createGraphics();
                    hiottuReuna.setRenderingHints(hints);
                    hiottuReuna.setPaint(tp);
                    hiottuReuna.fill(sideArea);
                    
                    hiottuReuna.dispose();
                }
                else {
                    sideImage = ImageIO.read(new File(System.getProperty("user.home") +
                        "/Documents/Hautakiviohjelma/kuvat/muodot/isot/reunat/kaareva3_sahattu.png"));
                    sideArea = drawArea(sideImage);

                    sideHiottuImage = rOp.filter(ImageArrays.kivenVariImages[variIndex], null);
                    sideRectangle = new Rectangle2D.Double(0, 0, muotoWidth, muotoHeight);
                    tp = new TexturePaint(sideHiottuImage, sideRectangle);
           
                    hiottuReuna = sideImage.createGraphics();
                    hiottuReuna.setRenderingHints(hints);
                    hiottuReuna.setPaint(tp);
                    hiottuReuna.fill(sideArea);
                    
                    hiottuReuna.dispose();
                }
            } catch (IOException ex) {
                System.out.println("Opening image failed: " + ex.getMessage());
            }
            imageName = "kaareva3.png";
        }
        
        else {
            for (int i=1; i<61; i++) {
                if (i<10) {
                    imageName = "Hauta0" + Integer.toString(i) + ".png";
                }
                else {
                    imageName = "Hauta" + Integer.toString(i) + ".png";
                }
                
                if (description.endsWith(imageName)) {
                    try {
                        frontImage = ImageIO.read(new File(System.getProperty("user.home") +
                                "/Documents/Hautakiviohjelma/kuvat/muodot/isot/" + imageName));
                        sideImage = ImageIO.read(new File(System.getProperty("user.home") +
                                "/Documents/Hautakiviohjelma/kuvat/muodot/isot/reunat/" + imageName));
                    } catch (IOException ex) {
                        System.out.println("Opening image failed: " + ex.getMessage());
                    }
                    if (sahattu) {
                        try {
                                sideSahattuImage = ImageIO.read(new File(System.getProperty("user.home") +
                                    "/Documents/Hautakiviohjelma/kuvat/jalusta1.png"));
                        } catch (IOException ex) {
                            System.out.println("Opening image failed: " + ex.getMessage());
                        }
                        sideArea = drawArea(sideImage);
                        sideRectangle = new Rectangle2D.Double(0, 0, 80, 80);
                        tp = new TexturePaint(sideSahattuImage, sideRectangle);
                            
                        hiottuReuna = sideImage.createGraphics();
                        hiottuReuna.setRenderingHints(hints);
                        hiottuReuna.setPaint(tp);
                        hiottuReuna.fill(sideArea);
                    
                        hiottuReuna.dispose();
                    }
                    else if (hiottu) {
                        sideArea = drawArea(sideImage);

                        sideHiottuImage = rOp.filter(ImageArrays.kivenVariImages[variIndex], null);
                        sideRectangle = new Rectangle2D.Double(0, 0, muotoWidth, muotoHeight);
                        tp = new TexturePaint(sideHiottuImage, sideRectangle);
           
                        hiottuReuna = sideImage.createGraphics();
                        hiottuReuna.setRenderingHints(hints);
                        hiottuReuna.setPaint(tp);
                        hiottuReuna.fill(sideArea);
                    
                            hiottuReuna.dispose();
                    }
                    else {
                        sideArea = drawArea(sideImage);
                        sideHiottuImage = rOp.filter(ImageArrays.kivenVariImages[variIndex], null);
                        sideRectangle = new Rectangle2D.Double(0, 0, muotoWidth, muotoHeight);
                        tp = new TexturePaint(sideHiottuImage, sideRectangle);
           
                        hiottuReuna = sideImage.createGraphics();
                        hiottuReuna.setRenderingHints(hints);
                        hiottuReuna.setPaint(tp);
                        hiottuReuna.fill(sideArea);
                    
                        hiottuReuna.dispose();
                    }
                    break;
                }
            }
        }
        frontArea = drawArea(frontImage);
        
        if (imageName.equals("Hauta01.png")) {
            leftPadding = (int)(14*kivenLeveys/140.0);
            rightPadding = (int)(27*kivenLeveys/140.0);
            bottomPadding = (int)(3*kivenKorkeus/80.0);
            offset = (int)(3*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta02.png")) {
            leftPadding = (int)(17*kivenLeveys/140.0);
            rightPadding = (int)(30*kivenLeveys/140.0);
            bottomPadding = (int)(-9*kivenKorkeus/80.0);
            offset = (int)(-9*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta03.png")) {
            leftPadding = (int)(15*kivenLeveys/140.0);
            rightPadding = (int)(17*kivenLeveys/140.0);
            bottomPadding = (int)(-4*kivenKorkeus/80.0);
            offset = (int)(-4*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta04.png")) {
            leftPadding = (int)(15*kivenLeveys/140.0);
            rightPadding = (int)(17*kivenLeveys/140.0);
            bottomPadding = (int)(-6*kivenKorkeus/80.0);
            offset = (int)(-6*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta05.png")) {
            leftPadding = (int)(17*kivenLeveys/140.0);
            rightPadding = (int)(34*kivenLeveys/140.0);
            bottomPadding = (int)(-5*kivenKorkeus/80.0);
            offset = (int)(-5*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta06.png")) {
            leftPadding = (int)(8*kivenLeveys/140.0);
            rightPadding = (int)(10*kivenLeveys/140.0);
            bottomPadding = (int)(2*kivenKorkeus/80.0);
            offset = (int)(2*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta07.png")) {
            leftPadding = (int)(16*kivenLeveys/140.0);
            rightPadding = (int)(30*kivenLeveys/140.0);
            bottomPadding = 0;
            offset = 0;
        }
        else if (imageName.equals("Hauta08.png")) {
            leftPadding = (int)(18*kivenLeveys/140.0);
            rightPadding = (int)(1*kivenLeveys/140.0);
            bottomPadding = (int)(-12*kivenKorkeus/80.0);
            offset = (int)(-12*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta09.png")) {
            leftPadding = (int)(14*kivenLeveys/140.0);
            rightPadding = (int)(31*kivenLeveys/140.0);
            bottomPadding = (int)(-9*kivenKorkeus/80.0);
            offset = (int)(-9*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta10.png")) {
            leftPadding = (int)(20*kivenLeveys/140.0);
            rightPadding = (int)(35*kivenLeveys/140.0);
            bottomPadding = (int)(-6*kivenKorkeus/80.0);
            offset = (int)(-6*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta11.png")) {
            leftPadding = (int)(12*kivenLeveys/140.0);
            rightPadding = (int)(24*kivenLeveys/140.0);
            bottomPadding = (int)(2*kivenKorkeus/80.0);
            offset = (int)(2*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta12.png")) {
            leftPadding = 0;
            rightPadding = (int)(30*kivenLeveys/140.0);
            bottomPadding = (int)(-15*kivenKorkeus/80.0);
            offset = (int)(-15*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta13.png")) {
            leftPadding = (int)(18*kivenLeveys/140.0);
            rightPadding = (int)(44*kivenLeveys/140.0);
            bottomPadding = (int)(1*kivenKorkeus/80.0);
            offset = (int)(1*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta14.png")) {
            leftPadding = (int)(9*kivenLeveys/140.0);
            rightPadding = (int)(21*kivenLeveys/140.0);
            bottomPadding = (int)(-7*kivenKorkeus/80.0);
            offset = (int)(-7*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta15.png")) {
            leftPadding = (int)(20*kivenLeveys/140.0);
            rightPadding = (int)(60*kivenLeveys/140.0);
            bottomPadding = (int)(-7*kivenKorkeus/80.0);
            offset = (int)(-7*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta16.png")) {
            leftPadding = (int)(16*kivenLeveys/140.0);
            rightPadding = (int)(42*kivenLeveys/140.0);
            bottomPadding = (int)(-6*kivenKorkeus/80.0);
            offset = (int)(-6*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta17.png")) {
            leftPadding = (int)(31*kivenLeveys/140.0);
            rightPadding = (int)(17*kivenLeveys/140.0);
            bottomPadding = (int)(-13*kivenKorkeus/80.0);
            offset = (int)(-13*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta18.png")) {
            leftPadding = (int)(10*kivenLeveys/140.0);
            rightPadding = (int)(27*kivenLeveys/140.0);
            bottomPadding = (int)(-9*kivenKorkeus/80.0);
            offset = (int)(-9*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta19.png")) {
            leftPadding = (int)(28*kivenLeveys/140.0);
            rightPadding = (int)(67*kivenLeveys/140.0);
            bottomPadding = (int)(-7*kivenKorkeus/80.0);
            offset = (int)(-7*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta20.png")) {
            leftPadding = (int)(16*kivenLeveys/140.0);
            rightPadding = (int)(56*kivenLeveys/140.0);
            bottomPadding = (int)(-9*kivenKorkeus/80.0);
            offset = (int)(-9*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta21.png")) {
            leftPadding = (int)(10*kivenLeveys/140.0);
            rightPadding = (int)(30*kivenLeveys/140.0);
            bottomPadding = (int)(4*kivenKorkeus/80.0);
            offset = (int)(4*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta22.png")) {
            leftPadding = (int)(7*kivenLeveys/140.0);
            rightPadding = (int)(28*kivenLeveys/140.0);
            bottomPadding = (int)(4*kivenKorkeus/80.0);
            offset = (int)(4*kivenKorkeus/80.0);
        } 
        else if (imageName.equals("Hauta23.png")) {
            leftPadding = 0;
            rightPadding = (int)(37*kivenLeveys/140.0);
            bottomPadding = (int)(-4*kivenKorkeus/80.0);
            offset = (int)(-4*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta24.png")) {
            leftPadding = 0;
            rightPadding = (int)(13*kivenLeveys/140.0);
            bottomPadding = (int)(-6*kivenKorkeus/80.0);
            offset = (int)(-6*kivenKorkeus/80.0);
        }  
        else if (imageName.equals("Hauta25.png")) {
            leftPadding = (int)(2*kivenLeveys/140.0);
            rightPadding = (int)(19*kivenLeveys/140.0);
            bottomPadding = (int)(-4*kivenKorkeus/80.0);
            offset = (int)(-4*kivenKorkeus/80.0);
        }  
        else if (imageName.equals("Hauta26.png")) {
            leftPadding = 0;
            rightPadding = (int)(20*kivenLeveys/140.0);
            bottomPadding = (int)(1*kivenKorkeus/80.0);
            offset = (int)(1*kivenKorkeus/80.0);
        }  
        else if (imageName.equals("Hauta27.png")) {
            leftPadding = 0;
            rightPadding = (int)(40*kivenLeveys/140.0);
            bottomPadding = (int)(-4*kivenKorkeus/80.0);
            offset = (int)(-4*kivenKorkeus/80.0);
        }  
        else if (imageName.equals("Hauta28.png")) {
            leftPadding = 0;
            rightPadding = (int)(18*kivenLeveys/140.0);
            bottomPadding = (int)(-3*kivenKorkeus/80.0);
            offset = (int)(-3*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta29.png")) {
            leftPadding = 0;
            rightPadding = (int)(33*kivenLeveys/140.0);
            bottomPadding = (int)(-10*kivenKorkeus/80.0);
            offset = (int)(-10*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta30.png")) {
            leftPadding = 0;
            rightPadding = (int)(43*kivenLeveys/140.0);
            bottomPadding = (int)(-10*kivenKorkeus/80.0);
            offset = (int)(-10*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta31.png")) {
            leftPadding = (int)(2*kivenLeveys/140.0);
            rightPadding = (int)(27*kivenLeveys/140.0);
            bottomPadding = (int)(-12*kivenKorkeus/80.0);
            offset = (int)(-12*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta32.png")) {
            leftPadding = 0;
            rightPadding = (int)(47*kivenLeveys/140.0);
            bottomPadding = (int)(-7*kivenKorkeus/80.0);
            offset = (int)(-7*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta33.png")) {
            leftPadding = 0;
            rightPadding = (int)(38*kivenLeveys/140.0);
            bottomPadding = (int)(-11*kivenKorkeus/80.0);
            offset = (int)(-11*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta34.png")) {
            leftPadding = 0;
            rightPadding = (int)(22*kivenLeveys/140.0);
            bottomPadding = (int)(-8*kivenKorkeus/80.0);
            offset = (int)(-8*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta35.png")) {
            leftPadding = 0;
            rightPadding = (int)(36*kivenLeveys/140.0);
            bottomPadding = (int)(-10*kivenKorkeus/80.0);
            offset = (int)(-10*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta36.png")) {
            leftPadding = 0;
            rightPadding = (int)(5*kivenLeveys/140.0);
            bottomPadding = (int)(-6*kivenKorkeus/80.0);
            offset = (int)(-6*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta37.png")) {
            leftPadding = 0;
            rightPadding = (int)(51*kivenLeveys/140.0);
            bottomPadding = (int)(-13*kivenKorkeus/80.0);
            offset = (int)(-13*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta38.png")) {
            leftPadding = 0;
            rightPadding = (int)(15*kivenLeveys/140.0);
            bottomPadding = (int)(-10*kivenKorkeus/80.0);
            offset = (int)(-10*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta39.png")) {
            leftPadding = 0;
            rightPadding = (int)(27*kivenLeveys/140.0);
            bottomPadding = (int)(-12*kivenKorkeus/80.0);
            offset = (int)(-12*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta40.png")) {
            leftPadding = 0;
            rightPadding = (int)(26*kivenLeveys/140.0);
            bottomPadding = (int)(-10*kivenKorkeus/80.0);
            offset = (int)(-10*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta41.png")) {
            leftPadding = 0;
            rightPadding = (int)(39*kivenLeveys/140.0);
            bottomPadding = (int)(-11*kivenKorkeus/80.0);
            offset = (int)(-11*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta42.png")) {
            leftPadding = 0;
            rightPadding = (int)(36*kivenLeveys/140.0);
            bottomPadding = (int)(-11*kivenKorkeus/80.0);
            offset = (int)(-11*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta43.png")) {
            leftPadding = 0;
            rightPadding = (int)(34*kivenLeveys/140.0);
            bottomPadding = (int)(-16*kivenKorkeus/80.0);
            offset = (int)(-16*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta44.png")) {
            leftPadding = 0;
            rightPadding = (int)(56*kivenLeveys/140.0);
            bottomPadding = (int)(-16*kivenKorkeus/80.0);
            offset = (int)(-16*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta45.png")) {
            leftPadding = (int)(-20*kivenLeveys/140.0);
            rightPadding = (int)(48*kivenLeveys/140.0);
            bottomPadding = (int)(-16*kivenKorkeus/80.0);
            offset = (int)(-16*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta46.png")) {
            leftPadding = 0;
            rightPadding = (int)(45*kivenLeveys/140.0);
            bottomPadding = (int)(-14*kivenKorkeus/80.0);
            offset = (int)(-14*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta47.png")) {
            leftPadding = 0;
            rightPadding = (int)(18*kivenLeveys/140.0);
            bottomPadding = (int)(-2*kivenKorkeus/80.0);
            offset = (int)(-2*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta48.png")) {
            leftPadding = 0;
            rightPadding = (int)(32*kivenLeveys/140.0);
            bottomPadding = (int)(-8*kivenKorkeus/80.0);
            offset = (int)(-8*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta49.png")) {
            leftPadding = 0;
            rightPadding = (int)(37*kivenLeveys/140.0);
            bottomPadding = (int)(-5*kivenKorkeus/80.0);
            offset = (int)(-5*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta50.png")) {
            leftPadding = 0;
            rightPadding = (int)(35*kivenLeveys/140.0);
            bottomPadding = 0;
            offset = 0;
        }
        else if (imageName.equals("Hauta51.png")) {
            leftPadding = 0;
            rightPadding = (int)(8*kivenLeveys/140.0);
            bottomPadding = (int)(-7*kivenKorkeus/80.0);
            offset = (int)(-7*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta52.png")) {
            leftPadding = 0;
            rightPadding = (int)(34*kivenLeveys/140.0);
            bottomPadding = (int)(-8*kivenKorkeus/80.0);
            offset = (int)(-8*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta53.png")) {
            leftPadding = 0;
            rightPadding = (int)(13*kivenLeveys/140.0);
            bottomPadding = (int)(-8*kivenKorkeus/80.0);
            offset = (int)(-8*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta54.png")) {
            leftPadding = 0;
            rightPadding = (int)(17*kivenLeveys/140.0);
            bottomPadding = (int)(-8*kivenKorkeus/80.0);
            offset = (int)(-8*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta55.png")) {
            leftPadding = 0;
            rightPadding = (int)(11*kivenLeveys/140.0);
            bottomPadding = (int)(1*kivenKorkeus/80.0);
            offset = (int)(1*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta56.png")) {
            leftPadding = 0;
            rightPadding = (int)(20*kivenLeveys/140.0);
            bottomPadding = (int)(-7*kivenKorkeus/80.0);
            offset = (int)(-7*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta57.png")) {
            leftPadding = 0;
            rightPadding = (int)(14*kivenLeveys/140.0);
            bottomPadding = (int)(-8*kivenKorkeus/80.0);
            offset = (int)(-8*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta58.png")) {
            leftPadding = 0;
            rightPadding = (int)(18*kivenLeveys/140.0);
            bottomPadding = (int)(-10*kivenKorkeus/80.0);
            offset = (int)(-10*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta59.png")) {
            leftPadding = 0;
            rightPadding = (int)(27*kivenLeveys/140.0);
            bottomPadding = (int)(-16*kivenKorkeus/80.0);
            offset = (int)(-16*kivenKorkeus/80.0);
        }
        else if (imageName.equals("Hauta60.png")) {
            leftPadding = 0;
            rightPadding = (int)(35*kivenLeveys/140.0);
            bottomPadding = (int)(-10*kivenKorkeus/80.0);
            offset = (int)(-10*kivenKorkeus/80.0);
        }
        
        jalustaWidth = muotoWidth + (int)(kivenLeveys/140.0*THREED) + leftPadding +
                sideImageLeftPadding +rightPadding + +rosoPintaX + 60;
        jalustaLeftPadding = (int)((jalustaWidth-muotoWidth-leftPadding-sideImageLeftPadding
                -rightPadding-(kivenLeveys/140.0*THREED)-rosoPintaX)/2);
        
        at = AffineTransform.getTranslateInstance((int)((1120-jalustaWidth)/2)+jalustaLeftPadding+leftPadding, 
                (480-muotoHeight)+TOPPADDING+(int)(kivenKorkeus/80.0*THREED)+offset);
        at.scale((double)muotoWidth/frontImage.getWidth(), (double)muotoHeight/frontImage.getHeight());
        frontArea.transform(at);
        
        frontRectangle = new Rectangle2D.Double(0, 0, muotoWidth, muotoHeight);
        tp = new TexturePaint(ImageArrays.kivenVariImages[variIndex], frontRectangle);
        BufferedImage hautakiviMuoto = new BufferedImage(1120, 
                560, BufferedImage.TYPE_INT_ARGB);
        
        Graphics2D g2d = hautakiviMuoto.createGraphics();
        g2d.setRenderingHints(hints);
        
        
        g2d.drawImage(jalustaImage, (int)((1120-jalustaWidth)/2), 
                (480-muotoHeight)+TOPPADDING+muotoHeight-30+(int)(kivenKorkeus/80.0*THREED)+offset, 
                jalustaWidth, jalustaHeight, null);
        
        g2d.setPaint(tp);
        g2d.fill(frontArea);

        g2d.drawImage(sideImage, (int)((1120-jalustaWidth)/2)+jalustaLeftPadding+sideImageLeftPadding, 
                (480-muotoHeight)+TOPPADDING+sideImageTopPadding, 
                muotoWidth+(int)(kivenLeveys/140.0*THREED)+leftPadding+rightPadding+rosoPintaX,
                muotoHeight+(int)(kivenKorkeus/80.0*THREED)+rosoPintaY+bottomPadding, null);

        g2d.dispose();
        //System.out.println(imageName);
        return hautakiviMuoto;
    }
    
    protected static Area drawArea(BufferedImage areaImage) {
        int imageWidth = areaImage.getWidth();
        int imageHeight = areaImage.getHeight();
        int imageX, imageY, areaX, areaY, pixelCount, tailX, rows, transparency;
        boolean transparent = true;
        Rectangle bounds;
        Area frontArea = new Area();
        Rectangle subArea;
        
        int[] rgbPixels = areaImage.getRGB(0, 0, imageWidth, imageHeight, 
                null, 0, imageWidth);
        areaX = areaY = pixelCount = 0;
        for (imageY=0; imageY<imageHeight; imageY++) {
            for (imageX=0; imageX<imageWidth; imageX++) {
                transparency = (rgbPixels[imageY*imageWidth+imageX] >> 24) &0xff;
                if (transparency != 0 && transparent) { // an edge of the image
                    transparent = false;
                    areaX = imageX;
                    areaY = imageY;
                    pixelCount = 1;
                }
                else if (transparency != 0 && !transparent) { // continue image
                    pixelCount++;
                }
                else if (transparency == 0 && !transparent) { // an end edge of the image
                    transparent = true;
                    /* calculate the tail of the first row */
                    tailX = imageWidth-areaX;
                    if (pixelCount <= tailX) { // a single row
                        subArea = new Rectangle(areaX, areaY, pixelCount, 1);
                        frontArea.add(new Area(subArea));
                    }
                    else { // shape continues to the next row
                        /* fill the partial row */
                        subArea = new Rectangle(areaX, areaY, tailX, 1);
                        frontArea.add(new Area(subArea));
                        pixelCount -= tailX;
                        rows = pixelCount/imageWidth;
                        if (rows >= 1) {
                            /* fill full rows */
                            subArea = new Rectangle(0, areaY+1, imageWidth, rows);
                            frontArea.add(new Area(subArea));
                            pixelCount = pixelCount - rows*imageWidth;
                        }
                        /* fill the last partial row */
                        subArea = new Rectangle(0, areaY+1+rows, pixelCount, 1);
                        frontArea.add(new Area(subArea));
                    }
                }
            }
        }
        /* calculate the tail of the first row */
        tailX = imageWidth-areaX;
        if (pixelCount <= tailX) { // a single row
            subArea = new Rectangle(areaX, areaY, pixelCount, 1);
            frontArea.add(new Area(subArea));
        }
        else { // shape continues to the next row
            /* fill the partial row */
            subArea = new Rectangle(areaX, areaY, tailX, 1);
            frontArea.add(new Area(subArea));
            pixelCount -= tailX;
            rows = pixelCount/imageWidth;
            if (rows >= 1) {
                /* fill full rows */
                subArea = new Rectangle(0, areaY+1, imageWidth, rows);
                frontArea.add(new Area(subArea));
                pixelCount = pixelCount - rows*imageWidth;
            }
            /* fill the last partial row */
            subArea = new Rectangle(0, areaY+1+rows, pixelCount, 1);
            frontArea.add(new Area(subArea));
        }
        return frontArea;
    }
}