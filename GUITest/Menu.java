import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.CardLayout;
import javax.swing.JOptionPane;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.swing.Timer;

public class Menu extends JPanel {

	private JPanel painel;
	private Tabuleiro tabuleiro;
	private JButton botaoJogar;
	private JButton botaoOpcoes;
	private JButton botaoPontuacoes;
	private JButton botaoLoja;
	private JButton botaoInstrucao;
	private CardLayout cl;
	private BufferedImage img;
	private Timer timer;
	private int contador = 1;
		
	public Menu() {
		setLayout(null);
		setImagem(1);
		botaoJogar = new JButton("Jogar");
		botaoJogar.setSize(200,50);
		botaoJogar.setLocation(260,300);
		add(botaoJogar);
		botaoJogar.addActionListener(
			(ActionEvent evento)->{
					timer.stop();
					tabuleiro.criaMapa();
					cl.show(painel, "2");
					tabuleiro.requestFocus();
					tabuleiro.iniciaTempo();
			}
		);
		botaoPontuacoes = new JButton("Maiores pontuacoes");
		botaoPontuacoes.setSize(200,50);
		botaoPontuacoes.setLocation(260,400);
		add(botaoPontuacoes);
		botaoPontuacoes.addActionListener(
			(ActionEvent event)->{
					timer.stop();
					cl.show(painel, "3");
			}
		);
		botaoLoja = new JButton("Loja");
		botaoLoja.setSize(200,50);
		botaoLoja.setLocation(260,500);
		add(botaoLoja);
		botaoLoja.addActionListener (
			(ActionEvent event)->{
					JOptionPane.showMessageDialog(Menu.this,"Loja temporariamente indisponivel\nVolte mais tarde para adquirir novas skins");
			}
		);
		botaoOpcoes = new JButton("Opcoes");
		botaoOpcoes.setSize(200,50);
		botaoOpcoes.setLocation(260,600);
		add(botaoOpcoes);
		botaoOpcoes.addActionListener(
			(ActionEvent event)->{
					JOptionPane.showMessageDialog(Menu.this,"Em breve novas features");
			}
		);
		
		botaoInstrucao = new JButton("Instrucoes");
		botaoInstrucao.setSize(200,50);
		botaoInstrucao.setLocation(260,700);
		add(botaoInstrucao);
		/*botaoPontuacoes.addActionListener(
			(ActionEvent event)->{
					timer.stop();
					cl.show(painel, "4");
			}
		);*/
		
		timer = new Timer(150,(ActionEvent evento)-> {
			this.contador++;
			if (contador == 6) {
				Timer timer = (Timer) evento.getSource();
				contador = 1;
				timer.stop();
				Menu.this.startTimer();
			}
			setImagem(contador);
			repaint();
		});
		timer.start();
	}
	
	public void setReferencias(JPanel p, CardLayout c, Tabuleiro tabuleiro) {
		this.painel = p;
		this.cl = c;
		this.tabuleiro = tabuleiro;
		System.out.println("Referencias setadas");
	}
	
	private void setImagem(int i) {
		try {
			img = ImageIO.read(new File("menu"+i+".png"));
		} catch (IOException e) {
		}
	}
	
	@Override	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.drawImage(img,0,0,null);
	}

	public void startTimer() {
		this.timer.setInitialDelay(5000);
		this.timer.start();
	}
}