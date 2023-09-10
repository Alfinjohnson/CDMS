package org.gcdms.gcdmssaas.entity.config.type;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import lombok.*;
import org.gcdms.gcdmssaas.entity.config.ConfigurationEntity;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.annotation.Transient;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "boolean_config")
@Getter
@Setter
@ToString
public class BooleanConfigEntity {

    @Id
    @Column("id")
    private Long id;

    @Column("configuration_id")
    private Long configuration_id;

    @Column("value")
    private boolean value;

    @Transient
    private ConfigurationEntity configurationEntity;

    @LastModifiedDate
    @Column( "modified_datetime")
    private Date modifiedDateTime;

    @CreatedDate
    @Column("created_datetime")
    private Date createdDateTime;

    @Column("created_userid")
    private Long createdUserId;

    @Column("last_modified_userid")
    private Long lastModifiedUserId;
}
