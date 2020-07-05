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
import javax.swing.JCheckBox;

public class Opcoes extends JPanel {

	private JPanel painel;
        private CardLayout cl;
        private Menu menu;
        private JButton volta;
        private JLabel titulo;
	private JCheckBox caixa;
        private BufferedImage img;
	private TocadorDeMusica tocador;

        public Opcoes () {
                setLayout(null);
                setImagem();
                titulo = new JLabel("Opcoes");
                titulo.setSize(100,100);
		titulo.setLocation(50,0);
		add(titulo);
		caixa = new JCheckBox("Parar musica");
		caixa.addItemListener((ItemEvent event)->{
			if (caixa.isSelected()) {
				tocador.stop();
			}
			else {
				tocador.play();
			}
		});
		caixa.setSize(400,200);
		caixa.setLocation(290,300);
		add(caixa);
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

        public void setReferencias(JPanel painel, CardLayout cl, Menu menu,TocadorDeMusica tocador) {
                this.painel = painel;
                this.cl = cl;
                this.menu = menu;
		this.tocador = tocador;
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
                g.setColor(new Color(128,128,128));
                g.fillRect(160, 215, 400,400 );
        }
}

