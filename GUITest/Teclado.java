import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Teclado implements KeyListener {

	private Dinosaur max;

	public Teclado(Dinosaur max) {
		this.max = max;
	}
	
	public void keyPressed (KeyEvent evento) {
		if (evento.getKeyCode() == 39) {
			max.viraDireita();
		}
		else if (evento.getKeyCode() == 37) {
			max.viraEsquerda();
		}
		else if (evento.getKeyCode()== KeyEvent.VK_D) {
			max.viraDireita();
		}
		else if (evento.getKeyCode()== KeyEvent.VK_A) {
			max.viraEsquerda();
		}
	}
	public void keyTyped (KeyEvent evento) {
		
		if (evento.getKeyCode() == 39) {
			max.viraDireita();
		}
		else if (evento.getKeyCode() == 37) {
			max.viraEsquerda();
		}
		else if (evento.getKeyCode() == KeyEvent.VK_D) {
			max.viraDireita();
		}
		else if (evento.getKeyCode() == KeyEvent.VK_A) {
			max.viraEsquerda();
		}
	}
	public void keyReleased (KeyEvent event) {
		;
    }
}