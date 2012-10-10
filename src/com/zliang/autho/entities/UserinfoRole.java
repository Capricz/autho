package com.zliang.autho.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the userinfo_role database table.
 * 
 */
@Entity
@Table(name="userinfo_role")
public class UserinfoRole implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="USERINFO_ROLE_USERINFOROLEID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="USERINFO_ROLE_USERINFOROLEID_GENERATOR")
	@Column(name="userinfo_role_id")
	private int userinfoRoleId;

	//bi-directional many-to-one association to Role
    @ManyToOne
	@JoinColumn(name="roleid")
	private Role role;

	//bi-directional many-to-one association to Userinfo
    @ManyToOne
	@JoinColumn(name="userid")
	private Userinfo userinfo;

    public UserinfoRole() {
    }

	public int getUserinfoRoleId() {
		return this.userinfoRoleId;
	}

	public void setUserinfoRoleId(int userinfoRoleId) {
		this.userinfoRoleId = userinfoRoleId;
	}

	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
	public Userinfo getUserinfo() {
		return this.userinfo;
	}

	public void setUserinfo(Userinfo userinfo) {
		this.userinfo = userinfo;
	}
	
}