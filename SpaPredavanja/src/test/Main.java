package test;

import metode.MetodeSaPredavanja;

public class Main {

	public static void main(String[] args) {
		int niz[] = {3,7,13,15,18,22,25};
//		System.out.println(MetodeSaPredavanja.binarnoPretrazivanje(niz,18));
		int gg = 6;
		int dg = 0;
		System.out.println(MetodeSaPredavanja.binarnoPretrazivanjeRekurzivno(niz, gg, dg, 18));

	}

}
