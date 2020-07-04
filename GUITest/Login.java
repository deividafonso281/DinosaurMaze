import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;

public class Login extends JPanel implements ILogin{

	private String nomeUsuario;
	private JButton botaoLogin;
	private JPanel painel;
	private CardLayout cl;
	private JTextField campoTexto;
	private BufferedImage img;
	
	public Login() {
		setLayout(null);
		setImagem();
		botaoLogin = new JButton("Login");
		botaoLogin.setSize(200,50);
		botaoLogin.setLocation(260,450);
		botaoLogin.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cl.show(painel,"menu");
					nomeUsuario = campoTexto.getText();
				}	
			}	
		);
		add(botaoLogin);
		campoTexto = new JTextField("Digite o nome do usuario");
		campoTexto.setSize(400,50);
		campoTexto.setLocation(160,350);
		add(campoTexto);
	}
	
	public void setReferencias(JPanel p, CardLayout c) {
		this.painel = p;
		this.cl = c;
        }
	
	public String getUsuario() {
		return nomeUsuario;
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
	}
}
