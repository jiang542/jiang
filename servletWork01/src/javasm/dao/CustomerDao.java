package javasm.dao;



import javasm.entity.Customer;

import java.util.List;

public interface CustomerDao {

    /**
     * 查找所有的管理员数据
     * @return
     */
    List<Customer> findAll();

    /**
     * 验证密码和用户名是否正确
     * @param customerName
     * @param pwd
     * @return
     */
    Customer login(String customerName,String pwd);

    /**
     * 根据customerId获取用户名
     * @param customerId
     * @return
     */
    Customer findUserByUserid(int customerId);
}
