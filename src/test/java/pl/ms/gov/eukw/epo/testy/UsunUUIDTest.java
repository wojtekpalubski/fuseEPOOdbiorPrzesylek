package pl.ms.gov.eukw.epo.testy;

import org.junit.Test;

import pl.ms.gov.eukw.epo.DodajWysylkeRequestResponseBean;

public class UsunUUIDTest {

	@Test
	public void test() {
		String body="--uuid:7b9c0933-9994-45d9-aaf6-ffba83979126\r\n" + 
				"Content-Type: application/xop+xml; charset=UTF-8; type=\"text/xml\"\r\n" + 
				"Content-Transfer-Encoding: binary\r\n" + 
				"Content-ID: <root.message@cxf.apache.org>\r\n" + 
				"\r\n" + 
				"<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\"><soap:Body><ns2:dodajWysylkeResponse xmlns:ns2=\"http://ms.gov.pl/ekw/channel/mse\r\n" + 
				"pocentralnyrejestrzwrotek/\"><wynik><status>true</status></wynik></ns2:dodajWysylkeResponse></soap:Body></soap:Envelope>\r\n" + 
				"--uuid:7b9c0933-9994-45d9-aaf6-ffba83979126--";
		DodajWysylkeRequestResponseBean rb=new DodajWysylkeRequestResponseBean();
		System.out.println(body);
		System.out.println("===");
		System.out.println(rb.usunUUID(body));
	}

}
