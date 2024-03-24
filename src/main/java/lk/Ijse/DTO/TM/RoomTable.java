package lk.Ijse.DTO.TM;

import com.jfoenix.controls.JFXButton;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class RoomTable {
    private String roomId;
    private String roomType;
    private String roomPrice;
    private JFXButton updateRoom;
    private JFXButton deleteRoom;
}
