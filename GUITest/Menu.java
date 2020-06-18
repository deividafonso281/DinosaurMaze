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

	private JPanel panelCont;
	private Tabuleiro tabuleiro;
	private JButton buttonJogar;
	private JButton buttonOptions;
	private JButton buttonScoreBoard;
	private JButton buttonLoja;
	private CardLayout cl;
	private BufferedImage img;
	private Timer timer;
	private int counter = 1;
		
	public Menu() {
		setLayout(null);
		setImage(1);
		buttonJogar = new JButton("Play");
		buttonJogar.setSize(200,50);
		buttonJogar.setLocation(260,300);
		add(buttonJogar);
		buttonJogar.addActionListener(
			(ActionEvent event)->{
					timer.stop();
					cl.show(panelCont, "2");
					tabuleiro.requestFocus();
					tabuleiro.startTimer();
			}
		);
		buttonScoreBoard = new JButton("ScoreBoard");
		buttonScoreBoard.setSize(200,50);
		buttonScoreBoard.setLocation(260,400);
		add(buttonScoreBoard);
		buttonScoreBoard.addActionListener(
			(ActionEvent event)->{
					timer.stop();
					cl.show(panelCont, "3");
			}
		);
		buttonLoja = new JButton("Store");
		buttonLoja.setSize(200,50);
		buttonLoja.setLocation(260,500);
		add(buttonLoja);
		buttonLoja.addActionListener (
			(ActionEvent event)->{
					JOptionPane.showMessageDialog(Menu.this,"Loja temporariamente indisponivel\nVolte mais tarde para adquirir novas skins");
			}
		);
		buttonOptions = new JButton("Options");
		buttonOptions.setSize(200,50);
		buttonOptions.setLocation(260,600);
		add(buttonOptions);
		buttonOptions.addActionListener(
			(ActionEvent event)->{
					JOptionPane.showMessageDialog(Menu.this,"Em breve novas features");
			}
		);
		timer = new Timer(150,(ActionEvent event)-> {
			this.counter++;
			if (counter==6) {
				Timer timer = (Timer) event.getSource();
				counter = 1;
				timer.stop();
				Menu.this.startTimer();
			}
			setImage(counter);
			repaint();
		});
		timer.start();
	}
	
	public void setReferences(JPanel panelCont, CardLayout cardLayout, Tabuleiro tabuleiro) {
		this.panelCont = panelCont;
		this.cl = cardLayout;
		this.tabuleiro = tabuleiro;
		System.out.println("References setadas");
	}
	
	private void setImage(int i) {
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
