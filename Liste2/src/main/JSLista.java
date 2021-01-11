package main;

import labis.cvorovi.CvorDSListe;
import labis.cvorovi.CvorJSListe;
import labis.liste.AJSLista;

public class JSLista extends AJSLista{

	// PRVI KOLOKVIJUM 2019
		//*
		//*
		//*
	//2.data je JS lista i parametri M i N
	//preskoci M elemenata pa izbaci N elemenata i tako do kraja
	//primer: M = 2  N = 2

		//1 2 3 4 5 6 7 8 9 10 11  ->  1 2 5 6 9 10 

	public void izbaciSledeciJs(CvorJSListe pom) {
		if(pom == null || pom.sledeci == null)
			return;
		pom.sledeci = pom.sledeci.sledeci;
	}
	public void izbaciSledeciDs(CvorDSListe pom) {
		if(pom == null || pom.sledeci == null)
			return;
		pom.sledeci = pom.sledeci.sledeci;
		if(pom.sledeci != null) 
			pom.sledeci.prethodni = pom;
		
	}
	
	public void preskociMizbaciN(int M,int N) {
		//granicni slucajevi
		if(prvi == null) return;
		
		if(M < 0 || N <= 0) return;
		
		if(M == 0) {
			prvi = null;
			return;
		}	
		
		CvorJSListe pom = prvi;
		while(true) {
			for (int i = 0; i < M - 1; i++) {
				if(pom == null) return;
				pom = pom.sledeci;
			}
		
			for(int i = 0; i < N; i ++) {
				izbaciSledeciJs(pom);
			}
			if(pom == null) return;
			pom = pom.sledeci;
		}
	}

		//	3) data je JS lista i parametri BROJ i N
		//	ubaci broj na N-to mesto od kraja liste
		//	primer: BROJ = 10  N = 3
		//
		//	1 2 3 4 5 -> 1 2 3 10 4 5
		//
		//	a) kako god
		//	b) u jednom prolazu
	//a):
	public void ubaciBrojnaNtoMestoOdKraja(int BROJ,int N) {
		if(prvi == null && N == 1) {
			prvi = new CvorJSListe(BROJ, prvi);
			return;
		}
		if(N == brojElemenataUListi() + 1) {
			prvi = new CvorJSListe(BROJ, prvi);
			return;
		}
		
		if(N <= 0 || N > brojElemenataUListi()) return;
		
		CvorJSListe pom = prvi;
		CvorJSListe noviCvorJSListe = new CvorJSListe(BROJ, null);
		for(int i = 0; i < brojElemenataUListi() - N; i ++) {
			pom = pom.sledeci;
		}
		noviCvorJSListe.sledeci = pom.sledeci;
		pom.sledeci = noviCvorJSListe;
		
		
	}
	public int brojElemenataUListi() {
		CvorJSListe pom = prvi;
		int br = 0;
		while(pom != null) {
			br++;
			pom = pom.sledeci;
		}
		return br;
	}

