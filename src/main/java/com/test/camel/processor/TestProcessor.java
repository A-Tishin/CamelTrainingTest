package com.test.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.Locale;

@Component
public class TestProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        exchange.getIn().setBody(exchange.getIn().getBody(String.class).toUpperCase(Locale.ROOT));
    }
}
