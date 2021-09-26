/**  
* <p>Title: Programmer.java</p>  
* <p>Description: </p>   
* @author zhouyao  
* @date 2021年6月25日  
* @version 1.0  
*/
package com.atguigu.team.domain;

import com.atguigu.team.service.*;

/*
 * memberId 用来记录成员加入开发团队后在团队中的ID
 * Status是项目service包下自定义的类，声明三个对象属性，分别表示成员的状态。
 * FREE-空闲
 * BUSY-已加入开发团队
 * VOCATION-正在休假
 * equipment 表示该成员领用的设备
 */
public class Programmer extends Employee {

	private int memberId;
	private Status status = Status.FREE;
	private Equipment equipment;

	public int getMemberId() {
		return memberId;
	}

	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Equipment getEquipment() {
		return equipment;
	}

	public void setEquipment(Equipment equipment) {
		this.equipment = equipment;
	}

	public Programmer() {
		super();
	}

	public Programmer(int id, String name, int age, double salary, Equipment equipment) {
		super(id, name, age, salary);
		this.equipment = equipment;
	}

	@Override
	public String toString() {
		return getDetails() + "\t程序员\t" + status + "\t\t\t" + equipment.getDescription();
	}

	public String getTeamBaseDetails() {
		return memberId + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary();
	}

	public String getDetailsForTeam() {
		return getTeamBaseDetails() + "\t程序员";
	}

}
