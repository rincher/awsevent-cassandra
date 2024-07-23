package com.example.awsevent.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EventRequestDto {
    private String companyName;
    private String message;
    private String time;
    private String eventType;
    private String date;
    private String eventSource;
    private String eventMessage;
    private String eventName;
    private String startTime;
    private String lastUpdatedTime;
    private String service;
    private String region;
    private String eventDescription;
    private String sourceIp;
    private String requestParameters;
    private String user;
    private String statusCode;
    private String mfaUsed;
}
