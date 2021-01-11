package main;


import labis.cvorovi.CvorDSListe;
import labis.cvorovi.CvorJSListe;
import labis.exception.LabisException;
import labis.liste.ADSLista;

public class DSLista extends ADSLista {


	@Override
	public void popuniListu() throws LabisException {
		if(prvi == null || prvi.sledeci == null) return;
		
		CvorDSListe pom = prvi;
		while(pom.sledeci != null) {
			if(pom.sledeci.podatak - pom.podatak > 1) {
				pom.sledeci = new CvorDSListe(pom.podatak + 1, pom, pom.sledeci);
				pom.sledeci.sledeci.prethodni = pom.sledeci;
			}
			pom = pom.sledeci;
		}
	}


	@Override
	public CvorDSListe elementUSredini() throws LabisException {
		if(prvi == null) throw new LabisException("Lista je prazna");
		if(prvi.sledeci == null) return prvi;
		CvorDSListe spori = prvi;
		CvorDSListe brzi = prvi;
		//moze i brzi != null && brzi.sledeci != null // vraca desni srednji 
		while(brzi.sledeci !=null && brzi.sledeci.sledeci != null) { // levi srednji 
			
			brzi = brzi.sledeci.sledeci;
			spori = spori.sledeci;
		}
		return spori;
	}
	
	public void ispisiListuUnazad() {
		if(prvi == null) {
			System.out.println("Lista je prazna");
			return;
		}
		CvorDSListe pom = prvi;
		while(pom.sledeci != prvi) {
			pom = pom.sledeci;
		}
		while(pom != prvi) {
			System.out.println(pom.podatak + " ");
			pom = pom.prethodni;
		}
		//ovo je za ciklicnu
				System.out.println(prvi.podatak);
				System.out.println();
	}
	// PRVI KOLOKVIJUM 2019
	//*
	//*
	//*
	
	//1.Izbazi sve negativne brojeve iz Ds ciklicne liste
	
	public void izbaciSveNegativne() {
		//prvo - ako pocetni podaci zadovoljavaju uslov
		CvorDSListe poslednji = prvi.prethodni;
		CvorDSListe zapamtiPrvi = prvi;
		while(prvi.podatak < 0) {
			prvi = prvi.sledeci;
			if(prvi == zapamtiPrvi) {
				prvi = null;
				return;
			}
		}
		prvi.prethodni = poslednji;
		poslednji.sledeci = prvi;
		//drugo - opsti slucaj
		CvorDSListe pom = prvi;
		while(pom.sledeci != prvi) {
			if(pom.sledeci.podatak < 0) {
				pom.sledeci = pom.sledeci.sledeci;
				if(pom.sledeci == prvi)
					prvi.prethodni = pom;
			}
			else {
				pom.sledeci.prethodni = pom;
				pom = pom.sledeci;
			}
		}
	}
	
		//	FEBRUAR 2020
		//	PRVI DEO
		//
	//	1) Date dve js liste kao parametri, elementi tih lista su temperature po danima. Metoda treba da vrati najveci zbir temperatura za neki dan
	//	Primer
	//	Lista1: 1 2 3 4 5
	//	Lista2: 5 1 6 7 1
	//
	//	Metoda vraca 11  (7+4)
	//
	//
	//	2) DSLista
	//	Krece se od drugog el i izbacuje se svaki treci (znaci 5. pa 8. itd)
	//
	//	1 2 3 4 5 6 7 8 9 ->
	//	1 2 3 4 6 7 9
	//
	//	3) Niz, dat broj kao parametar
	//	Metoda vraca duzinu najkraceg podniza ciji je zbir veci od datog parametra
 
	//1.)
	public static int najtoplijiDan(CvorJSListe cvorPrveListe,CvorJSListe cvorDrugeListe) throws LabisException {
		
		if(cvorDrugeListe == null || cvorDrugeListe == null) {
			throw new LabisException("neka lista je null");
		}
		int maks = cvorPrveListe.podatak + cvorDrugeListe.podatak;
		CvorJSListe pom1 = cvorPrveListe;
		CvorJSListe pom2 = cvorDrugeListe;
		//stajemo kada jedan od njih postane null
		// pom1 == null || pom2 == null ,odnosno petlja radi sve dok
		//uslov za stajanje negiramo !(pom1 == null || pom2 == null) :
	//znaci petlja radi sve dok i pom1 nije null i pom2 nije null
	//cim neki od ta dva postane null ona prestaje sa radom
		while(pom1 != null && pom2 != null) {
			if((pom1.podatak + pom2.podatak) > maks)
				maks = (pom1.podatak + pom2.podatak);
			pom1 = pom1.sledeci;
			pom2 = pom2.sledeci;
		}
		return maks;
	}

	//2.) Kreni od drugog i izbaci svaki treci
	public void izbaciSvakiTreci() {
        if(prvi == null || prvi.sledeci == null) return;
		CvorDSListe pom = prvi.sledeci;
		while(true) {	
			for(int i = 0; i < 2; i++) {
				if(pom == null) return;
				pom = pom.sledeci;
		}
			izbaciSledeci(pom);
		}
	}
	public void izbaciSledeci(CvorDSListe pom) {
		if(pom == null || pom.sledeci == null) 
			return;
		pom.sledeci = pom.sledeci.sledeci;
		if(pom.sledeci != null) {
			pom.sledeci.prethodni = pom;
		}
		
	}
		//JANUAR 2020

