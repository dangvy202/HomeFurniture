package com.furniture.hms.dto.result_data;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ResultData<T> {

    private Boolean status;

    private String error;

    private String message;

    private T resultData;

}
