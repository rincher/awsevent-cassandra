package com.example.awsevent.controller;

import com.example.awsevent.domain.Event;
import com.example.awsevent.dto.EventRequestDto;
import com.example.awsevent.service.AppendService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping
@RequiredArgsConstructor

public class EventController {
    private final AppendService appendService;

    @PostMapping("/documents/append")
    public ResponseEntity<?> appendData(@RequestBody EventRequestDto eventRequestDto){
        return appendService.appendData(eventRequestDto);
    }

    @GetMapping("/documents/list")
    public List<Event> getAllEvents(){
        return appendService.getAllEvents();
    }
}
