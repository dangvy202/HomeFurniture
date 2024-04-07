package com.furniture.hms.mapper.information_contact_client;


import com.furniture.hms.dto.information_contact_client.InformationContactClientResponse;
import com.furniture.hms.entity.InformationContactClient;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface InformationContactClientMapper {

    InformationContactClientMapper INSTANCE = Mappers.getMapper(InformationContactClientMapper.class);

    InformationContactClientResponse toInformationContactClientResponse(InformationContactClient informationContactClient);
}
