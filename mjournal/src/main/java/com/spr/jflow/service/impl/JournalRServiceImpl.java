package com.spr.jflow.service.impl;

import com.spr.jflow.service.JournalRService;
import com.spr.jflow.domain.JournalR;
import com.spr.jflow.repository.JournalRRepository;
import com.spr.jflow.service.dto.JournalRDTO;
import com.spr.jflow.service.mapper.JournalRMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
/**
 * Service Implementation for managing JournalR.
 */
@Service
@Transactional
public class JournalRServiceImpl implements JournalRService {

    private final Logger log = LoggerFactory.getLogger(JournalRServiceImpl.class);

    private final JournalRRepository journalRRepository;

    private final JournalRMapper journalRMapper;

    public JournalRServiceImpl(JournalRRepository journalRRepository, JournalRMapper journalRMapper) {
        this.journalRRepository = journalRRepository;
        this.journalRMapper = journalRMapper;
    }

    /**
     * Save a journalR.
     *
     * @param journalRDTO the entity to save
     * @return the persisted entity
     */
    @Override
    public JournalRDTO save(JournalRDTO journalRDTO) {
        log.debug("Request to save JournalR : {}", journalRDTO);
        JournalR journalR = journalRMapper.toEntity(journalRDTO);
        journalR = journalRRepository.save(journalR);
        return journalRMapper.toDto(journalR);
    }

    /**
     * Get all the journalRS.
     *
     * @return the list of entities
     */
    @Override
    @Transactional(readOnly = true)
    public List<JournalRDTO> findAll() {
        log.debug("Request to get all JournalRS");
        return journalRRepository.findAll().stream()
            .map(journalRMapper::toDto)
            .collect(Collectors.toCollection(LinkedList::new));
    }


    /**
     * Get one journalR by id.
     *
     * @param id the id of the entity
     * @return the entity
     */
    @Override
    @Transactional(readOnly = true)
    public Optional<JournalRDTO> findOne(Long id) {
        log.debug("Request to get JournalR : {}", id);
        return journalRRepository.findById(id)
            .map(journalRMapper::toDto);
    }

    /**
     * Delete the journalR by id.
     *
     * @param id the id of the entity
     */
    @Override
    public void delete(Long id) {
        log.debug("Request to delete JournalR : {}", id);
        journalRRepository.deleteById(id);
    }
}
