package com.tr.webapp.demo.model;

import java.util.Objects;

public class UserProfile {

	private String userName;
	private String preferredUserName;
	private Boolean isAdmin;
	
	public UserProfile() {
		super();
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param userName
	 * @param preferredUserName
	 * @param isAdmin
	 */
	public UserProfile(String userName, String preferredUserName, Boolean isAdmin) {
		super();
		this.userName = userName;
		this.preferredUserName = preferredUserName;
		this.isAdmin = isAdmin;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPreferredUserName() {
		return preferredUserName;
	}
	public void setPreferredUserName(String preferredUserName) {
		this.preferredUserName = preferredUserName;
	}
	public Boolean getIsAdmin() {
		return isAdmin;
	}
	public void setIsAdmin(Boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	@Override
	public int hashCode() {
		return Objects.hash(isAdmin, preferredUserName, userName);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		UserProfile other = (UserProfile) obj;
		return Objects.equals(isAdmin, other.isAdmin) && Objects.equals(preferredUserName, other.preferredUserName)
				&& Objects.equals(userName, other.userName);
	}
	@Override
	public String toString() {
		return "UserProfile [userName=" + userName + ", preferredUserName=" + preferredUserName + ", isAdmin=" + isAdmin
				+ "]";
	}
	
	
}
