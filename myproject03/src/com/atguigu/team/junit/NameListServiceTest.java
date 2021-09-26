/**  
* <p>Title: NameListServiceTest.java</p>  
* <p>Description: </p>   
* @author zhouyao  
* @date 2021年6月30日  
* @version 1.0  
*/
package com.atguigu.team.junit;

import com.atguigu.team.domain.Employee;
import com.atguigu.team.service.NameListService;
import com.atguigu.team.service.TeamException;
import org.junit.Test;

/**
 * @version:
 * @Title: NameListServiceTest
 * @Description:对NameListService类的测试
 * @author: zhouyao
 * @date: 2021年6月30日 下午5:45:29
 */
public class NameListServiceTest {

	@Test
	public void testGetAllEmployees() {
		NameListService service = new NameListService();
		Employee[] employees = service.getAllEmployees();
		for (int i = 0; i < employees.length; i++) {
			System.out.println(employees[i]);
		}

	}

	@Test
	public void testGetEmployee() {
		NameListService service = new NameListService();
		int id = 10;
		try {
			Employee employee = service.getEmployee(id);
			System.out.println(employee);
		} catch (TeamException e) {
			System.err.println(e.getMessage());
		}
	}

}
