package com.zliang.autho.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the module database table.
 * 
 */
@Entity
public class Module implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="MODULE_MODULEID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="MODULE_MODULEID_GENERATOR")
	private int moduleid;

	private String modulename;

	//bi-directional many-to-one association to Function
	@OneToMany(mappedBy="module")
	private Set<Function> functions;

    public Module() {
    }

	public int getModuleid() {
		return this.moduleid;
	}

	public void setModuleid(int moduleid) {
		this.moduleid = moduleid;
	}

	public String getModulename() {
		return this.modulename;
	}

	public void setModulename(String modulename) {
		this.modulename = modulename;
	}

	public Set<Function> getFunctions() {
		return this.functions;
	}

	public void setFunctions(Set<Function> functions) {
		this.functions = functions;
	}
	
}