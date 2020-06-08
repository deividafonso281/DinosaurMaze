import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Arbusto  {

        public int posx;
        public int posy;
        public boolean isObstacle;
	public boolean isVisible;
        private BufferedImage img = null;

        public Arbusto (int i, int j) {
                 posx = i;
                 posy = j;
                 isObstacle = false;
		 isVisible = true;
        }

        public void draw (Graphics g) {
                if (isVisible == true) {
                        try {
                                img = ImageIO.read(new File("novo_arbusto.png"));
                        } catch (IOException e) {
                        }
                        g.drawImage(img, (posx-1)*36,80+(posy-1)*36,null);
                }
        }

        public void setObstacle () {
                isObstacle = true;
        }
        public boolean getObstacle() {
                return isObstacle;
        }
	public void setVisible(boolean canSee) {
		isVisible = canSee;
	}
	public boolean getVisible() {
		return isVisible;
	}
}

