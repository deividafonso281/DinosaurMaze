import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Aplicacao extends JFrame {

	CardLayout cl = new CardLayout();
        JPanel painel = new JPanel();
        Login login = new Login();
        Menu menu = new Menu();
	TocadorDeMusica tocador = new TocadorDeMusica();
	Opcoes opcoes = new Opcoes();
        LeaderBoard l = new LeaderBoard();
	Loja loja = new Loja();
        Tabuleiro tab  = new Tabuleiro(painel, cl, login, l, menu, loja);
	public Aplicacao () {
		super("Dinosaur Maze");
        	painel.setLayout(cl);
        	menu.setReferencias(painel, cl, tab);
        	login.setReferencias(painel, cl);
        	l.setReferencias(painel, cl, menu);
		loja.setReferencias(painel,cl,menu);
		opcoes.setReferencias(painel,cl,menu,tocador);
        	painel.add(menu, "menu");
        	painel.add(tab, "tab");
        	painel.add(login,"login");
        	painel.add(l, "leaderboard");
		painel.add(opcoes,"opcoes");
		painel.add(loja,"loja");
        	cl.show(painel, "login");
        	addWindowListener(
        		new WindowAdapter() {
                		public void windowClosing(WindowEvent e) {
                        		l.salvaPlacar();
                       			System.exit(0);
                        	}
        	});
       		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        	add(painel);
        	setSize(720,850);
        	setVisible(true);
	}
}
