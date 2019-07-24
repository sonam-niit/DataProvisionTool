package com.niit.dpt.dataplan;

public class DataPlan {

	private int id;
	private String pack;
	private String validity;
	private String price;
	private String description;
	private int userId;
	
	
	public DataPlan() {
		
	}

	public DataPlan(int id,String pack, String validity, String price, String description) {
		super();
		this.id=id;
		this.pack = pack;
		this.validity = validity;
		this.price = price;
		this.description = description;
	}

	
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPack() {
		return pack;
	}

	public void setPack(String pack) {
		this.pack = pack;
	}

	public String getValidity() {
		return validity;
	}

	public void setValidity(String validity) {
		this.validity = validity;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "DataPlan [pack=" + pack + ", validity=" + validity + ", price=" + price + ", description=" + description
				+ "]";
	}
	
	
	
}
