import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Arbusto extends Cenario {

        public Arbusto (int i, int j) {
                 super(i,j,false,true);
		 setSrc("novo_arbusto.png");
        }

        public void draw (Graphics g) {
                super.draw(g);
        }

        public void setObstacle (boolean obs) {
                super.setObstacle(obs);
        }
        public boolean getObstacle() {
                return super.getObstacle();
        }
	public void setVisible(boolean vis) {
		super.setVisible(vis);
	}
	public boolean getVisible() {
		return super.getVisible();
	}
	public void setSrc(String src) {
		super.setSrc(src);
	}
}

