package jslista;

public class JsLista {

	Cvor prvi;
	
	public void ubaciNaPocetak(int podatak) {
		prvi =  new Cvor(podatak, prvi);
	}
	public void ubaciNaPocetak(int ... nizPodataka) {
		for (int i = 0; i < nizPodataka.length; i++) {
			ubaciNaPocetak(nizPodataka[i]);
		}
	}

	public void ubaciNakraj(int podatak) {
		if(prvi == null) {
			ubaciNaPocetak(podatak);
			return;
		}
		Cvor pom = prvi;
		while(pom.sledeci != null) {
			pom = pom.sledeci;
		}
		Cvor novi = new Cvor(podatak,null);
		pom.sledeci = novi;
	}

	public void ispisiListu() {

		System.out.println("Lista: ");
		Cvor pom = prvi;
		while(pom != null) {
			System.out.println(pom.podatak + " ");
			pom = pom.sledeci;
		}
		System.out.println();
	}

	public int izbaciSaPocetka() {
		if(prvi == null) throw new RuntimeException("Nema sta da se izbaci,lista prazna");
		int vratiPodatak = prvi.podatak;
		prvi = prvi.sledeci;
		return vratiPodatak;
	}

	public int izbaciSaKraja() {
		int vratiPodatak;
		if(prvi == null) throw new RuntimeException("Nema sta da se izbaci,lista prazna");
		else if(prvi.sledeci == null) {
			vratiPodatak = prvi.podatak;
			prvi = null;
		}
		else {
			Cvor pom = prvi;
			while(pom.sledeci.sledeci != null) {
				pom = pom.sledeci;
			}
			vratiPodatak = pom.sledeci.podatak;
			pom.sledeci = null;
		}
		return vratiPodatak;
	}

	public void ubaciNaPoziciju(int podatak,int pozicija) {
		if(prvi == null || pozicija == 1){
			ubaciNaPocetak(podatak);  
			return;
		}
		if(pozicija <= 0 || pozicija - brojElemenataUListi() >=2) {
			 System.out.println("Uneli ste nevalidnu poziciju"); 
			 return;
		}
		int br = 1;
		Cvor pom = prvi;
		while(br < pozicija - 1 ) {
			pom = pom.sledeci;
			br ++;
		}
		Cvor novi = new Cvor(podatak, pom.sledeci);
		pom.sledeci = novi;
	
	}
	//pomocna metoda za ubaciNapoziciju
	public int brojElemenataUListi() {
		Cvor pom = prvi;
		int br = 0;
		while(pom != null) {
			pom = pom.sledeci;
			br++;
		}
		return br;
	}

	public int vratiElementIzListe(int indeks) {
		
		if(prvi == null) throw new RuntimeException("Lista je prazna");
		if(indeks <= 0 || indeks > brojElemenataUListi()) throw new RuntimeException("Nevalidan indeks");
		int br = 1;
		Cvor pom = prvi;
		while(br != indeks) {
			pom = pom.sledeci;
			br++;
		}
		return pom.podatak;
	}
	
	public boolean daLiPostoji(int podatak) {
		if(prvi == null) throw new RuntimeException("Lista je prazna");
		Cvor pom = prvi;
		while(pom != null) {
			if(pom.podatak == podatak) return true;
			pom = pom.sledeci;
		}
		return false;
	}
	
	public int izbaciSaPozicije(int pozicija) {
		int vratiPodatak;
		
		if(prvi == null) throw new RuntimeException("Lista je prazna");
		
		if(pozicija > brojElemenataUListi() || pozicija <= 0) throw new RuntimeException("Nevalidan indeks");
		
		if(prvi.sledeci == null || pozicija == 1) {
			vratiPodatak = prvi.podatak;
			prvi = null;
			return vratiPodatak;
		}
		int br = 1;
		Cvor pom = prvi;
		while(br != pozicija - 1) {
			pom = pom.sledeci;
			br ++;
		}
		vratiPodatak = pom.sledeci.podatak;
		pom.sledeci = pom.sledeci.sledeci;
		return vratiPodatak;
	}
	
	public void sortirajListu() {
		
		Cvor pomi = prvi;
		Cvor pomj = prvi.sledeci;
	
		while(pomi.sledeci != null) {
			while(pomj != null) {
				if(pomi.podatak > pomj.podatak) {
					int pom = pomi.podatak;
					pomi.podatak = pomj.podatak;
					pomj.podatak = pom;
				}
				pomj = pomj.sledeci;
			}
			pomi = pomi.sledeci;
			pomj = pomi.sledeci;//bitno,svaki put kad j pomj postane null
			//moramo da ga vratimo na i + 1
		}
	}

	public void ubaciUSortiranuListu(int noviPodatak) {
		if(prvi.podatak >= noviPodatak) {
			prvi = new Cvor(noviPodatak, prvi);
			return;
		}
		
		Cvor pom = prvi;
		while(pom != null) {
			if(pom.sledeci == null) {
				Cvor novi = new Cvor(noviPodatak, null);
				pom.sledeci = novi;
				return;
			}
			if(pom.sledeci.podatak >= noviPodatak) {
				Cvor noviCvor = new Cvor(noviPodatak, pom.sledeci);
				pom.sledeci = noviCvor;
				break;
			}
			pom = pom.sledeci;
		}
	}
	
	public void izbaciSveParneBrojeve() {
		if(prvi == null) {
			System.out.println("Lista je prazna");
			return;
		}
		//posebno kada je broj na prvom mestu
		while(prvi.podatak % 2 == 0) {
			prvi = prvi.sledeci;
		}
		Cvor pom = prvi;
		while(pom.sledeci != null) {
			if(pom.sledeci.podatak % 2 == 0)
				pom.sledeci = pom.sledeci.sledeci;
			else pom = pom.sledeci;
		}
		
	}

}
