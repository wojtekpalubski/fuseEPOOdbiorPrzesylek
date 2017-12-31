package pl.ms.gov.eukw.epo.testy;

import org.junit.Test;
import pl.ms.gov.eukw.epo.NadawcaProducer;

public class LosowanieElementuTablicyTest {

    @Test
    public void losowanie1() {
        NadawcaProducer e = new NadawcaProducer();
        String[] tablica = {"a", "b", "c"};
        for (int l=0; l<100; l++) {
            System.out.println(e.wylosujElementtablicy(tablica));
        }
    }
}
