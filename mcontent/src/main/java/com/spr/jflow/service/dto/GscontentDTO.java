package com.spr.jflow.service.dto;

import java.time.LocalDate;
import javax.validation.constraints.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the Gscontent entity.
 */
public class GscontentDTO implements Serializable {

    private Long id;

    @NotNull
    private String objectId;

    private String repoContentPath;

    @NotNull
    private LocalDate creationDate;

    private String parentId;

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

    public String getRepoContentPath() {
        return repoContentPath;
    }

    public void setRepoContentPath(String repoContentPath) {
        this.repoContentPath = repoContentPath;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }

    public String getParentId() {
        return parentId;
    }

    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        GscontentDTO gscontentDTO = (GscontentDTO) o;
        if (gscontentDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), gscontentDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        return "GscontentDTO{" +
            "id=" + getId() +
            ", objectId='" + getObjectId() + "'" +
            ", repoContentPath='" + getRepoContentPath() + "'" +
            ", creationDate='" + getCreationDate() + "'" +
            ", parentId='" + getParentId() + "'" +
            "}";
    }
}
