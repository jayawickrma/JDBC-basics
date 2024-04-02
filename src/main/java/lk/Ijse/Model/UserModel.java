package lk.Ijse.Model;

import lk.Ijse.DTO.UserDto;
import lk.ijse.DBConnection.dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class UserModel {
    public static boolean saveUser(UserDto userDto){
        try{
            Connection connection=dbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("INSERT into User values (?,?,?)");
            preparedStatement.setInt(1,userDto.getUID());
            preparedStatement.setString(2,userDto.getUname());
            preparedStatement.setString(3,userDto.getUpw());
            int i =preparedStatement.executeUpdate();
            return i>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
