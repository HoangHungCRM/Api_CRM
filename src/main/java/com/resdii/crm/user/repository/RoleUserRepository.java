package com.resdii.crm.user.repository;

import com.resdii.crm.user.domain.RolesUsers;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleUserRepository extends JpaRepository<RolesUsers,String> {
//    RolesUsers findRolesUsersById(String id);

    RolesUsers findByUser_id(String id);
}
