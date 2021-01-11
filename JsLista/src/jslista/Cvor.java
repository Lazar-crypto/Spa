package jslista;

public class Cvor {
	
	int podatak;
	Cvor sledeci;

	public Cvor(int podatak,Cvor sledeci) {
		this.podatak = podatak;
		this.sledeci = sledeci;
	}
	
	public Cvor() {
		
	}

}
