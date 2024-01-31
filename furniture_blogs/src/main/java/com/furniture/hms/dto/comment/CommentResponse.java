package com.furniture.hms.dto.comment;

import java.time.Instant;
import java.util.List;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponse {

    private Boolean status;

    private String error;

    private String message;

    private Integer total;

    private List<CommentDetail> comment;

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class CommentDetail {
	private Integer id;
	private String content;
	private Integer status;
	private Instant updateDate;
	private UserInforDetail user;

	@Data
	@FieldDefaults(level = AccessLevel.PRIVATE)
	public static class UserInforDetail {
	    private String userName;

	    private String picture;
	}

    }
}