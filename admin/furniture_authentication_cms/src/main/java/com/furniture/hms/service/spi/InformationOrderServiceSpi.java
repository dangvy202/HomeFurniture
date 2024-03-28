package com.furniture.hms.service.spi;

import java.util.List;

import org.springframework.stereotype.Component;

import com.furniture.hms.dto.information_order.InformationOrderCMSResponse;

@Component
public interface InformationOrderServiceSpi {

    List<InformationOrderCMSResponse> getAllInformationOrder();
}
