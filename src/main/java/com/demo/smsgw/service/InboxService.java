package com.demo.smsgw.service;

import org.springframework.data.domain.Pageable;

public interface InboxService {
    boolean findInboxByStatus(String status, Pageable pageable);
}
