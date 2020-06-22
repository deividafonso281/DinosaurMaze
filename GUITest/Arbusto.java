import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.image.BufferedImage;

public class Arbusto extends Cenario {
	
	private int contador;

	public Arbusto (int i, int j) {
		super(i, j, true);
		contador = 0;
		setSrc("novo_arbusto.png");
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
		if (visivel == true) {
			
			Random aleatorio = new Random();
			int num = aleatorio.nextInt(9);
			setVisivel(false);
			
			if (num % 2 == 0) //0 2 4 6 8 buracos
				return 'b'; //buraco
			if (num == 1) 
				return 'c'; //capacete
			if (num == 3 || num == 5)  
				return 'm'; //machadinho
			return 'v'; //se o numero for 7 ou 9 retorna vazio
		}
		else {
			return 'n';
		}
	}

	public void confere() {
		if (visivel == false) {
			if (contador < 19) {
				contador++;
				System.out.println(contador);
			}
			else {
				setVisivel(true);
                		contador = 0;
			}
		}
	}
}