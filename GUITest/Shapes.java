import java.awt.Graphics;
import javax.swing.JPanel;
import java.awt.Color;

public class Shapes extends JPanel {

	public void paintComponent (Graphics g) {
		super.paintComponent(g);
		int height = getHeight();
		int width = getWidth();
		int xcenter = width/2;
		int ycenter = height/2;
		for (int i=12;i>=1;i--) {
			if (i%2==0) {
				g.setColor(Color.CYAN);
			}
			else {
				g.setColor(Color.MAGENTA);
			}
			g.fillOval(xcenter-10*i,ycenter-10*i,i*20,i*20);
		}
	}
}
