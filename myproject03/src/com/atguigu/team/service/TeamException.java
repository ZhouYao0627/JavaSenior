/**  
* <p>Title: TeamException.java</p>  
* <p>Description: </p>   
* @author zhouyao  
* @date 2021��6��30��  
* @version 1.0  
*/
package com.atguigu.team.service;

/**
 * @version:
 * @Title: TeamService
 * @Description:�Զ����쳣��
 * @author: zhouyao
 * @date: 2021��6��30�� ����5:33:47
 */
public class TeamException extends Exception {

	static final long serialVersionUID = -33875124229948L;

	public TeamException() {

	}

	public TeamException(String msg) {
		super(msg);
	}
}
