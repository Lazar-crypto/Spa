package nizovi;

public class Tester {

	public static void main(String[] args) {
		Niz niz = new Niz(2);
		
		int niz1[] = {1,3,5,7,9};
		int niz2[] = {2,4,6,8,10,12,14};
		
		niz.unijaSortiranihNizova(niz1, niz2);
		niz.ispisiNiz();
		System.out.println(niz.zbirTriMaksa());
	}

}
