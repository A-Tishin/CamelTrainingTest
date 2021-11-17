package com.test.camel.processor;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

@Component
public class HelloWorldProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        System.out.println("Hello world, consumed a file named " + exchange.getIn().getHeader("CamelFileName"));
    }
}
