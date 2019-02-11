package com.spr.jflow.service;

import com.spr.jflow.service.dto.JournalSDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing JournalS.
 */
public interface JournalSService {

    /**
     * Save a journalS.
     *
     * @param journalSDTO the entity to save
     * @return the persisted entity
     */
    JournalSDTO save(JournalSDTO journalSDTO);

    /**
     * Get all the journalS.
     *
     * @return the list of entities
     */
    List<JournalSDTO> findAll();


    /**
     * Get the "id" journalS.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<JournalSDTO> findOne(Long id);

    /**
     * Delete the "id" journalS.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
