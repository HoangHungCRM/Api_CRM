package com.resdii.crm.user.mapper;


import com.resdii.crm.user.domain.Test;
import com.resdii.crm.user.domain.User;
import com.resdii.crm.user.dto.TestDTO;
import com.resdii.crm.user.dto.UserInfoDTO;
import com.resdii.ms.common.mapper.IMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", config = IMapperConfig.class)
public interface UserInforMapper extends IBaseMapper<User, UserInfoDTO>{

    @Override
    @Named("toListItemDest")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "lastname", source = "lastname")
    UserInfoDTO toListItemDest(User user);

    @Override
    @Mapping(target = "id", source = "id")
    @Mapping(target = "username", source = "username")
    @Mapping(target = "lastname", source = "lastname")
    UserInfoDTO toDest(User user);
}
