package com.coeuz.cricbounz.model;

public class Authentication {
	
	private long id;
	
	private String username;
	
	private String password;
	
	private String logic;
	
	private String crteatedby;
	
	private String modified;
	
	private String resetpassword;
	
	private String deactivate;
	
	private String resetcount;
	
	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getLogic() {
		return logic;
	}

	public void setLogic(String logic) {
		this.logic = logic;
	}

	public String getCrteatedby() {
		return crteatedby;
	}

	public void setCrteatedby(String crteatedby) {
		this.crteatedby = crteatedby;
	}

	public String getModified() {
		return modified;
	}

	public void setModified(String modified) {
		this.modified = modified;
	}

	public String getResetpassword() {
		return resetpassword;
	}

	public void setResetpassword(String resetpassword) {
		this.resetpassword = resetpassword;
	}

	public String getDeactivate() {
		return deactivate;
	}

	public void setDeactivate(String deactivate) {
		this.deactivate = deactivate;
	}

	public String getResetcount() {
		return resetcount;
	}

	public void setResetcount(String resetcount) {
		this.resetcount = resetcount;
	}

}
