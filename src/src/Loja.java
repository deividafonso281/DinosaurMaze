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
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class Loja extends JPanel {

        private JPanel painel;
        private CardLayout cl;
        private Menu menu;
        private JButton volta;
        private JLabel titulo;
	private JLabel instrucoes;
        private BufferedImage img;
	private BufferedImage skin_classica;
	private BufferedImage skin_padrao;
	private JRadioButton padrao;
	private JRadioButton classico;
	private ButtonGroup skins;
	private String skin;

        public Loja () {
                setLayout(null);
                setImagem();
                titulo = new JLabel("Loja");
                titulo.setSize(100,100);
                titulo.setLocation(50,0);
                add(titulo);
		instrucoes = new JLabel("Escolha sua skin");
		instrucoes.setSize(200,100);
		instrucoes.setLocation(300,200);
		add(instrucoes);
                padrao = new JRadioButton("Padrao", true);
		classico = new JRadioButton("Classico",false);
		padrao.setSize(100,100);
		padrao.setLocation(240,436);
		add(padrao);
		classico.setSize(100,100);
		classico.setLocation(380,436);
		add(classico);
		skins = new ButtonGroup();
		skins.add(classico);
		skins.add(padrao);
		padrao.addItemListener((ItemEvent event)->{
			skin = "";
		});
		classico.addItemListener((ItemEvent event)->{
			skin = "classico";
		});
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

        private void setImagem() {
                try {
                        img = ImageIO.read(new File("menu6.png"));
			skin_classica = ImageIO.read(new File("maxclassico_direita.png"));
			skin_padrao = ImageIO.read(new File("max_direita.png"));
                } catch (IOException e) {
                }
    }

        @Override
        protected void paintComponent (Graphics g) {
                super.paintComponent(g);
                g.drawImage(img, 0, 0, null);
                g.setColor(new Color(128,128,128));
                g.fillRect(160, 215, 400,400 );
		g.drawImage(skin_padrao,260,400,null);
		g.drawImage(skin_classica,400,400,null);
        }
	public String getSkin() {
		return skin;
	}
}
