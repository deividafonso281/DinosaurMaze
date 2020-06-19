import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class Teclado implements KeyListener {

	private Dinosaur max;

	public Teclado(Dinosaur max) {
		this.max = max;
	}
	
	public void keyPressed(KeyEvent event) {
                if (event.getKeyCode()==39) {
                        max.turnRight();
                }
                else if (event.getKeyCode()==37) {
                        max.turnLeft();
                }
                else if (event.getKeyCode()== KeyEvent.VK_D) {
                        max.turnRight();
                }
                else if (event.getKeyCode()== KeyEvent.VK_A) {
                        max.turnLeft();
                }
        }
        public void keyTyped (KeyEvent event) {
                
		if (event.getKeyCode()==39) {
                        max.turnRight();
                }
                else if (event.getKeyCode()==37) {
                        max.turnLeft();
                }
		else if (event.getKeyCode()== KeyEvent.VK_D) {
                        max.turnRight();
                }
                else if (event.getKeyCode()== KeyEvent.VK_A) {
                        max.turnLeft();
                }
        }
        public void keyReleased (KeyEvent event) {
                ;
        }
}
