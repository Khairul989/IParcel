package iparcel.DAO;

import java.sql.*;
import java.util.ArrayList;

import iparcel.conn;
import iparcel.model.staff;

public class staffDAO {

	static String username;
	static String password;
	static String email;
	static String phoneno;
	static String id;
	static String ic;
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static Statement st = null;
	
	
	public static staff login(String id, String password) throws SQLException, ClassNotFoundException {
		String sql = "select * from staff where staff_id = ? and staff_pass = ?";
		
		con = conn.initializeDatabase();
		ps = con.prepareStatement(sql);
		
		ps.setString(1, id);
		ps.setString(2, password);
		
		rs = ps.executeQuery();
		
		if(rs.next()) {
			staff s = new staff();
			s.setId(rs.getString(1));
			s.setName(rs.getString(2));
			s.setPassword(rs.getString(3));
			s.setEmail(rs.getString(4));
			s.setPhone(rs.getString(5));
			s.setIc(rs.getString(6));
			
			return s;
		}
		con.close();
		
		return null;
	}
	
	public static staff staffRegister(staff s) throws SQLException {
		id = s.getId();
		username = s.getName();
		password = s.getPassword();
		email = s.getEmail();
		phoneno = s.getPhone();
		ic = s.getIc();
		try {
			con = conn.initializeDatabase();
			String sql1 = "select * from staff where staff_id ='"+id+"'";
			ps = con.prepareStatement(sql1);
			rs = ps.executeQuery();
			if(rs.next()==false) {
				String sql = "insert into staff (staff_id, staff_name, staff_pass, staff_email, staff_phone,staff_ic) values(?,?,?,?,?,?)";
				ps = con.prepareStatement(sql);
				
				ps.setString(1, id);
				ps.setString(2, username);
				ps.setString(3, password);
				ps.setString(4, email);
				ps.setString(5, phoneno);
				ps.setString(6, ic);
				
				ps.executeUpdate();
				s.setVerify(true);
			}
			else
				s.setVerify(false);
		}
		catch(Exception e) {
			System.out.println("Error : "+e);
		}
		finally {
			con.close();
		}
		return s;
	}
	public static boolean Update(staff s) throws ClassNotFoundException, SQLException {
		con = conn.initializeDatabase();
		
		boolean status = false;
		
		String id = s.getId();
		String name = s.getName();
		String password = s.getPassword();
		String email = s.getEmail();
		String phone = s.getPhone();
		String ic = s.getIc();
		
		try {
			String sql = "update staff set staff_name=?, staff_pass=?, staff_email=?, staff_phone=?, staff_ic=? where staff_id=?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, name);
			ps.setString(2, password);
			ps.setString(3, email);
			ps.setString(4, phone);
			ps.setString(5, ic);
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
	public static boolean Delete(String staffid) throws ClassNotFoundException, SQLException {
		
		con = conn.initializeDatabase();
		boolean status = false;
		
		try {
			String sql = "delete from staff where staff_Id=?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, staffid);
			
			int res = ps.executeUpdate();
			
			if(res==1)
				status = true;
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		return status;
	}
	
	public static ArrayList<staff> AllStaff() throws ClassNotFoundException, SQLException {
		con = conn.initializeDatabase();
		ArrayList<staff> st = new ArrayList<staff>();
		try {
			String sql = "select * from staff";	
			PreparedStatement ps = con.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();
		
			while (rs.next()) {
				String id = rs.getString(1);
				String name = rs.getString(2);
				String password = rs.getString(3);
				String email = rs.getString(4);
				String phone = rs.getString(5);
				String ic = rs.getString(6);
			
				staff s = new staff(id, name, password, email, phone, ic);
				st.add(s);
			} 
		}catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
			return st;
		}

}
