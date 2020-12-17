package javasm.control;

import javasm.dao.CustomerDao;
import javasm.dao.impl.CustomerDaoImpl;
import javasm.entity.Customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    private CustomerDao customerDao = new CustomerDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        CustomerDao customerDao = new CustomerDaoImpl();

        String customerName = request.getParameter("customerName");
        String pwd = request.getParameter("pwd");

        Customer customer = customerDao.login(customerName, pwd);
        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();

        //获取所有的cookie,并验证userId_Cookie是否存在--存在则不用验证
        Cookie[] cookies = request.getCookies();
        boolean flag = false;
        int userId = 0;
        for (Cookie cookie : cookies) {
            if ("customerId".equals(cookie.getName())){
                flag = true;
                userId = Integer.valueOf(cookie.getValue());
                break;
            }
        }

        if (flag){
            customer = customerDao.findUserByUserid(userId);
            session.setAttribute("loginCustomer", customer);
            request.getRequestDispatcher("main.jsp").forward(request, response);
        }else{
            //没有cookie,需要重新验证用户名和密码是否正确
            if (customer != null) {
                session.setAttribute("loginCustomer", customer);
                String flagRemeber = request.getParameter("flagRemeber");
                if (flagRemeber!=null){
                    //设置用户id为cookie-并设置时间为一天
                    Cookie userId_Cookie = new Cookie("customerId", "" + customer.getCustomerId());
                    userId_Cookie.setMaxAge(60*60*24);
                    response.addCookie(userId_Cookie);
                }
                request.getRequestDispatcher("main.jsp").forward(request, response);

            }
            else {
                request.setAttribute("message", "账号密码不正确");
                request.getRequestDispatcher("login.jsp").forward(request, response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
