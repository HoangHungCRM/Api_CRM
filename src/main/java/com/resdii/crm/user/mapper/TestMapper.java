package com.resdii.crm.user.mapper;

import com.resdii.crm.user.domain.Test;
import com.resdii.crm.user.dto.TestDTO;
import com.resdii.ms.common.mapper.IMapperConfig;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring", config = IMapperConfig.class)
public interface TestMapper extends IBaseMapper<Test, TestDTO> {

    @Override
    @Named("toListItemDest")
    @Mapping(target = "id", source = "id")
    @Mapping(target = "username", source = "username")
    TestDTO toListItemDest(Test test);

    @Override
    @Mapping(target = "id", source = "id")
    @Mapping(target = "username", source = "username")
    TestDTO toDest(Test test);
}
