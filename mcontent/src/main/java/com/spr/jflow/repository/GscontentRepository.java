package com.spr.jflow.repository;

import com.spr.jflow.domain.Gscontent;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the Gscontent entity.
 */
@SuppressWarnings("unused")
@Repository
public interface GscontentRepository extends JpaRepository<Gscontent, Long> {

}
