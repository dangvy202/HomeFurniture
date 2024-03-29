package com.furniture.hms.feign.response.UserResponse;

import java.math.BigInteger;
import java.util.Date;
import java.util.Map;

import com.fasterxml.jackson.annotation.JsonProperty;

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
public class UserResponse {
    private Boolean status;

    private String error;

    private String message;

    private DataUser user;

    @Data
    @FieldDefaults(level = AccessLevel.PRIVATE)
    public static class DataUser {
	@JsonProperty("first_name")
	private String firstName;

	@JsonProperty("last_name")
	private String lastName;

	@JsonProperty("username")
	private String userName;

	@JsonProperty("email")
	private String email;

	@JsonProperty("password")
	private String password;

	@JsonProperty("address")
	private String address;

	@JsonProperty("birthday")
	private Date birthday;

	@JsonProperty("role")
	private String role;

	@JsonProperty("nation")
	private String nation;

	@JsonProperty("phone")
	private BigInteger phone;

	@JsonProperty("picture")
	private String picture;

	private Orther orther;

	@Data
	@FieldDefaults(level = AccessLevel.PRIVATE)
	public static class Orther {
	    private Map<String, Object> variable;
	}
    }
}
