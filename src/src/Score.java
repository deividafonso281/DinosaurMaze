import java.io.Serializable;
import java.math.BigInteger;

public class Score implements Serializable, IScore{

	private BigInteger pontos;
	private String usuario;
		
	public Score(int pontos, String usuario) {
		this.pontos = BigInteger.valueOf(pontos);
		this.usuario = usuario;
	}
	
	public BigInteger getPontuacao() {
		return pontos;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void incrementa() {
		this.pontos = this.pontos.add(BigInteger.valueOf(1));
	}
}