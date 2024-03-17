package lk.Ijse.DTO.TM;

public class CustomerTable {
    private String CID;
    private String CName;
    private String CAddress;
    private String CMobile;

    public CustomerTable() {
    }

    public CustomerTable(String CID, String CName, String CAddress, String CMobile) {
        this.CID = CID;
        this.CName = CName;
        this.CAddress = CAddress;
        this.CMobile = CMobile;
    }

    public String getCID() {
        return CID;
    }

    public void setCID(String CID) {
        this.CID = CID;
    }

    public String getCName() {
        return CName;
    }

    public void setCName(String CName) {
        this.CName = CName;
    }

    public String getCAddress() {
        return CAddress;
    }

    public void setCAddress(String CAddress) {
        this.CAddress = CAddress;
    }

    public String getCMobile() {
        return CMobile;
    }

    public void setCMobile(String CMobile) {
        this.CMobile = CMobile;
    }

    @Override
    public String toString() {
        return "CustomerTable{" +
                "CID='" + CID + '\'' +
                ", CName='" + CName + '\'' +
                ", CAddress='" + CAddress + '\'' +
                ", CMobile='" + CMobile + '\'' +
                '}';
    }
}
