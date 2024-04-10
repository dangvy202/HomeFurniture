package com.furniture.hms.mapper.information_contact_admin;

import com.furniture.hms.dto.information_contact_admin.InformationContactAdminResponse;
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

    InformationContactAdminResponse toInformationContactAdminResponse(InformationContactAdmin informationContactAdmin);
}
