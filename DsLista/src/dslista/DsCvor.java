package dslista;
public class DsCvor {

	int podatak;
	DsCvor sledeci;
	DsCvor prethodni;
	
	public DsCvor(int podatak,DsCvor sledeci,DsCvor prethodni) {
		this.podatak = podatak;
		this.sledeci = sledeci;
		this.prethodni = prethodni;
	}

	public DsCvor() {
		
	}
}
