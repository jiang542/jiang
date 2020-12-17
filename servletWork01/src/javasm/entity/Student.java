package javasm.entity;

import java.util.Objects;

/**
 * 学生信息表
 */
public class Student {
    private Integer stuId;//学生编号
    private String stuName;//学生标题
    private String stuSex;//学生性别
    private String stuAdress;//学生住址
    private Integer stuClass;//学生所在班级(主键ID)

    public Student(Integer stuId, String stuName, String stuSex, String stuAdress, Integer stuClass) {
        this.stuId = stuId;
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuAdress = stuAdress;
        this.stuClass = stuClass;
    }

    public Student(String stuName, String stuSex, String stuAdress, Integer stuClass) {
        this.stuName = stuName;
        this.stuSex = stuSex;
        this.stuAdress = stuAdress;
        this.stuClass = stuClass;
    }

    public Student() {
    }

    public Integer getStuId() {
        return stuId;
    }

    public void setStuId(Integer stuId) {
        this.stuId = stuId;
    }

    public String getStuName() {
        return stuName;
    }

    public void setStuName(String stuName) {
        this.stuName = stuName;
    }

    public String getStuSex() {
        return stuSex;
    }

    public void setStuSex(String stuSex) {
        this.stuSex = stuSex;
    }

    public String getStuAdress() {
        return stuAdress;
    }

    public void setStuAdress(String stuAdress) {
        this.stuAdress = stuAdress;
    }

    public Integer getStuClass() {
        return stuClass;
    }

    public void setStuClass(Integer stuClass) {
        this.stuClass = stuClass;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(stuId, student.stuId) &&
                Objects.equals(stuName, student.stuName) &&
                Objects.equals(stuSex, student.stuSex) &&
                Objects.equals(stuAdress, student.stuAdress) &&
                Objects.equals(stuClass, student.stuClass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stuId, stuName, stuSex, stuAdress, stuClass);
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuId=" + stuId +
                ", stuName='" + stuName + '\'' +
                ", stuSex='" + stuSex + '\'' +
                ", stuAdress='" + stuAdress + '\'' +
                ", stuClass=" + stuClass +
                '}';
    }
}
