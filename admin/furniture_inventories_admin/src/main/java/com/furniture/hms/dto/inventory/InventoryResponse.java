package com.furniture.hms.dto.inventory;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse {
    private Integer id;

    private Integer inventoryQuantity;

    private Integer inventoryStatus;

    private Integer idProduct;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;
}
