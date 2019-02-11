package com.spr.jflow.service.mapper;

import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import com.spr.jflow.domain.JournalR;
import com.spr.jflow.domain.JournalS;
import com.spr.jflow.service.dto.JournalDTO;
import com.spr.jflow.service.dto.JournalRDTO;
import com.spr.jflow.service.dto.JournalSDTO;

@Mapper
@DecoratedWith(JMapper.class)
public interface JournalStoJournalMapper {

	JournalStoJournalMapper INSTANCE=Mappers.getMapper( JournalStoJournalMapper.class );
	
	JournalDTO jsS2J(JournalSDTO journals) ;
	JournalSDTO j2JSS(JournalDTO journals);
}
