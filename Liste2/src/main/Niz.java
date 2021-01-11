package main;

import labis.exception.LabisException;
import labis.niz.ANiz;

public class Niz extends ANiz {

	public Niz() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int[] spojiDva(int[] a, int[] b) throws LabisException {
		
		if((a == null || a.length == 0) && (b == null || b.length == 0))
			throw new LabisException("Nizovi ne postoje");
		
		int i1 = -1,i2 = -1;
		if(a != null) {
			i1 = a.length - 1;
		}
		if(b != null) {
			i2 = b.length - 1;
		}
		
		int novi[] = new int[i1 + i2 + 2];
		for(int i = 0; i < novi.length; i++) {
			//kada je a prazan,kada smo ubacili sve iz a ili kad je b[i2] > a[i1]
			if(i1 < 0 || (b[i2] >= a[i1] && i2 >= 0)) {
			novi[i] = b[i2--];
			}
			else {
			novi[i] = a[i1--];
			}
		}
		return novi;
	}
	//JANUAR I FREBRUAR 2020
//	*
//	*
//	*
//	3) Niz, dat parametar
//	Funkcija vraca duzinu najkraceg podniza ciji je zbir elemenata veci od parametra
//	a) Kako god
//	b) U jednom prolazu
	
	public int vratiDuzinuNajkracegPodniza(int parametar) throws LabisException {
		if(niz == null) 
			throw new LabisException("niz je prazan");
		
		int min = Integer.MAX_VALUE;
		int duzinaPodniza = 0;
		boolean pronasao = false;
		for (int i = 0; i < niz.length; i++) {
			duzinaPodniza = vratiDuzinuPodniza(i, parametar);
			if(duzinaPodniza < min) {
				min = duzinaPodniza;
				pronasao = true;
			}
		}
		if(pronasao == false) throw new LabisException("Ne postoji takav podniz");
		return min;
	}
	
	public int vratiDuzinuPodniza(int indeks,int parametar) {
		int br = 0;
		int zbir = 0;
		for(int i = indeks;i < niz.length; i ++) {
			zbir = zbir + niz[i];
			br ++;
			if(zbir > parametar) 
				return br;
		}
		// ukoliko nismo zadovoljili uslov,vrati mi nesto
		//sto je sigurno vece od mog proslog minimuma
		return Integer.MAX_VALUE;
	}
	
	//JUL 2019
//	*
//	*
//	*
//	3) Niz
//	U nizu zameniti svaki element proizvodom njegovih suseda.
//	Prvi zameniti proizvodom prvog i drugog a poslednji proizvodom poslednjeg i pretposlednjeg
//	primer:
//	1 2 3 4 5 pretvoriti u 2 3 8 15 20
	
		
		
	
	public void zameniNizProizvodomNjegovihSuseda() throws LabisException {
		if(niz == null || niz.length == 0 || niz.length == 1) 
			return;
		//POD A:
//		int pomocniNiz[] = new int[niz.length];
//		
//		for (int i = 0; i < niz.length; i++) {
//			if(i == 0) {
//				pomocniNiz[0] = niz[0] * niz[1];
//			}
//			else if(i == niz.length - 1) {
//				pomocniNiz[i] = niz[niz.length - 2] * niz[niz.length - 1];
//				
//			}
//			else {
//				pomocniNiz[i] = niz[i - 1] * niz[i + 1];
//			}
//		}
//		
//		for (int i = 0; i < pomocniNiz.length; i++) {
//			niz[i] = pomocniNiz[i];
//		}
		//POD B: zapamti niz[i] za sledecu iteraciju
		int prethodni;
		int pom = niz[0]; 
		for (int i = 0; i < niz.length; i++) {
			prethodni = pom;
			pom = niz[i];
			if(i == niz.length - 1) {
				niz[niz.length - 1] = prethodni * niz[niz.length - 1];
				break;
			}
			niz[i] = prethodni * niz[i + 1];
		}
	}

	//JUN  2019
	//	*
	//	*
	//	*
//	1) dat je niz i  dato je  K npr K = 2
//			premesti K elemenata sa kraja na pocetak
//			1 2 3 4 5 -> 4 5 1 2 3
	public void premestiKsaKrajaNapocetak(int niz[],int K) {
		if(niz.length == 0) {
			System.out.println("Niz prazan");
			return;
		}
		if(niz.length < K || K < 0) {
			System.out.println("Ne mere");
			return;
		}
		for(int j = 0; j < niz.length - K; j++) {
			int prviEl = niz[0];
			for (int i = 0; i < niz.length - 1; i++) {
				niz[i] = niz[i+1];
			}
			niz[niz.length - 1] = prviEl;
		}
	}
//	 SEPTEMBAR 2019
//	 *
//	 *
//	 *
//	3) Dat niz, nadji najvecu razliku izmedju dva elementa tako da desni element mora biti veci od drugog
	 public int nadjiNajvecuRazliku() throws LabisException {
		 if(niz == null)throw new LabisException();
		 
		 int najvecaRazlika = Integer.MIN_VALUE;
		 boolean pronasao = false;
		 for (int i = 0; i < niz.length - 1; i++) {
			for (int j = i + 1; j < niz.length; j++) {
				if(niz[j] > niz[i] && niz[j] - niz[i] > najvecaRazlika) {
					najvecaRazlika = niz[j] - niz[i];
					pronasao = true;
				}
			}
		}
		 if(pronasao == false) throw new LabisException();
		 return najvecaRazlika;
	 }
	 
	 public int zadatakSaKol() {
		int brojac = 0;
		 for (int i = 0; i < niz.length; i++) {
			 if(vratiBrojPonavljanja(niz[i],i) > 1)
				 continue;
			 int pomBr = 0;
			 for (int j = 0; j < niz.length; j++) {
				if(niz[i] == niz[j])
					pomBr ++;
			}
			if(niz[i] == pomBr)
				brojac ++;
		 }
		 return brojac;
	 }
	
	 public int vratiBrojPonavljanja(int broj,int indeks) {
		int br = 0;
		 for (int i = indeks; i < niz.length; i++) {
			if(niz[i] == broj) br++;
		} 
		 return br;
	 }
}
