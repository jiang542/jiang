package javasm.util;



import javasm.constant.JDBC;
import org.apache.commons.dbutils.*;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.MapListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JDBCUtils {

    private static Connection conn;

    public static Connection getConn() {
        try {
            // conn.isClosed()：connection对象是否关闭
            if (conn == null || conn.isClosed()) {
                // JDK1.7以及MYSQL5以上可以省略.前提条件是JavaSE应用
                Class.forName(JDBC.DRIVER); //加载驱动
                //获取连接.
                conn = DriverManager.getConnection(JDBC.URL, JDBC.USERNAME, JDBC.PWD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    /**
     * 修改
     *
     * @param sql
     * @param params
     * @return
     */
    public static int update(Connection connection, String sql, Object... params) {
        int count = 0;
        try {
            count = new QueryRunner().update(connection, sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * 插入数据
     *
     * @param sql
     * @param params
     * @return
     */
    public static int insert(Connection connection, String sql, Object... params) {
        int count = 0;
        try {
            count = new QueryRunner().insert(connection, sql, new ScalarHandler<Long>(), params).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }


    /********************************************************************************************/
    /**
     * 获取连接对象
     *
     * @return Connection连接对象
     */
    public static Connection getConnection() {
        Connection connection = null;
        try {
            // JDK1.7以及MYSQL5以上可以省略.前提条件是JavaSE应用
            Class.forName(JDBC.DRIVER); //加载驱动
            //获取连接.
            connection = DriverManager.getConnection(JDBC.URL, JDBC.USERNAME, JDBC.PWD);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return connection;
    }

    /**
     * 删除
     *
     * @param sql
     * @param params
     * @return
     */
    public static int delete(String sql, Object... params) {
        return update(sql, params);
    }

    /**
     * 修改
     *
     * @param sql
     * @param params
     * @return
     */
    public static int update(String sql, Object... params) {
        Connection connection = null;
        int count = 0;
        try {
            connection = getConnection();
            count = new QueryRunner().update(connection, sql, params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    /**
     * 插入数据
     *
     * @param sql
     * @param params
     * @return
     */
    public static int insert(String sql, Object... params) {
        Connection connection = null;
        int count = 0;
        try {
            connection = getConnection();
            count = new QueryRunner().insert(connection, sql, new ScalarHandler<Long>(), params).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    /**
     * 查询条数
     *
     * @param sql
     * @param params
     * @return
     */
    public static int getCount(String sql, Object... params) {
        Connection connection = null;
        int count = 0;
        try {
            connection = getConnection();
            count = new QueryRunner().query(connection, sql, new ScalarHandler<Long>(), params).intValue();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return count;
    }

    /**
     * 查询单个对象
     *
     * @param sql    sql语句
     * @param claz   实体类
     * @param params 参数
     * @param <T>
     * @return
     */
    public static <T> T get(String sql, Class<T> claz, Object... params) {
        Connection connection = null;
        T t = null;
        try {
            connection = getConnection();
            RowProcessor rowProcessor = new BasicRowProcessor(new GenerousBeanProcessor());
            t = new QueryRunner().query(connection, sql, new BeanHandler<>(claz, rowProcessor), params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return t;
    }


    /**
     * 查询一个类包装的list
     *
     * @param sql    sql语句
     * @param claz   实体类型
     * @param params 参数
     * @param <T>
     * @return
     */
    public static <T> List<T> getList(String sql, Class<T> claz, Object... params) {
        Connection connection = null;
        List<T> list = new ArrayList<>();
        try {
            connection = getConnection();
            QueryRunner queryRunner = new QueryRunner();
            //数据库字段下划线转换成实体类中的首字母大写
            RowProcessor rowProcessor = new BasicRowProcessor(new GenerousBeanProcessor());
            list = queryRunner.query(connection, sql, new BeanListHandler<>(claz, rowProcessor), params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return list;
    }

    /**
     * 查询返回list的map结构
     *
     * @param sql
     * @param params
     * @return
     */
    public static List<Map<String, Object>> getListMap(String sql, Object... params) {
        Connection connection = null;
        List<Map<String, Object>> map = new ArrayList<>();
        try {
            connection = getConnection();
            QueryRunner queryRunner = new QueryRunner();
            map = queryRunner.query(connection, sql, new MapListHandler(), params);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DbUtils.close(connection);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return map;
    }

}
