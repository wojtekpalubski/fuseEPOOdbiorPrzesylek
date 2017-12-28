package pl.ms.gov.eukw.epo;

import org.apache.camel.Exchange;
import org.apache.camel.Header;

import pl.asseco.GetHostinfo1;

public class Hostinfo1RequestBean {
	public void createSoapBody(@Header("komunikat") String komunikat, Exchange exchange) {
		System.out.println("Przygotowuje request1 z parametrami " + komunikat);
		GetHostinfo1 hi1 = new GetHostinfo1();
		hi1.setKomunikat(komunikat);
		exchange.getIn().setBody(hi1);
	}
}
