package com.example.awsevent.repository;

import com.example.awsevent.domain.Event;
import org.springframework.data.cassandra.repository.AllowFiltering;
import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository
public interface DocumentRepository extends CassandraRepository<Event, UUID> {
    @Query("SELECT * FROM event ORDER BY createdAt DESC")
    List<Event> findAllOrderByCreatedAtDesc();
    @Query("DELETE FROM event WHERE createdAt <?0")
    void deleteOldEvents(LocalDateTime date);
}
