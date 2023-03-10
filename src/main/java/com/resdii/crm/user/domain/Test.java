package com.resdii.crm.user.domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity(name = "users")
public class Test extends BaseEntity{
    private @Column(name = "user_name") String username;
    private @Column(name = "user_hash") String password;
    private @Column(name = "last_name") String lastname;



}
