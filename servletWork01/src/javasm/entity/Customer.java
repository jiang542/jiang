package javasm.entity;

import java.util.Objects;

/**
 * 管理员表
 */
public class Customer {
    private Integer customerId;//管理员编号
    private String customerName;//登录名称
    private String pwd;//密码

    public Customer(Integer customerId, String customerName, String pwd) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.pwd = pwd;
    }

    public Customer() {
    }

    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return Objects.equals(customerId, customer.customerId) &&
                Objects.equals(customerName, customer.customerName) &&
                Objects.equals(pwd, customer.pwd);
    }

    @Override
    public int hashCode() {
        return Objects.hash(customerId, customerName, pwd);
    }

    @Override
    public String toString() {
        return "Customer{" +
                "customerId=" + customerId +
                ", customerName='" + customerName + '\'' +
                ", pwd='" + pwd + '\'' +
                '}';
    }
}
