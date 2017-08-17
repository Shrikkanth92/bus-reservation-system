package com.polaris.teamd.bean;

public class CLogin {
	int count=0;
	String loginId, userName, password;
	int roleId;

	public CLogin() {
		super();
	}

	
	public CLogin(String loginId, String password) {
		super();
		this.loginId = loginId;
		this.password = password;
	}


	public CLogin(int count, String loginId, String userName, String password,
			int roleId) {
		super();
		this.count = count;
		this.loginId = loginId;
		this.userName = userName;
		this.password = password;
		this.roleId = roleId;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public int getRoleId() {
		return roleId;
	}

	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((loginId == null) ? 0 : loginId.hashCode());
		result = prime * result
				+ ((password == null) ? 0 : password.hashCode());
		return result;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		CLogin other = (CLogin) obj;
		if (loginId == null) {
			if (other.loginId != null)
				return false;
		} else if (!loginId.equals(other.loginId))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		return true;
	}


	@Override
	public String toString() {
		return "CLogin [count=" + count + ", loginId=" + loginId
				+ ", userName=" + userName + ", password=" + password
				+ ", roleId=" + roleId + "]";
	}

}
