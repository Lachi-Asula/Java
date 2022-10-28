import java.util.*;
import java.sql.*;
public class MenuDrivenDatabase {

	public void menu() {
		String m = "Menu Driven Application \n";
		m += "1. Add Product \n";
		m += "2. Update Product \n";
		m += "3. Delete Product \n";
		m += "4. Display Product List \n";
		m += "5. Exit \n";
		m += "Select Any Option: \n";
		
		System.out.println(m);
	}
	
	public Connection getConn() {
		Connection con = null;
		try {
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java201","root","root");
		}
		catch(Exception e) {
			System.out.println(e);
		}
		
		return con;
	}
	
	public boolean addProduct(Product prod)throws Exception{
		boolean b = false;
		
		Connection con = getConn();
		PreparedStatement pst = con.prepareStatement("insert into Product values(?,?,?)");
		pst.setInt(1, prod.pid);
		pst.setString(2, prod.pname);
		pst.setDouble(3, prod.price);
		
		int res = pst.executeUpdate();
		
		if(res > 0) {
			b = true;
		}
		
		return b;
	}
	
	public boolean updateProduct(Product prod)throws Exception {
		boolean b = false;
		
		Connection con = getConn();
		PreparedStatement pst = con.prepareStatement("update Product set pname = ?, price = ? where pid = ?");
		pst.setString(1, prod.pname);
		pst.setDouble(2, prod.price);
		pst.setInt(3, prod.pid);
		
		int res = pst.executeUpdate();
		
		if(res > 0) {
			b = true;
		}
		
		return b;
	}
	
	public boolean deleteProduct(int pid)throws Exception{
		boolean b = false;
		
		Connection con = getConn();
		PreparedStatement pst = con.prepareStatement("delete from product where pid=?");
		pst.setInt(1, pid);
		
		int res = pst.executeUpdate();
		
		if(res > 0) {
			b = true;
		}
		
		return b;
	}
	
	public List dispProduct()throws Exception {
		List<Product> li = new ArrayList();
		Connection con = getConn();
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery("select * from Product");
		while(rs.next()) {
			Product p = new Product(rs.getInt(1), rs.getString(2), rs.getDouble(3));
			li.add(p);
		}
		
		return li;
	}
	
	public static void main(String[] args)throws Exception{
		Scanner sc = new Scanner(System.in);
		MenuDrivenDatabase md = new MenuDrivenDatabase();
		
		while(true) {
			md.menu();
			int choice = sc.nextInt();
			
			switch(choice) {
				case 1:
					System.out.println("Enter Pid, Pname and Price");
					if(md.addProduct(new Product(sc.nextInt(),sc.next(),sc.nextDouble()))) {
						System.out.println("Product Added Successfully");
					}
					else {
						System.out.println("Try again");
					}
					break;
				case 2:
					System.out.println("Enter Pid, Pname and Price");
					if(md.updateProduct(new Product(sc.nextInt(),sc.next(),sc.nextDouble()))) {
						System.out.println("Product Updated Successfully");
					}
					else {
						System.out.println("Try again");
					}
					break;
				case 3:
					System.out.println("Enter Pid");
					if(md.deleteProduct(sc.nextInt())) {
						System.out.println("Product Deleted Successfully");
					}
					else {
						System.out.println("Try again");
					}
					break;
				case 4:
					System.out.println("Product Detailes are:");
					List<Product> li = md.dispProduct();
					
					for(Product p : li) {
						System.out.println(p);
					}
					break;
				case 5:
					System.exit(0);
			}
		}
	}

}
