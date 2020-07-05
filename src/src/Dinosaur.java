import java.awt.Graphics;
import java.awt.Color;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Dinosaur extends PMovimento {
	
	private BufferedImage img;
	private String direcao;
	private int machado;
	private int capacete;
	private String skin;
	
	public Dinosaur (int i, int j) {
	 	super(i,j);
		direcao = "direita";
		machado = 0;
		capacete = 0;
		skin = "";
		defineImagens();
	}
	
	private void defineImagens() {
		try {
			if (machado ==0&& capacete ==0) {
				img = ImageIO.read(new File("max"+ skin +"_" + direcao + ".png"));
			}
			else if (machado == 0&&capacete !=0) {
				img = ImageIO.read(new File("max"+ skin +"_" + direcao + "_capacete.png"));
			}
			else if (machado!= 0 && capacete==0) {
				img = ImageIO.read(new File("max"+ skin +"_" + direcao + "_machado.png"));
			}
			else {
				img = ImageIO.read(new File("max"+ skin +"_" + direcao + "_machado_capacete.png"));
			}
		} catch (IOException exception) {
		}
	
	}
	
	public void desenha (Graphics g) {
		g.drawImage(img, (posx - 1) * 36, 80 + (posy - 1) * 36, null);
	}
	
	public void move() {
		super.move();
		defineImagens();
	}
	
	public void viraDireita() {
		super.viraDireita();
		if (dirx == 1 && diry == 0) {
			direcao = "direita";
		}
		else if (dirx == -1 && diry == 0) {
			direcao = "esquerda";
		}
		defineImagens();
	}

	public void viraEsquerda() {
		super.viraEsquerda();
		if (dirx == -1 && diry == 0) {
			direcao = "esquerda";
		}
		else if (dirx == 1 && diry == 0) {
			direcao = "direita";
		}
		defineImagens();
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

	public EstadoDoJogo interacao(EstadoDoJogo estado) {
		int[] atual = getAtual();
		int[] prox = getProx();
		char efeito_atual = estado.getPeca(atual[0],atual[1]).qualObjeto();
		char efeito_prox = estado.getPeca(prox[0],prox[1]).qualObjeto();
		if (efeito_atual == 'a') {
			posx = 2;
			posy = 2;
		}
		if (efeito_atual == 'b') {
			((Arbusto)estado.getPeca(atual[0],atual[1])).pisotear();
			((Arbusto)estado.getPeca(atual[0],atual[1])).setVisivel(false);
			//caso de buraco debaixo do arbusto
			//max fica parado por pelo menos uma rodada
		}
		else if(efeito_atual == 'c') {
			//caso de capacete vai mais rapido
			if (capacete<3) {
				capacete++;
			}
			((Arbusto)estado.getPeca(atual[0],atual[1])).pisotear();
			((Arbusto)estado.getPeca(atual[0],atual[1])).setVisivel(false);
			move();
			move();
		}
		else if (efeito_atual == 'm') {
			if (machado<3) {
				machado++;
			}
			((Arbusto)estado.getPeca(atual[0],atual[1])).pisotear();
			((Arbusto)estado.getPeca(atual[0],atual[1])).setVisivel(false);
			move();
		}
		else if (efeito_atual == 'v') {
			//se e um arbusto e ta vazio
			((Arbusto)estado.getPeca(atual[0],atual[1])).pisotear();
			((Arbusto)estado.getPeca(atual[0],atual[1])).setVisivel(false);
			move();
		}
		else if(machado != 0 && efeito_prox =='a') {
			machado--;
			estado.setPeca(prox[0],prox[1],new Toquinho(prox[0]+1,prox[1]+1));
			move();
		}
		else if (machado == 0 && efeito_prox =='a') {
			;
		}
		else {
			//se nao tiver machados nao pode passar por cima das arvores
			move();
		}
		return estado;
	}

	public void setSkin(String skin) {
		this.skin = skin;
		defineImagens();
	}

	public int getMachado() {
		return machado;
	} 
	
	public int getCapacete() {
		return capacete;
	}
}
