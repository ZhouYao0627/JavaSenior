/**  
* <p>Title: TeamView.java</p>  
* <p>Description: </p>   
* @author zhouyao  
* @date 2021��7��1��  
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

	// listSvc��teamSvc���ԣ������еķ���ʹ��
	private NameListService listSvc = new NameListService();
	private TeamService teamSvc = new TeamService();

	/**
	 * 
	 * @Title: enterMainMenu
	 * @Description:��������ʾ�����Ʒ���
	 */
	public void enterMainMenu() {

		boolean loopFlag = true;
		char menu = 0;

		while (loopFlag) {
			if (menu != '1') {
				listAllEmployees();
			}

			System.out.println("1-�Ŷ��б� 2-����Ŷӳ�Ա 3-ɾ���Ŷӳ�Ա 4-�˳� ��ѡ��(1-4)");

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
				System.out.println("�Ƿ�ȷ���˳�(Y/N)");
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
	 * @Description:�Ա����ʽ��ʾ��˾����Ա����Ϣ
	 */
	private void listAllEmployees() {
		System.out.println("\n-------------------------------�����Ŷӵ������--------------------------------\n");
		Employee[] employees = listSvc.getAllEmployees();
		if (employees == null || employees.length == 0) {
			System.out.println("��˾��û���κ�Ա����Ϣ��");
		} else {
			System.out.println("ID\t����\t����\tְλ\t״̬\t����\t��Ʊ\t�����豸");

			for (int i = 0; i < employees.length; i++) {
				System.out.println(employees[i]);
			}

		}
		System.out.println("\n--------------------------------------------------------------\n");
	}

	/**
	 * 
	 * @Title: getTeam
	 * @Description:��ʾ�Ŷӳ�Ա�б����
	 */
	private void getTeam() {
//		System.out.println("�鿴�����Ŷ����");
		System.out.println("\n--------------------�Ŷӳ�Ա�б�---------------------\n");

		Programmer[] team = teamSvc.getTeam();
		if (team == null || team.length == 0) {
			System.out.println("�����Ŷ�Ŀǰû�г�Ա");
		} else {
			System.out.println("TID/ID\t����\t����\t����\tְλ\t����\t��Ʊ\n");
			for (int i = 0; i < team.length; i++) {
				System.out.println(team[i].getDetailsForTeam());
			}
		}

		System.out.println("\n-----------------------------------------\n");

	}

	/**
	 * 
	 * @Title: addMember
	 * @Description:ʵ����ӳ�Ա����
	 */
	private void addMember() {
//		System.out.println("����Ŷӳ�Ա");
		System.out.println("-------------------��ӳ�Ա----------------------");
		System.out.print("������Ҫ��ӵ�Ա��ID");
		int id = TSUtility.readInt();

		try {
			Employee emp = listSvc.getEmployee(id);
			teamSvc.addMember(emp);
			System.out.println("��ӳɹ�");
		} catch (TeamException e) {
			System.out.println("���ʧ�ܣ�ԭ��" + e.getMessage());
			// ���س�������
			TSUtility.readReturn();
		}
	}

	/**
	 * 
	 * @Title: deleteMember
	 * @Description:ʵ��ɾ����Ա����
	 * 
	 */
	private void deleteMember() {
//		System.out.println("ɾ���Ŷӳ�Ա");
		System.out.println("-------------------��ӳ�Ա----------------------");
		System.out.print("������Ҫɾ����Ա��TID");

		int memberId = TSUtility.readInt();

		System.out.println("ȷ���Ƿ�ɾ��(Y/N)��");
		char isDelete = TSUtility.readConfirmSelection();

		if (isDelete == 'N') {
			return;
		}

		try {
			teamSvc.removeMember(memberId);
			System.out.println("ɾ���ɹ�");
		} catch (TeamException e) {
			System.out.println("ɾ��ʧ�ܣ�ԭ��" + e.getMessage());
		}

		// ���س�������
		TSUtility.readReturn();

	}

	public static void main(String[] args) {
		TeamView view = new TeamView();
		view.enterMainMenu();
	}

}
