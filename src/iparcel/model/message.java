package iparcel.model;

public class message {
	String senderid, receiverid, msg;
	int mid;
	public message(int mid, String senderid, String receiverid, String msg) {
		super();
		this.mid = mid;
		this.senderid = senderid;
		this.receiverid = receiverid;
		this.msg = msg;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public message() {}

	public String getSenderid() {
		return senderid;
	}

	public void setSenderid(String senderid) {
		this.senderid = senderid;
	}

	public String getReceiverid() {
		return receiverid;
	}

	public void setReceiverid(String receiverid) {
		this.receiverid = receiverid;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	@Override
	public String toString() {
		return "message [senderid=" + senderid + ", receiverid=" + receiverid + ", msg=" + msg + "]";
	}
}