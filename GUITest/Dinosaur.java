import java.awt.Graphics;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Dinosaur  {

	int size = 32;
	public int posx;
	public int posy;
	public int dirx = 0;
	public int diry = 1;
	private BufferedImage max_cima_dir;
        private BufferedImage max_baixo_dir;
        private BufferedImage max_cima_esq;
        private BufferedImage max_baixo_esq;
	private BufferedImage img;
	
	public Dinosaur (int i, int j) {
	 	posx = i;
		posy = j;
		setImages();
	}
	
	private void setImages() {
		try {
                        max_cima_dir = ImageIO.read(new File("max1_direita.png"));
                } catch (IOException e) {
                }
		try {
                        max_baixo_dir = ImageIO.read(new File("Max2_direita.png"));
                } catch (IOException e) {
                }
		try {
                        max_cima_esq = ImageIO.read(new File("Max1_esquerda.png"));
                } catch (IOException e) {
                }
		try {
                        max_baixo_esq = ImageIO.read(new File("Max2_esquerda.png"));
                } catch (IOException e) {
                }
		img = max_baixo_esq;
	
	}
	
	public void draw (Graphics g) {
		g.drawImage(img, (posx-1)*36,80+(posy-1)*36, null);
	}
	
	public void move() {
		this.posx += dirx;
		if (this.posx>20) {
			this.posx = 1;
		}
		if (this.posx<1) {
			this.posx= 20;
		}
		this.posy += diry;
		if (this.posy>20) {
			this.posy = 1;
		}
		if (this.posy<1) {
			this.posy = 20;
		}
	}
	
	public void turnRight() {
		if (this.dirx==0&&this.diry==1) {
			this.dirx = -1;
			this.diry = 0;
		}
		else if (this.dirx==-1&&this.diry==0) {
			this.dirx = 0;
			this.diry = -1; 
		}
		else if (this.dirx==0&&this.diry==-1) {
			this.dirx = 1;
			this.diry = 0;
		}
		else {
			this.dirx = 0;
			this.diry = 1;
		}
	}

	public void turnLeft() {
		if (this.dirx==0&&this.diry==1) {
                        this.dirx = 1;
                        this.diry = 0;
                }
                else if (this.dirx==1&&this.diry==0) {
                        this.dirx = 0;
                        this.diry = -1;
                }
                else if (this.dirx==0&&this.diry==-1) {
                        this.dirx = -1;
                        this.diry = 0;
                }
                else {
                        this.dirx = 0;
                        this.diry = 1;
                }
	}
	
	public int[] getNext() {
		int[] position = new int[2];
		position[0] = (posx-1)+dirx;
		position[1] = (posy-1)+diry;
		if  (position[0]<0) {
			position[0]=19;
		}
		if (position[0]>19) {
			position[0] = 0;
		}
		if (position[1]<0) {
			position[1] = 19;
		}
		if (position[1]>19) {
			position[1] = 0;
		}
		return position;
	}
	public int[] getAtual() {
		int[] position = new int[2];
		position[0] = posx-1;
		position[1] = posy-1;
		return position;
	}
}
