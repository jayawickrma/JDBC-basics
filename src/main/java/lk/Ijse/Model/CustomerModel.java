package lk.Ijse.Model;

import lk.Ijse.DTO.CustomerDto;
import lk.ijse.DBConnection.dbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class CustomerModel {
    public static boolean deleteCustomer(int CID) throws SQLException {
        try{
        Connection connection=dbConnection.getInstance().getConnection();
        PreparedStatement preparedStatement=connection.prepareStatement("delete from customer where CID=?");
        preparedStatement.setInt(1,CID);
    int i;
    i=preparedStatement.executeUpdate();
    return i>0;
        }catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
        }
    public static boolean saveCustomer(CustomerDto customerDto){
        try {
            Connection connection= dbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement("insert into customer values(?,?,?,?) ");
            preparedStatement.setInt(1,customerDto.getCID());
            preparedStatement.setString(2,customerDto.getCNAme());
            preparedStatement.setString(3,customerDto.getCAddress());
            preparedStatement.setString(4,customerDto.getCMobile());

            int i;
            i=preparedStatement.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static ArrayList<CustomerDto>getAllCustomers(){
        ArrayList<CustomerDto>customerDtos=new ArrayList<>();
        try{
            Connection connection=dbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("select * from customer");
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                CustomerDto customerDto=new CustomerDto(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3),resultSet.getString(4));
                customerDtos.add(customerDto);
            }
        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }
        return customerDtos;
    }
    public static boolean updateCustomer(CustomerDto customerDto) throws SQLException {
        try {
            Connection connection = dbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement("update customer set CID=?,CName=?,CAddress=?,CMobile=? ");
            preparedStatement.setInt(1,customerDto.getCID());
            preparedStatement.setString(2,customerDto.getCNAme());
            preparedStatement.setString(3,customerDto.getCAddress());
            preparedStatement.setString(4,customerDto.getCMobile());

            int i =preparedStatement.executeUpdate();
            return  i>0;

        }catch (SQLException e){
            e.printStackTrace();
        }
        return false;
    }
}
