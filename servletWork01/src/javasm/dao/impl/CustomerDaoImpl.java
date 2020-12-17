package javasm.dao.impl;

import javasm.dao.CustomerDao;
import javasm.entity.ClassInfo;
import javasm.entity.Customer;
import javasm.util.JDBCUtils;

import java.util.List;

public class CustomerDaoImpl implements CustomerDao {
    @Override
    public List<Customer> findAll() {
        String sql = "SELECT * FROM customer;";
        return JDBCUtils.getList(sql, Customer.class);
    }

    @Override
    public Customer login(String customerName, String pwd) {
        String sql = "SELECT * FROM customer WHERE customerName = ? AND pwd = ?;";
        return JDBCUtils.get(sql, Customer.class, customerName,pwd);
    }

    @Override
    public Customer findUserByUserid(int customerId) {
        String sql = "SELECT * FROM customer WHERE customerId = ?";
        return JDBCUtils.get(sql, Customer.class, customerId);
    }
}
