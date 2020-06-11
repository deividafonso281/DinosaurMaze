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

public class LeaderBoard extends JPanel {

	private ScoreListWritter scoreListWritter = new ScoreListWritter();
	private ScoreListReader scoreListReader = new ScoreListReader();
	private JPanel panelCont;
	private CardLayout cl;
	private Menu menu;
	private ScoreList scoreList;
	private JButton goBack;
	private JLabel title;
	private JLabel[] scores = new JLabel[15];
	private BufferedImage img;

	public LeaderBoard () {
		setLayout(null);
		setImage();
		title = new JLabel("Best Players");
		title.setSize(620,40);
		title.setLocation(50,0);
		for (int i=0;i<15;i++) {
			scores[i] = new JLabel((i+1) + ".");
			scores[i].setSize(620,30);
			scores[i].setLocation(50,40+i*40);
			add(scores[i]);
		}
		scoreList = scoreListReader.getScoreList();
		update();
		goBack = new JButton("Return");
		goBack.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent event) {
					menu.startTimer();
					cl.show(panelCont,"1");
				}
			}
		);
		goBack.setSize(100,40);
		goBack.setLocation(310,650);
		add(goBack);
	}
	
	public void setReferences(JPanel panelCont, CardLayout cl, Menu menu) {
		this.panelCont = panelCont;
		this.cl = cl;
		this.menu = menu;
	}
	
	public void addScore(Score score) {
		scoreList.addScore(score);
		update();
	}

	public void update() {
		for (int i=0;i<scoreList.length;i++) {
			scores[i].setText((i+1)+"."+scoreList.positions[i].getUsername()+"  " +scoreList.positions[i].getPontuation());
		}
	}
	
	public void saveScores() {
		scoreListWritter.saveScoreList(scoreList);
	}

	private void setImage() {
                try {
                        img = ImageIO.read(new File("menu6.png"));
                } catch (IOException e) {
                }
        }

        @Override
        protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                g.drawImage(img,0,0,null);
		g.setColor(Color.WHITE);
		for (int i=0;i<15;i++) {
                        g.fillRect(50,40+i*40,620,30);
                }
        }
}
