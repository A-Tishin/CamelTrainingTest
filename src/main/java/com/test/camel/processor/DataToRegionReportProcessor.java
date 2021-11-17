package com.test.camel.processor;

import com.test.models.Data;
import com.test.models.RegionReport;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class DataToRegionReportProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        List<Data> dataList = (List<Data>) exchange.getIn().getBody();
        List<RegionReport> reportList = new ArrayList<>();

        Map<String, List<Data>> regionMap = dataList.stream()
                .collect(Collectors.groupingBy(Data::getRegion));

        for (String regionKey : regionMap.keySet()) {
            Map<String, List<Data>> countryMap = regionMap
                    .get(regionKey)
                    .stream()
                    .collect(Collectors.groupingBy(Data::getCountry));

            for (String key : countryMap.keySet()) {
                List<Data> list = countryMap.get(key);
                RegionReport report = new RegionReport(regionKey, key, list.size(),
                        list.stream().mapToDouble(Data::getUnitsSold).average().getAsDouble(),
                        list.stream().mapToDouble(Data::getUnitPrice).average().getAsDouble(),
                        list.stream().mapToDouble(Data::getUnitCost).average().getAsDouble(),
                        (list.stream().mapToDouble(Data::getTotalRevenue).sum())/1_000_000,
                        (list.stream().mapToDouble(Data::getUnitCost).sum())/1_000_000,
                        (list.stream().mapToDouble(Data::getTotalProfit).sum())/1_000_000);

                reportList.add(report);
            }
        }

        exchange.getIn().setBody(reportList);
    }
}
