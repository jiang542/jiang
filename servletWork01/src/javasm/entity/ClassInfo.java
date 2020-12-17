package javasm.entity;

import java.util.Date;
import java.util.Objects;

/**
 * 班级信息表
 */
public class ClassInfo {
    private Integer classId;//班级编号
    private String className;//班级名称
    private Date classDate;//班级创建时间
    private String classNote;//班级备注

    public ClassInfo(Integer classId, String className, Date classDate, String classNote) {
        this.classId = classId;
        this.className = className;
        this.classDate = classDate;
        this.classNote = classNote;
    }

    public ClassInfo(String className, Date classDate, String classNote) {
        this.className = className;
        this.classDate = classDate;
        this.classNote = classNote;
    }

    public ClassInfo() {
    }

    public Integer getClassId() {
        return classId;
    }

    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Date getClassDate() {
        return classDate;
    }

    public void setClassDate(Date classDate) {
        this.classDate = classDate;
    }

    public String getClassNote() {
        return classNote;
    }

    public void setClassNote(String classNote) {
        this.classNote = classNote;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassInfo classInfo = (ClassInfo) o;
        return Objects.equals(classId, classInfo.classId) &&
                Objects.equals(className, classInfo.className) &&
                Objects.equals(classDate, classInfo.classDate) &&
                Objects.equals(classNote, classInfo.classNote);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classId, className, classDate, classNote);
    }

    @Override
    public String toString() {
        return "ClassInfo{" +
                "classId=" + classId +
                ", className='" + className + '\'' +
                ", classDate=" + classDate +
                ", classNote='" + classNote + '\'' +
                '}';
    }
}
