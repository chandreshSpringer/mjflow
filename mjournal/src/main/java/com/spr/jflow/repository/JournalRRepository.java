package com.spr.jflow.repository;

import com.spr.jflow.domain.JournalR;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;


/**
 * Spring Data  repository for the JournalR entity.
 */
@SuppressWarnings("unused")
@Repository
public interface JournalRRepository extends JpaRepository<JournalR, Long> {
	
JournalR findBys2rIdAndiPosition(Long s2rId,int iPosition);
}
