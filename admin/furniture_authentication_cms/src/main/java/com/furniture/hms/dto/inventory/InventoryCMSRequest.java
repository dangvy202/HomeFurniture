package com.furniture.hms.dto.inventory;

import java.util.Date;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryCMSRequest {

    @JsonProperty("id_inventory")
    private Integer id;

    @JsonProperty("inventory_quantity")
    private Integer inventoryQuantity;

    @JsonProperty("inventory_status")
    private Integer inventoryStatus;

    @JsonProperty("id_product")
    private Integer idProduct;

    @JsonProperty("create_by")
    private String createBy;

    @JsonProperty("create_date")
    private Date createDate;

    @JsonProperty("update_by")
    private String updateBy;

    @JsonProperty("update_date")
    private Date updateDate;

}
