/**  
* <p>Title: Designer.java</p>  
* <p>Description: </p>   
* @author zhouyao  
* @date 2021��6��25��  
* @version 1.0  
*/
package com.atguigu.team.domain;

/*
 * bonus ��ʾ����
 * stock ��ʾ��˾�����Ĺ�Ʊ����
 */
public class Designer extends Programmer {
	private double bonus;

	public Designer() {
		super();
	}

	public Designer(int id, String name, int age, double salary, Equipment equipment, double bonus) {
		super(id, name, age, salary, equipment);
		this.bonus = bonus;
	}

	public double getBonus() {
		return bonus;
	}

	public void setBonus(double bonus) {
		this.bonus = bonus;
	}

	@Override
	public String toString() {
		return getDetails() + "\t���ʦ\t" + getStatus() + "\t" + bonus + "\t\t" + getEquipment().getDescription();
	}

	public String getDetailsForTeam() {
		return getTeamBaseDetails() + "\t���ʦ" + "\t" + getBonus();
	}

}
