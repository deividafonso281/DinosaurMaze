import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Meteor extends PMovimento {

	private BufferedImage onfire_cima;
	private BufferedImage onfire_baixo;
	private BufferedImage onfire_esq;
	private BufferedImage onfire_dir;

    public Meteor (int i, int j) {
    	super(i,j);
    	defineImagem();
    }

	private void defineImagem() {
		try {
               	onfire_esq = ImageIO.read(new File("onfire_esq.png"));
            } catch (IOException e){
              }
		try {
                onfire_baixo = ImageIO.read(new File("onfire_baixo.png"));
        } catch (IOException e){
          }
		try {
                onfire_cima = ImageIO.read(new File("onfire_cima.png"));
        } catch (IOException e){
          }
		try {
                        onfire_dir = ImageIO.read(new File("onfire_dir.png"));
        } catch (IOException e){
          }
	}
	
    public void desenha (Graphics g) {
                if (dirx == 0 && diry == -1) {
                	g.drawImage(onfire_baixo, (posx-1)*36, 80+(posy-1)*36, null); 
		}
		else if (dirx == 0 && diry == 1) {
                g.drawImage(onfire_cima, (posx-1)*36, 80+(posy-2)*36, null);
        }
		else if (dirx==1 && diry==0) {
                g.drawImage(onfire_esq, (posx-2)*36, 80+(posy-1)*36, null);
        }
		else if (dirx==-1 && diry==0) {
                g.drawImage(onfire_dir, (posx-1)*36, 80+(posy-1)*36, null);
        }
    }

    public void move() {
    	super.move();
    }

    public void viraDireita() {
        super.viraDireita();
    }

	public void viraEsquerda() {
        super.viraEsquerda();
    }

    public int[] getProx() {
    	return super.getProx();
    }

	public int[] getDireita() {
		return super.getDireita();
	}

	public int[] getEsquerda() {
		return super.getEsquerda();
	}
	
	public int[] getAtual() {
		return super.getAtual();
	}
}
