/**  
* <p>Title: TeamView.java</p>  
* <p>Description: </p>   
* @author zhouyao  
* @date 2021年7月1日  
* @version 1.0  
*/
package com.atguigu.team.view;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.domain.Programmer;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;
import com.atguigu.team.service.TeamService;
import com.atguigu.team.util.TSUtility;

public class TeamView {

	// listSvc和teamSvc属性：供类中的方法使用
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();

	/**
	 * 
	 * @Title: enterMainMenu
	 * @Description:主界面显示及控制方法
	 */
	public void enterMainMenu() {

		boolean loopFlag = true;
		char menu = 0;

		while (loopFlag) {
			if (menu != '1') {
				listAllEmployees();
			}

			System.out.println("1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择(1-4)");

			menu = TSUtility.readMenuSelection();
			switch (menu) {
			case '1':
				getTeam();
				break;
			case '2':
				addMember();
				break;
			case '3':
				deleteMember();
				break;
			case '4':
				System.out.println("是否确认退出(Y/N)");
				char isExit = TSUtility.readConfirmSelection();
				if (isExit == 'Y') {
					loopFlag = false;
				}
			}
		}
	}

	/**
	 * 
	 * @Title: listAllEmployees
	 * @Description:以表格形式显示公司所有员工信息
	 */
	private void listAllEmployees() {
		System.out.println("\n-------------------------------开发团队调度软件--------------------------------\n");
		Employee[] employees = listSvc.getAllEmployees();
		if (employees == null || employees.length == 0) {
			System.out.println("公司中没有任何员工信息！");
		} else {
			System.out.println("ID\t姓名\t年龄\t职位\t状态\t奖金\t股票\t领用设备");

			for (int i = 0; i < employees.length; i++) {
				System.out.println(employees[i]);
			}

		}
		System.out.println("\n--------------------------------------------------------------\n");
	}

	/**
	 * 
	 * @Title: getTeam
	 * @Description:显示团队成员列表操作
	 */
	private void getTeam() {
//		System.out.println("查看开发团队情况");
		System.out.println("\n--------------------团队成员列表---------------------\n");

		Programmer[] team = teamSvc.getTeam();
		if (team == null || team.length == 0) {
			System.out.println("开发团队目前没有成员");
		} else {
			System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t股票\n");
			for (int i = 0; i < team.length; i++) {
				System.out.println(team[i].getDetailsForTeam());
			}
		}

		System.out.println("\n-----------------------------------------\n");

	}

	/**
	 * 
	 * @Title: addMember
	 * @Description:实现添加成员操作
	 */
	private void addMember() {
//		System.out.println("添加团队成员");
		System.out.println("-------------------添加成员----------------------");
		System.out.print("请输入要添加的员工ID");
		int id = TSUtility.readInt();

		try {
			Employee emp = listSvc.getEmployee(id);
			teamSvc.addMember(emp);
			System.out.println("添加成功");
		} catch (TeamException e) {
			System.out.println("添加失败，原因：" + e.getMessage());
			// 按回车键继续
			TSUtility.readReturn();
		}
	}

	/**
	 * 
	 * @Title: deleteMember
	 * @Description:实现删除成员操作
	 * 
	 */
	private void deleteMember() {
//		System.out.println("删除团队成员");
		System.out.println("-------------------添加成员----------------------");
		System.out.print("请输入要删除的员工TID");

		int memberId = TSUtility.readInt();

		System.out.println("确认是否删除(Y/N)：");
		char isDelete = TSUtility.readConfirmSelection();

		if (isDelete == 'N') {
			return;
		}

		try {
			teamSvc.removeMember(memberId);
			System.out.println("删除成功");
		} catch (TeamException e) {
			System.out.println("删除失败，原因：" + e.getMessage());
		}

		// 按回车键继续
		TSUtility.readReturn();

	}

	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
	}

}
