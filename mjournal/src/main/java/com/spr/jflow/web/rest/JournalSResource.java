package com.spr.jflow.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.spr.jflow.service.JournalSService;
import com.spr.jflow.web.rest.errors.BadRequestAlertException;
import com.spr.jflow.web.rest.util.HeaderUtil;
import com.spr.jflow.service.dto.JournalSDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing JournalS.
 */
@RestController
@RequestMapping("/api")
public class JournalSResource {

    private final Logger log = LoggerFactory.getLogger(JournalSResource.class);

    private static final String ENTITY_NAME = "journalS";

    private final JournalSService journalSService;

    public JournalSResource(JournalSService journalSService) {
        this.journalSService = journalSService;
    }

    /**
     * POST  /journal-s : Create a new journalS.
     *
     * @param journalSDTO the journalSDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new journalSDTO, or with status 400 (Bad Request) if the journalS has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/journal-s")
    @Timed
    public ResponseEntity<JournalSDTO> createJournalS(@Valid @RequestBody JournalSDTO journalSDTO) throws URISyntaxException {
        log.debug("REST request to save JournalS : {}", journalSDTO);
        if (journalSDTO.getId() != null) {
            throw new BadRequestAlertException("A new journalS cannot already have an ID", ENTITY_NAME, "idexists");
        }
        JournalSDTO result = journalSService.save(journalSDTO);
        return ResponseEntity.created(new URI("/api/journal-s/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /journal-s : Updates an existing journalS.
     *
     * @param journalSDTO the journalSDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated journalSDTO,
     * or with status 400 (Bad Request) if the journalSDTO is not valid,
     * or with status 500 (Internal Server Error) if the journalSDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/journal-s")
    @Timed
    public ResponseEntity<JournalSDTO> updateJournalS(@Valid @RequestBody JournalSDTO journalSDTO) throws URISyntaxException {
        log.debug("REST request to update JournalS : {}", journalSDTO);
        if (journalSDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        JournalSDTO result = journalSService.save(journalSDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, journalSDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /journal-s : get all the journalS.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of journalS in body
     */
    @GetMapping("/journal-s")
    @Timed
    public List<JournalSDTO> getAllJournalS() {
        log.debug("REST request to get all JournalS");
        return journalSService.findAll();
    }

    /**
     * GET  /journal-s/:id : get the "id" journalS.
     *
     * @param id the id of the journalSDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the journalSDTO, or with status 404 (Not Found)
     */
    @GetMapping("/journal-s/{id}")
    @Timed
    public ResponseEntity<JournalSDTO> getJournalS(@PathVariable Long id) {
        log.debug("REST request to get JournalS : {}", id);
        Optional<JournalSDTO> journalSDTO = journalSService.findOne(id);
        return ResponseUtil.wrapOrNotFound(journalSDTO);
    }

    /**
     * DELETE  /journal-s/:id : delete the "id" journalS.
     *
     * @param id the id of the journalSDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/journal-s/{id}")
    @Timed
    public ResponseEntity<Void> deleteJournalS(@PathVariable Long id) {
        log.debug("REST request to delete JournalS : {}", id);
        journalSService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
