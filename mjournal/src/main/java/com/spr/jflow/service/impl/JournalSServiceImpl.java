package com.spr.jflow.service.impl;

import com.spr.jflow.service.JournalSService;
import com.spr.jflow.domain.JournalR;
import com.spr.jflow.domain.JournalS;
import com.spr.jflow.repository.JournalRRepository;
import com.spr.jflow.repository.JournalSRepository;
import com.spr.jflow.service.dto.JournalSDTO;
import com.spr.jflow.service.mapper.JournalSMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Service Implementation for managing JournalS.
 */
@Service
@Transactional
public class JournalSServiceImpl implements JournalSService {

	private final Logger log = LoggerFactory.getLogger(JournalSServiceImpl.class);
	@Autowired
	private  JournalSRepository journalSRepository;
	@Autowired
	private  JournalSMapper journalSMapper;
	@Autowired
	private JournalRRepository journalRRepository;

	/**
     * Save a journalS.
     *
     * @param journalSDTO the entity to save
     * @return the persisted entity
     */
    @Override
    @Transactional(readOnly=false)
    public JournalSDTO save(JournalSDTO journalSDTO) {
    	System.out.println("Request to save JournalS : {}"+ journalSDTO);
        JournalS journalS = journalSMapper.toEntity(journalSDTO);
        Set<JournalR> repeatings=journalS.getJournalRS();
        System.out.println("JournalSServiceImpl.save()"+repeatings);
        journalS = journalSRepository.save(journalS);
        Set<JournalR> repeatingsCreated=new HashSet<JournalR>();
		for (JournalR journalR : repeatings) {
			System.out.println("JournalSServiceImpl.save()"+journalR);
			repeatingsCreated.add(journalRRepository.save(journalR.s2r(journalS)));
		}
		journalS.setJournalRS(repeatingsCreated);
        return journalSMapper.toDto(journalS);
    }

	/**
	 * Get all the journalS.
	 *
	 * @return the list of entities
	 */
	@Override
	@Transactional(readOnly = true)
	public List<JournalSDTO> findAll() {
		log.debug("Request to get all JournalS");
		return journalSRepository.findAll().stream().map(journalSMapper::toDto)
				.collect(Collectors.toCollection(LinkedList::new));
	}

	/**
	 * Get one journalS by id.
	 *
	 * @param id the id of the entity
	 * @return the entity
	 */
	@Override
	@Transactional(readOnly = true)
	public Optional<JournalSDTO> findOne(Long id) {
		log.debug("Request to get JournalS : {}", id);
		Optional<JournalS> findById = journalSRepository.findById(id);
		System.out.println("JournalSServiceImpl.findOne()");
		findById.get().toString();
		return findById.map(journalSMapper::toDto);
	}

	/**
	 * Delete the journalS by id.
	 *
	 * @param id the id of the entity
	 */
	@Override
	public void delete(Long id) {
		log.debug("Request to delete JournalS : {}", id);
		journalSRepository.deleteById(id);
	}
}
