package pl.ms.gov.eukw.epo;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import pl.asseco.GetHostinfo2;

public class PrzygotujKSIhostinfoProcessor implements Processor {

	@Override
	public void process(Exchange exchange) throws Exception {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String teraz = sdf.format(cal.getTime());
		System.out.println("Zaczynam PrzygotujKSIhostinfoProcessor " + teraz);
		// GetHostinfo1 hi=exchange.getIn().getBody(GetHostinfo1.class);
		GetHostinfo2 hi = new GetHostinfo2();
		hi.setKomunikat("setkomuniat "+ teraz);
		exchange.getIn().setBody("PrzygotujKSIhostinfoProcessor " + teraz);
		exchange.getIn().setBody(hi);
		System.out.println("Skonczylem PrzygotujKSIhostinfoProcessor " + teraz);
	}

}
