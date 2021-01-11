package metode;

public class MetodeSaPredavanja {
	//cilj je vratiti poziciju na kojoj se nalazi trazeni broj
	public static int binarnoPretrazivanje(int niz[],int broj) {
		int dg = 0;
		int gg = (niz.length - 1);
		int s; // pozicija koju vracamo
		while(gg >= dg) {
			s = dg + (gg - dg)/2;
			if(broj < niz[s]) 
				gg = s-1;
			
			else if(broj > niz[s]) 
				dg = s+1;
			
			else return s;
		}
		return -1;
	}

	public static int binarnoPretrazivanjeRekurzivno(int niz[],int gg,int dg,int broj) {
	
		if(gg < dg) 
			return -1; // ne mere
		int s; // pozicija koju vracamo
			s = dg + (gg - dg)/2;

			if(broj < niz[s]) {
				return binarnoPretrazivanjeRekurzivno(niz,s - 1, dg, broj);
			}
			else if(broj > niz[s]) {
				return binarnoPretrazivanjeRekurzivno(niz,gg, s + 1, broj);
			}
			else return s;
	}
	
}
