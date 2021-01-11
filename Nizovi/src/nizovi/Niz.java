package nizovi;

public class Niz {

	int [] niz;
	int n;
	
	public Niz(int kapacitet) {
		niz = new int[kapacitet];
	}

	public void ubaciNaKraj(int broj) {
		if(n == niz.length) throw new RuntimeException("Niz je pun");
		niz[n++] = broj;
	}
	//promenljivu brojevi gledam kao na niz
	public void ubaciNaKraj(int ... brojevi) {
		for (int i = 0; i < brojevi.length; i++) {
			ubaciNaKraj(brojevi[i]);
		}
	}
	public void ispisiNiz() {
		System.out.println("Niz: ");
		for (int i = 0; i < n; i++) {
			System.out.print(niz[i] + " ");
		}
		System.out.println();
	}
	
	public int pronadjiNajveci() {
		int max = niz[0];
		for (int i = 0; i < n; i++) {
			if(niz[i] > max) max = niz[i];
		}
		return max;
	}
	
	public int pronadjiNajveciNegativni() {
		int max = Integer.MIN_VALUE;
		boolean pronadjen = false;
		
		for (int i = 0; i < niz.length; i++) {
			if(niz[i] < 0 && niz[i] >= max) {
				max = niz[i];
				pronadjen = true;
			}
		}
		if(pronadjen) return max;
		throw new RuntimeException("Ne postoji negativan broj");
	}

	public void ubaciNaPocetak(int broj) {
		//3 slucaja: prazan,pun i opsti
		if(n == 0) throw new RuntimeException("Niz je prazan");
		else if(niz.length == n) throw new RuntimeException("Niz je pun");
		
		else {
			//idemo od nazad i pomeramo u levo
			niz[n++] = niz[n];
			for(int i = n; i > 0 ; i--) {
				niz[i] = niz[i-1];
			}
			niz[0] = broj;
		}
		
	}
	
	public void ubaciNaIndeks(int indeks,int broj) {
		if(niz.length == 0) {
			System.out.println("niz je prazan");
			return;
		}
		if(niz.length <= n) {
			System.out.println("Niz je pun");
			return;
		}
		if(indeks > n || indeks < 0) {
			System.out.println("Indeks nije validan");
			return;
		}
		niz[n++] = niz[n];
		for (int i = n; i > indeks; i--) {
			niz[i] = niz[i-1];
		}
		niz[indeks] = broj;
	}

	public void ubaciURastuceSortiranNiz(int broj) {
		if(n >= niz.length) {
			System.out.println("Niz je pun");
			return;
		}
		for (int i = 0; i < n; i++) {
			if(niz[i] >= broj) {
//				niz[n++] = niz[n];
//				for(int j = n; j > i; j--) {
//					niz[j] = niz[j-1];
//				}
//				niz[i] = broj;
				ubaciNaIndeks(i, broj);
				return;
			}
		}
		niz[n++] = broj;
	}
	
	public void bubbleSort() {

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1 ; j++) {
				if(niz[j] > niz[j+1]) {
					int pom = niz[j];
					niz[j] = niz[j+1];
					niz[j+1] = pom;
				}
			}
			
		}
	}

	public void selectionSort() {
		
		for (int i = 0; i < n - 1; i++) {
			for (int j = i + 1;  j < n;  j++) {
				if(niz[i] > niz[j]) {
					int pom = niz[i];
					niz[i] = niz[j];
					niz[j] = pom;
				}
			}
		}
	}

	public int brojPonavljanjaBroja(int broj) {
		int br = 0;
		for (int i = 0; i < n; i++) {
			if(niz[i] == broj) br++;
		}
		return br;
	}
	
	public static int brojPonavljanjaBroja(int broj,int nizPom[]) {
		int br = 0;
		for (int i = 0; i < nizPom.length; i++) {
			if(nizPom[i] == broj) br++;
		}
		return br;
	}

	public void unijaNizova(int niz1[],int niz2[]){
		//pravi novi niz koji ce sadrzati oba
		niz = new int[niz1.length + niz2.length];
		n = 0;
		
		for (int i = 0; i < niz1.length; i++) {
			if(brojPonavljanjaBroja(niz1[i], niz) == 0)	
			niz[n++] = niz1[i];
		}
		for (int i = 0; i < niz2.length; i++) {
			if(brojPonavljanjaBroja(niz2[i], niz) == 0)	
			niz[n++] = niz2[i];
	}
	
	}

	public void unijaSortiranihNizova(int niz1[],int niz2[]) {
		
		niz = new int[niz1.length + niz2.length];
		n = 0;
		
		int br1 = 0;
		int br2 = 0;
		while(n != niz1.length + niz2.length) {
			
			if(br1 == niz1.length) {
				niz[n++] = niz2[br2++]; 
				continue;
			}
			if(br2 == niz2.length) {
				niz[n ++] = niz1[br1 ++];
				continue;
			}
			
			//ovo ce puci kada jedan niz dodje do kraja nema sta da poredi vise
			if(niz1[br1] > niz2[br2]) {
				niz[n ++] = niz2[br2];
				br2++;
			}
			else {
				niz[n ++] = niz1[br1];
				br1++;
			}
		}
			
		
	}

	public int zbirTriMaksa() {
		int maks1 = niz[0];
		int maks2 = Integer.MIN_VALUE;
		int maks3  = Integer.MIN_VALUE;
		
		for (int i = 0; i < n; i++) {
			if(niz[i] >= maks1) {
				maks3 = maks2;
				maks2 = maks1;
				maks1 = niz[i];
			}
			else if(niz[i] >= maks2) {
				maks3 = maks2;
				maks2 = niz[i];
			}
			else if(niz[i] >= maks3) {
				maks3 = niz[i];
			}
		}
		return maks1 + maks2 + maks3;
	}
}
