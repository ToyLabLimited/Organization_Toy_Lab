package br.com.toylab.model;

import java.util.List;

public class Category {
 
	private Integer id ;
	private String name;
	private List<Toy> toyList;
   

public Category () {
	
}

public Category(Integer id, String name, List<Toy> toyList) {
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
public List<Toy> getToyList() {
	return toyList;
}

public void setToyList(List<Toy> toyList) {
	this.toyList = toyList;
}



}
