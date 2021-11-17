package com.test.repository;

import com.test.models.Data;
import com.test.models.RegionReport;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class Database {

    @Autowired
    DataRepository dataRepository;
    @Autowired
    RegionReportRepository reportRepository;
//
//    public Database(DataRepository dataRepository, RegionReportRepository reportRepository) {
//        this.dataRepository = dataRepository;
//        this.reportRepository = reportRepository;
//    }

    public void sendDataToDb(List<Data> dataList) {
        for (int i = 0; i < dataList.size(); i = i + 1000) {
            if (i + 1000 > dataList.size()) {
                List<Data> subDataList = dataList.subList(i, dataList.size() - 1);
                dataRepository.saveAll(subDataList);
                break;
            }

            List<Data> subDataList = dataList.subList(i, i + 1000);
            dataRepository.saveAll(subDataList);
        }
    }

    public void sendReportToDb(List<RegionReport> reportList) {
        reportRepository.saveAll(reportList);
    }

    public List<Data> getDataList() {
        return dataRepository.findAll();
    }

    public List<RegionReport> getReportList() {
        return reportRepository.findAll();
    }
}
