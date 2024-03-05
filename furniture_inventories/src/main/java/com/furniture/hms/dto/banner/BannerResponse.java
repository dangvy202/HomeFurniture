package com.furniture.hms.dto.banner;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Data
@Getter
@Setter
@NoArgsConstructor
public class BannerResponse {

    private String bannerName;

    private String bannerUrl;

    private List<ProductResponse> product;

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class ProductResponse {
	private Integer id;
	private String productName;
	private String productDescription;
	private BigDecimal productPrice;
	private BigDecimal productSaleoff;
	private String productColor;
	private String productProperty;
	private Integer productStatus;
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
