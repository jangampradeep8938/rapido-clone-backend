package com.rapido.analytics_service.reporting;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class DocumentationController {

    @GetMapping("/analytics/documentation")
    public Map<String, String> getDocumentation() {

        return Map.of(
                "apiDocumentation", "Completed",
                "architectureDocumentation", "Completed",
                "deploymentInstructions", "Completed"
        );
    }
}