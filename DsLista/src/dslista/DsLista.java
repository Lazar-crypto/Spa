
//Kada prevezujes cvorove uvek prvo gledaj na prethodni

package dslista;
public class DsLista {

	DsCvor prvi;
	
	public void ubaciNaPocetak(int podatak) {
//		DsCvor novi = new DsCvor();
//		novi.podatak = podatak;
//		novi.sledeci = prvi;
//		novi.prethodni = null;
//		prvi.prethodni = novi
//		prvi = novi
		
		prvi = new DsCvor(podatak, prvi, null);
		if(prvi.sledeci != null) {
			prvi.sledeci.prethodni = prvi;
			return;
		}
			
	}

	public void ubaciNaKraj(int podatak) {
		if(prvi == null) {
			ubaciNaPocetak(podatak);
			return;
		}
		
		DsCvor pom = prvi;
		while(pom.sledeci != null) {
			pom = pom.sledeci;
		}
		DsCvor novi = new DsCvor(podatak, null, pom);
		pom.sledeci = novi;
	}

	public void ispisiListu() {
		if(prvi == null) {
			System.out.println("Lista je prazna");
			return;
		}
		
		DsCvor pom = prvi;
		while(pom != null) {
			System.out.println(pom.podatak + " ");
			pom = pom.sledeci;
		}
		System.out.println();
	}

	public void ispisiListuUnazad() {
		if(prvi == null) {
			System.out.println("Lista je prazna");
			return;
		}
		DsCvor pom = prvi;
		while(pom.sledeci != null) {
			pom = pom.sledeci;
		}
		while(pom != null) {
			System.out.println(pom.podatak + " ");
			pom = pom.prethodni;
		}
		System.out.println();
	}
	public int izbaciSaPocetka() {
		if(prvi == null) throw new RuntimeException("Nema sta da se izbaci,lista prazna");
		int vratiPodatak = prvi.podatak;
		prvi.sledeci.prethodni = null;		//bitno
		prvi = prvi.sledeci;
		return vratiPodatak;
	}
	public int izbaciSaKraja() {
		if(prvi == null) throw new RuntimeException("Nema sta da se izbaci,lista prazna");
		if(prvi.sledeci == null) {
			int vratiPodattak = izbaciSaPocetka();
			return vratiPodattak;
		}
		DsCvor pom = prvi;
		while(pom.sledeci.sledeci != null) {
			pom = pom.sledeci;
		}
		int vratiPodatak = pom.sledeci.podatak;
		pom.sledeci = null;
		return vratiPodatak;
	}
	public void ubaciNaPoziciju(int podatak,int pozicija) {
		if(prvi == null || pozicija == 1) {
			ubaciNaPocetak(podatak);
			return;
		}
		if(pozicija <= 0 || pozicija > brojElemenataUListi() + 1) {
			System.out.println("Nevalidna pozicija");
			return;
		}
		int br = 1;
		DsCvor pom = prvi;
		while(br != pozicija - 1) {
			pom = pom.sledeci;
			br++;
		}
		DsCvor novi = new DsCvor(podatak, pom.sledeci, pom);
		//zato sto ne mogu null da dodelim vrednost
		if(pozicija == brojElemenataUListi() + 1) {
			pom.sledeci = novi;
			return;
		}
		pom.sledeci.prethodni = novi;//ovde bi izbacio npe da nema gore uslova
		pom.sledeci = novi;
		
	}
	public int brojElemenataUListi() {
		DsCvor pom = prvi;
		int br = 0;
		while(pom != null) {
			br++;
			pom = pom.sledeci;
		}
		return br;
	}

	public int izbaciSaPozicije(int pozicija) {
		if(prvi.sledeci == null || pozicija == 1) {
			int vratiPodatak = prvi.podatak;
			izbaciSaPocetka();
			return vratiPodatak;
		}
		if(pozicija <= 0 || pozicija > brojElemenataUListi()) {
			throw new RuntimeException("Nevalidna pozicija");
		}
		int br = 1;
		DsCvor pom = prvi;
		while(br != pozicija - 1) {
			pom = pom.sledeci;
			br++;
		}
		int vratiPodatak = pom.sledeci.podatak;
		pom.sledeci.sledeci.prethodni = pom;
		pom.sledeci = pom.sledeci.sledeci;
		return vratiPodatak;
	}
}
