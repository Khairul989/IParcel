package iparcel.DAO;

import java.sql.*;
import java.util.*;

import iparcel.conn;
import iparcel.model.message;

public class messageDAO {
	
	static int mid;
	static String senderid;
	static String receiverid;
	static String msg;
	
	static Connection con = null;
	static PreparedStatement ps = null;
	static ResultSet rs = null;
	static Statement st = null;
	
	public static ArrayList<message> getMessage(String id) throws ClassNotFoundException, SQLException {
		con = conn.initializeDatabase();
		
		ArrayList<message> message = new ArrayList<message>();
		
		try {
			String sql = "select * from message where receiverID=?";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, id);
			
			rs = ps.executeQuery();
			
			while(rs.next()) {
				mid = rs.getInt(1);
				senderid = rs.getString(2);
				receiverid = rs.getString(3);
				msg = rs.getString(4);
				
				message m = new message(mid, senderid, receiverid, msg);
				message.add(m);
			}
		}catch(Exception e){
				e.printStackTrace();
			}finally {
				try {
					con.close();
				}
				catch(Exception e) {
					e.printStackTrace();
				}				
			}
			return message;
	}
	public static boolean InsertMessage(message m) throws ClassNotFoundException, SQLException{
		senderid = m.getSenderid();
		receiverid = m.getReceiverid();
		msg = m.getMsg();
		
		con = conn.initializeDatabase();
		boolean status = false;
		
		try {
			String sql = "insert into message(senderID, receiverID, message) values(?,?,?)";
			
			ps = con.prepareStatement(sql);
			ps.setString(1, senderid);
			ps.setString(2, receiverid);
			ps.setString(3, msg);
			
			int res = ps.executeUpdate();
			
			if(res==1) {
				status = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			}
			catch(Exception e) {
				e.printStackTrace();
			}			
		}
		return status;
	}
	
	public static boolean DeleteMessage(String mid) throws ClassNotFoundException, SQLException {
		
		con = conn.initializeDatabase();
		boolean status = false;
		
		try {
			String sql = "delete from message where mID = ?";
			
			ps = con.prepareStatement(sql);
			
			ps.setString(1, mid);
			
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