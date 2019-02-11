package com.spr.jflow.web.rest;

import com.codahale.metrics.annotation.Timed;
import com.spr.jflow.service.GscontentService;
import com.spr.jflow.web.rest.errors.BadRequestAlertException;
import com.spr.jflow.web.rest.util.HeaderUtil;
import com.spr.jflow.service.dto.GscontentDTO;
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
 * REST controller for managing Gscontent.
 */
@RestController
@RequestMapping("/api")
public class GscontentResource {

    private final Logger log = LoggerFactory.getLogger(GscontentResource.class);

    private static final String ENTITY_NAME = "gscontent";

    private final GscontentService gscontentService;

    public GscontentResource(GscontentService gscontentService) {
        this.gscontentService = gscontentService;
    }

    /**
     * POST  /gscontents : Create a new gscontent.
     *
     * @param gscontentDTO the gscontentDTO to create
     * @return the ResponseEntity with status 201 (Created) and with body the new gscontentDTO, or with status 400 (Bad Request) if the gscontent has already an ID
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PostMapping("/gscontents")
    @Timed
    public ResponseEntity<GscontentDTO> createGscontent(@Valid @RequestBody GscontentDTO gscontentDTO) throws URISyntaxException {
        log.debug("REST request to save Gscontent : {}", gscontentDTO);
        if (gscontentDTO.getId() != null) {
            throw new BadRequestAlertException("A new gscontent cannot already have an ID", ENTITY_NAME, "idexists");
        }
        GscontentDTO result = gscontentService.save(gscontentDTO);
        return ResponseEntity.created(new URI("/api/gscontents/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * PUT  /gscontents : Updates an existing gscontent.
     *
     * @param gscontentDTO the gscontentDTO to update
     * @return the ResponseEntity with status 200 (OK) and with body the updated gscontentDTO,
     * or with status 400 (Bad Request) if the gscontentDTO is not valid,
     * or with status 500 (Internal Server Error) if the gscontentDTO couldn't be updated
     * @throws URISyntaxException if the Location URI syntax is incorrect
     */
    @PutMapping("/gscontents")
    @Timed
    public ResponseEntity<GscontentDTO> updateGscontent(@Valid @RequestBody GscontentDTO gscontentDTO) throws URISyntaxException {
        log.debug("REST request to update Gscontent : {}", gscontentDTO);
        if (gscontentDTO.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        GscontentDTO result = gscontentService.save(gscontentDTO);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(ENTITY_NAME, gscontentDTO.getId().toString()))
            .body(result);
    }

    /**
     * GET  /gscontents : get all the gscontents.
     *
     * @return the ResponseEntity with status 200 (OK) and the list of gscontents in body
     */
    @GetMapping("/gscontents")
    @Timed
    public List<GscontentDTO> getAllGscontents() {
        log.debug("REST request to get all Gscontents");
        return gscontentService.findAll();
    }

    /**
     * GET  /gscontents/:id : get the "id" gscontent.
     *
     * @param id the id of the gscontentDTO to retrieve
     * @return the ResponseEntity with status 200 (OK) and with body the gscontentDTO, or with status 404 (Not Found)
     */
    @GetMapping("/gscontents/{id}")
    @Timed
    public ResponseEntity<GscontentDTO> getGscontent(@PathVariable Long id) {
        log.debug("REST request to get Gscontent : {}", id);
        Optional<GscontentDTO> gscontentDTO = gscontentService.findOne(id);
        return ResponseUtil.wrapOrNotFound(gscontentDTO);
    }

    /**
     * DELETE  /gscontents/:id : delete the "id" gscontent.
     *
     * @param id the id of the gscontentDTO to delete
     * @return the ResponseEntity with status 200 (OK)
     */
    @DeleteMapping("/gscontents/{id}")
    @Timed
    public ResponseEntity<Void> deleteGscontent(@PathVariable Long id) {
        log.debug("REST request to delete Gscontent : {}", id);
        gscontentService.delete(id);
        return ResponseEntity.ok().headers(HeaderUtil.createEntityDeletionAlert(ENTITY_NAME, id.toString())).build();
    }
}
