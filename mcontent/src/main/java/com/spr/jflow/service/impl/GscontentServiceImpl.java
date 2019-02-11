package com.spr.jflow.service.impl;

import com.spr.jflow.service.GscontentService;
import com.spr.jflow.domain.Gscontent;
import com.spr.jflow.repository.GscontentRepository;
import com.spr.jflow.service.dto.GscontentDTO;
import com.spr.jflow.service.mapper.GscontentMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing Gscontent.
 */
@Service
@Transactional
public class GscontentServiceImpl implements GscontentService {

    private final Logger log = LoggerFactory.getLogger(GscontentServiceImpl.class);

    private final GscontentRepository gscontentRepository;

    private final GscontentMapper gscontentMapper;

    public GscontentServiceImpl(GscontentRepository gscontentRepository, GscontentMapper gscontentMapper) {
        this.gscontentRepository = gscontentRepository;
        this.gscontentMapper = gscontentMapper;
    }

    /**
     * Save a gscontent.
     *
     * @param gscontentDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public GscontentDTO save(GscontentDTO gscontentDTO) {
        log.debug("Request to save Gscontent : {}", gscontentDTO);
        Gscontent gscontent = gscontentMapper.toEntity(gscontentDTO);
        gscontent = gscontentRepository.save(gscontent);
        return gscontentMapper.toDto(gscontent);
    }

    /**
     * Get all the gscontents.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<GscontentDTO> findAll() {
        log.debug("Request to get all Gscontents");
        return gscontentRepository.findAll().stream()
            .map(gscontentMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one gscontent by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<GscontentDTO> findOne(Long id) {
        log.debug("Request to get Gscontent : {}", id);
        return gscontentRepository.findById(id)
            .map(gscontentMapper::toDto);
    }

    /**
     * Delete the gscontent by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete Gscontent : {}", id);
        gscontentRepository.deleteById(id);
    }
}
