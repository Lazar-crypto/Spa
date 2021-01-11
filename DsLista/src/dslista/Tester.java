package dslista;

public class Tester {

	public static void main(String[] args) {
		
		DsLista dvostrukoSLista = new DsLista();
		dvostrukoSLista.ubaciNaPocetak(5);
		dvostrukoSLista.ubaciNaPocetak(4);
		dvostrukoSLista.ubaciNaPocetak(3);
		dvostrukoSLista.ubaciNaPocetak(2);
		dvostrukoSLista.ubaciNaPocetak(1);
		dvostrukoSLista.ubaciNaKraj(6);
		dvostrukoSLista.ubaciNaKraj(7);
		dvostrukoSLista.ubaciNaKraj(8);
		dvostrukoSLista.ubaciNaKraj(9);
		dvostrukoSLista.ubaciNaKraj(10);

		dvostrukoSLista.ispisiListu();
		System.out.println("Izbacen je podatak: "+dvostrukoSLista.izbaciSaPozicije(1));
		dvostrukoSLista.ispisiListu();
		dvostrukoSLista.ispisiListuUnazad();




	}

}
