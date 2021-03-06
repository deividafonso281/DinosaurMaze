import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.CardLayout;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import java.awt.Graphics;
import java.awt.Color;

public class LeaderBoard extends JPanel implements IPlacares{

	private ConjuntoDeScores conjuntoDeScores;
	private JPanel painel;
	private CardLayout cl;
	private Menu menu;
	private JButton volta;
	private JLabel titulo;
	private JLabel[] placares = new JLabel[15];
	private BufferedImage img;

	public LeaderBoard () {
		setLayout(null);
		setImagem();
		titulo = new JLabel("Melhores jogadores");
		titulo.setSize(620,40);
		titulo.setLocation(50,0);
		add(titulo);
		for (int i = 0; i < 15; i++) {
			placares[i] = new JLabel((i+1) + ".");
			placares[i].setSize(620,30);
			placares[i].setLocation(50,40+i*40);
			add(placares[i]);
		}
		conjuntoDeScores = new ConjuntoDeScores();
		atualiza();
		volta = new JButton("Voltar");
		volta.addActionListener(
			(ActionEvent event)->{
					menu.startTimer();
					cl.show(painel,"menu");
			}
		);
		volta.setSize(100,40);
		volta.setLocation(310,650);
		add(volta);
	}
	
	public void setReferencias(JPanel painel, CardLayout cl, Menu menu) {
		this.painel = painel;
		this.cl = cl;
		this.menu = menu;
	}
	
	public void addScore(IScore placar) {
		conjuntoDeScores.adicionaScore(placar);
		atualiza();
	}

	public void atualiza() {
		for (int i = 0; i < conjuntoDeScores.getTamanho(); i++) {
			placares[i].setText((i+1) + "." + conjuntoDeScores.getPlacar(i).getUsuario() + "  " + conjuntoDeScores.getPlacar(i).getPontuacao());
		}
	}
	
	public void salvaPlacar() {
		conjuntoDeScores.salvaPlacares();
	}

	private void setImagem() {
		try {
			img = ImageIO.read(new File("menu6.png"));
		} catch (IOException e) {
		}
    }

	@Override
	protected void paintComponent (Graphics g) {
		super.paintComponent(g);
		g.drawImage(img, 0, 0, null);
		g.setColor(Color.WHITE);
		for (int i = 0; i < 15; i++) {
			g.fillRect(50, 40 + i * 40, 620, 30);
		}
        }
}
