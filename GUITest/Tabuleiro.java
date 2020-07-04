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

public class Tabuleiro extends JPanel implements ITabuleiro {
	
	
	private JPanel painel;
	private CardLayout cl;
	private Login login;
	private Menu menu;
	private Loja loja;
	private LeaderBoard pontuacoesAltas;
	private JLabel tabelaPontuacao = new JLabel();
	private JLabel machado = new JLabel("Machados:");
	private JLabel capacete = new JLabel("Capacetes:");
	private Score pontuacao;
	private Timer timer = new Timer(100,(ActionEvent event)->daUmLoop());
	private Dinosaur max;
	private IMovable[] meteoros = new IMovable[5];
	private Color fundo = new Color(217,200,158);
	private EstadoDoJogo estado;
	private Random aleatorio = new Random();
	private int contador = 0;			
	private String pontTexto;
	private Teclado teclado;
	private boolean noite = false;
	
	public Tabuleiro(JPanel panelCont, CardLayout cardLayout, Login login, LeaderBoard leaderBoard, Menu menu,Loja loja) {
		setLayout(null);
		tabelaPontuacao.setSize(200,20);
		tabelaPontuacao.setLocation(330,0);
		add(tabelaPontuacao);
		machado.setSize(80,20);
		machado.setLocation(22,40);
		add(machado);
		capacete.setSize(80,20);
		capacete.setLocation(330,40);
		add(capacete);
		estado = new EstadoDoJogo();
		setReferencias(panelCont, cardLayout, login, leaderBoard, menu,loja);
		add(tabelaPontuacao);
	}
	

	public void iniciaTempo() {
		this.timer.start();
	}
	
	public  void criaMapa() {		
		for (int i = 0; i < 5; i++) {
			meteoros[i] = new Meteor(2, 2+i);
		}
		max = new Dinosaur(9,9);
		max.setSkin(loja.getSkin());
		teclado = new Teclado(max);
		addKeyListener(teclado);
		pontuacao = new Score(0, login.getUsuario());
		pontTexto = String.format("Pontuacao:" + pontuacao.getPontuacao().toString());
		tabelaPontuacao.setText(pontTexto);
		estado = new EstadoDoJogo();
	}

	public void paintComponent (Graphics g) {
		setBackground(fundo);
		super.paintComponent(g);
		int largura = 720;
                int altura = 720;
                int ritmo = 36;
		for (int i=1;i<=max.getMachado();i++) {
			Machado.draw(g,i);
		}
		for (int i=1;i<=max.getCapacete();i++) {
                        Capacete.draw(g,i);
                }
		if (noite==true) {
			int[] pos = max.getAtual();
			int cantoex = Math.max((pos[0]-1),0);
			int cantoey = Math.max((pos[1]-1),0);
			int cantodx = Math.min((pos[0]+2),20);
			int cantody = Math.min((pos[1]+2),20);
			g.setColor(Color.BLACK);
			g.fillRect(0,80,720,720);
			g.setColor(fundo);
			g.fillRect(cantoex*36,cantoey*36+80,(cantodx-cantoex)*36,(cantody-cantoey)*36);
			g.setColor(Color.BLACK);
			for (int i=cantoex;i<cantodx;i++) {
				for (int j=cantoey;j<cantody;j++) {
					g.drawLine(cantoex*36,80 + j * ritmo, cantodx*36, 80 + j * ritmo);
                                	g.drawLine(i * ritmo, cantoey*36+80, i * ritmo, cantody*36 + 80);
					if (estado.getPeca(i,j).qualObjeto()!='n') {
						estado.getPeca(i,j).setVisivel(true);
						estado.getPeca(i,j).desenha(g);
						estado.getPeca(i,j).setVisivel(false);
					}
				}
			}
			for (int i = 0; i < 5; i++) {
                                meteoros[i].desenha(g);
                        }
                        max.desenha(g);
		} 
		else {
			for (int i = 0; i <= 20; i++) {
				g.drawLine(0,80 + i * ritmo, largura, 80 + i * ritmo);
				g.drawLine(i * ritmo, 80, i * ritmo, altura + 80);
			}
			estado.desenhaEstado(g);
			max.desenha(g);
			for (int i = 0; i < 5; i++) {
				meteoros[i].desenha(g);
			}
		}
	}

	private void atualiza() {
		estado = max.interacao(estado);
		for (int i = 0; i < 20; i++) {
			for (int j = 0; j < 20; j++) {
				if (estado.getPeca(i,j) instanceof Arbusto) {
					((Arbusto) estado.getPeca(i,j)).confere(estado);
				}
				if (estado.getPeca(i,j) instanceof Toquinho) {
					((Toquinho) estado.getPeca(i,j)).confere(estado);
				}
			}
		}
		if (contador == 0) {
			for (int i = 0; i < 5; i++) {
				estado = meteoros[i].interacao(estado);
			}
		}
		contador = (contador + 1) % 2;
		
		//a partir daqui
		//vira noite
		BigInteger x = pontuacao.getPontuacao();
		if (x.intValue() % 150 == 100) {
			anoitecer();
		}
		else if (x.intValue() % 150 == 0) {
			amanhecer();
		}
	}
	
	private void mataMax() {
		boolean vivo = true;
		int[] maxPos = new int[2];
		int[] meteorPos = new int[2];
		maxPos = max.getAtual();
		for (int i = 0; i < 5 && vivo; i++) {
			meteorPos = meteoros[i].getAtual();
			if (meteorPos[0] == maxPos[0] && meteorPos[1] == maxPos[1]) {
				vivo = false;
			}
		}
		if (vivo == false) {
			this.timer.stop();
			String mensagem = String.format("Max morreu.\nSua pontuacao: " + pontuacao.getPontuacao().toString());
			pontuacoesAltas.addScore(pontuacao);
			int escolha = JOptionPane.showConfirmDialog(this, mensagem, "Aviso", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
			menu.startTimer();
			cl.show(painel,"menu");
		}
	}
	
	private void daUmLoop() {
		atualiza();
		repaint();
		if (contador == 1) {
			pontuacao.incrementa();
			pontTexto = String.format("Pontos: " + pontuacao.getPontuacao().toString());
			tabelaPontuacao.setText(pontTexto);
		}
		mataMax();
	}
	
	public void setReferencias(JPanel p, CardLayout c, Login login, LeaderBoard l, Menu menu, Loja loja) {
		this.painel = p;
		this.cl = c;
		this.login = login;
		this.pontuacoesAltas = l;
		this.menu = menu;
		this.loja = loja;
	}

	private void anoitecer() {
		for (int i = 0; i < 20; i++) {
                	for (int j = 0; j < 20; j++) {
                                if(estado.getPeca(i,j).qualObjeto() != 'n')
                                        estado.getPeca(i,j).setVisivel(false);
                	}
        	}
		noite = true;
	}

	private void amanhecer() {
		for (int i = 0; i < 20; i++) {
                	for (int j = 0; j < 20; j++) {
                        	if(estado.getPeca(i,j).qualObjeto() != 'n')
                        		estado.getPeca(i,j).setVisivel(true);
                        }
                }
		noite = false;
	}
}
