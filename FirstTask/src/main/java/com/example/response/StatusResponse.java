package com.example.response;

import java.util.List;

public class StatusResponse<T> {
    int statusCode;
    String statusMessage;
    boolean success;
    Long totalCount;
    String token;

    //  @JsonIgnore
    List<T> data;

    public StatusResponse() {
    }

    public StatusResponse(int statusCode, String statusMessage, boolean success) {
        this.statusCode = statusCode;
        this.statusMessage = statusMessage;
        this.success = success;
    }

    public StatusResponse(int value, String userNotFound, boolean b, Object o, Object o1, Object o2) {
    }

    public int getStatusCode() {
        return this.statusCode;
    }
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }
    public String getStatusMessage() {
        return this.statusMessage;
    }
    public void setStatusMessage(String statusMessage) {
        this.statusMessage = statusMessage;
    }
    public boolean isSuccess() {
        return this.success;
    }
    public void setSuccess(boolean success) {
        this.success = success;
    }
    public Long getTotalCount() {
        return this.totalCount;
    }
    public void setTotalCount(Long totalCount) {
        this.totalCount = totalCount;
    }
    public String getToken() {
        return this.token;
    }
    public void setToken(String token) {
        this.token = token;
    }
    public List<T> getData() {
        return this.data;
    }
    public void setData(List<T> data) {
        this.data = data;
    }
    public String toString() {
        return "StatusResponse [statusCode=" + this.statusCode + ", statusMessage=" + this.statusMessage + ", success=" + this.success + ", totalCount=" + this.totalCount + ", token=" + this.token + ", data=" + this.data + "]";
    }
}

