import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Tree extends Cenario {

		public char surpresa; //toda arvore tem tipo a 
        public Tree (int i, int j) {
        	super(i,j,true,true);
        	surpresa = 'a';
        	setSrc("arvred.png");
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
	
	public char getSurpresa() {
		return surpresa;
	}
}

