/**  
* <p>Title: Programmer.java</p>  
* <p>Description: </p>   
* @author zhouyao  
* @date 2021��6��25��  
* @version 1.0  
*/
package com.atguigu.team.domain;

import com.atguigu.team.service.*;

/*
 * memberId ������¼��Ա���뿪���ŶӺ����Ŷ��е�ID
 * Status����Ŀservice�����Զ�����࣬���������������ԣ��ֱ��ʾ��Ա��״̬��
 * FREE-����
 * BUSY-�Ѽ��뿪���Ŷ�
 * VOCATION-�����ݼ�
 * equipment ��ʾ�ó�Ա���õ��豸
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
		return getDetails() + "\t����Ա\t" + status + "\t\t\t" + equipment.getDescription();
	}

	public String getTeamBaseDetails() {
		return memberId + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary();
	}

	public String getDetailsForTeam() {
		return getTeamBaseDetails() + "\t����Ա";
	}

}
