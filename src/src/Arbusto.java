import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.image.BufferedImage;

public class Arbusto extends Cenario {
	
	private int contador;
	private boolean pisoteado;

	public Arbusto (int i, int j) {
		super(i, j, true);
		contador = 0;
		pisoteado = false;
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
		if (pisoteado==false) {
			
			Random aleatorio = new Random();
			int num = aleatorio.nextInt(9);
			
			if (num % 2 == 0) {//0 2 4 6 8 buracos
				return 'b'; //buraco
			}
			if (num == 1) {
				return 'c'; //capacete
			}
			if (num == 3 || num == 5) { 
				return 'm'; //machadinho
			}
			return 'v'; //se o numero for 7 ou 9 retorna vazio
		}
		else {
			return 'n';
		}
	}

	public EstadoDoJogo confere(EstadoDoJogo estado) {
		if (pisoteado == true) {
			if (contador < 19) {
				contador++;
			}
			else {
				pisoteado = false;
				setVisivel(true);
				setSrc("novo_arbusto.png");
                		contador = 0;
			}
		}
		return estado;
	}
	public void pisotear() {
		pisoteado = true;
	}
}
