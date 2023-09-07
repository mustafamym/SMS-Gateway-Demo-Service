package com.demo.smsgw.repository;

import com.demo.smsgw.model.Outbox;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OutboxRepository extends JpaRepository<Outbox, Integer> {

}

