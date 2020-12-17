package javasm.control;

import javasm.dao.StudentDao;
import javasm.dao.impl.StudentDaoImpl;
import javasm.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/studentServlet")
public class StudentServlet extends HttpServlet {
    private StudentDao studentDao = new StudentDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String way = request.getParameter("way");
        switch (way) {
            case "showAll":
                //显示所有学生数据在student.jsp上
                showAll(request, response);
                break;
            case "addStudent":
                //添加学生信息
                addStudent(request, response);
                break;
            case "updateStudent":
                //修改学生信息
                updateStudent(request, response);
                break;
            case "deleteStudent":
                //删除学生信息
                deleteStudent(request, response);
                break;
            case "deleteMoreStudent":
                //删除学生信息
                deleteMoreStudent(request, response);
                break;
            case "showById":
                //根据id得到学生信息
                showById(request, response);
                break;
            default:
                break;
        }
    }

    protected void showById(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Student student = new Student();
        student.setStuClass(Integer.valueOf(request.getParameter("stuClass")));

        List<Student> studentList = studentDao.findAll(student);
        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }

    protected void deleteMoreStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        String result[] = id.split(" ");
        System.out.println(result.length);
        for (int x = 0; x < result.length; x++) {
//            System.out.println(result[x] + "是的");
            studentDao.deleteStudent(Integer.valueOf(result[x]));
        }

        showAll(request, response);
    }

    protected void deleteStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stuId = request.getParameter("stuId");
        int i = studentDao.deleteStudent(Integer.valueOf(stuId));

        showAll(request, response);
    }

    protected void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Student> studentList = studentDao.findAll(new Student());

        request.setAttribute("studentList", studentList);
        request.getRequestDispatcher("student.jsp").forward(request, response);
    }

    protected void addStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        StudentDao studentDao = new StudentDaoImpl();

        String stuSex = request.getParameter("stuSex");
        String stuName = request.getParameter("stuName");
        String stuAdress = request.getParameter("stuAdress");
        String stuClass = request.getParameter("stuClass");


        Student student = new Student(stuName, stuSex, stuAdress, Integer.valueOf(stuClass));
        int i = studentDao.insertStudent(student);
//        System.out.println(i);

        showAll(request, response);
    }

    protected void updateStudent(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String stuId = request.getParameter("stuId");
        String stuSex = request.getParameter("stuSex");
        String stuName = request.getParameter("stuName");
        String stuAdress = request.getParameter("stuAdress");
        String stuClass = request.getParameter("stuClass");

        Student student = new Student(Integer.valueOf(stuId), stuName, stuSex, stuAdress, Integer.valueOf(stuClass));

        int i = studentDao.updateStudent(student);

        showAll(request, response);
    }
}
