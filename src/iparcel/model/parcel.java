package iparcel.model;

public class parcel {
	
	String pid, ptrack, ptype, date_arrive, date_collected, courier, status;
	staff st;
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	public String getPtrack() {
		return ptrack;
	}
	public void setPtrack(String ptrack) {
		this.ptrack = ptrack;
	}
	public String getPtype() {
		return ptype;
	}
	public void setPtype(String ptype) {
		this.ptype = ptype;
	}
	public String getDate_arrive() {
		return date_arrive;
	}
	public void setDate_arrive(String date_arrive) {
		this.date_arrive = date_arrive;
	}
	public String getDate_collected() {
		return date_collected;
	}
	public void setDate_collected(String date_collected) {
		this.date_collected = date_collected;
	}
	public String getCourier() {
		return courier;
	}
	public void setCourier(String courier) {
		this.courier = courier;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public staff getSt() {
		return st;
	}
	public void setSt(staff st) {
		this.st = st;
	}
	public parcel(String pid, String ptrack, String ptype, String date_arrive, String date_collected, String courier,
			String status, staff st) {
		super();
		this.pid = pid;
		this.ptrack = ptrack;
		this.ptype = ptype;
		this.date_arrive = date_arrive;
		this.date_collected = date_collected;
		this.courier = courier;
		this.status = status;
		this.st = st;
	}
	
	public parcel() {}
	@Override
	public String toString() {
		return "parcel [pid=" + pid + ", ptrack=" + ptrack + ", ptype=" + ptype + ", date_arrive=" + date_arrive
				+ ", date_collected=" + date_collected + ", courier=" + courier + ", status=" + status + ", st=" + st
				+ "]";
	}
	
	
}
