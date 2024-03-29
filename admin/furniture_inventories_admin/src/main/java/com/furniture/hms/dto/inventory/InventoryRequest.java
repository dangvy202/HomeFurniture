package com.furniture.hms.dto.inventory;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;
import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryRequest {

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
