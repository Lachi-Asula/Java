import java.sql.*;
public class PreviousData {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java201","root","root");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			ResultSet rs = stmt.executeQuery("select *from Product");
			rs.afterLast();
			while(rs.previous()) {
				System.out.println(rs.getInt("pid") + " " + rs.getString("pname") + " " + rs.getDouble("price"));
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}

	}

}
