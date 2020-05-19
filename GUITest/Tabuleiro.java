import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.util.Random;

public class Tabuleiro extends JPanel implements KeyListener{
	
	
	private Timer timer = new Timer(100,new GameLoop(this));
	Dinosaur max = new Dinosaur(9,9);
	Meteor[] met = new Meteor[5];
	Color fundo = new Color(217,200,158);
	private Tree[][] Obstacles = new Tree[20][20];
	Random aleatorio = new Random();
	int count = 0;			

	public Tabuleiro() {
		this.timer.start();
		addKeyListener(this);
		setFocusable(true);
		createMap();
	}
	
	public  void createMap() {
		for (int i=0;i<20;i++) {
                	for (int j=0;j<20;j++) {
                        	Obstacles[i][j] = new Tree(i+1,j+1);
                	}
        	}
		for (int i=0;i<20;i++) {
			if (i!=9&&i!=10) {
				Obstacles[i][0].setObstacle();
				Obstacles[0][i].setObstacle();
				Obstacles[19][i].setObstacle();
				Obstacles[i][19].setObstacle();
			}
		}
		for (int i=8;i<12;i++) {
			Obstacles[3][i].setObstacle();
			Obstacles[16][i].setObstacle();
		}
		for (int i=6;i<14;i++) {
			if (i!=9&&i!=10) {
				Obstacles[6][i].setObstacle();
				Obstacles[13][i].setObstacle();
			}
		}
		for (int i=7;i<13;i++) {
			if (i!=9&&i!=10) {
				Obstacles[i][6].setObstacle();
				Obstacles[i][13].setObstacle();
			}
		}
		for (int i=0;i<5;i++) {
			met[i] = new Meteor(2,2+i);
		}
	}

	public void paintComponent (Graphics g) {
		setBackground(fundo);
		super.paintComponent(g);
		int width = 800;
		int height = 800;
		int pace = 40;
		for (int i=1;i<=20;i++) {
			g.drawLine(0,i*pace,width,i*pace);
			g.drawLine(i*pace,0,i*pace,height);
		}
		for (int i=0;i<20;i++) {
			for (int j=0;j<20;j++) {
				Obstacles[i][j].draw(g);
			}
		}
		max.draw(g);
		for (int i=0;i<5;i++) {
			met[i].draw(g);
		}
	}

	private void update() {
		int[] checkMax = max.getNext();
		if (!Obstacles[checkMax[0]][checkMax[1]].getObstacle()) {
			max.move();
		}
		if (count==0) {
			for (int i=0;i<5;i++) {
				int[] checkMeteor = met[i].getNext();
				if (!Obstacles[checkMeteor[0]][checkMeteor[1]].getObstacle()) {
					int[] right = met[i].getRight();
                        		int[] left = met[i].getLeft();
					if(!Obstacles[right[0]][right[1]].getObstacle()&&!Obstacles[left[0]][left[1]].getObstacle()) {
                                		int choice = aleatorio.nextInt(10) + 1;
                                		if (choice == 1) {
                                        		met[i].turnRight();
                                		}
                                		else if (choice == 2){
                                        		met[i].turnLeft();
                                		}
                        		}
                        		else if (!Obstacles[right[0]][right[1]].getObstacle()&&Obstacles[left[0]][left[1]].getObstacle()) {
                                		int choice = aleatorio.nextInt(9) + 1;
                                		if (choice == 1) {
							met[i].turnRight();
						}
                        		}
                        		else if (Obstacles[right[0]][right[1]].getObstacle()&&!Obstacles[left[0]][left[1]].getObstacle()) {
                                		int choice = aleatorio.nextInt(9) + 1;
                                		if (choice == 1) {
							met[i].turnLeft();
						}
                        		}
					met[i].move();
				}
				else {
					int[] right = met[i].getRight();
					int[] left = met[i].getLeft();
					if(!Obstacles[right[0]][right[1]].getObstacle()&&!Obstacles[left[0]][left[1]].getObstacle()) {
						int choice = aleatorio.nextInt(2) + 1;
						if (choice == 1) {
							met[i].turnRight();
						}
						else {
							met[i].turnLeft();
						}
					}
					else if (!Obstacles[right[0]][right[1]].getObstacle()&&Obstacles[left[0]][left[1]].getObstacle()) {
                                		met[i].turnRight();
                        		}
					else if (Obstacles[right[0]][right[1]].getObstacle()&&!Obstacles[left[0]][left[1]].getObstacle()) {
                                		met[i].turnLeft();
                        		}
				}
			}
		}
		count = (count+1)%2;
	}
	
	public void doOneLoop() {
		update();
		repaint();
		//System.out.printf("Dirx: %d Diry: %d Posx: %d Posy: %d\n", max.dirx, max.diry, max.posx, max.posy);
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
		if (event.getKeyCode()== KeyEvent.VK_D) {
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
