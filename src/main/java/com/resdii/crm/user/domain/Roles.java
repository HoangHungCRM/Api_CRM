package com.resdii.crm.user.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "acl_roles")
public class Roles extends BaseEntity{
    private @Column(name = "name") String nameRole;
}
