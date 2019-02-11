package com.spr.jflow.service.mapper;

import com.spr.jflow.domain.*;
import com.spr.jflow.service.dto.JournalRDTO;
import com.spr.jflow.service.dto.JournalSDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity JournalS and its DTO JournalSDTO.
 */
@Mapper(componentModel = "spring", uses = {JournalRMapper.class})
public interface JournalSMapper extends EntityMapper<JournalSDTO, JournalS> {

	 JournalS toEntity(JournalSDTO journalSDTO);
	    default JournalS fromId(Long id) {
        if (id == null) {
            return null;
        }
        JournalS journalS = new JournalS();
        journalS.setId(id);
        return journalS;
    }
}
