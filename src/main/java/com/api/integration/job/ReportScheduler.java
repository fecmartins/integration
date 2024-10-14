package com.api.integration.job;

import com.api.integration.service.ReportService;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

@Component
public class ReportScheduler {

    private ReportService reportService;

    public ReportScheduler(ReportService reportService) {
        this.reportService = reportService;
    }

    @Scheduled(fixedRate = 5000)
    public void pollReportApi () {

        reportService.pollReportService();
    }
}
