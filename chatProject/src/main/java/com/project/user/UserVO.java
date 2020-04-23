package com.project.user;

public class UserVO {
	
	String id;
	String password;
	String thumbnailPath;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getThumbnailPath() {
		return thumbnailPath;
	}
	public void setThumbnailPath(String thumbnailPath) {
		this.thumbnailPath = thumbnailPath;
	}
	@Override
	public String toString() {
		return "UserVO [id=" + id + ", password=" + password + ", thumbnailPath=" + thumbnailPath + "]";
	}
		

}
