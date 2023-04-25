package org.data.linking.model.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

@Data
@Builder
@Entity
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "company")
public class Company implements Serializable {

    @Id
    @Column(name = "siret", length = 200, nullable = false)
    @Schema(description = "Unique identifier of the Company (siret of company)", example = "1", required = true)
    private String siret;

    @Column(name = "nic", length = 200, nullable = false)
    @Schema(description = "nic of company", required = true)
    private String nic;

    @Column(name = "full_address", length = 200, nullable = false)
    @Schema(description = "fullAddress of company", required = true)
    private String fullAddress;

    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    @Column(name = "creation_date", length = 200, nullable = false)
    @Schema(description = "creationDate of company", required = true)
    private Date creationDate;

    @Column(name = "full_name", nullable = false)
    @Schema(description = "fullName of company", required = true)
    private String fullName;
}
