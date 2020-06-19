import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import java.awt.image.BufferedImage;

public class Arbusto extends Cenario {
	
	private char surpresa; //b =  buraco, v = vazio, m = machado, c = corre mais rapido
	
	public Arbusto (int i, int j) {
		super(i,j,false,true);
		surpresa = whatObject();
		setSrc("novo_arbusto.png");
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
	public char whatObject() {
		Random random = new Random();
		int num = random.nextInt(9);
		if (num % 2 == 0) //0 2 4 6 8 buracos
			return 'b';
		if (num == 1) //capacete
			return 'c';
		if (num == 3 || num == 5) //machadinho 
			return 'm';
		return 'v'; //se o numero for 7 ou 9retorna vazio
	}
	public char getSurpresa() {
		return surpresa;
	}

	public void surpresaAleatoria() {
		surpresa = whatObject();
	}
}
