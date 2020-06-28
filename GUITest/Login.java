import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class Login extends JPanel implements ILogin{

	private String nomeUsuario;
	private JButton botaoLogin;
	private JPanel painel;
	private CardLayout cl;
	private JTextField campoTexto;
	
	public Login() {
		setLayout(null);
		botaoLogin = new JButton("Login");
		botaoLogin.setSize(200,50);
		botaoLogin.setLocation(260,450);
		botaoLogin.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cl.show(painel,"1");
					nomeUsuario = campoTexto.getText();
					System.out.println(nomeUsuario);
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
		System.out.println("Referencias setadas login");
    }
	
	public String getUsuario() {
		return nomeUsuario;
	}
}
