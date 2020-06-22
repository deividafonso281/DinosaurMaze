public abstract class PMovimento implements IMovable {
	
	public int posx;
    public int posy;
    public int dirx = 0;
    public int diry = 1;
	
	public PMovimento (int i, int j) {
                posx = i;
                posy = j;
    }	

	public void move() {
                this.posx += dirx;
                if (this.posx > 20) {
                	this.posx = 1;
                }
                if (this.posx < 1) {
                    this.posx= 20;
                }
                this.posy += diry;
                if (this.posy > 20) {
                    this.posy = 1;
                }
                if (this.posy < 1) {
                    this.posy = 20;
                }
	}

    public void viraDireita() {
    	if (this.dirx == 0 && this.diry == 1) {
    		this.dirx = -1;
            this.diry = 0;
        }
        else if (this.dirx == -1 && this.diry == 0) {
        	this.dirx = 0;
            this.diry = -1;
        }
        else if (this.dirx == 0 && this.diry == -1) {
        	this.dirx = 1;
            this.diry = 0;
        }
        else {
        	this.dirx = 0;
            this.diry = 1;
        }
    }

    public void viraEsquerda() {
    	if (this.dirx == 0 && this.diry == 1) {
    		this.dirx = 1;
    		this.diry = 0;
    	}
    	else if (this.dirx == 1&& this.diry == 0) {
    		this.dirx = 0;
    		this.diry = -1;
    	}
    	else if (this.dirx == 0 && this.diry == -1) {
    		this.dirx = -1;
    		this.diry = 0;
    	}
    	else {
    		this.dirx = 0;
    		this.diry = 1;
    	}
    }
	
	public int[] getProx() {
		int[] posicao = new int[2];
		posicao[0] = (posx - 1) + dirx;
		posicao[1] = (posy - 1) + diry;
		if  (posicao[0] < 0) {
			posicao[0] = 19;
		}
		if (posicao[0] > 19) {
			posicao[0] = 0;
		}
		if (posicao[1] < 0) {
			posicao[1] = 19;
		}
		if (posicao[1]>19) {
			posicao[1] = 0;
		}
		return posicao;
	}

	public int[] getDireita() {
		
		int[] posicao = new int[2];
        if (this.dirx == 0 && this.diry == 1) {
        	posicao[0] = posx -2;
            posicao[1] = posy-1;
        }
        else if (this.dirx == -1 && this.diry == 0) {
            posicao[0] = posx-1;
            posicao[1] = posy - 2;
        }
        else if (this.dirx == 0 && this.diry == -1) {
        	posicao[0] = posx;
            posicao[1] = posy - 1;
        }
        else {
        	posicao[0] = posx - 1;
            posicao[1] = posy;
        }
        if  (posicao[0] < 0) {
        	posicao[0] = 19;
        }
        if (posicao[0] > 19) {
        	posicao[0] = 0;
        }
        if (posicao[1] < 0) {
        	posicao[1] = 19;
        }
        if (posicao[1] > 19) {
        	posicao[1] = 0;
        }
    
        return posicao;
	}

	public int[] getEsquerda() {
		
		int[] posicao = new int[2];
		
		if (this.dirx == 0 && this.diry == 1) {
			posicao[0] = posx;
			posicao[1] = posy - 1;
		}
		else if (this.dirx == 1 && this.diry == 0) {
			posicao[0] = posx - 1;
			posicao[1] = posy - 2;
		}
		else if (this.dirx == 0 && this.diry == -1) {
			posicao[0] = posx - 2;
			posicao[1] = posy - 1;
		}
		else {
			posicao[0] = posx - 1;
			posicao[1] = posy;
		}
		if  (posicao[0] < 0) {
			posicao[0] = 19;
		}
		if (posicao[0] > 19) {
			posicao[0] = 0;
		}
		if (posicao[1] < 0) {
			posicao[1] = 19;
		}
		if (posicao[1] > 19) {
			posicao[1] = 0;
		}
		
		return posicao;
	}

	public int[] getAtual() {
		int[] posicao = new int[2];
		posicao[0] = posx - 1;
		posicao[1] = posy - 1;
		return posicao;
	}	
}
