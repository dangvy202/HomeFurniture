package com.furniture.hms.mapper.contactDescription;

import com.furniture.hms.dto.contactDescription.ContactDescriptionRequest;
import com.furniture.hms.entity.ContactDescription;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface ContactDescriptionMapper {
    ContactDescriptionMapper INSTANCE = Mappers.getMapper(ContactDescriptionMapper.class);

    @Mapping(target = "createDate" , source = "createDate")
    ContactDescription toContactDescriptionEntity(ContactDescriptionRequest contactDescriptionRequest, Instant createDate);
}
