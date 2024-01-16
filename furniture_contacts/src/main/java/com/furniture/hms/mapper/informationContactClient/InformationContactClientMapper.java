package com.furniture.hms.mapper.informationContactClient;

import com.furniture.hms.dto.informationContactClient.InformationContactClientRequest;
import com.furniture.hms.entity.InformationContactClient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface InformationContactClientMapper {
    InformationContactClientMapper INSTANT = Mappers.getMapper(InformationContactClientMapper.class);

    @Mapping(target = "createDate" , source = "createDate")
    @Mapping(target = "name" , source = "name")
    InformationContactClient toInformationContactClientEntity(
            InformationContactClientRequest request,
            Instant createDate,
            String name,
            int status
    );
}
