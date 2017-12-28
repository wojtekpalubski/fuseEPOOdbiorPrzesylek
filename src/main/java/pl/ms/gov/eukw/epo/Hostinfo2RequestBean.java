package pl.ms.gov.eukw.epo;

import org.apache.camel.Exchange;
import org.apache.camel.Header;

import pl.asseco.GetHostinfo2;
import pl.asseco.GetHostinfo2Response;

public class Hostinfo2RequestBean {
	public void createSoapBody(@Header("komunikat") String komunikat, @Header("komunikat2") String komunikat2,
			Exchange exchange) {
		System.out.println("Przygotowuje request2 z parametrami " + komunikat + " i " + komunikat2);
		GetHostinfo2 hi2 = new GetHostinfo2();
		hi2.setKomunikat(komunikat);
		hi2.setKomunikat2(komunikat2);
		System.out.println("hi2: "+hi2);
		exchange.getIn().setBody(hi2);
	}

	public GetHostinfo2 createSoapRequest(@Header("komunikat") String komunikat, @Header("komunikat2") String komunikat2) {
		System.out.println("Przygotowuje request2 z parametrami " + komunikat + " i " + komunikat2);
		GetHostinfo2 hi2 = new GetHostinfo2();
		hi2.setKomunikat(komunikat);
		hi2.setKomunikat2(komunikat2);
		System.out.println("hi2: "+hi2);
		return hi2;
	}

	public void procesSoapResponse(GetHostinfo2Response response) {
		System.out.println("Procesuje odpowiedz");
		System.out.println("Odebrany adres: "+response.getReturn().getAdres());
		System.out.println("Odebrany epoch: "+response.getReturn().getEpoch());
	}
}
