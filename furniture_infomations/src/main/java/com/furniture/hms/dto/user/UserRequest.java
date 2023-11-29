package com.furniture.hms.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.servlet.annotation.MultipartConfig;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.multipart.MultipartFile;

@Data
@Setter
@Getter
public class UserRequest {

    @JsonProperty("firstName")
    private String firstName;

    @JsonProperty("lastName")
    private String lastName;

    @JsonProperty("userName")
    private String userName;

    @JsonProperty("email")
    private String email;

    @JsonProperty("password")
    private String password;

    @JsonProperty("address")
    private String address;

    @JsonProperty("birthday")
    private String birthday;

    @JsonProperty("nation")
    private String nation;

    @JsonProperty("phone")
    private String phone;

    @JsonProperty("picture")
    private MultipartFile picture;

}
