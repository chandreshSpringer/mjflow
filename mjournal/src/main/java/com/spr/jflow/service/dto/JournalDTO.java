package com.spr.jflow.service.dto;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import javax.validation.constraints.NotNull;

import com.spr.jflow.domain.enumeration.CompanyGroup;
import com.spr.jflow.domain.enumeration.Language;

public class JournalDTO {
	 private Long id;

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

	    private String objectId;

	    private List<String> nameOfSociety;

	    private String onlineServices;

	    private Long s2rId;

	    public String getNameOfSociety() {
	        return nameOfSociety;
	    }

	    public void setNameOfSociety(String nameOfSociety) {
	        this.nameOfSociety = nameOfSociety;
	    }

	    public String getOnlineServices() {
	        return onlineServices;
	    }

	    public void setOnlineServices(String onlineServices) {
	        this.onlineServices = onlineServices;
	    }

	    public Long getS2rId() {
	        return s2rId;
	    }

	    public void setS2rId(Long journalSId) {
	        this.s2rId = journalSId;
	    }

	    @Override
	    public boolean equals(Object o) {
	        if (this == o) {
	            return true;
	        }
	        if (o == null || getClass() != o.getClass()) {
	            return false;
	        }

	        JournalRDTO journalRDTO = (JournalRDTO) o;
	        if (journalRDTO.getId() == null || getId() == null) {
	            return false;
	        }
	        return Objects.equals(getId(), journalRDTO.getId());
	    }


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
	    public int hashCode() {
	        return Objects.hashCode(getId());
	    }
	    
	

		

}
