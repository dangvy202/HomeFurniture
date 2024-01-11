package com.furniture.hms.service.informationContactAdmin;

import com.furniture.hms.dto.informationContactAdmin.InformationContactAdminResponse;
import com.furniture.hms.entity.InformationContactAdmin;
import com.furniture.hms.enums.StatusEnum;
import com.furniture.hms.mapper.informationContactAdmin.InformationContactAdminMapper;
import com.furniture.hms.repository.informationContactAdmin.InformationContactAdminRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class InformationContactAdminService {

    private final InformationContactAdminRepository repository;

    public InformationContactAdminResponse getInformationAdmin() {
        List<InformationContactAdmin> arrInformationContactAdmin = repository.findAll();

        InformationContactAdminResponse response =  new InformationContactAdminResponse();
        if(arrInformationContactAdmin.size() > 0) {
            arrInformationContactAdmin.stream().forEach(informationContactAdmin -> {
                if(informationContactAdmin.getStatus() == StatusEnum.VALID) {
                    response.setInformationContactAdminDetailList(List.of(
                            InformationContactAdminMapper.INSTANT.toInformationContactAdminResponse(
                                    informationContactAdmin
                            )
                    ));

                }
            });
            return response;
        } else {
            return response;
        }
    }
}
