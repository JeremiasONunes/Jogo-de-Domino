package Models;

//Classe Peca
public class Peca {
	private Integer numero1;
	private Integer numero2;

	public Peca(Integer numero1, Integer numero2) {
		this.numero1 = numero1;
		this.numero2 = numero2;
	}

	public int getNumero1() {
		return numero1;
	}

	public void setNumero1(Integer numero1) {
		this.numero1 = numero1;
	}

	public int getNumero2() {
		return numero2;
	}

	public void setNumero2(Integer numero2) {
		this.numero2 = numero2;
	}

	public void girar() {
		int temp = numero1;
		numero1 = numero2;
		numero2 = temp;
	}
}
