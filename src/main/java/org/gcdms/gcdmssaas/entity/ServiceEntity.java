package org.gcdms.gcdmssaas.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.util.Date;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "service")
@Getter
@Setter
@ToString
public class ServiceEntity {
    @Id
    @Column("id")
    private Long id;

    @Column("name")
    private String name;

    @Column("description")
    private String description;

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
