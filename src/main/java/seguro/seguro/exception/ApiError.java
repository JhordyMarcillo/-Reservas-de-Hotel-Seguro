package com.example.hotelreservas.exception;

import java.time.LocalDateTime;

public class ApiError {

    private final int status;
    private final String error;
    private final LocalDateTime timestamp;

    public ApiError(int status, String error) {
        this.status = status;
        this.error = error;
        this.timestamp = LocalDateTime.now();
    }

    public int getStatus() {
        return status;
    }

    public String getError() {
        return error;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }
}
