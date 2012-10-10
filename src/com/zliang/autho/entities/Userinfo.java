package com.zliang.autho.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the userinfo database table.
 * 
 */
@Entity
public class Userinfo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERINFO_USERID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERINFO_USERID_GENERATOR")
	private int userid;

	private String password;

	private String username;

	//bi-directional many-to-one association to UserinfoRole
	@OneToMany(mappedBy="userinfo")
	private Set<UserinfoRole> userinfoRoles;

    public Userinfo() {
    }

	public int getUserid() {
		return this.userid;
	}

	public void setUserid(int userid) {
		this.userid = userid;
	}

	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getUsername() {
		return this.username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Set<UserinfoRole> getUserinfoRoles() {
		return this.userinfoRoles;
	}

	public void setUserinfoRoles(Set<UserinfoRole> userinfoRoles) {
		this.userinfoRoles = userinfoRoles;
	}
	
}