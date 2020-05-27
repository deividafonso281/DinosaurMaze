import java.awt.Graphics;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Meteor  {

        private int posx;
        private int posy;
        private int dirx = 0;
        private int diry = 1;
	private BufferedImage img = null;

        public Meteor (int i, int j) {
                 posx = i;
                 posy = j;
        }

        public void draw (Graphics g) {
                if (dirx==0&&diry==-1) {
			try {
				img = ImageIO.read(new File("onfire_baixo.png"));
			} catch (IOException e){
			}
			g.drawImage(img,(posx-1)*36,80+(posy-1)*36,null); 
		}
		else if (dirx==0&&diry==1) {
                        try {
                                img = ImageIO.read(new File("onfire_cima.png"));
                        } catch (IOException e){
                        }
                        g.drawImage(img,(posx-1)*36,80+(posy-2)*36,null);
                }
		else if (dirx==1&&diry==0) {
                        try {
                                img = ImageIO.read(new File("onfire_esq.png"));
                        } catch (IOException e){
                        }
                        g.drawImage(img,(posx-2)*36,80+(posy-1)*36,null);
                }
		else if (dirx==-1&&diry==0) {
                        try {
                                img = ImageIO.read(new File("onfire_dir.png"));
                        } catch (IOException e){
                        }
                        g.drawImage(img,(posx-1)*36,80+(posy-1)*36,null);
                }
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

	public int[] getRight() {
		int[] position = new int[2];
		if (this.dirx==0&&this.diry==1) {
                        position[0] = posx -2;
                        position[1] = posy-1;
                }       
                else if (this.dirx==-1&&this.diry==0) {
                        position[0] = posx-1;
                        position[1] = posy - 2;
                }       
                else if (this.dirx==0&&this.diry==-1) {
                        position[0] = posx;
                        position[1] = posy-1;
                }       
                else {  
                        position[0] = posx-1;
                        position[1] = posy;
                }
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

	public int[] getLeft() {
		int[] position = new int[2];
		if (this.dirx==0&&this.diry==1) {
                        position[0] = posx;
                        position[1] = posy-1;
                }
                else if (this.dirx==1&&this.diry==0) {
                        position[0] = posx-1;
                        position[1] = posy - 2;
                }
                else if (this.dirx==0&&this.diry==-1) {
                        position[0] = posx - 2;
                        position[1] = posy-1;
                }
                else {
                        position[0] = posx -1;
                        position[1] = posy;
                }
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
	
	public int[] getAtual() {
		int[] position = new int[2];
		position[0] = posx - 1;
		position[1] = posy - 1;
		return position;
	}
}
