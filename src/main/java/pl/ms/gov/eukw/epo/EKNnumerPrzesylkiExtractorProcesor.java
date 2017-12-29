package pl.ms.gov.eukw.epo;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

/**
 * Odczyt numeru przesylki z atrybutu Opis elementu Nadawca -> Zbior.<br/>
 * Podział wartości atrybutu na pola oddzielone znakami ###, numer przesyłki to
 * ostatnie pole tekstu.<br/>
 * Znaleziony numer przesyłki jest przeskazywany w nagłówku NR_PRZESYLKI.
 * 
 * @author Wojciech.Palubski
 *
 */
public class EKNnumerPrzesylkiExtractorProcesor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Zbior zbior = exchange.getIn().getBody(Zbior.class);
		String opis = zbior.getOpis();
		String guidEKN = zbior.getGuid();
		String[] opisy = opis.split("###");
		if (opisy.length > 0) {
			String nrPrzesylki = opisy[opisy.length - 1];
			nrPrzesylki = nrPrzesylki.replaceAll("#", "");
			System.out.println("Numer przesylki EKN " + guidEKN + ": " + nrPrzesylki);
			exchange.getIn().getHeaders().put("NR_PRZESYLKI", nrPrzesylki);
		} else {
			System.out.println("W opisie nie znaleziono pola numer przesylki EKN " + guidEKN);
		}
	}
}
