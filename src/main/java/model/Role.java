package model;

public class Role {
	private int roleid;
	private String rolename;
	private int approval;
	private String userid;
	
	public Role() {
	
	}
	
	public Role(int roleid, String rolename, int approval, String userid) {
		super();
		this.roleid = roleid;
		this.rolename = rolename;
		this.approval = approval;
		this.userid = userid;
	}

	public int getRoleid() {
		return roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public int getApproval() {
		return approval;
	}

	public void setApproval(int approval) {
		this.approval = approval;
	}

	public String getUserid() {
		return userid;
	}

	public void setUserid(String userid) {
		this.userid = userid;
	}
	
	
	
}
