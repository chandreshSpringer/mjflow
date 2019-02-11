package com.spr.jflow.service.dto;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the JournalR entity.
 */
public class JournalRDTO implements Serializable {

    private Long id;

    private String objectId;

    private String nameOfSociety;

    private String onlineServices;

    private Integer iPosition;

    private Long s2rId;

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

    public Integer getiPosition() {
        return iPosition;
    }

    public void setiPosition(Integer iPosition) {
        this.iPosition = iPosition;
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

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "JournalRDTO{" +
            "id=" + getId() +
            ", objectId='" + getObjectId() + "'" +
            ", nameOfSociety='" + getNameOfSociety() + "'" +
            ", onlineServices='" + getOnlineServices() + "'" +
            ", iPosition=" + getiPosition() +
            ", s2r=" + getS2rId() +
            "}";
    }
}
