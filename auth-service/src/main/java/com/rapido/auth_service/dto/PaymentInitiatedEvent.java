public class PaymentInitiatedEvent {

    private String rideId;
    private Double amount;

    public PaymentInitiatedEvent() {
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

}
