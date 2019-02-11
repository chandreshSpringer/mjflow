package com.spr.jflow.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.spr.jflow.service.JournalRService;
import com.spr.jflow.web.rest.errors.BadRequestAlertException;
import com.spr.jflow.web.rest.util.HeaderUtil;
import com.spr.jflow.service.dto.JournalRDTO;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.net.URISyntaxException;

import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing JournalR.
 */
@RestController
@RequestMapping("/api")
public class JournalRResource {

    private final Logger log = LoggerFactory.getLogger(JournalRResource.class);

    private static final String ENTITY_NAME = "journalR";

    private final JournalRService journalRService;

    public JournalRResource(JournalRService journalRService) {
        this.journalRService = journalRService;
    }

    /**
     * POST  /journal-rs : Create a new journalR.
     *
     * @param journalRDTO the journalRDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new journalRDTO, or with status 400 (Bad Request) if the journalR has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/journal-rs")
    @Timed
    public ResponseEntity<JournalRDTO> createJournalR(@RequestBody JournalRDTO journalRDTO) throws URISyntaxException {
        log.debug("REST request to save JournalR : {}", journalRDTO);
        if (journalRDTO.getId() != null) {
            throw new BadRequestAlertException("A new journalR cannot already have an ID", ENTITY_NAME, "idexists");
        }
        JournalRDTO result = journalRService.save(journalRDTO);
        return ResponseEntity.created(new URI("/api/journal-rs/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /journal-rs : Updates an existing journalR.
     *
     * @param journalRDTO the journalRDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated journalRDTO,
     * or with status 400 (Bad Request) if the journalRDTO is not valid,
     * or with status 500 (Internal Server Error) if the journalRDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/journal-rs")
    @Timed
    public ResponseEntity<JournalRDTO> updateJournalR(@RequestBody JournalRDTO journalRDTO) throws URISyntaxException {
        log.debug("REST request to update JournalR : {}", journalRDTO);
        if (journalRDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        JournalRDTO result = journalRService.save(journalRDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, journalRDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /journal-rs : get all the journalRS.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of journalRS in body
     */
    @GetMapping("/journal-rs")
    @Timed
    public List<JournalRDTO> getAllJournalRS() {
        log.debug("REST request to get all JournalRS");
        return journalRService.findAll();
    }

    /**
     * GET  /journal-rs/:id : get the "id" journalR.
     *
     * @param id the id of the journalRDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the journalRDTO, or with status 404 (Not Found)
     */
    @GetMapping("/journal-rs/{id}")
    @Timed
    public ResponseEntity<JournalRDTO> getJournalR(@PathVariable Long id) {
        log.debug("REST request to get JournalR : {}", id);
        Optional<JournalRDTO> journalRDTO = journalRService.findOne(id);
        return ResponseUtil.wrapOrNotFound(journalRDTO);
    }

    /**
     * DELETE  /journal-rs/:id : delete the "id" journalR.
     *
     * @param id the id of the journalRDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/journal-rs/{id}")
    @Timed
    public ResponseEntity<Void> deleteJournalR(@PathVariable Long id) {
        log.debug("REST request to delete JournalR : {}", id);
        journalRService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
