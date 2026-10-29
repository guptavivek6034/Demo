package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main2 {
	
public static void main(String[] args)  {
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ResultSet set;
		try {
			set = DriverManager.getConnection("jdbc:mysql://localhost:3306/db","root","").createStatement().executeQuery("select * from info");
			while (set.next()) {
				System.out.println(set.getString(1));
				System.out.println(set.getInt(2));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	//	connection.close();
		
	}

}
