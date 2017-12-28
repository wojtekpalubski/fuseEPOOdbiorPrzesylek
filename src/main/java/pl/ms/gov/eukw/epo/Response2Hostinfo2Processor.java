package pl.ms.gov.eukw.epo;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;

import pl.asseco.GetHostinfo2Response;

public class Response2Hostinfo2Processor implements Processor{

	@Override
	public void process(Exchange exchange) throws Exception {
		GetHostinfo2Response h2r=exchange.getIn().getBody(GetHostinfo2Response.class);
		exchange.getIn().setBody(h2r.getReturn());
	}

}
