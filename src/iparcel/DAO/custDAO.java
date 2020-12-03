package iparcel.DAO;

import java.sql.*;
import java.util.ArrayList;

import iparcel.conn;
import iparcel.model.customer;
import iparcel.model.staff;

public class custDAO {
	static PreparedStatement ps = null;
	static Connection con = null;
	static ResultSet rs = null;
	
	static String id;
	static String fn;
	static String ic;
	static String phone;
	static String email;
	static String pass;
	
	public static boolean register(customer l) throws ClassNotFoundException, SQLException {
		
		id = l.getId();
		fn = l.getFullname();
		ic = l.getIc();
		phone = l.getPhone();
		email = l.getEmail();
		pass = l.getPassword();
		
		con = conn.initializeDatabase();

		boolean status = false;
		try {
			
			String sql = "select cID from customer where cID ='"+id+"'";
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			if(rs.next()==false) {
				String sql1 = "insert into customer (cID, cFullname, cIC, cPhone, email, cPass) values(?,?,?,?,?,?)";
				
				ps = con.prepareStatement(sql1);
				ps.setString(1, id);
				ps.setString(2, fn);
				ps.setString(3, ic);
				ps.setString(4, phone);
				ps.setString(5, email);
				ps.setString(6, pass);
				
				int res = ps.executeUpdate();
				
				if(res == 1) {
					status = true;
				}
			}			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public static ArrayList<customer> getCustomer() throws ClassNotFoundException, SQLException
	{
		con = conn.initializeDatabase();
		
		ArrayList<customer> cus = new ArrayList<customer>();
		
		try {

			String sql = "select * from customer";
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				id = rs.getString(1);
				fn = rs.getString(2);
				ic = rs.getString(3);
				phone = rs.getString(4);
				email = rs.getString(5);
				pass = rs.getString(6);
				
				customer c = new customer(id, fn, ic, phone, email, pass);
				
				cus.add(c);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(Exception e) {e.printStackTrace();}
		}
		return cus;
	}
	
	public static boolean Update(customer c) throws ClassNotFoundException, SQLException {
		con = conn.initializeDatabase();
		
		boolean status = false;
		
		String id = c.getId();
		String name = c.getFullname();
		String password = c.getPassword();
		String email = c.getEmail();
		String phone = c.getPhone();
		String ic = c.getIc();
		
		try {
			String sql = "update customer set cFullname=?, cIC=?, cPhone=?, email=?, cPass=? where cID=?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, ic);
			ps.setString(3, phone);
			ps.setString(4, email);
			ps.setString(5, password);
			ps.setString(6, id);
			
			int res = ps.executeUpdate();
			
			if(res==1)
				status = true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return status;
	}
}
