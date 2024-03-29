package com.furniture.hms.dto.inventory;

import java.util.Date;

import com.furniture.hms.dto.product.ProductResponse;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class InventoryResponse {

    private Integer inventoryQuantity;

    private Integer inventoryStatus;

    private String createBy;

    private Date createDate;

    private String updateBy;

    private Date updateDate;

    private ProductResponse product;
}
