package pl.ms.gov.eukw.epo.testy;

import org.apache.camel.Exchange;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Test;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;

public class KompresjaTest extends CamelSpringTestSupport {
    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext(
                "META-INF/spring/kompresja-camel-context.xml");
    }

    @Test
    public void kompresjaTest() throws InterruptedException {
        template.sendBodyAndHeader("file:kompresja/in",
                "Hello World", Exchange.FILE_NAME, "hello.txt");
        Thread.sleep(1000);
        File target = new File("kompresja/wy/hello.txt");
        assertTrue("File not moved", target.exists());
        String content = context.getTypeConverter()
                .convertTo(String.class, target);
        assertEquals("Hello World", content);
    }
}
