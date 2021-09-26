/**  
* <p>Title: NoteBook.java</p>  
* <p>Description: </p>   
* @author zhouyao  
* @date 2021Äê6ÔÂ25ÈÕ  
* @version 1.0  
*/
package com.atguigu.team.domain;

public class NoteBook implements Equipment {
	private String model;
	private double price;

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public NoteBook() {
		super();
	}

	public NoteBook(String model, double price) {
		super();
		this.model = model;
		this.price = price;
	}

	@Override
	public String getDescription() {
		return model + "(" + price + ")";

	}

}
