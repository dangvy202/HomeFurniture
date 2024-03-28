package com.furniture.hms.dto.result;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ResultData<T> {

    private Boolean status;

    private String error;

    private String message;

    private T resultData;

}