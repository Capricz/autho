package com.zliang.autho.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the function database table.
 * 
 */
@Entity
public class Function implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@SequenceGenerator(name="FUNCTION_FUNCTIONID_GENERATOR" )
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="FUNCTION_FUNCTIONID_GENERATOR")
	private int functionid;

	private String functionname;

	private String url;

	//bi-directional many-to-one association to Module
    @ManyToOne
	@JoinColumn(name="moduleid")
	private Module module;

	//bi-directional many-to-one association to RoleFunction
	@OneToMany(mappedBy="function")
	private Set<RoleFunction> roleFunctions;

    public Function() {
    }

	public int getFunctionid() {
		return this.functionid;
	}

	public void setFunctionid(int functionid) {
		this.functionid = functionid;
	}

	public String getFunctionname() {
		return this.functionname;
	}

	public void setFunctionname(String functionname) {
		this.functionname = functionname;
	}

	public String getUrl() {
		return this.url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Module getModule() {
		return this.module;
	}

	public void setModule(Module module) {
		this.module = module;
	}
	
	public Set<RoleFunction> getRoleFunctions() {
		return this.roleFunctions;
	}

	public void setRoleFunctions(Set<RoleFunction> roleFunctions) {
		this.roleFunctions = roleFunctions;
	}
	
}