package com.furniture.hms.mapper.contactHistory;

import com.furniture.hms.dto.contactHistory.ContactHistoryRequest;
import com.furniture.hms.dto.contactHistory.ContactHistoryResponse;
import com.furniture.hms.entity.ContactDescription;
import com.furniture.hms.entity.ContactHistory;
import com.furniture.hms.entity.InformationContactClient;
import com.furniture.hms.enums.ProcessEnum;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.mapstruct.factory.Mappers;

import java.time.Instant;

@Mapper(componentModel = "spring")
public interface ContactHistoryMapper {
    ContactHistoryMapper INSTANT = Mappers.getMapper(ContactHistoryMapper.class);

    ContactHistoryResponse toContactHistoryResponse(Boolean status,String error, String message);


    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createBy" , source = "createBy")
    @Mapping(target = "createDate" , source = "createDate")
    @Mapping(target = "updateBy" , source = "updateBy")
    @Mapping(target = "updateDate" , source = "updateDate")
    @Mapping(target = "informationContactClient" , source = "informationContactClient")
    @Mapping(target = "contactDescription" , source = "contactDescription")
    @Mapping(target = "process" , source = "process")
    @Mapping(target = "message" , source = "message")
    ContactHistory toContactHistoryEntity(
            ProcessEnum process,
            String message,
            InformationContactClient informationContactClient,
            ContactDescription contactDescription,
            String createBy,
            Instant createDate,
            String updateBy,
            Instant updateDate
    );
}
