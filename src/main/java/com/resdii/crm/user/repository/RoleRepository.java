package com.resdii.crm.user.repository;

import com.resdii.crm.user.domain.Roles;
import com.resdii.crm.user.enums.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Roles, String> {
    Roles findRolesById(String id);
}
