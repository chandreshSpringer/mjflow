package com.spr.jflow.repository;

import com.spr.jflow.domain.JournalS;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the JournalS entity.
 */
@SuppressWarnings("unused")
@Repository
@Component
public interface JournalSRepository extends JpaRepository<JournalS, Long> {

}
