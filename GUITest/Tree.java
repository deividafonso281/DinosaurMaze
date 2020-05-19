import java.awt.Graphics;
import java.awt.Color;

public class Tree  {

        int size = 36;
        public int posx;
        public int posy;
	public boolean isObstacle;

        public Tree (int i, int j) {
                 posx = i;
                 posy = j;
		 isObstacle = false;
        }

        public void draw (Graphics g) {
		if (isObstacle == true) {
                	g.setColor(Color.RED);
                	g.fillOval((posx-1)*40+2,(posy-1)*40+2,size,size);
        	}
	}

	public void setObstacle () {
		isObstacle = true;
	}
	public boolean getObstacle() {
		return isObstacle;
	}
}
