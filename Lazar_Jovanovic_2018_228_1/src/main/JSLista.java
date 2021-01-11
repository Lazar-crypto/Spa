package main;


import labis.cvorovi.CvorJSListe;
import labis.exception.LabisException;
import labis.liste.AJSLista;


public class JSLista extends AJSLista {

	 CvorJSListe prvi;
	//moje pomocne metode
	public void ispisiListu() {

		System.out.println("Lista: ");
		CvorJSListe pom = prvi;
		while(pom != null) {
			System.out.println(pom.podatak + " ");
			pom = pom.sledeci;
		}
		System.out.println();
	}
	public void ubaciNaPocetak(int podatak) {
		prvi =  new CvorJSListe(podatak, prvi);
	}
	public void ubaciNaPocetak(int ... nizPodataka) {
		for (int i = 0; i < nizPodataka.length; i++) {
			ubaciNaPocetak(nizPodataka[i]);
		}
	}
	@Override
	public int izbaciTrenutni(CvorJSListe t) throws LabisException {
		int vratiPodatak;
		//prvi slucaj lista prazna
		if(prvi == null || t == null) throw new RuntimeException("Lista je prazna");
		//drugi slucaj jedan element u listi
		if(prvi == t ) {
			vratiPodatak = t.podatak;
			prvi = prvi.sledeci;
			t.sledeci = null;
			return vratiPodatak;
		}
		//treci slucaj opsti i ukoliko cvora nema u listi
		CvorJSListe pom = prvi;
		boolean pronadjen = true;
		
		while(pom.sledeci != t) {
			if(pom.sledeci.sledeci == null) {
				pronadjen = false;
				break;
			}
			pom = pom.sledeci;
		}
		if(pronadjen == true) {
			vratiPodatak = t.podatak;
			pom.sledeci = t.sledeci;
			t.sledeci = null;
			return vratiPodatak;
		}
		else throw new RuntimeException("Uneli ste nevalidan cvor");
	}
	public int izbaciTrenutni2(CvorJSListe t)throws LabisException {
		int vratiPodatak;
		
		if(prvi == null ) throw new RuntimeException("Lista je prazna");
		
		if(prvi == t ) {
			vratiPodatak = t.podatak;
			prvi = prvi.sledeci;
			return vratiPodatak;
		}
		
		boolean pronadjen = false;
		CvorJSListe pom = prvi;
		while(pom.sledeci != null) {
			if(pom.sledeci == t) {
				pronadjen = true;
				break;
			}
			pom = pom.sledeci;
		}
		if(pronadjen) {
			vratiPodatak = t.podatak;
			pom.sledeci = t.sledeci;
			return vratiPodatak;
		}
		else throw new RuntimeException("Uneli ste nevalidan cvor");
	}
	
	@Override
	public CvorJSListe klonirajRekurzivno(CvorJSListe pom) throws LabisException {
		if(pom == null) return null;
		return new CvorJSListe(pom.podatak, klonirajRekurzivno(pom.sledeci));

		//	ovo bi bilo da kloniramo listu sa 3 elementa
//		new CvorJSListe(pom.podatak, 
//				new CvorJSListe(pom.sledeci.podatak,
//					new CvorJSListe(pom.sledeci.sledeci.podatak, null) ));
		
	
	}
	
	@Override
	public void invertovanjeSaPomocnom() throws LabisException {
		//napravimo novu listu i samo je obrnemo
		CvorJSListe pom = null;
		while(prvi != null) {
			pom = new CvorJSListe(prvi.podatak, pom);
			prvi = prvi.sledeci;
		}
		prvi = pom;
	}
	
	@Override
	public void invertovanjeBezPomocne() throws LabisException {
		CvorJSListe prethodni = null;
		CvorJSListe sledeci = null;
		CvorJSListe trenutni = prvi;
				while(trenutni != null) {
					sledeci = trenutni.sledeci;
					trenutni.sledeci = prethodni;//ovo je glavna ideja,pre nje radim iznad liniju
					prethodni = trenutni;
					trenutni = sledeci;
				}
				prvi = prethodni;
	}
	
	@Override
	public int zbirElemenataUCiklicnoj() throws LabisException {
		int zbir = 0;
		CvorJSListe pom = prvi;
		if(prvi == null) throw new LabisException();
		while(pom.sledeci != prvi){
			zbir += pom.podatak;
			pom = pom.sledeci;
		}
		return zbir + pom.podatak;
	}
	
	@Override
	public void ispisiObrnuto(CvorJSListe prvi) throws LabisException {
		if(prvi == null) {
			return;
		}
		ispisiObrnuto(prvi.sledeci);
		System.out.println(prvi.podatak);
	}
	
	
	public static void main(String[] args) {
		JSLista lista = new JSLista();
		lista.ubaciNaPocetak(8,7,6,5,4,3,2,1);
		try {
			lista.invertovanjeSaPomocnom();
//			lista.klonirajRekurzivno(lista.prvi);
		} catch (LabisException e) {
			e.getMessage();
		}
	
		lista.ispisiListu();
		
	}
	
}
