package model;

import java.sql.Timestamp;
import java.time.Instant;

public class LogEntryData {

    private Instant timestamp;
    private String level;
    private String message;

    public LogEntryData(Instant timestamp, String level, String message) {
        this.timestamp = timestamp;
        this.level = level;
        this.message = message;
    }

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return
                "timestamp=" + timestamp +
                ", level='" + level +
                ", message='" + message ;
    }
}
