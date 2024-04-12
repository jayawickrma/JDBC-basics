package lk.Ijse.Model;

import lk.Ijse.DTO.RoomDto;
import lk.ijse.DBConnection.dbConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class RoomModel {

    public static ArrayList<RoomDto> getAllRoom(){
        ArrayList<RoomDto>roomDtos =new ArrayList<>();
        try {
            Connection connection=dbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement =connection.prepareStatement("select * from room");
            ResultSet resultSet=preparedStatement.executeQuery();

            while (resultSet.next()){
                RoomDto roomDto=new RoomDto(resultSet.getInt(1),resultSet.getString(2),resultSet.getString(3));
                roomDtos.add(roomDto);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return roomDtos;
    }

    public static boolean saveRoom(RoomDto roomDto){
        try {
            Connection connection=dbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("insert into room values(?,?,?)");
            preparedStatement.setInt(1,roomDto.getRoomId());
            preparedStatement.setString(2,roomDto.getRoomType());
            preparedStatement.setString(3,roomDto.getRoomPrice());

            int i=preparedStatement.executeUpdate();
            return i>0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
    return false;
    }
    public static boolean deleteRoom(int rId){
        try{
            Connection connection =dbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("delete from room where roomId =?");
            preparedStatement.setInt(1,rId);

            int i = preparedStatement.executeUpdate();
            return i > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
    public static boolean updateRoom(RoomDto roomDto){
        try {
            Connection connection =dbConnection.getInstance().getConnection();
            PreparedStatement preparedStatement=connection.prepareStatement("update room set roomType=?,roomPrice=?");
            preparedStatement.setString(1,roomDto.getRoomType());
            preparedStatement.setString(2,roomDto.getRoomPrice());
            int i=preparedStatement.executeUpdate();
            return i>0;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
