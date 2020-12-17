package javasm.dao;

import javasm.entity.Student;

import java.util.List;

public interface StudentDao {

    /**
     * 查询所有学生的数据
     * @return
     */
    List<Student> findAll(Student student);

    /**
     * 插入数据
     * @param student
     * @return
     */
    int insertStudent(Student student);

    /**
     * 根据id修改学生信息
     * @param student
     * @return
     */
    int updateStudent(Student student);

    /**
     * 根据id删除学生信息
     * @param stuId
     * @return
     */
    int deleteStudent(int stuId);


}
