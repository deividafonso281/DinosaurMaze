import javax.swing.JOptionPane;

public class NameDialog {

	public static void main (String[] args) {

		String name = JOptionPane.showInputDialog("What is your name mate ?");
		String message = String.format("Welcome my friend %s", name);
		JOptionPane.showMessageDialog(null, message);
	}
}
