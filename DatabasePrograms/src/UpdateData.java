import java.sql.*;
public class UpdateData {

	public static void main(String[] args) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java201","root","root");
			Statement stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
//			ResultSet rs = stmt.executeQuery("select *from product where pid = 2");
//			while(rs.next()) {
//				rs.updateDouble ("price", 200000);
//				rs.updateRow();
//			}
//			ResultSet rs1 = stmt.executeQuery("select *from Product");
//			while(rs1.next()) {
//				System.out.println(rs.getInt("pid") + " " + rs.getString("pname") + " " + rs.getDouble("price"));
//			}
			
			ResultSet rs = stmt.executeQuery("select *from product");
			
//			while(rs.next()) {
//				System.out.println(rs.getInt("pid") + " " +rs.getString("pname") + " " +rs.getDouble("price"));
//			}
			
			rs.last();
			System.out.println(rs.getString("pname"));
			
			rs.absolute(2);
			System.out.println(rs.getDouble("price"));
			
			rs.first();
			System.out.println(rs.getInt("pid "));
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
