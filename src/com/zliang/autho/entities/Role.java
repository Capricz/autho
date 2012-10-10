package com.zliang.autho.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the role database table.
 * 
 */
@Entity
public class Role implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROLE_ROLEID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLE_ROLEID_GENERATOR")
	private int roleid;

	private String rolename;

	//bi-directional many-to-one association to RoleFunction
	@OneToMany(mappedBy="role")
	private Set<RoleFunction> roleFunctions;

	//bi-directional many-to-one association to UserinfoRole
	@OneToMany(mappedBy="role")
	private Set<UserinfoRole> userinfoRoles;

    public Role() {
    }

	public int getRoleid() {
		return this.roleid;
	}

	public void setRoleid(int roleid) {
		this.roleid = roleid;
	}

	public String getRolename() {
		return this.rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

	public Set<RoleFunction> getRoleFunctions() {
		return this.roleFunctions;
	}

	public void setRoleFunctions(Set<RoleFunction> roleFunctions) {
		this.roleFunctions = roleFunctions;
	}
	
	public Set<UserinfoRole> getUserinfoRoles() {
		return this.userinfoRoles;
	}

	public void setUserinfoRoles(Set<UserinfoRole> userinfoRoles) {
		this.userinfoRoles = userinfoRoles;
	}
	
}