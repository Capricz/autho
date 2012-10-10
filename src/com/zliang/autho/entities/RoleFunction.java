package com.zliang.autho.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the role_function database table.
 * 
 */
@Entity
@Table(name="role_function")
public class RoleFunction implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="ROLE_FUNCTION_ROLEFUNCTIONID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="ROLE_FUNCTION_ROLEFUNCTIONID_GENERATOR")
	private int rolefunctionid;

	//bi-directional many-to-one association to Function
    @ManyToOne
	@JoinColumn(name="functionid")
	private Function function;

	//bi-directional many-to-one association to Role
    @ManyToOne
	@JoinColumn(name="roleid")
	private Role role;

    public RoleFunction() {
    }

	public int getRolefunctionid() {
		return this.rolefunctionid;
	}

	public void setRolefunctionid(int rolefunctionid) {
		this.rolefunctionid = rolefunctionid;
	}

	public Function getFunction() {
		return this.function;
	}

	public void setFunction(Function function) {
		this.function = function;
	}
	
	public Role getRole() {
		return this.role;
	}

	public void setRole(Role role) {
		this.role = role;
	}
	
}