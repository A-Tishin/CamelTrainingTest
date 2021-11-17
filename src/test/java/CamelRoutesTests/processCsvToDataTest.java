package CamelRoutesTests;

import org.apache.camel.*;
import org.apache.camel.builder.AdviceWithRouteBuilder;
import org.apache.camel.component.mock.MockEndpoint;
import org.apache.camel.spring.spi.XmlCamelContextConfigurer;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest
@SpringBootApplication
@ContextConfiguration(locations = { "classpath:/spring-camel.xml" })
public class processCsvToDataTest {

    @Autowired
    XmlCamelContextConfigurer camelContext;
    @Autowired ProducerTemplate producerTemplate;

    @EndpointInject("mock:direct:foo")
    protected MockEndpoint mockA;

    @Test
    public void processCsvToDataRouteTest() throws Exception {
//        AdviceWithRouteBuilder.adviceWith(camelContext, "processCsvToData-route", routeBuilder -> {
//            routeBuilder.replaceFromWith("direct:start");
//        });
//        camelContext.start();
//        mockA.expectedMessageCount(1);
//        mockA.whenAnyExchangeReceived(new MockCsvToDataProcessor());
//
//        producerTemplate.sendBody("direct:start",
//                "Australia and Oceania,Tuvalu,Baby Food,Online,H,5/28/2010,669165933,6/27/2010,9925,255.28,159.42,2533654,1582243.5,951410.5");
//        mockA.assertIsSatisfied();
    }
}

class MockCsvToDataProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setBody("Body");
    }
}
