package com.demo.smsgw.repository;


import com.demo.smsgw.model.Inbox;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InboxRepository extends JpaRepository<Inbox, Integer> {

    @Query("SELECT i FROM Inbox i WHERE i.status=?1")
    Page<Inbox> findAllByStatusIs(String status, Pageable pageable);

}

