/**  
* <p>Title: TeamException.java</p>  
* <p>Description: </p>   
* @author zhouyao  
* @date 2021年6月30日  
* @version 1.0  
*/
package com.atguigu.team.service;

/**
 * @version:
 * @Title: TeamService
 * @Description:自定义异常类
 * @author: zhouyao
 * @date: 2021年6月30日 下午5:33:47
 */
public class TeamException extends Exception {

	static final long serialVersionUID = -33875124229948L;

	public TeamException() {

	}

	public TeamException(String msg) {
		super(msg);
	}
}
