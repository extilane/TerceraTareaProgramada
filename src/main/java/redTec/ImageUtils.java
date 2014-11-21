package redTec;

import java.awt.Graphics2D;
import java.awt.RenderingHints;

import sun.misc.BASE64Encoder;
import sun.misc.BASE64Decoder;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.imageio.ImageIO;

public class ImageUtils {

    /**
     * Decode string to image
     * @param imageString The string to decode
     * @return decoded image
     */

    /**
     * 
     * @param Path el path funciona para  encontar la direccion de la imagen
     * 
     * 
     */
    public static String encodeToString( InputStream path) throws IOException {
        String imageString = null;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        
        
         BufferedImage image = ImageIO.read(path);
          int w = image.getWidth();
          int h = image.getHeight();
         BufferedImage bufim = new BufferedImage(180, 150, image.getType());
         Graphics2D g = bufim.createGraphics();
         g.setRenderingHint(RenderingHints.KEY_INTERPOLATION, RenderingHints.VALUE_INTERPOLATION_BILINEAR);
         g.drawImage(image, 0, 0, 180, 150, 0, 0, w, h, null);
         g.dispose();
        try {
            ImageIO.write(bufim, "jpg", bos);
            byte[] imageBytes = bos.toByteArray();
			BASE64Encoder encoder = new BASE64Encoder();
            imageString = encoder.encode(imageBytes);

            bos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return imageString;
    }

}

