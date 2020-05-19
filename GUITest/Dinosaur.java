import java.awt.Graphics;
import java.awt.Color;

public class Dinosaur  {

	int size = 36;
	public int posx;
	public int posy;
	public int dirx = 0;
	public int diry = 1;
	
	public Dinosaur (int i, int j) {
	 	 posx = i;
		 posy = j;
	}
	
	public void draw (Graphics g) {
		g.setColor(Color.GREEN);
		g.fillOval((posx-1)*40+2,(posy-1)*40+2,size,size);
		g.setColor(Color.BLACK);
		g.fillOval((posx-1)*40+10,(posy-1)*40+7,6,6);
		g.fillOval((posx-1)*40+25,(posy-1)*40+7,6,6);
		g.fillOval((posx-1)*40+15,(posy-1)*40+15,10,10);
		g.setColor(Color.GREEN);
		g.fillRect((posx-1)*40+15,(posy-1)*40+15,10,5);
	}
	
	public void move() {
		this.posx += dirx;
		if (this.posx>20) {
			this.posx = 1;
		}
		if (this.posx<1) {
			this.posx= 20;
		}
		this.posy += diry;
		if (this.posy>20) {
			this.posy = 1;
		}
		if (this.posy<1) {
			this.posy = 20;
		}
	}
	
	public void turnRight() {
		if (this.dirx==0&&this.diry==1) {
			this.dirx = -1;
			this.diry = 0;
		}
		else if (this.dirx==-1&&this.diry==0) {
			this.dirx = 0;
			this.diry = -1; 
		}
		else if (this.dirx==0&&this.diry==-1) {
			this.dirx = 1;
			this.diry = 0;
		}
		else {
			this.dirx = 0;
			this.diry = 1;
		}
	}

	public void turnLeft() {
		if (this.dirx==0&&this.diry==1) {
                        this.dirx = 1;
                        this.diry = 0;
                }
                else if (this.dirx==1&&this.diry==0) {
                        this.dirx = 0;
                        this.diry = -1;
                }
                else if (this.dirx==0&&this.diry==-1) {
                        this.dirx = -1;
                        this.diry = 0;
                }
                else {
                        this.dirx = 0;
                        this.diry = 1;
                }
	}
	
	public int[] getNext() {
		int[] position = new int[2];
		position[0] = (posx-1)+dirx;
		position[1] = (posy-1)+diry;
		if  (position[0]<0) {
			position[0]=19;
		}
		if (position[0]>19) {
			position[0] = 0;
		}
		if (position[1]<0) {
			position[1] = 19;
		}
		if (position[1]>19) {
			position[1] = 0;
		}
		return position;
	}
}
