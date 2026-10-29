package jdbc;

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;


public class Main1 {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {

		Class.forName("com.mysql.jdbc.Driver");

		ResultSet set = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "").createStatement()
				.executeQuery("select * from info");
		while (set.next()) {
			System.out.println(set.getString(1));
			System.out.println(set.getInt(2));
		}

		// connection.close();

	}

}
