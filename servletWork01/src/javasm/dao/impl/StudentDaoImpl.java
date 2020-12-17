package javasm.dao.impl;

import javasm.dao.StudentDao;
import javasm.entity.Student;
import javasm.util.JDBCUtils;

import java.util.List;

public class StudentDaoImpl implements StudentDao {
    @Override
    public List<Student> findAll(Student student) {
        String sql = "SELECT * FROM student where 1=1 ";
        if (student!=null){
            if (student.getStuClass()!=null){
                sql+=" and stuClass='"+student.getStuClass()+"'";
            }
        }
        return JDBCUtils.getList(sql, Student.class);
    }

    @Override
    public int insertStudent(Student student) {
        String sql = "INSERT INTO student(stuName,stuSex,stuAdress,stuClass) VALUES(?,?,?,?);";
        return JDBCUtils.insert(sql, student.getStuName(),student.getStuSex(),student.getStuAdress(),student.getStuClass());
    }

    @Override
    public int updateStudent(Student student) {
        String sql = "UPDATE student SET stuName=?,stuSex=?,stuAdress=?,stuClass=? WHERE stuId = ?;";
        return JDBCUtils.update(sql, student.getStuName(),student.getStuSex(),student.getStuAdress(),student.getStuClass(),student.getStuId());
    }

    @Override
    public int deleteStudent(int stuId) {
        String sql = "DELETE FROM student WHERE student.stuId = ?;";
        return JDBCUtils.delete(sql, stuId);
    }
}
