import java.awt.Graphics;

public class EstadoDoJogo {

	private ICenario[][] Obstaculos;
	
	public EstadoDoJogo() {
		Obstaculos = new ICenario[20][20];
		for (int i = 0; i < 20; i++) {
                        for (int j = 0; j < 20; j++) {
                                Obstaculos[i][j] = new Cenario(i+1,j+1,false);
                        }
                }
                for (int i = 0; i < 20; i++) {
                        if (i != 9 && i != 10) {
                                Obstaculos[i][0] = new Tree(i+1,1);
                                Obstaculos[0][i] = new Tree(1,i+1);
                                Obstaculos[19][i] = new Tree(20,i+1);
                                Obstaculos[i][19] = new Tree(i+1,20);
                        }
                }
                for (int i = 8; i < 12; i++) {
                        Obstaculos[3][i] = new Tree(4,i+1);
                        Obstaculos[16][i] = new Tree(17,i+1);
                }
                for (int i = 6; i < 14; i++) {
                        if (i != 9 && i != 10) {
                                Obstaculos[6][i] = new Tree(7,i+1);
                                Obstaculos[13][i] = new Tree(14,i+1);
                        }
                }
                for (int i = 7; i < 13; i++) {
                        if (i != 9 && i != 10) {
                                Obstaculos[i][6] = new Tree(i+1,7);
                                Obstaculos[i][13] = new Tree(i+1,14);
                        }
                }

                // Cruz
                Obstaculos[16][3] = new Tree(17,4);
                Obstaculos[16][2] = new Tree(17,3);
                Obstaculos[16][4] = new Tree(17,5);
                Obstaculos[15][3] = new Tree(16,4);
                Obstaculos[17][3] = new Tree(18,4);

		//Arbustos
                Obstaculos[3][16] = new Arbusto(4, 17);
                Obstaculos[3][3] = new Arbusto(4, 4);
                Obstaculos[3][12] = new Arbusto(4, 13);
                Obstaculos[10][3] = new Arbusto(11, 4);
                Obstaculos[9][3] = new Arbusto(10, 4);
                Obstaculos[16][1] = new Arbusto(17, 2);
                Obstaculos[16][16] = new Arbusto(17, 17);
                Obstaculos[16][7] = new Arbusto(17, 8);
                Obstaculos[9][16] = new Arbusto(10, 17);
                Obstaculos[10][16] = new Arbusto(11, 17);
	}

	public void desenhaEstado(Graphics g) {
		for (int i=0;i<20;i++) {
			for (int j=0;j<20;j++) {
				desenhaPeca(g,i,j);
			}
		}
	}

	public ICenario getPeca (int i,int j) {
		return Obstaculos[i][j];
	}
	
	public void setPeca (int i, int j, ICenario peca) {
		Obstaculos[i][j] = peca;
	}

	public void desenhaPeca(Graphics g, int i, int j) {
		getPeca(i,j).desenha(g);
	}
}
