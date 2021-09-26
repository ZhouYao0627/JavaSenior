/**  
* <p>Title: NameListService.java</p>  
* <p>Description: </p>   
* @author zhouyao  
* @date 2021年6月25日  
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
 * @Description:负责将Data中的数据封装到Employee[]数组中，同时提供相关操作Employee[]的方法。
 * @author: zhouyao
 * @date: 2021年6月30日 下午4:18:08
 */
public class NameListService {

	private Employee[] employees;

	/**
	 * 
	 * @Title:NameListService
	 * @Description:给employees及数组元素进行初始化
	 */
	public NameListService() {
//	1、根据项目提供的Data类构建相应大小的employees数组
//	2、再根据Data类中的数据构建不同的对象，
//	包括Employee、Programmer、Designer和Architect对象，以及相关联的Equipment子类的对象
//	3、将对象存于数组中
		employees = new Employee[EMPLOYEES.length];

		for (int i = 0; i < employees.length; i++) {
			// 获取员工的类型
			int type = Integer.parseInt(EMPLOYEES[i][0]);
			// 获取Employee的4个基本信息
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
	 * @Description:获取指定index上的员工的设备
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
	 * @Description:获取当前所有员工
	 * @return:包含所有员工对象的数组
	 */
	public Employee[] getAllEmployees() {
		return employees;
	};

	/**
	 * 
	 * @Title: getEmployee 
	 * @Description:获取指定ID的员工对象
	 * @param id 指定员工的ID
	 * @return:指定员工对象
	 * @throws TeamException 找不到指定的员工
	 */
	public Employee getEmployee(int id) throws TeamException {
		for (int i = 0; i < employees.length; i++) {
			if (employees[i].getId() == id) {
				return employees[i];
			}
		}
		throw new TeamException("找不到指定的员工");
	}

}
