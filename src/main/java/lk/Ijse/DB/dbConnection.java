package lk.ijse.DBConnection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class dbConnection {
    private static dbConnection dbConnection;
    private final static String URL = "jdbc:mysql://localhost:3306/dbsetting";
    private final static Properties props =new Properties();
    private Connection connection;
    static {
        props.setProperty("user","root");
        props.setProperty("password","Ijse@1234");
    }

    private dbConnection() throws SQLException {
        connection = DriverManager.getConnection(URL,props);

    }
    public static dbConnection getInstance() throws SQLException {
        return(dbConnection == null) ? dbConnection = new dbConnection() :dbConnection;
    }
    public Connection getConnection(){
        return connection;
    }
}
