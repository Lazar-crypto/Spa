package main;

import labis.exception.LabisException;
import labis.stek.AStek;

public class Stek extends AStek{

	public Stek(int kapacitet) {
		// TODO Auto-generated constructor stub
		super(kapacitet);
	}

	@Override
	public void ispisiStekObrnuto() throws LabisException {
		if(prazanStek()) return;
		
		int x = pop();
		System.out.println("Pre rekurzije stek: " + x);
		ispisiStekObrnuto();
		System.out.println(x);
		push(x);
	}

	public static void main(String[] args) {
		Stek s = new Stek(5);
		s.push(1);
		s.push(2);
		s.push(3);

		try {
			s.ispisiStekObrnuto();
			
		} catch (LabisException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
