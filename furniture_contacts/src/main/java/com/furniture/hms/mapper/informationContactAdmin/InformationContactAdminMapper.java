package com.furniture.hms.mapper.informationContactAdmin;

import com.furniture.hms.dto.informationContactAdmin.InformationContactAdminResponse;
import com.furniture.hms.dto.informationContactClient.InformationContactClientRequest;
import com.furniture.hms.entity.InformationContactAdmin;
import com.furniture.hms.entity.InformationContactClient;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.Instant;
import java.util.List;

@Mapper(componentModel = "spring")
public interface InformationContactAdminMapper {
    InformationContactAdminMapper INSTANT = Mappers.getMapper(InformationContactAdminMapper.class);

    InformationContactAdminResponse.InformationContactAdminDetail toInformationContactAdminResponse(InformationContactAdmin informationContactAdmin);
}
