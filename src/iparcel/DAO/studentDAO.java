package iparcel.DAO;

import java.sql.*;
import java.util.ArrayList;

import iparcel.conn;
import iparcel.model.customer;
import iparcel.model.lecturer;
import iparcel.model.student;

public class studentDAO {
	static String id;
	static String status;
	static String program;
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	
	public static boolean register(student s) throws SQLException {

		id = s.getId();
		status = s.getStatus();
		program = s.getProgram();
		try {
			boolean status1 = custDAO.register(s);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		boolean statuss = false;
		
		try {
			con = conn.initializeDatabase();
				String sql1 = "insert into student (stu_id, stu_stat, stu_prog) values(?,?,?)";
				ps = con.prepareStatement(sql1);
				
				ps.setString(1, id);
				ps.setString(2, status);
				ps.setString(3, program);
				
				int res = ps.executeUpdate();
				if(res == 1) {
					statuss = true;
				}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			con.close();
		}
		return statuss;
	}
	
	public static student login(String id, String pass) throws SQLException, ClassNotFoundException {
		
		String sql ="select * from customer c join student s on c.cID = s.stu_id where c.cID=? and c.cPass=?";
		con = conn.initializeDatabase();
		student s = new student();
		try {
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			ps.setString(2, pass);
			
			rs = ps.executeQuery();
			
			if(rs.next()) {
				
				
				s.setId(rs.getString(1));
				s.setFullname(rs.getString(2));
				s.setIc(rs.getString(3));
				s.setPhone(rs.getString(4));
				s.setEmail(rs.getString(5));
				s.setPassword(rs.getString(6));
				s.setStatus(rs.getString(8));
				s.setProgram(rs.getString(9));
				
				return s;
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		finally {
			try {
				con.close();
			}
			catch(Exception e) {e.printStackTrace();}
		}
		return null;
	}
	public static ArrayList<student> getStudent() throws ClassNotFoundException, SQLException{
		
		con = conn.initializeDatabase();
		ArrayList<student> stu = new ArrayList<student>();
		
		try {
			String sql = "select * from customer c join student s on c.cID = s.stu_id where stu_stat = 'Active'";
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				id = rs.getString(1);
				String name = rs.getString(2);
				String ic = rs.getString(3);
				String phone = rs.getString(4);
				String email = rs.getString(5);
				String pass = rs.getString(6);
				status = rs.getString(8);
				program = rs.getString(9);
				
				student s = new student(id, name, ic, phone, email, pass, status, program);
				stu.add(s);
			}
		}
		catch (Exception e) {
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
		return stu;
	}

	public static boolean update(student s) throws SQLException {
		
		id = s.getId();
		program = s.getProgram();
		status = s.getStatus();
		
		System.out.println(s.toString());
		try {
			boolean status1 = custDAO.Update(s);
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		boolean statuss = false;
		try {
			con = conn.initializeDatabase();

				String sql1 = "update student set stu_stat=?, stu_prog=? where stu_id=? ";
				
				ps = con.prepareStatement(sql1);
				
				ps.setString(1, status);
				ps.setString(2, program);
				ps.setString(3, id);
				
				int res = ps.executeUpdate();
				if(res == 1) {
					statuss = true;
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
		return statuss;
	}
}
