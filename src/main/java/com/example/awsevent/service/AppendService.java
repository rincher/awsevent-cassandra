package com.example.awsevent.service;

import com.example.awsevent.domain.Event;
import com.example.awsevent.dto.EventRequestDto;
import com.example.awsevent.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AppendService {
    private final DocumentRepository repository;


    public ResponseEntity<String> appendData(EventRequestDto eventRequestDto) {
        Event event = Event.builder()
                .id(UUID.randomUUID())
                .createdAt(LocalDateTime.now())
                .companyName(eventRequestDto.getCompanyName())
                .message(eventRequestDto.getMessage())
                .time(eventRequestDto.getTime())
                .eventType(eventRequestDto.getEventType())
                .date(eventRequestDto.getDate())
                .eventSource(eventRequestDto.getEventSource())
                .eventMessage(eventRequestDto.getEventMessage())
                .eventName(eventRequestDto.getEventName())
                .startTime(eventRequestDto.getStartTime())
                .lastUpdatedTime(eventRequestDto.getLastUpdatedTime())
                .service(eventRequestDto.getService())
                .region(eventRequestDto.getRegion())
                .eventDescription(eventRequestDto.getEventDescription())
                .sourceIp(eventRequestDto.getSourceIp())
                .requestParameters(eventRequestDto.getRequestParameters())
                .user(eventRequestDto.getUser())
                .statusCode(eventRequestDto.getStatusCode())
                .mfaUsed(eventRequestDto.getMfaUsed())
                .build();
        repository.save(event);
        return ResponseEntity.ok().body("Saved successfully");
    }

    public List<Event> getAllEvents() {
        return repository.findAll();
    }
}