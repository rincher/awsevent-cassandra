package com.example.awsevent.service;

import com.example.awsevent.repository.DocumentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class CleanUpService {
    private final DocumentRepository documentRepository;

    @Scheduled(cron = "0 0 0 * * ?")
    public void cleanupOldData(){
        LocalDateTime thirtyDaysAgo = LocalDateTime.now().minusDays(30);
        documentRepository.deleteOldEvents(thirtyDaysAgo);
        System.out.println("Deleted records older than 30 days");
    }
}
