import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Cenario implements ICenario {
	public int posx;
        public int posy;
        public boolean isObstacle;
        public boolean isVisible;
	public BufferedImage img = null;
	public String src;

        public Cenario (int i, int j, boolean vis) {
                 posx = i;
                 posy = j;
                 isVisible = vis;
        }

        public void setVisible(boolean vis) {
                isVisible = vis;
        }

        public boolean getVisible() {
                return isVisible;
        }
	
	public void setSrc(String src) {
		this.src = src;
	}

	public void draw (Graphics g) {
                if (isVisible == true) {
                        try {
                                img = ImageIO.read(new File(src));
                        } catch (IOException e) {
                        }
                        g.drawImage(img, (posx-1)*36,80+(posy-1)*36,null);
                }
        }
	public char whatObject() {
		return 'n';
	}
}
