import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.util.Random;
import java.math.BigInteger;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import java.awt.CardLayout;

public class Tabuleiro extends JPanel {
	
	
	private JPanel panelCont;
	private CardLayout cl;
	private Login login;
	private Menu menu;
	private LeaderBoard leaderBoard;
	private JLabel scoreBoard = new JLabel();
	private Score pontuation;
	private Timer timer = new Timer(100,(ActionEvent event)->doOneLoop());
	private Dinosaur max;
	private Meteor[] met = new Meteor[5];
	private Color fundo = new Color(217,200,158);
	private Cenario[][] Obstacles = new Cenario[20][20];
	private Random aleatorio = new Random();
	private int count = 0;			
	private String textScore;
	private Teclado teclado;
	
	public Tabuleiro(JPanel panelCont, CardLayout cardLayout, Login login, LeaderBoard leaderBoard, Menu menu) {
		setReferences(panelCont, cardLayout, login, leaderBoard, menu);
		createMap();
		add(scoreBoard);
	}
	

	public void startTimer() {
		this.timer.start();
	}
	
	public  void createMap() {
		for (int i=0;i<20;i++) {
                	for (int j=0;j<20;j++) {
                        	Obstacles[i][j] = new Cenario(i+1,j+1,false,false);
                	}
        	}
		for (int i=0;i<20;i++) {
			if (i!=9&&i!=10) {
				Obstacles[i][0] = new Tree(i+1,1);
				Obstacles[0][i] = new Tree(1,i+1);
				Obstacles[19][i] = new Tree(20,i+1);
				Obstacles[i][19] = new Tree(i+1,20);
			}
		}
		for (int i=8;i<12;i++) {
			Obstacles[3][i] = new Tree(4,i+1);
			Obstacles[16][i] = new Tree(17,i+1);
		}
		for (int i=6;i<14;i++) {
			if (i!=9&&i!=10) {
				Obstacles[6][i] = new Tree(7,i+1);
				Obstacles[13][i] = new Tree(14,i+1);
			}
		}
		for (int i=7;i<13;i++) {
			if (i!=9&&i!=10) {
				Obstacles[i][6] = new Tree(i+1,7);
				Obstacles[i][13] = new Tree(i+1,14);
			}
		}
		// Cruz 
		Obstacles[16][3] = new Tree(17,4);
		Obstacles[16][2] = new Tree(17,3);
		Obstacles[16][4] = new Tree(17,5);
		Obstacles[15][3] = new Tree(16,4);
		Obstacles[17][3] = new Tree(18,4);
		for (int i=0;i<5;i++) {
			met[i] = new Meteor(2,2+i);
		}
		max = new Dinosaur(9,9);
		teclado = new Teclado(max);
		addKeyListener(teclado);
		pontuation = new Score(0,login.getUsername());
		textScore = String.format("Score:"+pontuation.getPontuation().toString());
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
				if (Obstacles[i][j].getVisible()==true && ((Obstacles[i][j] instanceof Tree)||(Obstacles[i][j] instanceof Arbusto))) {
					Obstacles[i][j].draw(g);
				}
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
			String message = String.format("Max died.\n Your score is: " + pontuation.getPontuation().toString());
			leaderBoard.addScore(pontuation);
			int choice = JOptionPane.showConfirmDialog(this,message,"Aviso",JOptionPane.OK_CANCEL_OPTION,JOptionPane.PLAIN_MESSAGE);
			menu.startTimer();
			cl.show(panelCont,"1");
			createMap();
		}
	}
	
	public void doOneLoop() {
		update();
		repaint();
		if (count==1) {
			pontuation.increment();
			textScore = String.format("Score: " + pontuation.getPontuation().toString());
			scoreBoard.setText(textScore);
		}
		killMax();
	}
	
	public void setReferences(JPanel panelCont, CardLayout cardLayout, Login login, LeaderBoard leaderBoard, Menu menu) {
                this.panelCont = panelCont;
                this.cl = cardLayout;
		this.login = login;
		this.leaderBoard = leaderBoard;
		this.menu = menu;
                System.out.println("References setadas Login");
        }
}
