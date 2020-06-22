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
	
	
	private JPanel painel;
	private CardLayout cl;
	private Login login;
	private Menu menu;
	private LeaderBoard pontuacoesAltas;
	private JLabel tabelaPontuacao = new JLabel();
	private JLabel efeito = new JLabel();
	private Score pontuacao;
	private Timer timer = new Timer(100,(ActionEvent event)->daUmLoop());
	private Dinosaur max;
	private Meteor[] met = new Meteor[5];
	private Color fundo = new Color(217,200,158);
	private Cenario[][] Obstaculos = new Cenario[20][20];
	private Random aleatorio = new Random();
	private int contador = 0;			
	private String pontTexto;
	private Teclado teclado;
	private int machado;
	
	public Tabuleiro(JPanel panelCont, CardLayout cardLayout, Login login, LeaderBoard leaderBoard, Menu menu) {
		setReferencias(panelCont, cardLayout, login, leaderBoard, menu);
		criaMapa();
		add(tabelaPontuacao);
		add(efeito);
	}
	

	public void iniciaTempo() {
		this.timer.start();
	}
	
	public  void criaMapa() {
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				Obstaculos[i][j] = new Cenario(i+1,j+1,false);
			}
		}
		for (int i = 0; i < 20; i++) {
			if (i != 9 && i != 10) {
				Obstaculos[i][0] = new Tree(i+1,1);
				Obstaculos[0][i] = new Tree(1,i+1);
				Obstaculos[19][i] = new Tree(20,i+1);
				Obstaculos[i][19] = new Tree(i+1,20);
			}
		}
		for (int i = 8; i < 12; i++) {
			Obstaculos[3][i] = new Tree(4,i+1);
			Obstaculos[16][i] = new Tree(17,i+1);
		}
		for (int i = 6; i < 14; i++) {
			if (i != 9 && i != 10) {
				Obstaculos[6][i] = new Tree(7,i+1);
				Obstaculos[13][i] = new Tree(14,i+1);
			}
		}
		for (int i = 7; i < 13; i++) {
			if (i != 9 && i != 10) {
				Obstaculos[i][6] = new Tree(i+1,7);
				Obstaculos[i][13] = new Tree(i+1,14);
			}
		}
		
		// Cruz 
		Obstaculos[16][3] = new Tree(17,4);
		Obstaculos[16][2] = new Tree(17,3);
		Obstaculos[16][4] = new Tree(17,5);
		Obstaculos[15][3] = new Tree(16,4);
		Obstaculos[17][3] = new Tree(18,4);
		
		for (int i = 0; i < 5; i++) {
			met[i] = new Meteor(2, 2+i);
		}
		
		//Arbustos
		Obstaculos[3][16] = new Arbusto(4, 17);
		Obstaculos[3][3] = new Arbusto(4, 4);
		Obstaculos[3][12] = new Arbusto(4, 13);
		Obstaculos[10][3] = new Arbusto(11, 4);
		Obstaculos[9][3] = new Arbusto(10, 4);
		Obstaculos[16][1] = new Arbusto(17, 2);
		Obstaculos[16][16] = new Arbusto(17, 17);
		Obstaculos[16][7] = new Arbusto(17, 8);
		Obstaculos[9][16] = new Arbusto(10, 17);
		Obstaculos[10][16] = new Arbusto(11, 17);
		
		max = new Dinosaur(9,9);
		teclado = new Teclado(max);
		addKeyListener(teclado);
		pontuacao = new Score(0, login.getUsuario());
		machado = 0;
		pontTexto = String.format("Pontuacao:" + pontuacao.getPontuacao().toString());
		tabelaPontuacao.setText(pontTexto);
		efeito.setText("Sem efeito");
	}

	public void paintComponent (Graphics g) {
		setBackground(fundo);
		super.paintComponent(g);
		int largura = 720;
		int altura = 720;
		int ritmo = 36;
		for (int i = 0; i <= 20; i++) {
			g.drawLine(0,80 + i * ritmo, largura, 80 + i * ritmo);
			g.drawLine(i * ritmo, 80, i * ritmo, altura + 80);
		}
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				Obstaculos[i][j].desenha(g);
			}
		}
		max.draw(g);
		for (int i = 0; i < 5; i++) {
			met[i].desenha(g);
		}
	}

	private void atualiza() {
		int[] veMax = max.getProx();
		String bonus = max.interacao(Obstaculos[veMax[0]][veMax[1]].qualObjeto());
		efeito.setText(bonus);
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (Obstaculos[i][j] instanceof Arbusto) {
					((Arbusto) Obstaculos[i][j]).confere();
				}
			}
		}
		if (contador == 0) {
			for (int i = 0; i < 5; i++) {
				int[] veMeteoro = met[i].getProx();
				if (Obstaculos[veMeteoro[0]][veMeteoro[1]].qualObjeto() != 'a') {
					int[] direita = met[i].getDireita();
                    int[] esquerda = met[i].getEsquerda();
					if(Obstaculos[direita[0]][direita[1]].qualObjeto() != 'a' && Obstaculos[esquerda[0]][esquerda[1]].qualObjeto() != 'a') {
                                		int escolha = aleatorio.nextInt(10) + 1;
                                		if (escolha == 1) {
                                        		met[i].viraDireita();
                                		}
                                		else if (escolha == 2){
                                        		met[i].viraEsquerda();
                                		}
                    }
                    else if (Obstaculos[direita[0]][direita[1]].qualObjeto() != 'a' && Obstaculos[esquerda[0]][esquerda[1]].qualObjeto() == 'a') {
                    	int escolha = aleatorio.nextInt(9) + 1;
                    	if (escolha == 1) {
                    		met[i].viraDireita();
						}
                    }
                    else if (Obstaculos[direita[0]][direita[1]].qualObjeto() == 'a' && Obstaculos[esquerda[0]][esquerda[1]].qualObjeto() != 'a') {
                    	int escolha = aleatorio.nextInt(9) + 1;
                    	if (escolha == 1) {
                    		met[i].viraEsquerda();
						}
                    }
					met[i].move();
				}
				else {
					int[] direita = met[i].getDireita();
					int[] esquerda = met[i].getEsquerda();
					if(Obstaculos[direita[0]][direita[1]].qualObjeto() != 'a' && Obstaculos[esquerda[0]][esquerda[1]].qualObjeto() != 'a') {
						int escolha = aleatorio.nextInt(2) + 1;
						if (escolha == 1) {
							met[i].viraDireita();
						}
						else {
							met[i].viraEsquerda();
						}
					}
					else if (Obstaculos[direita[0]][direita[1]].qualObjeto() != 'a' && Obstaculos[esquerda[0]][esquerda[1]].qualObjeto() == 'a') {
						met[i].viraDireita();
					}
					else if (Obstaculos[direita[0]][direita[1]].qualObjeto() == 'a' && Obstaculos[esquerda[0]][esquerda[1]].qualObjeto() != 'a') {
						met[i].viraEsquerda();
					}
				}
			}
		}
		contador = (contador + 1) % 2;
	}
	
	public void mataMax() {
		boolean vivo = true;
		int[] maxPos = new int[2];
		int[] meteorPos = new int[2];
		maxPos = max.getAtual();
		for (int i = 0; i < 5 && vivo; i++) {
			meteorPos = met[i].getAtual();
			if (meteorPos[0] == maxPos[0] && meteorPos[1] == maxPos[1]) {
				vivo = false;
			}
		}
		if (vivo == false) {
			this.timer.stop();
			String mensagem = String.format("Max morreu.\n Sua pontuacao e: " + pontuacao.getPontuacao().toString());
			pontuacoesAltas.addScore(pontuacao);
			int escolha = JOptionPane.showConfirmDialog(this, mensagem, "Aviso", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			menu.startTimer();
			cl.show(painel,"1");
			criaMapa();
		}
	}
	
	public void daUmLoop() {
		atualiza();
		repaint();
		if (contador == 1) {
			pontuacao.incrementa();
			pontTexto = String.format("Pontos: " + pontuacao.getPontuacao().toString());
			tabelaPontuacao.setText(pontTexto);
		}
		mataMax();
	}
	
	public void setReferencias(JPanel p, CardLayout c, Login login, LeaderBoard l, Menu menu) {
		this.painel = p;
		this.cl = c;
		this.login = login;
		this.pontuacoesAltas = l;
		this.menu = menu;
		System.out.println("Referencias setadas Login");
	}
}