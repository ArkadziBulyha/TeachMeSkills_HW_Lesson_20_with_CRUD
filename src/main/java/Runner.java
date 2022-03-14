import connection.MySQLDriverManager;
import util.Util;

import java.sql.*;

public class
Runner {

    public static void main(String[] args) throws SQLException {
        MySQLDriverManager connectionMySQL = new MySQLDriverManager();
        try {
            Util.deleteStudentByID(connectionMySQL.getConnection());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
