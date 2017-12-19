package pl.ms.gov.eukw.epo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Nadawca", namespace="http://msepo.gov.pl/epo/XSD/EKN.xsd")
public class Nadawca {

	public String getStruktura() {
		return Struktura;
	}

	public void setStruktura(String struktura) {
		Struktura = struktura;
	}

	public String getGuid() {
		return Guid;
	}

	public void setGuid(String guid) {
		Guid = guid;
	}

	public String getZrodlo() {
		return Zrodlo;
	}

	public void setZrodlo(String zrodlo) {
		Zrodlo = zrodlo;
	}

	public String getNIP() {
		return NIP;
	}

	public void setNIP(String nIP) {
		NIP = nIP;
	}

	public String getKod() {
		return Kod;
	}

	public void setKod(String kod) {
		Kod = kod;
	}

	public String getMiejscowosc() {
		return Miejscowosc;
	}

	public void setMiejscowosc(String miejscowosc) {
		Miejscowosc = miejscowosc;
	}

	public String getUlica() {
		return Ulica;
	}

	public void setUlica(String ulica) {
		Ulica = ulica;
	}

	public String getDom() {
		return Dom;
	}

	public void setDom(String dom) {
		Dom = dom;
	}

	public String getLokal() {
		return Lokal;
	}

	public void setLokal(String lokal) {
		Lokal = lokal;
	}

	public String getNazwa() {
		return Nazwa;
	}

	public void setNazwa(String nazwa) {
		Nazwa = nazwa;
	}

	public Zbior getZbior() {
		return zbior;
	}

	public void setZbior(Zbior zbior) {
		this.zbior = zbior;
	}

	@XmlAttribute(name = "Struktura", required = true)
	private String Struktura;

	@XmlAttribute(name = "Guid", required = true)
	private String Guid;

	@XmlAttribute(name = "Zrodlo", required = true)
	private String Zrodlo;

	@XmlAttribute(name = "NIP", required = true)
	private String NIP;

	@XmlAttribute(name = "Kod", required = true)
	private String Kod;

	@XmlAttribute(name = "Miejscowosc", required = true)
	private String Miejscowosc;

	@XmlAttribute(name = "Ulica", required = true)
	private String Ulica;

	@XmlAttribute(name = "Dom", required = true)
	private String Dom;

	@XmlAttribute(name = "Lokal", required = true)
	private String Lokal;

	@XmlAttribute(name = "Nazwa", required = true)
	private String Nazwa;
	
	@XmlAttribute(name = "NazwaSkrocona", required = true)
	private String NazwaSkrocona;

	public String getNazwaSkrocona() {
		return NazwaSkrocona;
	}

	public void setNazwaSkrocona(String nazwaSkrocona) {
		NazwaSkrocona = nazwaSkrocona;
	}

	@XmlElement(name = "Zbior")
	private Zbior zbior;

}
