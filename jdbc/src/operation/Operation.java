package operation;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import jdbc.GetConnection;

public class Operation {

	void insertData() {

		try {
			PreparedStatement preparedStatement = GetConnection.getConnection()
					.prepareStatement("insert into info values(?,?)");
			
			preparedStatement.setString(1, "Vivek");
			preparedStatement.setInt(2, 10);
			
			preparedStatement.executeUpdate();
			System.out.println("data inserted....");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void updateData() {
		try {
			PreparedStatement preparedStatement = GetConnection.getConnection()
					.prepareStatement("update info set name=? where id=?");
			
			preparedStatement.setString(1, "Himanshu");
			preparedStatement.setInt(2, 10);
			
			preparedStatement.executeUpdate();
			System.out.println("data updated....");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void deleteData() {
		try {
			PreparedStatement preparedStatement = GetConnection.getConnection()
					.prepareStatement("delete from info where id=?");
			
			preparedStatement.setInt(1, 10);
			
			preparedStatement.executeUpdate();
			System.out.println("data deleted....");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	void showData() {
		
		try {
			PreparedStatement preparedStatement = GetConnection.getConnection()
					.prepareStatement("select * from info");
			
			ResultSet set = preparedStatement.executeQuery();
			
			while (set.next()) {
				System.out.println("Name: " + set.getString("name") + ", ID: " + set.getInt("id"));
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		
		Operation operation = new Operation();
		operation.insertData();
		operation.showData();
		
		System.out.println("================================");
		
		operation.updateData();
		operation.showData();
		
		System.out.println("================================");
		
		operation.deleteData();
		operation.showData();
		
		System.out.println("================================");
		

	}

}
