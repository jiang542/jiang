package javasm.dao;

import javasm.entity.ClassInfo;

import java.util.List;

public interface ClassInfoDao {

    /**
     * 查找所有的管理员数据
     * @return
     */
    List<ClassInfo> findAll();

    /**
     * 插入数据
     * @param classInfo
     * @return
     */
    int insertClassInfo(ClassInfo classInfo);

    /**
     * 修改数据
     * @param classInfo
     * @return
     */
    int updateClassInfo(ClassInfo classInfo);

    /**
     * 删除班级数据
     * @param classInfo
     * @return
     */
    int deleteClassInfo(ClassInfo classInfo);
}
