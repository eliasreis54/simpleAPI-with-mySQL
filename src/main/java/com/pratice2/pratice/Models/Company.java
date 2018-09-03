package com.pratice2.pratice.Models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name= "Company")
public class Company implements Serializable{
	private static final long serialVersionUID = 1456778916L;
	
	
	private long id;
	private String name;
	private int cnpj;
	private List<Employed> employed;
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO)
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	
	@Column(name = "Name", nullable	= false)
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	@Column(name = "CNPJ")
	public int getCnpj() {
		return cnpj;
	}
	public void setCnpj(int cnpj) {
		this.cnpj = cnpj;
	}
	
	@OneToMany(mappedBy = "company", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	public List<Employed> getEmployed() {
		return employed;
	}
	public void setEmployed(List<Employed> employed) {
		this.employed = employed;
	}
	
	
	
}
