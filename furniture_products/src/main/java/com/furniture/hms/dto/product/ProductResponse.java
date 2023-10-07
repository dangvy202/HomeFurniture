package com.furniture.hms.dto.product;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.furniture.hms.entity.Product;
import com.furniture.hms.feign.response.InventoryResponse.InventoryResponse;
import jakarta.persistence.Column;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProductResponse {
    List<ProductList> products;

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class ProductList {
        private Integer id;
        private String productName;
        private String productDescription;
        private BigDecimal productPrice;
        private BigDecimal productSaleoff;
        private String productColor;
        private String productProperty;
        private Integer productStatus;

//        @Column(name = "id_category")
//        private Integer idCategory;
//
//        @Column(name = "id_room")
//        private Integer idRoom;

//
//        @Column(name = "id_rating")
//        private Integer idRating;


        private String createBy;
        private Date createDate;
        private String updateBy;
        private Date updateDate;
        private Category category;
        private Inventory inventory;
        private Picture picture;
        private Room room;

        @Data
        @FieldDefaults(level = AccessLevel.PRIVATE)
        public static class Room {
            private Integer id;
            private String roomName;
        }

        @Data
        @FieldDefaults(level = AccessLevel.PRIVATE)
        public static class Category {
            private Integer id;

            private String categoryName;
        }

        @Data
        @FieldDefaults(level = AccessLevel.PRIVATE)
        public static class Picture {
            private Integer id;

            private String pictureFirst;

            private String pictureSecond;

            private String pictureThird;
        }

        @Data
        @FieldDefaults(level = AccessLevel.PRIVATE)
        public static class Inventory {

            private Message message;

            private Integer id;

            private Integer inventoryQuantity;

            private Integer inventoryStatus;

            @Data
            @FieldDefaults(level = AccessLevel.PRIVATE)
            public static class Message {
                private Boolean status;

                private String error;

                private String message;
            }
        }
    }
}
