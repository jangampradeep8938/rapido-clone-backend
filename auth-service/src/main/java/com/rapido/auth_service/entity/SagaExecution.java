package com.rapido.auth_service.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class SagaExecution {

    @Id
    private String sagaId;

    private String sagaType;

    private String currentStep;

    private String status;

    public SagaExecution() {
    }

    public String getSagaId() {
        return sagaId;
    }

    public void setSagaId(String sagaId) {
        this.sagaId = sagaId;
    }

    public String getSagaType() {
        return sagaType;
    }

    public void setSagaType(String sagaType) {
        this.sagaType = sagaType;
    }

    public String getCurrentStep() {
        return currentStep;
    }

    public void setCurrentStep(String currentStep) {
        this.currentStep = currentStep;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}