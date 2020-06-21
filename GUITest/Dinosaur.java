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
	private int machado;
	private String bonus;
	
	public Dinosaur (int i, int j) {
	 	super(i,j);
		direction = "direita";
		counter = 1;
		machado = 0;
		bonus = "";
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

	public String interact(char effect) {
		if (effect == 'b') {
                        //caso de buraco debaixo do arbusto
                        //max fica parado por pelo menos uma rodada
			bonus = "Buraco";
                }
                else if(effect == 'c') {
                        //caso de capacete vai mais rapido
                        move();
                        move();
			bonus = "Capacete";
                }
                else if (effect == 'm') {
                        machado++;
			bonus = "Machado";
                }
                else if (effect == 'v') {
                        //se e um arbusto e ta vazio
                        move();
			bonus = "";
                }
                else if(machado != 0 && effect=='a') {
                        machado--;
                        move();
                }
                else if (machado == 0 && effect=='a') {
                        ;
		}
		else {
			//se nao tiver machados nao pode passar por cima das arvores
                        move();
		}
		return bonus;
	} 
}
