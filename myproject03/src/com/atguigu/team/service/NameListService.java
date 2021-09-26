/**  
* <p>Title: NameListService.java</p>  
* <p>Description: </p>   
* @author zhouyao  
* @date 2021��6��25��  
* @version 1.0  
*/
package com.atguigu.team.service;

import com.atguigu.team.domain.Architect;
import com.atguigu.team.domain.Designer;
import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Equipment;
import com.atguigu.team.domain.NoteBook;
import com.atguigu.team.domain.PC;
import com.atguigu.team.domain.Printer;
import com.atguigu.team.domain.Programmer;

import static com.atguigu.team.service.Data.*;

/**
 * @version:
 * @Title: NameListService
 * @Description:����Data�е����ݷ�װ��Employee[]�����У�ͬʱ�ṩ��ز���Employee[]�ķ�����
 * @author: zhouyao
 * @date: 2021��6��30�� ����4:18:08
 */
public class NameListService {

	private Employee[] employees;

	/**
	 * 
	 * @Title:NameListService
	 * @Description:��employees������Ԫ�ؽ��г�ʼ��
	 */
	public NameListService() {
//	1��������Ŀ�ṩ��Data�๹����Ӧ��С��employees����
//	2���ٸ���Data���е����ݹ�����ͬ�Ķ���
//	����Employee��Programmer��Designer��Architect�����Լ��������Equipment����Ķ���
//	3�����������������
		employees = new Employee[EMPLOYEES.length];

		for (int i = 0; i < employees.length; i++) {
			// ��ȡԱ��������
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			// ��ȡEmployee��4��������Ϣ
			int id = Integer.parseInt(EMPLOYEES[i][1]);
			String name = EMPLOYEES[i][2];
			int age = Integer.parseInt(EMPLOYEES[i][3]);
			double salary = Double.parseDouble(EMPLOYEES[i][4]);

			Equipment equipment;
			double bonus;
			int stock;

			switch (type) {
			case EMPLOYEE: // 10
				employees[i] = new Employee(id, name, age, salary);
				break;
			case PROGRAMMER: // 11
				equipment = creatEquipment(i);
				employees[i] = new Programmer(id, name, age, salary, equipment);
				break;
			case DESIGNER: // 12
				equipment = creatEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				employees[i] = new Designer(id, name, age, salary, equipment, bonus);
				break;
			case ARCHITECT: // 13
				equipment = creatEquipment(i);
				bonus = Double.parseDouble(EMPLOYEES[i][5]);
				stock = Integer.parseInt(EMPLOYEES[i][6]);
				employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
				break;
			}

		}

	}

	/**
	 * @Title: creatEquipment
	 * @Description:��ȡָ��index�ϵ�Ա�����豸
	 * @param index
	 * @return
	 */
	private Equipment creatEquipment(int index) {
		int key = Integer.parseInt(EQUIPMENTS[index][0]);

		String modelOrName = EQUIPMENTS[index][1];
		switch (key) {
		case PC: // 21
			String display = EQUIPMENTS[index][2];
			return new PC(modelOrName, display);
//			return new PC(EQUIPMENTS[index][1], EQUIPMENTS[index][2]);
		case NOTEBOOK: // 22
			double price = Double.parseDouble(EQUIPMENTS[index][2]);
			return new NoteBook(modelOrName, price);
		case PRINTER: // 23
			String type = EQUIPMENTS[index][2];
			return new Printer(modelOrName, type);
		}

		return null;
	}

	/**
	 * 
	 * @Title: getAllEmployees
	 * @Description:��ȡ��ǰ����Ա��
	 * @return:��������Ա�����������
	 */
	public Employee[] getAllEmployees() {
		return employees;
	};

	/**
	 * 
	 * @Title: getEmployee 
	 * @Description:��ȡָ��ID��Ա������
	 * @param id ָ��Ա����ID
	 * @return:ָ��Ա������
	 * @throws TeamException �Ҳ���ָ����Ա��
	 */
	public Employee getEmployee(int id) throws TeamException {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}
		throw new TeamException("�Ҳ���ָ����Ա��");
	}

}
