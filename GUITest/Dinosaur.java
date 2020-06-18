import java.awt.Graphics;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Dinosaur extends PMovimento implements KeyListener{

	private BufferedImage max_cima_dir;
        private BufferedImage max_baixo_dir;
        private BufferedImage max_cima_esq;
        private BufferedImage max_baixo_esq;
	private BufferedImage img;
	
	public Dinosaur (int i, int j) {
	 	super(i,j);
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
		super.move();
	}
	
	public void turnRight() {
		super.turnRight();
	}

	public void turnLeft() {
		super.turnLeft();
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

	public void keyPressed(KeyEvent event) {
                if (event.getKeyCode()==39) {
                        turnRight();
                }
                else if (event.getKeyCode()==37) {
                        turnLeft();
                }
                else if (event.getKeyCode()== KeyEvent.VK_D) {
                        turnRight();
                }
                else if (event.getKeyCode()== KeyEvent.VK_A) {
                        turnLeft();
                }
        }
        public void keyTyped (KeyEvent event) {
                if (event.getKeyCode()== KeyEvent.VK_D) {
                        turnRight();
                }
                else if (event.getKeyCode()== KeyEvent.VK_A) {
                        turnLeft();
                }
        }
        public void keyReleased (KeyEvent event) {
                ;
        }
}
