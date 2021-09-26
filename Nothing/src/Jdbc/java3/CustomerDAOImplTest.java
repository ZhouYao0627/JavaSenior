package Jdbc.java3;

import Jdbc.java1.util.JDBCUtils;
import org.junit.Test;

import java.sql.Connection;
import java.util.List;

/**
 * @author：ZhouYao
 * @create：2021-08-05 15:07
 */
public class CustomerDAOImplTest {

    @Test
    public void test1() {

        Connection connection = null;
        try {
            connection = JDBCUtils.getConnection();

            CustomerDAOImpl imp1 = new CustomerDAOImpl();
            List<Customer> list = imp1.getAll(connection);
            for (Customer customer : list)
                System.out.println(customer);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCUtils.close(connection);
        }

    }


}














