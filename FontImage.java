/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hautakivi;

import java.awt.image.BufferedImage;

/**
 *
 * @author Juha-Pekka
 */
public class FontImage {
    
    private BufferedImage image;
    private String description;
    
    public FontImage(BufferedImage image, String description) {
        this.image = image;
        this.description = description;
    }
    
    public BufferedImage getImage() {
        return this.image;
    }
    
    public void setImage(BufferedImage image) {
        this.image = image;
    }
    
    public String getDescription() {
        return this.description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public static FontImage getFontImage(FontImage[] fontImages, String ending) {
        
        for (FontImage fontImage : fontImages) {
            if (fontImage.getDescription().endsWith(ending)) {
                return fontImage;
            }
        }
        return null;
    }
    
    public static FontImage[] getFontImages(String text, String kirjasinTyyppi, 
            String kirjasinAlaTyyppi, boolean isOs) {
	
        FontImage[] fontImages = new FontImage[text.length()];
	char charItem;
        
	for (int i=0; i<text.length(); i++) {
            charItem = text.charAt(i);
            switch (charItem) {
                case ' ':
                    fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "space.png");
                    break;
                    
                case 'A':
                case 'a':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
                        fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "A.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "A.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "A.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "A.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "A.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "A.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "A.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "A.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "A.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "A.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "A.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "A.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "A.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "A.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "A.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "A.png");
			break;
                    }
                    else { break; }
				
		case 'B':
                case 'b':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
                        fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "B.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "B.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "B.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "B.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "B.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "B.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "B.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "B.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "B.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "B.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "B.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "B.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "B.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "B.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "B.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "B.png");
			break;
                    }
                    else { break; }
				
		case 'C':
                case 'c':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "C.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "C.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "C.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "C.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "C.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "C.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "C.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "C.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "C.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "C.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "C.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "C.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "C.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "C.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "C.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "C.png");
			break;
                    }
                    else { break; }
				
