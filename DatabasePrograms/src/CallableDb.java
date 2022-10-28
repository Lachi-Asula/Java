import java.sql.*;
public class CallableDb {

	public static void main(String[] args) {
		try {
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java201","root","root");
			CallableStatement cst = con.prepareCall("{?=CALL getAvg1(?,?)}");
//			cst.setInt(1, 3);
//			cst.registerOutParameter(2, Types.FLOAT);
//			cst.execute();
//			
//			System.out.println("SAl is: " + cst.getFloat(2));
			
//			cst.setInt(1, 7);
//			cst.setString(2, "laptop");
//			cst.setDouble(3, 200000);
//			cst.execute();
//			
//			System.out.println("Inserted Successfully");
			
			cst.setInt(2, 2);
			cst.setInt(3, 3);
			cst.registerOutParameter(1, Types.FLOAT);
			cst.execute();
			
			System.out.println("Average: " + cst.getFloat(1));
			cst.close();
			con.close();
		}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
