package com.furniture.hms.dto.room;

import lombok.*;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RoomResponse {
    private Integer id;
    private String roomName;
}
