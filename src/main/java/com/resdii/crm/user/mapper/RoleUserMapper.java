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
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "roleId", source = "roleId")
    RoleUser toListItemDest(RolesUsers rolesUsers);

    @Override
    @Mapping(target = "userId", source = "userId")
    @Mapping(target = "roleId", source = "roleId")
    RoleUser toDest(RolesUsers rolesUser);
}
