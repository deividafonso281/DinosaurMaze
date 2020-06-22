import java.awt.Graphics;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Dinosaur extends PMovimento {
	
	private BufferedImage img;
	private String direcao;
	private int contador;
	private int machado;
	private String bonus;
	
	public Dinosaur (int i, int j) {
	 	super(i,j);
		direcao = "direita";
		contador = 1;
		machado = 0;
		bonus = "";
		setImagens();
	}
	
	private void setImagens() {
		try {
			img = ImageIO.read(new File("max" + contador+"_" + direcao + ".png"));
		} catch (IOException exception) {
		}
	
	}
	
	public void draw (Graphics g) {
		g.drawImage(img, (posx - 1) * 36, 80 + (posy - 1) * 36, null);
	}
	
	public void move() {
		super.move();
        contador = (contador) % 2 + 1;
		setImagens();
	}
	
	public void viraDireita() {
		super.viraDireita();
		if (dirx == 1 && diry == 0) {
			direcao = "direita";
		}
		else if (dirx == -1 && diry == 0) {
			direcao = "esquerda";
		}
		setImagens();
	}

	public void viraEsquerda() {
		super.viraEsquerda();
		if (dirx == -1 && diry == 0) {
			direcao = "esquerda";
		}
		else if (dirx == 1 && diry == 0) {
			direcao = "direita";
		}
		setImagens();
	}
	
	public int[] getProx() {
		return super.getProx();
	}

	public int[] getAtual() {
		return super.getAtual();
	}

	public int[] getEsquerda() {
		return super.getEsquerda();
	}
	
	public int[] getDireita() {
		return super.getDireita();
	}

	public String interacao(char efeito) {
		if (efeito == 'b') {
			//caso de buraco debaixo do arbusto
			//max fica parado por pelo menos uma rodada
			bonus = "Buraco";
		}
		else if(efeito == 'c') {
			//caso de capacete vai mais rapido
			move();
			move();
			bonus = "Capacete";
		}
		else if (efeito == 'm') {
			machado++;
			bonus = "Machado";
		}
		else if (efeito == 'v') {
			//se e um arbusto e ta vazio
			move();
			bonus = "";
		}
		else if(machado != 0 && efeito =='a') {
			machado--;
			move();
		}
		else if (machado == 0 && efeito =='a') {
			;
		}
		else {
			//se nao tiver machados nao pode passar por cima das arvores
			move();
		}
		return bonus;
	} 
}