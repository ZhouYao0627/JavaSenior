/**  
* <p>Title: Architect.java</p>  
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
public class Architect extends Designer {
	private int stock;

	public Architect() {
		super();
	}

	public Architect(int id, String name, int age, double salary, Equipment equipment, double bonus, int stock) {
		super(id, name, age, salary, equipment, bonus);
		this.stock = stock;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public String toString() {
		return getDetails() + "\t�ܹ�ʦ\t" + getStatus() + "\t" + getBonus() + "\t" + stock
				+ getEquipment().getDescription();
	}

	public String getDetailsForTeam() {
		return getTeamBaseDetails() + "\t�ܹ�ʦ" + "\t" + getBonus() + "\t" + getStock();
	}
}
