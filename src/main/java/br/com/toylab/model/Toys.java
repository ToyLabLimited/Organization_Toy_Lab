package br.com.toylab.model;

public class Toys {
	
	private Integer code;
	private String name;
	private String image ;
	private String description;
	private Double value ; 
	private String details ;
	private Category category ;
	private String brand ;
	
	
	private Toys () {
	}
	public Toys(Integer code, String name, String image, String description, Double value, String details,
			Category category, String brand) {
		super();
		this.code = code;
		this.name = name;
		this.image = image;
		this.description = description;
		this.value = value;
		this.details = details;
		this.category = category;
		this.brand = brand;
	}


	public Integer getCode() {
		return code;
	}


	public void setCode(Integer code) {
		this.code = code;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getImage() {
		return image;
	}


	public void setImage(String image) {
		this.image = image;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public Double getValue() {
		return value;
	}


	public void setValue(Double value) {
		this.value = value;
	}


	public String getDetails() {
		return details;
	}


	public void setDetails(String details) {
		this.details = details;
	}


	public Category getCategory() {
		return category;
	}


	public void setCategory(Category category) {
		this.category = category;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		this.brand = brand;
	}
	
	
}
