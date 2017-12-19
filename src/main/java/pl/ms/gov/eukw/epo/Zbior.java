package pl.ms.gov.eukw.epo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "Zbior")
public class Zbior {

	@XmlAttribute(name = "DataUtworzenia", required = true)
	private String DataUtworzenia;

	@XmlAttribute(name = "Guid", required = true)
	private String Guid;
	
	@XmlAttribute(name = "IloscPrzesylek", required = true)
	private Integer IloscPrzesylek;
	
	@XmlAttribute(name = "Opis", required = true)
	private String Opis;
	
	@XmlElement(name = "PrzesylkaEPO")
	private List<PrzesylkaEPO> przesylkaEPO;

	public String getDataUtworzenia() {
		return DataUtworzenia;
	}

	public void setDataUtworzenia(String dataUtworzenia) {
		DataUtworzenia = dataUtworzenia;
	}

	public String getGuid() {
		return Guid;
	}

	public void setGuid(String guid) {
		Guid = guid;
	}

	public Integer getIloscPrzesylek() {
		return IloscPrzesylek;
	}

	public void setIloscPrzesylek(Integer iloscPrzesylek) {
		IloscPrzesylek = iloscPrzesylek;
	}

	public String getOpis() {
		return Opis;
	}

	public void setOpis(String opis) {
		Opis = opis;
	}

	public List<PrzesylkaEPO> getPrzesylkaEPO() {
		return przesylkaEPO;
	}

	public void setPrzesylkaEPO(List<PrzesylkaEPO> przesylkaEPO) {
		this.przesylkaEPO = przesylkaEPO;
	}
}
