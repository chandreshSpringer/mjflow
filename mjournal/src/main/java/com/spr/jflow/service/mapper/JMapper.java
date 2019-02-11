package com.spr.jflow.service.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;

import com.spr.jflow.domain.JournalR;
import com.spr.jflow.repository.JournalRRepository;
import com.spr.jflow.service.dto.JournalDTO;
import com.spr.jflow.service.dto.JournalRDTO;
import com.spr.jflow.service.dto.JournalSDTO;

public abstract class JMapper implements JournalStoJournalMapper {
	@Autowired
	private JMapper delegate;
	@Autowired
	private JournalRRepository rRepo;

	@Override
	public JournalDTO jsS2J(JournalSDTO journals) {
		JournalDTO j = delegate.jsS2J(journals);
		Set<JournalRDTO> js = journals.getJournalRS();
		for (JournalRDTO journalRDTO : js) {
			j.addNameOfSociety(journalRDTO.getNameOfSociety());
			j.addOnlineServices(journalRDTO.getOnlineServices());
		}
		return j;
	}

	@Override
	public JournalSDTO j2JSS(JournalDTO journal) {
		JournalSDTO jss = delegate.j2JSS(journal);
		Set<JournalRDTO> js = new HashSet<JournalRDTO>();
		for (int i = 0; i < Math.max(journal.getNameOfSociety().size(), journal.getOnlineServices().size()); i++) {
			JournalRDTO jrdto = new JournalRDTO();
			if (i < journal.getNameOfSociety().size()) {
				jrdto.setNameOfSociety(journal.getNameOfSociety().get(i));
			}
			if (i < journal.getOnlineServices().size()) {
				jrdto.setOnlineServices(journal.getOnlineServices().get(i));
			}
			jrdto.setiPosition(i + 1);
			jrdto.setS2rId(jss.getId());
			if (isNotNullOrZero(jss.getId())) {
				JournalR oldjs = rRepo.findBys2rIdAndiPosition(jss.getId(), i + 1);
				jrdto.setId(oldjs.getId());
			}
			js.add(jrdto);
		}
		jss.setJournalRS(js);
		return jss;
	}

	private boolean isNotNullOrZero(Long id) {

		return id != null && id != 0;
	}

}
