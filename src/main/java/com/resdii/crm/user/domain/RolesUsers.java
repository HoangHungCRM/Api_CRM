package com.resdii.crm.user.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "acl_roles_users")
public class RolesUsers extends BaseEntity{

    @Column(name = "user_id")
    private String userId;

    @Column(name = "role_id")
    private String roleId;

}
