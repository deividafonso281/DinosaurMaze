import java.awt.Graphics;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Tree  {

        int size = 36;
        public int posx;
        public int posy;
	public boolean isObstacle;
	private BufferedImage img = null;

        public Tree (int i, int j) {
                 posx = i;
                 posy = j;
		 isObstacle = false;
        }

        public void draw (Graphics g) {
		if (isObstacle == true) {
                	/*g.setColor(Color.RED);
                	g.fillOval((posx-1)*36+2,80+(posy-1)*36+2,size,size);*/
        		try {
				img = ImageIO.read(new File("arvred.png"));
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
}
