package pl.ms.gov.eukw.epo;

import org.apache.camel.Exchange;
import org.apache.camel.Header;

import pl.asseco.GetHostinfo2;

public class Hostinfo2RequestBean {
	public void createSoapBody(@Header("komunikat") String komunikat, @Header("komunikat2") String komunikat2,
			Exchange exchange) {
		System.out.println("Przygotowuje request2 z parametrami " + komunikat + " i " + komunikat2);
		GetHostinfo2 hi2 = new GetHostinfo2();
		hi2.setKomunikat(komunikat);
		hi2.setKomunikat2(komunikat2);
		exchange.getIn().setBody(hi2);
	}
}
