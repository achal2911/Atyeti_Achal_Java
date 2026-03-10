package collections_and_streams.transaction_analyzer_system.model;

import java.sql.Timestamp;

public class Transactions {

    private String userId;
    private int amount;
    private Timestamp timestamp;

    public Transactions(String userId, int amount, Timestamp timestamp) {
        this.userId = userId;
        this.amount = amount;
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "userId='" + userId + ", amount=" + amount + ", timestamp=" + timestamp;
    }
}
