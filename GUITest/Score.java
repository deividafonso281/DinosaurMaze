import java.io.Serializable;
import java.math.BigInteger;

public class Score implements Serializable, IScore{

	private BigInteger pontuacao;
	private String usuario;
		
	public Score(int pontos, String usuario) {
		this.pontuacao = BigInteger.valueOf(pontos);
		this.usuario = usuario;
	}
	
	public BigInteger getPontuacao() {
		return pontuacao;
	}
	
	public String getUsuario() {
		return usuario;
	}

	public void incrementa() {
		this.pontuacao = this.pontuacao.add(BigInteger.valueOf(1));
	}
}