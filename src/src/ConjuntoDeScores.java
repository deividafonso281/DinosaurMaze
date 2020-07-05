public class ConjuntoDeScores {

	private ScoreListWritter scoreListWritter;
	private ScoreListReader scoreListReader;
	private ScoreList scoreList;

	public ConjuntoDeScores() {
		scoreListWritter = new ScoreListWritter();
		scoreListReader = new ScoreListReader();
		scoreList = scoreListReader.getListaPlacar();
	}

	public void adicionaScore(IScore novo) {
		scoreList.adicionaPontuacao(novo);
	}
	
	public void salvaPlacares() {
		scoreListWritter.salvaListaPlacar(scoreList);
	}

	public IScore getPlacar(int i) {
		return scoreList.posicoes[i];
	}

	public int getTamanho() {
		return scoreList.tamanho;
	}
}
