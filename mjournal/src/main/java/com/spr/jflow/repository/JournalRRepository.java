package com.spr.jflow.repository;

import com.spr.jflow.domain.JournalR;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the JournalR entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JournalRRepository extends JpaRepository<JournalR, Long> {

}
