package javasm.dao.impl;

import javasm.dao.ClassInfoDao;
import javasm.entity.ClassInfo;
import javasm.util.JDBCUtils;

import java.util.List;

public class ClassInfoDaoImpl implements ClassInfoDao {
    @Override
    public List<ClassInfo> findAll() {
        String sql = "SELECT * FROM classinfo ;";
        return JDBCUtils.getList(sql, ClassInfo.class);
    }

    @Override
    public int insertClassInfo(ClassInfo classInfo) {
        String sql = "INSERT INTO classinfo(className,classDate,classNote) VALUES(?,?,?);";
        return JDBCUtils.insert(sql, classInfo.getClassName(),classInfo.getClassDate(),classInfo.getClassNote());
    }

    @Override
    public int updateClassInfo(ClassInfo classInfo) {
        String sql = "UPDATE classinfo SET className=?,classDate=?,classNote=? WHERE classId = '405';";
        return JDBCUtils.update(sql, classInfo.getClassName(),classInfo.getClassDate(),classInfo.getClassNote());
    }

    @Override
    public int deleteClassInfo(ClassInfo classInfo) {
        String sql = "DELETE FROM classinfo WHERE classinfo.classId = ?;";
        return JDBCUtils.delete(sql, classInfo.getClassId());
    }
}
