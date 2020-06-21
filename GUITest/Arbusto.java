import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.image.BufferedImage;

public class Arbusto extends Cenario {
	
	private int contador;

	public Arbusto (int i, int j) {
		super(i,j,true);
		contador = 0;
		setSrc("novo_arbusto.png");
	}
	public void draw (Graphics g) {
    	super.draw(g);
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
	public char whatObject() {
		if (isVisible== true) {
			Random random = new Random();
			int num = random.nextInt(9);
			setVisible(false);
			if (num % 2 == 0) //0 2 4 6 8 buracos
				return 'b'; //buraco
			if (num == 1) //capacete
				return 'c'; //capacete
			if (num == 3 || num == 5) //machadinho 
				return 'm'; //machadinho
			return 'v'; //se o numero for 7 ou 9retorna vazio
		}
		else {
			return 'n';
		}
	}

	public void check() {
		if (isVisible== false) {
			if (contador<19) {
				contador++;
				System.out.println(contador);
			}
			else {
				setVisible(true);
                		contador = 0;
			}
		}
	}
}
