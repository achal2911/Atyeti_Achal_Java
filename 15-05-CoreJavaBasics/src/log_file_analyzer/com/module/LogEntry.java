package log_file_analyzer.com.module;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class LogEntry {
    private Timestamp timestamp;
    private String userId;
    private String action;

    public LogEntry(Timestamp timestamp, String userId, String action) {
        this.timestamp = timestamp;
        this.userId = userId;
        this.action = action;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    @Override
    public String toString() {
        return "LogEntry{" +
                "timestamp=" + timestamp +
                ", userId='" + userId + '\'' +
                ", action='" + action + '\'' +
                '}';
    }
}

