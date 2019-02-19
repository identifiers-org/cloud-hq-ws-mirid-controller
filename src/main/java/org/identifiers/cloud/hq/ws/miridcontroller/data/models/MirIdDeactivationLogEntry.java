package org.identifiers.cloud.hq.ws.miridcontroller.data.models;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

/**
 * Project: mirid-controller
 * Package: org.identifiers.cloud.hq.ws.miridcontroller.data.models
 * Timestamp: 2019-02-19 15:00
 *
 * @author Manuel Bernal Llinares <mbdebian@gmail.com>
 * ---
 *
 * This model represents log entries with information on when a MIR ID is "returned", i.e. deactivated.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Accessors(chain = true)
@Entity
@EntityListeners(AuditingEntityListener.class)
public class MirIdDeactivationLogEntry {
    // Internal ID for the entry
    @Id
    @GeneratedValue
    private long id;

    // MIR ID, once the entry has been created, it makes no sense to update it.
    @Column(nullable = false, updatable = false)
    private long mirId;

    // When the log entry was created
    @Column(nullable = false, updatable = false)
    @CreatedDate
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private Date created;

    // When the MIR ID was minted
    private Date minted;

    // When the MIR ID was last confirmed
    private Date lastConfirmed;

    // Some additional information regarding the deactivation entry
    private String additionalInformation;
    // TODO
}
