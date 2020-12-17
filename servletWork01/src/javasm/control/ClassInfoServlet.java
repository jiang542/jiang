package javasm.control;

import javasm.dao.ClassInfoDao;
import javasm.dao.impl.ClassInfoDaoImpl;
import javasm.entity.ClassInfo;
import javasm.entity.Student;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/classInfoServlet")
public class ClassInfoServlet extends HttpServlet {
    private ClassInfoDao classInfoDao = new ClassInfoDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        String way = request.getParameter("way");
        switch (way) {
            case "showAll":
                //显示所有班级数据在student.jsp上
                showAll(request, response);
                break;
            case "addClassInfo":
                //添加班级数据-student.jsp
                addClassInfo(request, response);
                break;
            case "updateClassInfo":
                //修改班级数据-student.jsp
                updateClassInfo(request, response);
                break;
            case "deleteClassInfo":
                //删除班级数据-student.jsp
                deleteClassInfo(request, response);
                break;
            case "deleteMoreClass":
                //删除班级数据-student.jsp
                deleteMoreClass(request, response);
                break;
            default:
                break;
        }
    }

    protected void deleteMoreClass(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String id = request.getParameter("id");
        String result[] = id.split(" ");
        ClassInfo classInfo = new ClassInfo();
        for (int x = 0; x < result.length; x++) {
            classInfo.setClassId(Integer.valueOf(result[x]));
            classInfoDao.deleteClassInfo(classInfo);
        }

        showAll(request, response);
    }

    protected void deleteClassInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        ClassInfo classInfo = new ClassInfo();
        classInfo.setClassId(Integer.valueOf(request.getParameter("classId").trim()));
        classInfoDao.deleteClassInfo(classInfo);
        showAll(request, response);
    }

    protected void updateClassInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String classId = request.getParameter("classId");
        String className = request.getParameter("className");
        String classDate = request.getParameter("classDate");
        String classNote = request.getParameter("classNote");


        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date dateStart = null;
        try {
            dateStart = formatter.parse(classDate.replace('T', ' '));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        ClassInfo classInfo = new ClassInfo(Integer.valueOf(classId.trim()), className, dateStart, classNote);

        int i = classInfoDao.updateClassInfo(classInfo);
        showAll(request, response);
    }

    protected void addClassInfo(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String className = request.getParameter("className");
        String classDate = request.getParameter("classDate");
        String classNote = request.getParameter("classNote");
        System.out.println(classDate+":"+className+":"+classNote);

        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date dateStart = null;
        try {
            dateStart = formatter.parse(classDate.replace('T', ' '));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        int i = classInfoDao.insertClassInfo(new ClassInfo(className, dateStart, classNote));

        showAll(request, response);
    }

    protected void showAll(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<ClassInfo> classInfoList = classInfoDao.findAll();

        request.setAttribute("classInfoList", classInfoList);
        request.getRequestDispatcher("classinfo.jsp").forward(request, response);
    }
}
