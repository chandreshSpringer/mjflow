package com.spr.jflow.service.mapper;

import com.spr.jflow.domain.*;
import com.spr.jflow.service.dto.JournalRDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity JournalR and its DTO JournalRDTO.
 */
@Mapper(componentModel = "spring", uses = {JournalSMapper.class})
public interface JournalRMapper extends EntityMapper<JournalRDTO, JournalR> {

    @Mapping(source = "s2r.id", target = "s2rId")
    JournalRDTO toDto(JournalR journalR);

    @Mapping(source = "s2rId", target = "s2r")
    JournalR toEntity(JournalRDTO journalRDTO);

    default JournalR fromId(Long id) {
        if (id == null) {
            return null;
        }
        JournalR journalR = new JournalR();
        journalR.setId(id);
        return journalR;
    }
}
