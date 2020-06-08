import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.util.Random;
import java.math.BigInteger;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.CardLayout;

public class Tabuleiro extends JPanel implements KeyListener{
	
	
	private JPanel panelCont;
	private CardLayout cl;
	private Login login;
	private LeaderBoard leaderBoard;
	private JLabel scoreBoard = new JLabel();
	private BigInteger score;
	private Timer timer = new Timer(100,new GameLoop(this));
	private Dinosaur max;
	private Meteor[] met = new Meteor[5];
	private Color fundo = new Color(217,200,158);
	private Tree[][] Obstacles = new Tree[20][20];
	private Random aleatorio = new Random();
	private int count = 0;			
	private String textScore;
	private Arbusto arbusto;

	public Tabuleiro() {
		addKeyListener(this);
		setFocusable(true);
		createMap();
		add(scoreBoard);
	}
	

	public void startTimer() {
		this.timer.start();
	}
	
	public  void createMap() {
		arbusto = new Arbusto(2,2);
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
		// Cruz 
		Obstacles[16][3].setObstacle();
		Obstacles[16][2].setObstacle();
		Obstacles[16][4].setObstacle();
		Obstacles[15][3].setObstacle();
		Obstacles[17][3].setObstacle();
		for (int i=0;i<5;i++) {
			met[i] = new Meteor(2,2+i);
		}
		max = new Dinosaur(9,9);
		score = new BigInteger("0");
		textScore = String.format("Score:"+score.toString());
		scoreBoard.setText(textScore);
	}

	public void paintComponent (Graphics g) {
		setBackground(fundo);
		super.paintComponent(g);
		int width = 720;
		int height = 720;
		int pace = 36;
		for (int i=0;i<=20;i++) {
			g.drawLine(0,80+i*pace,width,80+i*pace);
			g.drawLine(i*pace,80,i*pace,height+80);
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
		arbusto.draw(g);
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
	
	public void killMax() {
		boolean alive = true;
		int[] maxpos = new int[2];
		int[] meteorpos = new int[2];
		maxpos = max.getAtual();
		for (int i=0;i<5&&alive;i++) {
			meteorpos = met[i].getAtual();
			if (meteorpos[0]==maxpos[0]&&meteorpos[1]==maxpos[1]) {
				alive = false;
			}
		}
		if (alive == false) {
			this.timer.stop();
			String message = String.format("Max died.\n Your score is: " + score.toString());
			Score pontuation = new Score(score,login.getUsername());
			leaderBoard.addScore(pontuation);
			int choice = JOptionPane.showConfirmDialog(this,message,"Aviso",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
			cl.show(panelCont,"1");
			createMap();
		}
	}
	
	public void doOneLoop() {
		update();
		repaint();
		if (count==1) {
			score = score.add(BigInteger.valueOf(1));
			textScore = String.format("Score: " + score.toString());
			scoreBoard.setText(textScore);
		}
		killMax();
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
	
	public void setReferences(JPanel panelCont, CardLayout cardLayout, Login login, LeaderBoard leaderBoard) {
                this.panelCont = panelCont;
                this.cl = cardLayout;
		this.login = login;
		this.leaderBoard = leaderBoard;
                System.out.println("References setadas Login");
        }
}
