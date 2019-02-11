package com.spr.jflow.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.spr.jflow.domain.enumeration.Language;
import com.spr.jflow.domain.JournalR;
import com.spr.jflow.domain.enumeration.CompanyGroup;

/**
 * A DTO for the JournalS entity.
 */
public class JournalSDTO implements Serializable {

    private Long id;

    private String objectId;

    @NotNull
    private String objectName;

    @NotNull
    private String productId;

    private String title;

    private String shortTitle;

    private Language primaryLanguage;

    private CompanyGroup companyGroup;

    private String publisher;

    private String publishingSegment;

    private String imprint;

    private String medium;

    
    private Set<JournalRDTO> journalRS = new HashSet<>();

    @NotNull
    private LocalDate creationDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getObjectName() {
        return objectName;
    }

    public void setObjectName(String objectName) {
        this.objectName = objectName;
    }

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    public Language getPrimaryLanguage() {
        return primaryLanguage;
    }

    public void setPrimaryLanguage(Language primaryLanguage) {
        this.primaryLanguage = primaryLanguage;
    }

    public CompanyGroup getCompanyGroup() {
        return companyGroup;
    }

    public void setCompanyGroup(CompanyGroup companyGroup) {
        this.companyGroup = companyGroup;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public String getPublishingSegment() {
        return publishingSegment;
    }

    public void setPublishingSegment(String publishingSegment) {
        this.publishingSegment = publishingSegment;
    }

    public String getImprint() {
        return imprint;
    }

    public void setImprint(String imprint) {
        this.imprint = imprint;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        JournalSDTO journalSDTO = (JournalSDTO) o;
        if (journalSDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), journalSDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }
    
	@Override
	public String toString() {
		return "JournalSDTO [id=" + id + ", objectId=" + objectId + ", objectName=" + objectName + ", productId="
				+ productId + ", title=" + title + ", shortTitle=" + shortTitle + ", primaryLanguage=" + primaryLanguage
				+ ", companyGroup=" + companyGroup + ", publisher=" + publisher + ", publishingSegment="
				+ publishingSegment + ", imprint=" + imprint + ", medium=" + medium + "\n, journalRS=" + journalRS
				+ "\n, creationDate=" + creationDate + "]";
	}

	public Set<JournalRDTO> getJournalRS() {
		return journalRS;
	}

	public void setJournalRS(Set<JournalRDTO> journalRS) {
		this.journalRS = journalRS;
	}

	
}
