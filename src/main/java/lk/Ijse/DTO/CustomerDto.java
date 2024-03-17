package lk.Ijse.DTO;

public class CustomerDto {
    private int CID;
    private String CNAme;
    private String CAddress;
    private String CMobile;

    public CustomerDto() {
    }

    public CustomerDto(int CID, String CNAme, String CAddress, String CMobile) {
        this.CID = CID;
        this.CNAme = CNAme;
        this.CAddress = CAddress;
        this.CMobile = CMobile;
    }

    public int getCID() {
        return CID;
    }

    public void setCID(int CID) {
        this.CID = CID;
    }

    public String getCNAme() {
        return CNAme;
    }

    public void setCNAme(String CNAme) {
        this.CNAme = CNAme;
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
        return "CustomerDto{" +
                "CID=" + CID +
                ", CNAme='" + CNAme + '\'' +
                ", CAddress='" + CAddress + '\'' +
                ", CMobile='" + CMobile + '\'' +
                '}';
    }
}
