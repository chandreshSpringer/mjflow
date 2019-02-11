package com.spr.jflow.service;

import com.spr.jflow.service.dto.GscontentDTO;

import java.util.List;
import java.util.Optional;

/**
 * Service Interface for managing Gscontent.
 */
public interface GscontentService {

    /**
     * Save a gscontent.
     *
     * @param gscontentDTO the entity to save
     * @return the persisted entity
     */
    GscontentDTO save(GscontentDTO gscontentDTO);

    /**
     * Get all the gscontents.
     *
     * @return the list of entities
     */
    List<GscontentDTO> findAll();


    /**
     * Get the "id" gscontent.
     *
     * @param id the id of the entity
     * @return the entity
     */
    Optional<GscontentDTO> findOne(Long id);

    /**
     * Delete the "id" gscontent.
     *
     * @param id the id of the entity
     */
    void delete(Long id);
}
