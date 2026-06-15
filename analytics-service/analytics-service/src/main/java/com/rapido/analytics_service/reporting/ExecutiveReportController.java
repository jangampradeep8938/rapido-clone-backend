package com.rapido.analytics_service.reporting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ExecutiveReportController {

    @GetMapping("/analytics/reports")
    public Map<String, Object> generateReports() {

        return Map.of(
                "ceoReport", "CEO Daily Report Generated",
                "operationsReport", "Operations Report Generated",
                "financeReport", "Finance Report Generated",
                "formats", "PDF, CSV, Excel"
        );
    }
}