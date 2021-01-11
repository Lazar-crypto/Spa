package liste;

public class Lista {

	private Cvor glava ;
	
	public void ubaciNaPocetak(int podatak) {
		//bez konstruktora
//		Cvor novi = new Cvor();
//		novi.podatak = podatak;
//		novi.sledeci = glava;
//		glava = novi;
	
		//sa konstruktorom mnogo kul,prvo odradi desnu stranu pa onda dodeli levoj
		glava = new Cvor(podatak, glava);
	}
	
	public void ubaciNaKraj(int podatak) {
		
		//ako je lista prazna ubacujemo ga na prvo mesto
		if(glava == null) ubaciNaPocetak(podatak);
		else {
			Cvor novi = new Cvor(podatak,null);	
			Cvor pom = glava;
			
			while(pom.sledeci != null) {
				pom = pom.sledeci;
			}
			pom.sledeci = novi;
		}
		
	}
	
	public int izbaciSaPrvogMesta() throws Exception {
		int vratiElement;
		if(glava == null) throw new Exception("Lista je prazna!");
		else {
			 vratiElement = glava.podatak;
			glava = glava.sledeci;
		}
		return vratiElement;
	}
	
	public int izbaciSaKraja() throws Exception {
		
		int vratiElement;
		//3 slucaja
		//lista prazna
		if(glava == null) throw new Exception("Lista je prazna!");
		//jedan element
		else if(glava.sledeci == null) {
			vratiElement = glava.podatak;
			glava = null;
		}
		//vise elemenata
		else {
			Cvor pom = glava;
			while(pom.sledeci.sledeci != null) {
				pom = pom.sledeci;
			}
			vratiElement = pom.sledeci.podatak;
			pom.sledeci = null;
			
		}
	
		return vratiElement;
	}
	
	public void ubaciNaPoziciju(int pozicija,int podatak) throws Exception {
		
		if(pozicija == 1) ubaciNaPocetak(podatak);
		else {
			Cvor pom = glava;
			int poz = 1;
			while(poz != pozicija - 1) {
				pom = pom.sledeci;
				poz ++;
			}
		//prvo bez konstruktora
//			Cvor novi = new Cvor(podatak,pom.sledeci);
//			novi.podatak = podatak;
//			novi.sledeci = pom.sledeci;
//			pom.sledeci = novi;
			Cvor novi = new Cvor(podatak,pom.sledeci);
			pom.sledeci = novi;
		}
		
		
	}
	
	public void ispisiListu() {
		Cvor pom = glava;
		System.out.println("Lista: ");
		while(pom != null) {
			System.out.println("Podatak: "+ pom.podatak);
			pom = pom.sledeci;
		}
	}

	public static void main(String[] args) {
		Lista lista = new Lista();
		lista.ubaciNaPocetak(5);
		lista.ubaciNaPocetak(4);
		
		lista.ubaciNaKraj(6);
		lista.ubaciNaKraj(7);
		lista.ubaciNaPocetak(3);
		
		lista.ispisiListu();
		
		try {
			System.out.println("Izbacen je podatak: " + lista.izbaciSaPrvogMesta());
			lista.ispisiListu();
			System.out.println("Izbacen je podatak: " + lista.izbaciSaKraja());
			lista.ispisiListu();
			lista.ubaciNaPoziciju(1, 3);
			lista.ispisiListu();
			lista.ubaciNaPoziciju(5, 7);
			lista.ispisiListu();

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	
		



	
	}
}