	//	2) DSLista
	//	Izbaci sve neparne elemente
	public void zadatak2Januar() {
		if(prvi == null) return;
		//na pocetku
		while(prvi.podatak % 2 != 0) {
			prvi = prvi.sledeci;
			if(prvi == null) return;
		}
		prvi.prethodni = null;
		//opsti slucaj
		CvorDSListe pom = prvi;
		while(pom.sledeci != null) {
			if(pom.sledeci.podatak % 2 != 0) {
				pom.sledeci = pom.sledeci.sledeci;
			}
			else {
				pom.sledeci.prethodni = pom;
				pom = pom.sledeci;
			}
		}
	}
		//JUL 2019
//		*
//		*
//		*
//		1) Ciklicna DS lista
//		Izracunati prosek parnih elemenata
//
//		2) JS lista i parametar K
//		Vrati broj parova elemenata ciji je zbir veci od K
//		primer:
//		1 2 3 4     K = 5
//		parovi: 2 4 i 3 4
//
//		3) Niz
//		U nizu zameniti svaki element proizvodom njegovih suseda.
//		Prvi zameniti proizvodom prvog i drugog a poslednji proizvodom poslednjeg i pretposlednjeg
//		primer:
//		1 2 3 4 5 pretvoriti u 2 3 8 15 20
	
	public void prosekParnih() throws LabisException {
		if(prvi == null) throw new LabisException("Lista prazna");
		int zbir = 0;
		int br = 0;
		//naPocetkuslucaj
		CvorDSListe poslednji = prvi.prethodni;
		CvorDSListe zapamtiPrvi = prvi;
		while(prvi.podatak % 2 == 0) {
			zbir += prvi.podatak;
			br++;
			prvi = prvi.sledeci;
			if(prvi == zapamtiPrvi) {
				//znaci da smo dosli do kraja 
				prvi = null;
				return;
			}
		}
		prvi.prethodni = poslednji;
		poslednji.sledeci = prvi;
		
		//opstiSlucaj
		CvorDSListe pom = prvi;
		while(pom.sledeci != prvi) {
			if(pom.sledeci.podatak % 2 == 0) {
				zbir += pom.sledeci.podatak;
				br++;
				pom.sledeci = pom.sledeci.sledeci;
//				ne zaboravi na kraju ! !
				if(pom.sledeci == prvi)
					prvi.prethodni = pom;
			}
			else {
				pom.sledeci.prethodni = pom;
				pom = pom.sledeci;
			}
		}
		if(br == 0) throw new LabisException("Nema parnih brojeva");
//		return zbir / br;
	}
//	SEPTEMBAR 2019
//	 *
//	 *
//	 *
//	 1) DSLista, dat novi broj kao parametar
//	Ubaci taj broj izmedju dva susedna negativna broja, ako takva dva broja ne postoje ubaci na kraj
//	Primer: dat broj 5
//	
//	1 2 -1 -3 7 6 -> 1 2 -1 5 -3 7 6
	public void ubaciIzmedjuDvaNegativna(int broj) {
		if(prvi == null) return;
		
		CvorDSListe pom = prvi;
		boolean pronasao = false;
		while(pom.sledeci != null) {
			if(pom.podatak < 0 && pom.sledeci.podatak <0) {
				CvorDSListe novi = new CvorDSListe(broj, pom, pom.sledeci); 
				pom.sledeci.prethodni = novi;
				pom.sledeci = novi;
				return;
			}
			pom = pom.sledeci;
		}
		if(pronasao == false) {
			CvorDSListe novi = new CvorDSListe(broj, pom, null);
			pom.sledeci = novi;
		}
	}

//	OKTOBAR 2019
//	 *
//	 *
//	 *
//	2) Dve liste
//	1 2 3
//	2 3
//	Pretvoriti u brojeve 123 i 23, sabrati ih i napravi opet listu od toga
//	123+23=146
//	Lista: 1 4 6
	
	public static CvorDSListe pretvoriUBrojeveVratiListu(CvorDSListe lista1,CvorDSListe lista2) {
		int a = 0;
		int b = 0;
		while(lista1 != null) {
			a = a * 10 + lista1.podatak;
			lista1 = lista1.sledeci;
		}
		while(lista2 != null) {
			b = b * 10 + lista2.podatak;
			lista2 = lista2.sledeci;
		}
		int zbir = a + b;
//		int invertovanBroj = invertujBroj(zbir);
		CvorDSListe novaListaPrvi = null ;
		while(zbir != 0) {
			int cifra = zbir % 10;
			novaListaPrvi = new CvorDSListe(cifra, null, novaListaPrvi);
			if(novaListaPrvi.sledeci != null) {
				novaListaPrvi.sledeci.prethodni = novaListaPrvi;
			}
			zbir = zbir / 10;
		}
		return novaListaPrvi;
	}
//	public int invertujBroj(int broj) {
//		int invertovan = 0;
//		while(broj != 0) {
//			int cifra = broj % 10;
//			invertovan = invertovan * 10 + cifra;
//			broj = broj / 10;
//		}
//		return invertovan;
//	}
}
