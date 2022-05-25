package com.ordermgmt.app;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Users")
public class User {

	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="userid")
	private int id;
	private String username;
	private String  usernumber;
	private String useraddress;
	public int getid() {
		return id;
	}
	public void setid(int id) {
		this.id = id;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsernumber() {
		return usernumber;
	}
	public void setUsernumber(String usernumber) {
		this.usernumber = usernumber;
	}
	public String getUseraddress() {
		return useraddress;
	}
	public void setUseraddress(String useraddress) {
		this.useraddress = useraddress;
	}
	public User(int id, String username, String usernumber, String useraddress) {
		super();
		this.id = id;
		this.username = username;
		this.usernumber = usernumber;
		this.useraddress = useraddress;
	}
	@Override
	public String toString() {
		return "user [userid=" + id + ", username=" + username + ", usernumber=" + usernumber + ", useraddress="
				+ useraddress + "]";
	}
	
	public User()
	{}
	
	
}
