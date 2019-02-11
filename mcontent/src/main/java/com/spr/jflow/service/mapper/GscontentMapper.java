package com.spr.jflow.service.mapper;

import com.spr.jflow.domain.*;
import com.spr.jflow.service.dto.GscontentDTO;

import org.mapstruct.*;

/**
 * Mapper for the entity Gscontent and its DTO GscontentDTO.
 */
@Mapper(componentModel = "spring", uses = {})
public interface GscontentMapper extends EntityMapper<GscontentDTO, Gscontent> {



    default Gscontent fromId(Long id) {
        if (id == null) {
            return null;
        }
        Gscontent gscontent = new Gscontent();
        gscontent.setId(id);
        return gscontent;
    }
}
