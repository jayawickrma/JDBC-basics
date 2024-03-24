package lk.Ijse.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class CustomerDto {
    private int CID;
    private String CNAme;
    private String CAddress;
    private String CMobile;
}
