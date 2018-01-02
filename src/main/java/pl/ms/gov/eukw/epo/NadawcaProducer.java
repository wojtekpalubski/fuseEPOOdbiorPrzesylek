package pl.ms.gov.eukw.epo;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

public class NadawcaProducer {
	Integer iloscPrzesylek = 2;

	String[] miejscowosci = { "Warszawa", "Wrocław", "Kraków" };
	String[] ulice = { "Marszałkowska", "Czerniakowska", "al. Jerozolimskie" };

	public Nadawca utworzNadawce() {
		Nadawca n = new Nadawca();
		n.setGuid("{" + UUID.randomUUID().toString() + "}");
		n.setStruktura("1.6");
		n.setZrodlo("Sąd");
		n.setNIP(Integer.toString(wylosujInteger(111111111, 999999999)));
		n.setKod(Integer.toString(wylosujInteger(10, 99)) + "-" + Integer.toString(wylosujInteger(100, 999)));
		n.setLokal(Integer.toString(wylosujInteger(1, 100)));
		n.setMiejscowosc(wylosujElementtablicy(miejscowosci));
		n.setNazwa("nazwa");
		n.setNazwaSkrocona("nazwa skrocona");
		n.setDom(Integer.toString(wylosujInteger(1, 100)));
		n.setUlica(wylosujElementtablicy(ulice));

		n.setZbior(utworzZbior());
		return n;
	}

	/**
	 * @return
	 */
	private Zbior utworzZbior() {
		Zbior z = new Zbior();
		z.setGuid("{" + UUID.randomUUID().toString() + "}");
		z.setOpis("##" + wylosujInteger(1, 50000) + "/17#####" + wylosujInteger(1, 50000) + "/17###");
		z.setDataUtworzenia(getDataCzas());
		z.setIloscPrzesylek(this.iloscPrzesylek);
		z.setPrzesylkaEPO(utworzPrzesylkiEPO());
		return z;
	}

	private List<PrzesylkaEPO> utworzPrzesylkiEPO() {
		List<PrzesylkaEPO> lp = new ArrayList();
		for (int i = 0; i < this.iloscPrzesylek; i++) {
			PrzesylkaEPO p = new PrzesylkaEPO();
			p.setGuid("{" + UUID.randomUUID().toString() + "}");
			p.setAtrybut(utworzAtrybuty());
			lp.add(p);
		}
		return lp;
	}

	private List<Atrybut> utworzAtrybuty() {
		List<Atrybut> la = new ArrayList<Atrybut>();
		la.add(utworzAtrybut("Adresat", "Nazwa", "aaa"));
		la.add(utworzAtrybut("Adresat", "Kraj", "Polska"));
		la.add(utworzAtrybut("Adresat", "Kod", Integer.toString(wylosujInteger(11111, 99999))));
		la.add(utworzAtrybut("Adresat", "Miejscowosc", wylosujElementtablicy(miejscowosci)));
		la.add(utworzAtrybut("Adresat", "Ulica", wylosujElementtablicy(ulice)));
		la.add(utworzAtrybut("Adresat", "Dom", Integer.toString(wylosujInteger(1, 99))));
		la.add(utworzAtrybut("Adresat", "Lokal", Integer.toString(wylosujInteger(1, 99))));
		la.add(utworzAtrybut("", "Masa", "50"));
		la.add(utworzAtrybut("", "DataNadania", getData()));
		la.add(utworzAtrybut("", "NrNadania", Integer.toString(wylosujInteger(1, 99))));
		la.add(utworzAtrybut("", "Symbol", Integer.toString(wylosujInteger(1, 999))));
		la.add(utworzAtrybut("", "Umowa", ""));
		la.add(utworzAtrybut("", "KartaUmowy", ""));
		la.add(utworzAtrybut("", "Kategoria", "E"));
		la.add(utworzAtrybut("", "PosteRestante", "N"));
		la.add(utworzAtrybut("", "EgzBibl", "N"));
		la.add(utworzAtrybut("", "DlaOciemn", "N"));
		la.add(utworzAtrybut("", "Uslugi", "ROX"));
		la.add(utworzAtrybut("", "IloscPotwOdb", "1"));
		la.add(utworzAtrybut("", "Strefa", "A"));
		la.add(utworzAtrybut("", "Wersja", "1"));
		la.add(utworzAtrybut("", "Oplacenie", "Z"));
		la.add(utworzAtrybut("", "Sygnatura", "I ACa "+Integer.toString(wylosujInteger(1, 99))+"/"+Integer.toString(wylosujInteger(1, 99))));
		la.add(utworzAtrybut("", "Rodzaj", "rodzaj"));
		return la;
	}

	private Atrybut utworzAtrybut(String typ, String nazwa, String wartosc) {
		Atrybut a = new Atrybut();
		a.setNazwa(nazwa);
		a.setTyp(typ);
		a.setWartosc(wartosc);
		return a;
	}

	public String wylosujElementtablicy(String[] tablica) {
		String element;
		if (tablica.length == 0) {
			return "";
		}
		int indeks = ThreadLocalRandom.current().nextInt(0, tablica.length);
		element = tablica[indeks];
		return element;
	}

	private int wylosujInteger(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max);
	}

	private String getDataCzas() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
		return sdf.format(cal.getTime());
	}
	private String getData() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd");
		return sdf.format(cal.getTime());
	}
}
