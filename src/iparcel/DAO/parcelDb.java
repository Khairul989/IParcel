package iparcel.DAO;

import java.sql.*;
import java.util.*;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import iparcel.conn;
import iparcel.model.*;
public class parcelDb {

	static String pid;
	static String track;
	static String ptype;
	static String date_arrive;
	static String date_collected;
	static String courier;
	static String status;
	static String staff;

	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static Statement st = null;
	
	public static boolean AddParcel(parcel p) throws ClassNotFoundException, SQLException {
		pid = p.getPid();
		track = p.getPtrack();
		ptype = p.getPtype();
		date_arrive = p.getDate_arrive();
		date_collected = p.getDate_collected();
		courier = p.getCourier();
		status = p.getStatus();
		staff = p.getSt().getId();
		
		con = conn.initializeDatabase();
		boolean insert = false;
		try {
			
			String sql1 = "select * from parcel where p_track='"+track+"'";
			ps = con.prepareStatement(sql1);
	
			rs = ps.executeQuery();
			
			if(rs.next()==false) {
				String sql = "insert into parcel(p_id, staff_id, p_track, p_type, p_da, p_dc, p_courier, p_stat) values (?,?,?,?,?,?,?,?)";
				
				ps = con.prepareStatement(sql);
				
				ps.setString(1, pid);
				ps.setString(2, staff);
				ps.setString(3, track);
				ps.setString(4, ptype);
				ps.setString(5, date_arrive);
				ps.setString(6, date_collected);
				ps.setString(7, courier);
				ps.setString(8, status);
				int res = ps.executeUpdate();
				
				if(res==1)
				{
					insert = true;
				}
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
		return insert;
	}
	
	public static ArrayList<parcel> getAllParcel() throws ClassNotFoundException, SQLException{
		con = conn.initializeDatabase();
		
		ArrayList<parcel> parcel = new ArrayList<parcel>();
		try {
			String sql = "select * from parcel";
			
			ps = con.prepareStatement(sql);
			
			rs = ps.executeQuery();
			parcel p = new parcel();
			
			while(rs.next()) {
				pid = rs.getString(1);
				track = rs.getString(3);
				staff = rs.getString(2);
				ptype = rs.getString(4);
				date_arrive = rs.getString(5);
				date_collected = rs.getString(6);
				courier = rs.getString(7);
				status = rs.getString(8);
				
				staff s = new staff();
				s.setId(staff);
				p = new parcel(pid, track, ptype, date_arrive, date_collected, courier, status, s);
				parcel.add(p);
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
		return parcel;
	}
	
	public static ArrayList<parcel> getParcel(String id) throws ClassNotFoundException, SQLException{
		con = conn.initializeDatabase();
		ArrayList<parcel> par = new ArrayList<parcel>();
		try {
			String sql = "select * from parcel p JOIN staff s ON p.staff_id = s.staff_id where p_id =? AND p_stat ='Not taken'";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				pid = rs.getString(1);
				staff = rs.getString(2);
				track = rs.getString(3);
				ptype = rs.getString(4);
				date_arrive = rs.getString(5);
				date_collected = rs.getString(6);
				courier = rs.getString(7);
				status = rs.getString(8);
				String st_name = rs.getString(11);
				
				staff s = new staff();
				s.setId(staff);
				s.setName(st_name);
				parcel p = new parcel(pid, track, ptype, date_arrive, date_collected, courier, status, s);
				
				par.add(p);
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
		return par;
	}
	
	public static boolean taken(String id, String stat) throws ClassNotFoundException, SQLException {
		con = conn.initializeDatabase();
		DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

		Date today = new Date();

		String td = formatter.format(today);
		
		System.out.println(td);
		boolean status = false;
		try {
			String sql = "update parcel set p_stat=?, p_dc=? where p_id=? and p_stat='Not taken'";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, stat);
			ps.setString(2, td);
			ps.setString(3, id);
			
			int res = ps.executeUpdate();
			
			if(res == 1) {
				status = true;
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
		return status;
	}
	
	public static ArrayList<parcel> getTakenParcel(String id) throws ClassNotFoundException, SQLException{
		con = conn.initializeDatabase();
		ArrayList<parcel> par = new ArrayList<parcel>();
		
		try {
			String sql = "select * from parcel p JOIN staff s ON p.staff_id = s.staff_id where p_id = ? AND p_stat ='Taken'";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				pid = rs.getString(1);
				staff = rs.getString(2);
				track = rs.getString(3);
				ptype = rs.getString(4);
				date_arrive = rs.getString(5);
				date_collected = rs.getString(6);
				courier = rs.getString(7);
				status = rs.getString(8);
				String st_name = rs.getString(10);
				
				staff s = new staff();
				s.setId(staff);
				s.setName(st_name);
				parcel p = new parcel(pid, track, ptype, date_arrive, date_collected, courier, status, s);
				
				par.add(p);
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
		return par;
	}
	
	public static ArrayList<parcel> getAllNotTaken() throws ClassNotFoundException, SQLException{
		con = conn.initializeDatabase();
		ArrayList<parcel> parcel = new ArrayList<parcel>();
		try {
			String sql = "select * from parcel where p_stat='Not taken'";
			
			ps = con.prepareStatement(sql);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				pid = rs.getString(1);
				staff = rs.getString(2);
				track = rs.getString(3);
				ptype = rs.getString(4);
				date_arrive = rs.getString(5);
				date_collected = rs.getString(6);
				courier = rs.getString(7);
				status = rs.getString(8);
				
				staff s = new staff();
				s.setId(staff);
				parcel p = new parcel(pid, track, ptype, date_arrive, date_collected, courier, status, s);
				
				parcel.add(p);
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
		return parcel;
	}
	
	public static boolean Update(parcel p) throws ClassNotFoundException, SQLException {
		con = conn.initializeDatabase();
		
		boolean insert = false;
		
		pid = p.getPid();
		track = p.getPtrack();
		ptype = p.getPtype();
		date_arrive = p.getDate_arrive();
		
		try {
			String sql = "update parcel set p_id=?, p_track = ?, p_da=?, p_type=? where p_stat='Not taken'";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, pid);
			ps.setString(2, track);
			ps.setString(3, date_arrive);
			ps.setString(4, ptype);
			
			int res = ps.executeUpdate();
			
			if(res==1)
				insert = true;
		}catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
		}
		
		return insert;
	}
	
	public static parcel getParcelUpdate(String track) throws ClassNotFoundException, SQLException{
		con = conn.initializeDatabase();
		try {
			String sql = "select * from parcel p JOIN staff s ON p.staff_id = s.staff_id where p_track =? AND p_stat ='Not taken'";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, track);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				pid = rs.getString(1);
				staff = rs.getString(2);
				track = rs.getString(3);
				ptype = rs.getString(4);
				date_arrive = rs.getString(5);
				date_collected = rs.getString(6);
				courier = rs.getString(7);
				status = rs.getString(8);
				String st_name = rs.getString(11);
				
				staff s = new staff();
				s.setId(staff);
				s.setName(st_name);
				parcel p = new parcel(pid, track, ptype, date_arrive, date_collected, courier, status, s);
				
				return p;
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
	
	public static boolean Delete(String pid) throws ClassNotFoundException, SQLException {
		con = conn.initializeDatabase();
		boolean status = false;
		
		try {
			String sql = "delete from parcel where p_track=?";
			ps = con.prepareStatement(sql);
			
			ps.setString(1, pid);
			
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
}
