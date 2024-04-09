package com.furniture.hms.mapper.contact_history;

import com.furniture.hms.dto.contact_history.ContactHistoryResponse;
import com.furniture.hms.entity.ContactHistory;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

import java.util.Map;
import java.util.Objects;


@Mapper(componentModel = "spring")
public interface ContactHistoryMapper {

    ContactHistoryMapper INSTANCE = Mappers.getMapper(ContactHistoryMapper.class);

    @Mapping(target = "id" , source = "contactHistory.id")
    @Mapping(target = "process" , source = "contactHistory.process")
    @Mapping(target = "message" , source = "contactHistory.message")
    @Mapping(target = "other" , source = "other")
    ContactHistoryResponse toContactHistoryResponse(ContactHistory contactHistory, Map<String, Object> other);
}
