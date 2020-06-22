import java.io.Serializable;

public class ScoreList implements Serializable {

	public Score[] posicoes = new Score[15];
	public Score aux;
	public int capacidade = 15;
	public int tamanho = 0;

	public void adicionaPontuacao(Score novo) {
		int pos = achaPos(novo);
		if (tamanho == 15){
			if (pos != -1) {
				for (int i = pos; i < tamanho; i++) {
					aux = posicoes[i];
					posicoes[i] = novo;
					novo = aux;
				}
			}
		}
		else {
			if (pos == -1) {
				posicoes[tamanho] = novo;
				tamanho++;
			}
			else {
				tamanho++;
				for (int i = pos; i < tamanho; i++) {
					aux = posicoes[i];
					posicoes[i] = novo;
					novo = aux;
				}
			}
		}
	}
	
	public int achaPos(Score novo) {
		for (int i = 0; i < tamanho; i++) {
			if (novo.getPontuacao().compareTo(posicoes[i].getPontuacao()) == 1) {
				return i;
			}
		}
		return -1;
	}
}

