package Jdbc.java3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * @author：ZhouYao
 * @create：2021-08-05 15:07
 */
public interface CustomerDAO {

    // 向数据表中添加一条记录
    int addCustomer(Connection connection, Customer cust) throws SQLException;

    // 根据指定id,删除一条记录
    int deleteCustomer(Connection connection, int id) throws SQLException;

    // 修改表中的一条记录
    int updateCustomer(Connection connection, Customer customer) throws SQLException;

    // 根据指定的id,查询表中的一条记录
    Customer getCustomer(Connection connection, int id) throws SQLException;

    // 查询表中的所有记录
    List<Customer> getAll(Connection connection) throws SQLException;

    // 查询表中的条目数
    long getCount(Connection connection) throws SQLException;

    // 查询最大的生日
    Date getMaxBirth(Connection connection) throws SQLException;
}


















