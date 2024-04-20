package Models;

public class No {
	Peca peca;
	No anterior;
	No proximo;

	public No(Peca peca) {
		this.peca = peca;
		this.anterior = null;
		this.proximo = null;
	}
}
