package Jdbc.java3;

import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.util.List;

/**
 * @author：ZhouYao
 * @create：2021-08-05 15:07
 */
public class CustomerDAOImpl extends BaseDAO implements CustomerDAO {
    @Override
    public int addCustomer(Connection connection, Customer cust) throws SQLException {
        String sql = "insert into customers(name,email,birth) values(?,?,?)";
        int count = update(connection, sql, cust.getName(), cust.getEmail(), cust.getBirth());

        return count;
    }

    @Override
    public int deleteCustomer(Connection connection, int id) throws SQLException {
        String sql = "delete from customers where id = ?";
        int count = update(connection, sql, id);

        return count;
    }

    @Override
    public int updateCustomer(Connection connection, Customer customer) throws SQLException {
        String sql = "update customers set name = ?,email = ?,birth = ?";
        int count = update(connection, sql, customer.getName(), customer.getEmail(), customer.getBirth());

        return count;
    }

    @Override
    public Customer getCustomer(Connection connection, int id) throws SQLException {
        String sql = "select name,email,birth from customers where id = ?";
        Customer customer = getInstance(connection, sql, Customer.class, id);

        return customer;
    }

    @Override
    public List<Customer> getAll(Connection connection) throws SQLException {
        String sql = "select name,email,birth from customers";
        List<Customer> list = getForList(connection, sql, Customer.class);

        return list;
    }

    @Override
    public long getCount(Connection connection) throws SQLException {
        String sql = "select count(*) from customers";
        long count = getValue(connection, sql);

        return count;
    }

    @Override
    public Date getMaxBirth(Connection connection) throws SQLException {
        String sql = "select max(birth) from customers";
        Date maxBirth = getValue(connection, sql);

        return maxBirth;
    }
}











