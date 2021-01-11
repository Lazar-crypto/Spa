package main;

import labis.exception.LabisException;
import labis.test.ListGenerator;

public class Test {

public static void main(String[] args) throws LabisException {
		
//		DSLista dsLista = new DSLista();
//		int niz[] = {1,2,3};
//		ListGenerator.napraviDSListuCommon(dsLista,niz, false);
//		
//		DSLista dsLista2 = new DSLista();
//		int niz2[] = {2,3};
//		ListGenerator.napraviDSListuCommon(dsLista2,niz2, false);
//		
//		DSLista testPrimer = new DSLista();
//		
//		testPrimer.prvi = DSLista.pretvoriUBrojeveVratiListu(dsLista.prvi, dsLista2.prvi);
//		
//		ListGenerator.ispisiDSListu(testPrimer.prvi);
//		System.out.println(dsLista.prvi.prethodni.podatak);
//		System.out.println(dsLista.prvi.prethodni.prethodni.podatak);
//		
		JSLista jslista = new JSLista();
		int niz[] = {1,2,3,4,5,6,7};
		ListGenerator.napraviJSListuCommon(jslista,niz, false);
//		jslista.izbaciPreTogBroja(2);
//		ListGenerator.ispisiJSListu(jslista.prvi);
		jslista.printListuRekurzivno(jslista.prvi);
//
//		Niz objekatNiza = new Niz();
//		objekatNiza.niz = new int[] {1,2,3,2,3,3,4,5};
//		System.out.println(objekatNiza.zadatakSaKol());
		
//		for(int i = 0; i < objekatNiza.niz.length; i ++) {
//			System.out.println(objekatNiza.niz[i]);
//		}
}

}
