package lk.Ijse.DTO.TM;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerTable {
    private String CID;
    private String CName;
    private String CAddress;
    private String CMobile;
}
