package br.com.toylab.model;

import java.util.List;

public class Category {
 
	private Integer id ;
	private String name;
	private List<Toys> toyList;
   

public Category () {
	
}

public Category(Integer id, String name, List<Toys> toyList) {
	super();
	this.id = id;
	this.name = name;
	this.toyList = toyList;
}


public Integer getId() {
	return id;
}


public void setId(Integer id) {
	this.id = id;
}


public String getName() {
	return name;
}


public void setName(String name) {
	this.name = name;
}
public List<Toys> getToyList() {
	return toyList;
}

public void setToyList(List<Toys> toyList) {
	this.toyList = toyList;
}



}
