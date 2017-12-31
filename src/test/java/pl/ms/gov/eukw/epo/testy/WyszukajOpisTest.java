package pl.ms.gov.eukw.epo.testy;

import static org.junit.Assert.*;

import org.junit.Test;

public class WyszukajOpisTest {

	@Test
	public void test() {
		String opis = "##102191/17#####11111/17###";
		String[] opisy = opis.split("###");
		System.out.println("Opis: " + opis);
		if (opisy.length > 0) {
			String ostatni=opisy[opisy.length - 1];
			ostatni=ostatni.replaceAll("#", "");
			System.out.println("Numer przesylki EKN: "+ostatni);
		} else {
			System.out.println("W opisie nie znaleziono pola numer przesylki EKN");
		}
	}

}
