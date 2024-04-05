package br.com.toylab.model;

public class ToyCategory {
	private Integer toyCode;
	private Integer categoryCode;
	
	
	public ToyCategory() {
		
		
	}


	public ToyCategory(Integer toyCode, Integer categoryCode) {
		super();
		this.toyCode = toyCode;
		this.categoryCode = categoryCode;
	}


	public Integer getToyCode() {
		return toyCode;
	}


	public void setToyCode(Integer toyCode) {
		this.toyCode = toyCode;
	}


	public Integer getCategoryCode() {
		return categoryCode;
	}


	public void setCategoryCode(Integer categoryCode) {
		this.categoryCode = categoryCode;
	}
		
}