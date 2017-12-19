package pl.ms.gov.eukw.epo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "PrzesylkaEPO")
public class PrzesylkaEPO {
	
	@XmlAttribute(name = "Guid", required = true)
	private String Guid;
	
	@XmlElement(name = "Atrybut")
	private List<Atrybut> atrybut;

	public String getGuid() {
		return Guid;
	}

	public void setGuid(String guid) {
		Guid = guid;
	}

	public List<Atrybut> getAtrybut() {
		return atrybut;
	}

	public void setAtrybut(List<Atrybut> atrybut) {
		this.atrybut = atrybut;
	}

}
