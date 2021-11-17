package CamelRoutesTests;


import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.camel.Exchange;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.test.spring.CamelSpringTestSupport;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ComponentScan(basePackages = {"com.test"})
public class CamelTest extends CamelSpringTestSupport {

    @Override
    public void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected AbstractApplicationContext createApplicationContext() {
        return new ClassPathXmlApplicationContext("spring-camel.xml", "CamelRouteTest.xml");
    }

    @Test
    public void testRouteTest() throws InterruptedException {
        MockEndpoint mock = getMockEndpoint("direct:end");
        mock.expectedMessageCount(1);
        template.sendBody("direct:start", "test");
        assertMockEndpointsSatisfied();
        Exchange exchange = (Exchange) mock.getReceivedExchanges();
        String body = exchange.getIn().getBody(String.class);
        Assert.assertEquals("TEST", body);
    }

}
