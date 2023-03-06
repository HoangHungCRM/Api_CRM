package com.resdii.crm.user.domain;


import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;


import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "users")
@Data
public class User extends BaseEntity{
    private @Column(name = "user_name") String username;
    private @Column(name = "user_hash") String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
