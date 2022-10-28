import java.sql.*;
public class BatchDb {

	public static void main(String[] args)throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java201","root","root");
		try {
			
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			stmt.addBatch("insert into product values(6,'bottle',3000)");
			stmt.addBatch("delete from product where pid = 1");
			int arr[] = stmt.executeBatch();
			
			if(arr.length == 2) {
				con.commit();
				System.out.println("transaction successful");
			}
		
		}
		catch(Exception e) {
			con.rollback();
			System.out.println("transaction failed");
			System.out.println(e);
		}

	}

}
