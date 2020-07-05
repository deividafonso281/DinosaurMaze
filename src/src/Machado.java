import java.awt.Graphics;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Machado {

        private static BufferedImage img;
		
        private static void setImagens() {
                try {
                	img = ImageIO.read(new File("machado.png"));
                } catch (IOException exception) {
                }

        }

        public static void draw (Graphics g,int i) {
		setImagens();
                g.drawImage(img, 36*i+52 , 24, null);
        }
}
