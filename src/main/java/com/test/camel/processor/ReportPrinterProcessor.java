package com.test.camel.processor;

import com.test.models.RegionReport;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Component
public class ReportPrinterProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        List<RegionReport> list = (List<RegionReport>) exchange.getIn().getBody();
        Map<String, List<RegionReport>> regionMap = list.stream()
                .collect(Collectors.groupingBy(RegionReport::getRegion));

        for (String key : regionMap.keySet()) {
            String timeStamp = new SimpleDateFormat("yyyy-MM-dd-HH-mm").format(new Date());
            var a = Files.createDirectories(Paths.get("out\\reports\\" + timeStamp));
            File csvOutputFile = new File(
                    a + "\\" + key + ".csv");
            PrintWriter pw = new PrintWriter(csvOutputFile);

            List<RegionReport> reportList = regionMap.get(key);
            reportList.stream().map(RegionReport::toString).forEach(pw::println);
            pw.close();
        }

    }
}