		//JANUAR 2020
	//	1) JSLista, dat novi broj kao parametar
	//	Ubaci taj broj posle prvog broja koji je manji od njega, ako ne postoji element manji od parametra, ubaci ga na kraj liste
	//
	//	2) DSLista
	//	Izbaci sve neparne elemente
	//
	//	3) Niz, dat parametar
	//	Funkcija vraca duzinu najkraceg podniza ciji je zbir elemenata veci od parametra
	//	a) Kako god
	//	b) U jednom prolazu
	public void zadatak1Januar2020(int broj) {
		if(prvi == null) {
			prvi = new CvorJSListe(broj, prvi);
			return;
		}
		CvorJSListe pom = prvi;
		boolean pronasao = false;
		while(pom.sledeci != null) {
			if(pom.podatak < broj) {
				pronasao = true;
				CvorJSListe novi = new CvorJSListe(broj, pom.sledeci);
					pom.sledeci = novi;
				return;
			}
			pom = pom.sledeci;
		}
		if(pronasao == false) {
			CvorJSListe novi = new CvorJSListe(broj, null);
			pom.sledeci = novi;
		}
	}
	//JUL 2019
//	*
//	*
//	*
	
//	2) JS lista i parametar K
//	Vrati broj parova elemenata ciji je zbir veci od K
//	primer:
//	1 2 3 4     K = 5
//	parovi: 2 4 i 3 4
	public int vratiBrojParova(int K) {
		if(prvi == null)
			return 0;
		
		CvorJSListe pomi = prvi;
		CvorJSListe pomj = prvi.sledeci;
		int br = 0;
		while(pomi.sledeci !=null) {
			while(pomj != null) {
				if(pomi.podatak + pomj.podatak > K) {
					br++;
				}
				pomj = pomj.sledeci;
			}
			pomi = pomi.sledeci;
			pomj = pomi.sledeci;
		}
	return br;
	}
//	JUN 2019
//	*
//	*
//	*
//	2) izbaci iz JS liste sve elemente ciji je kvadrat veci 
//	od zbira elemenata pocetne liste
	public void izbaciKvadrat() {
		int zbirElemenataPocetne = zbirElemenata();
		
		if(prvi == null) return;
		if(prvi.sledeci == null && 
				prvi.podatak * prvi.podatak > zbirElemenataPocetne) {
			prvi = null;
			return;
		}
		while(prvi.podatak * prvi.podatak > zbirElemenataPocetne)
			prvi = prvi.sledeci;
		CvorJSListe pom = prvi;
		//opstiSlucaj
		while(pom.sledeci != null) {
			if((pom.sledeci.podatak * pom.sledeci.podatak) > zbirElemenataPocetne) {
				pom.sledeci = pom.sledeci.sledeci;
			}
			else {
				pom = pom.sledeci;
			}
		}
	}
	
	public int zbirElemenata() {
		CvorJSListe pom = prvi;
		int zbir = 0;
		while(pom != null) {
			zbir += pom.podatak;
			pom = pom.sledeci;
		}
		return zbir;
	}
	
//	SEPTEMBAR 2019
//	 *
//	 *
//	 *

//	2) JSLista, dat broj kao parametar
//	Izbaci sve brojeve iz liste koji su manji od tog broja
	
	public void izbaciSveKojiSuManjiOdDatogBroja(int broj) {
		if(prvi == null) return;
		//naPocetku
		while(prvi.podatak < broj) {
			prvi = prvi.sledeci;
			if(prvi == null) return;
		}
		
		//opstiSlucaj
		CvorJSListe pom = prvi;
		while(pom.sledeci != null) {
			if(pom.sledeci.podatak < broj) {
				pom.sledeci = pom.sledeci.sledeci;
			}
			else {
				pom = pom.sledeci;
			}
		}
	}

//	OKTOBAR 2019
//	 *
//	 *
//	 *
//	 1) JS lista, dat broj kao parametar
//	Izbaci iz liste broj pre tog broja
//	Parametar = 6
//	1 2 3 5 6 7  -->  1 2 3 6 7
	
	public void izbaciPreTogBroja(int broj) {
		if(prvi == null || prvi.sledeci == null || prvi.podatak == broj) 
			return;
		if(prvi.sledeci.podatak == broj) {
			prvi = prvi.sledeci;
			return;
		}
		if(prvi.sledeci.sledeci.podatak == broj) {
			prvi.sledeci = prvi.sledeci.sledeci;
			return;
		}
		boolean pronasao = false;
		//opsti Slucaj
		CvorJSListe pom = prvi;
		while(pom.sledeci != null) {
			if(pom.sledeci.sledeci.podatak == broj) {
				pom.sledeci = pom.sledeci.sledeci;
				return;
			}
			pom = pom.sledeci;
		
		}
		if(pronasao == false) {
			System.out.println("Broj ne postoji u listi");
		}
	}
	
	public void printListuRekurzivno(CvorJSListe pom){
		if(pom == null) return;
		
		printListuRekurzivno(pom.sledeci);
		System.out.println(pom.podatak);
	}
	
	

}
