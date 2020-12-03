package iparcel.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import iparcel.conn;
import iparcel.model.customer;
import iparcel.model.lecturer;

public class lecturerDAO {
	static String id;
	static String faculty;
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static Statement st = null;
	
	public static boolean register(lecturer l) throws SQLException {
		
		id = l.getId();
		faculty = l.getFaculty();
		
		try {
			boolean status1 = custDAO.register(l);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		boolean status = false;
		try {
			con = conn.initializeDatabase();

				String sql1 = "insert into lecturer(lect_id, lect_faculty) values(?,?)";
				
				ps = con.prepareStatement(sql1);
				ps.setString(1, id);
				ps.setString(2, faculty);
				
				int res = ps.executeUpdate();
				if(res == 1) {
					status = true;
				}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return status;
	}
	
	public static lecturer login(String id, String pass) throws SQLException, ClassNotFoundException {
		
		String sql ="select * from customer c join lecturer l on c.cID = l.lect_id where c.cID=? and c.cPass=?";
		con = conn.initializeDatabase();
		try {		
		
			ps = con.prepareStatement(sql);
		
			ps.setString(1, id);
			ps.setString(2, pass);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				lecturer l = new lecturer();
				l.setId(rs.getString(1));
				l.setFullname(rs.getString(2));
				l.setIc(rs.getString(3));
				l.setPhone(rs.getString(4));
				l.setEmail(rs.getString(5));
				l.setPassword(rs.getString(6));
				l.setFaculty(rs.getString(8));
				return l;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}		
		return null;
	}
	public static ArrayList<lecturer> getLecturer() throws ClassNotFoundException, SQLException
	{
		con = conn.initializeDatabase();
		
		ArrayList<lecturer> lect = new ArrayList<lecturer>();
		
		try {
			String sql = "select * from customer c, lecturer l where c.cID = l.lect_id";
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				id = rs.getString(1);
				String name = rs.getString(2);
				String ic = rs.getString(3);
				String phone = rs.getString(4);
				String email = rs.getString(5);
				faculty = rs.getString(6);
				String pass = rs.getString(8);
				
				lecturer l = new lecturer(id, name, ic, phone, email, pass, faculty);
				
				lect.add(l);
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
		return lect;
	}
	
	public static boolean update(lecturer l) throws SQLException {
		
		id = l.getId();
		faculty = l.getFaculty();
		try {
			boolean status1 = custDAO.Update(l);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		boolean status = false;
		try {
			con = conn.initializeDatabase();

				String sql1 = "update lecturer set lect_faculty=? where lect_id=? ";
				
				ps = con.prepareStatement(sql1);
				ps.setString(1, faculty);
				ps.setString(2, id);
				
				int res = ps.executeUpdate();
				if(res == 1) {
					status = true;
				}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}
		}
		return status;
	}
}
