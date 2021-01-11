package main;

public class Vezba {

	public int faktorijalBroja(int n) {
		if(n == 1) return 1;
		
		return  faktorijalBroja(n-1) * n; 
	}
	
	public int bunnyEars(int bunnies) {
		int ears = 0;
		if(bunnies == 0) return ears;
	
		ears = bunnyEars(bunnies - 1) + 2;
		return ears;
	}
	
	public int zbirCifaraBroja(int n) {
//		if(n / 10 == 0) return 1;
//		ili :
		if(n == 0) return 0;
		int cifra = n % 10;
//		
		return cifra + zbirCifaraBroja(n/10);
	}

	public void ispisiBrojeveOdNekogBroja(int n) {
		if(n == 0) return ;
		
		 ispisiBrojeveOdNekogBroja(n -1);
		 System.out.println(n);
	}
	
	public int proizvodCifara(int n) {
		//poseban slucaj samo za n = 0
		if(n == 0) return 0;
		
		return proizvodCifaraR(n);
	}
	
	private int proizvodCifaraR(int n) {
		if(n == 0) return 1; // nece raditi kada je n = 0 -> enkapsulacija
		
		int cifra = n % 10;
		return cifra* proizvodCifaraR(n/10);
	}
	
	private void ispisNizaR(int niz[],int indeks,char slovo) {
		
		if(indeks == niz.length) return;
		
		System.out.println("Element niza: "+ niz[indeks]);
		//radi i ovako ali mi nije jasno zasto
		//ispisNizaR(niz, niz[indeks]);
		
		indeks ++;
		slovo++;
		ispisNizaR(niz, indeks,slovo);
		System.out.println(slovo);
	}
	
	public void ispisNizaOsigurano(int niz[],char slovo) {
		//indeks uvek mora kretati od nule
		//slovo sam ja bzvz stavio da vidim nesto
		if(niz == null) {
			System.out.println("Niz ne postoji");
			return;
		}
		
		if(niz.length == 0) {
			System.out.println("Niz je prazan");
			return;
		}
		ispisNizaR(niz, 0, slovo);
	}
	
	
	private int zbirElemenataUNizuR(int niz[],int indeks) {
		
		if(indeks == niz.length) return 0;
		return  niz[indeks] + zbirElemenataUNizuR(niz, ++indeks);
		
	}
	
	public int zbirElemenataUNizuROsiguranIndeks(int niz[]) {
		if(niz == null) {
			throw new RuntimeException("Niz ne postoji");
		}
		
		if(niz.length == 0) {
			throw new RuntimeException("Niz je prazan");

		}
		
		return zbirElemenataUNizuR(niz, 0);
	}
	
	public void fibonaciPrekoPetlje(int n) {
		int niz[] = new int[n];
		int br = 0;
		for (int i = 0; i < n; i++) {
			if(i == 0) {
				niz[br++] = 0;
				continue;
			}
			if(i == 1) {
				niz[br++] = 0 + 1;
				continue;
			}
			niz[br++] = niz[i-1] + niz[i-2];
		}
		for (int i = 0; i < niz.length; i++) {
			System.out.println(niz[i]);
		}
	}
	
	public int fibonacci(int n) {
		
		if(n == 1 || n == 2) return 1;
		
		return fibonacci(n-1) + fibonacci(n-2);
		 
	}
	
	public static void main(String[] args) {
		
		Vezba primer = new Vezba();
		
//		System.out.println(primer.faktorijalBroja(4));
//		System.out.println(primer.bunnyEars(4));
		System.out.println(primer.fibonacci(6));
		
//		System.out.println(primer.zbirCifaraBroja(12345));
//		primer.ispisiBrojeveOdNekogBroja(10);
//		System.out.println(primer.proizvodCifara(0));
		
		int niz[] = {1,2,3,4,5,6,7,8,9,10};
//		primer.ispisNizaOsigurano(niz, 'A');
//	System.out.println(primer.zbirElemenataUNizuROsiguranIndeks(niz));
//		primer.fibonaciPrekoPetlje(10);
		primer.fibonacci(10);
	}

}
