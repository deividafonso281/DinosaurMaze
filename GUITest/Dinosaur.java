import java.awt.Graphics;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Dinosaur extends PMovimento {
	
	private BufferedImage img;
	private String src;
	private String direction;
	private int counter;
	
	public Dinosaur (int i, int j) {
	 	super(i,j);
		direction = "direita";
		counter = 1;
		setImages();
	}
	
	private void setImages() {
		try {
                        img = ImageIO.read(new File("max"+counter+"_"+direction+".png"));
                } catch (IOException exception) {
		}
	
	}
	
	public void draw (Graphics g) {
		g.drawImage(img, (posx-1)*36,80+(posy-1)*36, null);
	}
	
	public void move() {
		super.move();
                counter = (counter)%2 + 1;
		setImages();
	}
	
	public void turnRight() {
		super.turnRight();
		if (dirx==1&&diry==0) {
			direction = "direita";
		}
		else if (dirx==-1&&diry==0) {
			direction = "esquerda";
		}
		setImages();
	}

	public void turnLeft() {
		super.turnLeft();
		if (dirx==-1&&diry==0) {
			direction = "esquerda";
		}
		else if (dirx==1&&diry==0) {
			direction = "direita";
		}
		setImages();
	}
	
	public int[] getNext() {
		return super.getNext();
	}

	public int[] getAtual() {
		return super.getAtual();
	}

	public int[] getLeft() {
		return super.getLeft();
	}
	
	public int[] getRight() {
		return super.getRight();
	}
}