                case 'D':
                case 'd':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "D.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "D.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "D.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "D.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "D.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "D.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "D.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "D.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "D.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "D.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "D.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "D.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "D.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "D.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "D.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "D.png");
			break;
                    }
                    else { break; }   
                            
                case 'E':
                case 'e':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "E.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "E.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "E.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "E.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "E.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "E.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "E.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "E.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "E.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "E.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "E.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "E.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "E.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "E.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "E.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "E.png");
			break;
                    }
                    else { break; }                    
				
		case 'F':
                case 'f':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "F.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "F.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "F.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "F.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "F.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "F.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "F.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "F.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "F.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "F.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "F.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "F.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "F.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "F.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "F.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "F.png");
			break;
                    }
                    else { break; }
				
		case 'G':
                case 'g':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "G.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "G.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "G.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "G.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "G.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "G.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "G.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "G.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "G.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "G.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "G.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "G.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "G.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "G.png");
                    	break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "G.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "G.png");
			break;
                    }
                    else { break; }	
				
		case 'H':
                case 'h':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "H.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "H.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "H.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "H.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "H.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "H.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "H.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "H.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "H.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "H.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "H.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "H.png");
                        break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "H.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "H.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "H.png");
                    	break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "H.png");
			break;
                    }
                    else { break; }

		case 'I':
                case 'i':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "I.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "I.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "I.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "I.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "I.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "I.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "I.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "I.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "I.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "I.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "I.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "I.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "I.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "I.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "I.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "I.png");
			break;
                    }
                    else { break; }
				
		case 'J':
                case 'j':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "J.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "J.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "J.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "J.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "J.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "J.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "J.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "J.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "J.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "J.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "J.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "J.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "J.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "J.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "J.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "J.png");
			break;
                    }
                    else { break; }
				
		case 'K':
                case 'k':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "K.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "K.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "K.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "K.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "K.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "K.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "K.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "K.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "K.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "K.png");
                        break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "K.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "K.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "K.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "K.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "K.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "K.png");
			break;
                    }
                    else { break; }
				
		case 'L':
                case 'l':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "L.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "L.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "L.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "L.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "L.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "L.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "L.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "L.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "L.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "L.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "L.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "L.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "L.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "L.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "L.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "L.png");
			break;
                    }
                    else { break; }
				
		case 'M':
                case 'm':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "M.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "M.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "M.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "M.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "M.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "M.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "M.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "M.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "M.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "M.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "M.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "M.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "M.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "M.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "M.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "M.png");
			break;
                    }
                    else { break; }
				
		case 'N':
                case 'n':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "N.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "N.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "N.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "N.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "N.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "N.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "N.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "N.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "N.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "N.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "N.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "N.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "N.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "N.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "N.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "N.png");
			break;
                    }
                    else { break; }
		
		case 'O':
                case 'o':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
                        if (!isOs || i > 0) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "O.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "O_small.png");
                            break;
                        }
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 0) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "O.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "O_small.png");
                            break;
                        }
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 0) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "O.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "O_small.png");
                            break;
                        }
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 0) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "O.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "O_small.png");
                            break;
                        }
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 0) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "O.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "O_small.png");
                            break;
                        }
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 0) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "O.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "O_small.png");
                            break;
                        }
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 0) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "O.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "O_small.png");
                            break;
                        }
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 0) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "O.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "O_small.png");
                            break;
                        }
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 0) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "O.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "O_small.png");
                            break;
                        }
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 0) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "O.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "O_small.png");
                            break;
                        }
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 0) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "O.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "O_small.png");
                            break;
                        }
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 0) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "O.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "O_small.png");
                            break;
                        }
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 0) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "O.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "O_small.png");
                            break;
                        }
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 0) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "O.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "O_small.png");
                            break;
                        }
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 0) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "O.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "O_small.png");
                            break;
                        }
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 0) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "O.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "O_small.png");
                            break;
                        }
                    }
                    else { break; }
			
		case 'P':
                case 'p':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "P.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "P.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "P.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "P.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "P.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "P.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "P.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "P.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "P.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "P.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "P.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "P.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "P.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "P.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "P.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "P.png");
			break;
                    }
                    else { break; }
				
		case 'Q':
                case 'q':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "Q.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "Q.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "Q.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "Q.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "Q.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "Q.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "Q.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "Q.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "Q.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "Q.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "Q.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "Q.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "Q.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "Q.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "Q.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "Q.png");
			break;
                    }
                    else { break; }
				
		case 'R':
                case 'r':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "R.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "R.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "R.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "R.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "R.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "R.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "R.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "R.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "R.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "R.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "R.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "R.png");
                    	break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
                        fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "R.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "R.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "R.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "R.png");
			break;
                    }
                    else { break; }
				
		case 'S':
                case 's':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
                        if (!isOs || i > 2) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "S.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "S_small.png");
                            break;
                        }
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 2) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "S.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "S_small.png");
                            break;
                        }
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 2) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "S.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "S_small.png");
                            break;
                        }
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 2) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "S.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "S_small.png");
                            break;
                        }
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 2) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "S.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "S_small.png");
                            break;
                        }
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 2) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "S.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "S_small.png");
                            break;
                        }
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 2) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "S.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "S_small.png");
                            break;
                        }
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 2) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "S.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "S_small.png");
                            break;
                        }
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 2) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "S.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "S_small.png");
                            break;
                        }
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 2) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "S.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "S_small.png");
                            break;
                        }
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 2) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "S.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "S_small.png");
                            break;
                        }
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 2) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "S.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "S_small.png");
                            break;
                        }
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 2) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "S.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "S_small.png");
                            break;
                        }
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 2) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "S.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "S_small.png");
                            break;
                        }
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 2) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "S.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "S_small.png");
                            break;
                        }
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			if (!isOs || i > 2) { // not "o.s." string
                            fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "S.png");
                            break;
                        }
                        else {
                            fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "S_small.png");
                            break;
                        }
                    }
                    else { break; }
				
		case 'T':
                case 't':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "T.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "T.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "T.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "T.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "T.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "T.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "T.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "T.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "T.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "T.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
                        fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "T.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "T.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "T.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "T.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "T.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "T.png");
			break;
                    }
                    else { break; }
				
		case 'U':
                case 'u':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "U.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "U.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "U.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "U.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "U.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "U.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "U.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "U.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "U.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "U.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "U.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "U.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "U.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "U.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "U.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "U.png");
			break;
                    }
                    else { break; }
				
		case 'V':
                case 'v':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "V.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "V.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "V.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "V.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "V.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "V.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "V.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "V.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "V.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "V.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "V.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "V.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "V.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "V.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "V.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "V.png");
			break;
                    }
                    else { break; }
				
		case 'W':
                case 'w':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "W.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "W.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "W.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "W.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "W.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "W.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "W.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "W.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "W.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "W.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "W.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "W.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "W.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "W.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "W.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "W.png");
			break;
                    }
                    else { break; }
			
		case 'X':
                case 'x':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "X.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "X.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "X.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "X.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
                       	fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "X.png");
                    	break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "X.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "X.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "X.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "X.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "X.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "X.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "X.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "X.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "X.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "X.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "X.png");
			break;
                    }
                    else { break; }
				
		case 'Y':
                case 'y':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "Y.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "Y.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "Y.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "Y.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "Y.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "Y.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "Y.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "Y.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "Y.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "Y.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "Y.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "Y.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "Y.png");
				break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "Y.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "Y.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "Y.png");
			break;
                    }
                    else { break; }
				
                case 'Z':
                case 'z':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "Z.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "Z.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "Z.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "Z.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "Z.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "Z.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "Z.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "Z.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "Z.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "Z.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "Z.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "Z.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "Z.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "Z.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "Z.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "Z.png");
			break;
                    }
                    else { break; }
				
		case 'Å':
                case 'å':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "Å.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "Å.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "Å.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "Å.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "Å.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "Å.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "Å.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
                    	fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "Å.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
                        fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "Å.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "Å.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "Å.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "Å.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "Å.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "Å.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "Å.png");
					break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "Å.png");
			break;
                    }
                    else { break; }
				
		case 'Ä':
                case 'ä':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "Ä.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "Ä.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "Ä.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "Ä.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "Ä.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "Ä.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "Ä.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "Ä.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "Ä.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "Ä.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "Ä.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "Ä.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "Ä.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "Ä.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "Ä.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "Ä.png");
			break;
                    }
                    else { break; }
				
		case 'Ö':
                case 'ö':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "Ö.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "Ö.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "Ö.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "Ö.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "Ö.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "Ö.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "Ö.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "Ö.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "Ö.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "Ö.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "Ö.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "Ö.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "Ö.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "Ö.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "Ö.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "Ö.png");
			break;
                    }
                    else { break; }
                
                case '0':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "0.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "0.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "0.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "0.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "0.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "0.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "0.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "0.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "0.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "0.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "0.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "0.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "0.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "0.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "0.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "0.png");
			break;
                    }
                    else { break; }
                
                case '1':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "1.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "1.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "1.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "1.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "1.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "1.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "1.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "1.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "1.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "1.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "1.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "1.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "1.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "1.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "1.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "1.png");
			break;
                    }
                    else { break; }
                
                case '2':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "2.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "2.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "2.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "2.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "2.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "2.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "2.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "2.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "2.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "2.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "2.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "2.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "2.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "2.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "2.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "2.png");
			break;
                    }
                    else { break; }
                
                case '3':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "3.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "3.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "3.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "3.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "3.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "3.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "3.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "3.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "3.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "3.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "3.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "3.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "3.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "3.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "3.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "3.png");
			break;
                    }
                    else { break; }
                
                case '4':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "4.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "4.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "4.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "4.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "4.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "4.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "4.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "4.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "4.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "4.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "4.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "4.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "4.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "4.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "4.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "4.png");
			break;
                    }
                    else { break; }
                
                case '5':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "5.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "5.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "5.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "5.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "5.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "5.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "5.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "5.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "5.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "5.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "5.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "5.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "5.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "5.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "5.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "5.png");
			break;
                    }
                    else { break; }
                
                case '6':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "6.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "6.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "6.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "6.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "6.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "6.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "6.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "6.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "6.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "6.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "6.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "6.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "6.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "6.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "6.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "6.png");
			break;
                    }
                    else { break; }
                
                case '7':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "7.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "7.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "7.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "7.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "7.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "7.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "7.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "7.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "7.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "7.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "7.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "7.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "7.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "7.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "7.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "7.png");
			break;
                    }
                    else { break; }
                
                case '8':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "8.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "8.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "8.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "8.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "8.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "8.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "8.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "8.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "8.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "8.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "8.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "8.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "8.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "8.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "8.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "8.png");
			break;
                    }
                    else { break; }
                
                case '9':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "9.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "9.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "9.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "9.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "9.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "9.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "9.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "9.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "9.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "9.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "9.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "9.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "9.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "9.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "9.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "9.png");
			break;
                    }
                    else { break; }
				
		case '-':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "dash.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "dash.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "dash.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "dash.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "dash.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "dash.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "dash.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "dash.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "dash.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "dash.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "dash.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "dash.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "dash.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "dash.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "dash.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "dash.png");
			break;
                    }
                    else { break; }
			
		case '.':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "dot.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "dot.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "dot.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "dot.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "dot.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "dot.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "dot.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "dot.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "dot.png");
			break;
                    }  
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "dot.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "dot.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "dot.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "dot.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "dot.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "dot.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "dot.png");
			break;
                    }
                    else { break; }
                
                case '*':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "star.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "star.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "star.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "star.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "star.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "star.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "star.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "star.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "star.png");
			break;
                    }  
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "star.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "star.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "star.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "star.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "star.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "star.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "star.png");
			break;
                    }
                    else { break; }
                
                case '†':
                    if ("Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKirkasImages, "cross.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaKromausImages, "cross.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTaidePatinaImages, "cross.png");
			break;
                    }
                    else if ("Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.antikvaTummaPatinaImages, "cross.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKirkasImages, "cross.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiKromausImages, "cross.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTaidePatinaImages, "cross.png");
			break;
                    }
                    else if ("Groteski".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.groteskiTummaPatinaImages, "cross.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKirkasImages, "cross.png");
			break;
                    }  
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaKromausImages, "cross.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTaidePatinaImages, "cross.png");
			break;
                    }
                    else if ("Kapea Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.kapeaAntikvaTummaPatinaImages, "cross.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kirkas".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKirkasImages, "cross.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Kromaus".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaKromausImages, "cross.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Taidepatina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTaidePatinaImages, "cross.png");
			break;
                    }
                    else if ("Leveä Antikva".equals(kirjasinTyyppi) && "Tumma patina".equals(kirjasinAlaTyyppi)) {
			fontImages[i] = getFontImage(ImageArrays.leveaAntikvaTummaPatinaImages, "cross.png");
			break;
                    }
                    else { break; }
				
                default: break; 
            }
        }
	return fontImages;
    }
}
