package com.test.repository;

import com.test.models.RegionReport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegionReportRepository extends JpaRepository<RegionReport, Integer> {
}
