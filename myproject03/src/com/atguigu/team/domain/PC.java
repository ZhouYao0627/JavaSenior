/**  
* <p>Title: PC.java</p>  
* <p>Description: </p>   
* @author zhouyao  
* @date 2021年6月25日  
* @version 1.0  
*/
package com.atguigu.team.domain;

public class PC implements Equipment {

	private String model; // 机器的型号
	private String display; // 显示器名称

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getDiaplay() {
		return display;
	}

	public void setDiaplay(String diaplay) {
		this.display = diaplay;
	}

	public PC() {
		super();
	}

	public PC(String model, String display) {
		super();
		this.model = model;
		this.display = display;
	}

	@Override
	public String getDescription() {
		return model + "(" + display + ")";
	}

}
