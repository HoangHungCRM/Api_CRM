package com.resdii.crm.user.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "acl_roles")
public class Roles{
    @Id
    @Column(name = "id")
    private String id;

    @Column(name = "name")
    private String name;

    public Roles(String id, String name) {
        this.id = id;
        this.name = name;
    }
    public Roles(String name) {
        super();
        this.name = name;
    }
    public Roles() { // TODO Auto-generated constructor stub }
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
}
