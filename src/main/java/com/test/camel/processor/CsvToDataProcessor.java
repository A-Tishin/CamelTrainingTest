package com.test.camel.processor;

import com.test.models.Data;
import org.apache.camel.CamelContext;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class CsvToDataProcessor implements Processor {

    @Override
    public void process(Exchange exchange) throws Exception {
        List<List<String>> csvStringList = (List<List<String>>) exchange.getIn().getBody();
        List<Data> dataList = new ArrayList<>();
        for (var i = 1; i < csvStringList.size(); i++) {
            List<String> list = csvStringList.get(i);
            if (list.get(3).equals("Offline")) {
                continue;
            }

            Data data = new Data(
                    list.get(0), list.get(1), list.get(2),
                    list.get(3), list.get(4), list.get(5),
                    Long.parseLong(list.get(6)), list.get(7),
                    Integer.parseInt(list.get(8)),
                    Double.parseDouble(list.get(9)),
                    Double.parseDouble(list.get(10)),
                    Double.parseDouble(list.get(11)),
                    Double.parseDouble(list.get(12)),
                    Double.parseDouble(list.get(13)));

            dataList.add(data);
        }

        exchange.getIn().setBody(dataList);
    }
}
