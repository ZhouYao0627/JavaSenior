/**  
* <p>Title: TSUtility.java</p>  
* <p>Description: </p>   
* @author zhouyao  
* @date 2021��6��25��  
* @version 1.0  
*/
package com.atguigu.team.util;

import java.util.Scanner;

public class TSUtility {

	/**
	 * 
	 * @Title: readMenuSelection
	 * @Description:�÷�����ȡ���̣�����û����롯1��-��4���е������ַ����򷽷����ء�����ֵΪ�û������ַ���
	 * @return
	 */
	public static char readMenuSelection() {
		char c;
		for (;;) {
			String str = readKeyBoard(1, false);
			c = str.charAt(0);
			if (c != '1' && c != '2' && c != '3' && c != '4') {
				System.out.print("ѡ��������������룺");
			} else {
				break;
			}
		}
		return c;
	}

	/**
	 * 
	 * @Title: readReturn
	 * @Description:�÷�����ʾ���ȴ���ֱ���û����س����󷵻ء�
	 */
	public static void readReturn() {
		System.out.print("���س�������...");
		readKeyBoard(100, true);
	}

	/**
	 * 
	 * @Title: readInt
	 * @Description:�÷����Ӽ��̶�ȡһ�����Ȳ�����2λ����������������Ϊ�����ķ���ֵ��
	 * @return
	 */
	public static int readInt() {
		int n;
		for (;;) {
			String str = readKeyBoard(2, false);
			try {
				n = Integer.parseInt(str);
				break;
			} catch (NumberFormatException e) {
				System.out.print("��������������������룺");
			}
		}
		return n;

	}

	/**
	 * 
	 * @Title: readConfirmSelection
	 * @Description:�Ӽ��̶�ȡ��Y����N������������Ϊ�����ķ���ֵ��
	 * @return
	 */
	public static char readConfirmSelection() {
		char c;
		for(;;) {
			String str = readKeyBoard(1, false);
			c = str.charAt(0);
			if (c != 'Y' || c != 'N') {
				System.out.println("�����������������");
			}else {
				break;
			}
		}
		return c;
	}

	// ˽�з��� �Ӽ��̻�ȡֵ
	private static String readKeyBoard(int limit, boolean blankReturn) {
		Scanner scanner = new Scanner(System.in);
		String line = "";
		while (scanner.hasNextLine()) {
			line = scanner.nextLine();
			if (line.length() == 0) {
				if (blankReturn) {
					break;
				} else {
					continue;
				}
			}
			if (line.length() < 0 || line.length() > limit) {
				System.out.print("���볤�ȣ�������" + limit + "���������������룺");
				continue;
			}
			break;
		}
		return line;
	}

}
