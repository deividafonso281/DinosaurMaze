import java.awt.Color;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Cenario implements ICenario {
	public int posx;
	public int posy;
	public boolean obstaculo;
	public boolean visivel;
	public BufferedImage img = null;
	public String src;

	public Cenario (int i, int j, boolean vis) {
		posx = i;
		posy = j;
		visivel = vis;
	}

	public void setVisivel(boolean vis) {
		visivel = vis;
    }

	public boolean getVisivel() {
		return visivel;
    }
	
	public void setSrc(String src) {
		this.src = src;
	}

	public void desenha (Graphics g) {
		if (visivel == true) {
			try {
				img = ImageIO.read(new File(src));
			} catch (IOException e) {
			}
			g.drawImage(img, (posx - 1) * 36, 80 + (posy - 1) *36, null);
		}
	}
	
	public char qualObjeto() {
		return 'n';
	}
}