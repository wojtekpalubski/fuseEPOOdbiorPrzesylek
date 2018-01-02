package pl.ms.gov.eukw.epo;

import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import javax.xml.transform.Source;

import org.apache.camel.Exchange;
import org.apache.camel.component.cxf.CxfPayload;
import org.apache.cxf.binding.soap.SoapHeader;
import org.w3c.dom.Element;

import pl.gov.ms.ekw.channel.msepocentralnyrejestrzwrotek.DodajWysylke;
import pl.gov.ms.ekw.channel.msepocentralnyrejestrzwrotek.DodajWysylkeResponse;
import pl.gov.ms.ekw.channel.msepocentralnyrejestrzwrotek.StatusDodania;
import pl.gov.ms.ekw.channel.msepocentralnyrejestrzwrotek.Wysylka;

public class DodajWysylkeRequestResponseBean {
	public Wysylka createSoapRequest(Exchange exchange) {
		PrzesylkaEPO p = exchange.getIn().getBody(PrzesylkaEPO.class);
		String EKN_GUID = exchange.getIn().getHeader("ZBIOR_GUID").toString();

		String ZBIOR_DATA_UTWORZENIA = exchange.getIn().getHeader("ZBIOR_DATA_UTWORZENIA").toString();
		GregorianCalendar c = new GregorianCalendar();
		c.set(2017, 1, 2);
		XMLGregorianCalendar ZBIOR_DATA_UTWORZENIA_XML = null;
		try {
			ZBIOR_DATA_UTWORZENIA_XML = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Wysylka w = new Wysylka();
		w.setEknGuid(EKN_GUID);
		w.setEknDatautworzenia(ZBIOR_DATA_UTWORZENIA_XML);
		w.setWkwId(exchange.getIn().getHeader("JMSReplyTo").toString());
		try {
			w.setEknDataWyslania(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w.setEknStatus("WYSLANO");
		w.setPrzesylkaNumer("1");
		DodajWysylke dw = new DodajWysylke();
		dw.setParametry(w);
		return w;
	}

	public String usunUUID(String body) {
		body = body.replaceAll("--uuid:.*", "");
		return body;
	}

	public DodajWysylke createSoapPayloadRequest(Exchange exchange) {
		CxfPayload<SoapHeader> requestPayload = exchange.getIn().getBody(CxfPayload.class);
		List<Source> inElements = requestPayload.getBodySources();
		List<Source> outElements = new ArrayList<Source>();

		PrzesylkaEPO p = exchange.getIn().getBody(PrzesylkaEPO.class);
		String EKN_GUID = exchange.getIn().getHeader("ZBIOR_GUID").toString();

		String ZBIOR_DATA_UTWORZENIA = exchange.getIn().getHeader("ZBIOR_DATA_UTWORZENIA").toString();
		GregorianCalendar c = new GregorianCalendar();
		c.set(2017, 1, 2);
		XMLGregorianCalendar ZBIOR_DATA_UTWORZENIA_XML = null;
		try {
			ZBIOR_DATA_UTWORZENIA_XML = DatatypeFactory.newInstance().newXMLGregorianCalendar(c);
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Wysylka w = new Wysylka();
		w.setEknGuid(EKN_GUID);
		w.setEknDatautworzenia(ZBIOR_DATA_UTWORZENIA_XML);
		w.setWkwId(exchange.getIn().getHeader("JMSReplyTo").toString());
		try {
			w.setEknDataWyslania(DatatypeFactory.newInstance().newXMLGregorianCalendar(new GregorianCalendar()));
		} catch (DatatypeConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		w.setEknStatus("WYSLANO");
		w.setPrzesylkaNumer("1");
		DodajWysylke dw = new DodajWysylke();
		dw.setParametry(w);
		return dw;
	}

	public void procesSoapPojoResponse(Exchange exchange) {
		StatusDodania sd=exchange.getIn().getBody(StatusDodania.class);
		System.out.println("Status dodania: "+sd.isStatus());
	}
	
	public void procesSoapMessageResponse(DodajWysylkeResponse response) {
		System.out.println("Procesuje odpowiedz DodajWysylkeResponse");
		System.out.println("Status = "+response.getWynik());
	}

//	public void procesSoapMessageResponse(Exchange exchange) {
//		System.out.println("Procesuje odpowiedz message");
//		// System.out.println("ilosc zalacznikow:
//		// "+exchange.getIn().getAttachments().size());
//		String body = exchange.getIn().getBody(String.class);
//		body = usunUUID(body);
//		System.out.println("body=" + body + "=");
//		exchange.getIn().setBody(body);
//	}

	public void UsunUUID(Exchange exchange) {
		System.out.println("Procesuje odpowiedz message");
		// System.out.println("ilosc zalacznikow:
		// "+exchange.getIn().getAttachments().size());
		String body = exchange.getIn().getBody(String.class);
		body = usunUUID(body);
		System.out.println("body=" + body + "=");
		exchange.getIn().setBody(body);
	}

	public void procesSoapPayloadResponse(Exchange exchange) {
		System.out.println("Procesuje odpowiedz payload");
		CxfPayload<SoapHeader> requestPayload = exchange.getIn().getBody(CxfPayload.class);
		List<Source> inElements = requestPayload.getBodySources();
		List<Element> le = requestPayload.getBody();
		String request = exchange.getIn().getBody(String.class);
		System.out.println("request=" + request);
		for (Element s : le) {
			System.out.println("==" + s);
		}
		// Element in = new XmlConverter().toDOMElement(inElements.get(0));
	}

}
