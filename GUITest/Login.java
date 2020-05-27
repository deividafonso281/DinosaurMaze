import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;

public class Login extends JPanel{

	private String userName;
	private JButton buttonLogin;
	private JPanel panelCont;
	private CardLayout cl;
	private JTextField textField;
	
	public Login() {
		setLayout(null);
		buttonLogin = new JButton("Login");
		buttonLogin.setSize(200,50);
		buttonLogin.setLocation(260,450);
		buttonLogin.addActionListener(
			new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					cl.show(panelCont,"1");
					userName = textField.getText();
					System.out.println(userName);
				}	
			}	
		);
		add(buttonLogin);
		textField = new JTextField("Input your username");
		textField.setSize(400,50);
		textField.setLocation(160,350);
		add(textField);
	}
	
	public void setReferences(JPanel panelCont, CardLayout cardLayout) {
                this.panelCont = panelCont;
                this.cl = cardLayout;
                System.out.println("References setadas login");
        }
	
	public String getUsername() {
		return userName;
	}
}
