import java.sql.*;
import java.util.*;
public class DatabaseConnection {

	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		try { 
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java201","root","root");
//			System.out.println("Enter pid, pname, price");
//			int pid = sc.nextInt();
//			String pname=sc.next();
//			float price = sc.nextFloat();
//			PreparedStatement pst = con.prepareStatement("insert into Product values(?,?,?)");
//			pst.setInt(1, pid);
//			pst.setString(2, pname);
//			pst.setDouble(3, price);
//		//	Statement stmt = con.createStatement();
//		//	stmt.execute("create table Product(pid int, pname varchar(20), price int)");
//		//	System.out.println("Table created successfully");
//			
//		//	int res = stmt.executeUpdate("insert into Product values("+ pid + "," + pname + "," + price + ")");
//			int res = pst.executeUpdate();
//			System.out.println(res + " row Successfully inserted");
//			
//			System.out.println("Enter pname and pid for updation");
//			pname = sc.next();
//			pid = sc.nextInt();
//			
//			pst =con.prepareStatement("update Product set pname=? where pid=?");
//			pst.setString(1, pname);
//			pst.setInt(2, pid);
//			
//			res = pst.executeUpdate();
//			System.out.println(res + " row Updated");
//			
//			System.out.println("Enter Product id");
//			int pid = sc.nextInt();
//			PreparedStatement pst =con.prepareStatement("delete from product where pid=?");
//			pst.setInt(1, pid);
//			int res = pst.executeUpdate();
//			System.out.println(res + " row deleted" );
//			
			Statement stmt = con.createStatement();
			ResultSet rs = stmt.executeQuery("select *from product");
			
			ResultSetMetaData rsmd = rs.getMetaData();
			for(int i = 1; i <= rsmd.getColumnCount(); i++) {
				System.out.print(rsmd.getColumnName(i) + "\t");
			}
			System.out.println("\n------------------------------------------");
			while(rs.next()) {
				System.out.println(rs.getInt(1)+ "\t" + rs.getString(2) + "\t" + rs.getDouble(3));
			}
			
			System.out.println("------------------------------------------");
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
