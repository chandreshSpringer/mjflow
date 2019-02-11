package com.spr.jflow.service;

import com.spr.jflow.service.dto.JournalRDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing JournalR.
 */
public interface JournalRService {

    /**
     * Save a journalR.
     *
     * @param journalRDTO the entity to save
     * @return the persisted entity
     */
    JournalRDTO save(JournalRDTO journalRDTO);

    /**
     * Get all the journalRS.
     *
     * @return the list of entities
     */
    List<JournalRDTO> findAll();


    /**
     * Get the "id" journalR.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<JournalRDTO> findOne(Long id);

    /**
     * Delete the "id" journalR.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
