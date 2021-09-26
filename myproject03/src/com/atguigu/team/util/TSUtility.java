/**  
* <p>Title: TSUtility.java</p>  
* <p>Description: </p>   
* @author zhouyao  
* @date 2021年6月25日  
* @version 1.0  
*/
package com.atguigu.team.util;

import java.util.Scanner;

public class TSUtility {

	/**
	 * 
	 * @Title: readMenuSelection
	 * @Description:该方法读取键盘，如果用户键入’1’-’4’中的任意字符，则方法返回。返回值为用户键入字符。
	 * @return
	 */
	public static char readMenuSelection() {
		char c;
		for (;;) {
			String str = readKeyBoard(1, false);
			c = str.charAt(0);
			if (c != '1' && c != '2' && c != '3' && c != '4') {
				System.out.print("选择错误，请重新输入：");
			} else {
				break;
			}
		}
		return c;
	}

	/**
	 * 
	 * @Title: readReturn
	 * @Description:该方法提示并等待，直到用户按回车键后返回。
	 */
	public static void readReturn() {
		System.out.print("按回车键继续...");
		readKeyBoard(100, true);
	}

	/**
	 * 
	 * @Title: readInt
	 * @Description:该方法从键盘读取一个长度不超过2位的整数，并将其作为方法的返回值。
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
				System.out.print("数字输入错误，请重新输入：");
			}
		}
		return n;

	}

	/**
	 * 
	 * @Title: readConfirmSelection
	 * @Description:从键盘读取‘Y’或’N’，并将其作为方法的返回值。
	 * @return
	 */
	public static char readConfirmSelection() {
		char c;
		for(;;) {
			String str = readKeyBoard(1, false);
			c = str.charAt(0);
			if (c != 'Y' || c != 'N') {
				System.out.println("输入错误，请重新输入");
			}else {
				break;
			}
		}
		return c;
	}

	// 私有方法 从键盘获取值
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
				System.out.print("输入长度（不大于" + limit + "）错误，请重新输入：");
				continue;
			}
			break;
		}
		return line;
	}

}
