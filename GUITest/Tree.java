import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Tree extends Cenario {

	public Tree (int i, int j) {
		super(i,j,true);
		setSrc("arvred.png");
	}

	public void desenha (Graphics g) {
		super.desenha(g);
	}

	public void setVisivel(boolean vis) {
		super.setVisivel(vis);
	}

	public boolean getVisivel() {
		return super.getVisivel();
	}

	public void setSrc(String src) {
		super.setSrc(src);
	}
	
	public char qualObjeto() {
		return 'a'; //toda arvore tem tipo a
	}
}
