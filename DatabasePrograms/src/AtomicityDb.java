import java.sql.*;
public class AtomicityDb {

	public static void main(String[] args)throws Exception {
		Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java201","root","root");
		try {
			con.setAutoCommit(false);
			Statement stmt = con.createStatement();
			stmt.executeUpdate("insert into product values(1,'pen',300)");
			stmt.executeUpdate("insert into product values(2,'bag',10000)");
			stmt.executeUpdate("insert into product values(1,'book',900)");
			con.commit();
			System.out.println("Transaction successful");
		}
		catch(Exception e) {
			con.rollback();
			System.out.println("Transaction failed");
			System.out.println(e);
		}

	}

}
