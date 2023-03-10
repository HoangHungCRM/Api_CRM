package com.resdii.crm.user.mapper;


import com.resdii.crm.user.domain.RolesUsers;
import com.resdii.crm.user.domain.User;
import com.resdii.crm.user.dto.RoleUser;
import com.resdii.crm.user.dto.UserInfoDTO;
import com.resdii.ms.common.mapper.IMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", config = IMapperConfig.class)
public interface RoleUserMapper extends IBaseMapper<RolesUsers, RoleUser>{

    @Override
    @Named("toListItemDest")
    @Mapping(target = "user_id", source = "user_id")
    @Mapping(target = "role_id", source = "role_id")
    RoleUser toListItemDest(RolesUsers rolesUsers);

    @Override
    @Mapping(target = "user_id", source = "user_id")
    @Mapping(target = "role_id", source = "role_id")
    RoleUser toDest(RolesUsers rolesUser);
}
